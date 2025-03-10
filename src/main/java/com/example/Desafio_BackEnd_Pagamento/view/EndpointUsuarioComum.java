package com.example.Desafio_BackEnd_Pagamento.view;

import com.example.Desafio_BackEnd_Pagamento.controller.UsuarioComumController;
import com.example.Desafio_BackEnd_Pagamento.model.UsuarioComum;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarioscomuns")
public class EndpointUsuarioComum {

    UsuarioComumController c = new UsuarioComumController();

    @GetMapping
    public List<UsuarioComum> getInformationsUsuariosComuns(){
        return c.listarUsuariosComuns();
    }

    @PostMapping
    public String postInformationsUsuariosComuns(@RequestBody UsuarioComum uc){
        c.postarUsuarioComum(uc);
        return "Sucesso ao cadastrar";
    }

    @PutMapping
    public String putInformationsUsuariosComuns(@RequestBody UsuarioComum uc){
        if(c.atualizarUsuarioComum(uc)){
            return "Sucesso ao atualizar!";
        } else {
            return "Falha ao atualizar...";
        }
    }

    @DeleteMapping("/{cpf}")
    public String deleteInformationsUsuariosLojistas(@RequestParam String cpf){
        if(c.deletarUsuarioComum(cpf)){
            return "Deletado com sucesso";
        } else {
            return "Falha ao deletar...";
        }
    }
}
