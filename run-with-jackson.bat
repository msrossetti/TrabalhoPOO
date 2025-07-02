@echo off
echo Executando programa com Jackson...

if not exist "bin\trabalho\Menu.class" (
    echo ERRO: Classes nao compiladas!
    echo Execute primeiro: compile-with-jackson.bat
    pause
    exit /b 1
)

echo Executando Menu...
java -cp "bin;lib\jackson-core-2.15.2.jar;lib\jackson-databind-2.15.2.jar;lib\jackson-annotations-2.15.2.jar;lib\jackson-datatype-jsr310-2.15.2.jar" trabalho.Menu

pause
