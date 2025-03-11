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

    public UsuarioLojista findOneUsuarioLojista(String cnpj){
        for(UsuarioLojista ul : usuarioslojistas){
            if(ul.getCnpj().equals(cnpj)){
                return ul;
            }
        }
        return  null;

//        ou
//        return usuariosLojistas.stream()
//                .filter(ul -> ul.getCnpj().equals(cnpj))
//                .findFirst()
//                .orElse(null);
    }

    public List<UsuarioLojista> findAllUsuarioLojista() {
        return new ArrayList<>(usuarioslojistas);
    }

    public boolean updateUsuarioLojista(UsuarioLojista ul){
        for(int i = 0; i < usuarioslojistas.size();i++){
            if(usuarioslojistas.get(i).getCnpj().equals(ul.getCnpj())){
                usuarioslojistas.set(i,ul);
                return true;
            }
        }
        return false;

//        ou
//        Optional<Integer> indexOpt =
//                usuariosLojistas.stream()
//                        .filter(u -> u.getCnpj().equals(ul.getCnpj()))
//                        .map(usuariosLojistas::indexOf)
//                        .findFirst();
//
//        indexOpt.ifPresent(index -> usuariosLojistas.set(index, ul));
//        return indexOpt.isPresent();
    }

    public boolean deleteUsuarioLojista(String cnpj){
        return usuarioslojistas.removeIf(ul -> ul.getCnpj().equals(cnpj));
    }
}
