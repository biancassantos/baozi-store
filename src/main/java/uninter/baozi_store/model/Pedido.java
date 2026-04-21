package uninter.baozi_store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "PEDIDO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @ManyToOne()
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "ID_PRODUTO")
    private Produto produto;
}
