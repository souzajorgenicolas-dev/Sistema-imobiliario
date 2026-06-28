package aula14;

import java.util.Objects;

public abstract class Imovel implements Calculavel {
	
	//atributo STATIC para fazer a contagem, ele faz com q o valor pertenca a classe, e nao aos objetos, estabelecendo a contagem
	private static int proximoCodigo = 1;
	
    private int cod;
    private Endereco endereco;
    private double valor;
    private double area;
    private StatusImovel status;

    public Imovel(Endereco endereco, double valor, double area, StatusImovel status) {

        this.cod = proximoCodigo++;
        
        setEndereco(endereco);
        setValor(valor);
        setArea(area);
        setStatus(status);
        
    }

    public int getCod() {
        return cod;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço inválido.");
        }

        this.endereco = endereco;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido.");
        }

        this.valor = valor;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        if (area <= 0) {
            throw new IllegalArgumentException("Área inválida.");
        }

        this.area = area;
    }

    public StatusImovel getStatus() {
        return status;
    }

    public void setStatus(StatusImovel status) {
        if (status == null) {
            throw new IllegalArgumentException("Status inválido.");
        }

        this.status = status;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(cod));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		return cod == other.cod;
	}

	@Override
	public String toString() {
		return "---Imovel " + cod + "---]\n[cod=" + cod + ",\nendereco=\n" + endereco + ",\nvalor=" + valor + ",\narea=" + area + ",\nstatus="
				+ status + "\n";
	}
	
	
}