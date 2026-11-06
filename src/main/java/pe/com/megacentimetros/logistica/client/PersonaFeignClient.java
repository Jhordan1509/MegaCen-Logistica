package pe.com.megacentimetros.logistica.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-persona", url = "http://localhost:9092/pmega/api/")
public interface PersonaFeignClient {
	@GetMapping("/transportista/{id}")
	Object getTransportista(@PathVariable("id") Long id);

	@GetMapping("/personal/{id}")
	Object getPersonal(@PathVariable("id") Long id);
}
