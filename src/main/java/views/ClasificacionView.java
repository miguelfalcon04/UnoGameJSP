package views;

import java.util.ArrayList;

import player.LoggedPlayer;

public class ClasificacionView {
    ArrayList<LoggedPlayer> playerArray = null;

    public ClasificacionView(ArrayList<LoggedPlayer> playerArray){
        this.playerArray = playerArray;
    }


    @Override
    public String toString() {
        String datos = "";
        if(playerArray!=null){
            for(int i = 0; i <playerArray.size(); i++){
                datos+= String.format(
                    "<tr>"+
                    "    <td>%d</td>"+
                    "    <td>%s</td>"+
                    "    <td>%s</td>"+
                    "    <td>%s</td>"+
                    "    <td>%d</td>"+
                    "    <td>%d</td>"+
                    "</tr>"+
                    "\n",
                    playerArray.get(i).getId(),
                    playerArray.get(i).getName(),
                    playerArray.get(i).getSurname(),
                    playerArray.get(i).getNametag(),
                    playerArray.get(i).getWin(),
                    playerArray.get(i).getLost());
            }
        }
        return 
        "<div class=\"col\">"+
            "<div class=\"clasificacion\">"+
                "<table class=\"table table-striped\" style=\"color:white\">"+
                    "<thead>"+
                        "<tr>"+
                            "<th scope=\"col\">Id</th>"+
                            "<th scope=\"col\">Nombre</th>"+
                            "<th scope=\"col\">Apellidos</th>"+
                            "<th scope=\"col\">Nametag</th>"+
                            "<th scope=\"col\">Victorias</th>"+
                            "<th scope=\"col\">Derrotas</th>"+
                        "</tr>"+
                    "</thead>"+
                    "<tbody>"+
                        datos+
                    "</tbody>"+
                "</table>"+
            "</div>"+
        "</div>";
    }
    
}
