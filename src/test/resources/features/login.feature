#language:pt

   Funcionalidade: Realizar login
     Teste da API de Login

    Cenario: Realizar login de sucesso
      Dado que tenha um payload valido da API de Login
      Quando envio uma requisicao do tipo POST de login
      Entao valido que recebo o status 200 no response
      E armazeno o token que recebo do response de login

    Cenario: Realizar Login com usuario invalido
      Dado que tenha um payload da API de login com as seguintes informacoes
        |email | invalido@email.com|
        |senha | 123456            |
      Quando envio uma requisicao do tipo POST de login
      Entao valido que recebo o status 200 no response
