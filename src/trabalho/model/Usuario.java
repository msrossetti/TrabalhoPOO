package trabalho.model;

public class Usuario {
	private String login, senha;
	private boolean isActive;
	private int cod;
	
	public Usuario(String login, String senha, int cod, boolean isActive) {
		super();
		this.login = login;
		this.senha = senha;
		this.cod = cod;
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
}
