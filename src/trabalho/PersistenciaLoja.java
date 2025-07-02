import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Classe utilitária para gerenciar a persistência de dados usando Jackson
 */
public class PersistenciaLoja {
    private static final String ARQUIVO_DADOS = "dados_unificados.json";
    private ObjectMapper objectMapper;

    public PersistenciaLoja() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Para JSON formatado
    }

    /**
     * Salva todos os dados da loja em arquivo JSON
     */
    public boolean salvarDados(Loja loja) {
        try {
            DadosLoja dados = new DadosLoja();

            // Transferir dados da loja para o objeto de dados
            dados.setFornecedores(loja.getFornecedores());
            dados.setClientes(loja.getClientes());
            dados.setProdutos(loja.getProdutos());
            dados.setPedidos(loja.getPedidos());
            dados.setCodUser(loja.getCodUser());
            dados.setCodProd(loja.getCodProd());
            dados.setNumPed(loja.getNumPed());

            // Salvar no arquivo JSON
            objectMapper.writeValue(new File(ARQUIVO_DADOS), dados);
            System.out.println("Dados salvos com sucesso em " + ARQUIVO_DADOS);
            return true;

        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Carrega os dados da loja do arquivo JSON
     */
    public boolean carregarDados(Loja loja) {
        try {
            File arquivo = new File(ARQUIVO_DADOS);

            if (!arquivo.exists()) {
                System.out.println("Arquivo " + ARQUIVO_DADOS + " não encontrado.");
                
                // Verifica se existe algum dos arquivos antigos para migrar
                File arquivoAntigo1 = new File("dados_loja.json");
                File arquivoAntigo2 = new File("dados_iniciais.json");
                
                if (arquivoAntigo1.exists()) {
                    System.out.println("Migrando dados de dados_loja.json...");
                    return migrarDados(loja, arquivoAntigo1);
                } else if (arquivoAntigo2.exists()) {
                    System.out.println("Migrando dados de dados_iniciais.json...");
                    return migrarDados(loja, arquivoAntigo2);
                } else {
                    System.out.println("Criando dados iniciais...");
                    return criarDadosIniciais(loja);
                }
            }

            DadosLoja dados = objectMapper.readValue(arquivo, DadosLoja.class);

            // Transferir dados carregados para a loja
            loja.setFornecedores(dados.getFornecedores());
            loja.setClientes(dados.getClientes());
            loja.setProdutos(dados.getProdutos());
            loja.setPedidos(dados.getPedidos());
            loja.setCodUser(dados.getCodUser());
            loja.setCodProd(dados.getCodProd());
            loja.setNumPed(dados.getNumPed());

            // Reconectar relacionamentos (produtos com fornecedores)
            reconectarRelacionamentos(loja);

            System.out.println("Dados carregados com sucesso de " + ARQUIVO_DADOS);
            return true;

        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
            System.out.println("Criando dados iniciais...");
            return criarDadosIniciais(loja);
        }
    }

    /**
     * Cria dados iniciais programaticamente e salva no JSON
     */
    private boolean criarDadosIniciais(Loja loja) {
        try {
            // Criar dados iniciais programaticamente
            loja.getFornecedores().clear();
            loja.getClientes().clear();
            loja.getProdutos().clear();
            loja.getPedidos().clear();

            // Criar fornecedores
            Endereco endereco1 = new Endereco("Rua 1", "111", "Complemento", "Bairro 1", "11111-111", "Caxias do Sul",
                    "Rio Grande do Sul");
            Endereco endereco2 = new Endereco("Rua 2", "222", "Complemento", "Bairro 2", "22222-222", "Caxias do Sul",
                    "Rio Grande do Sul");
            Endereco endereco3 = new Endereco("Rua 3", "333", "Complemento", "Bairro 3", "33333-333", "Caxias do Sul",
                    "Rio Grande do Sul");

            Usuario usuario1 = new Usuario("joao", "senha", 0, true);
            Usuario usuario2 = new Usuario("paulo", "senha", 1, true);
            Usuario usuario3 = new Usuario("roberto", "senha", 2, true);

            Fornecedor fornecedor1 = new Fornecedor("João", "54123456789", "joão@gmail.com", "012-345-678.99",
                    endereco1, "Vendedor de Queijo", usuario1);
            Fornecedor fornecedor2 = new Fornecedor("Paulo", "54123456789", "paulo@gmail.com", "012-345-678.99",
                    endereco2, "Vendedor de Queijo", usuario2);
            Fornecedor fornecedor3 = new Fornecedor("Roberto", "54123456789", "roberto@gmail.com", "012-345-678.99",
                    endereco3, "Vendedor de Salame", usuario3);

            loja.getFornecedores().add(fornecedor1);
            loja.getFornecedores().add(fornecedor2);
            loja.getFornecedores().add(fornecedor3);

            // Criar clientes
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

            loja.getClientes().add(cliente1);
            loja.getClientes().add(cliente2);
            loja.getClientes().add(cliente3);

            // Criar produtos
            Estoque estoque1 = new Estoque(10, 20.0);
            Estoque estoque2 = new Estoque(15, 25.0);
            Estoque estoque3 = new Estoque(20, 30.0);
            Estoque estoque4 = new Estoque(25, 35.0);
            Estoque estoque5 = new Estoque(10, 10.0);
            Estoque estoque6 = new Estoque(5, 50.0);

            Produto produto1 = new Produto(0, "Queijo", "Queijo Prato", null, fornecedor1, estoque1, true);
            Produto produto2 = new Produto(1, "Queijo", "Queijo Minas", null, fornecedor1, estoque2, true);
            Produto produto3 = new Produto(2, "Queijo Gorgonzola", "Queijo Gorgonzola", null, fornecedor2, estoque3,
                    true);
            Produto produto4 = new Produto(3, "Queijo", "Queijo da Montanha", null, fornecedor2, estoque4, true);
            Produto produto5 = new Produto(4, "Salame", "Salame Apimentado", null, fornecedor3, estoque5, true);
            Produto produto6 = new Produto(5, "Salame e Queijo", "Salame com Queijo Prato", null, fornecedor3, estoque6,
                    true);

            loja.getProdutos().add(produto1);
            loja.getProdutos().add(produto2);
            loja.getProdutos().add(produto3);
            loja.getProdutos().add(produto4);
            loja.getProdutos().add(produto5);
            loja.getProdutos().add(produto6);

            // Definir códigos
            loja.setCodUser(6);
            loja.setCodProd(6);
            loja.setNumPed(0);

            System.out.println("Dados iniciais criados com sucesso!");

            // Salvar dados iniciais
            salvarDados(loja);

            return true;

        } catch (Exception e) {
            System.err.println("Erro ao criar dados iniciais: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Reconecta os relacionamentos entre objetos após deserialização
     */
    private void reconectarRelacionamentos(Loja loja) {
        // Os relacionamentos já são mantidos automaticamente pelo Jackson
        // quando salvamos as referências completas dos objetos
    }

    /**
     * Verifica se existe arquivo de dados salvos
     */
    public boolean existeArquivoDados() {
        return new File(ARQUIVO_DADOS).exists();
    }

    /**
     * Migra dados de um arquivo antigo para o novo formato
     */
    private boolean migrarDados(Loja loja, File arquivoAntigo) {
        try {
            DadosLoja dados = objectMapper.readValue(arquivoAntigo, DadosLoja.class);

            // Transferir dados carregados para a loja
            loja.setFornecedores(dados.getFornecedores());
            loja.setClientes(dados.getClientes());
            loja.setProdutos(dados.getProdutos());
            loja.setPedidos(dados.getPedidos());
            loja.setCodUser(dados.getCodUser());
            loja.setCodProd(dados.getCodProd());
            loja.setNumPed(dados.getNumPed());

            // Reconectar relacionamentos
            reconectarRelacionamentos(loja);

            // Salvar no novo arquivo
            salvarDados(loja);

            System.out.println("Dados migrados com sucesso de " + arquivoAntigo.getName() + " para " + ARQUIVO_DADOS);
            return true;

        } catch (IOException e) {
            System.err.println("Erro ao migrar dados de " + arquivoAntigo.getName() + ": " + e.getMessage());
            System.out.println("Criando dados iniciais...");
            return criarDadosIniciais(loja);
        }
    }
}
