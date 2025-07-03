package trabalho;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Classe que encapsula todos os dados da loja para serialização JSON
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosLoja {
    private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private int codUser = 0;
    private int codProd = 0;
    private int numPed = 0;

    // Construtor padrão necessário para Jackson
    public DadosLoja() {
    }

    // Getters e setters
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
}
