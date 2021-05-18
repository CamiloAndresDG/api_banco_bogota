package co.edu.usbbog.bdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.bdd.model.TipoTransaccion;



public interface ITipoDeTransaccion extends JpaRepository<TipoTransaccion, Integer>{
	public List<TipoTransaccion> findByNombre(String nombre);
}
