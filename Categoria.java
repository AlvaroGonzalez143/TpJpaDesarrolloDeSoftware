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

public class Categoria implements Serializable{
        @Serial
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String Denominacion;

//Relacion bidireccional con Articulo
        @ManyToMany(mappedBy = "categorias")
        private List<Articulo> articulos = new ArrayList<>();

}
