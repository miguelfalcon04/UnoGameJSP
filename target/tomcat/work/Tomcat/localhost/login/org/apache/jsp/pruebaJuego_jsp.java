/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-05-15 19:05:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import juego.Carta;
import juego.Mazo;
import juego.CartaTemplate;
import player.LoggedPlayer;
import java.util.ArrayList;
import java.lang.Thread;

public final class pruebaJuego_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>UnoGame</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/juego.css\" type=\"text/css\">\r\n");
      out.write("            <!-- Enlace a Bootstrap CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    ");
 
    boolean newGame = Boolean.parseBoolean(request.getParameter("newGame")); // Booleano que resetea partida

    if (newGame){
        session.removeAttribute("mazo");
        session.removeAttribute("playerCards");
        session.removeAttribute("botCards");
        session.removeAttribute("jugando");
        session.removeAttribute("fase");
    }

    int fase = 1;
    if(request.getParameter("fase")!=null && request.getParameter("fase").length() > 0){
        fase = Integer.parseInt(request.getParameter("fase"));
    }

    LoggedPlayer player = (LoggedPlayer)session.getAttribute("player");
    if(player==null){
    response.sendRedirect("login.jsp");
    }

    Mazo mazo = (Mazo) session.getAttribute("mazo");
    if(mazo == null){
        mazo = new Mazo();
        session.setAttribute("mazo", mazo);
    }

    ArrayList<Carta> playerCards = (ArrayList<Carta>) session.getAttribute("playerCards");
    if(playerCards == null){
        playerCards = new ArrayList<Carta>();
        for(int i=0; i<3; i++){
            playerCards.add(mazo.extrae());
            session.setAttribute("playerCards", playerCards);
        }
    }

    ArrayList<Carta> botCards = (ArrayList<Carta>) session.getAttribute("botCards");
    if(botCards == null){
        botCards = new ArrayList<Carta>();
        for(int i=0; i<3; i++){
            botCards.add(mazo.extrae());
            session.setAttribute("botCards", botCards);
        }
    }

    ArrayList<Carta> jugando = (ArrayList<Carta>) session.getAttribute("jugando");
    if(jugando == null){
        jugando = new ArrayList<Carta>();
        jugando.add(mazo.extrae());
        session.setAttribute("jugando", jugando);
    }

    if(fase==1){ // Turno del jugador 
        boolean roba = Boolean.parseBoolean(request.getParameter("roba"));
        if(roba){
            if(playerCards.size()<=6){
                ArrayList<Carta> mazoArray = mazo.getCartas();
                if(mazoArray.size()>0){
                    playerCards.add(mazo.extrae());
                }
            }
        }

        boolean lanza = Boolean.parseBoolean(request.getParameter("lanza"));
        int cardId = -1;
        int posicionArray = -1;
        if(request.getParameter("posicionArray")!=null && request.getParameter("posicionArray").length() > 0){
            posicionArray = Integer.parseInt(request.getParameter("posicionArray"));
        }
        if(request.getParameter("cardId")!=null && request.getParameter("cardId").length() > 0){
            cardId = Integer.parseInt(request.getParameter("cardId"));
        }
        Carta cardPlayer = new Carta(cardId);
        int miCartaInt = cardPlayer.getNumeroAsInt();
        String miCartaColor = cardPlayer.getColores();

        Carta cartaEnMesa = jugando.get(jugando.size()-1);
        int cartaEnMesaInt = cartaEnMesa.getNumeroAsInt(); 
        String cartaEnMesaColor = cartaEnMesa.getColores();

        if(lanza) {
            if(miCartaInt == cartaEnMesaInt || miCartaColor == cartaEnMesaColor){
                Carta cartaMovida = playerCards.remove(posicionArray);
                jugando.add(cartaMovida);
            }
        }
    }

    if(playerCards.size()==0){ // Suma una win 
        response.sendRedirect("doFinalJuego.jsp?ganador=1");
    }else if(botCards.size()==0){ // Suma un lost
        response.sendRedirect("doFinalJuego.jsp?ganador=2");
    }else if(playerCards.size()==7 && botCards.size()==7){ // Se queda igual
        response.sendRedirect("doFinalJuego.jsp?ganador=3");
    }

    
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"salir\">\r\n");
      out.write("            <a href=\"home.jsp\" class=\"btn btn-secondary\">Salir</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"cartas\"> <!-- Cartas del Bot Reversas -->\r\n");
      out.write("            ");

                Carta cartaEnMesaJug = jugando.get(jugando.size()-1);
                int cartaEnMesaInt = cartaEnMesaJug.getNumeroAsInt(); 
                String cartaEnMesaColor = cartaEnMesaJug.getColores();
                int posicionArrayBot = -1;
                boolean haLanzado = false;

                for(Carta carta : botCards){
                    posicionArrayBot++;
                    Carta cardBot = new Carta(carta.getId());
                    int botCartaInt = cardBot.getNumeroAsInt();
                    String botCartaColor = cardBot.getColores();

                    if(botCartaInt == cartaEnMesaInt || botCartaColor == cartaEnMesaColor){
                        Carta cartaMovida = botCards.remove(posicionArrayBot);
                        jugando.add(cartaMovida);
                        haLanzado = true;
                        break;
                    }
                }

                if(haLanzado==false && botCards.size()<=6){
                    ArrayList<Carta> mazoArray = mazo.getCartas();
                    if(mazoArray.size()>0){
                        botCards.add(mazo.extrae());
                    }
                }

                if(botCards.size()>0){
                    for(Carta cartas : botCards) {
                        out.print(new CartaTemplate(cartas,2));
                    }
                }else{
                    out.print("<div class=\"carta\" style=\"height: 250px;\"></div>");
                }
            
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"cartas\"> <!-- Mazo En la mesa -->\r\n");
      out.write("            ");

            Carta cartaEnMesa = jugando.get(jugando.size()-1);
            out.print(new CartaTemplate(cartaEnMesa,1));
            
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");

            ArrayList<Carta> cartasEnMazo = mazo.getCartas();
            for(Carta carta : cartasEnMazo) {
                out.print(new CartaTemplate(carta, 3));
            }
            
      out.write("\r\n");
      out.write("            <form action=\"pruebaJuego.jsp\" method=\"post\" class=\"formularioRobar\">\r\n");
      out.write("                <input type=\"hidden\" name=\"roba\" value=true>\r\n");
      out.write("                <input type=\"submit\" value=\"Robar\">\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"cartas\"> <!-- Cartas del jugador -->\r\n");
      out.write("            ");
 int posicionArray = -1; 
      out.write("\r\n");
      out.write("            ");
 if(playerCards.size()>0){
      out.write(" \r\n");
      out.write("                    ");
 for(Carta carta : playerCards) { 
      out.write("\r\n");
      out.write("                    <div class=\"carta\">\r\n");
      out.write("                        ");
      out.print( new CartaTemplate(carta, 1) );
      out.write("\r\n");
      out.write("                        ");
 posicionArray++; 
      out.write("\r\n");
      out.write("                        <form action=\"pruebaJuego.jsp\" method=\"post\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"cardId\" value=\"");
      out.print( carta.getId() );
      out.write("\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"posicionArray\" value=\"");
      out.print( posicionArray );
      out.write("\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"lanza\" value=true>\r\n");
      out.write("                            <input type=\"hidden\" name=\"fase\" value=\"");
      out.print( 1 );
      out.write("\">\r\n");
      out.write("                            <input type=\"submit\" value=\"Lanzar\">\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap JavaScript y dependencias -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
