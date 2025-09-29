package co.edu.unbosque.pokemon.service;

import java.util.List;

public interface CRUDOperation<D> {

	public int create(D newData);

	public List<D> getAll();

	public boolean existByCorreo(String correo);

	public int deleteByID(Long id);

	public int updateByID(Long id, D newData);

}
