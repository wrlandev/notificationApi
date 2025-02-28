package com.wdev.agendamento_notificacao_api.infra.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.wdev.agendamento_notificacao_api.infra.enums.StatusModificacaoEnum;

import java.time.LocalDateTime;

@Table(name = "agendamento")
@Entity
@Getter
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
    private StatusModificacaoEnum statusModificacao;
}
