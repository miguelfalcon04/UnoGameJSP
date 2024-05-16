<%-- index.jsp (proyecto Incrementa5) --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connectionpool.ConnectionPool"%>
<%@page import="player.AuthService"%>
<%@page import="player.LoggedPlayer"%>
<%
    session.invalidate();
    response.sendRedirect("login.jsp");
%>