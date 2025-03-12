package com.example.Desafio_BackEnd_Pagamento.controller;

import com.example.Desafio_BackEnd_Pagamento.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    @Autowired
    private TransferenciaService trservice;

    @PostMapping
    public String transferirDinheiro(@RequestParam String pagadorCpf, @RequestParam String recebedorCpfCnpj, @RequestParam BigDecimal valor){
        return trservice.transferir(pagadorCpf,recebedorCpfCnpj,valor);
    }
}
