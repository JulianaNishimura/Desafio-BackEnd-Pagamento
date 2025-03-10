package com.example.Desafio_BackEnd_Pagamento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioLojista {
    private String nomeCompleto;
    private String CPF;
    private String email;
    private String senha;
    private Double carteira;

}
