package com.wdev.agendamento_notificacao_api.services.mapper;

import com.wdev.agendamento_notificacao_api.controller.dto.AgendamentoRecord;
import com.wdev.agendamento_notificacao_api.controller.dto.AgendamentoRecordOut;
import com.wdev.agendamento_notificacao_api.infra.entities.Agendamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "SPRING")
public interface IAgendamentoMapperr {

    Agendamento paraEntity(AgendamentoRecord agendamento);

    AgendamentoRecordOut paraDto(Agendamento agendamento);
}
