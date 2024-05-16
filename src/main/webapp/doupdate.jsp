<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="player.AuthService"%>
<%@page import="player.LoggedPlayer"%>
    <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    //Usuario de la base de datos
    String dbuser = "MiguelFalcon";
    //Contraseña de la base de datos
    String dbpassword = "12345678";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/unogame", dbuser, dbpassword);
    AuthService auth = new AuthService(pool.getConnection());
    String nametag = request.getParameter("nametag");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String password = request.getParameter("password");
    LoggedPlayer player = (LoggedPlayer)session.getAttribute("player");
    LoggedPlayer newPlayerData = new LoggedPlayer(player.getId(),name,surname,nametag,password);
    if(auth.update(newPlayerData)==1){
        session.setAttribute("player",newPlayerData);
        response.sendRedirect("home.jsp");
    }else{
        response.sendRedirect("login.jsp?error=No ha sido posible cambiar la inforamción");
    }
    %>
