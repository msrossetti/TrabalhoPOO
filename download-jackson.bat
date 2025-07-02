@echo off
echo Baixando bibliotecas Jackson...

mkdir lib 2>nul

echo Baixando jackson-core...
powershell -Command "Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.15.2/jackson-core-2.15.2.jar' -OutFile 'lib\jackson-core-2.15.2.jar'"

echo Baixando jackson-databind...
powershell -Command "Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.15.2/jackson-databind-2.15.2.jar' -OutFile 'lib\jackson-databind-2.15.2.jar'"

echo Baixando jackson-annotations...
powershell -Command "Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.15.2/jackson-annotations-2.15.2.jar' -OutFile 'lib\jackson-annotations-2.15.2.jar'"

echo Baixando jackson-datatype-jsr310...
powershell -Command "Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.15.2/jackson-datatype-jsr310-2.15.2.jar' -OutFile 'lib\jackson-datatype-jsr310-2.15.2.jar'"

echo.
echo Bibliotecas baixadas na pasta 'lib'!
echo Agora use: compile-with-jackson.bat
pause
