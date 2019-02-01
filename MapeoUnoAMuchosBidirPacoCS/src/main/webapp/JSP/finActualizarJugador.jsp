<%-- 
    Document   : finActualizar
    Created on : 28 ene. 2019, 17:59:19
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
        <title>Actualizar</title>
    </head>
    <body>
        <div id="principal">
            <center>
                <div class="contenedor">
                    <h2 class="me">Actualización de datos.</h2>
                </div>
            </center>
            <form method="post" action="Conclusion?op=update">
                <center>
                    <table>

                        <input type="hidden" name="idJ" value="${jugadores.idJugador}" readonly/>

                        <tr>
                            <td>Nombre del jugador</td>
                            <td><input type="text" name="nombreJ" value="${jugadores.nombreJugador}"/></td>
                        </tr>
                        <tr>
                            <td>Dorsal</td>
                            <td><input type="number" name="dorsalJ" value="${jugadores.dorsal}"/></td>
                        </tr>
                        <tr>
                            <td>Equipo</td>
                            <td>
                                <select name="equipoXjugador">
                                    <c:forEach var="equi" items="${listaEquipos}">
                                        <option value="${equi.idEquipo}">${equi.nombreEquipo}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>


                        <tr>
                            <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
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
