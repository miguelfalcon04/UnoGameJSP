package views;

import java.util.ArrayList;
import player.LoggedPlayer;

public class MainView {
    LoggedPlayer player = null;
    ArrayList<LoggedPlayer> playerArray = null;

    private int opc;

    public MainView(LoggedPlayer player, int opc){
        this.player = player;
        this.opc = opc;
    }

    public MainView(ArrayList<LoggedPlayer> playerArray, int opc){
        this.playerArray = playerArray;
        this.opc = opc;
    }

    @Override
    public String toString() {
        if(opc==2){
            return new ClasificacionView(playerArray).toString();
        }else if(opc==3){
            return new UpdateView(player).toString();
        }else{
            return new InicioView(player).toString();
        }

    }
}
