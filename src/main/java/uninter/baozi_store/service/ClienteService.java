package uninter.baozi_store.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uninter.baozi_store.exceptions.ApiException;
import uninter.baozi_store.model.Cliente;
import uninter.baozi_store.repository.ClienteRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente create(Cliente cliente) {
        cliente.setClienteDesde(LocalDate.now());
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) throws ApiException {
        return clienteRepository
                .findById(id)
                .orElseThrow(() -> new ApiException("Cliente não encontrado", HttpStatus.NOT_FOUND));
    }

    public Cliente update(Long id, Cliente clienteToUpdate) throws ApiException {
        Cliente cliente = findById(id);

        cliente.setNome(clienteToUpdate.getNome());

        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
