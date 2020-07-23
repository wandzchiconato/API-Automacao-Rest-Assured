#language: pt
  #enconding: utf-8

Funcionalidade: pesquisa de Usuario

  Esquema do Cenario: pesquisa de Usuario com Sucesso

    Dado a requisicao contem <id> <username> <firstname> <lastname> <email> <password> <phone> <userStatus>
    Quando conecto com a uri da PetShop
    Entao pesquiso <username>

    Exemplos:
      | id          | username   | firstname | lastname | email                | password | phone         | userStatus | code | type      | message     |
      | "119740511" | "AnaClara" | "Ana"     | "Clara"  | "anaclara@teste.com" | "123456" | "11999990001" | 1          | 200  | "unknown" | "119740511" |
      | "219740511" | "JucaPato" | "Juca"    | "Pato"   | "jucapato@teste.com" | "654321" | "11999990002" | 1          | 200  | "unknown" | "219740511" |