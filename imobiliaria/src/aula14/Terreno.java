package aula14;

public class Terreno extends Imovel {

	private TipoTerreno tipo;
	
	public Terreno(Endereco endereco, double valor, double area, StatusImovel status, TipoTerreno tipo) {
		super(endereco, valor, area, status);
		
		setTipo(tipo);
	}

	@Override
	public double calcularValorFinal() {
		return getValor() * 1.08;
	}
	
	public TipoTerreno getTipo() {
		return tipo;
	}

	public void setTipo(TipoTerreno tipo) {
		if (tipo == null) {
			throw new IllegalArgumentException("Tipo de terreno invalido");
		}
		
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "===Terreno=== [" + super.toString() + "tipo= " + tipo + "]\n";
	}	
}
