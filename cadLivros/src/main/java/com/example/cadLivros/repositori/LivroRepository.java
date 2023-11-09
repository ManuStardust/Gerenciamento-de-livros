package com.example.cadLivros.repositori;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cadLivros.entities.Livro;


public interface LivroRepository extends JpaRepository<Livro, Long> {

}
