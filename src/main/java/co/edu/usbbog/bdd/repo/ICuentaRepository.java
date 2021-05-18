package co.edu.usbbog.bdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.bdd.model.Cuenta;




public interface ICuentaRepository extends JpaRepository<Cuenta, Integer>{
	public List<Cuenta> findByNombres(String nombres);
}
