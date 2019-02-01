package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Jugador;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paco
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/Conclusion"})
public class Conclusion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();

        Equipo equipo = new Equipo();
        Jugador jugador = new Jugador();

        String url = null;

        switch (request.getParameter("op")) {
            case "updateEquipo":
                List<Jugador> jugadores = new ArrayList<>();
                equipo = (Equipo) gdao.getById(Long.parseLong(request.getParameter("idE")), Equipo.class);
                equipo.setNombreEquipo(request.getParameter("nombreE"));
                if (request.getParameter("jugador1") != null) {
                    if (request.getParameter("idJugador1") != null && request.getParameter("jugador1").length() > 0 && request.getParameter("dorsal1").length() > 0) {
                        jugador = (Jugador) gdao.getById(Long.parseLong(request.getParameter("idJugador1")), Jugador.class);
                    } else {
                        jugador = new Jugador();
                    }
                    jugador.setNombreJugador(request.getParameter("jugador1"));
                    jugador.setDorsal(Integer.parseInt(request.getParameter("dorsal1")));
                    jugadores.add(jugador);
                }

                if (request.getParameter("jugador2") != null) {
                    if (request.getParameter("idJugador2") != null && request.getParameter("jugador2").length() > 0 && request.getParameter("dorsal2").length() > 0) {
                        jugador = (Jugador) gdao.getById(Long.parseLong(request.getParameter("idJugador2")), Jugador.class);
                    } else {
                        jugador = new Jugador();
                    }
                    jugador.setNombreJugador(request.getParameter("jugador2"));
                    jugador.setDorsal(Integer.parseInt(request.getParameter("dorsal2")));
                    jugadores.add(jugador);
                }

                if (request.getParameter("jugador3") != null) {
                    if (request.getParameter("idJugador3") != null && request.getParameter("jugador3").length() > 0 && request.getParameter("dorsal3").length() > 0) {
                        jugador = (Jugador) gdao.getById(Long.parseLong(request.getParameter("idJugador3")), Jugador.class);
                    } else {
                        jugador = new Jugador();
                    }
                    jugador.setNombreJugador(request.getParameter("jugador3"));
                    jugador.setDorsal(Integer.parseInt(request.getParameter("dorsal3")));
                    jugadores.add(jugador);
                }

                equipo.setJugadores(jugadores);
                gdao.insertOrUpdate(equipo);
                url = "index.jsp";
                break;
            case "updateJugador":
                jugador = new Jugador();
                jugador.setNombreJugador(request.getParameter("nombreJ"));
                jugador.setDorsal(Integer.parseInt(request.getParameter("dorsalJ")));
                equipo = (Equipo) gdao.getById(Long.parseLong(request.getParameter("equipoXjugador")), Equipo.class);
                jugadores = equipo.getJugadores();
                jugadores.add(jugador);
                gdao.insertOrUpdate(jugador);

                url = "index.jsp";
                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
