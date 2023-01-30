package com.algaworks.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.crm.model.Client;
import com.algaworks.crm.repository.ClientRepository;

@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> List() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Client> Get(@PathVariable Long id) {
		return clientRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client Insert(@RequestBody Client cliente) {
		return clientRepository.save(cliente);
	}
	
	@PutMapping
	public Client Update(@RequestBody Client cliente) {
		Client clientUpdate = clientRepository.getById(cliente.getId());
		clientUpdate.setNome(cliente.getNome());
		return clientRepository.save(clientUpdate);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
	}
}
