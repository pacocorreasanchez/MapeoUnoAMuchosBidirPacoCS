/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.Equipo;
import es.albarregas.beans.Jugador;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.dao.IGenericoDAO;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author paco
 */
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

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

        String url = null;
        HttpSession sesion = request.getSession();

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO gdao = daof.getGenericoDAO();
        if (!request.getParameter("op").equals("addEquipo")) {
            List<Equipo> listaEquipos = gdao.get(Equipo.class);
            sesion.setAttribute("listaEquipos", listaEquipos);
        }
        if (!request.getParameter("op").equals("addJugador")) {
            List<Jugador> listaJugadores = gdao.get(Jugador.class);
            sesion.setAttribute("listaJugadores", listaJugadores);
        }
        switch (request.getParameter("op")) {
            case "addEquipo":
                url = "JSP/insertarEquipo.jsp";
                break;
            case "addJugador":
                url = "JSP/insertarJugador.jsp";
                break;
            case "deleteEquipo":
                url = "JSP/eliminarEquipo.jsp";
                break;
            case "deleteJugador":
                url = "JSP/eliminarJugador.jsp";
                break;
            case "updateEquipo":
                url = "JSP/elegirActualizarEquipo.jsp";
                break;
            case "updateJugador":
                url = "JSP/elegirActualizarJugador.jsp";
                break;
            case "listEquipos":
                url = "JSP/listadoEquipos.jsp";
                break;
            case "listJugadores":
                url = "JSP/listadoJugadores.jsp";
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
