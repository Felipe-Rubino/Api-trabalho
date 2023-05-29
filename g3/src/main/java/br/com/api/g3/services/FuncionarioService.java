package br.com.api.g3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.g3.domain.Funcionario;
import br.com.api.g3.dto.FuncionarioDTO;
import br.com.api.g3.repositories.FuncionarioRepository;
@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	
	public List<Funcionario> findAll(Pageable page){ 
		return funcionarioRepository.findAll(page).getContent();// repository do JPA .getContent 
	}
	
	
	public Optional <Funcionario> findById(Long id){
		return funcionarioRepository.findById(id);
		
	}
	
	public FuncionarioDTO cadastrarFuncionario(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = parseEntity(funcionarioDTO);
		funcionarioRepository.save(funcionario);
		return parseDTO(funcionario);
	}
	
	public FuncionarioDTO parseDTO(Funcionario funcionario) {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		funcionarioDTO.setFuncionarioId(funcionario.getFuncionarioId());
		funcionarioDTO.setNome(funcionario.getNome());
		funcionarioDTO.setEmail(funcionario.getEmail());
		funcionarioDTO.setAtivo(funcionario.isAtivo());
		return funcionarioDTO;
	}
	
	public Funcionario parseEntity(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionario = new Funcionario();
		funcionario.setEmail(funcionarioDTO.getEmail());
		funcionario.setNome(funcionarioDTO.getNome());
		funcionario.setAtivo(funcionarioDTO.isAtivo());
		return funcionario;
	}
	
	
	public Funcionario atualizarFuncionario(Funcionario funcionarioAtualizado, Long id) {
		Optional<Funcionario> opt = funcionarioRepository.findById(id);
		if(opt.isPresent()) {
			Funcionario funcionarioAntigo = opt.get();
			funcionarioAntigo.setNome(funcionarioAtualizado.getNome());
			funcionarioAntigo.setEmail(funcionarioAtualizado.getEmail());
			
			funcionarioRepository.save(funcionarioAntigo);
		}
		return null;
	}
	
	public void deletarFuncionario(Long id) {
		Optional<Funcionario> opt = funcionarioRepository.findById(id);
		if(opt.isPresent()) {
			Funcionario funcionario = opt.get();
			funcionario.setAtivo(false);
			funcionarioRepository.save(funcionario);

		}
	}
}
