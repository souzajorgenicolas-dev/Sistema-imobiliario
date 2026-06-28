package aula14;

import java.util.Objects;

public class Cliente {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	
	public Cliente (String  nome, String cpf, String telefone, String email) {
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
	}
	
	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome inválido");
		}
		
		this.nome = nome.trim();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCpf(String cpf) {
		if (cpf == null) {
	        throw new IllegalArgumentException("CPF inválido.");
	    }
		
		cpf = cpf.replaceAll("\\D", "");

	    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
	        throw new IllegalArgumentException("CPF inválido.");
	    }

	    this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setTelefone(String telefone) {
		if (telefone == null) {
	        throw new IllegalArgumentException("Telefone inválido.");
	    }
		
		telefone = telefone.replaceAll("\\D", "");
		if (telefone.length() < 10 || telefone.length() > 11 || telefone.matches("(\\d)\\1{9,10}")) {
			    throw new IllegalArgumentException("Telefone inválido");
			}
		
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setEmail(String email) {
		if (email == null || email.trim().isEmpty() || !email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
			throw new IllegalArgumentException("E-mail inválido");
		}
		
		this.email = email.trim();
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Cliente \n[nome=" + nome + ",\ncpf=" + cpf + ",\ntelefone=" + telefone + ",\nemail=" + email + "]";
	}	
}