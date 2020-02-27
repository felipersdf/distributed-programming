package dao;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UsuariosDAO {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuariosDAO() {
        this.usuarios.add(new Usuario(1, "Ana", 20));
        this.usuarios.add(new Usuario(2, "Carlos", 30));
        this.usuarios.add(new Usuario(3, "João", 25));
        this.usuarios.add(new Usuario(4, "José", 18));
        this.usuarios.add(new Usuario(5, "Felipe da Silva Rodrigues", 26));
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public Usuario getUsuarioPorCodigo(int codigo){
        return this.usuarios
                           .stream()
                           .filter(usuario -> usuario.getCodigo() == codigo)
                           .collect(Collectors.toList()).get(0);
    }
}
