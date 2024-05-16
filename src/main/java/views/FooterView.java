package views;

import player.LoggedPlayer;

public class FooterView {
    LoggedPlayer player = null;

    public FooterView(LoggedPlayer player){
        this.player = player;
    }

    @Override
    public String toString() {
        return 
        "<footer class=\"bg-light text-center text-lg-start\">"+
        "    <div class=\"text-center p-3\" style=\"background-color: rgba(0, 0, 0, 0.2);\">"+
        "        © 2024 Derechos Reservados: <a class=\"text-dark\" href=\"#\">Usuarios.com</a>"+
        "    </div>"+
        "</footer>";
    }
}
