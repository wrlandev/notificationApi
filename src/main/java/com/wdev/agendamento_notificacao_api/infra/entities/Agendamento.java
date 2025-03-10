package com.wdev.agendamento_notificacao_api.infra.entities;

import com.wdev.agendamento_notificacao_api.infra.enums.StatusNotificacaoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "agendamento")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String EmailDestinatario;
    private String telefoneDestinatario;
    private LocalDateTime dataHoraEnvio;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime dataHoraModificacao;
    private String mensagem;
    private StatusNotificacaoEnum statusNotificacao;

    public Long getId() {
        return id;
    }

    public String getEmailDestinatario() {
        return EmailDestinatario;
    }

    public String getTelefoneDestinatario() {
        return telefoneDestinatario;
    }

    public LocalDateTime getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public LocalDateTime getDataHoraModificacao() {
        return dataHoraModificacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public StatusNotificacaoEnum getStatusNotificacao() {
        return statusNotificacao;
    }

    @PrePersist
    private void prePersist(){
        dataHoraAgendamento = LocalDateTime.now();
        statusNotificacao = StatusNotificacaoEnum.AGENDADO;
    }
}
