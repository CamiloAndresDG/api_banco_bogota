package co.edu.usbbog.bdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.usbbog.bdd.model.TipoTransaccion;
import co.edu.usbbog.bdd.repo.ITipoDeTransaccion;

@Service
public class TipoTransaccionService implements ITipoTransaccionService{
	
	@Autowired
	ITipoDeTransaccion tipoRepo;

	@Override
	public String crearTipoTransaccion(TipoTransaccion tipoTransaccion) {
		try {
			tipoRepo.save(tipoTransaccion);
			return "Se guardo el tipo de transaccion";
		} catch (IllegalArgumentException e) {
			return "No se guardo el tipo de transaccion: " + e.getMessage();
		}
	}

	@Override
	public int contarTipoTransaccion() {
		try {
			long cantidad=0;
			cantidad=tipoRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarTipoTransaccion(TipoTransaccion tipoTransacciona) {
		try {
        	int busqueda= tipoTransacciona.getId();
            if(tipoRepo.getOne(busqueda)!=null) {
            	tipoRepo.delete(tipoTransacciona);
            	tipoRepo.save(tipoTransacciona);
                return "Se modifico el tipo de transaccion";
            }else {
                return "No se modifico el tipo de transaccion";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico el tipo de transaccion: " + e.getMessage();
        }
	}

	@Override
	public List<TipoTransaccion> findAll() {
		try {
			List<TipoTransaccion> encontrado=tipoRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarTipoTransaccion(TipoTransaccion tipoTransaccion) {
		try {
			if(tipoRepo.getOne(tipoTransaccion.getId())!=null) {
				tipoRepo.delete(tipoTransaccion);
				return "Se elimino el tipo de transaccion";
			}else {
			return "No Se elimino el tipo de transaccion";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino tipo de transaccion: " + e.getMessage();
		}
	}

	@Override
	public TipoTransaccion mostrarTipoTransaccion(int id) {
		TipoTransaccion tipo= new TipoTransaccion();
		try {
			if(tipoRepo.getOne(id)!=null) {
				tipo=tipoRepo.getOne(id);
				return tipo;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	
}
