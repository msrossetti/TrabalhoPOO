package trabalho;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DataManager {
    private static final String DATA_DIR = "data";
    private static final String FORNECEDORES_FILE = DATA_DIR + "/fornecedores.json";
    private static final String CLIENTES_FILE = DATA_DIR + "/clientes.json";
    private static final String PRODUTOS_FILE = DATA_DIR + "/produtos.json";
    private static final String PEDIDOS_FILE = DATA_DIR + "/pedidos.json";
    private static final String CONTADORES_FILE = DATA_DIR + "/contadores.json";
    
    private ObjectMapper objectMapper;
    
    public DataManager() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        // Criar diretório de dados se não existir
        File dataDir = new File(DATA_DIR);
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }
    
    // Salvar fornecedores
    public void salvarFornecedores(ArrayList<Fornecedor> fornecedores) throws IOException {
        objectMapper.writeValue(new File(FORNECEDORES_FILE), fornecedores);
    }
    
    // Carregar fornecedores
    public ArrayList<Fornecedor> carregarFornecedores() throws IOException {
        File file = new File(FORNECEDORES_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, 
            objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Fornecedor.class));
    }
    
    // Salvar clientes
    public void salvarClientes(ArrayList<Cliente> clientes) throws IOException {
        objectMapper.writeValue(new File(CLIENTES_FILE), clientes);
    }
    
    // Carregar clientes
    public ArrayList<Cliente> carregarClientes() throws IOException {
        File file = new File(CLIENTES_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, 
            objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Cliente.class));
    }
    
    // Salvar produtos
    public void salvarProdutos(ArrayList<Produto> produtos) throws IOException {
        objectMapper.writeValue(new File(PRODUTOS_FILE), produtos);
    }
    
    // Carregar produtos
    public ArrayList<Produto> carregarProdutos() throws IOException {
        File file = new File(PRODUTOS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, 
            objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Produto.class));
    }
    
    // Salvar pedidos
    public void salvarPedidos(ArrayList<Pedido> pedidos) throws IOException {
        objectMapper.writeValue(new File(PEDIDOS_FILE), pedidos);
    }
    
    // Carregar pedidos
    public ArrayList<Pedido> carregarPedidos() throws IOException {
        File file = new File(PEDIDOS_FILE);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return objectMapper.readValue(file, 
            objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Pedido.class));
    }
    
    // Salvar contadores
    public void salvarContadores(ContadoresData contadores) throws IOException {
        objectMapper.writeValue(new File(CONTADORES_FILE), contadores);
    }
    
    // Carregar contadores
    public ContadoresData carregarContadores() throws IOException {
        File file = new File(CONTADORES_FILE);
        if (!file.exists()) {
            return new ContadoresData();
        }
        return objectMapper.readValue(file, ContadoresData.class);
    }
    
    // Salvar todos os dados
    public void salvarTodos(ArrayList<Fornecedor> fornecedores, ArrayList<Cliente> clientes, 
                           ArrayList<Produto> produtos, ArrayList<Pedido> pedidos, 
                           ContadoresData contadores) throws IOException {
        salvarFornecedores(fornecedores);
        salvarClientes(clientes);
        salvarProdutos(produtos);
        salvarPedidos(pedidos);
        salvarContadores(contadores);
    }
}
