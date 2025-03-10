package com.wdev.agendamento_notificacao_api.services;

import com.wdev.agendamento_notificacao_api.Exception.NotFoundException;
import com.wdev.agendamento_notificacao_api.controller.dto.AgendamentoRecord;
import com.wdev.agendamento_notificacao_api.controller.dto.AgendamentoRecordOut;
import com.wdev.agendamento_notificacao_api.infra.entities.Agendamento;
import com.wdev.agendamento_notificacao_api.infra.repositories.AgendamentoRepository;
import com.wdev.agendamento_notificacao_api.services.mapper.IAgendamentoMapper;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoService(AgendamentoRepository repository, IAgendamentoMapper agendamentoMapper) {
        this.repository = repository;
        this.agendamentoMapper = agendamentoMapper;
    }

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
        return agendamentoMapper.paraOut(
                repository.save(
                        agendamentoMapper.paraEntity(agendamento)));
    }

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id){
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrador")));
    }

    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrador"));
        repository.save(
                agendamentoMapper.paraEntityCancelamento(agendamento)
        );
    }

}
