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
import pe.com.megacentimetros.logistica.entity.MovimientoInventarioEntity;
import pe.com.megacentimetros.logistica.service.MovimientoInventarioService;

@RestController
@RequestMapping("/api/movimientoinventario")
public class MovimientoInventarioRestController {

	@Autowired
	private MovimientoInventarioService servicio;

	@GetMapping
	public List<MovimientoInventarioEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<MovimientoInventarioEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public MovimientoInventarioEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public MovimientoInventarioEntity add(@RequestBody MovimientoInventarioEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public MovimientoInventarioEntity update(@RequestBody MovimientoInventarioEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public MovimientoInventarioEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public MovimientoInventarioEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
