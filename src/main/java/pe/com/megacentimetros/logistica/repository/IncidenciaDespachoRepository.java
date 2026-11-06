package pe.com.megacentimetros.logistica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.logistica.entity.IncidenciaDespachoEntity;

public interface IncidenciaDespachoRepository extends JpaRepository<IncidenciaDespachoEntity, Long> {

	@Query("select d from IncidenciaDespachoEntity d where d.estado = true")
	List<IncidenciaDespachoEntity> findAllCustom();
}
