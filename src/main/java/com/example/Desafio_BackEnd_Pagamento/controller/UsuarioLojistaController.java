package com.example.Desafio_BackEnd_Pagamento.controller;

import com.example.Desafio_BackEnd_Pagamento.entity.UsuarioLojista;
import com.example.Desafio_BackEnd_Pagamento.repository.UsuarioComumRepository;
import com.example.Desafio_BackEnd_Pagamento.repository.UsuarioLojistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuariosLojistas")
public class UsuarioLojistaController {
    @Autowired
    private UsuarioLojistaRepository ulRepository;

    @Autowired
    private UsuarioComumRepository ucRepository;

    @PostMapping("/add")
    public ResponseEntity<String> adicionarLojista(@RequestBody UsuarioLojista ul) {
        if(ulRepository.existsById(ul.getCnpj())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse CNPJ já está cadastrado.");
        }

        if(ulRepository.existsByCpf(ul.getCpf()) || ucRepository.existsById(ul.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse CPF já está cadastrado.");
        }

        if(ulRepository.existsByEmail(ul.getEmail()) || ucRepository.existsByEmail(ul.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse email já está cadastrado.");
        }

        ulRepository.save(ul);
        return ResponseEntity.status(HttpStatus.CREATED).body("Lojista adicionado com sucesso.");
    }

    @GetMapping("/get")
    public ResponseEntity<List<UsuarioLojista>> listarLojistas() {
        List<UsuarioLojista> lojistas = ulRepository.findAll();
        if (lojistas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(lojistas);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<String> atualizarLojista(@PathVariable String cnpj, @RequestBody UsuarioLojista ul) {
        if (!ulRepository.existsById(cnpj)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lojista não encontrado.");
        }

        ul.setCnpj(cnpj);
        ulRepository.save(ul);
        return ResponseEntity.status(HttpStatus.OK).body("Lojista atualizado com sucesso.");
    }

    @DeleteMapping("/deletar/{cnpj}")
    public ResponseEntity<String> deletarLojista(@PathVariable String cnpj) {
        if (!ulRepository.existsById(cnpj)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lojista não encontrado.");
        }

        ulRepository.deleteById(cnpj);
        return ResponseEntity.status(HttpStatus.OK).body("Lojista deletado com sucesso.");
    }
}
