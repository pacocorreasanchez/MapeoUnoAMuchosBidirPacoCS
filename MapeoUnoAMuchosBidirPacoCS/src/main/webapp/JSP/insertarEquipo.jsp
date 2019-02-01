<%-- 
    Document   : insertar
    Created on : 28 ene. 2019, 17:58:44
    Author     : paco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="ROBOTS" content="NOARCHIVE"> 
        <meta name="generator" content="NetBeans"> 
        <meta name="referrer" content="always"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="${estilos}" />
        <title>Insertar</title>
    </head>
    <body>
        <div id="principal">
            
            <center>
                <div class="contenedor">
                    <h2 class="me">Inserta los datos.</h2>
                </div>
            </center>
            <form method="post" action="Controlador?op=addEquipo">
                <center>
                <table>
                        <tr>
                            <td>Nombre del equipo</td>
                            <td><input type="text" name="nombreEquipo" /></td>
                        </tr>
                        <tr>
                            <td>Jugador 1: </td>
                            <td>Nombre<input type="text" name="jugador1" /></td>
                            <td>Dorsal<input type="number" name="dorsal1" /></td>
                        </tr>
                        <tr>
                            <td>Jugador 2</td>
                            <td>Nombre<input type="text" name="jugador2" /></td>
                            <td>Dorsal<input type="number" name="dorsal2" /></td>
                        </tr>
                        <tr>
                            <td>Jugador 3</td>
                            <td>Nombre<input type="text" name="jugador3" /></td>
                            <td>Dorsal<input type="number" name="dorsal3" /></td>
                        </tr>
                        
                    <tr>
                        <td colspan="5"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                    </tr>
                </table>
                </center>
            </form>
            <center>
                <p><a href="${contexto}/index.jsp" class="enlace">Menú inicial</a></p>
            </center>
        </div>
    </body>
</html>
