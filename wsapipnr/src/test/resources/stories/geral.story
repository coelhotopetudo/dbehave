Funcionalidade: Receber mensagem

Eu quero: Receber as mensagens que o cliente enviar
De modo que: Após receber uma mensagem, verificar se ela possui todos os campos obrigatórios e se o hash do conteúdo são iguais

Cenário: Mensagem com erro de hash

Quando recebo uma mensagem "com erro de hash"
Então deve retornar "erro de hash"

Cenário: Mensagem mal formado, faltando um fechamento de tag

Quando recebo uma mensagem "mal formado"
Então deve retornar "erro de xsd"

Cenário: Mensagem sem todos os campos obrigatórios, isto é, somente com id e conteúdo

Quando recebo uma mensagem "com somente os campos id e conteudo"
Então deve retornar "erro de xsd"

Cenário: Mensagem sem conteúdo, zerado

Quando recebo uma mensagem "sem conteudo"
Então deve retornar "erro de xsd"

Cenário: Mensagem com Formato e hash corretos

Quando recebo uma mensagem "com hash e formato correto"
Então deve retornar "ok"
