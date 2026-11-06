package pe.com.megacentimetros.logistica.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.logistica.exception.ResourceNotFoundException;
import pe.com.megacentimetros.logistica.entity.IncidenciaDespachoEntity;
import pe.com.megacentimetros.logistica.repository.IncidenciaDespachoRepository;
import pe.com.megacentimetros.logistica.service.IncidenciaDespachoService;

@Service
public class IncidenciaDespachoServiceImpl implements IncidenciaDespachoService {

	private IncidenciaDespachoRepository repositorio;

	public IncidenciaDespachoServiceImpl(IncidenciaDespachoRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<IncidenciaDespachoEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<IncidenciaDespachoEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public IncidenciaDespachoEntity findById(Long id) {
		IncidenciaDespachoEntity incidenciaDespacho = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("IncidenciaDespacho con id " + id + " no existe"));
		return incidenciaDespacho;
	}
	@Override
	public IncidenciaDespachoEntity add(IncidenciaDespachoEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		if (obj.getSituacion() == null) {
			obj.setSituacion("PENDIENTE");
		}
		return repositorio.save(obj);
	}
	@Override
	public IncidenciaDespachoEntity update(IncidenciaDespachoEntity obj, Long id) {
		IncidenciaDespachoEntity objinc = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("IncidenciaDespacho con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objinc, "codigo");
		return repositorio.save(objinc);
	}
	@Override
	public IncidenciaDespachoEntity delete(Long id) {
		IncidenciaDespachoEntity objinc = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("IncidenciaDespacho con id " + id + " no existe"));
		objinc.setEstado(false);
		return repositorio.save(objinc);
	}
	@Override
	public IncidenciaDespachoEntity enable(Long id) {
		IncidenciaDespachoEntity objinc = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("IncidenciaDespacho con id " + id + " no existe"));
		objinc.setEstado(true);
		return repositorio.save(objinc);
	}
}
