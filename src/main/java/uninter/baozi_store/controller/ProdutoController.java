package uninter.baozi_store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uninter.baozi_store.exceptions.ApiException;
import uninter.baozi_store.model.Produto;
import uninter.baozi_store.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto Produto) {
        return new ResponseEntity<>(produtoService.create(Produto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable("id") Long id) throws ApiException {
        return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody Produto produtoParaAtualizar) throws ApiException {
        return new ResponseEntity<>(produtoService.update(id, produtoParaAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
