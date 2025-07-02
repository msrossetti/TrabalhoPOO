package trabalho;

public class Produto {
	private int cod;
	private String nome, descricao;
	private byte[] foto;
	protected Fornecedor fornecedor;
	private boolean disponivel;
	protected Estoque estoque;
	
	// Construtor padrão para Jackson
	public Produto() {
	}
	
	public Produto(int cod, String nome, String descricao, byte[] foto, Fornecedor fornecedor, Estoque estoque, Boolean disponivel) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.descricao = descricao;
		this.foto = foto;
		this.fornecedor = fornecedor;
		this.estoque = estoque;
		this.disponivel = disponivel;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
