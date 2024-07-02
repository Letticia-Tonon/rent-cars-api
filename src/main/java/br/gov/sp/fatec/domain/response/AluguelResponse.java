package br.gov.sp.fatec.domain.response;

import br.gov.sp.fatec.domain.entity.Carro;
import br.gov.sp.fatec.domain.entity.Cliente;
import br.gov.sp.fatec.domain.enums.AluguelStatus;

import java.util.Date;

public record AluguelResponse(Long id, Date dataInicio, Date dataFim, double valor, AluguelStatus status, Carro carro, Cliente cliente) {}
