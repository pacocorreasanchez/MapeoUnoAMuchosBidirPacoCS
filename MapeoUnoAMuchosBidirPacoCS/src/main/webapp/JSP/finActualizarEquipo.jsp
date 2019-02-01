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

                        <input type="hidden" name="idE" value="${equipos.idEquipo}" readonly/>

                        <tr>
                            <td>Nombre del equipo</td>
                            <td><input type="text" name="nombreE" value="${equipos.nombreEquipo}"/></td>
                        </tr>  
                        <c:forEach var="jugador" varStatus="contador" items="${equipos.jugadores}">
                            <tr>
                            <input type="hidden" name="idJugador${contador.index + 1}" value="${jugador.idJugador}"/>
                            <td>Jugador ${contador.index + 1}: </td>
                            <td><input type="text" name="jugador${contador.index + 1}" value="${jugador.nombreJugador}"/></td>
                            <td><input type="number" name="dorsal${contador.index + 1}" value="${jugador.dorsal}"/></td>
                            </tr>
                        </c:forEach>

                        <!--Este forEach añade campos vacios para insertar nuevos jugadores, tantos como haga falta para llegar a 3-->
                        <c:forEach var="contador" begin="1" end="${3 - (equipos.jugadores.size())}">		    
                            <tr>
                                <td>Jugador ${equipos.jugadores.size()+contador}</td>
                                <td><input type="text" name="jugador${equipos.jugadores.size()+contador}"/></td>
                                <td><input type="number" name="dorsal${equipos.jugadores.size()+contador}"/></td>
                            </tr>
                        </c:forEach>


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
