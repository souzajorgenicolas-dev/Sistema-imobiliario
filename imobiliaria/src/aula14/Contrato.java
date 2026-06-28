package aula14;

public class Contrato {

	private Cliente cliente;
	private Imovel imovel;
	private String tipoContrato;
	private double valorAcordado;
	
	public Contrato(Cliente cliente, Imovel imovel, String tipoContrato, double valorAcordado) {
			
		setCliente(cliente);
		setImovel(imovel);
		setTipoContrato(tipoContrato);
		setValorAcordado(valorAcordado);
	}
	
	public String emitirContrato() {
		return  "Tipo de Contrato: " + tipoContrato +
				"\nCliente: " + cliente.getNome() +
				"\nCódigo do Imóvel: " + imovel.getCod() +
				"\nValor Acordado: R$ " + valorAcordado;
		    }
    
	public Cliente getCliente() { 
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new IllegalArgumentException("Cliente invalido!");
		}
		
		this.cliente = cliente;
	} 
	
	public Imovel getImovel() {
		return imovel;
	}
	
	public void setImovel(Imovel imovel) {
		if (imovel == null) {
			throw new IllegalArgumentException("Imovel invalido!");
		}
		this.imovel = imovel;
	}
	
	public String getTipoContrato() {
		return tipoContrato;
	}
	
	public void setTipoContrato(String tipoContrato) {
		if (tipoContrato == null || tipoContrato.trim().isEmpty()) {
			throw new IllegalArgumentException("Tipo de contrato invalido!");
		}
		
		if (!tipoContrato.equalsIgnoreCase("Venda") && !tipoContrato.equalsIgnoreCase("Aluguel")) {
		    throw new IllegalArgumentException("Tipo de contrato invalido!");
		}
		
		this.tipoContrato = tipoContrato;
    }
	
	public double getValorAcordado() {
		return valorAcordado;
	}

	public void setValorAcordado(double valorAcordado) {
		if (valorAcordado <= 0) {
			throw new IllegalArgumentException("Valor invalido!");
		}
		
		this.valorAcordado = valorAcordado;
	}

	@Override
	public String toString() {
		return emitirContrato();
	}

}
