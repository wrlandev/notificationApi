package com.wdev.agendamento_notificacao_api.config;

import com.wdev.agendamento_notificacao_api.controller.dto.AgendamentoRecord;
import com.wdev.agendamento_notificacao_api.controller.dto.AgendamentoRecordOut;
import com.wdev.agendamento_notificacao_api.infra.entities.Agendamento;
import com.wdev.agendamento_notificacao_api.infra.enums.StatusNotificacaoEnum;
import com.wdev.agendamento_notificacao_api.services.mapper.IAgendamentoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class MapperConfig {

    @Bean
    public IAgendamentoMapper agendamentoMapper() {
        return new IAgendamentoMapper() {
            @Override
            public Agendamento paraEntity(AgendamentoRecord agendamento) {
                return Agendamento.builder()
                        .EmailDestinatario(agendamento.emailDestinatario())
                        .telefoneDestinatario(agendamento.telefoneDestinatario())
                        .mensagem(agendamento.mensagem())
                        .dataHoraEnvio(agendamento.dataHoraEnvio())
                        .build();
            }

            @Override
            public AgendamentoRecordOut paraOut(Agendamento agendamento){
                return new AgendamentoRecordOut(
                        agendamento.getId(),
                        agendamento.getEmailDestinatario(),
                        agendamento.getTelefoneDestinatario(),
                        agendamento.getMensagem(),
                        agendamento.getDataHoraEnvio(),
                        agendamento.getStatusNotificacao()

                );
            }

            @Override
            public Agendamento paraEntityCancelamento(Agendamento agendamento) {
                agendamento.setDataHoraModificacao(LocalDateTime.now());
                agendamento.setStatusNotificacao(StatusNotificacaoEnum.CANCELADO);
                return agendamento;
            }
        };
    }
}