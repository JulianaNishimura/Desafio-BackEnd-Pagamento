package com.example.Desafio_BackEnd_Pagamento.repository;

import com.example.Desafio_BackEnd_Pagamento.entity.UsuarioComum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, String> {
    boolean existsByEmail(String email);
}
