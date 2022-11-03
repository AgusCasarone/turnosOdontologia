package dao;


import model.Domicilio;
import model.Usuario;

public interface IDao<T> {

    Domicilio guardar(Domicilio domicilio);

    public Usuario guardar(Usuario t);

    public Usuario buscar(int id);

}