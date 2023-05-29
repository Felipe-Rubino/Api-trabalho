package br.com.api.g3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.api.g3.domain.Endereco;
import br.com.api.g3.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	public List<Endereco> listaEndereco() {
		return enderecoRepository.findAll();
	}

	public Endereco buscaEndereco(Long id) {
		return enderecoRepository.findById(id).get();
	}

	public Endereco adicionaEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
		return endereco;
	}
	public Endereco alteraEndereco(Long id, Endereco endereco) {
        Endereco enderecoNovo = enderecoRepository.findById(id).get();
        enderecoNovo.setCep(endereco.getCep());
        enderecoNovo.setLogradouro(endereco.getLogradouro());
        enderecoNovo.setNumero(endereco.getLocalidade());
        enderecoNovo.setBairro(endereco.getBairro());
        enderecoNovo.setLocalidade(endereco.getLocalidade());
        enderecoNovo.setUf(endereco.getUf());
        enderecoNovo.setClientes(endereco.getClientes());
        enderecoRepository.saveAndFlush(enderecoNovo);
        return enderecoNovo;
    }
	
	public Endereco buscaCep (String Cep) {
		
		
		RestTemplate restTemplate = new RestTemplate();
		String uri= "http://viacep.com.br/ws/{cep}/json";
		Map<String, String> params = new HashMap<>();	
		params.put("cep",Cep );
		Endereco endCadastro = restTemplate.getForObject(uri, Endereco.class, params);
		Endereco endereco = new Endereco();
		endereco.setBairro(endCadastro.getBairro());
		endereco.setCep(Cep);
		endereco.setLocalidade(endCadastro.getLocalidade());
		endereco.setLogradouro(endCadastro.getLogradouro());
		//endereco.setNumero(clienteDTO.getNumero());
		endereco.setUf(endCadastro.getUf()); 
		return endereco;	
	}

}
