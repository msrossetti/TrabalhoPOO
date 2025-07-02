# COMO USAR JACKSON SEM MAVEN

## Passo 1: Baixar as bibliotecas Jackson
Execute o comando:
```
download-jackson.bat
```
Isso vai criar uma pasta `lib` e baixar os 4 JARs necessários do Jackson.

## Passo 2: Compilar com Jackson
Execute o comando:
```
compile-with-jackson.bat
```
Isso vai compilar seu código Java incluindo as bibliotecas Jackson.

## Passo 3: Executar o programa
Execute o comando:
```
run-with-jackson.bat
```
Seu programa vai rodar com persistência JSON usando Jackson!

## O que acontece?
- Os dados são carregados dos arquivos JSON na pasta `data/`
- Quando você faz alterações (adicionar clientes, produtos, pedidos), eles são salvos automaticamente nos arquivos JSON
- Na próxima execução, os dados são carregados novamente

## Arquivos de dados:
- `data/clientes.json` - Lista de clientes
- `data/fornecedores.json` - Lista de fornecedores  
- `data/produtos.json` - Lista de produtos
- `data/pedidos.json` - Lista de pedidos
- `data/contadores.json` - Contadores de códigos

## Se der erro:
1. Verifique se tem internet para baixar os JARs
2. Verifique se o Java está instalado: `java -version`
3. Verifique se javac está instalado: `javac -version`
