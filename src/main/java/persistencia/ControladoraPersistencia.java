package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    UsuarioJpaController usuJpa = new UsuarioJpaController();

    //Opcion crear (CREATE)
    public void crearUsuario(Usuario usu) {

        usuJpa.create(usu);
    }

    //Opcion Leer (READ)
    public List<Usuario> traerUsuarios() {

        return usuJpa.findUsuarioEntities();
    }

    //Opcion Actualizar (UPDATE)
    public Usuario traerUsuario(int id_editar) {

        return usuJpa.findUsuario(id_editar);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Opcion Eliminar (DELETE)  
    public void borrarUsuario(int id_eliminar) {

        try {
            usuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
