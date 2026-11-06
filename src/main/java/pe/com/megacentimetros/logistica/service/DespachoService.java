package pe.com.megacentimetros.logistica.service;

import java.util.List;
import pe.com.megacentimetros.logistica.entity.DespachoEntity;

public interface DespachoService {

	List<DespachoEntity> findAll();

	List<DespachoEntity> findAllCustom();

	DespachoEntity findById(Long id);

	DespachoEntity add(DespachoEntity obj);

	DespachoEntity update(DespachoEntity obj, Long id);

	DespachoEntity delete(Long id);

	DespachoEntity enable(Long id);
}
