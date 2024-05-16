package views;

public class RegisterView {

    String error = null;
    public RegisterView(){
    }

    public RegisterView(String error){
        this.error = error;
    }


    @Override
    public String toString() {
        return
        "<div class=\"container\">" +
        "   <div class=\"row centro-register\">" +
        "       <div class=\"login-form bg-light mt-4 p-4\">"+
        "           <form action=\"doregistration.jsp\" method=\"POST\" class=\"row g-3\">"+
        "               <h4>Nuevo usuario/a</h4>"+
        "               <div class=\"col-12\">"+
        "                   <label>Nombre</label>"+
        "                   <input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Nombre\" required>"+
        "               </div>"+

        "               <div class=\"col-12\">"+
        "                   <label>Apellidos</label>"+
        "                   <input type=\"text\" name=\"surname\" class=\"form-control\" placeholder=\"Apellidos\" required>"+
        "               </div>"+

        "               <div class=\"col-12\">"+
        "                   <label>Usuario</label>"+
        "                   <input type=\"text\" name=\"nametag\" class=\"form-control\" placeholder=\"Usuario\" required>"+
        "               </div>"+

        "               <div class=\"col-12\">"+
        "                   <label>Contraseña</label>"+
        "                   <input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"Contraseña\" required>"+
        "               </div>"+

        ((error!=null)?"                <h4 class=\"col-12 error\">"+error+"</h4>":"")+
        "               <div class=\"col-12\">" +
        "                   <button type=\"submit\" class=\"btn btn-dark float-end\">Registrarse</button>"+
        "               </div>"+
        "           </form>"+
        "           <hr class=\"mt-4\">"+
        "           <div class=\"col-12\">"+
        "                <p class=\"text-center mb-0\">Quiero hacer <a href=\"login.jsp\">login</a></p>"+
        "           </div>"+
        
        "        </div>"+
        "    </div>"+
        "</div>";
    }
}
