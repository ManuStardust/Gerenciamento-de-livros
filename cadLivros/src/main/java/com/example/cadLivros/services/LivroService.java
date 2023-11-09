package com.example.cadLivros.services;

import java.util.List;
import java.util.Optional;

import com.example.cadLivros.entities.Livro;
import com.example.cadLivros.repositori.LivroRepository;




public class LivroService {
	
	private final LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	//para criar um novo livro
	public Livro savecadLivros(Livro cadLivros) {
		return livroRepository.save(cadLivros);
	}
	//pesquuisar todos os livros
	public List<Livro> getAllcadLivros() {
		return livroRepository.findAll();
	}
	//pesquisar pelo id
	public Livro getcadLivrosById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}
	//deletar pelo id
	public void deletecadLivros(Long id) {
		livroRepository.deleteById(id);
	}
	//atualizar pelo id
	
	public Livro updateLivro(Long id, Livro novoLivro) {
		Optional<Livro> livroOptional = livroRepository.findById(id);
		if (livroOptional.isPresent()) {
			Livro livroExistente = livroOptional.get();
			livroExistente.setDescricao(novoLivro.getDescricao());
			livroExistente.setIsbn(novoLivro.getIsbn());
			return livroRepository.save(livroExistente);
		} else {
			return null;
		}
	}

}
