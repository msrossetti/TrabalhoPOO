package trabalho.controller;

import trabalho.view.Menu;

public class MainController {
    public static void main(String[] args) {
        // Ponto de entrada da aplicação
        // Cria uma instância da loja (controller principal)
        Loja loja = new Loja();
        
        // Cria a interface do usuário (view)
        Menu menu = new Menu(loja);
        
        // Inicia o sistema
        menu.exibirMenuPrincipal();
    }
}
