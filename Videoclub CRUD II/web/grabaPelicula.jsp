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
    <body class="visionado">
        <%
          Class.forName("com.mysql.jdbc.Driver");
          Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3399/videoclub", "root", "");
          Statement sta = conexion.createStatement();

          request.setCharacterEncoding("UTF-8");

          // Comprueba la existencia del número de pelicula introducido
          String consultaNumPelicula = "SELECT * FROM pelicula WHERE idPelicula="
            + Integer.valueOf(request.getParameter("idPelicula"));

          ResultSet numeroDePeliculas = sta.executeQuery(consultaNumPelicula);
          numeroDePeliculas.last();

          if (numeroDePeliculas.getRow() != 0) {
            out.println("Lo siento, no se ha podido dar de alta, ya existe una película con el número "
              + request.getParameter("idPelicula") + ".");
          } else {
            String insercion = "INSERT INTO pelicula VALUES ("
              + Integer.valueOf(request.getParameter("idPelicula"))
              + ", '" + request.getParameter("nombre")
              + "', '" + request.getParameter("genero")
              + "', '" + request.getParameter("ano")
              + "', '" + request.getParameter("director") + "')";

            
            sta.execute(insercion);
            out.println("Película dada de alta correctamente.");
          }
          conexion.close();
        %>
        <br>
        <a href="peliculas.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Página principal</button>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>
</html>