package pe.com.megacentimetros.logistica.service;

import java.util.List;
import pe.com.megacentimetros.logistica.entity.MovimientoInventarioEntity;

public interface MovimientoInventarioService {

	List<MovimientoInventarioEntity> findAll();

	List<MovimientoInventarioEntity> findAllCustom();

	MovimientoInventarioEntity findById(Long id);

	MovimientoInventarioEntity add(MovimientoInventarioEntity obj);

	MovimientoInventarioEntity update(MovimientoInventarioEntity obj, Long id);

	MovimientoInventarioEntity delete(Long id);

	MovimientoInventarioEntity enable(Long id);
}
