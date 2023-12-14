package com.example.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.books.model.RegistroLeitura;

public interface RegistroLeituraRepository extends JpaRepository<RegistroLeitura, Long>{
    
}
