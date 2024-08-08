package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.messaging;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducaoRabbitMQConfig {

    @Value("${message.recever.exchange}")
    private String producaoExchange;

    @Value("${message.recever.inicia-pedido.route-key}")
    private String producaoIniciaPedidoRoutekey;

    @Value("${message.recever.inicia-pedido.queues}")
    private String producaoIniciaPedidoQueue;


    @Bean
    public DirectExchange producaoExchange() {
        return new DirectExchange(producaoExchange);
    }

    @Bean
    public Queue producaoIniciaPedidoQueue() {
        return new Queue(producaoIniciaPedidoQueue, true);
    }

    @Bean
    public Binding producaoIniciaPedidoBinding() {
        return BindingBuilder.bind(producaoIniciaPedidoQueue()).to(producaoExchange()).with(producaoIniciaPedidoRoutekey);
    }
}
