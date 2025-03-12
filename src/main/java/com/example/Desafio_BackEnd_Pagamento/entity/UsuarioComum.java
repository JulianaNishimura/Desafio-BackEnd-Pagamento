package com.example.Desafio_BackEnd_Pagamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsuarioComum {
    private String nomeCompleto;

    @Id
    private String cpf;
    private String email;
    private String senha;
    private BigDecimal carteira;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public BigDecimal getCarteira() {
        return carteira;
    }

    public void setCarteira(BigDecimal carteira) {
        this.carteira = carteira;
    }
}
