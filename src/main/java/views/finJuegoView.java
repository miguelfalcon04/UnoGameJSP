package views;

import player.LoggedPlayer;

public class finJuegoView {
    LoggedPlayer player = null;
    private int opc;

    public finJuegoView(LoggedPlayer player, int opc){
        this.player = player;
        this.opc = opc;
    }

    @Override
    public String toString() {
        String html = "";
        if (opc == 1) {
                html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n"+
                    "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>\n" +
                    "<style>\n" +
                    "body { display: flex; justify-content: center; align-items: center; height: 100vh; }\n" +
                    ".container { text-align: center; }\n" +
                    ".button-group { display: flex; justify-content: center; gap: 10px; }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class='container'>\n" +
                    "<h1>Felicidades, has ganado</h1>\n" +
                    "<div class='button-group'>\n" +
                    "<form action='juego.jsp' method='get'>\n" +
                    "<input type='hidden' name='newGame' value='true'>\n" +
                    "<button type='submit' class='btn btn-primary'>Volver a jugar</button>\n" +
                    "</form>\n" +
                    "<form action='home.jsp' method='get'>\n" +
                    "<button type='submit' class='btn btn-secondary'>Volver al Inicio</button>\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        } else if (opc == 2) {
                html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n"+
                    "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>\n" +
                    "<style>\n" +
                    "body { display: flex; justify-content: center; align-items: center; height: 100vh; }\n" +
                    ".container { text-align: center; }\n" +
                    ".button-group { display: flex; justify-content: center; gap: 10px; }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class='container'>\n" +
                    "<h1>Lo siento, has perdido</h1>\n" +
                    "<div class='button-group'>\n" +
                    "<form action='juego.jsp' method='get'>\n" +
                    "<input type='hidden' name='newGame' value='true'>\n" +
                    "<button type='submit' class='btn btn-primary'>Volver a jugar</button>\n" +
                    "</form>\n" +
                    "<form action='home.jsp' method='get'>\n" +
                    "<button type='submit' class='btn btn-secondary'>Volver al Inicio</button>\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        } else {
                html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "<link rel=\"stylesheet\" href=\"assets/css/style.css\">\n"+
                    "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>\n" +
                    "<style>\n" +
                    "body { display: flex; justify-content: center; align-items: center; height: 100vh; }\n" +
                    ".container { text-align: center; }\n" +
                    ".button-group { display: flex; justify-content: center; gap: 10px; }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class='container'>\n" +
                    "<h1>Nadie ha ganado</h1>\n" +
                    "<div class='button-group'>\n" +
                    "<form action='juego.jsp' method='get'>\n" +
                    "<input type='hidden' name='newGame' value='true'>\n" +
                    "<button type='submit' class='btn btn-primary'>Volver a jugar</button>\n" +
                    "</form>\n" +
                    "<form action='home.jsp' method='get'>\n" +
                    "<button type='submit' class='btn btn-secondary'>Volver al Inicio</button>\n" +
                    "</form>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>";
        }
        return html;
    }
}
