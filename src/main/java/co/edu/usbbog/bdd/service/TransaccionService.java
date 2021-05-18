package co.edu.usbbog.bdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbbog.bdd.model.TipoTransaccion;
import co.edu.usbbog.bdd.model.Transaccion;
import co.edu.usbbog.bdd.repo.ITipoDeTransaccion;
import co.edu.usbbog.bdd.repo.ITransaccionRepository;

@Service
public class TransaccionService implements ITransaccionService{
	
	@Autowired
	ITransaccionRepository tranRepo;

	@Override
	public String crearTransaccion(Transaccion Transaccion) {
		try {
			tranRepo.save(Transaccion);
			return "Se guardo la transaccion";
		} catch (IllegalArgumentException e) {
			return "No se guardo la transaccion: " + e.getMessage();
		}
	}
	

	@Override
	public int contarTransaccion() {
		try {
			long cantidad=0;
			cantidad=tranRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarTransaccion(Transaccion Transaccion) {
		try {
        	int busqueda= Transaccion.getId();
            if(tranRepo.getOne(busqueda)!=null) {
            	tranRepo.delete(Transaccion);
            	tranRepo.save(Transaccion);
                return "Se modifico la transaccion";
            }else {
                return "No se modifico la transaccion";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico la transaccion: " + e.getMessage();
        }
	}

	@Override
	public List<Transaccion> findAll() {
		try {
			List<Transaccion> encontrado=tranRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarTransaccion(Transaccion Transaccion) {
		try {
			if(tranRepo.getOne(Transaccion.getId())!=null) {
				tranRepo.delete(Transaccion);
				return "Se elimino la transaccion";
			}else {
			return "No Se elimino la transaccion";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino la transaccion: " + e.getMessage();
		}
	}

	@Override
	public Transaccion mostrarTransaccion(int id) {
		Transaccion tran= new Transaccion();
		try {
			if(tranRepo.getOne(id)!=null) {
				tran=tranRepo.getOne(id);
				return tran;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	

		
	
}
