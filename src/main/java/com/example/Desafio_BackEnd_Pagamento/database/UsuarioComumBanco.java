package com.example.Desafio_BackEnd_Pagamento.database;

import com.example.Desafio_BackEnd_Pagamento.model.UsuarioComum;

import java.util.ArrayList;
import java.util.List;

public class UsuarioComumBanco {
    private static UsuarioComumBanco instance;
    private List<UsuarioComum> usuarioscomuns = new ArrayList<>();

    public static UsuarioComumBanco getInstance(){
        if (instance == null){
            instance = new UsuarioComumBanco();
        }
        return instance;
    }

    public void insertUsuarioComum(UsuarioComum uc){
        usuarioscomuns.add(uc);
    }

    public UsuarioComum findOneUsuarioComum(String cpf){
        for(UsuarioComum u : usuarioscomuns){
            if(u.getCPF() == cpf){
                return u;
            }
        }
        return  null;
    }

    public List<UsuarioComum> findAllUsuarioComum() {
        return new ArrayList<>(usuarioscomuns);
    }

    public boolean updateUsuarioComum(UsuarioComum u){
        for(int i = 0; i < usuarioscomuns.size();i++){
            if(usuarioscomuns.get(i).getCPF() == u.getCPF()){
                usuarioscomuns.set(i,u);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUsuarioComum(String cpf){
        return usuarioscomuns.removeIf(u -> u.getCPF() == cpf);
    }
}
