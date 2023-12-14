package com.example.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.books.model.Livro;
import java.util.List;


public interface LivroRepository extends JpaRepository<Livro, Long>{

    /*Buscas por:
        - Titulo 
        - Autor
        - Ano
        - Editora
        - ISBN */

    List<Livro> findByTitulo(String titulo);
    List<Livro> findByAutor(String autor);
    List<Livro> findByAno(int ano);
    List<Livro> findByEditora(String editora);
    List<Livro> findByIsbn(String isbn);

}
