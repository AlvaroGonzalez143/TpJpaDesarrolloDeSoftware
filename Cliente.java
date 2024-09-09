package org.example;
import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private long DNI;

    private String Apellido;

    private String Nombre;
//Relacion 1 a 1 bidireccional con Domicilio
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Domicilio")
    private Domicilio domicilio;
//Relacion bidireccional con Factura 1 a *
    @OneToMany(mappedBy = "c")
    private List<Factura> facturas = new ArrayList<>();
}
