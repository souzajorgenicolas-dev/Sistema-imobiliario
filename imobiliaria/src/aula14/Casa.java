package aula14;

public class Casa extends Imovel {
	private int nrQuartos;
	private boolean garagem;
	private double iptu;
	
	@Override
	public double calcularValorFinal() {
		return getValor() + getIptu();
	}
	
	public Casa (Endereco endereco, double valor, double area, StatusImovel status, int nrQuartos, boolean garagem, double iptu) {
		super(endereco, valor, area, status);
		
		setNrQuartos(nrQuartos);
		setGaragem(garagem);
		setIptu(iptu);
		
	}
	
	public void setNrQuartos(int nrQuartos) {
		if (nrQuartos < 0) {
			throw new IllegalArgumentException("Numero de quartos inválido.");
		}
		
		this.nrQuartos = nrQuartos;
	}
	
	public int getNrQuartos() {
		return nrQuartos;
	}
	
	public void setGaragem(boolean garagem) {
		this.garagem = garagem;
	}
	
	public boolean isGaragem() {
		return garagem;
	}
	
	// posso deixar no imovel, PERGUNTAR AO PROFESSOR
	public void setIptu(double iptu) {
        if (iptu < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.iptu = iptu;
    }
	
	public double getIptu() {
        return iptu;
    }

	@Override
	public String toString() {
		return "===Casa=== [" + super.toString() + "Numero de Quartos=" + nrQuartos + ", garagem=" + garagem + ", iptu=" + iptu + "]\n";
	}
	
}
