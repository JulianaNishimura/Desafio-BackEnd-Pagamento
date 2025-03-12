package com.example.Desafio_BackEnd_Pagamento.repository;

import com.example.Desafio_BackEnd_Pagamento.entity.UsuarioLojista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioLojistaRepository extends JpaRepository<UsuarioLojista,String> {
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    Optional<UsuarioLojista> findByCpf(String cpf);
}
