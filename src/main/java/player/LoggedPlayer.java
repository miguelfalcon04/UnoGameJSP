package player;

public class LoggedPlayer {
    private long id, win, lost;
    private String name;
    private String surname;
    private String nametag;
    private String password;



    public LoggedPlayer(long id, String name, String surname, String nametag, String password, long win, long lost){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nametag = nametag;
        this.password = password;
        this.win = win;
        this.lost = lost;
    }

    public LoggedPlayer(long id, String name, String surname, String nametag, long win, long lost ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nametag = nametag;
        this.win = win;
        this.lost = lost;
    }

    public LoggedPlayer(long id, String name, String surname, String nametag ){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nametag = nametag;
    }

    public LoggedPlayer(long id, String name, String surname, String nametag, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nametag = nametag;
        this.password = password;
    }

    public LoggedPlayer(long id, long win, long lost){
        this.id = id;
        this.win = win;
        this.lost = lost;
    }


    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNametag() {
        return nametag;
    }

    public String getPassword() {
        return password;
    }

    public long getWin() {
        return win;
    }

    public long getLost() {
        return lost;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)",getName(), getSurname(), getNametag());
    }
    
}
