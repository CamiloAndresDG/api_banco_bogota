package co.edu.usbbog.bdd.service;

import java.util.List;

import co.edu.usbbog.bdd.model.Ciudad;


public interface ICiudadService {
	public String crearCiudad(Ciudad ciudad);
	public int contarCiudad();
	public String modificarCiudad(Ciudad ciudad);
	public List<Ciudad> findAll();	
	public String eliminarCiuadad(Ciudad ciudad);
	public Ciudad mostrarCiudad(int id);

}
