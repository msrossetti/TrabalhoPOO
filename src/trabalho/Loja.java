package trabalho;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Loja {

	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	private static final int maxProdutos = 50;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

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
		Endereco endereco1 = new Endereco("Rua 1", "111", "Complemento", "Bairro 1", "11111-111", "Caxias do Sul",
				"Rio Grande do Sul");
		Endereco endereco2 = new Endereco("Rua 2", "222", "Complemento", "Bairro 2", "22222-222", "Caxias do Sul",
				"Rio Grande do Sul");
		Endereco endereco3 = new Endereco("Rua 3", "333", "Complemento", "Bairro 3", "33333-333", "Caxias do Sul",
				"Rio Grande do Sul");
		Usuario usuario1 = new Usuario("joao", "senha", 0, true);
		Usuario usuario2 = new Usuario("paulo", "senha", 1, true);
		Usuario usuario3 = new Usuario("roberto", "senha", 2, true);
		Fornecedor fornecedor1 = new Fornecedor("João", "54123456789", "joão@gmail.com", "012-345-678.99", endereco1,
				"Vendedor de Queijo", usuario1);
		Fornecedor fornecedor2 = new Fornecedor("Paulo", "54123456789", "paulo@gmail.com", "012-345-678.99", endereco2,
				"Vendedor de Queijo", usuario2);
		Fornecedor fornecedor3 = new Fornecedor("Roberto", "54123456789", "roberto@gmail.com", "012-345-678.99",
				endereco3, "Vendedor de Salame", usuario3);
		fornecedores.add(0, fornecedor1);
		fornecedores.add(1, fornecedor2);
		fornecedores.add(2, fornecedor3);
		// fornecedores[1] = fornecedor2;
		// fornecedores[2] = fornecedor3;

		Endereco endereco4 = new Endereco("Rua 4", "444", "Complemento", "Bairro 4", "44444-444", "Caxias do Sul",
				"Rio Grande do Sul");
		Endereco endereco5 = new Endereco("Rua 5", "555", "Complemento", "Bairro 5", "55555-555", "Caxias do Sul",
				"Rio Grande do Sul");
		Endereco endereco6 = new Endereco("Rua 6", "666", "Complemento", "Bairro 6", "66666-666", "Caxias do Sul",
				"Rio Grande do Sul");
		Usuario usuario4 = new Usuario("marcelo", "senha", 3, true);
		Usuario usuario5 = new Usuario("rogerio", "senha", 4, true);
		Usuario usuario6 = new Usuario("marcos", "senha", 5, true);
		Cliente cliente1 = new Cliente("Marcelo", "54123456789", "marcelo@gmail.com", "012-345-678.99", endereco4,
				"Cartão1", usuario4);
		Cliente cliente2 = new Cliente("Rogério", "54123456789", "rogerio@gmail.com", "012-345-678.99", endereco5,
				"Cartão2", usuario5);
		Cliente cliente3 = new Cliente("Marcos", "54123456789", "marcos@gmail.com", "012-345-678.99", endereco6,
				"Cartão1", usuario6);
		// clientes[0] = cliente1;
		// clientes[1] = cliente2;
		// clientes[2] = cliente3;
		clientes.add(0, cliente1);
		clientes.add(1, cliente2);
		clientes.add(2, cliente3);

		byte[] foto = null;
		Estoque estoque1 = new Estoque(10, 20);
		Estoque estoque2 = new Estoque(15, 25);
		Estoque estoque3 = new Estoque(20, 30);
		Estoque estoque4 = new Estoque(25, 35);
		Estoque estoque5 = new Estoque(10, 10);
		Estoque estoque6 = new Estoque(5, 50);
		Produto produto1 = new Produto(0, "Queijo", "Queijo Prato", foto, fornecedores.get(0), estoque1, true);
		Produto produto2 = new Produto(1, "Queijo", "Queijo Minas", foto, fornecedores.get(0), estoque2, true);
		Produto produto3 = new Produto(2, "Queijo Gorgonzola", "Queijo Gorgonzola", foto, fornecedores.get(1), estoque3,
				true);
		Produto produto4 = new Produto(3, "Queijo", "Queijo da Montanha", foto, fornecedores.get(1), estoque4, true);
		Produto produto5 = new Produto(4, "Salame", "Salame Apimentado", foto, fornecedores.get(2), estoque5, true);
		Produto produto6 = new Produto(5, "Salame e Queijo", "Salame com Queijo Prato", foto, fornecedores.get(2),
				estoque6,
				true);
		// produtos[0] = produto1;
		// produtos[1] = produto2;
		// produtos[2] = produto3;
		// produtos[3] = produto4;
		// produtos[4] = produto5;
		// produtos[5] = produto6;
		produtos.add(0, produto1);
		produtos.add(1, produto2);
		produtos.add(2, produto3);
		produtos.add(3, produto4);
		produtos.add(4, produto5);
		produtos.add(5, produto6);

		// Pedido pedido1 = new Pedido(0, clientes[0]);
		// Pedido pedido2 = new Pedido(1, clientes[0]);
		// Pedido pedido3 = new Pedido(2, clientes[1]);
		// Pedido pedido4 = new Pedido(3, clientes[1]);
		// Pedido pedido5 = new Pedido(4, clientes[2]);
		// Pedido pedido6 = new Pedido(5, clientes[2]);
		Pedido pedido1 = new Pedido(0, clientes.get(0));
		Pedido pedido2 = new Pedido(1, clientes.get(0));
		Pedido pedido3 = new Pedido(2, clientes.get(1));
		Pedido pedido4 = new Pedido(3, clientes.get(1));
		Pedido pedido5 = new Pedido(4, clientes.get(2));
		Pedido pedido6 = new Pedido(5, clientes.get(2));

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
		// ItemPedido[] itens1 = new ItemPedido[maxIPP];
		// ItemPedido[] itens2 = new ItemPedido[maxIPP];
		// ItemPedido[] itens3 = new ItemPedido[maxIPP];
		// ItemPedido[] itens4 = new ItemPedido[maxIPP];
		// ItemPedido[] itens5 = new ItemPedido[maxIPP];
		// ItemPedido[] itens6 = new ItemPedido[maxIPP];
		ItemPedido[] itens1 = new ItemPedido[pedido1.getMaxIPP()];
		ItemPedido[] itens2 = new ItemPedido[pedido2.getMaxIPP()];
		ItemPedido[] itens3 = new ItemPedido[pedido3.getMaxIPP()];
		ItemPedido[] itens4 = new ItemPedido[pedido4.getMaxIPP()];
		ItemPedido[] itens5 = new ItemPedido[pedido5.getMaxIPP()];
		ItemPedido[] itens6 = new ItemPedido[pedido6.getMaxIPP()];

		itens1[0] = new ItemPedido(produtos.get(0), 2);
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

	// Método refatorado - retorna resultado em vez de interagir com usuário
	public String cadastrarUsuario(char tipo, String login, String senha, String nome,
			String telefone, String email, String cpf,
			Endereco endereco, String cartaoOuDescricao) {
		int pos = -1;

		if (tipo == 'c') {
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i) != null) {
					if (clientes.get(i).usuario.getLogin().equalsIgnoreCase(login)) {
						return "Login já existe. Tente outro.";
					}
				} else {
					if (pos == -1)
						pos = i;
				}
			}
		} else {
			for (int i = 0; i < fornecedores.size(); i++) {
				if (fornecedores.get(i) != null) {
					if (fornecedores.get(i).usuario.getLogin().equalsIgnoreCase(login)) {
						return "Login já existe. Tente outro.";
					}
				} else {
					if (pos == -1)
						pos = i;
				}
			}
		}

		if (pos == -1) {
			return "Limite de usuários atingido.";
		}

		if (tipo == 'c') {
			checarCod();
			Usuario usuarioc = new Usuario(login, senha, codUser, true);
			clientes[pos] = new Cliente(nome, telefone, email, cpf, endereco, cartaoOuDescricao, usuarioc);
		} else {
			checarCod();
			Usuario usuariof = new Usuario(login, senha, codUser, true);
			fornecedores.set(pos, new Fornecedor(nome, telefone, email, cpf, endereco, cartaoOuDescricao, usuariof));
		}
		codUser++;
		return "Usuário cadastrado com sucesso.";
	}

	// Método refatorado - retorna objeto encontrado ou null
	public Object fazerLogin(char tipo, String login, String senha) {
		exc = false;
		return autenticarUsuario(login, senha, tipo);
	}

	private Object autenticarUsuario(String login, String senha, char tipo) {
		if (tipo == 'c') {
			for (int i = 0; i < maxClientes; i++) {
				if (clientes[i] != null) {
					if (clientes[i].usuario.getLogin().equalsIgnoreCase(login) &&
							clientes[i].usuario.getSenha().equals(senha) &&
							clientes[i].usuario.isActive()) {
						return clientes[i];
					}
				}
			}
		} else {
			for (int i = 0; i < fornecedores.size(); i++) {
				if (fornecedores.get(i) != null) {
					if (fornecedores.get(i).usuario.getLogin().equalsIgnoreCase(login) &&
							fornecedores.get(i).usuario.getSenha().equals(senha) &&
							fornecedores.get(i).usuario.isActive()) {
						return fornecedores.get(i);
					}
				}
			}
		}
		return null;
	}

	public boolean autenticaExistente(String login, char tipo) {
		if (tipo == 'c') {
			for (int i = 0; i < maxClientes; i++) {
				if (clientes[i] != null) {
					if (clientes[i].usuario.getLogin().equalsIgnoreCase(login)) {
						return true;
					}
				}
			}
		} else {
			for (int i = 0; i < maxFornecedores; i++) {
				if (fornecedores.get(i) != null) {
					if (fornecedores.get(i).usuario.getLogin().equalsIgnoreCase(login)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// Método refatorado - retorna string com informações
	public String visualizarConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
		StringBuilder info = new StringBuilder();

		if (tipo == 'c') {
			info.append("Usuário: ").append(cliente.usuario.getLogin()).append("\n");
			info.append("Senha: ").append(cliente.usuario.getSenha()).append("\n");
			info.append("CPF: ").append(cliente.getCpf()).append("\n");
			info.append("Email: ").append(cliente.getEmail()).append("\n");
			info.append("Telefone: ").append(cliente.getTelefone()).append("\n");
			info.append("Cartão de Crédito: ").append(cliente.getCartaoCredito()).append("\n");
			info.append("Endereço: \n");
			info.append("Estado: ").append(cliente.endereco.getEstado()).append("\n");
			info.append("Cidade: ").append(cliente.endereco.getCidade()).append("\n");
			info.append("Bairro: ").append(cliente.endereco.getBairro()).append("\n");
			info.append("Rua: ").append(cliente.endereco.getRua()).append("\n");
			info.append("Número: ").append(cliente.endereco.getNumero()).append("\n");
			info.append("CEP: ").append(cliente.endereco.getCep()).append("\n");
			info.append("Complemento: ").append(cliente.endereco.getComplemento()).append("\n");
		} else {
			info.append("Usuário: ").append(fornecedor.usuario.getLogin()).append("\n");
			info.append("Senha: ").append(fornecedor.usuario.getSenha()).append("\n");
			info.append("CPF: ").append(fornecedor.getCpf()).append("\n");
			info.append("Email: ").append(fornecedor.getEmail()).append("\n");
			info.append("Telefone: ").append(fornecedor.getTelefone()).append("\n");
			info.append("Descrição: ").append(fornecedor.getDescricao()).append("\n");
			info.append("Endereço: \n");
			info.append("Estado: ").append(fornecedor.endereco.getEstado()).append("\n");
			info.append("Cidade: ").append(fornecedor.endereco.getCidade()).append("\n");
			info.append("Bairro: ").append(fornecedor.endereco.getBairro()).append("\n");
			info.append("Rua: ").append(fornecedor.endereco.getRua()).append("\n");
			info.append("Número: ").append(fornecedor.endereco.getNumero()).append("\n");
			info.append("CEP: ").append(fornecedor.endereco.getCep()).append("\n");
			info.append("Complemento: ").append(fornecedor.endereco.getComplemento()).append("\n");
		}

		return info.toString();
	}

	// Método refatorado - recebe os parâmetros necessários
	public String alterarConta(char tipo, Cliente cliente, Fornecedor fornecedor, int n, String novoValor,
			Endereco novoEndereco) {
		if (tipo == 'c') {
			switch (n) {
				case 1:
					boolean autentica = autenticaExistente(novoValor, tipo);
					if (autentica == false) {
						cliente.usuario.setLogin(novoValor);
						return "Usuário alterado com sucesso.";
					} else {
						return "Usuário já existe. Tente outro.";
					}
				case 2:
					cliente.usuario.setSenha(novoValor);
					return "Senha alterada com sucesso.";
				case 3:
					cliente.setNome(novoValor);
					return "Nome alterado com sucesso.";
				case 4:
					cliente.setTelefone(novoValor);
					return "Telefone alterado com sucesso.";
				case 5:
					cliente.setEmail(novoValor);
					return "Email alterado com sucesso.";
				case 6:
					cliente.setCartaoCredito(novoValor);
					return "Cartão de Crédito alterado com sucesso.";
				case 7:
					if (novoEndereco != null) {
						cliente.endereco = novoEndereco;
						return "Endereço alterado com sucesso.";
					}
					break;
			}
		} else {
			switch (n) {
				case 1:
					boolean autentica = autenticaExistente(novoValor, tipo);
					if (autentica == false) {
						fornecedor.usuario.setLogin(novoValor);
						return "Usuário alterado com sucesso.";
					} else {
						return "Usuário já existe. Tente outro.";
					}
				case 2:
					fornecedor.usuario.setSenha(novoValor);
					return "Senha alterada com sucesso.";
				case 3:
					fornecedor.setNome(novoValor);
					return "Nome alterado com sucesso.";
				case 4:
					fornecedor.setTelefone(novoValor);
					return "Telefone alterado com sucesso.";
				case 5:
					fornecedor.setEmail(novoValor);
					return "Email alterado com sucesso.";
				case 6:
					fornecedor.setDescricao(novoValor);
					return "Descrição alterada com sucesso.";
				case 7:
					if (novoEndereco != null) {
						fornecedor.endereco = novoEndereco;
						return "Endereço alterado com sucesso.";
					}
					break;
			}
		}
		return "Erro na alteração.";
	}

	// Método refatorado - retorna string com resultado
	public String excluirConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
		StringBuilder resultado = new StringBuilder();

		if (tipo == 'c') {
			double reembolso = 0;
			cliente.usuario.setActive(false);
			for (int i = 0; i < maxPedidos; i++) {
				if (pedidos[i] != null) {
					if (pedidos[i].getCliente() == cliente && pedidos[i].getSituacao().equals("PENDENTE")) {
						pedidos[i].setSituacao("CANCELADO");
						reembolso += pedidos[i].calcularTotalPedido();
					}
				}
			}
			resultado.append("Conta removida com sucesso.\n");
			resultado.append("Pedidos pendentes Cancelados. Valor a ser reembolsado: ").append(reembolso);
		} else {
			fornecedor.usuario.setActive(false);
			for (int i = 0; i < maxProdutos; i++) {
				if (produtos[i] != null) {
					if (produtos[i].getFornecedor() == fornecedor) {
						produtos[i].setDisponivel(false);
					}
				}
			}
			resultado.append("Conta removida com sucesso.\n");
			resultado.append("Produtos associados à conta foram removidos.");
		}

		return resultado.toString();
	}

	// Método para obter informações de alteração
	public String getAlteracaoInfo(char tipo, Cliente cliente, Fornecedor fornecedor) {
		StringBuilder info = new StringBuilder();

		if (tipo == 'c') {
			info.append("1 - Alterar Usuário\n");
			info.append("Usuário Atual: ").append(cliente.usuario.getLogin()).append("\n\n");
			info.append("2 - Alterar Senha\n");
			info.append("Senha Atual: ").append(cliente.usuario.getSenha()).append("\n\n");
			info.append("3 - Alterar Nome\n");
			info.append("Nome Atual: ").append(cliente.getNome()).append("\n\n");
			info.append("4 - Alterar Telefone\n");
			info.append("Telefone Atual: ").append(cliente.getTelefone()).append("\n\n");
			info.append("5 - Alterar Email\n");
			info.append("Email Atual: ").append(cliente.getEmail()).append("\n\n");
			info.append("6 - Alterar Cartão de Crédito\n");
			info.append("Cartão de Crédito Atual: ").append(cliente.getCartaoCredito()).append("\n\n");
			info.append("7 - Alterar Endereço\n");
			info.append("Endereço Atual: \n");
			info.append("Estado: ").append(cliente.endereco.getEstado()).append("\n");
			info.append("Cidade: ").append(cliente.endereco.getCidade()).append("\n");
			info.append("Bairro: ").append(cliente.endereco.getBairro()).append("\n");
			info.append("Rua: ").append(cliente.endereco.getRua()).append("\n");
			info.append("Número: ").append(cliente.endereco.getNumero()).append("\n");
			info.append("CEP: ").append(cliente.endereco.getCep()).append("\n");
			info.append("Complemento: ").append(cliente.endereco.getComplemento()).append("\n\n");
		} else {
			info.append("1 - Alterar Usuário\n");
			info.append("Usuário Atual: ").append(fornecedor.usuario.getLogin()).append("\n\n");
			info.append("2 - Alterar Senha\n");
			info.append("Senha Atual: ").append(fornecedor.usuario.getSenha()).append("\n\n");
			info.append("3 - Alterar Nome\n");
			info.append("Nome Atual: ").append(fornecedor.getNome()).append("\n\n");
			info.append("4 - Alterar Telefone\n");
			info.append("Telefone Atual: ").append(fornecedor.getTelefone()).append("\n\n");
			info.append("5 - Alterar Email\n");
			info.append("Email Atual: ").append(fornecedor.getEmail()).append("\n\n");
			info.append("6 - Alterar Descrição\n");
			info.append("Descrição Atual: ").append(fornecedor.getDescricao()).append("\n\n");
			info.append("7 - Alterar Endereço\n");
			info.append("Endereço Atual: \n");
			info.append("Estado: ").append(fornecedor.endereco.getEstado()).append("\n");
			info.append("Cidade: ").append(fornecedor.endereco.getCidade()).append("\n");
			info.append("Bairro: ").append(fornecedor.endereco.getBairro()).append("\n");
			info.append("Rua: ").append(fornecedor.endereco.getRua()).append("\n");
			info.append("Número: ").append(fornecedor.endereco.getNumero()).append("\n");
			info.append("CEP: ").append(fornecedor.endereco.getCep()).append("\n");
			info.append("Complemento: ").append(fornecedor.endereco.getComplemento()).append("\n\n");
		}

		return info.toString();
	}

	// ------------------ Fornecedor ------------------

	// Método refatorado - retorna lista de produtos
	public String visualizarMeusProdutos(Fornecedor fornecedor) {
		StringBuilder produtos = new StringBuilder();
		boolean encontrou = false;

		for (int i = 0; i < maxProdutos; i++) {
			if (this.produtos[i] != null) {
				Fornecedor f = this.produtos[i].getFornecedor();
				if (f == fornecedor) {
					produtos.append("Código: ").append(this.produtos[i].getCod()).append("\n");
					produtos.append("Nome: ").append(this.produtos[i].getNome()).append("\n");
					produtos.append("Descrição: ").append(this.produtos[i].getDescricao()).append("\n");
					produtos.append("Preço: ").append(this.produtos[i].estoque.getPreco()).append("\n");
					produtos.append("Quantidade: ").append(this.produtos[i].estoque.getQuantidade()).append("\n");
					produtos.append("Disponível: ").append(this.produtos[i].isDisponivel() ? "Sim" : "Não")
							.append("\n\n");
					encontrou = true;
				}
			}
		}

		if (!encontrou) {
			return "Nenhum produto encontrado.";
		}

		return produtos.toString();
	}

	// Método refatorado - recebe termo de busca e retorna resultados
	public String consultarProdutos(String termoBusca, boolean admin) {
		StringBuilder resultado = new StringBuilder();
		boolean achou = false;
		String procura = termoBusca.toLowerCase();

		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] != null) {
				if (produtos[i].isDisponivel() == true || admin == true) {
					if (procura.isEmpty() ||
							produtos[i].getNome().toLowerCase().contains(procura) ||
							produtos[i].getDescricao().toLowerCase().contains(procura)) {
						resultado.append("Código: ").append(produtos[i].getCod()).append("\n");
						resultado.append("Nome: ").append(produtos[i].getNome()).append("\n");
						resultado.append("Descrição: ").append(produtos[i].getDescricao()).append("\n");
						resultado.append("Preço: ").append(produtos[i].estoque.getPreco()).append("\n");
						resultado.append("Quantidade: ").append(produtos[i].estoque.getQuantidade()).append("\n");
						resultado.append("Fornecedor: ").append(produtos[i].getFornecedor().getNome()).append("\n\n");
						achou = true;
					}
				}
			}
		}

		if (!achou) {
			return "Nenhum resultado encontrado.";
		}

		return resultado.toString();
	}

	// Método refatorado - retorna informações do produto ou null
	public String visualizarProduto(int codigo, boolean admin) {
		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getCod() == codigo && (produtos[i].isDisponivel() == true || admin == true)) {
					StringBuilder info = new StringBuilder();
					info.append("Código: ").append(produtos[i].getCod()).append("\n");
					info.append("Nome: ").append(produtos[i].getNome()).append("\n");
					info.append("Descrição: ").append(produtos[i].getDescricao()).append("\n");
					info.append("Preço: ").append(produtos[i].estoque.getPreco()).append("\n");
					info.append("Quantidade: ").append(produtos[i].estoque.getQuantidade()).append("\n");
					info.append("Fornecedor: ").append(produtos[i].getFornecedor().getNome()).append("\n");
					info.append("Disponível: ").append(produtos[i].isDisponivel() ? "Sim" : "Não").append("\n");
					return info.toString();
				}
			}
		}
		return null;
	}

	// Método refatorado - recebe login e retorna informações do fornecedor
	public String consultarFornecedor(String loginFornecedor, boolean admin) {
		for (int i = 0; i < maxFornecedores; i++) {
			if (fornecedores.get(i) != null) {
				if (fornecedores.get(i).usuario.getLogin().equalsIgnoreCase(loginFornecedor)) {
					StringBuilder info = new StringBuilder();
					info.append("Nome: ").append(fornecedores.get(i).getNome()).append("\n");
					info.append("Login: ").append(fornecedores.get(i).usuario.getLogin()).append("\n");
					info.append("Email: ").append(fornecedores.get(i).getEmail()).append("\n");
					info.append("Telefone: ").append(fornecedores.get(i).getTelefone()).append("\n");
					info.append("Descrição: ").append(fornecedores.get(i).getDescricao()).append("\n");
					return info.toString();
				}
			}
		}
		return null;
	}

	// Método refatorado - recebe parâmetros do produto
	public String cadastrarProduto(Fornecedor fornecedor, String nome, String descricao,
			int quantidade, double preco) {
		if (preco <= 0) {
			return "Preço deve ser maior que zero.";
		}

		int pos = -1;
		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] == null && pos == -1) {
				pos = i;
			}
		}

		if (pos == -1) {
			return "Limite de Produtos atingido.";
		}

		byte[] foto = null;
		Estoque estoque = new Estoque(quantidade, preco);

		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getCod() == codProd) {
					codProd++;
					i = -1; // reinicia o loop
				}
			}
		}

		produtos[pos] = new Produto(codProd, nome, descricao, foto, fornecedor, estoque, true);
		codProd++;

		return "Produto cadastrado com sucesso!";
	}

	// Método refatorado - busca produto por código
	public Produto buscarProdutoFornecedor(int codigo, Fornecedor fornecedor) {
		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getCod() == codigo && produtos[i].getFornecedor() == fornecedor) {
					s = i;
					return produtos[i];
				}
			}
		}
		return null;
	}

	// Método refatorado - altera produto
	public String alterarProduto(int n, String novoValor, double novoPreco, int novaQuantidade) {
		switch (n) {
			case 1:
				if (novoPreco <= 0) {
					return "Não é possível colocar este preço.";
				}
				produtos[s].estoque.setPreco(novoPreco);
				return "Preço alterado com sucesso.";
			case 2:
				produtos[s].estoque.setQuantidade(novaQuantidade);
				return "Estoque alterado com sucesso.";
			case 3:
				produtos[s].setNome(novoValor);
				return "Nome alterado com sucesso.";
			case 4:
				// Implementar alteração de foto se necessário
				return "Foto alterada com sucesso.";
			case 5:
				produtos[s].setDescricao(novoValor);
				return "Descrição alterada com sucesso.";
		}
		return "Erro na alteração.";
	}

	public String removerProduto() {
		produtos[s].setDisponivel(false);
		produtos[s].estoque.setQuantidade(0);
		return "Produto removido com sucesso, referência mantida para pedidos antigos.";
	}

	// Método para obter informações de alteração de produto
	public String getAlteracaoProdutoInfo() {
		StringBuilder info = new StringBuilder();
		info.append("1 - Alterar Preço\n");
		info.append("Preço atual: ").append(produtos[s].estoque.getPreco()).append("\n\n");
		info.append("2 - Alterar Quantidade de Estoque\n");
		info.append("Quantidade Atual: ").append(produtos[s].estoque.getQuantidade()).append("\n\n");
		info.append("3 - Alterar Nome\n");
		info.append("Nome atual: ").append(produtos[s].getNome()).append("\n\n");
		info.append("4 - Alterar Foto\n");
		info.append("Foto atual: ").append(produtos[s].getFoto()).append("\n\n");
		info.append("5 - Alterar Descricao\n");
		info.append("Descrição atual: ").append(produtos[s].getDescricao()).append("\n\n");
		return info.toString();
	}

	// ------------------ Cliente ------------------

	public boolean autenticaNumPedidos(Cliente cliente) {
		for (int i = 0; i < maxPedidos; i++) {
			if (pedidos[i] != null) {
				if (pedidos[i].getNumero() == numPed) {
					numPed++;
					i = -1; // reinicia o loop
				}
			}
		}
		for (int i = 0; i < maxPedidos; i++) {
			if (pedidos[i] == null) {
				itCarr = 0;
				spPed = i;
				carrinho = new Pedido(numPed, cliente);
				return true;
			}
		}
		return false;
	}

	// Método refatorado - adiciona item ao carrinho
	public String adicionarItemAoCarrinho(int codigo, int quantidade) {
		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getCod() == codigo) {
					if (!produtos[i].isDisponivel()) {
						return "Produto não está disponível.";
					}
					if (produtos[i].estoque.getQuantidade() < quantidade) {
						return "Quantidade insuficiente em estoque.";
					}

					// Verifica se já existe no carrinho
					for (int j = 0; j < maxIPP; j++) {
						if (carrinho.itens[j] != null && carrinho.itens[j].produto.getCod() == codigo) {
							carrinho.itens[j].setQuantidade(carrinho.itens[j].getQuantidade() + quantidade);
							return "Quantidade do item atualizada no carrinho.";
						}
					}

					// Adiciona novo item
					for (int j = 0; j < maxIPP; j++) {
						if (carrinho.itens[j] == null) {
							carrinho.itens[j] = new ItemPedido(produtos[i], quantidade);
							itCarr++;
							return "Item adicionado ao carrinho com sucesso.";
						}
					}
					return "Carrinho cheio.";
				}
			}
		}
		return "Código não encontrado.";
	}

	// Método refatorado - remove item do carrinho
	public String removerItemDoCarrinho(int codigo) {
		for (int i = 0; i < maxIPP; i++) {
			if (carrinho.itens[i] != null) {
				if (carrinho.itens[i].produto.getCod() == codigo) {
					carrinho.itens[i] = null;
					itCarr--;
					return "Item removido do carrinho com sucesso.";
				}
			}
		}
		return "Código não encontrado no carrinho.";
	}

	// Método refatorado - altera quantidade do item
	public String alterarItemDoCarrinho(int codigo, int novaQuantidade) {
		if (novaQuantidade <= 0) {
			return "Quantidade deve ser maior que zero.";
		}

		for (int i = 0; i < maxIPP; i++) {
			if (carrinho.itens[i] != null) {
				if (carrinho.itens[i].produto.getCod() == codigo) {
					if (carrinho.itens[i].produto.estoque.getQuantidade() < novaQuantidade) {
						return "Quantidade insuficiente em estoque.";
					}
					carrinho.itens[i].setQuantidade(novaQuantidade);
					return "Quantidade alterada com sucesso.";
				}
			}
		}
		return "Código não encontrado no carrinho.";
	}

	// Método refatorado - retorna informações do carrinho
	public String consultarCarrinho() {
		StringBuilder info = new StringBuilder();
		info.append(" - Itens no Carrinho: \n");

		for (int i = 0; i < maxIPP; i++) {
			if (carrinho.itens[i] != null) {
				info.append(" - Nome: ").append(carrinho.itens[i].produto.getNome()).append("\n");
				info.append("	- Código: ").append(carrinho.itens[i].produto.getCod()).append("\n");
				info.append("	- Preço: ").append(carrinho.itens[i].produto.estoque.getPreco()).append("\n");
				info.append("	- Quantidade: ").append(carrinho.itens[i].getQuantidade()).append("\n");
				info.append("	- Preço Total: ").append(carrinho.itens[i].getTotalItem()).append("\n");
				info.append("	- Descrição: ").append(carrinho.itens[i].produto.getDescricao()).append("\n\n");
			}
		}
		info.append(" - Preço Total: ").append(carrinho.calcularTotalPedido());

		return info.toString();
	}

	// Método refatorado - finaliza pedido
	public String finalizarPedido(Cliente cliente, String cartaoCredito) {
		boolean zerado = true;
		for (int j = 0; j < maxIPP; j++) {
			if (carrinho.itens[j] != null) {
				zerado = false;
			}
		}

		if (zerado) {
			return "Você não possui nenhum item no carrinho.";
		}

		if (!cliente.getCartaoCredito().equalsIgnoreCase(cartaoCredito)) {
			return "Cartão incorreto informado.";
		}

		// Verifica estoque
		for (int i = 0; i < maxIPP; i++) {
			if (carrinho.itens[i] != null) {
				if (carrinho.itens[i].produto.estoque.getQuantidade() < carrinho.itens[i].getQuantidade()) {
					return "Estoque insuficiente para o produto: " + carrinho.itens[i].produto.getNome();
				}
			}
		}

		// Atualiza estoque
		for (int i = 0; i < maxIPP; i++) {
			if (carrinho.itens[i] != null) {
				carrinho.itens[i].produto.estoque.setQuantidade(
						carrinho.itens[i].produto.estoque.getQuantidade() - carrinho.itens[i].getQuantidade());
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

		return "Pedido finalizado com sucesso.";
	}

	// Método refatorado - consulta pedidos do cliente
	public String consultarMeusPedidos(Cliente cliente) {
		StringBuilder pedidosInfo = new StringBuilder();
		boolean encontrou = false;

		for (int i = 0; i < maxPedidos; i++) {
			if (pedidos[i] != null) {
				Cliente c = pedidos[i].getCliente();
				if (c == cliente) {
					pedidosInfo.append("Número: ").append(pedidos[i].getNumero()).append("\n");
					pedidosInfo.append("Data do Pedido: ").append(pedidos[i].getDataPedido()).append("\n");
					pedidosInfo.append("Data de Entrega: ").append(pedidos[i].getDataEntrega()).append("\n");
					pedidosInfo.append("Situação: ").append(pedidos[i].getSituacao()).append("\n");
					pedidosInfo.append("Total: ").append(pedidos[i].calcularTotalPedido()).append("\n\n");
					encontrou = true;
				}
			}
		}

		if (!encontrou) {
			return "Nenhum pedido encontrado.";
		}

		return pedidosInfo.toString();
	}

	// Método refatorado - consulta pedido específico
	public String consultarPedido(Cliente cliente, int numeroPedido) {
		for (int i = 0; i < maxPedidos; i++) {
			if (pedidos[i] != null) {
				if (pedidos[i].getNumero() == numeroPedido && pedidos[i].getCliente() == cliente) {
					StringBuilder info = new StringBuilder();
					info.append("Número: ").append(pedidos[i].getNumero()).append("\n");
					info.append("Data do Pedido: ").append(pedidos[i].getDataPedido()).append("\n");
					info.append("Data de Entrega: ").append(pedidos[i].getDataEntrega()).append("\n");
					info.append("Situação: ").append(pedidos[i].getSituacao()).append("\n");
					info.append("Total de Itens: ").append(pedidos[i].getTotalItens()).append("\n");
					info.append("Itens:\n");

					for (int j = 0; j < maxIPP; j++) {
						if (pedidos[i].itens[j] != null) {
							info.append(" - ").append(pedidos[i].itens[j].produto.getNome())
									.append(" (Qtd: ").append(pedidos[i].itens[j].getQuantidade())
									.append(", Preço: ").append(pedidos[i].itens[j].getTotalItem()).append(")\n");
						}
					}

					info.append("Total do Pedido: ").append(pedidos[i].calcularTotalPedido()).append("\n");
					return info.toString();
				}
			}
		}
		return null;
	}

	// Método refatorado - cancela pedido
	public String cancelarPedido(Cliente cliente, int numeroPedido) {
		for (int i = 0; i < maxPedidos; i++) {
			if (pedidos[i] != null) {
				if (pedidos[i].getNumero() == numeroPedido && pedidos[i].getCliente() == cliente) {
					if (!pedidos[i].getSituacao().equals("PENDENTE")) {
						return "Pedido não pode ser cancelado pois não está pendente.";
					}

					// Restaura estoque
					for (int j = 0; j < maxIPP; j++) {
						if (pedidos[i].itens[j] != null) {
							pedidos[i].itens[j].produto.estoque.setQuantidade(
									pedidos[i].itens[j].produto.estoque.getQuantidade()
											+ pedidos[i].itens[j].getQuantidade());
						}
					}

					pedidos[i].setSituacao("CANCELADO");
					return "Pedido cancelado com sucesso. Estoque restaurado.";
				}
			}
		}
		return "Número de pedido não encontrado.";
	}

	// ------------------ Admin ------------------

	public Fornecedor getF(boolean isLogin, int codigo, String login) {
		for (int i = 0; i < maxFornecedores; i++) {
			if (fornecedores.get(i) != null) {
				if (isLogin == false) {
					if (fornecedores.get(i).usuario.getCod() == codigo) {
						return fornecedores.get(i);
					}
				} else {
					if (fornecedores.get(i).usuario.getLogin().equalsIgnoreCase(login)) {
						return fornecedores.get(i);
					}
				}
			}
		}
		return null;
	}

	public Cliente getC(boolean isLogin, int codigo, String login) {
		for (int i = 0; i < maxClientes; i++) {
			if (clientes[i] != null) {
				if (isLogin == false) {
					if (clientes[i].usuario.getCod() == codigo) {
						return clientes[i];
					}
				} else {
					if (clientes[i].usuario.getLogin().equalsIgnoreCase(login)) {
						return clientes[i];
					}
				}
			}
		}
		return null;
	}

	public String consultarPedidosAdm() {
		StringBuilder pedidosInfo = new StringBuilder();
		boolean encontrou = false;

		for (int i = 0; i < maxPedidos; i++) {
			if (pedidos[i] != null) {
				pedidosInfo.append(" - Pedido Número: ").append(pedidos[i].getNumero()).append("\n");
				pedidosInfo.append(" - Cliente: ").append(pedidos[i].cliente.getNome()).append("\n");
				pedidosInfo.append(" - Situação: ").append(pedidos[i].getSituacao()).append("\n");
				pedidosInfo.append(" - Total: ").append(pedidos[i].calcularTotalPedido()).append("\n\n");
				encontrou = true;
			}
		}

		if (!encontrou) {
			return "Nenhum pedido encontrado.";
		}

		return pedidosInfo.toString();
	}

	public Object buscarContaAdm(char tipo, int codigo) {
		if (tipo == 'c') {
			for (int i = 0; i < maxClientes; i++) {
				if (clientes[i] != null && clientes[i].usuario.getCod() == codigo) {
					return clientes[i];
				}
			}
		} else {
			for (int i = 0; i < maxFornecedores; i++) {
				if (fornecedores.get(i) != null && fornecedores.get(i).usuario.getCod() == codigo) {
					return fornecedores.get(i);
				}
			}
		}
		return null;
	}

	public String consultarContasAdm() {
		StringBuilder info = new StringBuilder();
		info.append("===Contas tipo Cliente: ===\n");

		for (int i = 0; i < maxClientes; i++) {
			if (clientes[i] != null) {
				info.append(" - Código: ").append(clientes[i].usuario.getCod()).append("\n");
				info.append(" - Nome: ").append(clientes[i].getNome()).append("\n");
				info.append(" - Login: ").append(clientes[i].usuario.getLogin()).append("\n");
				info.append(" - Ativo: ").append(clientes[i].usuario.isActive() ? "Sim" : "Não").append("\n\n");
			}
		}

		info.append("===Contas tipo Fornecedor: ===\n");
		for (int i = 0; i < maxFornecedores; i++) {
			if (fornecedores.get(i) != null) {
				info.append(" - Código: ").append(fornecedores.get(i).usuario.getCod()).append("\n");
				info.append(" - Nome: ").append(fornecedores.get(i).getNome()).append("\n");
				info.append(" - Login: ").append(fornecedores.get(i).usuario.getLogin()).append("\n");
				info.append(" - Ativo: ").append(fornecedores.get(i).usuario.isActive() ? "Sim" : "Não").append("\n\n");
			}
		}

		return info.toString();
	}

	// ------------------ Transferência de Produtos ------------------

	// Método para buscar produto por código (para admin)
	public Produto buscarProdutoPorCodigo(int codigo) {
		for (int i = 0; i < maxProdutos; i++) {
			if (produtos[i] != null && produtos[i].getCod() == codigo) {
				return produtos[i];
			}
		}
		return null;
	}

	// Método para buscar fornecedor por login
	public Fornecedor buscarFornecedorPorLogin(String login) {
		for (int i = 0; i < maxFornecedores; i++) {
			if (fornecedores.get(i) != null &&
					fornecedores.get(i).usuario.getLogin().equalsIgnoreCase(login) &&
					fornecedores.get(i).usuario.isActive()) {
				return fornecedores.get(i);
			}
		}
		return null;
	}

	// Método para transferir produto entre fornecedores
	public String transferirProduto(int codigoProduto, String loginFornecedorDestino) {
		// Busca o produto
		Produto produto = buscarProdutoPorCodigo(codigoProduto);
		if (produto == null) {
			return "Produto não encontrado.";
		}

		// Busca o fornecedor de destino
		Fornecedor fornecedorDestino = buscarFornecedorPorLogin(loginFornecedorDestino);
		if (fornecedorDestino == null) {
			return "Fornecedor de destino não encontrado ou inativo.";
		}

		// Verifica se o produto já não pertence ao fornecedor de destino
		if (produto.getFornecedor() == fornecedorDestino) {
			return "O produto já pertence a este fornecedor.";
		}

		// Guarda informações do fornecedor original
		Fornecedor fornecedorOriginal = produto.getFornecedor();

		// Realiza a transferência
		produto.setFornecedor(fornecedorDestino);

		return String.format("Produto '%s' (Código: %d) transferido com sucesso de '%s' para '%s'.",
				produto.getNome(),
				produto.getCod(),
				fornecedorOriginal.getNome(),
				fornecedorDestino.getNome());
	}

	// Método para listar produtos de um fornecedor específico (para admin)
	public String listarProdutosFornecedor(String loginFornecedor) {
		Fornecedor fornecedor = buscarFornecedorPorLogin(loginFornecedor);
		if (fornecedor == null) {
			return "Fornecedor não encontrado.";
		}

		StringBuilder produtos = new StringBuilder();
		produtos.append("Produtos do fornecedor: ").append(fornecedor.getNome()).append("\n\n");

		boolean encontrou = false;
		for (int i = 0; i < maxProdutos; i++) {
			if (this.produtos[i] != null && this.produtos[i].getFornecedor() == fornecedor) {
				produtos.append("Código: ").append(this.produtos[i].getCod()).append("\n");
				produtos.append("Nome: ").append(this.produtos[i].getNome()).append("\n");
				produtos.append("Descrição: ").append(this.produtos[i].getDescricao()).append("\n");
				produtos.append("Preço: ").append(this.produtos[i].estoque.getPreco()).append("\n");
				produtos.append("Quantidade: ").append(this.produtos[i].estoque.getQuantidade()).append("\n");
				produtos.append("Disponível: ").append(this.produtos[i].isDisponivel() ? "Sim" : "Não").append("\n\n");
				encontrou = true;
			}
		}

		if (!encontrou) {
			produtos.append("Este fornecedor não possui produtos cadastrados.");
		}

		return produtos.toString();
	}

	// Método para listar todos os fornecedores ativos (para facilitar a
	// transferência)
	public String listarFornecedoresAtivos() {
		StringBuilder fornecedores = new StringBuilder();
		fornecedores.append("Fornecedores ativos:\n\n");

		boolean encontrou = false;
		for (int i = 0; i < maxFornecedores; i++) {
			if (this.fornecedores.get(i) != null && this.fornecedores.get(i).usuario.isActive()) {
				fornecedores.append("Login: ").append(this.fornecedores.get(i).usuario.getLogin()).append("\n");
				fornecedores.append("Nome: ").append(this.fornecedores.get(i).getNome()).append("\n");
				fornecedores.append("Email: ").append(this.fornecedores.get(i).getEmail()).append("\n\n");
				encontrou = true;
			}
		}

		if (!encontrou) {
			fornecedores.append("Nenhum fornecedor ativo encontrado.");
		}

		return fornecedores.toString();
	}

	private void checarCod() {
		for (int i = 0; i < maxFornecedores; i++) {
			if (fornecedores.get(i) != null) {
				if (fornecedores.get(i).usuario.getCod() == codUser) {
					codUser++;
					i = -1; // reinicia o loop
				}
			}
		}

		for (int i = 0; i < maxClientes; i++) {
			if (clientes[i] != null) {
				if (clientes[i].usuario.getCod() == codUser) {
					codUser++;
					i = -1; // reinicia o loop
				}
			}
		}
	}
}
