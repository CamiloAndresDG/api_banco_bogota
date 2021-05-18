package co.edu.usbbog.bdd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.usbbog.bdd.model.Cuenta;
import co.edu.usbbog.bdd.repo.ICuentaRepository;

@Service
public class CuentaService implements ICuentaService{
	@Autowired
	ICuentaRepository cuentaRepo;

	@Override
	public String crearCuenta(Cuenta cuenta) {
		try {
			cuentaRepo.save(cuenta);
			return "Se guardo la cuenta";
		} catch (IllegalArgumentException e) {
			return "No se guardo la cuenta: " + e.getMessage();
		}
	}

	@Override
	public int contarCuenta() {
		try {
			long cantidad=0;
			cantidad=cuentaRepo.count();
			Integer i=(int) cantidad;
			return i;
		} catch (IllegalArgumentException e) {
			return 0;
		}
	}

	@Override
	public String modificarCuenta(Cuenta cuenta) {
		try {
        	int busqueda= cuenta.getNum();
            if(cuentaRepo.getOne(busqueda)!=null) {
            	cuentaRepo.delete(cuenta);
            	cuentaRepo.save(cuenta);
                return "Se modifico la cuenta";
            }else {
                return "No se modifico la cuenta";
            }
        } catch (IllegalArgumentException e) {
            return "No se modifico la cuenta: " + e.getMessage();
        }
	}

	@Override
	public List<Cuenta> findAll() {
		try {
			List<Cuenta> encontrado=cuentaRepo.findAll();
			return encontrado;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String eliminarCuenta(Cuenta cuenta) {
		try {
			if(cuentaRepo.getOne(cuenta.getNum())!=null) {
				cuentaRepo.delete(cuenta);
				return "Se elimino la cuenta";
			}else {
			return "No Se elimino la cuenta";
			}
		} catch (IllegalArgumentException e) {
			return "No Se elimino la cuenta: " + e.getMessage();
		}
	}

	@Override
	public Cuenta mostrarCuenta(int id) {
		Cuenta cuenta= new Cuenta();
		try {
			if(cuentaRepo.getOne(id)!=null) {
				cuenta=cuentaRepo.getOne(id);
				return cuenta;
			}else {
				return null;
			}
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	

	
}
