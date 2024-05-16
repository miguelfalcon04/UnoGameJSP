<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="juego.Carta" %>
<%@ page import="juego.Mazo" %>
<%@ page import="juego.CartaTemplate" %>
<%@ page import="player.LoggedPlayer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.lang.Thread" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UnoGame</title>
        <link rel="stylesheet" href="assets/css/juego.css" type="text/css">
            <!-- Enlace a Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
<body>

    <% 
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

    %>


    <div class="container">
        <div class="salir">
            <a href="home.jsp" class="btn btn-secondary">Salir</a>
        </div>

        <div class="cartas"> <!-- Cartas del Bot Reversas -->
            <%
                Carta cartaEnMesaJug = jugando.get(jugando.size()-1);
                int cartaEnMesaInt = cartaEnMesaJug.getNumeroAsInt(); 
                String cartaEnMesaColor = cartaEnMesaJug.getColores();
                int posicionArrayBot = -1;
                boolean haLanzado = false;

                if(!newGame){
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
                }

                if(botCards.size()>0){
                    for(Carta cartas : botCards) {
                        out.print(new CartaTemplate(cartas,2));
                    }
                }else{
                    out.print("<div class=\"carta\" style=\"height: 250px;\"></div>");
                }
            %>
        </div>

        <div class="cartas"> <!-- Mazo En la mesa -->
            <%
            Carta cartaEnMesa = jugando.get(jugando.size()-1);
            out.print(new CartaTemplate(cartaEnMesa,1));
            %>

            <%
            ArrayList<Carta> cartasEnMazo = mazo.getCartas();
            for(Carta carta : cartasEnMazo) {
                out.print(new CartaTemplate(carta, 3));
            }
            %>
            <form action="juego.jsp" method="post" class="formularioRobar">
                <input type="hidden" name="roba" value=true>
                <input type="submit" value="Robar">
            </form>

        </div>

        <div class="cartas"> <!-- Cartas del jugador -->
            <% int posicionArray = -1; %>
            <% if(playerCards.size()>0){%> 
                    <% for(Carta carta : playerCards) { %>
                    <div class="carta">
                        <%= new CartaTemplate(carta, 1) %>
                        <% posicionArray++; %>
                        <form action="juego.jsp" method="post">
                            <input type="hidden" name="cardId" value="<%= carta.getId() %>">
                            <input type="hidden" name="posicionArray" value="<%= posicionArray %>">
                            <input type="hidden" name="lanza" value=true>
                            <input type="hidden" name="fase" value="<%= 1 %>">
                            <input type="submit" value="Lanzar">
                        </form>
                    </div>
                <% } %>
            <% } %>
        </div>

    </div>

    <!-- Bootstrap JavaScript y dependencias -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>