package trabalho;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Loja {
	private Scanner sc = new Scanner(System.in);
	
	private static final int maxFornecedores = 20;
	private Fornecedor[] fornecedores = new Fornecedor[maxFornecedores]; 
	
	private static final int maxProdutos = 50;
	private Produto[] produtos = new Produto[maxProdutos];
	
	private static final int maxPedidos = 50;
	private Pedido[] pedidos = new Pedido[maxPedidos];
	private static final int maxIPP = 10;

	private static final int maxClientes = 100;
	private Cliente[] clientes = new Cliente[maxClientes];
	
	private int codUser = 0;
	private int codProd = 0;
	private int numPed = 0;
	
	private int spPed = 0;
	private int s = 0;
	private int itCarr = 0;
	
	static boolean achou = false;
	
	boolean exc = false;
	
	private Pedido carrinho;
	
	public void iniciarValores() {
		Endereco endereco1 = new Endereco("Rua 1", "111", "Complemento", "Bairro 1", "11111-111", "Caxias do Sul", "Rio Grande do Sul");
		Endereco endereco2 = new Endereco("Rua 2", "222", "Complemento", "Bairro 2", "22222-222", "Caxias do Sul", "Rio Grande do Sul");
		Endereco endereco3 = new Endereco("Rua 3", "333", "Complemento", "Bairro 3", "33333-333", "Caxias do Sul", "Rio Grande do Sul");
		Usuario usuario1 = new Usuario("joao", "senha", 0, true);
		Usuario usuario2 = new Usuario("paulo", "senha", 1, true);
		Usuario usuario3 = new Usuario("roberto", "senha", 2, true);
		Fornecedor fornecedor1 = new Fornecedor("João", "54123456789", "joão@gmail.com", "012-345-678.99", endereco1, "Vendedor de Queijo", usuario1);
		Fornecedor fornecedor2 = new Fornecedor("Paulo", "54123456789", "paulo@gmail.com", "012-345-678.99", endereco2, "Vendedor de Queijo", usuario2);
		Fornecedor fornecedor3 = new Fornecedor("Roberto", "54123456789", "roberto@gmail.com", "012-345-678.99", endereco3, "Vendedor de Salame", usuario3);
		fornecedores[0] = fornecedor1;
		fornecedores[1] = fornecedor2;
		fornecedores[2] = fornecedor3;
		
		Endereco endereco4 = new Endereco("Rua 4", "444", "Complemento", "Bairro 4", "44444-444", "Caxias do Sul", "Rio Grande do Sul");
		Endereco endereco5 = new Endereco("Rua 5", "555", "Complemento", "Bairro 5", "55555-555", "Caxias do Sul", "Rio Grande do Sul");
		Endereco endereco6 = new Endereco("Rua 6", "666", "Complemento", "Bairro 6", "66666-666", "Caxias do Sul", "Rio Grande do Sul");
		Usuario usuario4 = new Usuario("marcelo", "senha", 3, true);
		Usuario usuario5 = new Usuario("rogerio", "senha", 4, true);
		Usuario usuario6 = new Usuario("marcos", "senha", 5, true);
		Cliente cliente1 = new Cliente("Marcelo", "54123456789", "marcelo@gmail.com", "012-345-678.99", endereco4, "Cartão1", usuario4);
		Cliente cliente2 = new Cliente("Rogério", "54123456789", "rogerio@gmail.com", "012-345-678.99", endereco5, "Cartão2", usuario5);
		Cliente cliente3 = new Cliente("Marcos", "54123456789", "marcos@gmail.com", "012-345-678.99", endereco6, "Cartão1", usuario6);
		clientes[0] = cliente1;
		clientes[1] = cliente2;
		clientes[2] = cliente3;
		
		byte[] foto = null;
		Estoque estoque1 = new Estoque(10, 20);
		Estoque estoque2 = new Estoque(15, 25);
		Estoque estoque3 = new Estoque(20, 30);
		Estoque estoque4 = new Estoque(25, 35);
		Estoque estoque5 = new Estoque(10, 10);
		Estoque estoque6 = new Estoque(5, 50);
		Produto produto1 = new Produto(0, "Queijo", "Queijo Prato", foto, fornecedores[0], estoque1, true);
		Produto produto2 = new Produto(1, "Queijo", "Queijo Minas", foto, fornecedores[0], estoque2, true);
		Produto produto3 = new Produto(2, "Queijo Gorgonzola", "Queijo Gorgonzola", foto, fornecedores[1], estoque3, true);
		Produto produto4 = new Produto(3, "Queijo", "Queijo da Montanha", foto, fornecedores[1], estoque4, true);
		Produto produto5 = new Produto(4, "Salame", "Salame Apimentado", foto, fornecedores[2], estoque5, true);
		Produto produto6 = new Produto(5, "Salame e Queijo", "Salame com Queijo Prato", foto, fornecedores[2], estoque6, true);
		produtos[0] = produto1;
		produtos[1] = produto2;
		produtos[2] = produto3;
		produtos[3] = produto4;
		produtos[4] = produto5;
		produtos[5] = produto6;
		
		Pedido pedido1 = new Pedido(0, clientes[0]);
		Pedido pedido2 = new Pedido(1, clientes[0]);
		Pedido pedido3 = new Pedido(2, clientes[1]);
		Pedido pedido4 = new Pedido(3, clientes[1]);
		Pedido pedido5 = new Pedido(4, clientes[2]);
		Pedido pedido6 = new Pedido(5, clientes[2]);
		Date atual = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(atual);
		calendario.add(Calendar.DAY_OF_MONTH, 20);
		Date entrega = calendario.getTime();
		pedido1.setDataPedido(atual);
		pedido1.setDataEntrega(entrega);
		pedido1.setTotalItens(2);
		pedido1.setSituacao("PENDENTE");
		pedido2.setDataPedido(atual);
		pedido2.setDataEntrega(entrega);
		pedido2.setTotalItens(2);
		pedido2.setSituacao("PENDENTE");
		pedido3.setDataPedido(atual);
		pedido3.setDataEntrega(entrega);
		pedido3.setTotalItens(2);
		pedido3.setSituacao("PENDENTE");
		pedido4.setDataPedido(atual);
		pedido4.setDataEntrega(entrega);
		pedido4.setTotalItens(2);
		pedido4.setSituacao("PENDENTE");
		pedido5.setDataPedido(atual);
		pedido5.setDataEntrega(entrega);
		pedido5.setTotalItens(2);
		pedido5.setSituacao("PENDENTE");
		pedido6.setDataPedido(atual);
		pedido6.setDataEntrega(entrega);
		pedido6.setTotalItens(2);
		pedido6.setSituacao("PENDENTE");
		ItemPedido[] itens1 = new ItemPedido[maxIPP];
		ItemPedido[] itens2 = new ItemPedido[maxIPP];
		ItemPedido[] itens3 = new ItemPedido[maxIPP];
		ItemPedido[] itens4 = new ItemPedido[maxIPP];
		ItemPedido[] itens5 = new ItemPedido[maxIPP];
		ItemPedido[] itens6 = new ItemPedido[maxIPP];
		itens1[0] = new ItemPedido(produtos[0], 2);
		itens1[1] = new ItemPedido(produtos[1], 4);
		itens2[0] = new ItemPedido(produtos[1], 6);
		itens2[1] = new ItemPedido(produtos[2], 8);
		itens3[0] = new ItemPedido(produtos[2], 10);
		itens3[1] = new ItemPedido(produtos[3], 8);
		itens4[0] = new ItemPedido(produtos[3], 6);
		itens4[1] = new ItemPedido(produtos[4], 4);
		itens5[0] = new ItemPedido(produtos[4], 2);
		itens5[1] = new ItemPedido(produtos[5], 4);
		itens6[0] = new ItemPedido(produtos[5], 6);
		itens6[1] = new ItemPedido(produtos[0], 8);
		pedido1.setItens(itens1);
		pedido2.setItens(itens2);
		pedido3.setItens(itens3);
		pedido4.setItens(itens4);
		pedido5.setItens(itens5);
		pedido6.setItens(itens6);
		pedidos[0] = pedido1;
		pedidos[1] = pedido2;
		pedidos[2] = pedido3;
		pedidos[3] = pedido4;
		pedidos[4] = pedido5;
		pedidos[5] = pedido6;
		
	}
	
	public void cadastrarUsuario(char tipo) {
		int pos = -1;
		
		System.out.println("Digite o login: ");
		String login = sc.nextLine();
		
		if(tipo == 'c') {
			for (int i = 0; i<maxClientes; i++) {
				if(clientes[i]!=null) {
					if (clientes[i].usuario.getLogin().equalsIgnoreCase(login)) {
						System.out.println("Login já existente.");
						return;
					}
				}else if(clientes[i] == null && pos == -1) {
					pos = i;
				}
			}
		}else {
			for (int i = 0; i<maxFornecedores; i++) {
				if(fornecedores[i]!= null) {
					if (fornecedores[i].usuario.getLogin().equalsIgnoreCase(login)) {
						System.out.println("Login já existente.");
						return;
					}
				}else if(fornecedores[i] == null && pos == -1) {
					pos = i;
				}
			}
		}
		
		if(pos == -1) {
			System.out.println("Limite de usuários atingido.");
			return;
		}
		
		System.out.print("Digite a senha: ");
        String senha = sc.nextLine();
        
        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        
        System.out.println("Digite seu telefone: ");
        String telefone = sc.nextLine();
        
        System.out.println("Digite seu email: ");
        String email = sc.nextLine();
        
        System.out.println("Digite seu CPF: ");
        String cpf = sc.nextLine();
        
        Endereco endereco = new Endereco("","","","","","","");
        System.out.println("Deseja informar seu Endereço? \n");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        int opcao = 0;
        do {
        	opcao = lerInt();
        	switch(opcao) {
        	case 1:
        		System.out.println("Digite sua rua: ");
        		endereco.setRua(sc.nextLine());
        		System.out.println("Digite o número: ");
        		endereco.setNumero(sc.nextLine());
        		System.out.println("Digite um complemento: ");
        		endereco.setComplemento(sc.nextLine());
        		System.out.println("Digite seu bairro: ");
        		endereco.setBairro(sc.nextLine());
        		System.out.println("Digite o cep: ");
        		endereco.setCep(sc.nextLine());
        		System.out.println("Digite sua cidade: ");
        		endereco.setCidade(sc.nextLine());
        		System.out.println("Digite seu estado: ");
        		endereco.setEstado(sc.nextLine());
        		opcao = 2;
        		break;
        	case 2:
        		break;
        	default:
        		System.out.println("Opção incorreta informada");
        		break;
        	}
        } while(opcao!= 2);
        
        if(tipo == 'c') {
        	System.out.println("Digite seu Cartão de Crédito: ");
            String cartao = sc.nextLine();
            checarCod();
            Usuario usuarioc = new Usuario(login, senha, codUser, true);
        	clientes[pos] = new Cliente(nome, telefone, email, cpf, endereco, cartao, usuarioc);
    	}else {
    		System.out.println("Digite sua Descrição: ");
            String descricao = sc.nextLine();
            checarCod();
            Usuario usuariof = new Usuario(login, senha, codUser, true);
    		fornecedores[pos] = new Fornecedor(nome, telefone, email, cpf, endereco, descricao, usuariof);
    	}
    	codUser++;
    	System.out.println("Usuário cadastrado com sucesso.");
	}
	
	public boolean fazerLogin(char tipo) { 
		exc = false;
    	String login, senha;
        System.out.println("=== Sistema de Login ===");
        System.out.print("Login: ");
        login = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        
        boolean autentica = autenticarUsuario(login, senha, tipo);
        return autentica;
    }
	
	private boolean autenticarUsuario(String login, String senha, char tipo) {
		if(tipo == 'c') {
			for (int i = 0; i < maxClientes; i++) {
				if(clientes[i]!= null) {
					if (clientes[i].usuario.getLogin().equals(login) && clientes[i].usuario.getSenha().equals(senha)) {
						if(clientes[i].usuario.isActive()==true) {
							Menu.cliente = clientes[i];
							return true;
						}else {
							System.out.println("Conta excluída.");
							exc = true;
							return false;
						}
					}
				}
			}
		}else {
			for (int i = 0; i < maxFornecedores; i++) { 
				if(fornecedores[i]!=null) {
					if (fornecedores[i].usuario.getLogin().equals(login) && fornecedores[i].usuario.getSenha().equals(senha)) {
						if(fornecedores[i].usuario.isActive()==true) {
							Menu.fornecedor = fornecedores[i];
							return true;
						}else {
							System.out.println("Conta excluída.");
							exc = true;
							return false;
						}
					}
				}
			}
		}
		
		return false;
    }
	
	public boolean autenticaExistente(String login, char tipo) {
		if(tipo == 'c') {
			for(int i =0; i<maxClientes;i++) {
				if(clientes[i]!=null) {
					if(clientes[i].usuario.getLogin().equalsIgnoreCase(login)) {
						return true;
					}
				}
			}
		}else {
			for(int i =0; i<maxFornecedores;i++) {
				if(fornecedores[i]!=null) {
					if(fornecedores[i].usuario.getLogin().equalsIgnoreCase(login)) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void visualizarConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
		if(tipo == 'c') {
			System.out.println("Usuário: " + cliente.usuario.getLogin());
			System.out.println("Senha: " + cliente.usuario.getSenha());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Cartão de Crédito: " + cliente.getCartaoCredito());
			System.out.println("Endereço: ");
			System.out.println("Estado: " + cliente.endereco.getEstado());
			System.out.println("Cidade: " + cliente.endereco.getCidade());
			System.out.println("Bairro: " + cliente.endereco.getBairro());
			System.out.println("Rua: " + cliente.endereco.getRua());
			System.out.println("Número: " + cliente.endereco.getNumero());
			System.out.println("CEP: " + cliente.endereco.getCep());
			System.out.println("Complemento: " + cliente.endereco.getComplemento());
			
		}else {
			System.out.println("Usuário: " + fornecedor.usuario.getLogin());
			System.out.println("Senha: " + fornecedor.usuario.getSenha());
			System.out.println("CPF: " + fornecedor.getCpf());
			System.out.println("Email: " + fornecedor.getEmail());
			System.out.println("Telefone: " + fornecedor.getTelefone());
			System.out.println("Descrição: " + fornecedor.getDescricao());
			System.out.println("Endereço: ");
			System.out.println("Estado: " + fornecedor.endereco.getEstado());
			System.out.println("Cidade: " + fornecedor.endereco.getCidade());
			System.out.println("Bairro: " + fornecedor.endereco.getBairro());
			System.out.println("Rua: " + fornecedor.endereco.getRua());
			System.out.println("Número: " + fornecedor.endereco.getNumero());
			System.out.println("CEP: " + fornecedor.endereco.getCep());
			System.out.println("Complemento: " + fornecedor.endereco.getComplemento());
		}
	}
	
	public void alterarConta(char tipo, Cliente cliente, Fornecedor fornecedor, int n) {
		if(tipo == 'c') {
			switch(n) {
			case 1:
				System.out.println("Informe o novo Usuário: ");
				String u = sc.nextLine();
				boolean autentica = autenticaExistente(u, tipo);
				if(autentica==false)
				{
					cliente.usuario.setLogin(u);
					System.out.println("Usuário alterado com sucesso.");
				}else {
					System.out.println("Login já existente.");
				}
				break;
			case 2:
				System.out.println("Informe a nova Senha: ");
				String s = sc.nextLine();
				cliente.usuario.setSenha(s);
				System.out.println("Senha alterada com sucesso.");
				break;
			case 3:
				System.out.println("Informe o novo Nome: ");
				String no = sc.nextLine();
				cliente.setNome(no);
				System.out.println("Nome alterado com sucesso.");
				break;
			case 4:
				System.out.println("Informe o novo telefone: ");
				String t = sc.nextLine();
				cliente.setTelefone(t);
				System.out.println("Telefone alterado com sucesso.");
				break;
			case 5:
				System.out.println("Informe o novo email: ");
				String e = sc.nextLine();
				cliente.setEmail(e);
				System.out.println("Email alterado com sucesso.");
				break;
			case 6:
				System.out.println("Informe o novo Cartão de Crédito: ");
				String cc = sc.nextLine();
				cliente.setCartaoCredito(cc);
				System.out.println("Cartão de Crédito alterado com sucesso.");
				break;
			case 7:
				System.out.println("Informe o novo Endereço: ");
				System.out.println("Digite sua rua: ");
        		cliente.endereco.setRua(sc.nextLine());
        		System.out.println("Digite o número: ");
        		cliente.endereco.setNumero(sc.nextLine());
        		System.out.println("Digite um complemento: ");
        		cliente.endereco.setComplemento(sc.nextLine());
        		System.out.println("Digite seu bairro: ");
        		cliente.endereco.setBairro(sc.nextLine());
        		System.out.println("Digite o cep: ");
        		cliente.endereco.setCep(sc.nextLine());
        		System.out.println("Digite sua cidade: ");
        		cliente.endereco.setCidade(sc.nextLine());
        		System.out.println("Digite seu estado: ");
        		cliente.endereco.setEstado(sc.nextLine());
				System.out.println("Endereço alterado com sucesso.");
				break;
			}
		}else {
			switch(n) {
			case 1:
				System.out.println("Informe o novo Usuário: ");
				String u = sc.nextLine();
				boolean autentica = autenticaExistente(u, tipo);
				if(autentica==false)
				{
					fornecedor.usuario.setLogin(u);
					System.out.println("Usuário alterado com sucesso.");
				}else {
					System.out.println("Login já existente.");
				}
				break;
			case 2:
				System.out.println("Informe a nova Senha: ");
				String s = sc.nextLine();
				fornecedor.usuario.setSenha(s);
				System.out.println("Senha alterada com sucesso.");
				break;
			case 3:
				System.out.println("Informe o novo Nome: ");
				String no = sc.nextLine();
				fornecedor.setNome(no);
				System.out.println("Nome alterado com sucesso.");
				break;
			case 4:
				System.out.println("Informe o novo telefone: ");
				String t = sc.nextLine();
				fornecedor.setTelefone(t);
				System.out.println("Telefone alterado com sucesso.");
				break;
			case 5:
				System.out.println("Informe o novo email: ");
				String e = sc.nextLine();
				fornecedor.setEmail(e);
				System.out.println("Email alterado com sucesso.");
				break;
			case 6:
				System.out.println("Informe a nova Descrição: ");
				String de = sc.nextLine();
				fornecedor.setDescricao(de);
				System.out.println("Descrição alterada com sucesso.");
				break;
			case 7:
				System.out.println("Informe o novo Endereço: ");
				System.out.println("Digite sua rua: ");
				fornecedor.endereco.setRua(sc.nextLine());
        		System.out.println("Digite o número: ");
        		fornecedor.endereco.setNumero(sc.nextLine());
        		System.out.println("Digite um complemento: ");
        		fornecedor.endereco.setComplemento(sc.nextLine());
        		System.out.println("Digite seu bairro: ");
        		fornecedor.endereco.setBairro(sc.nextLine());
        		System.out.println("Digite o cep: ");
        		fornecedor.endereco.setCep(sc.nextLine());
        		System.out.println("Digite sua cidade: ");
        		fornecedor.endereco.setCidade(sc.nextLine());
        		System.out.println("Digite seu estado: ");
        		fornecedor.endereco.setEstado(sc.nextLine());
				System.out.println("Endereço alterado com sucesso.");
				break;
			}
		}
	}
	
	public void excluirConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
		if(tipo == 'c') {
			double reembolso = 0;
			cliente.usuario.setActive(false);
			for(int i =0; i<maxPedidos; i++) {
				if(pedidos[i]!=null) {
					if(pedidos[i].getCliente()==cliente) {
						if(pedidos[i].getSituacao().equalsIgnoreCase("PENDENTE")) {
							reembolso=+pedidos[i].calcularTotalPedido();
							pedidos[i].setSituacao("CANCELADO");
						}
					}
				}
			}
			System.out.println("Conta removida com sucesso.");
			System.out.println("Pedidos pendentes Cancelados. Valor a ser reembolsado: " + reembolso);
		}else {
			fornecedor.usuario.setActive(false);
			for(int i = 0; i<maxProdutos; i++) {
				if(produtos[i]!=null) {
					if(produtos[i].getFornecedor()==fornecedor) {
						if(produtos[i].isDisponivel() == true) {
							produtos[i].setDisponivel(false);
							produtos[i].estoque.setQuantidade(0);
						}
					}
				}
			}
			System.out.println("Conta removida com sucesso.");
			System.out.println("Produtos associados à conta foram removidos.");
		}
	}
	
	public void alterarContaInformacoes(char tipo, Cliente cliente, Fornecedor fornecedor) {
		if(tipo == 'c') {
            System.out.println("1 - Alterar Usuário");
            System.out.println("Usuário Atual: " + cliente.usuario.getLogin() + "\n");
            System.out.println("2 - Alterar Senha");
            System.out.println("Senha Atual: " + cliente.usuario.getSenha() + "\n");
            System.out.println("3 - Alterar Nome");
            System.out.println("Nome Atual: " + cliente.getNome() + "\n");
            System.out.println("4 - Alterar Telefone");
            System.out.println("Telefone Atual: " + cliente.getTelefone() + "\n");
            System.out.println("5 - Alterar Email");
            System.out.println("Email Atual: " + cliente.getEmail() + "\n");
            System.out.println("6 - Alterar Cartão de Crédito");
            System.out.println("Cartão de Crédito Atual: " + cliente.getCartaoCredito() + "\n");
            System.out.println("7 - Alterar Endereço");
            System.out.println("Endereço Atual: ");
            System.out.println("Estado: " + cliente.endereco.getEstado());
			System.out.println("Cidade: " + cliente.endereco.getCidade());
			System.out.println("Bairro: " + cliente.endereco.getBairro());
			System.out.println("Rua: " + cliente.endereco.getRua());
			System.out.println("Número: " + cliente.endereco.getNumero());
			System.out.println("CEP: " + cliente.endereco.getCep());
			System.out.println("Complemento: " + cliente.endereco.getComplemento() + "\n");
		}else {
			System.out.println("1 - Alterar Usuário");
            System.out.println("Usuário Atual: " + fornecedor.usuario.getLogin() + "\n");
            System.out.println("2 - Alterar Senha");
            System.out.println("Senha Atual: " + fornecedor.usuario.getSenha() + "\n");
            System.out.println("3 - Alterar Nome");
            System.out.println("Nome Atual: " + fornecedor.getNome() + "\n");
            System.out.println("4 - Alterar Telefone");
            System.out.println("Telefone Atual: " + fornecedor.getTelefone() + "\n");
            System.out.println("5 - Alterar Email");
            System.out.println("Email Atual: " + fornecedor.getEmail() + "\n");
            System.out.println("6 - Alterar Descrição");
            System.out.println("Descrição Atual: " + fornecedor.getDescricao() + "\n");
            System.out.println("7 - Alterar Endereço");
            System.out.println("Endereço Atual: ");
            System.out.println("Estado: " + fornecedor.endereco.getEstado());
			System.out.println("Cidade: " + fornecedor.endereco.getCidade());
			System.out.println("Bairro: " + fornecedor.endereco.getBairro());
			System.out.println("Rua: " + fornecedor.endereco.getRua());
			System.out.println("Número: " + fornecedor.endereco.getNumero());
			System.out.println("CEP: " + fornecedor.endereco.getCep());
			System.out.println("Complemento: " + fornecedor.endereco.getComplemento() + "\n");
		}
	}
	
	//------------------ Fornecedor ------------------
	public void visualizarMeusProdutos(Fornecedor fornecedor) {
		for(int i=0;i<maxProdutos;i++) {
			if(produtos[i]!=null) {
				Fornecedor f = produtos[i].getFornecedor();
				if(f == fornecedor) {
					if(produtos[i].isDisponivel()==false) {
						System.out.println("!!! Produto Removido. !!!");
					}
					System.out.println(" - Nome: " + produtos[i].getNome());
					System.out.println("	- Código: " + produtos[i].getCod());
					System.out.println("	- Preço: " + produtos[i].estoque.getPreco());
					System.out.println("	- Descrição: " + produtos[i].getDescricao() + "\n");
				}
			}
		}
	}
	
	public void consultarProdutos(boolean admin) {
		System.out.println("Digite o que quer procurar: ");
		System.out.println("(Apenas clique enter para ver todos Produtos disponíveis)");
		boolean achou = false;
		String procura = sc.nextLine().toLowerCase();
		for(int i=0;i<maxProdutos;i++) {
			if(produtos[i]!=null) {
				if(produtos[i].isDisponivel()==true || admin==true) {
					if(produtos[i].getNome().toLowerCase().contains(procura) || produtos[i].getDescricao().toLowerCase().contains(procura)) {
						if(produtos[i].isDisponivel() == false) {
							System.out.println(" - ===Produto Desativado.===");
						}
						System.out.println(" - Nome: " + produtos[i].getNome());
						System.out.println("	- Código: " + produtos[i].getCod());
						System.out.println("	- Preço: " + produtos[i].estoque.getPreco());
						System.out.println("	- Descrição: " + produtos[i].getDescricao()+ "\n");
						achou = true;
					}
				}
			}
		}
		
		if(achou == false) {
			System.out.println("Nenhum resultado encontrado.");
		}
		
	}

	public void visualizarProduto(int codigo, boolean admin) {
		for(int i = 0;i<maxProdutos; i++) {
			if(produtos[i]!=null) {
				if(produtos[i].getCod() == codigo && (produtos[i].isDisponivel()==true || admin==true)) {
					if(produtos[i].isDisponivel() == false) {
						System.out.println(" - ===Produto Desativado.===");
					}
					System.out.println(" - Nome: " + produtos[i].getNome());
					System.out.println(" - Código: " + produtos[i].getCod());
					System.out.println(" - Foto: " + produtos[i].getFoto());
					System.out.println(" - Descrição: " + produtos[i].getDescricao());
					System.out.println(" - Preço: " + produtos[i].estoque.getPreco());
					System.out.println(" - Quantidade em Estoque: " + produtos[i].estoque.getQuantidade());
					System.out.println(" - Fornecedor: " + produtos[i].fornecedor.usuario.getLogin());
					return;
				}
			}
		}
		System.out.println("Código não encontrado.");
	}
	
	public void consultarFornecedor(boolean admin) {
		System.out.println("Informe o Usuário do Fornecedor: ");
		String user = sc.nextLine();
		for(int i =0; i<maxFornecedores;i++) {
			if(fornecedores[i]!= null) {
				if(fornecedores[i].usuario.getLogin().equalsIgnoreCase(user)) {
					if(fornecedores[i].usuario.isActive()==true || admin == true) {
						if(fornecedores[i].usuario.isActive()==false) {
							System.out.println("===Conta Desativada.===");
						}
						System.out.println("Nome: " + fornecedores[i].getNome());
						System.out.println("Usuario: " + fornecedores[i].usuario.getLogin());
						System.out.println("Descricao: " + fornecedores[i].getDescricao());
						System.out.println("Produtos: ");
						for(int j=0;j<maxProdutos;j++) {
							if(produtos[j]!=null) {
								if(produtos[j].isDisponivel()==true || admin==true) {
									Fornecedor f = produtos[j].getFornecedor();
									if(f == fornecedores[i]) {
										if(produtos[i].isDisponivel() == false) {
											System.out.println(" - ===Produto Desativado.===");
										}
										System.out.println(" - Nome: " + produtos[j].getNome());
										System.out.println("	- Código: " + produtos[j].getCod());
										System.out.println("	- Preço: " + produtos[i].estoque.getPreco());
										System.out.println("	- Descrição: " + produtos[j].getDescricao());
									}
								}
							}
						}
						return;
					}else {
						System.out.println("Conta excluída.");
						return;
					}
				}
			}
		}
		System.out.println("Usuário errado informado.");
	}

	public void cadastrarProduto(Fornecedor fornecedor) {
		int pos = -1;
		
		for(int i = 0; i < maxProdutos; i++) {
        	if(produtos[i] == null && pos == -1) {
        		pos = i;
        	}
        }
		if(pos == -1) {
			System.out.println("Limite de Produtos atingido.");
			return;
		}
		
        System.out.println("=== Cadastro de Produto ===");
        
        System.out.print("Nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Descrição do produto: ");
        String descricao = sc.nextLine();

        byte[] foto = null;

        System.out.print("Quantidade em estoque: ");
        int quantidade = lerInt();
        System.out.print("Preço: ");
        double preco = 0;
        do {
        	preco = lerDouble();
        	if(preco <= 0) {
        		System.out.println("Não é possível colocar este preço. Digite outro preço: ");
        	}
        }while(preco<0);

        Estoque estoque = new Estoque(quantidade, preco);
        for(int i=0;i<maxProdutos;i++) {
        	if(produtos[i]!=null) {
        		if(produtos[i].getCod()==codProd) {
        			codProd++;
        		}
        	}
        }
        produtos[pos] = new Produto(codProd, nome, descricao, foto, fornecedor, estoque, true);
        codProd++;

        System.out.println("Produto cadastrado com sucesso!");
	}
	
	public void autenticarProduto(Fornecedor fornecedor) {
		System.out.println("Informe o código do produto: ");
		achou = false;
		int cod = lerInt();
		for(int i=0;i<maxProdutos;i++) {
			if(produtos[i]!=null) {
				if(produtos[i].getCod() == cod && produtos[i].getFornecedor() == fornecedor) {
					if(produtos[i].isDisponivel()==true) {
						s = i;
						achou = true;
					}else {
						achou = false;
						System.out.println("Produto excluído.");
						return;
					}
				}
			}
		}
		if(achou == false) {
			System.out.println("Código errado informado.");
		}
	}

	public void alterarProduto(int n) {
		switch(n) {
			case 1:
				System.out.println("Informe o novo Preço: ");
				double p = 0;
				do {
		        	p = lerDouble();
		        	if(p <= 0) {
		        		System.out.println("Não é possível colocar este preço. Digite outro preço: ");
		        	}
		        }while(p<0);
				produtos[s].estoque.setPreco(p);
				System.out.println("Preço alterado com sucesso.");
				break;
			case 2:
				System.out.println("Informe a nova quantidade de Estoque: ");
				int q = lerInt();
				produtos[s].estoque.setQuantidade(q);
				System.out.println("Estoque alterado com sucesso.");
				break;
			case 3:
				System.out.println("Informe o novo Nome: ");
				String nm = sc.nextLine();
				produtos[s].setNome(nm);
				System.out.println("Nome alterado com sucesso.");
				break;
			case 4:
				System.out.println("Informe a novo Foto: ");
				
				System.out.println("Foto alterada com sucesso.");
				break;
			case 5:
				System.out.println("Informe a nova Descrição: ");
				String d = sc.nextLine();
				produtos[s].setDescricao(d);
				System.out.println("Descrição alterada com sucesso.");
				break;
		}
	}

	public void removerProduto() {
		produtos[s].setDisponivel(false);
		produtos[s].estoque.setQuantidade(0);
		System.out.println("Produto removido com sucesso, referência mantida para pedidos antigos.");
		
	}
	
	public void alterarProdutoInformacoes() {
		System.out.println("1 - Alterar Preço");
		System.out.println("Preço atual: " + produtos[s].estoque.getPreco() + "\n");
        System.out.println("2 - Alterar Quantidade de Estoque");
        System.out.println("Quantidade Atual: " + produtos[s].estoque.getQuantidade() + "\n");
        System.out.println("3 - Alterar Nome");
        System.out.println("Nome atual: " + produtos[s].getNome() + "\n");
        System.out.println("4 - Alterar Foto");
        System.out.println("Foto atual: " + produtos[s].getFoto() + "\n");
        System.out.println("5 - Alterar Descricao");
        System.out.println("Descrição atual: " + produtos[s].getDescricao() + "\n");
	}

	//------------------ Cliente ------------------
	public boolean autenticaNumPedidos(Cliente cliente) {
		for(int i = 0; i<maxPedidos; i++) {
			if(pedidos[i]!=null) {
				if(pedidos[i].getNumero()==numPed) {
					numPed++;
				}
			}
		}
		for(int i = 0; i<maxPedidos; i++) {
			if(pedidos[i]==null) {
				itCarr = 0;
				spPed = i;
				carrinho = new Pedido(numPed, cliente);
				return true;
			}
		}
		return false;
	}
	
	public void adicionarItemAoCarrinho() {
		System.out.println("Informe o Código do Produto: ");
		int cod = lerInt();
		for(int i = 0; i<maxProdutos; i++) {
			if(produtos[i]!=null) {
				if(produtos[i].getCod() == cod) {
					if(itCarr<maxIPP) {
						boolean jaesta = false;
						for(int j =0; j<maxIPP;j++) {
							if(carrinho.itens[j]!=null) {
								if(produtos[i].getCod() == carrinho.itens[j].produto.getCod()) {
									jaesta = true;
								}
							}
						}
						if(jaesta == false) {
							if(produtos[i].estoque.getQuantidade() == 0) {
								System.out.println("Produto sem Estoque.");
								return;
							}else {
								System.out.println("Informe a quantidade desejada: ");
								int q = lerInt();
								if(q!=0) {
									if(q>produtos[i].estoque.getQuantidade()) {
										System.out.println("Quantidade excede o Estoque do Produto.");
										return;
									}else {
										carrinho.itens[itCarr] = new ItemPedido(produtos[i],q);
										itCarr++;
										System.out.println("Item adicionado com sucesso.");
										return;
									}
								}else {
									System.out.println("Não é possível adicionar uma quantidade 0 de um produto.");
									return;
								}
							}
						}else {
							System.out.println("Produto já está no Carrinho.");
							return;
						}
					}else {
						System.out.println("Máximo de Produtos por Pedido já atingido.");
						return;
					}
				}
			}
		}
		System.out.println("Código errado informado.");
	}

	public void removerItemDoCarrinho() {
		System.out.println("Informe o Código do Produto: ");
		int cod = lerInt();
		for(int i = 0; i<maxIPP; i++) {
			if(carrinho.itens[i]!=null) {
				if(carrinho.itens[i].produto.getCod() == cod) {
					for(int j = i; j<maxIPP-1;j++) {
						carrinho.itens[j] = carrinho.itens[j+1];
					}
					carrinho.itens[maxIPP-1] = null;
					itCarr--;
					System.out.println("Item removido com sucesso.");
					return;
				}
			}
		}
		System.out.println("Código errado informado.");
	}
	
	public void alterarItemDoCarrinho() {
		System.out.println("Informe o Código do Produto: ");
		int cod = lerInt();
		for(int i = 0; i<maxIPP; i++) {
			if(carrinho.itens[i]!=null) {
				if(carrinho.itens[i].produto.getCod() == cod) {
					System.out.println("Nome do Produto: " + carrinho.itens[i].produto.getNome());
					System.out.println("Descrição: " + carrinho.itens[i].produto.getDescricao());
					System.out.println("Preço: " + carrinho.itens[i].produto.estoque.getPreco());
					System.out.println("Quantidade Atual: " + carrinho.itens[i].getQuantidade());
					System.out.println("Preço Total: " + carrinho.itens[i].getTotalItem());
					System.out.println("Informe a nova quantidade que deseja: (Digite 0 caso não queira alterar a quantidade)");
					int q = lerInt();
					if(q != 0) {
						if(q>carrinho.itens[i].produto.estoque.getQuantidade()) {
							System.out.println("Quantidade excede o Estoque do Produto.");
							return;
						}else {
							carrinho.itens[i].setQuantidade(q);
							System.out.println("Quantidade do Item alterada com sucesso.");
							return;
						}
					}else {
						System.out.println("Voltando...");
						return;
					}
				}
			}
		}
		System.out.println("Código errado informado.");
	}

	public void consultarCarrinho() {
		System.out.println(" - Itens no Carrinho: ");
		for(int i=0; i<maxIPP;i++) {
			if(carrinho.itens[i]!=null) {
				System.out.println(" - Nome: " + carrinho.itens[i].produto.getNome());
				System.out.println("	- Código: " + carrinho.itens[i].produto.getCod());
				System.out.println("	- Preço: " + carrinho.itens[i].produto.estoque.getPreco());
				System.out.println("	- Quantidade: " + carrinho.itens[i].getQuantidade());
				System.out.println("	- Preço Total: " + carrinho.itens[i].getTotalItem());
				System.out.println("	- Descrição: " + carrinho.itens[i].produto.getDescricao()+ "\n");
			}
		}
		System.out.println(" - Preço Total: " + carrinho.calcularTotalPedido());
	}
	
	public void finalizarPedido(Cliente cliente) {
		System.out.println("Informe seu Cartão de Crédito: ");
		String cc = sc.nextLine();
		boolean zerado = true;
		for(int j = 0; j<maxIPP; j++) {
			if(carrinho.itens[j]!=null) {
				zerado = false;
			}
		}
		if(zerado == false) {
			if(cliente.getCartaoCredito().equalsIgnoreCase(cc)) {
				for(int i =0;i<maxIPP;i++) {
					if(carrinho.itens[i]!=null) {
						carrinho.itens[i].produto.estoque.setQuantidade(carrinho.itens[i].produto.estoque.getQuantidade()-carrinho.itens[i].getQuantidade());
					}
				}
				pedidos[spPed] = carrinho;
				pedidos[spPed].setSituacao("PENDENTE");
				Date atual = new Date();
				Calendar calendario = Calendar.getInstance();
				calendario.setTime(atual);
				calendario.add(Calendar.DAY_OF_MONTH, 20);
				Date entrega = calendario.getTime();
				pedidos[spPed].setDataPedido(atual);
				pedidos[spPed].setDataEntrega(entrega);
				pedidos[spPed].setTotalItens(itCarr);
				numPed++;
				System.out.println("Pedido finalizado com sucesso.");
			}else {
				System.out.println("Cartão incorreto informado.");
			}
		}else {
			System.out.println("Você não possui nenhum item no carrinho.");
			return;
		}
	}
	
	public void consultarMeusPedidos(Cliente cliente) {
		for(int i=0;i<maxPedidos;i++) {
			if(pedidos[i]!=null) {
				Cliente c = pedidos[i].getCliente();
				if(c == cliente) {
					System.out.println(" - Pedido Número: " + pedidos[i].getNumero());
					System.out.println("	- Total Itens: " + pedidos[i].getTotalItens());
					for(int j=0; j<pedidos[i].getTotalItens();j++) {
						if(pedidos[i].itens[j]!=null) {
							if(pedidos[i].itens[j].produto.isDisponivel() == false) {
								System.out.println("		!!! Produto Removido. !!!");
							}
							System.out.println("		- Nome: " + pedidos[i].itens[j].produto.getNome());
							System.out.println("			- Código: " + pedidos[i].itens[j].produto.getCod());
							System.out.println("			- Preço: " + pedidos[i].itens[j].produto.estoque.getPreco());
							System.out.println("			- Quantidade: " + pedidos[i].itens[j].getQuantidade());
							System.out.println("			- Preço Total: " + pedidos[i].itens[j].getTotalItem());
							System.out.println("			- Descrição: " + pedidos[i].itens[j].produto.getDescricao());
						}
					}
					if (pedidos[i].getSituacao().equalsIgnoreCase("CANCELADO")){
						System.out.println("	- Situação: " + pedidos[i].getSituacao());
						System.out.println("	- Preço a ser Reembolsado: " + pedidos[i].calcularTotalPedido());
						System.out.println("	- Data do Pedido: " + pedidos[i].getDataPedido()+ "\n");
					}else {
						System.out.println("	- Preço Total: " + pedidos[i].calcularTotalPedido());
						System.out.println("	- Situação: " + pedidos[i].getSituacao());
						System.out.println("	- Data do Pedido: " + pedidos[i].getDataPedido());
						System.out.println("	- Data de Entrega: " + pedidos[i].getDataEntrega()+ "\n");
					}
				}
			}
		}
	}
	
	
	public void consultarPedido(Cliente cliente) {
		System.out.println("Informe o Número do Pedido: ");
		int num = lerInt();
		boolean achou = false;
		for(int i=0;i<maxPedidos;i++) {
			if(pedidos[i]!=null) {
				if(pedidos[i].getNumero() == num && pedidos[i].getCliente()==cliente) {
					System.out.println(" - Pedido Número: " + pedidos[i].getNumero());
					System.out.println("	- Total Itens: " + pedidos[i].getTotalItens());
					for(int j=0; j<pedidos[i].getTotalItens();j++) {
						if(pedidos[i].itens[j]!=null) {
							if(pedidos[i].itens[j].produto.isDisponivel() == false) {
								System.out.println("		!!! Produto Removido. !!!");
							}
							System.out.println("		- Nome: " + pedidos[i].itens[j].produto.getNome());
							System.out.println("			- Código: " + pedidos[i].itens[j].produto.getCod());
							System.out.println("			- Preço: " + pedidos[i].itens[j].produto.estoque.getPreco());
							System.out.println("			- Quantidade: " + pedidos[i].itens[j].getQuantidade());
							System.out.println("			- Preço Total: " + pedidos[i].itens[j].getTotalItem());
							System.out.println("			- Descrição: " + pedidos[i].itens[j].produto.getDescricao());
						}
					}
					if (pedidos[i].getSituacao().equalsIgnoreCase("CANCELADO")){
						System.out.println("	- Situação: " + pedidos[i].getSituacao());
						System.out.println("	- Preço a ser Reembolsado: " + pedidos[i].calcularTotalPedido());
						System.out.println("	- Data do Pedido: " + pedidos[i].getDataPedido());
					}else {
						System.out.println("	- Preço Total: " + pedidos[i].calcularTotalPedido());
						System.out.println("	- Situação: " + pedidos[i].getSituacao());
						System.out.println("	- Data do Pedido: " + pedidos[i].getDataPedido());
						System.out.println("	- Data de Entrega: " + pedidos[i].getDataEntrega());
					}
					achou = true;
				}
			}
		}
		
		if(achou == false) {
			System.out.println("Número incorreto informado.");
		}
	}
	
	public void cancelarPedido(Cliente cliente) {
		System.out.println("Informe o Número do Pedido: ");
		int num = lerInt();
		boolean achou = false;
		for(int i=0;i<maxPedidos;i++) {
			if(pedidos[i]!=null) {
				if(pedidos[i].getNumero() == num && pedidos[i].getCliente()==cliente) {
					if(pedidos[i].getSituacao().equalsIgnoreCase("CANCELADO")) {
						System.out.println("Pedido já cancelado.");
						return;
					}else if(pedidos[i].getSituacao().equalsIgnoreCase("ENTREGUE")) {
						System.out.println("Pedido já entregue.");
						return;
					}else {
						for(int j = 0; j<maxIPP; j++) {
							if(pedidos[i].itens[j]!=null) {
								int qt = pedidos[i].itens[j].produto.estoque.getQuantidade() + pedidos[i].itens[j].getQuantidade();
								pedidos[i].itens[j].produto.estoque.setQuantidade(qt);
							}
						}
						pedidos[i].setSituacao("CANCELADO");
						System.out.println("Pedido cancelado com sucesso.");
						System.out.println("Valor a ser reembolsado: " + pedidos[i].calcularTotalPedido());
					}
				}
			}
		}
		
		if(achou == false) {
			System.out.println("Número incorreto informado.");
		}
	}
	
	//------------------ Admin ------------------
	
	public Fornecedor getF(boolean isLogin) {
		int cod = 0;
		String login = "";
		if(isLogin == false) {
			System.out.println("Informe o Código do Fornecedor.");
			cod = lerInt();
		}else {
			System.out.println("Informe o Login do Fornecedor.");
			login = sc.nextLine();
		}
		for(int i = 0; i<maxFornecedores;i++) {
			if(fornecedores[i]!=null) {
				if(isLogin == false) {
					if(fornecedores[i].usuario.getCod() == cod) {
						return fornecedores[i];
					}
				}else {
					if(fornecedores[i].usuario.getLogin().equalsIgnoreCase(login)) {
						return fornecedores[i];
					}
				}
			}
		}
		if(isLogin==false) {
			System.out.println("Código não encontrado.");
			return null;
		}else {
			System.out.println("Login não encontrado.");
			return null;
		}
	}
	
	
	public Cliente getC(boolean isLogin) {
		int cod = 0;
		String login = "";
		if(isLogin == false) {
			System.out.println("Informe o Código do Cliente.");
			cod = lerInt();
		}else {
			System.out.println("Informe o Login do Cliente.");
			login = sc.nextLine();
		}
		for(int i = 0; i<maxClientes;i++) {
			if(clientes[i]!=null) {
				if(isLogin == false) {
					if(clientes[i].usuario.getCod() == cod) {
						return clientes[i];
					}
				}else {
					if(clientes[i].usuario.getLogin().equalsIgnoreCase(login)) {
						return clientes[i];
					}
				}
			}
		}
		if(isLogin==false) {
			System.out.println("Código não encontrado.");
			return null;
		}else {
			System.out.println("Login não encontrado.");
			return null;
		}
	}
	
	public void consultarPedidosAdm() {
		for(int i=0;i<maxPedidos;i++) {
			if(pedidos[i]!=null) {
				
					System.out.println(" - Pedido Número: " + pedidos[i].getNumero());
					System.out.println(" - Cliente: " + pedidos[i].cliente.getNome());
					System.out.println(" - Código do Cliente: " + pedidos[i].cliente.usuario.getCod());
					System.out.println("	- Total Itens: " + pedidos[i].getTotalItens());
					for(int j=0; j<pedidos[i].getTotalItens();j++) {
						if(pedidos[i].itens[j]!=null) {
							if(pedidos[i].itens[j].produto.isDisponivel() == false) {
								System.out.println("		!!! Produto Removido. !!!");
							}
							System.out.println("		- Nome: " + pedidos[i].itens[j].produto.getNome());
							System.out.println("			- Código: " + pedidos[i].itens[j].produto.getCod());
							System.out.println("			- Preço: " + pedidos[i].itens[j].produto.estoque.getPreco());
							System.out.println("			- Quantidade: " + pedidos[i].itens[j].getQuantidade());
							System.out.println("			- Preço Total: " + pedidos[i].itens[j].getTotalItem());
							System.out.println("			- Descrição: " + pedidos[i].itens[j].produto.getDescricao());
						}
					}
					if (pedidos[i].getSituacao().equalsIgnoreCase("CANCELADO")){
						System.out.println("	- Situação: " + pedidos[i].getSituacao());
						System.out.println("	- Preço a ser Reembolsado: " + pedidos[i].calcularTotalPedido());
						System.out.println("	- Data do Pedido: " + pedidos[i].getDataPedido()+ "\n");
					}else {
						System.out.println("	- Preço Total: " + pedidos[i].calcularTotalPedido());
						System.out.println("	- Situação: " + pedidos[i].getSituacao());
						System.out.println("	- Data do Pedido: " + pedidos[i].getDataPedido());
						System.out.println("	- Data de Entrega: " + pedidos[i].getDataEntrega()+ "\n");
					}
				}
			}
		}
	public void pedirContaAdm(char tipo) {
		System.out.println("Informe o código da conta: ");
		int cod = lerInt();
		if(tipo=='c') {
			for(int i=0; i<maxClientes; i++) {
				if(clientes[i]!=null) {
					if(clientes[i].usuario.getCod() == cod) {
						Menu.cliente = clientes[i];
						return;
					}
				}
			}
		} else {
			for(int i=0; i<maxFornecedores; i++) {
				if(fornecedores[i]!=null) {
					if(fornecedores[i].usuario.getCod() == cod) {
						Menu.fornecedor = fornecedores[i];
						return;
					}
				}
			}
		}
		System.out.println("Código errado informado.");
	}
	
	public void consultarContasAdm() {
		System.out.println("===Contas tipo Cliente: ===");
		for(int i = 0; i<maxClientes;i++) {
			if(clientes[i]!=null) {
				if(clientes[i].usuario.isActive()==false) {
					System.out.println(" - ===Conta Desativada.===");
				}
				System.out.println(" - Usuário: " + clientes[i].usuario.getLogin());
				System.out.println(" - Código: " + clientes[i].usuario.getCod());
				System.out.println(" - Nome: " + clientes[i].getNome() + "\n");
			}
		}
		
		System.out.println("===Contas tipo Fornecedor: ===");
		for(int i = 0; i<maxFornecedores;i++) {
			if(fornecedores[i]!=null) {
				if(fornecedores[i].usuario.isActive()==false) {
					System.out.println(" - ===Conta Desativada.===");
				}
				System.out.println(" - Usuário: " + fornecedores[i].usuario.getLogin());
				System.out.println(" - Código: " + fornecedores[i].usuario.getCod());
				System.out.println(" - Nome: " + fornecedores[i].getNome() + "\n");
			}
		}
	}
	
	public int lerInt() {
		int in = 0;
		boolean valido = false;

        do {
            String st = sc.nextLine();
            try {
                in = Integer.parseInt(st);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida. Digite um número inteiro.");
            }
        } while (!valido);
        
        return in;
	}
	
	public double lerDouble() {
		double db = 0.0;
        boolean valido = false;
        do {
            String st = sc.nextLine();
            try {
                db = Double.parseDouble(st);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Erro: entrada inválida. Digite um número decimal.");
            }
        } while (!valido);
        return db;
	}
	
	public void checarCod() {
		for(int i = 0; i<maxFornecedores; i++) {
        	if(fornecedores[i]!=null) {
        		if(fornecedores[i].usuario.getCod()==codUser) {
        			codUser++;
        		}
        	}
        }
		
		for(int i = 0; i<maxClientes; i++) {
        	if(clientes[i]!=null) {
        		if(clientes[i].usuario.getCod()==codUser) {
        			codUser++;
        		}
        	}
        }
	}
}
