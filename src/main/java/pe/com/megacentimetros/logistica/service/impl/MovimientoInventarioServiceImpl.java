package pe.com.megacentimetros.logistica.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.logistica.client.InventarioFeignClient;
import pe.com.megacentimetros.logistica.client.ComprasFeignClient;
import pe.com.megacentimetros.logistica.client.VentasFeignClient;
import pe.com.megacentimetros.logistica.exception.ResourceNotFoundException;
import pe.com.megacentimetros.logistica.entity.MovimientoInventarioEntity;
import pe.com.megacentimetros.logistica.repository.MovimientoInventarioRepository;
import pe.com.megacentimetros.logistica.service.MovimientoInventarioService;

@Service
public class MovimientoInventarioServiceImpl implements MovimientoInventarioService {

	private MovimientoInventarioRepository repositorio;
	private InventarioFeignClient inventarioFeignClient;
	private ComprasFeignClient comprasFeignClient;
	private VentasFeignClient ventasFeignClient;

	public MovimientoInventarioServiceImpl(MovimientoInventarioRepository repositorio,
			InventarioFeignClient inventarioFeignClient,
			ComprasFeignClient comprasFeignClient,
			VentasFeignClient ventasFeignClient) {
		this.repositorio = repositorio;
		this.inventarioFeignClient = inventarioFeignClient;
		this.comprasFeignClient = comprasFeignClient;
		this.ventasFeignClient = ventasFeignClient;
	}

	@Override
	public List<MovimientoInventarioEntity> findAll() {
		List<MovimientoInventarioEntity> lista = repositorio.findAll();
		for (MovimientoInventarioEntity movimientoInventario : lista) {
			movimientoInventario.setProducto(inventarioFeignClient.getProducto(movimientoInventario.getCodprod()));
			if (movimientoInventario.getCodalmori() != null) {
				movimientoInventario.setAlmacenorigen(inventarioFeignClient.getAlmacen(movimientoInventario.getCodalmori()));
			}
			if (movimientoInventario.getCodalmdes() != null) {
				movimientoInventario.setAlmacendestino(inventarioFeignClient.getAlmacen(movimientoInventario.getCodalmdes()));
			}
			if (movimientoInventario.getCodordcom() != null) {
				movimientoInventario.setOrdencompra(comprasFeignClient.getOrdenCompra(movimientoInventario.getCodordcom()));
			}
			if (movimientoInventario.getCodrec() != null) {
				movimientoInventario.setRecepcioncompra(comprasFeignClient.getRecepcionCompra(movimientoInventario.getCodrec()));
			}
			if (movimientoInventario.getCodped() != null) {
				movimientoInventario.setPedido(ventasFeignClient.getPedido(movimientoInventario.getCodped()));
			}
		}
		return lista;
	}
	@Override
	public List<MovimientoInventarioEntity> findAllCustom() {
		List<MovimientoInventarioEntity> lista = repositorio.findAllCustom();
		for (MovimientoInventarioEntity movimientoInventario : lista) {
			movimientoInventario.setProducto(inventarioFeignClient.getProducto(movimientoInventario.getCodprod()));
			if (movimientoInventario.getCodalmori() != null) {
				movimientoInventario.setAlmacenorigen(inventarioFeignClient.getAlmacen(movimientoInventario.getCodalmori()));
			}
			if (movimientoInventario.getCodalmdes() != null) {
				movimientoInventario.setAlmacendestino(inventarioFeignClient.getAlmacen(movimientoInventario.getCodalmdes()));
			}
			if (movimientoInventario.getCodordcom() != null) {
				movimientoInventario.setOrdencompra(comprasFeignClient.getOrdenCompra(movimientoInventario.getCodordcom()));
			}
			if (movimientoInventario.getCodrec() != null) {
				movimientoInventario.setRecepcioncompra(comprasFeignClient.getRecepcionCompra(movimientoInventario.getCodrec()));
			}
			if (movimientoInventario.getCodped() != null) {
				movimientoInventario.setPedido(ventasFeignClient.getPedido(movimientoInventario.getCodped()));
			}
		}
		return lista;
	}
	@Override
	public MovimientoInventarioEntity findById(Long id) {
		MovimientoInventarioEntity movimientoInventario = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoInventario con id " + id + " no existe"));
		movimientoInventario.setProducto(inventarioFeignClient.getProducto(movimientoInventario.getCodprod()));
		if (movimientoInventario.getCodalmori() != null) {
			movimientoInventario.setAlmacenorigen(inventarioFeignClient.getAlmacen(movimientoInventario.getCodalmori()));
		}
		if (movimientoInventario.getCodalmdes() != null) {
			movimientoInventario.setAlmacendestino(inventarioFeignClient.getAlmacen(movimientoInventario.getCodalmdes()));
		}
		if (movimientoInventario.getCodordcom() != null) {
			movimientoInventario.setOrdencompra(comprasFeignClient.getOrdenCompra(movimientoInventario.getCodordcom()));
		}
		if (movimientoInventario.getCodrec() != null) {
			movimientoInventario.setRecepcioncompra(comprasFeignClient.getRecepcionCompra(movimientoInventario.getCodrec()));
		}
		if (movimientoInventario.getCodped() != null) {
			movimientoInventario.setPedido(ventasFeignClient.getPedido(movimientoInventario.getCodped()));
		}
		return movimientoInventario;
	}
	@Override
	public MovimientoInventarioEntity add(MovimientoInventarioEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		return repositorio.save(obj);
	}
	@Override
	public MovimientoInventarioEntity update(MovimientoInventarioEntity obj, Long id) {
		MovimientoInventarioEntity objmov = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoInventario con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objmov, "codigo");
		return repositorio.save(objmov);
	}
	@Override
	public MovimientoInventarioEntity delete(Long id) {
		MovimientoInventarioEntity objmov = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoInventario con id " + id + " no existe"));
		objmov.setEstado(false);
		return repositorio.save(objmov);
	}
	@Override
	public MovimientoInventarioEntity enable(Long id) {
		MovimientoInventarioEntity objmov = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("MovimientoInventario con id " + id + " no existe"));
		objmov.setEstado(true);
		return repositorio.save(objmov);
	}
}
