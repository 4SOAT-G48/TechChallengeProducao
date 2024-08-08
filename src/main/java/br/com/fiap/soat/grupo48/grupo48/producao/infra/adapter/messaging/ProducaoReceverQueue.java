package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducaoReceverQueue {

    @RabbitListener(queues = "${message.recever.producao.inicia-pedido.queues}")
    public void receiveIniciaPedido(String message) {
        log.info("Mensagem recebida da fila de produção: {}", message);
    }
}
