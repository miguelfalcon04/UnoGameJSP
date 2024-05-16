package views;

import player.LoggedPlayer;

public class MenuView {
    LoggedPlayer player = null;

    public MenuView(LoggedPlayer player){
        this.player = player;
    }

    @Override
    public String toString() {
        return 
        "<div class=\"menu-lateral\">"+
        "   <ul class=\"nav flex-column text-white\">"+
        "       <li class=\"nav-item\">"+
        "           <a class=\"nav-link text-white ml-2\" href=\"home.jsp\">Inicio</a>"+
        "       </li>"+
        "       <li class=\"nav-item\">"+
        "           <a class=\"nav-link text-white ml-2\" href=\"clasificacion.jsp\">Clasificaciones</a>"+
        "       </li>"+
        "       <li class=\"nav-item\">"+
        "           <a class=\"nav-link text-white ml-2\" href=\"update.jsp\">Actualiza</a>"+
        "       </li>"+
        "       <li class=\"nav-item\">"+
        "           <a class=\"nav-link text-white ml-2\" href=\"logout.jsp\">Cerrar sesión</a>"+
        "       </li>"+
        "   </ul>"+
        "</div>";
    }
}
