package co.edu.usbbog.bdd.service;

import java.util.List;


import co.edu.usbbog.bdd.model.TipoTransaccion;

public interface ITipoTransaccionService {
	public String crearTipoTransaccion(TipoTransaccion tipoTransaccion);
	public int contarTipoTransaccion();
	public String modificarTipoTransaccion(TipoTransaccion tipoTransacciona);
	public List<TipoTransaccion> findAll();	
	public String eliminarTipoTransaccion(TipoTransaccion tipoTransaccion);
	public TipoTransaccion mostrarTipoTransaccion(int id);
}
