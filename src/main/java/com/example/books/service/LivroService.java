package com.example.books.service;

import java.util.List;
import java.util.Optional;

import com.example.books.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.books.repository.LivroRepository;

public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}