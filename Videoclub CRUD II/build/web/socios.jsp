<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

        <link href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0/minty/bootstrap.min.css" rel="stylesheet" integrity="sha384-OSebLJ6DTybdnQ7rjdh2FeOkWs4mQkZQwBDa0IdEyyWyCONtTCUyj+VOEqMcpKAo" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="estilo.css">
        <title>Videoclub - Salvador Rebollo Benítez</title>
    </head>

    <body>
        <div class="container">
            <br><br>			
            <div class="panel panel-primary">
                <div class="panel-heading"><a href="./index.html"><img class="flechatras" src="./static/flechatras.png" title="Ir atrás"></a><h2 class="text-center">Videoclub MiuC</h2><h4 class="text-center">Lista de socios</h4></div>
                <%
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3399/videoclub", "root", "");
                  Statement n = conexion.createStatement();
                  ResultSet listaSocios = n.executeQuery("SELECT * FROM socio");
                  
                  
                  ArrayList<String> listaAtributos = new ArrayList<String>(); //LISTA
                  listaAtributos.add("idsocio");
                  listaAtributos.add("nombre");
                  listaAtributos.add("ciudad");
                  listaAtributos.add("dni");
                  listaAtributos.add("sexo");
                  listaAtributos.add("email");
                  
                  System.out.println("[DEBUGG] Tamaño listaAtributos.size()= " + listaAtributos.size());

                  ArrayList<HashMap> filas = new ArrayList<HashMap>();
                  HashMap<Integer, String> columnas = new HashMap<Integer, String>();

                  while(listaSocios.next()){
                    for (int i = 0; i < listaAtributos.size(); i++) {
                        columnas.put(i,"<td class='text-center'>"+listaSocios.getString(listaAtributos.get(i))+"</td>");
                        System.out.println("[DEBUGG] Añadida a hashmap columna-" + listaSocios.getString(listaAtributos.get(i)) );
                    }
                    
                    System.out.println(columnas);
                    filas.add(columnas);
                    
                    System.out.println("[DEBUGG] HASHMAP COLUMNA AÑADIDA AL ARRAYLIST DE FILAS");
                    columnas = new HashMap();
                    System.out.println("[DEBUGG] CREADO DE NUEVO HASHMAP COLUMNA");
                  }

                %>

                <table class="table table-striped">
                    <tr><th class="text-center">Nº de socio</th><th class="text-center">Nombre</th><th class="text-center">Ciudad</th><th class="text-center">DNI</th><th class="text-center">Sexo (H/M)</th><th class="text-center">Email</th></tr>
                    <form method="get" action="grabaSocio.jsp">
                        <tr>
                            <td class="text-center"><input type="text" name="idSocio" size="5"></td>
                            <td class="text-center"><input type="text" name="nombre" size="30"></td>
                            <td class="text-center"><input type="text" name="ciudad" size="5"></td>
                            <td class="text-center"><input type="text" name="dni" size="9"></td>
                            <td class="text-center"><input type="text" name="sexo" size="5"></td>
                            <td class="text-center"><input type="text" name="email" size="20"></td>
                            <td><button type="submit" value="Añadir" class="btn btn-success"><span class="glyphicon glyphicon-floppy-save"></span> Añadir socio</button></td>
                            <td></td>
                        </tr>           
                    </form>
                    <%
                      int contador = 0;

                      out.println("<tr>");
                      System.out.println("Tamaño del arraylist filas:" + filas.size());
                      
                      listaSocios = n.executeQuery("SELECT * FROM socio");
                      while(contador < filas.size() && listaSocios.next()) {
                        
                        columnas = filas.get(contador);
                        //System.out.print(columnas.get(2));
                        
                        out.println(columnas.get(0));
                        out.println(columnas.get(1));
                        out.println(columnas.get(2));
                        out.println(columnas.get(3));
                        out.println(columnas.get(4));
                        out.println(columnas.get(5));  
                    %>
                    <td>
                        <form method="get" action="modificaSocio.jsp">
                            <input type="hidden" name="idSocio" value="<%=listaSocios.getString("idSocio")%>">
                            <input type="hidden" name="nombre" value="<%=listaSocios.getString("nombre")%>">
                            <input type="hidden" name="ciudad" value="<%=listaSocios.getString("ciudad")%>">
                            <input type="hidden" name="dni" value="<%=listaSocios.getString("dni")%>">
                            <input type="hidden" name="sexo" value="<%=listaSocios.getString("sexo")%>">
                            <input type="hidden" name="email" value="<%=listaSocios.getString("email")%>">
                            <button type="submit"  class="btn btn-info"><span class="glyphicon glyphicon-edit"></span> Editar</button>
                        </form>
                    </td>
                    <td>
                        <form method="get" action="borraSocio.jsp">
                            <input type="hidden" name="idSocio" value="<%=listaSocios.getString("idSocio")%>"/>
                            <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-erase"></span> Borrar</button>
                        </form>
                    </td>                    

                    
                    
                    <%
                      
                      contador++;
                      out.print("</tr>");
                        
                      } // while(contador < filas.size()
                      
                      
                      conexion.close();
                      
                      
                    %>

                </table>
            </div>
            <div class="text-center">&copy; Salvador Rebollo Benítez</div>
        </div>
        <!-- jQuery (necessary for Bootstrap'n JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>