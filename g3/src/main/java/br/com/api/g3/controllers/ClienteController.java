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

import br.com.api.g3.domain.Cliente;
import br.com.api.g3.dto.ClienteDTO;
import br.com.api.g3.services.ClienteService;
import br.com.api.g3.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	EmailService emailService;

	@GetMapping("/listar")
	@Operation( summary  = "Lista todos os clientes ", description = "Listagem de clientes")
	@ApiResponses( value = {
			@ApiResponse(responseCode= "200", description="Retorna todos os clientes"),
			@ApiResponse(responseCode= "401", description="Erro de autenticacao")
	})
	public List<Cliente> listar() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> procurarId(@PathVariable Long id){
		Optional <Cliente> opt = clienteService.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		
		}
		return ResponseEntity.notFound().build();
	}
	@PostMapping
	public Cliente cadastrarCliente(@RequestParam String email, @RequestBody ClienteDTO clienteDTO) throws MessagingException {
		emailService.envioEmailCadastroC(email, clienteDTO);
		return clienteService.cadastrarCliente(clienteDTO);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.atualizarCliente(cliente, id);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
	
	}
	
	
	
	
	
}
