package br.senai.sp.odonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_dentista")
public class Dentista {

@Override
	public String toString() {
		return "Dentista [codigo=" + codigo + ", nome=" + nome + ", cro=" + cro + ", telefone=" + telefone + ", email="
				+ email + "]";
	}

	// Boa prática
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
//	Define que não pode ser nulo
	@NotNull
//	Passa os padrão de tamanho
	@Size(min = 3, max = 100, message = "tenha paciência e coloque o nome entre 3 a 100 letras, obrigado")
	private String nome;
	
	private String cro;
	private String telefone;
	private String email;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}