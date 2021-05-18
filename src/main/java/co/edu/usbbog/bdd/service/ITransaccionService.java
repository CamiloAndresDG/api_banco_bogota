package co.edu.usbbog.bdd.service;

import java.util.List;

import co.edu.usbbog.bdd.model.Transaccion;

public interface ITransaccionService {
	public String crearTransaccion(Transaccion Transaccion);
	public int contarTransaccion();
	public String modificarTransaccion(Transaccion Transaccion);
	public List<Transaccion> findAll();	
	public String eliminarTransaccion(Transaccion Transaccion);
	public Transaccion mostrarTransaccion(int id);
}
