package com.example.Desafio_BackEnd_Pagamento.controller;

import com.example.Desafio_BackEnd_Pagamento.entity.UsuarioComum;
import com.example.Desafio_BackEnd_Pagamento.repository.UsuarioComumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuariosComuns")
public class UsuarioComumController {
    @Autowired
    private UsuarioComumRepository ucRepository;

    @PostMapping("/add")
    public ResponseEntity<String> adicionarUsuarioComum(@RequestBody UsuarioComum uc) {
        if(ucRepository.existsById(uc.getCPF())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse CPF já está cadastrado.");
        }

        if(ucRepository.existsByEmail(uc.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse email já está cadastrado.");
        }

        ucRepository.save(uc);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário adicionado com sucesso.");
    }

    @GetMapping("/get")
    public ResponseEntity<List<UsuarioComum>> listarUsuariosComuns() {
        List<UsuarioComum> usuarios = ucRepository.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<String> atualizarUsuarioComum(@PathVariable String cpf, @RequestBody UsuarioComum uc) {
        if (!ucRepository.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

        uc.setCPF(cpf);
        ucRepository.save(uc);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário atualizado com sucesso.");
    }

    @DeleteMapping("/deletar/{cpf}")
    public ResponseEntity<String> deletarUsuarioComum(@PathVariable String cpf) {
        if (!ucRepository.existsById(cpf)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        ucRepository.deleteById(cpf);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso.");
    }
}
