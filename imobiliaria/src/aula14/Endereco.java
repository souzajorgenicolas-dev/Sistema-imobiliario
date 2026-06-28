package aula14;

public class Endereco {
	
	String logradouro;
	int numero;
	String bairro;
	String cidade;
	
	public Endereco (String logradouro, int numero, String bairro, String cidade) {
		setLogradouro(logradouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
	
	}
	
	public void setLogradouro(String logradouro) {
			if (logradouro == null || logradouro.trim().isEmpty()) {
				throw new IllegalArgumentException("logradouro inválido");
			}
			
			this.logradouro = logradouro.trim();
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setNumero(int numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("Numero inválido");
		}
		
		this.numero = numero;
	
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setBairro(String bairro) {
		if (bairro == null || bairro.trim().isEmpty()) {
			throw new IllegalArgumentException("Bairro inválido");
		}
		
		this.bairro = bairro.trim();
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setCidade(String cidade) {
		if (cidade == null || cidade.trim().isEmpty()) {
			throw new IllegalArgumentException("Bairro inválido");
		}
		
		this.cidade = cidade.trim();
	}
	
	public String getCidade() {
		return cidade;
	}

	@Override
	public String toString() {
		return "\nlogradouro=" + logradouro + ",\nnumero=" + numero + ",\nbairro=" + bairro + ",\ncidade=" + cidade;
	}
	
	
}
