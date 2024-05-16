package views;

import java.util.ArrayList;
import player.LoggedPlayer;

public class HomeView {
    LoggedPlayer player = null;
    ArrayList<LoggedPlayer> playerArray = null;

    private int opc;

    public HomeView(LoggedPlayer player, int opc){
        this.player = player;
        this.opc = opc;
    }

    public HomeView(ArrayList<LoggedPlayer> playerArray, LoggedPlayer player, int opc){
        this.player = player;
        this.playerArray = playerArray;
        this.opc = opc;
    }

    @Override
    public String toString() {
        if(opc==2){
            return 
            "<div class=\"min-vh-100 d-flex flex-column\">"+
                (new HeaderView(player))+
            "   <div class=\"flex-grow-wrapper\">"+
            "       <div class=\"row\">"+
                    (new MenuView(player))+
                    (new MainView(playerArray, opc))+
            "       </div>"+
            "   </div>"+
                /*(new FooterView(player))+*/
            "</div>";
        }else{
            return 
            "<div class=\"min-vh-100 d-flex flex-column\">"+
                (new HeaderView(player))+
            "   <div class=\"flex-grow-wrapper\">"+
            "       <div class=\"row\">"+
                    (new MenuView(player))+
                    (new MainView(player, opc))+
            "       </div>"+
            "   </div>"+
                /*(new FooterView(player))+*/
            "</div>";
        }
    }

}
