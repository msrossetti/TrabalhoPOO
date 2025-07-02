package trabalho;

import java.util.Date;

public class Pedido {
	private int numero;
	private Date dataPedido;
	private Date dataEntrega;
	private String situacao;
	protected Cliente cliente;
	protected ItemPedido[] itens;
	private int totalItens;
	private static final int maxIPP = 10;

	// Construtor padrão para Jackson
	public Pedido() {
		this.itens = new ItemPedido[maxIPP];
	}

	public Pedido(int numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.dataPedido = new Date();
		this.itens = new ItemPedido[maxIPP];
		this.totalItens = 0;
		this.situacao = "Pendente";
	}

	public double calcularTotalPedido() {
		double total = 0;
		for (int i = 0; i < maxIPP; i++) {
			if (itens[i] != null) {
				total += itens[i].getTotalItem();
			}
		}
		return total;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ItemPedido[] getItens() {
		return itens;
	}

	public void setItens(ItemPedido[] itens) {
		this.itens = itens;
	}

	public int getTotalItens() {
		return totalItens;
	}

	public void setTotalItens(int totalItens) {
		this.totalItens = totalItens;
	}

	public int getMaxIPP() {
		return maxIPP;
	}

}
