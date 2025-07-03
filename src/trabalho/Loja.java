package trabalho;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Loja {

	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
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

	// Getters e setters para persistência
	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public int getCodUser() {
		return codUser;
	}

	public void setCodUser(int codUser) {
		this.codUser = codUser;
	}

	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public int getNumPed() {
		return numPed;
	}

	public void setNumPed(int numPed) {
		this.numPed = numPed;
	}

	// Método refatorado - retorna resultado em vez de interagir com usuário
	public String cadastrarUsuario(char tipo, String login, String senha, String nome,
			String telefone, String email, String cpf,
			Endereco endereco, String cartaoOuDescricao) {
		int pos = -1;

		if (tipo == 'c') {
			// Verifica se login já existe
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
			// Se não encontrou posição vazia, adiciona no final
			if (pos == -1) {
				pos = clientes.size();
			}
		} else {
			// Verifica se login já existe para fornecedores
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
			// Se não encontrou posição vazia, adiciona no final
			if (pos == -1) {
				pos = fornecedores.size();
			}
		}

		if (tipo == 'c') {
			checarCod();
			Usuario usuarioc = new Usuario(login, senha, codUser, true);
			// Ensure the ArrayList is large enough
			while (clientes.size() <= pos) {
				clientes.add(null);
			}
			clientes.set(pos, new Cliente(nome, telefone, email, cpf, endereco, cartaoOuDescricao, usuarioc));
		} else {
			checarCod();
			Usuario usuariof = new Usuario(login, senha, codUser, true);
			// Ensure the ArrayList is large enough
			while (fornecedores.size() <= pos) {
				fornecedores.add(null);
			}
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
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i) != null) {
					if (clientes.get(i).usuario.getLogin().equalsIgnoreCase(login) &&
							clientes.get(i).usuario.getSenha().equals(senha) &&
							clientes.get(i).usuario.isActive()) {
						return clientes.get(i);
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
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i) != null) {
					if (clientes.get(i).usuario.getLogin().equalsIgnoreCase(login)) {
						return true;
					}
				}
			}
		} else {
			for (int i = 0; i < fornecedores.size(); i++) {
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
			for (int i = 0; i < pedidos.size(); i++) {
				if (pedidos.get(i) != null) {
					// Compara pelo código do usuário (mais seguro que comparar objetos)
					if (pedidos.get(i).getCliente().usuario.getCod() == cliente.usuario.getCod() && 
					    pedidos.get(i).getSituacao().equals("PENDENTE")) {
						
						// Restaura estoque antes de cancelar
						for (int j = 0; j < pedidos.get(i).getMaxIPP(); j++) {
							if (pedidos.get(i).itens[j] != null) {
								// Busca o produto na lista principal pelo código
								int codigoProduto = pedidos.get(i).itens[j].produto.getCod();
								Produto produtoNaLista = buscarProdutoPorCodigo(codigoProduto);
								
								if (produtoNaLista != null) {
									produtoNaLista.estoque.setQuantidade(
										produtoNaLista.estoque.getQuantidade() + pedidos.get(i).itens[j].getQuantidade());
								}
							}
						}
						
						pedidos.get(i).setSituacao("CANCELADO");
						reembolso += pedidos.get(i).calcularTotalPedido();
					}
				}
			}
			resultado.append("Conta removida com sucesso.\n");
			resultado.append("Pedidos pendentes Cancelados. Valor a ser reembolsado: ").append(reembolso);
		} else {
			fornecedor.usuario.setActive(false);
			for (int i = 0; i < produtos.size(); i++) {
				if (produtos.get(i) != null) {
					if (produtos.get(i).getFornecedor() == fornecedor) {
						produtos.get(i).setDisponivel(false);
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

		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i) != null) {
				Fornecedor f = this.produtos.get(i).getFornecedor();
				if (f == fornecedor) {
					produtos.append("Código: ").append(this.produtos.get(i).getCod()).append("\n");
					produtos.append("Nome: ").append(this.produtos.get(i).getNome()).append("\n");
					produtos.append("Descrição: ").append(this.produtos.get(i).getDescricao()).append("\n");
					produtos.append("Preço: ").append(this.produtos.get(i).estoque.getPreco()).append("\n");
					produtos.append("Quantidade: ").append(this.produtos.get(i).estoque.getQuantidade()).append("\n");
					produtos.append("Disponível: ").append(this.produtos.get(i).isDisponivel() ? "Sim" : "Não")
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

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) != null) {
				if (produtos.get(i).isDisponivel() == true || admin == true) {
					if (procura.isEmpty() ||
							produtos.get(i).getNome().toLowerCase().contains(procura) ||
							produtos.get(i).getDescricao().toLowerCase().contains(procura)) {
						resultado.append("Código: ").append(produtos.get(i).getCod()).append("\n");
						resultado.append("Nome: ").append(produtos.get(i).getNome()).append("\n");
						resultado.append("Descrição: ").append(produtos.get(i).getDescricao()).append("\n");
						resultado.append("Preço: ").append(produtos.get(i).estoque.getPreco()).append("\n");
						resultado.append("Quantidade: ").append(produtos.get(i).estoque.getQuantidade()).append("\n");
						resultado.append("Fornecedor: ").append(produtos.get(i).getFornecedor().getNome())
								.append("\n\n");
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
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) != null) {
				if (produtos.get(i).getCod() == codigo && (produtos.get(i).isDisponivel() == true || admin == true)) {
					StringBuilder info = new StringBuilder();
					info.append("Código: ").append(produtos.get(i).getCod()).append("\n");
					info.append("Nome: ").append(produtos.get(i).getNome()).append("\n");
					info.append("Descrição: ").append(produtos.get(i).getDescricao()).append("\n");
					info.append("Preço: ").append(produtos.get(i).estoque.getPreco()).append("\n");
					info.append("Quantidade: ").append(produtos.get(i).estoque.getQuantidade()).append("\n");
					info.append("Fornecedor: ").append(produtos.get(i).getFornecedor().getNome()).append("\n");
					info.append("Disponível: ").append(produtos.get(i).isDisponivel() ? "Sim" : "Não").append("\n");
					return info.toString();
				}
			}
		}
		return null;
	}

	// Método refatorado - recebe login e retorna informações do fornecedor
	public String consultarFornecedor(String loginFornecedor, boolean admin) {
		for (int i = 0; i < fornecedores.size(); i++) {
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
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) == null && pos == -1) {
				pos = i;
			}
		}

		if (pos == -1) {
			pos = produtos.size();
		}

		byte[] foto = null;
		Estoque estoque = new Estoque(quantidade, preco);

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) != null) {
				if (produtos.get(i).getCod() == codProd) {
					codProd++;
					i = -1; // reinicia o loop
				}
			}
		}

		// Ensure the ArrayList is large enough
		while (produtos.size() <= pos) {
			produtos.add(null);
		}
		produtos.set(pos, new Produto(codProd, nome, descricao, foto, fornecedor, estoque, true));
		codProd++;

		return "Produto cadastrado com sucesso!";
	}

	// Método refatorado - busca produto por código
	public Produto buscarProdutoFornecedor(int codigo, Fornecedor fornecedor) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) != null) {
				if (produtos.get(i).getCod() == codigo && produtos.get(i).getFornecedor() == fornecedor) {
					s = i;
					return produtos.get(i);
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
				produtos.get(s).estoque.setPreco(novoPreco);
				return "Preço alterado com sucesso.";
			case 2:
				produtos.get(s).estoque.setQuantidade(novaQuantidade);
				return "Estoque alterado com sucesso.";
			case 3:
				produtos.get(s).setNome(novoValor);
				return "Nome alterado com sucesso.";
			case 4:
				// Implementar alteração de foto se necessário
				return "Foto alterada com sucesso.";
			case 5:
				produtos.get(s).setDescricao(novoValor);
				return "Descrição alterada com sucesso.";
		}
		return "Erro na alteração.";
	}

	public String removerProduto() {
		produtos.get(s).setDisponivel(false);
		produtos.get(s).estoque.setQuantidade(0);
		return "Produto removido com sucesso, referência mantida para pedidos antigos.";
	}

	// Método para obter informações de alteração de produto
	public String getAlteracaoProdutoInfo() {
		StringBuilder info = new StringBuilder();
		info.append("1 - Alterar Preço\n");
		info.append("Preço atual: ").append(produtos.get(s).estoque.getPreco()).append("\n\n");
		info.append("2 - Alterar Quantidade de Estoque\n");
		info.append("Quantidade Atual: ").append(produtos.get(s).estoque.getQuantidade()).append("\n\n");
		info.append("3 - Alterar Nome\n");
		info.append("Nome atual: ").append(produtos.get(s).getNome()).append("\n\n");
		info.append("4 - Alterar Foto\n");
		info.append("Foto atual: ").append(produtos.get(s).getFoto()).append("\n\n");
		info.append("5 - Alterar Descricao\n");
		info.append("Descrição atual: ").append(produtos.get(s).getDescricao()).append("\n\n");
		return info.toString();
	}

	// ------------------ Cliente ------------------

	public boolean autenticaNumPedidos(Cliente cliente) {
		// Se já existe um carrinho ativo, reutiliza
		if (carrinho != null && carrinho.getCliente() == cliente) {
			return true;
		}

		// Garante que o numero do pedido seja único
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i) != null) {
				if (pedidos.get(i).getNumero() == numPed) {
					numPed++;
					i = -1; // reinicia o loop
				}
			}
		}

		// Encontra uma posição vazia ou adiciona no final
		spPed = -1;
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i) == null) {
				spPed = i;
				break;
			}
		}

		// Se não encontrou posição vazia, adiciona no final
		if (spPed == -1) {
			spPed = pedidos.size();
		}

		// Cria novo carrinho
		itCarr = 0;
		carrinho = new Pedido(numPed, cliente);
		return true;
	}

	// Método público para inicializar carrinho
	public String inicializarCarrinho(Cliente cliente) {
		if (autenticaNumPedidos(cliente)) {
			return "Carrinho inicializado com sucesso.";
		} else {
			return "Erro ao inicializar carrinho.";
		}
	}

	// Método para limpar carrinho
	public String limparCarrinho() {
		if (carrinho != null) {
			carrinho = null;
			itCarr = 0;
			spPed = 0;
			return "Carrinho limpo com sucesso.";
		}
		return "Carrinho já estava vazio.";
	}

	// Método para verificar se carrinho está ativo
	public boolean temCarrinhoAtivo() {
		return carrinho != null;
	}

	// Método refatorado - adiciona item ao carrinho
	public String adicionarItemAoCarrinho(int codigo, int quantidade) {
		// Verifica se o carrinho existe, se não existir, não pode adicionar itens
		if (carrinho == null) {
			return "Erro: Carrinho não inicializado. Tente novamente.";
		}

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) != null) {
				if (produtos.get(i).getCod() == codigo) {
					if (!produtos.get(i).isDisponivel()) {
						return "Produto não está disponível.";
					}
					if (produtos.get(i).estoque.getQuantidade() < quantidade) {
						return "Quantidade insuficiente em estoque.";
					}

					// Verifica se já existe no carrinho
					for (int j = 0; j < carrinho.getMaxIPP(); j++) {
						if (carrinho.itens[j] != null && carrinho.itens[j].produto.getCod() == codigo) {
							carrinho.itens[j].setQuantidade(carrinho.itens[j].getQuantidade() + quantidade);
							return "Quantidade do item atualizada no carrinho.";
						}
					}

					// Adiciona novo item
					for (int j = 0; j < carrinho.getMaxIPP(); j++) {
						if (carrinho.itens[j] == null) {
							carrinho.itens[j] = new ItemPedido(produtos.get(i), quantidade);
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
		if (carrinho == null) {
			return "Carrinho vazio. Adicione itens antes de tentar remover.";
		}

		for (int i = 0; i < carrinho.getMaxIPP(); i++) {
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
		if (carrinho == null) {
			return "Carrinho vazio. Adicione itens antes de tentar alterar.";
		}

		if (novaQuantidade <= 0) {
			return "Quantidade deve ser maior que zero.";
		}

		for (int i = 0; i < carrinho.getMaxIPP(); i++) {
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
		if (carrinho == null) {
			return "Carrinho vazio. Adicione itens antes de consultar.";
		}

		StringBuilder info = new StringBuilder();
		info.append(" - Itens no Carrinho: \n");

		for (int i = 0; i < carrinho.getMaxIPP(); i++) {
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
		if (carrinho == null) {
			return "Carrinho vazio. Adicione itens antes de finalizar o pedido.";
		}

		boolean zerado = true;
		for (int j = 0; j < carrinho.getMaxIPP(); j++) {
			if (carrinho.itens[j] != null) {
				zerado = false;
			}
		}

		if (zerado) {
			return "Você não possui nenhum item no carrinho.";
		}

		// Debug: mostra informações do cartão
		System.out.println("DEBUG - Nome do cliente: '" + cliente.getNome() + "'");
		System.out.println("DEBUG - Login do cliente: '" + cliente.usuario.getLogin() + "'");
		System.out.println("DEBUG - Cartão do cliente: '" + cliente.getCartaoCredito() + "'");
		System.out.println("DEBUG - Cartão informado: '" + cartaoCredito + "'");

		// Verificação de nulos
		if (cliente.getCartaoCredito() == null) {
			return "Erro: Cliente não possui cartão de crédito cadastrado.";
		}

		System.out.println(
				"DEBUG - São iguais (ignoreCase): " + cliente.getCartaoCredito().equalsIgnoreCase(cartaoCredito));

		if (!cliente.getCartaoCredito().equalsIgnoreCase(cartaoCredito)) {
			return "Cartão incorreto informado.";
		}

		// Verifica estoque
		for (int i = 0; i < carrinho.getMaxIPP(); i++) {
			if (carrinho.itens[i] != null) {
				if (carrinho.itens[i].produto.estoque.getQuantidade() < carrinho.itens[i].getQuantidade()) {
					return "Estoque insuficiente para o produto: " + carrinho.itens[i].produto.getNome();
				}
			}
		}

		// Atualiza estoque
		for (int i = 0; i < carrinho.getMaxIPP(); i++) {
			if (carrinho.itens[i] != null) {
				carrinho.itens[i].produto.estoque.setQuantidade(
						carrinho.itens[i].produto.estoque.getQuantidade() - carrinho.itens[i].getQuantidade());
			}
		}

		// Ensure the ArrayList is large enough
		while (pedidos.size() <= spPed) {
			pedidos.add(null);
		}
		pedidos.set(spPed, carrinho);
		pedidos.get(spPed).setSituacao("PENDENTE");
		Date atual = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(atual);
		calendario.add(Calendar.DAY_OF_MONTH, 20);
		Date entrega = calendario.getTime();
		pedidos.get(spPed).setDataPedido(atual);
		pedidos.get(spPed).setDataEntrega(entrega);
		pedidos.get(spPed).setTotalItens(itCarr);
		numPed++;

		// Limpa o carrinho após finalizar o pedido
		carrinho = null;
		itCarr = 0;
		spPed = 0;

		return "Pedido finalizado com sucesso.";
	}

	// Método refatorado - consulta pedidos do cliente
	public String consultarMeusPedidos(Cliente cliente) {
		StringBuilder pedidosInfo = new StringBuilder();
		boolean encontrou = false;

		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i) != null) {
				// Compara pelo código do usuário (mais seguro que comparar objetos)
				if (pedidos.get(i).getCliente().usuario.getCod() == cliente.usuario.getCod()) {
					pedidosInfo.append("Número: ").append(pedidos.get(i).getNumero()).append("\n");
					pedidosInfo.append("Data do Pedido: ").append(pedidos.get(i).getDataPedido()).append("\n");
					pedidosInfo.append("Data de Entrega: ").append(pedidos.get(i).getDataEntrega()).append("\n");
					pedidosInfo.append("Situação: ").append(pedidos.get(i).getSituacao()).append("\n");
					pedidosInfo.append("Total: ").append(pedidos.get(i).calcularTotalPedido()).append("\n\n");
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
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i) != null) {
				// Compara pelo número do pedido E pelo código do usuário (mais seguro que comparar objetos)
				if (pedidos.get(i).getNumero() == numeroPedido && 
				    pedidos.get(i).getCliente().usuario.getCod() == cliente.usuario.getCod()) {
					StringBuilder info = new StringBuilder();
					info.append("Número: ").append(pedidos.get(i).getNumero()).append("\n");
					info.append("Data do Pedido: ").append(pedidos.get(i).getDataPedido()).append("\n");
					info.append("Data de Entrega: ").append(pedidos.get(i).getDataEntrega()).append("\n");
					info.append("Situação: ").append(pedidos.get(i).getSituacao()).append("\n");
					info.append("Total de Itens: ").append(pedidos.get(i).getTotalItens()).append("\n");
					info.append("Itens:\n");

					for (int j = 0; j < pedidos.get(i).getMaxIPP(); j++) {
						if (pedidos.get(i).itens[j] != null) {
							info.append(" - ").append(pedidos.get(i).itens[j].produto.getNome())
									.append(" (Qtd: ").append(pedidos.get(i).itens[j].getQuantidade())
									.append(", Preço: ").append(pedidos.get(i).itens[j].getTotalItem()).append(")\n");
						}
					}

					info.append("Total do Pedido: ").append(pedidos.get(i).calcularTotalPedido()).append("\n");
					return info.toString();
				}
			}
		}
		return null;
	}

	// Método refatorado - cancela pedido
	public String cancelarPedido(Cliente cliente, int numeroPedido) {
		System.out.println("DEBUG - Cancelar Pedido:");
		System.out.println("DEBUG - Numero do pedido procurado: " + numeroPedido);
		System.out.println("DEBUG - Cliente: " + cliente.getNome() + " (código: " + cliente.usuario.getCod() + ")");
		System.out.println("DEBUG - Total de pedidos na lista: " + pedidos.size());
		
		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i) != null) {
				System.out.println("DEBUG - Pedido " + i + ": numero=" + pedidos.get(i).getNumero() + 
				                  ", cliente=" + pedidos.get(i).getCliente().getNome() + 
				                  " (código: " + pedidos.get(i).getCliente().usuario.getCod() + ")" +
				                  ", situacao=" + pedidos.get(i).getSituacao());
				
				// Compara pelo número do pedido E pelo código do usuário (mais seguro que comparar objetos)
				if (pedidos.get(i).getNumero() == numeroPedido && 
				    pedidos.get(i).getCliente().usuario.getCod() == cliente.usuario.getCod()) {
					System.out.println("DEBUG - Pedido encontrado! Verificando situação...");
					
					if (!pedidos.get(i).getSituacao().equals("PENDENTE")) {
						return "Pedido não pode ser cancelado pois não está pendente. Situação atual: " + pedidos.get(i).getSituacao();
					}

					// Restaura estoque - busca o produto na lista principal para garantir que atualize corretamente
					for (int j = 0; j < pedidos.get(i).getMaxIPP(); j++) {
						if (pedidos.get(i).itens[j] != null) {
							// Busca o produto na lista principal pelo código
							int codigoProduto = pedidos.get(i).itens[j].produto.getCod();
							Produto produtoNaLista = buscarProdutoPorCodigo(codigoProduto);
							
							if (produtoNaLista != null) {
								produtoNaLista.estoque.setQuantidade(
									produtoNaLista.estoque.getQuantidade() + pedidos.get(i).itens[j].getQuantidade());
								System.out.println("DEBUG - Estoque restaurado para produto " + codigoProduto + 
								                  ": " + pedidos.get(i).itens[j].getQuantidade() + " unidades");
							} else {
								System.out.println("DEBUG - ERRO: Produto " + codigoProduto + " não encontrado na lista principal");
							}
						}
					}

					pedidos.get(i).setSituacao("CANCELADO");
					return "Pedido cancelado com sucesso. Estoque restaurado.";
				}
			}
		}
		return "Número de pedido não encontrado.";
	}

	// ------------------ Admin ------------------

	public Fornecedor getF(boolean isLogin, int codigo, String login) {
		for (int i = 0; i < fornecedores.size(); i++) {
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
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) != null) {
				if (isLogin == false) {
					if (clientes.get(i).usuario.getCod() == codigo) {
						return clientes.get(i);
					}
				} else {
					if (clientes.get(i).usuario.getLogin().equalsIgnoreCase(login)) {
						return clientes.get(i);
					}
				}
			}
		}
		return null;
	}

	public String consultarPedidosAdm() {
		StringBuilder pedidosInfo = new StringBuilder();
		boolean encontrou = false;

		for (int i = 0; i < pedidos.size(); i++) {
			if (pedidos.get(i) != null) {
				pedidosInfo.append(" - Pedido Número: ").append(pedidos.get(i).getNumero()).append("\n");
				pedidosInfo.append(" - Cliente: ").append(pedidos.get(i).cliente.getNome()).append("\n");
				pedidosInfo.append(" - Situação: ").append(pedidos.get(i).getSituacao()).append("\n");
				pedidosInfo.append(" - Total: ").append(pedidos.get(i).calcularTotalPedido()).append("\n\n");
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
			for (int i = 0; i < clientes.size(); i++) {
				if (clientes.get(i) != null && clientes.get(i).usuario.getCod() == codigo) {
					return clientes.get(i);
				}
			}
		} else {
			for (int i = 0; i < fornecedores.size(); i++) {
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

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) != null) {
				info.append(" - Código: ").append(clientes.get(i).usuario.getCod()).append("\n");
				info.append(" - Nome: ").append(clientes.get(i).getNome()).append("\n");
				info.append(" - Login: ").append(clientes.get(i).usuario.getLogin()).append("\n");
				info.append(" - Ativo: ").append(clientes.get(i).usuario.isActive() ? "Sim" : "Não").append("\n\n");
			}
		}

		info.append("===Contas tipo Fornecedor: ===\n");
		for (int i = 0; i < fornecedores.size(); i++) {
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
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i) != null && produtos.get(i).getCod() == codigo) {
				return produtos.get(i);
			}
		}
		return null;
	}

	// Método para buscar fornecedor por login
	public Fornecedor buscarFornecedorPorLogin(String login) {
		for (int i = 0; i < fornecedores.size(); i++) {
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
		for (int i = 0; i < this.produtos.size(); i++) {
			if (this.produtos.get(i) != null && this.produtos.get(i).getFornecedor() == fornecedor) {
				produtos.append("Código: ").append(this.produtos.get(i).getCod()).append("\n");
				produtos.append("Nome: ").append(this.produtos.get(i).getNome()).append("\n");
				produtos.append("Descrição: ").append(this.produtos.get(i).getDescricao()).append("\n");
				produtos.append("Preço: ").append(this.produtos.get(i).estoque.getPreco()).append("\n");
				produtos.append("Quantidade: ").append(this.produtos.get(i).estoque.getQuantidade()).append("\n");
				produtos.append("Disponível: ").append(this.produtos.get(i).isDisponivel() ? "Sim" : "Não")
						.append("\n\n");
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
		for (int i = 0; i < this.fornecedores.size(); i++) {
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
		for (int i = 0; i < fornecedores.size(); i++) {
			if (fornecedores.get(i) != null) {
				if (fornecedores.get(i).usuario.getCod() == codUser) {
					codUser++;
					i = -1; // reinicia o loop
				}
			}
		}

		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i) != null) {
				if (clientes.get(i).usuario.getCod() == codUser) {
					codUser++;
					i = -1; // reinicia o loop
				}
			}
		}
	}

	// Métodos para persistência de dados
	private PersistenciaLoja persistencia = new PersistenciaLoja();

	/**
	 * Carrega dados salvos do arquivo JSON
	 */
	public boolean carregarDadosSalvos() {
		return persistencia.carregarDados(this);
	}

	/**
	 * Salva os dados atuais em arquivo JSON
	 */
	public boolean salvarDados() {
		return persistencia.salvarDados(this);
	}

	/**
	 * Verifica se existem dados salvos
	 */
	public boolean existeDadosSalvos() {
		return persistencia.existeArquivoDados();
	}
}
