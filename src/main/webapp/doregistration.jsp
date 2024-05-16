<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="player.AuthService"%>
<%@page import="player.LoggedPlayer"%>
<%
    String nametag = request.getParameter("nametag");
    String password = request.getParameter("password");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    //Usuario de la base de datos
    String dbuser = "MiguelFalcon";
    //Contraseña de la base de datos
    String dbpassword = "12345678";
    //Pool de conexiones a la base de datos
    ConnectionPool pool = new ConnectionPool("jdbc:mysql://localhost:3306/unogame", dbuser, dbpassword);
    AuthService auth = new AuthService(pool.getConnection());
    LoggedPlayer player = auth.register(nametag, name, surname, password);
    response.sendRedirect("login.jsp");
%>