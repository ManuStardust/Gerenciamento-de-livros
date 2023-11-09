package com.example.cadLivros.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.cadLivros.entities.Livro;
import com.example.cadLivros.services.LivroService;



public class LivroControler {
	private final LivroService livroService;

	public LivroControler(LivroService livroService) {
		this.livroService = livroService;
	}

	@PostMapping
	public Livro createcadLivros(@RequestBody Livro livro) {
		return livroService.savecadLivros(livro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getLivro(@PathVariable Long id) {
		Livro Livro = livroService.getcadLivrosById(id);
		if (Livro != null) {
			return ResponseEntity.ok(Livro);
		} else {
			return ResponseEntity.notFound().build();

		}
	}

	@GetMapping("/home")
	public String paginaIicial() {
		return "index";
	}

	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Long id) {
		livroService.deletecadLivros(id);
	}

	@GetMapping
	public ResponseEntity<List<Livro>> getAllLivros(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Livro> livro = livroService.getAllcadLivros();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
		.body(livro);
	}

	@PutMapping("/{id}")
	public Livro updatelivro(@PathVariable Long id, @RequestBody Livro livros) {
		return livroService.updateLivro(id, livros);
	}


}
