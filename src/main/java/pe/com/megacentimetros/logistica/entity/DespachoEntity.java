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
@Entity(name = "DespachoEntity")
@Table(name = "despacho")
public class DespachoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "coddesp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "numguia", length = 40, nullable = false, unique = true)
    private String numeroGuia;

    @Column(name = "fecdesp", nullable = false)
    private LocalDateTime fechaDespacho;

    @Column(name = "fecentest")
    private LocalDateTime fechaEntregaEstimada;

    @Column(name = "fecentreal")
    private LocalDateTime fechaEntregaReal;

    @Column(name = "sitent", length = 30, nullable = false)
    private String situacion;

    @Column(name = "dirent", length = 250, nullable = false)
    private String direccionEntrega;

    @Column(name = "obs", length = 300)
    private String observacion;

    @Column(name = "codped", nullable = false)
    private Long codped;

    @Column(name = "codtransp")
    private Long codtransp;

    @Column(name = "codperres", nullable = false)
    private Long codperres;

    @Column(name = "estdesp", nullable = false)
    private Boolean estado;

    @Transient
    private Object pedido;

    @Transient
    private Object transportista;

    @Transient
    private Object personalresponsable;
}
