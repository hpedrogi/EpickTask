package br.com.fiap.epictask.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_TASK")
@SequenceGenerator(name = "task", sequenceName = "SQ_TB_TASK", allocationSize = 1)
public class Task {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task")
	private Long id;
	
	@NotBlank(message = "O título é obrigatório. Digite um título")
	private String title;
	
	@Size(min = 15, message = "A descrição deve ter pelo menos 15 caracteres")
	private String description;
	
	@Min(value = 10, message = "A pontuação mínima é 10")
	@Max(value = 500, message = "A pontuação máxima é 500")
	private int points;

}
