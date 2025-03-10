package com.example.Desafio_BackEnd_Pagamento.view;

import com.example.Desafio_BackEnd_Pagamento.controller.UsuarioLojistaController;
import com.example.Desafio_BackEnd_Pagamento.model.UsuarioLojista;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarioslojistas")
public class EndpointUsuarioLojista {
    UsuarioLojistaController c = new UsuarioLojistaController();

    @GetMapping
    public List<UsuarioLojista> getInformationsUsuariosLojistas(){
        return c.listarUsuariosLojistas();
    }

    @PostMapping
    public String postInformationsUsuariosLojistas(@RequestBody UsuarioLojista ul){
        if(c.postarUsuarioLojista(ul)){
            return "Sucesso ao cadastrar";
        }
        return "Falha ao cadastrar";
    }

    @PutMapping
    public String putInformationsUsuariosLojistas(@RequestBody UsuarioLojista ul){
        if(c.atualizarUsuarioLojista(ul)){
            return "Sucesso ao atualizar!";
        } else {
            return "Falha ao atualizar...";
        }
    }

    @DeleteMapping("/{cpf}")
    public String deleteInformationsUsuariosLojistas(@RequestParam String cpf){
        if(c.deletarUsuarioLojista(cpf)){
            return "Deletado com sucesso";
        } else {
            return "Falha ao deletar...";
        }
    }
}
