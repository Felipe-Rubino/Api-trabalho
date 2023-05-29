package br.com.api.g3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.com.api.g3.domain.Produto;
import br.com.api.g3.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.mail.MessagingException;


@RestController
@RequestMapping("/produtos")
@SecurityScheme(
        name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
    )
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/listar")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Lista todos os Produtos - ADMIN", description = "Listagem de produtos")
	@ApiResponses( value = {
			@ApiResponse(responseCode= "200", description="Retorna todos os clientes"),
			@ApiResponse(responseCode= "401", description="Erro de autenticacao")
	})
	public Object listar() {
		return produtoService.findAll();
	}

	@GetMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Lista de Produtos por Id - ADMIN", description = "Lista produtos Id")
	public ResponseEntity<Produto> procurarId(@PathVariable Long id){
		Optional <Produto> opt = produtoService.findById(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		
		}
		return ResponseEntity.notFound().build();
	}


//	@PostMapping
//	public ResponseEntity<Object> create(@RequestBody Produto produto) {
//		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
//	}
	
	@PostMapping
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Cadastrar novo Produto - ADMIN", description = "Cadastro de produtos")
	public Object cadastrarCliente(@RequestParam String email, @RequestBody Produto produto) throws MessagingException {
		return produtoService.save(produto);
	}
	

	@PutMapping
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	
	@Operation( summary  = "Atualizar  Produto - ADMIN", description = "Atualização de produtos")
	public ResponseEntity<Object> update(@RequestBody Produto product) {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.update(product));
	}

	@DeleteMapping("/{id}")
	@SecurityRequirement(name="Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation( summary  = "Deletar Produto - ADMIN", description = "Delete de produtos")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
