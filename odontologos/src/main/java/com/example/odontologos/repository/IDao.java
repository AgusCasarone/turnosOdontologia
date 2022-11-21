package com.example.odontologos.repository;


import java.util.List;

public interface IDao<T> {

    public T crear(T t);

    T buscar(Integer id);

    Boolean eliminar(int id);

    List<T> listar();

    T actualizar(T t);

}
