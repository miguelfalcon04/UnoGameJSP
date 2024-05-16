package views;

import player.LoggedPlayer;

public class HeaderView {
    LoggedPlayer player = null;

    public HeaderView(LoggedPlayer player){
        this.player = player;
    }

    @Override
    public String toString() {
        return 
        "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">"+
        "    <a class=\"navbar-brand\" href=\"#\">Usuario</a>"+
        "    <div class=\"collapse navbar-collapse justify-content-end\">"+
        "        <ul class=\"navbar-nav\">"+
        "            <li class=\"nav-item\">"+
        "                <a class=\"nav-link\" href=\"#\">"+player.getNametag()+"</a>"+
        "            </li>"+
        "       </ul>"+
        "    </div>"+
        "</nav>";
    }
}
