package com.example.Desafio_BackEnd_Pagamento.service;

import com.example.Desafio_BackEnd_Pagamento.entity.UsuarioComum;
import com.example.Desafio_BackEnd_Pagamento.entity.UsuarioLojista;
import com.example.Desafio_BackEnd_Pagamento.repository.UsuarioComumRepository;
import com.example.Desafio_BackEnd_Pagamento.repository.UsuarioLojistaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaService {
    @Autowired
    private UsuarioComumRepository usuarioComumRepository;

    @Autowired
    private UsuarioLojistaRepository usuarioLojistaRepository;

    @Transactional
    public String transferir(String payerCpf, String payeeCpf, BigDecimal valor) {
        if (usuarioLojistaRepository.existsById(payerCpf)) {
            return "Lojistas não podem enviar dinheiro.";
        }

        if(valor.compareTo(BigDecimal.ZERO) <= 0){
            return "O valor deve ser maior que 0";
        }

        UsuarioComum usuarioPagador = usuarioComumRepository.findById(payerCpf).orElse(null);
        UsuarioComum usuarioRecebe = usuarioComumRepository.findById(payeeCpf).orElse(null);
        UsuarioLojista lojistaRecebe = usuarioLojistaRepository.findByCpf(payeeCpf).orElse(null);

        if(usuarioPagador != null && (usuarioRecebe != null || lojistaRecebe != null)){
            if(usuarioPagador.getCarteira().compareTo(valor) < 0){
                return "Saldo insuficiente na conta";
            }

            usuarioPagador.setCarteira(usuarioPagador.getCarteira().subtract(valor));
            if(usuarioRecebe != null){
                usuarioRecebe.setCarteira(usuarioRecebe.getCarteira().add(valor));
                usuarioComumRepository.save(usuarioRecebe);
            } else {
                lojistaRecebe.setCarteira(lojistaRecebe.getCarteira().add(valor));
                usuarioLojistaRepository.save(lojistaRecebe);
            }

            usuarioComumRepository.save(usuarioPagador);
            return "Transferência realizada com sucesso!";
        }
        return "Usuários não encontrados.";
    }
}
