#language:pt
@categoria
Funcionalidade: Consulta Categoria

  Cenario: Ralizar Consulta Categorias com Sucesso
    Dado que tenha realizado o login com dados validos
    E que tenha um payload da API de categoria
    Quando realizo uma requisicao do tipo GET de categoria
    Entao valido que recebo o status 200 no response
    E valido que no campo "tipo[2]" possui valor "Terror"

  Cenario: Ralizar Consulta Categorias sem token
    Quando realizo uma requisicao do tipo GET de categoria
    Entao valido que recebo o status 403 no response
    E valido que no campo "message" possui valor "Access Denied"