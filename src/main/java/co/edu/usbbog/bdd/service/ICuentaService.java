package co.edu.usbbog.bdd.service;

import java.util.List;

import co.edu.usbbog.bdd.model.Cuenta;



public interface ICuentaService {
	public String crearCuenta(Cuenta cuenta);
	public int contarCuenta();
	public String modificarCuenta(Cuenta cuenta);
	public List<Cuenta> findAll();	
	public String eliminarCuenta(Cuenta cuentad);
	public Cuenta mostrarCuenta(int id);
}
