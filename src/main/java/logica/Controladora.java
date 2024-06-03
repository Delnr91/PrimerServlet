package logica;

import persistencia.ControladoraPersistencia;
import java.util.List;
import logica.Usuario;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(Usuario usu) {
        controlPersis.crearUsuario(usu);
    }

    public List<Usuario> traerUsuario() {
        return controlPersis.traerUsuarios();
    }

    public void borrarUsuario(int id_eliminar) {
        controlPersis.borrarUsuario(id_eliminar);
    }

    public Usuario traerUsuario(int id_editar) {
        return controlPersis.traerUsuario(id_editar);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }

}
