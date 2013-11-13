Funcionalidade: Aplicar regras

Eu quero: utilizar as funcionalidades básicas do motor de regras
De modo que: o motor de regras execute as operações básicas

Cenário: Carregar planilha de regras

Quando inicio o motor de regras
Então o motor de regras dirá "Iniciei"

Cenário: Execução das regras
Dado que a origem do viajante é "<ORIGEM>"
Dado que o país de residência do viajante é "<RESIDENCIA>"
Dado que a quantidade de bagagem é "<BAGAGEM>"
Quando solicito a execução das regras
Então seu valor será "<PESO>"

Exemplos:
|ORIGEM|RESIDENCIA|BAGAGEM|PESO|
|Franca|Brasil|5|3|
|EUA|Brasil|10|5|
|EUA|EUA|1|1|