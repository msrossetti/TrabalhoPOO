package trabalho;

public class ItemPedido {
	protected Produto produto;
	private int quantidade;
	
	public ItemPedido(Produto produto, int quantidade) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public double getTotalItem( ) {
		return quantidade * produto.estoque.getPreco();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
