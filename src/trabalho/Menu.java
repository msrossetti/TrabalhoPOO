package trabalho;

import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	
	Loja loja = new Loja();
	
	static Fornecedor fornecedor;
	static Cliente cliente;
	
	String senhaAdmin = "123abc";
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.executar();
    }
	
	public void executar() {
        loja.iniciarValores();
        menuInicial();
	}
    
    public void menuInicial() {
        int opcao;
        do {
            System.out.println("\n=== MENU INICIAL ===");
            System.out.print("Escolha como deseja acessar: \n");
            System.out.println("1 - Fornecedor");
            System.out.println("2 - Cliente");
            System.out.println("3 - Admin");
            System.out.println("0 - Sair");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                    menuLogin('f');
                    break;
                case 2:
                	menuLogin('c');
                    break;
                case 3:
                	System.out.println("Insira a senha de Admin: ");
                	String senha = sc.nextLine();
                	if(senhaAdmin.equals(senha)) {
                		System.out.println("Autenticado com sucesso.\n");
                		menuAdmin();
                	}else {
                		System.out.println("Senha errada informada.");
                	}
                	break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuLogin(char tipo) {
        int opcao;
        do {
            System.out.println("\n=== LOGIN / CADASTRO ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Login");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.cadastrarUsuario(tipo);
                    break;
                case 2:
                	boolean autenticar = false;
                	if(tipo == 'f') {
                		autenticar = loja.fazerLogin(tipo);
                		if(autenticar == true) {
                			System.out.println("Login realizado com sucesso!\n");
                			menuFornecedor();
                		}
                    }else if(tipo == 'c') {
                    	autenticar = loja.fazerLogin(tipo);
                		if(autenticar == true) {
                			System.out.println("Login realizado com sucesso!\n");
                			menuCliente();
                		}
                    }
                	if(autenticar == false) {
                		if(loja.exc == false) {
                			System.out.println("Login ou senha incorretos.");
                		}
                	}
                	break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuFornecedor() {
        int opcao;
        do {
            System.out.println("\n=== MENU FORNECEDOR ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Gerenciar Conta");
            System.out.println("2 - Gerenciar Produtos");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	menuGerenciarConta('f');
                    break;
                case 2:
                    menuProdutos();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuProdutos(){
    	int opcao;
        do {
            System.out.println("\n=== MENU PRODUTOS ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Visualizar Meus Produtos");
            System.out.println("2 - Consultar Produtos");
            System.out.println("3 - Consultar Produto por Código");
            System.out.println("4 - Consultar Fornecedor");
            System.out.println("5 - Cadastrar Novo Produto");
            System.out.println("6 - Alterar Produto");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.visualizarMeusProdutos(fornecedor);
                    break;
                case 2:
                	loja.consultarProdutos(false);
                	break;
                case 3:
                	System.out.println("Informe o Código do Produto: ");
                	int c = loja.lerInt();
                	loja.visualizarProduto(c, false);
                    break;
                case 4:
                	loja.consultarFornecedor(false);
                	break;
                case 5:
                	loja.cadastrarProduto(fornecedor);
                    break;
                case 6:
                	loja.autenticarProduto(fornecedor);
                	if(Loja.achou == true) {
                		menuAlterarProduto();
                	}
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuGerenciarConta(char tipo) {
    	int opcao;
        do {
            System.out.println("\n=== GERENCIAR CONTA ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Visualizar Informações");
            System.out.println("2 - Alterar Conta");
            System.out.println("3 - Excluir Conta");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.visualizarConta(tipo, cliente, fornecedor);
                    break;
                case 2:
                	menuAlterarConta(tipo);
                    break;
                case 3:
                	loja.excluirConta(tipo, cliente, fornecedor);
                	menuInicial();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuAlterarConta(char tipo) {
    	int opcao;
        do {
            System.out.println("\n=== ALTERAR CONTA ===");
            System.out.print("Escolha a opção: \n");
            loja.alterarContaInformacoes(tipo, cliente, fornecedor);
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.alterarConta(tipo, cliente, fornecedor,1);
                    break;
                case 2:
                	loja.alterarConta(tipo, cliente, fornecedor,2);
                    break;
                case 3:
                	loja.alterarConta(tipo, cliente, fornecedor,3);
                    break;
                case 4:
                	loja.alterarConta(tipo, cliente, fornecedor,4);
                    break;
                case 5:
                	loja.alterarConta(tipo, cliente, fornecedor,5);
                    break;
                case 6:
                	loja.alterarConta(tipo, cliente, fornecedor,6);
                    break;
                case 7:
                	loja.alterarConta(tipo, cliente, fornecedor,7);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuAlterarProduto() {
    	int opcao;
    	System.out.print("Escolha a opção: \n");
        do {
            System.out.println("\n=== ALTERAR PRODUTO ===");
            System.out.print("Escolha a opção: \n");
            loja.alterarProdutoInformacoes();
            System.out.println("6 - Remover Produto");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.alterarProduto(1);
                    break;
                case 2:
                	loja.alterarProduto(2);
                	break;
                case 3:
                	loja.alterarProduto(3);
                    break;
                case 4:
                	loja.alterarProduto(4);
                	break;
                case 5:
                	loja.alterarProduto(5);
                    break;
                case 6:
                	loja.removerProduto();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0 && opcao != 6);
    }
    
    
    
    public void menuCliente() {
        int opcao;
        do {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Gerenciar Conta");
            System.out.println("2 - Fazer Pedido");
            System.out.println("3 - Gerenciar Meus Pedidos");
            System.out.println("0 - Sair");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                    menuGerenciarConta('c');
                    break;
                case 2:
                	boolean max = loja.autenticaNumPedidos(cliente);
                	if(max == true) {
                		menuFazerPedido(false);
                	}else {
                		System.out.println("Número máximo de Pedidos atingido.");
                	}
                    break;
                case 3:
                    menuPedidos();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuFazerPedido(boolean admin) {
    	int opcao;
        do {
            System.out.println("\n=== FAZER PEDIDO ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Consultar Produtos");
            System.out.println("2 - Consultar Produto por Código");
            System.out.println("3 - Consultar Fornecedor");
            System.out.println("4 - Adicionar Item ao Carrinho");
            System.out.println("5 - Alterar Quandidade do Item no Carrinho");
            System.out.println("6 - Remover Item do Carrinho");
            System.out.println("7 - Consultar Carrinho");
            System.out.println("8 - Finalizar Pedido");
            System.out.println("0 - Voltar (Cancelar Pedido)");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.consultarProdutos(false);
                    break;
                case 2:
                	System.out.println("Informe o Código do Pedido: ");
                	int c = loja.lerInt();
                	loja.visualizarProduto(c, false);
                    break;
                case 3:
                	loja.consultarFornecedor(admin);
                    break;
                case 4:
                	loja.adicionarItemAoCarrinho();
                    break;
                case 5:
                	loja.alterarItemDoCarrinho();
                    break;
                case 6:
                	loja.removerItemDoCarrinho();
                    break;
                case 7:
                	loja.consultarCarrinho();
                    break;
                case 8:
                	loja.finalizarPedido(cliente);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0 && opcao != 8);
    }
    
    public void menuPedidos() {
    	int opcao;
        do {
            System.out.println("\n=== MEUS PEDIDOS ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Consultar Meus Pedidos");
            System.out.println("2 - Consultar Pedido Por Número");
            System.out.println("3 - Cancelar Pedido");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.consultarMeusPedidos(cliente);
                    break;
                case 2:
                	loja.consultarPedido(cliente);
                    break;
                case 3:
                	loja.cancelarPedido(cliente);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuAdmin() {
        int opcao;
        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Mudar senha Admin");
            System.out.println("2 - Contas");
            System.out.println("3 - Produtos");
            System.out.println("4 - Pedidos");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe a nova senha: ");
                    String senha = sc.nextLine();
                    senhaAdmin = senha;
                    System.out.println("Senha alterada com sucesso. Voltando...");
                    break;
                case 2:
                    menuAdminContas();
                    break;
                case 3:
                	menuAdminProdutos();
                    break;
                case 4:
                	menuAdminPedidos();
                	break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0 && opcao!=1);
    }
    
    public void menuAdminContas() {
    	int opcao;
        do {
            System.out.println("\n=== MENU ADMIN CONTAS ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Visualizar Contas");
            System.out.println("2 - Consultar Conta por Código");
            System.out.println("3 - Consultar Conta por Login");
            System.out.println("4 - Alterar Conta");
            System.out.println("5 - Excluir Conta");
            System.out.println("6 - Criar Conta");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.consultarContasAdm();
                    break;
                case 2:
                	int o2;
                	do {
                		System.out.print("Escolha a opção: \n");
                		System.out.println("1 - Cliente");
                		System.out.println("2 - Fornecedor");
                		System.out.println("0 - Voltar");
                		o2 = loja.lerInt();

                		switch (o2) {
                        	case 1:
                        		Cliente c2 = loja.getC(false);
                            	if(c2!=null) {
                            		loja.visualizarConta('c', c2, fornecedor);
                            	}
                        		break;
                        	case 2:
                        		Fornecedor f2 = loja.getF(false);
                            	if(f2!=null) {
                            		loja.visualizarConta('f', cliente, f2);
                            	}
                        		break;
                        	case 0:
                            System.out.println("Voltando...");
                            break;
                        	default:
                            System.out.println("Opção inválida.");
                    	}
                    } while (o2<0 || o2>2);
                    break;
                case 3:
                	int o3;
                	do {
                		System.out.print("Escolha a opção: \n");
                		System.out.println("1 - Cliente");
                		System.out.println("2 - Fornecedor");
                		System.out.println("0 - Voltar");
                		o3 = loja.lerInt();

                		switch (o3) {
                        	case 1:
                        		Cliente c3 = loja.getC(true);
                            	if(c3!=null) {
                            		loja.visualizarConta('c', c3, fornecedor);
                            	}
                        		break;
                        	case 2:
                        		Fornecedor f3 = loja.getF(true);
                            	if(f3!=null) {
                            		loja.visualizarConta('f', cliente, f3);
                            	}
                        		break;
                        	case 0:
                            System.out.println("Voltando...");
                            break;
                        	default:
                            System.out.println("Opção inválida.");
                    	}
                    } while (o3<0 || o3>2);
                	break;
                case 4:
                	int o4;
                	do {
                		System.out.print("Escolha a opção: \n");
                		System.out.println("1 - Cliente");
                		System.out.println("2 - Fornecedor");
                		System.out.println("0 - Voltar");
                		o4 = loja.lerInt();

                		switch (o4) {
                        	case 1:
                        		menuAlterarContaAdm('c');
                        		break;
                        	case 2:
                        		menuAlterarContaAdm('f');
                        		break;
                        	case 0:
                            System.out.println("Voltando...");
                            break;
                        	default:
                            System.out.println("Opção inválida.");
                    	}
                    } while (o4<0 || o4>2);
                    break;
                case 5:
                	int o5;
                	do {
                		System.out.print("Escolha a opção: \n");
                		System.out.println("1 - Cliente");
                		System.out.println("2 - Fornecedor");
                		System.out.println("0 - Voltar");
                		o5 = loja.lerInt();

                		switch (o5) {
                		case 1:
                    		Cliente c5 = loja.getC(false);
                        	if(c5!=null) {
                        		if(c5.usuario.isActive()==true) {
                        			loja.excluirConta('c', c5, fornecedor);
                        		}else {
                        			System.out.println("Conta já desativada.");
                        		}
                        	}
                    		break;
                    	case 2:
                    		Fornecedor f5 = loja.getF(false);
                        	if(f5!=null) {
                        		if(f5.usuario.isActive()==true) {
                        			loja.excluirConta('f', cliente, f5);
                        		}else {
                        			System.out.println("Conta já desativada.");
                        		}
                        	}
                    		break;
                        	case 0:
                            System.out.println("Voltando...");
                            break;
                        	default:
                            System.out.println("Opção inválida.");
                    	}
                    } while (o5<0 || o5>2);
                	break;
                case 6:
                	int o6;
                	do {
                		System.out.print("Escolha a opção: \n");
                		System.out.println("1 - Cliente");
                		System.out.println("2 - Fornecedor");
                		System.out.println("0 - Voltar");
                		o6 = loja.lerInt();

                		switch (o6) {
                        	case 1:
                        		loja.cadastrarUsuario('c');
                        		break;
                        	case 2:
                        		loja.cadastrarUsuario('f');
                        		break;
                        	case 0:
                            System.out.println("Voltando...");
                            break;
                        	default:
                            System.out.println("Opção inválida.");
                    	}
                    } while (o6<0 || o6>2);
                	break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuAdminProdutos() {
    	int opcao;
        do {
            System.out.println("\n=== MENU ADMIN PRODUTOS ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Visualizar Produtos"); //deve aparecer todos produtos, até mesmo excluídos
            System.out.println("2 - Consultar Produto por Código");
            System.out.println("3 - Consultar Fornecedor");
            System.out.println("4 - Alterar Produto");
            System.out.println("5 - Criar Produto");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.consultarProdutos(true);


                    break;
                case 2:
         
                	System.out.println("Informe o Código do Produto: ");
                	int c = loja.lerInt();
                	loja.visualizarProduto(c, true);
                    break;
                case 3:
                	loja.consultarFornecedor(true);
                	break;
                case 4:
                	Fornecedor f4 = loja.getF(false);
                	if(f4!=null) {
                		if(f4.usuario.isActive()==true) {
                			loja.autenticarProduto(f4);
                			if(Loja.achou == true) {
                				menuAlterarProduto();
                			}
                		}else {
                			System.out.println("Conta desativada.");
                		}
                	}
                    break;
                case 5:
                	Fornecedor f5 = loja.getF(false);
                	if(f5!=null) {
                		if(f5.usuario.isActive()==true) {
                			loja.cadastrarProduto(f5);
                		}else {
                			System.out.println("Conta desativada.");
                		}
                	}
                	break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void menuAdminPedidos() {
    	int opcao;
        do {
            System.out.println("\n=== MENU ADMIN PEDIDOS ===");
            System.out.print("Escolha a opção: \n");
            System.out.println("1 - Visualizar Pedidos");
            System.out.println("2 - Consultar Pedido por Número");
            System.out.println("3 - Cancelar Pedido");
            System.out.println("4 - Criar Pedido");
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                         loja.consultarPedidosAdm();
                    break;
                case 2:
   
                   Cliente c2 = loja.getC(false);
                   if(c2!=null) {
                	   loja.consultarPedido(c2);
                   }
                		   break;
                case 3:
                	Cliente c3 = loja.getC(false);
                    if(c3!=null) {
                    	loja.cancelarPedido(c3);
                    }
                	
                    break;
                case 4:
                	Cliente c4 = loja.getC(false);
                	if(c4!=null) {
                		if(c4.usuario.isActive()==true) {
                			boolean max = loja.autenticaNumPedidos(c4);
                			if(max == true) {
                				menuFazerPedido(true);
                			}else {
                				System.out.println("Número máximo de Pedidos atingido.");
                			} 
                		}else {
                			System.out.println("Conta desativada.");
                		}
                	}
                	break;
                
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
    public void menuAlterarContaAdm(char tipo) {
    	loja.pedirContaAdm(tipo);
    	if(cliente!=null && tipo == 'c') {
    		if(cliente.usuario.isActive()==false) {
    			System.out.println("Conta desativada.");
    			return;
    		}
    	}else if(fornecedor!=null && tipo == 'f') {
    		if(fornecedor.usuario.isActive()==false) {
    			System.out.println("Conta desativada.");
    			return;
    		}
    	}
    	int opcao;
        do {
            System.out.println("\n=== ALTERAR CONTA ===");
            System.out.print("Escolha a opção: \n");
            loja.alterarContaInformacoes(tipo, cliente, fornecedor);
            System.out.println("0 - Voltar");
            opcao = loja.lerInt();

            switch (opcao) {
                case 1:
                	loja.alterarConta(tipo, cliente, fornecedor,1);
                    break;
                case 2:
                	loja.alterarConta(tipo, cliente, fornecedor,2);
                    break;
                case 3:
                	loja.alterarConta(tipo, cliente, fornecedor,3);
                    break;
                case 4:
                	loja.alterarConta(tipo, cliente, fornecedor,4);
                    break;
                case 5:
                	loja.alterarConta(tipo, cliente, fornecedor,5);
                    break;
                case 6:
                	loja.alterarConta(tipo, cliente, fornecedor,6);
                    break;
                case 7:
                	loja.alterarConta(tipo, cliente, fornecedor,7);
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
    
}
