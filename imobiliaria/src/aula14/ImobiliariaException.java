package aula14;

public class ImobiliariaException extends Exception {

    
	private static final long serialVersionUID = 1L;
	private boolean erro = true;

    public ImobiliariaException(String mensagem) {
        super(mensagem);
    }

    public ImobiliariaException(String mensagem, boolean erro) {
        super(mensagem);
        this.erro = erro;
    }

    public boolean isErro() {
        return erro;
    }
}