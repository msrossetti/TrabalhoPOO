package trabalho;

/**
 * Classe principal que inicializa o sistema com dados JSON
 */
public class InicializadorDados {
    
    public static void main(String[] args) {
        System.out.println("=== Inicializando Sistema de Loja ===");
        
        // Criar instância da loja (automaticamente carrega os dados)
        Loja loja = new Loja();
        
        System.out.println("Sistema inicializado com sucesso!");
        System.out.println("Dados carregados:");
        System.out.println("- Fornecedores: " + (loja.getFornecedores() != null ? loja.getFornecedores().size() : 0));
        System.out.println("- Clientes: " + (loja.getClientes() != null ? loja.getClientes().size() : 0));
        System.out.println("- Produtos: " + (loja.getProdutos() != null ? loja.getProdutos().size() : 0));
        System.out.println("- Pedidos: " + (loja.getPedidos() != null ? loja.getPedidos().size() : 0));
        
        // Iniciar o menu principal
        Menu menu = new Menu();
        menu.iniciar();
    }
}
