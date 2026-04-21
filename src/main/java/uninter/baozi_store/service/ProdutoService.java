package uninter.baozi_store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uninter.baozi_store.exceptions.ApiException;
import uninter.baozi_store.model.Produto;
import uninter.baozi_store.repository.ProdutoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) throws ApiException {
        return produtoRepository
                .findById(id)
                .orElseThrow(() -> new ApiException("Produto não encontrado", HttpStatus.NOT_FOUND));
    }

    public Produto update(Long id, Produto produtoParaAtualizar) throws ApiException {
        Produto produto = findById(id);

        produto.setNome(produtoParaAtualizar.getNome());
        produto.setPreco(produtoParaAtualizar.getPreco());
        produto.setEstoque(produtoParaAtualizar.getEstoque());

        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
