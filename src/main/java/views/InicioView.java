package views;

import player.LoggedPlayer;

public class InicioView {
    LoggedPlayer player = null;
    
    public InicioView(LoggedPlayer player){
        this.player = player;
    }

    @Override
    public String toString() {
        return 
        "<div class=\"col\">"+
        "   <div class=\"container\">"+
        "       <div class=\"row\">"+
        "           <div class=\"rules\">"+
        "               <h4>Como jugar al UNO</h4>"+
        "               <div class=\"col-12\">"+
        "                   <ul class=\"list-group\">"+
        "                   <li class=\"list-group-item list-group-item-danger\">1. Se baraja el mazo y se reparten 3 cartas a cada jugador</li>"+
        "                   <li class=\"list-group-item list-group-item-danger\">2. Las cartas sobrantes se colocan boca abajo como mazo de robar</li>"+
        "                   <li class=\"list-group-item list-group-item-danger\">3. Para lanzar carta debe ser del mismo color o número</li>"+
        "                   <li class=\"list-group-item list-group-item-danger\">4. Si no puedes lanzar carta robas una (Máximo 7 cartas en mano)</li>"+
        "                   <li class=\"list-group-item list-group-item-danger\">5. Quien se quede sin cartas gana</li>"+
        "                   <li class=\"list-group-item list-group-item-danger\">6. En caso de empate nadie gana</li>"+
        "                   </ul>"+
        "               </div>"+
        "               <br>"+
        "               <form action=\"juego.jsp\" method=\"POST\" class=\"row g-3\">"+
        "                   <div class=\"col-12\">"+
        "                       <input type=\"hidden\" id=\"newGame\" name=\"newGame\" value=\"true\">"+
        "                       <input type=\"hidden\" id=\"fase\" name=\"fase\" value =" + 1 + ">"+
        "                       <button type=\"submit\" class=\"btn btn-dark float-end\">Juguemos</button>"+
        "                   </div>"+
        "               </form>"+
        "           </div>"+
        "       </div>"+
        "   </div>"+
        "</div>";
    }

}
