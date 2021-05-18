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
import co.edu.usbbog.bdd.service.TipoTransaccionService;

@RestController
public class TipoTransaccionController {
	
	@Autowired
	TipoTransaccionService tipoService;
	
	@GetMapping("/crearTipo")
//	@Procedure("application/json")
	public String crearTipo(@RequestBody TipoTransaccion newTipo) {
		JSONObject respuesta= new JSONObject();
		if(tipoService.crearTipoTransaccion(newTipo).equals("Se guardo el tipo de transaccion")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
	}
	
	
	@PostMapping("/contarTipo")
	public String contarTipo() {
		JSONObject respuesta= new JSONObject();
			int aux=tipoService.contarTipoTransaccion();
			respuesta.put("Count", aux);
			return respuesta.toString();
	}
	
	
	@PostMapping("/eliminarTipo")
	public String eliminarTipo(@RequestBody TipoTransaccion newTipo) {
		JSONObject respuesta= new JSONObject();
		if(tipoService.eliminarTipoTransaccion(newTipo).equals("Se elimino el tipo de transaccion")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/getTipo")
	public String getTipo() {
		JSONArray array= new JSONArray();
		List<TipoTransaccion> tipo=tipoService.findAll();
		for (int i = 0; i < tipo.size(); i++) {
			JSONObject ciudadJson= new JSONObject();
			ciudadJson.put("ID", tipo.get(i).getId());
			ciudadJson.put("Nombre", tipo.get(i).getNombre());
			array.put(ciudadJson);
		}
		return array.toString();
	}
	
	
	@PostMapping("/buscarTipo")
	public String buscarTipo(@RequestBody TipoTransaccion tipo) {
		JSONObject respuesta= new JSONObject();
		if(tipoService.mostrarTipoTransaccion(tipo.getId())!=null) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
	
	@PostMapping("/modificarTipo")
	public String modificarTipo(@RequestBody TipoTransaccion newTipo) {
		JSONObject respuesta= new JSONObject();
		if(tipoService.modificarTipoTransaccion(newTipo).equals("Se modifico el tipo de transaccion")) {
			respuesta.put("respuesta", true);
			return respuesta.toString();
		}else {
			respuesta.put("respuesta", false);
			return respuesta.toString();
		}
		
	}
}
