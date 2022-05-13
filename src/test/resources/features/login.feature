#language:pt

Funcionalidade: Realizar login
  Teste da API de Login

  @loginSucesso
  Cenario: Realizar login de sucesso
    Dado que tenha um payload valido da API de Login
    Quando envio uma requisicao do tipo POST de login
    Entao valido que recebo o status 200 no response
    E armazeno o token que recebo do response de login
  @loginInvalido
  Esquema do Cenario: Realizar Login com <cenario>
    Dado que tenha um payload da API de login com as seguintes informacoes
      | email | <email> |
      | senha | <senha> |
    Quando envio uma requisicao do tipo POST de login
    Entao valido que recebo o status 400 no response

    Exemplos:
      | cenario          | email              | senha    |
      | usuario invalido | invalido@email.com | 123456   |
      | senha invalida   | aluno@email.com    | invalido |