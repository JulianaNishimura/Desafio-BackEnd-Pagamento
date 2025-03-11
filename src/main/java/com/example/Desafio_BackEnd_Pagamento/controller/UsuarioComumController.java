package com.example.Desafio_BackEnd_Pagamento.controller;

import com.example.Desafio_BackEnd_Pagamento.database.UsuarioComumBanco;
import com.example.Desafio_BackEnd_Pagamento.model.UsuarioComum;
import com.example.Desafio_BackEnd_Pagamento.model.UsuarioLojista;

import java.util.List;

public class UsuarioComumController {
    UsuarioComumBanco banco = UsuarioComumBanco.getInstance();

    public List<UsuarioComum> listarUsuariosComuns(){
        return banco.findAllUsuarioComum();
    }

    public boolean postarUsuarioComum(UsuarioComum uc){
        List<UsuarioComum> usuariosco = banco.findAllUsuarioComum();

        if(banco.findOneUsuarioComum(uc.getCPF()) != null){
            return false;
        }

        for(UsuarioComum u : usuariosco){
            if(u.getEmail().equals(uc.getEmail())){
                return false;
            }
        }

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
