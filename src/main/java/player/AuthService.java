package player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthService implements AuthInterface{
    Connection conn = null;

    public AuthService(Connection conn){
        this.conn = conn;
    }

    @Override 
    public LoggedPlayer login(String nametag, String password) throws SQLException{
        //Varible conteniendo el Individuo a devolver
        LoggedPlayer result = null;
        //Construimos la consulta a realizar
        Statement statement = this.conn.createStatement();    
        String sql = String.format("SELECT id, name, surname FROM player WHERE nametag='%s' AND password='%s'", nametag, password);
        // Ejecución de la consulta
        ResultSet querySet = statement.executeQuery(sql);
        // Recorrido del resultado de la consulta
        if(querySet.next()) {
            //Obtenemos los datos del Individuo
            long id = querySet.getLong("id");
            String name = querySet.getString("name");
            String surname = querySet.getString("surname");

            result = new LoggedPlayer(id, name, surname, nametag);
        }
        //Cerramos la consulta
        statement.close();    
        //Devolvemos el individuo
        return result;
    }

    @Override
    public LoggedPlayer register(String nametag, String name, String surname, String password) throws SQLException {
        Statement statement = this.conn.createStatement();    
        String sql = String.format("INSERT INTO player (name, surname, nametag, password) VALUES ('%s', '%s', '%s', '%s')",name, surname, nametag, password);
        // Ejecución de la consulta
        int affectedRows = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        if (affectedRows == 0) {
            // Devolvemos una excepción si no se ha creado el individuo
            throw new SQLException("Creating LoggedPlayer failed, no rows affected.");
        }

        //Aquí llegaremos si se ha creado satisfactoriamente el individuo
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                //Devolvemos el identificador del individuo creado
                long id = generatedKeys.getLong(1);
                statement.close();
                return new LoggedPlayer(id, name, surname, nametag, password, 0, 0 );
            }
            else {
                //Aquí detectamos que hemos perdido conexión con el servidor de la
                //base de datos y devolvemos una excepción
                statement.close();
                throw new SQLException("Creating LoggedPlayer failed, no ID obtained.");
            }
        }
    }

    @Override
    public int update(LoggedPlayer player) throws SQLException {
        long id = player.getId();
        String name = player.getName();
        String surname = player.getSurname();
        String nametag = player.getNametag();
        String password = player.getPassword();
        Statement statement = this.conn.createStatement();
        String sql = String.format("UPDATE player SET name= '%s',surname= '%s', nametag= '%s', password= '%s' WHERE id=%d", name, surname, nametag, password, id);
        int affectedRow = statement.executeUpdate(sql);
        statement.close();
        if(affectedRow==0){
            throw new SQLException("Error al modificar los datos");
        }else{
            return affectedRow;
        }
    }

    @Override
    public int updateEnd(LoggedPlayer player) throws SQLException {
        long id = player.getId();
        String name = player.getName();
        String surname = player.getSurname();
        String nametag = player.getNametag();
        String password = player.getPassword();
        long win = player.getWin();
        long lost = player.getLost();
        Statement statement = this.conn.createStatement();
        String sql = String.format("UPDATE player SET name= '%s',surname= '%s', nametag= '%s', password= '%s', wingames=%d, lostgames=%d WHERE id=%d", name, surname, nametag, password ,win,lost, id);
        int affectedRow = statement.executeUpdate(sql);
        statement.close();
        if(affectedRow==0){
            throw new SQLException("Error al modificar los datos");
        }else{
            return affectedRow;
        }
    }

}
