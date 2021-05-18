package co.edu.usbbog.bdd.rest;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.edu.usbbog.bdd.model.Cuenta;
import co.edu.usbbog.bdd.service.ICuentaService;

@RestController
public class CuentaController {
	@Autowired
	ICuentaService cuentaService;
	
	@GetMapping("/crearCuenta")
//	@Procedure("application/json")
	public String crearCuenta(@RequestBody Cuenta newCuenta) {
		JSONObject respuesta= new JSONObject();
		if(cuentaService.crearCuenta(newCuenta).equals("Se guardo la cuenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	
	@PostMapping("/contarCuenta")
	public String contarCuenta() {
		JSONObject respuesta= new JSONObject();
			int aux=cuentaService.contarCuenta();
			respuesta.put("Count", aux);
			return respuesta.toString();
	}
	
	@PostMapping("/eliminarCuenta")
	public String eliminarCuenta(@RequestBody Cuenta newCuenta) {
		JSONObject respuesta= new JSONObject();
		if(cuentaService.eliminarCuenta(newCuenta).equals("Se elimino la cuenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/getCuenta")
	public String getCuenta() {
		JSONArray array= new JSONArray();
		List<Cuenta> cuenta=cuentaService.findAll();
		for (int i = 0; i < cuenta.size(); i++) {
			JSONObject ciudadJson= new JSONObject();
			ciudadJson.put("Numero", cuenta.get(i).getNum());
			ciudadJson.put("Cedula", cuenta.get(i).getCedula());
			ciudadJson.put("Nombre", cuenta.get(i).getNombres());
			ciudadJson.put("Telefono", cuenta.get(i).getTelefono());
			ciudadJson.put("Saldo", cuenta.get(i).getSaldo());
			ciudadJson.put("Ciudad", cuenta.get(i).getCiudad());
			array.put(ciudadJson);
		}
		return array.toString();
	}
	
	@PostMapping("/buscarCuenta")
	public String buscarCuenta(@RequestBody Cuenta cuenta) {
		JSONObject respuesta= new JSONObject();
		int busqueda= cuenta.getNum();
		if(busqueda!= 0) {
			cuentaService.mostrarCuenta(cuenta.getNum());
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/modificarCuenta")
	public String modificarcuenta(@RequestBody Cuenta newCuenta) {
		JSONObject respuesta= new JSONObject();
		if(cuentaService.modificarCuenta(newCuenta).equals("Se modifico la cuenta")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
}
