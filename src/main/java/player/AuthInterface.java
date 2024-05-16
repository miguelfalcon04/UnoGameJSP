package player;

import java.sql.SQLException;

public interface AuthInterface {
    public LoggedPlayer login(String nametag, String password) throws SQLException;
    public LoggedPlayer register(String nametag, String name, String surname, String password) throws SQLException;
    public int update(LoggedPlayer player) throws SQLException;
    public int updateEnd(LoggedPlayer player) throws SQLException;
}
