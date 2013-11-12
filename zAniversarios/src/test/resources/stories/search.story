Funcionalidade: Acesso

Narrativa:
Para obter a tela inicial apareceça para mim
Como um visitante
Desejo acessar o Aniversariantes

Cenário: capturo os aniversariantes da "{REGIONAL}"

Dado que estou na tela "Tela de Aniversariantes"
Quando clico em "Link" referente a "{REGIONAL}"

Cenário: Login

Dado que vou para a tela "Tela de Login"
Quando informo "usuario" no campo "Nome do Usuário"
Quando informo "senha" no campo "Senha"
Quando clico em "Acessar"
Então será exibido "Aniversariantes"

Cenário: Capturar

Dado que estou na tela "Tela de Aniversariantes"
Quando capturo os aniversariantes da "<REGIONAL>"
Então será exibido "Regiona <REGIONAL>"

Exemplos:
|REGIONAL|
|Belo Horizonte|
|Belém|
|Brasília|
|Curitiba|
|Florianópolis|
|Fortaleza|
|Porto Alegre|
|Recife|
|Rio de Janeiro|
|Salvador|
|São Paulo|
