package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.ClienteMapper;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.repository.ClienteRepository;
import br.gov.sp.fatec.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        return clienteMapper.map(clienteRepository.save(clienteMapper.map(clienteRequest)));
    }

    @Override
    public ClienteResponse findById(Long id) {
        return clienteMapper.map(
                clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com o id a seguir não foi encontrdo: " + id)));
    }

    @Override
    public List<ClienteResponse> findAll() {
        return clienteRepository.findAll().stream().map(clienteMapper::map).toList();
    }

    @Override
    public void updateById(Long id, ClienteUpdateRequest clienteUpdateRequest) {
        Cliente clienteUpdated = clienteMapper.map(clienteUpdateRequest);
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cliente com o id a seguir não foi encontrdo: " + id));

        cliente.setNome(clienteUpdated.getNome());
        cliente.setCpf(clienteUpdated.getCpf());
        cliente.setTelefone(clienteUpdated.getTelefone());

        clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
