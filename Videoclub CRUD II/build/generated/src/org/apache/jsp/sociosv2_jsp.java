package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class sociosv2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/minty/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-OSebLJ6DTybdnQ7rjdh2FeOkWs4mQkZQwBDa0IdEyyWyCONtTCUyj+VOEqMcpKAo\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">\n");
      out.write("        <title>Videoclub - Salvador Rebollo Benítez</title>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <br><br>\t\t\t\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\"><a href=\"./index.html\"><img class=\"flechatras\" src=\"./static/flechatras.png\" title=\"Ir atrás\"></a><h2 class=\"text-center\">Videoclub MiuC</h2><h4 class=\"text-center\">Lista de socios</h4></div>\n");
      out.write("                ");

                  Class.forName("com.mysql.jdbc.Driver");
                  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3399/videoclub", "root", "");
                  Statement n = conexion.createStatement();

                  ResultSet listaSocios = n.executeQuery("SELECT * FROM socio");
                  
                
      out.write("\n");
      out.write("\n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("                    <tr><th>Nº de socio</th><th>Nombre</th><th>Ciudad</th><th>DNI</th><th>Sexo (H/M)</th><th>Email</th></tr>\n");
      out.write("                    <form method=\"get\" action=\"grabaSocio.jsp\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><input type=\"text\" name=\"idSocio\" size=\"5\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"nombre\" size=\"30\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"ciudad\" size=\"5\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"dni\" size=\"9\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"sexo\" size=\"5\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"email\" size=\"20\"></td>\n");
      out.write("                            <td><button type=\"submit\" value=\"Añadir\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-plus\"></span> Añadir socio</button></td>\n");
      out.write("                            <td></td>\n");
      out.write("                        </tr>           \n");
      out.write("                    </form>\n");
      out.write("                    ");

                      while (listaSocios.next()) {
                        out.println("<tr><td>");
                        out.println(listaSocios.getString("idSocio") + "</td>");
                        out.println("<td>" + listaSocios.getString("nombre") + "</td>");
                        out.println("<td>" + listaSocios.getString("ciudad") + "</td>");
                        out.println("<td>" + listaSocios.getString("dni") + "</td>");
                        out.println("<td>" + listaSocios.getString("sexo") + "</td>");
                        out.println("<td>" + listaSocios.getString("email") + "</td>");
                    
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <form method=\"get\" action=\"modificaSocio.jsp\">\n");
      out.write("                            <input type=\"hidden\" name=\"idSocio\" value=\"");
      out.print(listaSocios.getString("idSocio"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"nombre\" value=\"");
      out.print(listaSocios.getString("nombre"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"ciudad\" value=\"");
      out.print(listaSocios.getString("ciudad"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"dni\" value=\"");
      out.print(listaSocios.getString("dni"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"sexo\" value=\"");
      out.print(listaSocios.getString("sexo"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"email\" value=\"");
      out.print(listaSocios.getString("email"));
      out.write("\">\n");
      out.write("                            <button type=\"submit\"  class=\"btn btn-info\"><span class=\"glyphicon glyphicon-pencil\"></span> Editar</button>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form method=\"get\" action=\"borraSocio.jsp\">\n");
      out.write("                            <input type=\"hidden\" name=\"idSocio\" value=\"");
      out.print(listaSocios.getString("idSocio"));
      out.write("\"/>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-remove\"></span> Borrar</button>\n");
      out.write("                        </form>\n");
      out.write("                    </td></tr>\n");
      out.write("                    ");

                      } // while

                      conexion.close();
                    
      out.write("\n");
      out.write("\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"text-center\">&copy; Salvador Rebollo Benítez</div>\n");
      out.write("        </div>\n");
      out.write("        <!-- jQuery (necessary for Bootstrap'n JavaScript plugins) -->\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
