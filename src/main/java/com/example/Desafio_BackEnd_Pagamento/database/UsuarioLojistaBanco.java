package com.example.Desafio_BackEnd_Pagamento.database;

import com.example.Desafio_BackEnd_Pagamento.model.UsuarioLojista;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLojistaBanco {
    private static UsuarioLojistaBanco instance;
    private List<UsuarioLojista> usuarioslojistas = new ArrayList<>();

    public static UsuarioLojistaBanco getInstance(){
        if (instance == null){
            instance = new UsuarioLojistaBanco();
        }
        return instance;
    }

    public void insertUsuarioLojista(UsuarioLojista ul){
        usuarioslojistas.add(ul);
    }

    public UsuarioLojista findOneUsuarioLojista(String cpf){
        for(UsuarioLojista ul : usuarioslojistas){
            if(ul.getCPF() == cpf){
                return ul;
            }
        }
        return  null;
    }

    public List<UsuarioLojista> findAllUsuarioLojista() {
        return new ArrayList<>(usuarioslojistas);
    }

    public boolean updateUsuarioLojista(UsuarioLojista ul){
        for(int i = 0; i < usuarioslojistas.size();i++){
            if(usuarioslojistas.get(i).getCPF() == ul.getCPF()){
                usuarioslojistas.set(i,ul);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUsuarioLojista(String cpf){
        return usuarioslojistas.removeIf(ul -> ul.getCPF() == cpf);
    }
}
