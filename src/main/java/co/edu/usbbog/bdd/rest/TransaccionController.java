package co.edu.usbbog.bdd.rest;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.TipoTransaccion;
import co.edu.usbbog.bdd.model.Transaccion;
import co.edu.usbbog.bdd.service.TransaccionService;

@RestController
public class TransaccionController {
	@Autowired
	TransaccionService traService;
	
	
	@GetMapping("/crearTrans")
//	@Procedure("application/json")
	public String crearTrans(@RequestBody Transaccion newTrans) {
		JSONObject respuesta= new JSONObject();
		if(traService.crearTransaccion(newTrans).equals("Se guardo la transaccion")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	@PostMapping("/contarTrans")
	public String contarTrans() {
		JSONObject respuesta= new JSONObject();
			int aux=traService.contarTransaccion();
			respuesta.put("Count", aux);
			return respuesta.toString();
	}
	
	@PostMapping("/eliminarTrans")
	public String eliminarTrans(@RequestBody Transaccion newTrans) {
		JSONObject respuesta= new JSONObject();
		if(traService.eliminarTransaccion(newTrans).equals("Se elimino la transaccion")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/getTrans")
	public String getTrans() {
		JSONArray array= new JSONArray();
		List<Transaccion> trans=traService.findAll();
		for (int i = 0; i < trans.size(); i++) {
			JSONObject ciudadJson= new JSONObject();
			ciudadJson.put("ID", trans.get(i).getId());
			ciudadJson.put("Valor", trans.get(i).getValor());
			ciudadJson.put("Fecha", trans.get(i).getFecha());
			ciudadJson.put("Tipo", trans.get(i).getTipo());
			ciudadJson.put("Cuenta", trans.get(i).getCuenta());
			array.put(ciudadJson);
		}
		return array.toString();
	}
	
	@PostMapping("/buscarTrans")
	public String buscarTrans(@RequestBody Transaccion tipo) {
		JSONObject respuesta= new JSONObject();
		if(traService.mostrarTransaccion(tipo.getId())!=null) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/modificarTrans")
	public String modificarTrans(@RequestBody Transaccion newTrans) {
		JSONObject respuesta= new JSONObject();
		if(traService.modificarTransaccion(newTrans).equals("Se modifico la transaccion")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
}
