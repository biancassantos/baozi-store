package uninter.baozi_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uninter.baozi_store.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
