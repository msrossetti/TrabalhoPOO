@echo off
echo Compilando com Jackson...

if not exist "lib\jackson-core-2.15.2.jar" (
    echo ERRO: Bibliotecas Jackson nao encontradas!
    echo Execute primeiro: download-jackson.bat
    pause
    exit /b 1
)

echo Limpando diretorio bin...
rmdir /s /q bin 2>nul
mkdir bin

echo Compilando classes Java...
javac -cp "lib\jackson-core-2.15.2.jar;lib\jackson-databind-2.15.2.jar;lib\jackson-annotations-2.15.2.jar;lib\jackson-datatype-jsr310-2.15.2.jar" -d bin src\trabalho\*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilacao concluida com sucesso!
    echo Use: run-with-jackson.bat para executar
) else (
    echo ERRO na compilacao!
)

pause
