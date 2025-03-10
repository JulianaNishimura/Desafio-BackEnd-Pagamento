package com.example.Desafio_BackEnd_Pagamento.controller;

import com.example.Desafio_BackEnd_Pagamento.database.UsuarioComumBanco;
import com.example.Desafio_BackEnd_Pagamento.model.UsuarioComum;
import java.util.List;

public class UsuarioComumController {
    UsuarioComumBanco banco = UsuarioComumBanco.getInstance();

    public List<UsuarioComum> listarUsuariosComuns(){
        return banco.findAllUsuarioComum();
    }

    public boolean postarUsuarioComum(UsuarioComum uc){
        banco.insertUsuarioComum(uc);
        return true;
    }

    public boolean atualizarUsuarioComum(UsuarioComum ul){
        return banco.updateUsuarioComum(ul);
    }

    public boolean deletarUsuarioComum(String cpf){
        return banco.deleteUsuarioComum(cpf);
    }
}
