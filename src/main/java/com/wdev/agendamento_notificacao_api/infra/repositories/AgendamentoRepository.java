package com.wdev.agendamento_notificacao_api.infra.repositories;

import com.wdev.agendamento_notificacao_api.infra.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
