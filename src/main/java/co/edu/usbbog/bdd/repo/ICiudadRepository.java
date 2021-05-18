package co.edu.usbbog.bdd.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbbog.bdd.model.Ciudad;




public interface ICiudadRepository extends JpaRepository<Ciudad, Integer>{
	public List<Ciudad> findByNombre(String nombre);
}
