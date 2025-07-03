package trabalho;

public class TesteCarregamento {
    public static void main(String[] args) {
        Loja loja = new Loja();
        PersistenciaLoja persistencia = new PersistenciaLoja();
        
        System.out.println("=== Teste de Carregamento de Dados ===");
        boolean sucesso = persistencia.carregarDados(loja);
        
        if (sucesso) {
            System.out.println("Carregamento realizado com sucesso!");
            System.out.println("Fornecedores carregados: " + loja.getFornecedores().size());
            System.out.println("Clientes carregados: " + loja.getClientes().size());
            System.out.println("Produtos carregados: " + loja.getProdutos().size());
            System.out.println("Pedidos carregados: " + loja.getPedidos().size());
        } else {
            System.out.println("Falha no carregamento.");
        }
    }
}
