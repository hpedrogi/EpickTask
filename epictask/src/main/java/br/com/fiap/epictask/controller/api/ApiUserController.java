package br.com.fiap.epictask.controller.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;

@Controller
public class ApiUserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/api/user")
	@ResponseBody
	public List<User> index(@RequestParam(required = false) String nome) {
		
		if(nome == null)
			return repository.findAll();
		
		return repository.findByNomeLike("%" + nome + "%");
	}
	
	@PostMapping("/api/user")
	@ResponseBody
	public ResponseEntity<User> create(@RequestBody User user, UriComponentsBuilder uriBuilder){
		repository.save(user);
		URI uri = uriBuilder
				.path("/api/user/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<User> delete(@PathVariable Long id){
		Optional<User> user = repository.findById(id);
		
		if(user.isEmpty())
			return ResponseEntity.notFound().build();
		
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
	}

}
