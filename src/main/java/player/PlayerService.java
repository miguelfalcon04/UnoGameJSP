package player;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import crud.CRUD;

public class PlayerService implements CRUD<LoggedPlayer> {

    Connection conn;

    public PlayerService(Connection conn){
        this.conn = conn;
    }

    @Override
    public ArrayList<LoggedPlayer> query(String column, String value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    @Override
    public ArrayList<LoggedPlayer> query(String column, long value) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'query'");
    }

    private ArrayList<LoggedPlayer> _requestAll(String sql) throws SQLException{
        //Creamos el array que vamos a devolver
        ArrayList<LoggedPlayer> result = new ArrayList<LoggedPlayer>();
        //Construimos la consulta a realizar
        Statement statement = this.conn.createStatement();   

        // Ejectuamos la consulta
        ResultSet querySet = statement.executeQuery(sql);
        // Recorremos cada uno de los registro devueltos por la consulta
        while(querySet.next()) {
            //Obtenemos los datos del Individuo
            int id = querySet.getInt("id");
            String name = querySet.getString("name");
            String surname = querySet.getString("surname");
            String nametag = querySet.getString("nametag");
            long wingames = querySet.getLong("wingames");
            long lostgames = querySet.getLong("lostgames");
        
            result.add(new LoggedPlayer(id, name, surname, nametag, wingames, lostgames));
        } 
        //Cerramos la consulta
        statement.close();

        //Devolvemos el array de individuoes
        return result;
    }

    private ArrayList<LoggedPlayer> _requestAllEnd(String sql) throws SQLException{
        //Creamos el array que vamos a devolver
        ArrayList<LoggedPlayer> result = new ArrayList<LoggedPlayer>();
        //Construimos la consulta a realizar
        Statement statement = this.conn.createStatement();   
        // Ejectuamos la consulta
        ResultSet querySet = statement.executeQuery(sql);
        // Recorremos cada uno de los registro devueltos por la consulta
        while(querySet.next()) {
            //Obtenemos los datos del Individuo
            int id = querySet.getInt("id");
            String name = querySet.getString("name");
            String surname = querySet.getString("surname");
            String nametag = querySet.getString("nametag");
            String password = querySet.getString("password");

            long wingames = querySet.getLong("wingames");
            long lostgames = querySet.getLong("lostgames");
        
            result.add(new LoggedPlayer(id, name, surname, nametag, password, wingames, lostgames));
        } 
        //Cerramos la consulta
        statement.close();

        //Devolvemos el array de individuoes
        return result;
    }

    @Override
    public ArrayList<LoggedPlayer> requestAll(String sortedBy) throws SQLException {
        String sql = "SELECT id, name, surname, nametag, wingames, lostgames FROM player"+(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAll(sql);
    }

    @Override
    public ArrayList<LoggedPlayer> requestAllEnd(String sortedBy) throws SQLException {
        String sql = "SELECT id, name, surname, nametag, password, wingames, lostgames FROM player" +(sortedBy.length()>0?(" ORDER BY "+sortedBy):"");
        return this._requestAllEnd(sql);
    }

    @Override
    public LoggedPlayer requestById(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestById'");
    }

    @Override
    public long create(LoggedPlayer model) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public int update(LoggedPlayer object) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
