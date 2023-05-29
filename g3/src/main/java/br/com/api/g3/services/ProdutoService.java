package br.com.api.g3.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Produto;
import br.com.api.g3.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public Object findAll() {
		// TODO Auto-generated method stub
		return produtoRepository.findAll();
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		 produtoRepository.deleteById(id);
		
	}

	public Object update(Produto produto) {
		// TODO Auto-generated method stub
		return produtoRepository.save(produto);
	}

	public Object save(Produto produto) {
		// TODO Auto-generated method stub
		return produtoRepository.save(produto);
	}

	public Optional<Produto> findById(Long id) {
		// TODO Auto-generated method stub
		return produtoRepository.findById(id);
	}
	
	
}
