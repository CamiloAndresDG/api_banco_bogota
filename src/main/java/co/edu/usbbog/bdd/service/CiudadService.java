package co.edu.usbbog.bdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.bdd.model.Ciudad;
import co.edu.usbbog.bdd.repo.ICiudadRepository;


@Service
public class CiudadService implements ICiudadService{
	
	@Autowired
	ICiudadRepository ciudadRepo;

	@Override
	public String crearCiudad(Ciudad ciudad) {
		try {
			ciudadRepo.save(ciudad);
			return "Se guardo la ciudad";
		} catch (IllegalArgumentException e) {
			return "No se guardo la ciudad: " + e.getMessage();
		}
	}

	@Override
	public int contarCiudad() {
		try {
			long cantidad=0;
			cantidad=ciudadRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarCiudad(Ciudad ciudad) {
		try {
        	int busqueda= ciudad.getId();
            if(ciudadRepo.getOne(busqueda)!=null) {
            	ciudadRepo.delete(ciudad);
            	ciudadRepo.save(ciudad);
                return "Se modifico la ciudad";
            }else {
                return "No se modifico la ciudad";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico la ciudad: " + e.getMessage();
        }
	}

	@Override
	public List<Ciudad> findAll() {
		try {
			List<Ciudad> encontrado=ciudadRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarCiuadad(Ciudad ciudad) {
		try {
			if(ciudadRepo.getOne(ciudad.getId())!=null) {
				ciudadRepo.delete(ciudad);
				return "Se elimino la ciudad";
			}else {
			return "No Se elimino la ciudad";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino la ciudad: " + e.getMessage();
		}
	}

	@Override
	public Ciudad mostrarCiudad(int id) {
		Ciudad ciudad= new Ciudad();
		try {
			if(ciudadRepo.getOne(id)!=null) {
				ciudad=ciudadRepo.getOne(id);
				return ciudad;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	}


