package service;

import dao.UsuariosDAO;
import model.Usuario;

import java.util.List;

public class UsuariosService {

    private UsuariosDAO usuariosDAO = new UsuariosDAO();

    public List<Usuario> getUsuarios(){
        return usuariosDAO.getUsuarios();
    }

    public Usuario getUsuarioPorCodigo(int codigo){
        return usuariosDAO.getUsuarioPorCodigo(codigo);
    }
}
