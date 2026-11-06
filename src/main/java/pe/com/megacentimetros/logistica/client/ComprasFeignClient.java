package pe.com.megacentimetros.logistica.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-compras", url = "http://localhost:9094/pmega/api/")
public interface ComprasFeignClient {
	@GetMapping("/ordencompra/{id}")
	Object getOrdenCompra(@PathVariable("id") Long id);

	@GetMapping("/recepcioncompra/{id}")
	Object getRecepcionCompra(@PathVariable("id") Long id);
}
