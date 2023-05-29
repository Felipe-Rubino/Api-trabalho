package br.com.api.g3.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Cliente;
import br.com.api.g3.dto.ClienteDTO;
import br.com.api.g3.repositories.ClienteRepository;
import br.com.api.g3.repositories.EnderecoRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	public Optional <Cliente> findById(Long id){
		return clienteRepository.findById(id);
		
	}
	public Cliente cadastrarCliente(ClienteDTO clienteDTO) {
			Cliente cliente = new Cliente();
			cliente.setNome(clienteDTO.getNome());
			cliente.setCpf(clienteDTO.getCpf());
			cliente.setEmail(clienteDTO.getEmail());
			
//			RestTemplate restTemplate = new RestTemplate();
//			String uri= "http://viacep.com.br/ws/{cep}/json";
//			Map<String, String> params = new HashMap<>();	
//			params.put("cep", clienteDTO.getCep());
//			Endereco endCadastro = restTemplate.getForObject(uri, Endereco.class, params);
//			Endereco endereco = new Endereco();
//			endereco.setBairro(endCadastro.getBairro());
//			endereco.setCep(clienteDTO.getCep());
//			endereco.setLocalidade(endCadastro.getLocalidade());
//			endereco.setLogradouro(endCadastro.getLogradouro());
//			endereco.setNumero(clienteDTO.getNumero());
//			endereco.setUf(endCadastro.getUf());
			//List<Endereco> enderecosCliente = new ArrayList<>();
			//cliente.setEndereco(enderecosCliente);
			cliente.CadastrarEndereco(enderecoService.buscaCep(clienteDTO.getCep()));
			enderecoService.adicionaEndereco(enderecoService.buscaCep(clienteDTO.getCep()));
			clienteRepository.save(cliente);
			return clienteRepository.save(cliente);
		}	
	public Cliente atualizarCliente(Cliente clienteAtualizado, Long id) {
		Optional<Cliente> opt = clienteRepository.findById(id);
		if(opt.isPresent()) {
			Cliente clienteAntigo = opt.get();
			clienteAntigo.setCpf(clienteAtualizado.getCpf());
			clienteAntigo.setEmail(clienteAtualizado.getEmail());
			clienteAntigo.setNome(clienteAtualizado.getNome());
			clienteAntigo.setClienteId(clienteAtualizado.getClienteId());

			clienteRepository.save(clienteAntigo);
		}
		return null;
	}
	public void deletarCliente(Long id) {
		Optional<Cliente> opt = clienteRepository.findById(id);
		if(opt.isPresent()) {
			Cliente cliente = opt.get();
			cliente.setAtivo(false);
			clienteRepository.save(cliente);

		}
	}
}	
