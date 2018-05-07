<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
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
                <div class="panel-heading"><a href="./index.html"><img class="flechatras" src="./static/flechatras.png" title="Ir atrás"></a><h2 class="text-center">Videoclub MiuC</h2><h4 class="text-center">Alquileres realizados en este momento</h4></div>

                <%
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3399/videoclub", "root", "");
                  Statement n = conexion.createStatement();
                  ResultSet listaAlquileres = n.executeQuery("SELECT * from vistaalquileres");
                
                  Statement aux = conexion.createStatement();
                  ResultSet resultAtributos = aux.executeQuery("DESCRIBE vistaalquileres");
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

                  while(listaAlquileres.next()){
                    for (int i = 0; i < listaAtributos.size(); i++) {
                        columnas.put(i,"<td class='text-center'>"+listaAlquileres.getString(listaAtributos.get(i))+"</td>");
                        System.out.println("[DEBUGG] Añadida a hashmap columna-" + listaAlquileres.getString(listaAtributos.get(i)) );
                    }
                    
                    System.out.println(columnas);
                    filas.add(columnas);
                    
                    System.out.println("[DEBUGG] HASHMAP COLUMNA AÑADIDA AL ARRAYLIST DE FILAS");
                    columnas = new HashMap();
                    System.out.println("[DEBUGG] CREADO DE NUEVO HASHMAP COLUMNA");
                  }

                
                %>

                <table class="table table-hover">
                    <tr><th class="text-center">ID Alquiler</th><th class="text-center">ID Pelicula</th><th class="text-center">Pelicula</th><th class="text-center">ID Socio</th><th class="text-center">Socio</th><th class="text-center">DNI</th><th class="text-center">Fecha Alquiler</th><th class="text-center">Fecha Devolver</th></tr>
                    <form method="get" action="grabaAlquiler.jsp">
                        <tr>
                            <td class="text-center"><input type="text" name="idAlquiler" size="5"></td>
                            <td class="text-center"><input type="text" name="pelicula" size="5"></td>
                            <td class="text-center"><input style="background-color : #d1d1d1" type="text" placeholder="Autocompletado" name="" readonly="readonly" size="11"></td>
                            <td class="text-center"><input type="text" name="socio" size="5"></td>
                            <td class="text-center"><input style="background-color : #d1d1d1" type="text" placeholder="Autocompletado" name="" readonly="readonly" size="11"></td>
                            <td class="text-center"><input style="background-color : #d1d1d1" type="text" placeholder="Autocompletado" name="" readonly="readonly" size="11"></td>
                            <td class="text-center"><input type="text" name="fecha" size="10"></td>
                            <td class="text-center"><input type="text" name="fechaEntrega" size="10"></td>
                            <td class="text-center"><button type="submit" value="Añadir" class="btn btn-success"><span class="glyphicon glyphicon-floppy-save"></span> Añadir alquiler</button></td>
                            <td></td>
                        </tr>           
                    </form>


                    <!--BUCLE QUE MUESTRA TODAS LAS FILAS, SE EJECUTA AUTOMATICAMENTE-->
                    <%
                      int contador = 0;

                      out.println("<tr>");
                      System.out.println("Tamaño del arraylist filas:" + filas.size());
                      
                      listaAlquileres = n.executeQuery("SELECT * from vistaalquileres");
                      while(contador < filas.size() && listaAlquileres.next()) {
                        
                        columnas = filas.get(contador);
                        //System.out.print(columnas.get(2));
                        
                        out.println(columnas.get(0));
                        out.println(columnas.get(1));
                        out.println(columnas.get(2));
                        out.println(columnas.get(3));
                        out.println(columnas.get(4));
                        out.println(columnas.get(5)); 
                        out.println(columnas.get(6)); 
                        out.println(columnas.get(7)); 
                    %>
                    <td>
                        <form method="get" action="modificaAlquiler.jsp">
                            <input type="hidden" name="idAlquiler" value="<%=listaAlquileres.getString("idAlquiler")%>">
                            <input type="hidden" name="idSocio" value="<%=listaAlquileres.getString("idSocio")%>">
                            <input type="hidden" name="idPelicula" value="<%=listaAlquileres.getString("idPelicula")%>">
                            <input type="hidden" name="fecha" value="<%=listaAlquileres.getString("fecha")%>">
                            <input type="hidden" name="fechaEntrega" value="<%=listaAlquileres.getString("fechaEntrega")%>">

                            <button type="submit"  class="btn btn-info"><span class="glyphicon glyphicon-edit"></span> Editar</button>
                        </form>
                    </td>
                    <td>
                        <form method="get" action="borraAlquiler.jsp">
                            <input type="hidden" name="idAlquiler" value="<%=listaAlquileres.getString("idAlquiler")%>"/>
                            <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-erase"></span> Borrar</button>
                        </form>
                    </td></tr>
                    <%
                      
                      contador++;
                      out.print("</tr>");
                        
                      } // while(contador < filas.size()
                      resultAtributos.close();
                      
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