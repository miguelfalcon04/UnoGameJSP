/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-05-16 08:19:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectionpool.ConnectionPool;
import player.AuthService;
import player.LoggedPlayer;
import java.util.ArrayList;
import player.PlayerService;
import views.finJuegoView;

public final class doFinalJuego_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>EndGame</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("    <!-- Enlace a Bootstrap CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");

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
    playerArray = playerSvc.requestAllEnd("ID ASC");

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

    LoggedPlayer newPlayerData = new LoggedPlayer(id,name, surname, nametag, password, win, lost);
    if(auth.updateEnd(newPlayerData)==1){
        session.setAttribute("player",newPlayerData);
        out.print(new finJuegoView(player, ganador));
    }else{
        response.sendRedirect("login.jsp?error=No ha sido posible cambiar la inforamción");
    }


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
