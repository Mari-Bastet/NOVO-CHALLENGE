package fiap.br.challenge.domain;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name = "CLI_SEQ", sequenceName = "TB_CLIENTE_SEQ", allocationSize = 1)

public class Cliente {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLI_SEQ")
	@Column(name="ID_CLIENTE")
	private Long id;
	
	@NotNull
	@Size(min=2, max=255)
	private String nome;
	
	@Email
	private String email;
	
	@NotNull
	private Calendar data_nascimento;
	
	@NotNull
	private String endereco;
	
	
    @OneToMany(mappedBy = "cliente", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Compra> compras;
   
    public List<Compra> getCompras() {
    return compras;
     }
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Feedback> feedbacks;
    
    public List<Feedback> getFeedbacks(){
    	return feedbacks;
    }
    
	public Cliente() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @JsonFormat(pattern = "dd/MM/yyyy")
	public Calendar getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Calendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	};
	
}