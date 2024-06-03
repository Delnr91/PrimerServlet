package com.mycompany.primerservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;

@WebServlet(name = "SvUsuarios", urlPatterns = {"/SvUsuarios"})
public class SvUsuarios extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //simulacion base de datos logica   
        /* List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("123", "Daniel", "Nunez", "994107322"));
        listaUsuarios.add(new Usuario("123", "Manin", "Manin", "944452"));
        listaUsuarios.add(new Usuario("123", "matakuri", "rojas", "9941362")); */
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios = control.traerUsuario();

        //Clase que valida la sesion de usuario en la aplicacion web 
        HttpSession misesion = request.getSession();
        misesion.setAttribute("listaUsuarios", listaUsuarios);

        //generar respuesta
        response.sendRedirect("mostrarUsuarios.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = request.getParameter("telefono");

        Usuario usu = new Usuario();
        
        usu.setDni(dni);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setTelefono(telefono);

        control.crearUsuario(usu);

        //generar respuesta
        response.sendRedirect("index.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
