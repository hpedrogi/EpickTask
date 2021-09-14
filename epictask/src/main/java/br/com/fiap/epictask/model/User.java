package br.com.fiap.epictask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_USER")
@SequenceGenerator(name = "user", sequenceName = "SQ_TB_USER", allocationSize = 1)
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
	private Long id;
	@NotBlank(message = "O nome é obrigatório. Digite um nome")
	private String nome;
	@NotBlank(message = "O email é obrigatório. Digite um email")
	private String email;
	@Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
	private String senha;

}
