package trabalho.model;

public class Fornecedor extends Pessoa {
	private String descricao;

	public Fornecedor(String nome, String telefone, String email, String cpf, Endereco endereco, String descricao, Usuario usuario) {
		super(nome, telefone, email, cpf, endereco, usuario);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
