package aula14;

class Apartamento extends Imovel {
    private int andar;
    private int numeroApt;
    private double vlrCondominio;
    private double iptu;

    @Override
    public double calcularValorFinal() {
        return (getValor() + getIptu() + getVlrCondominio());
    }

    public Apartamento(Endereco endereco, double valor, double area, StatusImovel status, int andar, int numeroApt, double vlrCondominio, double iptu) {
    	super(endereco, valor, area, status);
    	
    	setAndar(andar);
        setNumeroApt(numeroApt);
        setVlrCondominio(vlrCondominio);
        setIptu(iptu);
    }

    public void setAndar(int andar) {
        if (andar < 0) {
            throw new IllegalArgumentException("Andar inválido");
        }
        this.andar = andar;
    }

    public void setNumeroApt(int numeroApt) {
        if (numeroApt < 0) {
            throw new IllegalArgumentException("Número do apartamento inválido");
        }
        this.numeroApt = numeroApt;
    }

    public void setVlrCondominio(double vlrCondominio) {
        if (vlrCondominio < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.vlrCondominio = vlrCondominio;
    }

 // posso deixar no imovel, PERGUNTAR AO PROFESSOR
    public void setIptu(double iptu) {
        if (iptu < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }
        this.iptu = iptu;
    }

    public int getAndar() {
        return andar;
    }

    public int getNumeroApt() {
        return numeroApt;
    }

    public double getVlrCondominio() {
        return vlrCondominio;
    }

    public double getIptu() {
        return iptu;
    }

	@Override
	public String toString() {
		return "===Apartamento=== [" + super.toString() + "andar= " + andar + ", numeroApt=" + numeroApt + ", vlrCondominio=" + vlrCondominio
				+ ", iptu=" + iptu + "]\n";
	}    
}
