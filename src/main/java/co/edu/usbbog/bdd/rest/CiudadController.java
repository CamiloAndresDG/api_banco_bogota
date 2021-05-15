package co.edu.usbbog.bdd.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.repo.CiudadRepository;

@RestController
@RequestMapping("/prueba")
public class CiudadController {

	@Autowired
	CiudadRepository ciudadRepository;
	
	@GetMapping("/hola")
	public String hola() {
		return "Hola";
	}
}
