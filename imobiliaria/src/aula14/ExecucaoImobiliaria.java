package aula14;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ExecucaoImobiliaria {
	
	public static void main(String[] args) {
	
	Scanner entrada = new Scanner(System.in);
	ServicoImobiliaria servico = new ServicoImobiliaria();
	
	int opcao = 0;
	
	while (opcao != 8) {
		System.out.println("----DIGITE A SUA OPCAO----");
		System.out.println("   1- CADASTRAR CLIENTE");
		System.out.println("   2- CADASTRAR IMOVEL");
		System.out.println("   3- LISTAR IMOVEIS");
		System.out.println("   4- VENDER IMOVEL");
		System.out.println("   5- ALUGAR IMOVEL");
		System.out.println("   6- BUSCAR IMOVEL");
		System.out.println("   7- RELATORIOS");
		System.out.println("   8- SAIR DO SISTEMA");
		
		if (!entrada.hasNextInt()) {
		    System.out.println("Digite apenas números!");
		    entrada.nextLine(); // limpa a entrada
		    continue;
		}

		opcao = entrada.nextInt();
		
		try {
			if (opcao == 1) {
				cadastrarCliente(entrada, servico);
			} else if (opcao == 2) {
				cadastrarImovel(entrada, servico);
			} else if (opcao == 3) {
				listarImoveis(entrada, servico);
			} else if (opcao == 4) {
				venderImovel(entrada, servico);
			} else if (opcao == 5) {
				alugarImovel(entrada, servico);
			} else if(opcao == 6) {
				buscarImovel(entrada, servico);
			} else if(opcao == 7) {
				servico.gerarRelatorios();
			} else if (opcao != 8) {
				throw new ImobiliariaException("Opcao invalida", false);
			} else {
				entrada.close();
				System.out.println("Encerrando...");
			}
		} catch (ImobiliariaException e) {
			if (e.isErro()){
				System.out.println(":: ERRO :: -> " + e.getMessage());
			} else {
				System.out.println(":: AVISO :: -> " + e.getMessage());
			}
		} catch(Exception e) {
			System.out.println(":: ERRO :: -> Servico Indisponivel\n Enter para retornar ao menu...");
			entrada.nextLine();
		}
	
		}
	}

	private static void buscarImovel(Scanner entrada, ServicoImobiliaria servico) throws ImobiliariaException {
		if (servico.getImoveis() == null || servico.getImoveis().isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		System.out.println("Digite o codigo do imovel: ");
		int codigo = entrada.nextInt();
		
		Imovel i = servico.buscarImovel(codigo);
		
		System.out.println(i);
		
	}

	private static void alugarImovel(Scanner entrada, ServicoImobiliaria servico) throws ImobiliariaException {		
		if (servico.getImoveis() == null || servico.getImoveis().isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		entrada.nextLine(); 
		System.out.println("CPF do cliente locatorio: ");
		String cpf = entrada.nextLine();
		
		System.out.println("CODIGO do imovel: ");
		int cod = entrada.nextInt();
		
		Cliente locatorio = servico.buscarCliente(cpf);
		
		Imovel i = servico.buscarImovel(cod);
		
		System.out.println("Valor mensal do aluguel:");
		double valorMensal = entrada.nextDouble();
		
		servico.alugarImovel(i, locatorio, valorMensal);
		
		System.out.println("Imovel alugado com sucesso");
	}
	

	private static void venderImovel(Scanner entrada, ServicoImobiliaria servico) throws ImobiliariaException{
		if (servico.getImoveis() == null || servico.getImoveis().isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		entrada.nextLine();
		System.out.println("CPF do cliente comprador: ");
		String cpf = entrada.nextLine();
		
		System.out.println("CODIGO do imovel: ");
		int cod = entrada.nextInt();
		
		Cliente comprador = servico.buscarCliente(cpf);
		
		Imovel i = servico.buscarImovel(cod);
		
		servico.venderImovel(i, comprador);
		
		System.out.println("Imovel vendido com sucesso");
	}

	private static void cadastrarImovel(Scanner entrada, ServicoImobiliaria servico) throws ImobiliariaException {
		System.out.println("Que tipo de imovel quer cadastrar? \n1- Casa \n2- Apartamento \n3- Terreno");
		int tipoImovel = entrada.nextInt();
		
		entrada.nextLine();
		
		// area endereco
		System.out.println("Detalhes do endereco- \nLogradouro: ");
		String logradouro = entrada.nextLine();
		
		System.out.println("Detalhes do endereco- \nNumero: ");
		int numero = entrada.nextInt();
		entrada.nextLine();
		
		System.out.println("Detalhes do endereco- \nBairro: ");
		String bairro = entrada.nextLine();
		
		System.out.println("Detalhes do endereco- \nCidade: ");
		String cidade = entrada.nextLine();
		
		Endereco endereco = new Endereco(logradouro, numero, bairro, cidade);
		//
		System.out.println("Valor: ");
		double valor = entrada.nextDouble();
		
		System.out.println("Area: ");
		double area = entrada.nextDouble();
		
		System.out.println("Status do imovel (DIGITE O NUMERO DA OPCAO): \n1- Disponivel \n2- Alugado \n3- Vendido");
		int opStatus = entrada.nextInt();
		
		StatusImovel status;
		
		switch (opStatus) {
		case 1:
			status = StatusImovel.Disponivel;
			break;
		case 2:
			status = StatusImovel.Alugado;
			break;
		case 3:
			status = StatusImovel.Vendido;
			break;
		default:
			throw new ImobiliariaException("Status invalido", true);
		}
		
		switch (tipoImovel) {
		case 1:
			
			System.out.println("Numero de quartos: ");
			int nrQuartos = entrada.nextInt();
			
			System.out.println("Tem garagem?(DIGITE O NUMERO DA OPCAO) \n1- SIM \n2- NAO");
			int temGaragem = entrada.nextInt();
			boolean garagem = false;
			if (temGaragem == 1) {
				garagem = true;
			} else if (temGaragem == 2) {
				garagem = false;
			} else {
				throw new ImobiliariaException("Opcao invalida", true);
			}
			
			System.out.println("IPTU: ");
			double iptuCasa = entrada.nextDouble();
			
			Casa casa = new Casa(endereco, valor, area, status, nrQuartos, garagem, iptuCasa);
			
			servico.cadastrarImovel(casa);
			System.out.println("Casa Cadastrada com sucesso!");
			break;
		case 2:
			
			System.out.println("Andar: ");
			int andar = entrada.nextInt();

			System.out.println("Numero do apartamento: ");
			int numeroApt = entrada.nextInt();

			System.out.println("Valor do condominio: ");
			double vlrCondominio = entrada.nextDouble();

			System.out.println("IPTU: ");
			double iptuApto = entrada.nextDouble();
			
			Apartamento apartamento = new Apartamento(endereco, valor, area, status, andar, numeroApt, vlrCondominio, iptuApto);
			
			servico.cadastrarImovel(apartamento);
			System.out.println("Apartamento cadastrado com sucesso!");
			break;
		case 3: 
			
			TipoTerreno tipo;
			
			System.out.println("Qual o tipo do terreno?(DIGITE O NUMERO DA OPCAO) \n1- Residencial \n2- Comercial");
			int opcTipo = entrada.nextInt();
			
			if(opcTipo == 1) {
				tipo = TipoTerreno.Residencial;
			} else if (opcTipo == 2) {
				tipo = TipoTerreno.Comercial;
			} else {
				throw new ImobiliariaException("Tipo invalido", true);
			}
			
			Terreno terreno = new Terreno(endereco, valor, area, status, tipo);
			
			servico.cadastrarImovel(terreno);
			System.out.println("Terreno cadastrado com sucesso!");
			break;
		default: 
			throw new ImobiliariaException("Opcao invalida");
		}
			
	}

	private static void listarImoveis(Scanner entrada, ServicoImobiliaria servico) throws ImobiliariaException {
		if (servico.getImoveis() == null || servico.getImoveis().isEmpty()) {
			throw new ImobiliariaException("Sem imoveis cadastrados", false);
		}
		
		System.out.println("Que tipo de imovel quer listar?(DIGITE A OPCAO) \n1- Casa \n2- Apartamento \n3- Terreno");
		int opcao = entrada.nextInt();
		String tipo;
		List<Imovel> resultado = new ArrayList<>();
		if (opcao == 1) {
			tipo = "Casa";
			if (servico.buscarImovelPorTipo(tipo).isEmpty()) {
				throw new ImobiliariaException("Sem casas cadastradas", false);
			} else {
				for (Imovel i : servico.buscarImovelPorTipo(tipo)) {
					resultado.add(i);
				}
			System.out.println(resultado);
			}
		} else if (opcao == 2) {
			tipo = "Apartamento";
			if (servico.buscarImovelPorTipo(tipo).isEmpty()) {
				throw new ImobiliariaException("Sem apartamentos cadastrados", false);
			} else {
				for (Imovel i : servico.buscarImovelPorTipo(tipo)) {
					resultado.add(i);
				}
			System.out.println(resultado);
			}
		} else if (opcao == 3) {
			tipo = "Terreno";
			if (servico.buscarImovelPorTipo(tipo).isEmpty()) {
				throw new ImobiliariaException("Sem terrenos cadastrados", false);
			} else {
				for (Imovel i : servico.buscarImovelPorTipo(tipo)) {
					resultado.add(i);
				}
			System.out.println(resultado);
			}
		} else {
			throw new ImobiliariaException("Opcao invalida", false);
		}
		
	}

	private static void cadastrarCliente(Scanner entrada, ServicoImobiliaria servico) throws ImobiliariaException {

	    entrada.nextLine(); // limpa o Enter

	    System.out.print("Nome: ");
	    String nome = entrada.nextLine();

	    System.out.print("CPF: ");
	    String cpf = entrada.nextLine();

	    System.out.print("Telefone: ");
	    String telefone = entrada.nextLine();

	    System.out.print("Email: ");
	    String email = entrada.nextLine();

	    Cliente cliente = new Cliente(nome, cpf, telefone, email);

	    servico.cadastrarCliente(cliente);
	    
	    System.out.println("Cliente cadastrado com sucesso");
		}
	}