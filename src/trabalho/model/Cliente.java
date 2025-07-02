package trabalho.model;

public class Cliente extends Pessoa {
	private String cartaoCredito;

	public Cliente(String nome, String telefone, String email, String cpf, Endereco endereco, String cartaoCredito, Usuario usuario) {
		super(nome, telefone, email, cpf, endereco, usuario);
		this.cartaoCredito = cartaoCredito;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}
}
