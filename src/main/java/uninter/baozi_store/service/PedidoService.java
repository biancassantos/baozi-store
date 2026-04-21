package uninter.baozi_store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uninter.baozi_store.exceptions.ApiException;
import uninter.baozi_store.model.Pedido;
import uninter.baozi_store.model.Produto;
import uninter.baozi_store.repository.PedidoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoService produtoService;

    public Pedido create(Pedido pedido) throws ApiException {
        Produto produto = produtoService.findById(pedido.getProduto().getId());

        if (produto.getEstoque() < pedido.getQuantidade()) {
            throw new ApiException("Quantidade do produto insuficiente em estoque");
        }

        produto.setEstoque(produto.getEstoque() - pedido.getQuantidade());
        produto = produtoService.update(produto.getId(), produto);

        pedido.setProduto(produto);

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) throws ApiException {
        return pedidoRepository
                .findById(id)
                .orElseThrow(() -> new ApiException("Pedido não encontrado", HttpStatus.NOT_FOUND));
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
