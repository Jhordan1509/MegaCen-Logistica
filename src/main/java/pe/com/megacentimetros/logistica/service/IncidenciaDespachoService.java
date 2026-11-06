package pe.com.megacentimetros.logistica.service;

import java.util.List;
import pe.com.megacentimetros.logistica.entity.IncidenciaDespachoEntity;

public interface IncidenciaDespachoService {

	List<IncidenciaDespachoEntity> findAll();

	List<IncidenciaDespachoEntity> findAllCustom();

	IncidenciaDespachoEntity findById(Long id);

	IncidenciaDespachoEntity add(IncidenciaDespachoEntity obj);

	IncidenciaDespachoEntity update(IncidenciaDespachoEntity obj, Long id);

	IncidenciaDespachoEntity delete(Long id);

	IncidenciaDespachoEntity enable(Long id);
}
