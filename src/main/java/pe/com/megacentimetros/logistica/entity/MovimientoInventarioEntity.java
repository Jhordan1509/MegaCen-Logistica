package pe.com.megacentimetros.logistica.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "MovimientoInventarioEntity")
@Table(name = "movimientoinventario")
public class MovimientoInventarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codmovinv")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "tipmov", length = 30, nullable = false)
    private String tipo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "fecmov", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "obs", length = 300)
    private String observacion;

    @Column(name = "codprod", nullable = false)
    private Long codprod;

    @Column(name = "codalmori")
    private Long codalmori;

    @Column(name = "codalmdes")
    private Long codalmdes;

    @Column(name = "codordcom")
    private Long codordcom;

    @Column(name = "codrec")
    private Long codrec;

    @Column(name = "codped")
    private Long codped;

    @Column(name = "estmovinv", nullable = false)
    private Boolean estado;

    @Transient
    private Object producto;

    @Transient
    private Object almacenorigen;

    @Transient
    private Object almacendestino;

    @Transient
    private Object ordencompra;

    @Transient
    private Object recepcioncompra;

    @Transient
    private Object pedido;
}
