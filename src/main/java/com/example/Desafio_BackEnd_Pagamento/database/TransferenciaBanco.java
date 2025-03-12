package com.example.Desafio_BackEnd_Pagamento.database;

import com.example.Desafio_BackEnd_Pagamento.model.Transferencia;
import java.util.ArrayList;
import java.util.List;

public class TransferenciaBanco {
    private static TransferenciaBanco instance;
    private List<Transferencia> transferencias = new ArrayList<>();

    public static TransferenciaBanco getInstance(){
        if (instance == null){
            instance = new TransferenciaBanco();
        }
        return instance;
    }

    public void insertTransferencia(Transferencia transf){
        transferencias.add(transf);
    }

    public Transferencia findOneTransferencia(Long id){
        for(Transferencia transf : transferencias){
            if(transf.getId().equals(id)){
                return transf;
            }
        }
        return  null;
    }

    public List<Transferencia> findAllTransferencia() {
        return new ArrayList<>(transferencias);
    }

    public boolean updateTransferencia(Transferencia transf){
        for(int i = 0; i < transferencias.size();i++){
            if(transferencias.get(i).getId().equals(transf.getId())){
                transferencias.set(i,transf);
                return true;
            }
        }
        return false;
    }

    public boolean deletetransf(Long id){
        return transferencias.removeIf(transf -> transf.getId().equals(id));
    }
}
