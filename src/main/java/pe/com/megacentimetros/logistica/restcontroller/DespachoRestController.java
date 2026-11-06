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
import pe.com.megacentimetros.logistica.entity.DespachoEntity;
import pe.com.megacentimetros.logistica.service.DespachoService;

@RestController
@RequestMapping("/api/despacho")
public class DespachoRestController {

	@Autowired
	private DespachoService servicio;

	@GetMapping
	public List<DespachoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<DespachoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public DespachoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public DespachoEntity add(@RequestBody DespachoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public DespachoEntity update(@RequestBody DespachoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public DespachoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public DespachoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
