<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="player.AuthService"%>
<%@page import="player.LoggedPlayer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="player.PlayerService"%>

<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    //Usuario de la base de datos
    String dbuser = "MiguelFalcon";
    //Contraseña de la base de datos
    String dbpassword = "12345678";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/unogame", dbuser, dbpassword);
    Connection connection = pool.getConnection();
    AuthService auth = new AuthService(pool.getConnection());
    LoggedPlayer player = (LoggedPlayer)session.getAttribute("player");
    PlayerService playerSvc = new PlayerService(pool.getConnection());
    ArrayList<LoggedPlayer> playerArray = null;
    playerArray = playerSvc.requestAll("id ASC");

    int ganador = -1;
    if(request.getParameter("ganador")!=null && request.getParameter("ganador").length() > 0){
        ganador = Integer.parseInt(request.getParameter("ganador"));
    }

    long id = player.getId();
    String name = "";
    String surname = "";
    String nametag = "";
    String password = "";
    long win = 0;
    long lost = 0;

    for(LoggedPlayer playerAr : playerArray){
        if(playerAr.getId() == id){
            name = playerAr.getName();
            surname = playerAr.getSurname();
            nametag = playerAr.getNametag();
            password = playerAr.getPassword();
            win = playerAr.getWin();
            lost = playerAr.getLost();
        }
    }

    if(ganador==1){ // Se suma una victoria
        win = win + 1;
    }else if(ganador==2){ // Se suma una derrota
        lost = lost + 1;
    }else if(ganador==3){ // Se queda igual
    }

    LoggedPlayer newPlayerData = new LoggedPlayer(player.getId(),name, surname, nametag, player.getPassword(), win, lost);
    if(auth.updateEnd(newPlayerData)==1){
        session.setAttribute("player",newPlayerData);
        response.sendRedirect("home.jsp");
    }else{
        response.sendRedirect("login.jsp?error=No ha sido posible cambiar la inforamción");
    }

%>