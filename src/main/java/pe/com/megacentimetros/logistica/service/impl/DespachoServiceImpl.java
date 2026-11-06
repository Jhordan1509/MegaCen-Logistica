package pe.com.megacentimetros.logistica.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.logistica.client.VentasFeignClient;
import pe.com.megacentimetros.logistica.client.PersonaFeignClient;
import pe.com.megacentimetros.logistica.exception.ResourceNotFoundException;
import pe.com.megacentimetros.logistica.entity.DespachoEntity;
import pe.com.megacentimetros.logistica.repository.DespachoRepository;
import pe.com.megacentimetros.logistica.service.DespachoService;

@Service
public class DespachoServiceImpl implements DespachoService {

	private DespachoRepository repositorio;
	private VentasFeignClient ventasFeignClient;
	private PersonaFeignClient personaFeignClient;

	public DespachoServiceImpl(DespachoRepository repositorio,
			VentasFeignClient ventasFeignClient,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.ventasFeignClient = ventasFeignClient;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<DespachoEntity> findAll() {
		List<DespachoEntity> lista = repositorio.findAll();
		for (DespachoEntity despacho : lista) {
			despacho.setPedido(ventasFeignClient.getPedido(despacho.getCodped()));
			if (despacho.getCodtransp() != null) {
				despacho.setTransportista(personaFeignClient.getTransportista(despacho.getCodtransp()));
			}
			despacho.setPersonalresponsable(personaFeignClient.getPersonal(despacho.getCodperres()));
		}
		return lista;
	}
	@Override
	public List<DespachoEntity> findAllCustom() {
		List<DespachoEntity> lista = repositorio.findAllCustom();
		for (DespachoEntity despacho : lista) {
			despacho.setPedido(ventasFeignClient.getPedido(despacho.getCodped()));
			if (despacho.getCodtransp() != null) {
				despacho.setTransportista(personaFeignClient.getTransportista(despacho.getCodtransp()));
			}
			despacho.setPersonalresponsable(personaFeignClient.getPersonal(despacho.getCodperres()));
		}
		return lista;
	}
	@Override
	public DespachoEntity findById(Long id) {
		DespachoEntity despacho = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Despacho con id " + id + " no existe"));
		despacho.setPedido(ventasFeignClient.getPedido(despacho.getCodped()));
		if (despacho.getCodtransp() != null) {
			despacho.setTransportista(personaFeignClient.getTransportista(despacho.getCodtransp()));
		}
		despacho.setPersonalresponsable(personaFeignClient.getPersonal(despacho.getCodperres()));
		return despacho;
	}
	@Override
	public DespachoEntity add(DespachoEntity obj) {
		obj.setEstado(true);
		if (obj.getFechaDespacho() == null) {
			obj.setFechaDespacho(LocalDateTime.now());
		}
		if (obj.getSituacion() == null) {
			obj.setSituacion("PENDIENTE");
		}
		return repositorio.save(obj);
	}
	@Override
	public DespachoEntity update(DespachoEntity obj, Long id) {
		DespachoEntity objdes = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Despacho con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objdes, "codigo");
		return repositorio.save(objdes);
	}
	@Override
	public DespachoEntity delete(Long id) {
		DespachoEntity objdes = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Despacho con id " + id + " no existe"));
		objdes.setEstado(false);
		return repositorio.save(objdes);
	}
	@Override
	public DespachoEntity enable(Long id) {
		DespachoEntity objdes = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Despacho con id " + id + " no existe"));
		objdes.setEstado(true);
		return repositorio.save(objdes);
	}
}
