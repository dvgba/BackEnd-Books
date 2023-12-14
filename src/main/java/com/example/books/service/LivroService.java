package com.example.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.books.model.Livro;
//import org.springframework.beans.factory.annotation.Autowired;

import com.example.books.repository.LivroRepository;
@Service
public class LivroService {
    
    private final LivroRepository livroRepository;

    //@Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> findAllLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void deleteLIvro(Long id) {
        livroRepository.deleteById(id);
    }
    //Métodos para buscar por título
    public List<Livro> findLivrosByTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }
    //Métodos para buscar por Autor
    public List<Livro> findLivrosByAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }
    //Métodos para buscar por Ano
    public List<Livro> findLivrosByAno(int ano) {
        return livroRepository.findByAno(ano);
    }

    //Métodos para buscar por Ano
    public List<Livro> findLivrosByEditora(String editora) {
        return livroRepository.findByEditora(editora);
    }

    //Métodos para buscar por ISBN
    public List<Livro> findLivrosByIsbn(String isbn) {
        return livroRepository.findByIsbn(isbn);
    }

    //Metodo Update 
    public Optional<Object> updateLivro(Long id, Livro novoLivro) {
        return livroRepository.findById(id)
                .map(livroExistente -> {
                    livroExistente.setTitulo(novoLivro.getTitulo());
                    livroExistente.setAutor(novoLivro.getAutor());
                    livroExistente.setEditora(novoLivro.getEditora());
                    livroExistente.setAno(novoLivro.getAno());
                    livroExistente.setIsbn(novoLivro.getIsbn());
                    return Optional.of(livroRepository.save(livroExistente));
                });
    }

}