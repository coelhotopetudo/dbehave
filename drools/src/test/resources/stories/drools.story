Funcionalidade: Aplicar regras

Eu quero: utilizar as funcionalidades básicas do motor de regras
De modo que: o motor de regras execute as operações básicas

Cenário: Carregar planilha de regras

Quando inicio o motor de regras
Então o motor de regras dirá "Iniciei"

Cenário: Franca Brasil cinco quilos

Quando informo origem-residencia-bagagem "Franca-Brasil-5"
Então seu valor será "3"

Cenário: EUA Brasil dez quilos

Quando informo origem-residencia-bagagem "EUA-Brasil-10"
Então seu valor será "5"

Cenário: EUA EUA nada

Quando informo origem-residencia-bagagem "EUA-EUA- "
Então seu valor será "1"