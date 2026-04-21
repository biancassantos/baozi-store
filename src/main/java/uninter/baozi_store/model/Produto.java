package uninter.baozi_store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "PRODUTO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "PRECO")
    private BigDecimal preco;

    @Column(name = "ESTOQUE")
    private Integer estoque;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<Pedido> pedidos;
}
