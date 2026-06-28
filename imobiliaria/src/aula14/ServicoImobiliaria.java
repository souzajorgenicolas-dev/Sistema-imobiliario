package aula14;

import java.util.ArrayList;
import java.util.List;

public class ServicoImobiliaria {
	
	private List<Cliente> clientes;
	private List<Imovel> imoveis;
	private List<Contrato> contratos;
	
	public ServicoImobiliaria () {
		
		clientes = new ArrayList<>();
		imoveis = new ArrayList<>();
		contratos = new ArrayList<>();
	}
	
	public void gerarRelatorios() throws ImobiliariaException {
		if(imoveis.isEmpty()) {
			throw new ImobiliariaException("Nao existem imoveis cadastrados", false);
		}
		
		int qtdImoveisDisp = 0;
		for (Imovel i : imoveis) {
			
			if(i.getStatus() == StatusImovel.Disponivel) {
				qtdImoveisDisp++;
			}
		}
		
		int qtdImoveisVendidos = 0;
		for (Imovel i : imoveis) {
			if((i.getStatus()) == StatusImovel.Vendido){
				qtdImoveisVendidos++;
			}
		}
		double totalArrecadadoVendidos = 0;
		for (Imovel i : imoveis) {
			if (i.getStatus() == StatusImovel.Vendido) {
				totalArrecadadoVendidos += i.calcularValorFinal();
			}
		}
		
		int qtdImoveisAlugados = 0;
		for (Imovel i : imoveis) {
			if((i.getStatus()) == StatusImovel.Alugado){
				qtdImoveisAlugados++;
			}
		}
		double totalArrecadadoAlugueis = 0;
		for (Contrato c : contratos) {
			if(c.getTipoContrato().equalsIgnoreCase("Aluguel")) {
				totalArrecadadoAlugueis += c.getValorAcordado() ;
			}
		}
		
		double imvMaisCaro = 0;
		for (Imovel i : imoveis) {
			double imvAtual = i.calcularValorFinal();
			if(imvAtual > imvMaisCaro){
				imvMaisCaro = imvAtual;
			}
		}
		
		System.out.println("------------------RELATORIOS-----------------\n"
				     	+ "Quantidade de imoveis DISPONIVEIS: " + qtdImoveisDisp +"\n" 
				     	+ "Quantidade de imoveis VENDIDOS: " + qtdImoveisVendidos +"\n" 
				     	+ "Total arrecadado com imoveis VENDIDOS: " + totalArrecadadoVendidos +"\n" 
				     	+ "Quantidade de imoveis ALUGADOS: " + qtdImoveisAlugados +"\n"
				     	+ "Total arrecadado com imoveis ALUGADOS: " + totalArrecadadoAlugueis +"\n"
				     	+ "Imovel mais caro: " + imvMaisCaro);
		
	}
	
	
	public List<Imovel> getImoveis() {
		return imoveis;
	}
	
	public List<Contrato> getContratos() {
		return contratos;
	}
	
	public void cadastrarCliente(Cliente c) throws ImobiliariaException {
		if (clientes.contains(c)) {
			throw new ImobiliariaException("Cliente ja cadastrado");
		}
		
		
		clientes.add(c);
		
	}
	
	public Cliente buscarCliente(String cpf) throws ImobiliariaException {
		if (clientes.isEmpty()) {
			throw new ImobiliariaException("Sem clientes cadastrados");
		}
		
	    for (Cliente c : clientes) {
	        if (c.getCpf().equals(cpf)) {
	            return c;
	        }
	    }

	    throw new ImobiliariaException("Cliente não encontrado.", false);
	}
	
	public Imovel buscarImovel(int codigo) throws ImobiliariaException {
		if (imoveis.isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados");
		}
		
	    for (Imovel i : imoveis) {
	        if (i.getCod() == codigo) {
	            return i;
	        }
	    }

	    throw new ImobiliariaException("Imóvel não encontrado.", false);
	}
	
	public void cadastrarImovel(Imovel i) throws ImobiliariaException {		
		if (imoveis.contains(i)) {
			throw new ImobiliariaException("Imovel ja cadastrado");
		}
		
		if (i == null) {
			throw new ImobiliariaException("Imovel invalido");
		}
		
		imoveis.add(i);
	}
	
	public void venderImovel(Imovel i, Cliente comprador) throws ImobiliariaException {
		if(imoveis.isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		if (!clientes.contains(comprador)) {
		    throw new ImobiliariaException("Cliente não cadastrado.");
		}
		
		if (!imoveis.contains(i)) {
			throw new ImobiliariaException("Esse imovel nao esta cadastrado");
		}
		
		if (i.getStatus() != StatusImovel.Disponivel) {
			throw new ImobiliariaException("Imovel indisponivel para venda");
		}
		
		i.setStatus(StatusImovel.Vendido);
		
		Contrato contrato = new Contrato(
				comprador,
				i,
				"Venda",
				i.calcularValorFinal()
				);
		
		contratos.add(contrato);
	}
	
	public void alugarImovel(Imovel i, Cliente locatorio, double valorMensal) throws ImobiliariaException {
		if(imoveis.isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		if (!clientes.contains(locatorio)) {
		    throw new ImobiliariaException("Cliente não cadastrado.");
		}
		
		if (!imoveis.contains(i)) {
			throw new ImobiliariaException("Esse imovel nao esta cadastrado");
		}
		
		if (i.getStatus() != StatusImovel.Disponivel) {
			throw new ImobiliariaException("Imovel indisponivel para alugar");
		}
		
		i.setStatus(StatusImovel.Alugado);
		
		Contrato contrato = new Contrato(
				locatorio,
				i,
				"Aluguel",
				valorMensal
				);
		
		contratos.add(contrato);
	}
	
	
	public List<Imovel> buscarImovelPorTipo(String tipo) throws ImobiliariaException{
		if(imoveis.isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		List<Imovel> resultado = new ArrayList<>();
				
		for (Imovel i : imoveis) {
			if (i.getClass().getSimpleName().equalsIgnoreCase(tipo)) {
				resultado.add(i);
			}
		}
		
		return resultado;
	}
	
	public List<Imovel> buscarImovelPorStatus(String status) throws ImobiliariaException {
		if(imoveis.isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		List<Imovel> resultado = new ArrayList<>();
		
		for (Imovel i : imoveis) {
			if (i.getStatus().toString().equalsIgnoreCase(status)) {
				resultado.add(i);
			}
		}
		
		return resultado;
	}
}
