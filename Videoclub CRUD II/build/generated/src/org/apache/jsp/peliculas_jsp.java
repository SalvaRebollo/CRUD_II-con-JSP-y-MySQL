package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;

public final class peliculas_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                                <div class=\"panel-heading\"><a href=\"./index.html\"><img class=\"flechatras\" src=\"./static/flechatras.png\" title=\"Ir atrás\"></a><h2 class=\"text-center\">Videoclub MiuC</h2><h4 class=\"text-center\">Catálogo de películas</h4></div>\n");
      out.write("\n");
      out.write("                ");

                  Class.forName("com.mysql.jdbc.Driver");
                  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3399/videoclub", "root", "");
                  Statement n = conexion.createStatement();

                  ResultSet listaPeliculas = n.executeQuery("SELECT * FROM pelicula");

                  Statement aux = conexion.createStatement();
                  ResultSet resultAtributos = aux.executeQuery("DESCRIBE pelicula");
                  ArrayList<String> listaAtributos = new ArrayList<String>(); //LISTA
                  int q=0;
                  while(resultAtributos.next()){
                    listaAtributos.add(resultAtributos.getString("Field"));
                    System.out.println("[DEBUGG] Añadido:"+listaAtributos.get(q));
                    q++;
                  }
                  System.out.println("[DEBUGG] Tamaño listaAtributos.size()= " + listaAtributos.size());

                  ArrayList<HashMap> filas = new ArrayList<HashMap>();
                  HashMap<Integer, String> columnas = new HashMap<Integer, String>();

                  while(listaPeliculas.next()){
                    for (int i = 0; i < listaAtributos.size(); i++) {
                        columnas.put(i,"<td>"+listaPeliculas.getString(listaAtributos.get(i))+"</td>");
                        System.out.println("[DEBUGG] Añadida a hashmap columna-" + listaPeliculas.getString(listaAtributos.get(i)) );
                    }
                    
                    System.out.println(columnas);
                    filas.add(columnas);
                    
                    System.out.println("[DEBUGG] HASHMAP COLUMNA AÑADIDA AL ARRAYLIST DE FILAS");
                    columnas = new HashMap();
                    System.out.println("[DEBUGG] CREADO DE NUEVO HASHMAP COLUMNA");
                  }
                  
                
      out.write("\n");
      out.write("\n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("                    <tr><th>ID Película</th><th>Nombre</th><th>Genero</th><th>Año</th><th>Director</th></tr>\n");
      out.write("                    <form method=\"get\" action=\"grabaPelicula.jsp\">\n");
      out.write("                        <tr><td><input type=\"text\" name=\"idPelicula\" size=\"5\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"nombre\" size=\"20\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"genero\" size=\"10\"></td>\n");
      out.write("                            <td><input type=\"number\" name=\"ano\" size=\"4\"></td>\n");
      out.write("                            <td><input type=\"text\" name=\"director\" size=\"20\"></td>\n");
      out.write("                            <td><button type=\"submit\" value=\"Añadir\" class=\"btn btn-primary\"><span class=\"glyphicon glyphicon-plus\"></span> Añadir película</button></td><td></td></tr>           \n");
      out.write("                    </form>\n");
      out.write("                    ");
                      
                      int contador = 0;

                      out.println("<tr>");
                      System.out.println("Tamaño del arraylist filas:" + filas.size());
                      
                      listaPeliculas = n.executeQuery("SELECT * FROM pelicula");
                      while(contador < filas.size() && listaPeliculas.next()) {
                        
                        columnas = filas.get(contador);
                        //System.out.print(columnas.get(2));
                        
                        out.println(columnas.get(0));
                        out.println(columnas.get(1));
                        out.println(columnas.get(2));
                        out.println(columnas.get(3));
                        out.println(columnas.get(4));
                        
                    
      out.write("\n");
      out.write("                    <td>\n");
      out.write("                        <form method=\"get\" action=\"modificaPelicula.jsp\">\n");
      out.write("                            <input type=\"hidden\" name=\"idPelicula\" value=\"");
      out.print(listaPeliculas.getString("idPelicula"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"nombre\" value=\"");
      out.print(listaPeliculas.getString("nombre"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"genero\" value=\"");
      out.print(listaPeliculas.getString("genero"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"ano\" value=\"");
      out.print(listaPeliculas.getString("ano"));
      out.write("\">\n");
      out.write("                            <input type=\"hidden\" name=\"director\" value=\"");
      out.print(listaPeliculas.getString("director"));
      out.write("\">\n");
      out.write("                            <button type=\"submit\"  class=\"btn btn-info\"><span class=\"glyphicon glyphicon-pencil\"></span> Editar</button>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <form method=\"get\" action=\"borraPelicula.jsp\">\n");
      out.write("                            <input type=\"hidden\" name=\"idPelicula\" value=\"");
      out.print(listaPeliculas.getString("idPelicula"));
      out.write("\"/>\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-remove\"></span> Borrar</button>\n");
      out.write("                        </form>\n");
      out.write("                    </td></tr>\n");
      out.write("                    ");

                      contador++;
                      out.print("</tr>");
                        
                      } // while(contador < filas.size()
                      resultAtributos.close();
                      
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
