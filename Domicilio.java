package org.example;
import lombok.*;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Domicilio implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NombreCalle;

    private int numero;
//Relacion 1 a 1 con Cliente
    @OneToOne(mappedBy = "domicilio")
    private Cliente cliente;

}
