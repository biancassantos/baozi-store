package uninter.baozi_store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uninter.baozi_store.exceptions.ApiException;
import uninter.baozi_store.model.Pedido;
import uninter.baozi_store.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) throws ApiException {
        return new ResponseEntity<>(pedidoService.create(pedido), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return new ResponseEntity<>(pedidoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable("id") Long id) throws ApiException {
        return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        pedidoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
