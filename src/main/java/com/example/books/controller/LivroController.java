package com.example.books.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.books.model.Livro;
import com.example.books.service.LivroService;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/livros")
public class LivroController {
    
    private final LivroService livroService;

    //@Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    //POST
    @PostMapping
    public ResponseEntity<Livro> addLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.saveLivro(livro);
        return ResponseEntity.ok(novoLivro);
    }

    //GET
    @GetMapping
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> livros = livroService.findAllLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        return livroService.findLivroById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateLivro(@PathVariable Long id, @RequestBody Livro novoLivro) {
        return livroService.updateLivro(id, novoLivro)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
}
