#!/bin/bash

# Diretórios
SRC_DIR="src"
OUT_DIR="bin"
LIB_DIR="lib"

# Cria o diretório de saída, se não existir
mkdir -p "$OUT_DIR"

# Compila os arquivos Java
echo "Compilando..."
javac -cp "$LIB_DIR/*" -d "$OUT_DIR" "$SRC_DIR"/trabalho/*.java

# Verifica se a compilação teve sucesso
if [ $? -eq 0 ]; then
    echo "Compilação bem-sucedida."
    echo "Executando o programa..."
    
    # Executa o programa
    java -cp "$LIB_DIR/*:$OUT_DIR" trabalho.Menu
else
    echo "Erro na compilação. Execução cancelada."
fi

