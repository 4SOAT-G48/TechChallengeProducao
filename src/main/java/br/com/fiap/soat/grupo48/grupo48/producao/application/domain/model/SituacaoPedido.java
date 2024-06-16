package br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model;

public enum SituacaoPedido {
    /**
     * A cozinha separou o pedido para
     * começar a montagem
     */
    EM_PREPARACAO,

    /**
     * A cozinha terminou a montagem e
     * passou para o atendente fazer a entrega
     */
    PRONTO,

    /**
     * O atendente passou o pedido para a
     * faze de entrega, o cliente pode vir buscar o pedido.
     */
    EM_ENTREGA,

    /**
     * pedido entregue ao cliente
     */
    FINALIZADO
}
