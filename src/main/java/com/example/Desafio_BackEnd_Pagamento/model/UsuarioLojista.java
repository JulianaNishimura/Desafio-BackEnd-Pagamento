package com.example.Desafio_BackEnd_Pagamento.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLojista {
    private String nomeCompleto;
    private Long cnpj;
    private String email;
    private String senha;
    private Double carteira;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
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

    public Double getCarteira() {
        return carteira;
    }

    public void setCarteira(Double carteira) {
        this.carteira = carteira;
    }
}
