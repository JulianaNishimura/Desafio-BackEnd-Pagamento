package com.example.Desafio_BackEnd_Pagamento.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class Transferencia {

    private Long id;

    private UsuarioComum pagador;

    private Long recebedorId;

    private BigDecimal valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioComum getPagador() {
        return pagador;
    }

    public void setPagador(UsuarioComum pagador) {
        this.pagador = pagador;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getRecebedorId() {
        return recebedorId;
    }

    public void setRecebedorId(Long recebedorId) {
        this.recebedorId = recebedorId;
    }
}
