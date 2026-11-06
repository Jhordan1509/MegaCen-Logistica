package pe.com.megacentimetros.logistica.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.logistica.entity.IncidenciaDespachoEntity;
import pe.com.megacentimetros.logistica.service.IncidenciaDespachoService;

@RestController
@RequestMapping("/api/incidenciadespacho")
public class IncidenciaDespachoRestController {

	@Autowired
	private IncidenciaDespachoService servicio;

	@GetMapping
	public List<IncidenciaDespachoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<IncidenciaDespachoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public IncidenciaDespachoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public IncidenciaDespachoEntity add(@RequestBody IncidenciaDespachoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public IncidenciaDespachoEntity update(@RequestBody IncidenciaDespachoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public IncidenciaDespachoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public IncidenciaDespachoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
