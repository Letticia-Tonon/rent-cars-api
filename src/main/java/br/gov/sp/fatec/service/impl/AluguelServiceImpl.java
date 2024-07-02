package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        return aluguelMapper.map(aluguelRepository.save(aluguelMapper.map(aluguelRequest)));
    }

    @Override
    public AluguelResponse findById(Long id) {
        return aluguelMapper.map(
                aluguelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluguel com o id a seguir não foi encontrdo: " + id)));
    }

    @Override
    public List<AluguelResponse> findAll() {
        return aluguelRepository.findAll().stream().map(aluguelMapper::map).toList();
    }
    @Override
    public void updateById(Long id, AluguelUpdateRequest aluguelUpdateRequest) {
        Aluguel aluguelUpdated = aluguelMapper.map(aluguelUpdateRequest);
        Aluguel aluguel = aluguelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aluguel com o id a seguir não foi encontrdo: " + id));

        aluguel.setDataInicio(aluguelUpdated.getDataInicio());
        aluguel.setDataFim(aluguelUpdated.getDataFim());
        aluguel.setValor(aluguelUpdated.getValor());
        aluguel.setStatus(aluguelUpdated.getStatus());
        aluguel.setCarro(aluguelUpdated.getCarro());
        aluguel.setCliente(aluguelUpdated.getCliente());

        aluguelRepository.save(aluguel);
    }

    @Override
    public void deleteById(Long id) {
        aluguelRepository.deleteById(id);
    }
}
