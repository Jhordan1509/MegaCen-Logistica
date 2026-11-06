package pe.com.megacentimetros.logistica.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.logistica.entity.MovimientoInventarioEntity;

public interface MovimientoInventarioRepository extends JpaRepository<MovimientoInventarioEntity, Long> {

	@Query("select d from MovimientoInventarioEntity d where d.estado = true")
	List<MovimientoInventarioEntity> findAllCustom();
}
