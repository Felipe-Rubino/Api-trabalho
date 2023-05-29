package br.com.api.g3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Produto;
import br.com.api.g3.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> findAll(){
        return produtoRepository.findAll();
    }


    public Optional <Produto> findById(Long id){
        return produtoRepository.findById(id);

    }

    public Produto cadastrarProduto(Produto produto) {

           return produtoRepository.save(produto);
        }


    public Produto atualizarProduto(Produto produtoAtualizado, Long id) {
        Optional<Produto> opt = produtoRepository.findById(id);
        if(opt.isPresent()) {
            Produto produtoAntigo = opt.get();
            produtoAntigo.setNome(produtoAtualizado.getNome());
            produtoAntigo.setDescricao(produtoAtualizado.getDescricao());
            produtoAntigo.setValor(produtoAtualizado.getValor());
            produtoRepository.save(produtoAntigo);
        }
        return null;
    }

    public void deleteById(Long id) {
    	// TODO Auto-generated method stub
    	produtoRepository.deleteById(id);

        }
    }
