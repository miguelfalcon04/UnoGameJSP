package views;

import player.LoggedPlayer;

public class UpdateView {
    LoggedPlayer player = null;

    public UpdateView(LoggedPlayer player){
        this.player = player;
    }

    @Override
    public String toString() {
        return
        "<div class=\"col\">"+
        "   <div class=\"container\">" +
        "       <div class=\"row centro-update\">" +
        "           <div class=\"update bg-light mt-4 p-4\">"+
        "               <form action=\"doupdate.jsp\" method=\"POST\" class=\"row g-3\">"+
        "                   <h4>Actualiza Usuario</h4>"+
        "                   <div class=\"col-12\">"+
        "                       <label>Nuevo Nombre</label>"+
        "                       <input type=\"text\" name=\"name\" class=\"form-control\" value="+player.getName()+" placeholder=\"Nombre\" required>"+
        "                   </div>"+

        "                   <div class=\"col-12\">"+
        "                       <label>Nuevos Apellidos</label>"+
        "                       <input type=\"text\" name=\"surname\" class=\"form-control\" value="+player.getSurname()+" placeholder=\"Apellidos\" required>"+
        "                   </div>"+

        "                   <div class=\"col-12\">"+
        "                       <label>Nuevo NameTag</label>"+
        "                       <input type=\"text\" name=\"nametag\" class=\"form-control\" value="+player.getNametag()+" placeholder=\"Usuario\" required>"+
        "                   </div>"+

        "                   <div class=\"col-12\">"+
        "                       <label>Nueva Contraseña</label>"+
        "                       <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Contraseña\" required>"+
        "                   </div>"+

        "                   <div class=\"col-12\">"+
        "                       <label> </label>"+
        "                   </div>"+

        "                   <div class=\"col-12\">" +
        "                       <button type=\"submit\" class=\"btn btn-dark float-end\">Actualizar</button>"+
        "                   </div>"+
        "               </form>"+
        "            </div>"+
        "        </div>"+
        "   </div>"+
        "</div>";
    }
}
