
package trabalho;

import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Loja loja = new Loja();

    public void iniciar() {
        // Sempre tenta carregar dados do JSON primeiro
        System.out.println("Carregando dados da loja...");
        if (!loja.carregarDadosSalvos()) {
            System.out.println("Erro ao carregar dados. Verifique os arquivos JSON.");
            return;
        }
        menuPrincipal();
    }

    public void menuPrincipal() {
        int opcao = 0;
        do {
            System.out.println("===== LOJA ONLINE =====");
            System.out.println("1 - Fazer Login");
            System.out.println("2 - Cadastrar-se");
            System.out.println("3 - Consultar Produtos");
            System.out.println("4 - Consultar Fornecedor");
            System.out.println("5 - Salvar Dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = lerInt();

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    consultarProdutos();
                    break;
                case 4:
                    consultarFornecedor();
                    break;
                case 5:
                    salvarDados();
                    break;
                case 0:
                    salvarAntesDeFechar();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void fazerLogin() {
        System.out.println("===== LOGIN =====");
        System.out.println("Tipo de usuário:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Fornecedor");
        System.out.println("3 - Administrador");
        System.out.print("Escolha: ");

        int tipo = lerInt();

        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        switch (tipo) {
            case 1:
                Cliente cliente = (Cliente) loja.fazerLogin('c', login, senha);
                if (cliente != null) {
                    System.out.println("Login realizado com sucesso!");
                    menuCliente(cliente);
                } else {
                    System.out.println("Login ou senha incorretos, ou usuário inativo.");
                }
                break;
            case 2:
                Fornecedor fornecedor = (Fornecedor) loja.fazerLogin('f', login, senha);
                if (fornecedor != null) {
                    System.out.println("Login realizado com sucesso!");
                    menuFornecedor(fornecedor);
                } else {
                    System.out.println("Login ou senha incorretos, ou usuário inativo.");
                }
                break;
            case 3:
                if (login.equals("admin") && senha.equals("admin")) {
                    System.out.println("Login de administrador realizado com sucesso!");
                    menuAdmin();
                } else {
                    System.out.println("Credenciais de administrador incorretas.");
                }
                break;
            default:
                System.out.println("Tipo de usuário inválido!");
                break;
        }
    }

    private void cadastrarUsuario() {
        System.out.println("===== CADASTRO =====");
        System.out.println("Tipo de usuário:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Fornecedor");
        System.out.print("Escolha: ");

        int tipo = lerInt();
        char tipoChar = (tipo == 1) ? 'c' : 'f';

        System.out.print("Digite o login: ");
        String login = sc.nextLine();

        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite seu telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();

        System.out.print("Digite seu CPF: ");
        String cpf = sc.nextLine();

        Endereco endereco = coletarEndereco();

        String cartaoOuDescricao;
        if (tipo == 1) {
            System.out.print("Digite seu Cartão de Crédito: ");
            cartaoOuDescricao = sc.nextLine();
        } else {
            System.out.print("Digite sua Descrição: ");
            cartaoOuDescricao = sc.nextLine();
        }

        String resultado = loja.cadastrarUsuario(tipoChar, login, senha, nome, telefone, email, cpf, endereco,
                cartaoOuDescricao);
        System.out.println(resultado);
    }

    private Endereco coletarEndereco() {
        System.out.println("Deseja informar seu Endereço?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Escolha: ");

        int opcao = lerInt();

        if (opcao == 1) {
            System.out.print("Digite sua rua: ");
            String rua = sc.nextLine();
            System.out.print("Digite o número: ");
            String numero = sc.nextLine();
            System.out.print("Digite um complemento: ");
            String complemento = sc.nextLine();
            System.out.print("Digite seu bairro: ");
            String bairro = sc.nextLine();
            System.out.print("Digite o CEP: ");
            String cep = sc.nextLine();
            System.out.print("Digite sua cidade: ");
            String cidade = sc.nextLine();
            System.out.print("Digite seu estado: ");
            String estado = sc.nextLine();

            return new Endereco(rua, numero, complemento, bairro, cep, cidade, estado);
        } else {
            return null;
        }
    }

    private void consultarProdutos() {
        System.out.println("===== CONSULTAR PRODUTOS =====");
        System.out.print("Digite o termo de busca (ou pressione Enter para ver todos): ");
        String termo = sc.nextLine();

        String resultado = loja.consultarProdutos(termo, false);
        System.out.println(resultado);
    }

    private void consultarFornecedor() {
        System.out.println("===== CONSULTAR FORNECEDOR =====");
        System.out.print("Digite o login do fornecedor: ");
        String login = sc.nextLine();

        String resultado = loja.consultarFornecedor(login, false);
        if (resultado != null) {
            System.out.println(resultado);
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    private void menuCliente(Cliente cliente) {
        int opcao = 0;
        do {
            System.out.println("\n===== MENU CLIENTE =====");
            System.out.println("1 - Visualizar Conta");
            System.out.println("2 - Alterar Conta");
            System.out.println("3 - Excluir Conta");
            System.out.println("4 - Consultar Produtos");
            System.out.println("5 - Visualizar Produto");
            System.out.println("6 - Consultar Fornecedor");
            System.out.println("7 - Adicionar Item ao Carrinho");
            System.out.println("8 - Remover Item do Carrinho");
            System.out.println("9 - Alterar Item do Carrinho");
            System.out.println("10 - Consultar Carrinho");
            System.out.println("11 - Finalizar Pedido");
            System.out.println("12 - Consultar Meus Pedidos");
            System.out.println("13 - Consultar Pedido");
            System.out.println("14 - Cancelar Pedido");
            System.out.println("0 - Logout");
            System.out.print("Escolha uma opção: ");

            opcao = lerInt();

            switch (opcao) {
                case 1:
                    visualizarConta('c', cliente, null);
                    break;
                case 2:
                    alterarConta('c', cliente, null);
                    break;
                case 3:
                    if (excluirConta('c', cliente, null)) {
                        opcao = 0; // Logout após exclusão
                    }
                    break;
                case 4:
                    consultarProdutos();
                    break;
                case 5:
                    visualizarProduto();
                    break;
                case 6:
                    consultarFornecedor();
                    break;
                case 7:
                    adicionarItemAoCarrinho(cliente);
                    break;
                case 8:
                    removerItemDoCarrinho();
                    break;
                case 9:
                    alterarItemDoCarrinho();
                    break;
                case 10:
                    consultarCarrinho();
                    break;
                case 11:
                    finalizarPedido(cliente);
                    break;
                case 12:
                    consultarMeusPedidos(cliente);
                    break;
                case 13:
                    consultarPedido(cliente);
                    break;
                case 14:
                    cancelarPedido(cliente);
                    break;
                case 0:
                    System.out.println("Logout realizado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void menuFornecedor(Fornecedor fornecedor) {
        int opcao = 0;
        do {
            System.out.println("\n===== MENU FORNECEDOR =====");
            System.out.println("1 - Visualizar Conta");
            System.out.println("2 - Alterar Conta");
            System.out.println("3 - Excluir Conta");
            System.out.println("4 - Visualizar Meus Produtos");
            System.out.println("5 - Consultar Produtos");
            System.out.println("6 - Visualizar Produto");
            System.out.println("7 - Consultar Fornecedor");
            System.out.println("8 - Cadastrar Produto");
            System.out.println("9 - Alterar Produto");
            System.out.println("10 - Remover Produto");
            System.out.println("0 - Logout");
            System.out.print("Escolha uma opção: ");

            opcao = lerInt();

            switch (opcao) {
                case 1:
                    visualizarConta('f', null, fornecedor);
                    break;
                case 2:
                    alterarConta('f', null, fornecedor);
                    break;
                case 3:
                    if (excluirConta('f', null, fornecedor)) {
                        opcao = 0; // Logout após exclusão
                    }
                    break;
                case 4:
                    visualizarMeusProdutos(fornecedor);
                    break;
                case 5:
                    consultarProdutos();
                    break;
                case 6:
                    visualizarProduto();
                    break;
                case 7:
                    consultarFornecedor();
                    break;
                case 8:
                    cadastrarProduto(fornecedor);
                    break;
                case 9:
                    alterarProduto(fornecedor);
                    break;
                case 10:
                    removerProduto(fornecedor);
                    break;
                case 0:
                    System.out.println("Logout realizado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private void menuAdmin() {
        int opcao = 0;
        do {
            System.out.println("\n===== MENU ADMINISTRADOR =====");
            System.out.println("1 - Consultar Pedidos");
            System.out.println("2 - Consultar Contas");
            System.out.println("3 - Visualizar Conta");
            System.out.println("4 - Alterar Conta");
            System.out.println("5 - Excluir Conta");
            System.out.println("6 - Consultar Produtos");
            System.out.println("7 - Visualizar Produto");
            System.out.println("8 - Consultar Fornecedor");
            System.out.println("9 - Transferir Produto entre Fornecedores"); // Nova opção
            System.out.println("10 - Listar Produtos por Fornecedor"); // Nova opção
            System.out.println("0 - Logout");
            System.out.print("Escolha uma opção: ");

            opcao = lerInt();

            switch (opcao) {
                case 1:
                    consultarPedidosAdmin();
                    break;
                case 2:
                    consultarContasAdmin();
                    break;
                case 3:
                    visualizarContaAdmin();
                    break;
                case 4:
                    alterarContaAdmin();
                    break;
                case 5:
                    excluirContaAdmin();
                    break;
                case 6:
                    System.out.print("Digite o termo de busca (ou pressione Enter para ver todos): ");
                    String termo = sc.nextLine();
                    String resultado = loja.consultarProdutos(termo, true);
                    System.out.println(resultado);
                    break;
                case 7:
                    System.out.print("Digite o código do produto: ");
                    int codigo = lerInt();
                    String infoProduto = loja.visualizarProduto(codigo, true);
                    if (infoProduto != null) {
                        System.out.println(infoProduto);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 8:
                    consultarFornecedor();
                    break;
                case 9:
                    transferirProdutoAdmin();
                    break;
                case 10:
                    listarProdutosPorFornecedorAdmin();
                    break;
                case 0:
                    System.out.println("Logout realizado.");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    // Métodos auxiliares para Cliente
    private void visualizarConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
        String info = loja.visualizarConta(tipo, cliente, fornecedor);
        System.out.println("===== INFORMAÇÕES DA CONTA =====");
        System.out.println(info);
    }

    private void alterarConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
        System.out.println("===== ALTERAR CONTA =====");
        String opcoes = loja.getAlteracaoInfo(tipo, cliente, fornecedor);
        System.out.println(opcoes);
        System.out.print("Escolha o que deseja alterar: ");

        int opcao = lerInt();
        String novoValor = "";
        Endereco novoEndereco = null;

        if (opcao >= 1 && opcao <= 6) {
            System.out.print("Digite o novo valor: ");
            novoValor = sc.nextLine();
        } else if (opcao == 7) {
            System.out.println("Digite o novo endereço:");
            novoEndereco = coletarEndereco();
        }

        String resultado = loja.alterarConta(tipo, cliente, fornecedor, opcao, novoValor, novoEndereco);
        System.out.println(resultado);
    }

    private boolean excluirConta(char tipo, Cliente cliente, Fornecedor fornecedor) {
        System.out.println("===== EXCLUIR CONTA =====");
        System.out.print("Tem certeza que deseja excluir sua conta? (s/n): ");
        String confirmacao = sc.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            String resultado = loja.excluirConta(tipo, cliente, fornecedor);
            System.out.println(resultado);
            return true;
        } else {
            System.out.println("Operação cancelada.");
            return false;
        }
    }

    private void visualizarProduto() {
        System.out.print("Digite o código do produto: ");
        int codigo = lerInt();

        String info = loja.visualizarProduto(codigo, false);
        if (info != null) {
            System.out.println("===== INFORMAÇÕES DO PRODUTO =====");
            System.out.println(info);
        } else {
            System.out.println("Produto não encontrado ou não disponível.");
        }
    }

    private void adicionarItemAoCarrinho(Cliente cliente) {
        if (!loja.autenticaNumPedidos(cliente)) {
            System.out.println("Limite de pedidos atingido.");
            return;
        }

        System.out.print("Digite o código do produto: ");
        int codigo = lerInt();
        System.out.print("Digite a quantidade: ");
        int quantidade = lerInt();

        String resultado = loja.adicionarItemAoCarrinho(codigo, quantidade);
        System.out.println(resultado);
    }

    private void removerItemDoCarrinho() {
        System.out.print("Digite o código do produto a remover: ");
        int codigo = lerInt();

        String resultado = loja.removerItemDoCarrinho(codigo);
        System.out.println(resultado);
    }

    private void alterarItemDoCarrinho() {
        System.out.print("Digite o código do produto: ");
        int codigo = lerInt();
        System.out.print("Digite a nova quantidade: ");
        int quantidade = lerInt();

        String resultado = loja.alterarItemDoCarrinho(codigo, quantidade);
        System.out.println(resultado);
    }

    private void consultarCarrinho() {
        String carrinho = loja.consultarCarrinho();
        System.out.println("===== CARRINHO =====");
        System.out.println(carrinho);
    }

    private void finalizarPedido(Cliente cliente) {
        System.out.println("===== FINALIZAR PEDIDO =====");
        consultarCarrinho();

        System.out.print("Digite seu cartão de crédito para confirmar: ");
        String cartao = sc.nextLine();

        String resultado = loja.finalizarPedido(cliente, cartao);
        System.out.println(resultado);
    }

    private void consultarMeusPedidos(Cliente cliente) {
        String pedidos = loja.consultarMeusPedidos(cliente);
        System.out.println("===== MEUS PEDIDOS =====");
        System.out.println(pedidos);
    }

    private void consultarPedido(Cliente cliente) {
        System.out.print("Digite o número do pedido: ");
        int numero = lerInt();

        String pedido = loja.consultarPedido(cliente, numero);
        if (pedido != null) {
            System.out.println("===== DETALHES DO PEDIDO =====");
            System.out.println(pedido);
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }

    private void cancelarPedido(Cliente cliente) {
        System.out.print("Digite o número do pedido a cancelar: ");
        int numero = lerInt();

        String resultado = loja.cancelarPedido(cliente, numero);
        System.out.println(resultado);
    }

    // Métodos auxiliares para Fornecedor
    private void visualizarMeusProdutos(Fornecedor fornecedor) {
        String produtos = loja.visualizarMeusProdutos(fornecedor);
        System.out.println("===== MEUS PRODUTOS =====");
        System.out.println(produtos);
    }

    private void cadastrarProduto(Fornecedor fornecedor) {
        System.out.println("===== CADASTRAR PRODUTO =====");
        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.print("Digite a descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = lerInt();
        System.out.print("Digite o preço: ");
        double preco = lerDouble();

        String resultado = loja.cadastrarProduto(fornecedor, nome, descricao, quantidade, preco);
        System.out.println(resultado);
    }

    private void alterarProduto(Fornecedor fornecedor) {
        System.out.println("===== ALTERAR PRODUTO =====");
        System.out.print("Digite o código do produto: ");
        int codigo = lerInt();

        Produto produto = loja.buscarProdutoFornecedor(codigo, fornecedor);
        if (produto == null) {
            System.out.println("Produto não encontrado ou não pertence a você.");
            return;
        }

        String opcoes = loja.getAlteracaoProdutoInfo();
        System.out.println(opcoes);
        System.out.print("Escolha o que deseja alterar: ");

        int opcao = lerInt();
        String resultado = "";

        switch (opcao) {
            case 1:
                System.out.print("Digite o novo preço: ");
                double preco = lerDouble();
                resultado = loja.alterarProduto(opcao, "", preco, 0);
                break;
            case 2:
                System.out.print("Digite a nova quantidade: ");
                int quantidade = lerInt();
                resultado = loja.alterarProduto(opcao, "", 0, quantidade);
                break;
            case 3:
                System.out.print("Digite o novo nome: ");
                String nome = sc.nextLine();
                resultado = loja.alterarProduto(opcao, nome, 0, 0);
                break;
            case 4:
                resultado = loja.alterarProduto(opcao, "", 0, 0);
                break;
            case 5:
                System.out.print("Digite a nova descrição: ");
                String descricao = sc.nextLine();
                resultado = loja.alterarProduto(opcao, descricao, 0, 0);
                break;
            default:
                resultado = "Opção inválida.";
                break;
        }

        System.out.println(resultado);
    }

    private void removerProduto(Fornecedor fornecedor) {
        System.out.println("===== REMOVER PRODUTO =====");
        System.out.print("Digite o código do produto: ");
        int codigo = lerInt();

        Produto produto = loja.buscarProdutoFornecedor(codigo, fornecedor);
        if (produto == null) {
            System.out.println("Produto não encontrado ou não pertence a você.");
            return;
        }

        System.out.print("Tem certeza que deseja remover o produto? (s/n): ");
        String confirmacao = sc.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            String resultado = loja.removerProduto();
            System.out.println(resultado);
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    // Métodos auxiliares para Admin
    private void consultarPedidosAdmin() {
        String pedidos = loja.consultarPedidosAdm();
        System.out.println("===== TODOS OS PEDIDOS =====");
        System.out.println(pedidos);
    }

    private void consultarContasAdmin() {
        String contas = loja.consultarContasAdm();
        System.out.println("===== TODAS AS CONTAS =====");
        System.out.println(contas);
    }

    private void visualizarContaAdmin() {
        System.out.println("===== VISUALIZAR CONTA =====");
        System.out.println("Tipo de conta:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Fornecedor");
        System.out.print("Escolha: ");

        int tipo = lerInt();
        char tipoChar = (tipo == 1) ? 'c' : 'f';

        System.out.print("Digite o código da conta: ");
        int codigo = lerInt();

        Object conta = loja.buscarContaAdm(tipoChar, codigo);
        if (conta != null) {
            if (tipoChar == 'c') {
                visualizarConta('c', (Cliente) conta, null);
            } else {
                visualizarConta('f', null, (Fornecedor) conta);
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void alterarContaAdmin() {
        System.out.println("===== ALTERAR CONTA =====");
        System.out.println("Tipo de conta:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Fornecedor");
        System.out.print("Escolha: ");

        int tipo = lerInt();
        char tipoChar = (tipo == 1) ? 'c' : 'f';

        System.out.print("Digite o código da conta: ");
        int codigo = lerInt();

        Object conta = loja.buscarContaAdm(tipoChar, codigo);
        if (conta != null) {
            if (tipoChar == 'c') {
                alterarConta('c', (Cliente) conta, null);
            } else {
                alterarConta('f', null, (Fornecedor) conta);
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void excluirContaAdmin() {
        System.out.println("===== EXCLUIR CONTA =====");
        System.out.println("Tipo de conta:");
        System.out.println("1 - Cliente");
        System.out.println("2 - Fornecedor");
        System.out.print("Escolha: ");

        int tipo = lerInt();
        char tipoChar = (tipo == 1) ? 'c' : 'f';

        System.out.print("Digite o código da conta: ");
        int codigo = lerInt();

        Object conta = loja.buscarContaAdm(tipoChar, codigo);
        if (conta != null) {
            if (tipoChar == 'c') {
                excluirConta('c', (Cliente) conta, null);
            } else {
                excluirConta('f', null, (Fornecedor) conta);
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    private void transferirProdutoAdmin() {
        System.out.println("===== TRANSFERIR PRODUTO =====");

        System.out.println("Produtos disponíveis:");
        String todosProdutos = loja.consultarProdutos("", true);
        System.out.println(todosProdutos);

        System.out.print("Digite o código do produto a ser transferido: ");
        int codigoProduto = lerInt();

        System.out.println("\n" + loja.listarFornecedoresAtivos());

        System.out.print("Digite o login do fornecedor de destino: ");
        String loginDestino = sc.nextLine();

        System.out.print("Confirma a transferência? (s/n): ");
        String confirmacao = sc.nextLine();

        if (confirmacao.equalsIgnoreCase("s")) {
            String resultado = loja.transferirProduto(codigoProduto, loginDestino);
            System.out.println(resultado);
        } else {
            System.out.println("Transferência cancelada.");
        }
    }

    private void listarProdutosPorFornecedorAdmin() {
        System.out.println("===== LISTAR PRODUTOS POR FORNECEDOR =====");

        System.out.println(loja.listarFornecedoresAtivos());

        System.out.print("Digite o login do fornecedor: ");
        String login = sc.nextLine();

        String produtos = loja.listarProdutosFornecedor(login);
        System.out.println("\n" + produtos);
    }

    // Métodos para persistência
    private void salvarDados() {
        System.out.println("===== SALVAR DADOS =====");
        if (loja.salvarDados()) {
            System.out.println("Dados salvos com sucesso!");
        } else {
            System.out.println("Erro ao salvar dados.");
        }
    }

    private void salvarAntesDeFechar() {
        System.out.print("Deseja salvar os dados antes de sair? (s/n): ");
        String resposta = sc.nextLine();
        if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim")) {
            if (loja.salvarDados()) {
                System.out.println("Dados salvos com sucesso!");
            } else {
                System.out.println("Erro ao salvar dados.");
            }
        }
    }

    // Métodos utilitários
    private int lerInt() {
        try {
            int valor = Integer.parseInt(sc.nextLine());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Digite um número inteiro.");
            return lerInt();
        }
    }

    private double lerDouble() {
        try {
            double valor = Double.parseDouble(sc.nextLine());
            return valor;
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Digite um número decimal.");
            return lerDouble();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
    }
}