package com.example.Desafio_BackEnd_Pagamento.controller;

import com.example.Desafio_BackEnd_Pagamento.database.UsuarioLojistaBanco;
import com.example.Desafio_BackEnd_Pagamento.model.UsuarioLojista;
import java.util.List;

public class UsuarioLojistaController {
    UsuarioLojistaBanco banco = UsuarioLojistaBanco.getInstance();

    public List<UsuarioLojista> listarUsuariosLojistas(){
        return banco.findAllUsuarioLojista();
    }

    public boolean postarUsuarioLojista(UsuarioLojista ul){
        banco.insertUsuarioLojista(ul);
        return true;
    }

    public boolean atualizarUsuarioLojista(UsuarioLojista ul){
        return banco.updateUsuarioLojista(ul);
    }

    public boolean deletarUsuarioLojista(String cpf){
        return banco.deleteUsuarioLojista(cpf);
    }
}
