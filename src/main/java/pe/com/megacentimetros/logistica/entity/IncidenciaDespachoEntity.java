package pe.com.megacentimetros.logistica.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "IncidenciaDespachoEntity")
@Table(name = "incidenciadespacho")
public class IncidenciaDespachoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codinc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "tipinc", length = 30, nullable = false)
    private String tipo;

    @Column(name = "descrip", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "fecinc", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "sitres", length = 30, nullable = false)
    private String situacion;

    @Column(name = "solucion", length = 500)
    private String solucion;

    @Column(name = "coddesp", nullable = false)
    private Long coddesp;

    @Column(name = "estinc", nullable = false)
    private Boolean estado;
}
