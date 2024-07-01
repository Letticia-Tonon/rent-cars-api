package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.ClienteController;
import br.gov.sp.fatec.domain.request.ClienteRequest;
import br.gov.sp.fatec.domain.request.ClienteUpdateRequest;
import br.gov.sp.fatec.domain.response.ClienteResponse;
import br.gov.sp.fatec.service.ClienteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteControllerImpl implements ClienteController {

    private final ClienteService clienteService;

    @Override
    public ResponseEntity<ClienteResponse> save(ClienteRequest cliente) {
        return ResponseEntity.ok(clienteService.save(cliente));
    }

    @Override
    public ResponseEntity<ClienteResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateById(Long id, ClienteUpdateRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return null;
    }
}
