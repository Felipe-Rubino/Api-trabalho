package br.com.api.g3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g3.domain.Funcionario;
import br.com.api.g3.dto.FuncionarioDTO;
import br.com.api.g3.services.EmailService;
import br.com.api.g3.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	EmailService emailService;

	@GetMapping("/listar")
	@Operation( summary  = "Lista todos os vendedores ", description = "Listagem de vendedores")
	@ApiResponses( value = {
			@ApiResponse(responseCode= "200", description="Retorna todos os vendedores"),
			@ApiResponse(responseCode= "401", description="Erro de autenticacao")
	})
	public List<Funcionario> listar() {
		return funcionarioService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> procurarId(@PathVariable Long id){
		Optional <Funcionario> opt = funcionarioService.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping	
	public FuncionarioDTO cadastrarFuncionario(@Valid @RequestParam String email, @Valid @RequestBody Funcionario funcionario) throws MessagingException {
		emailService.envioEmailCadastroF(email, funcionario);
		return funcionarioService.cadastrarFuncionario(funcionario);
	}
	
	@PutMapping("/{id}")
	public Funcionario atualizarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		return funcionarioService.atualizarFuncionario(funcionario, id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarFuncionario(@PathVariable Long id) {
		funcionarioService.deletarFuncionario(id);
	
	}
}
