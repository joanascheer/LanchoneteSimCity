# LanchoneteSimCity
Lanchonete Fast Food Sim City. Desafio 003 Catalisa

Desafio 003 - OOP

Desafio do programa Catalisa 2022 utilizando Programação Orientada a Objetos, SOLID

Enunciado: 

O seu trabalho em SimCity tem sido tão bom que mais uma vez as pessoas
moradoras da cidade precisam dos seus serviços.
Dessa vez, é uma lanchonete FastFood que quer modernizar o sistema
deles para liberar as pessoas operadoras de caixa para outras funções e
permitir que seus clientes façam os pedidos de forma autônoma e passem
no balcão apenas para retirada de seus pedidos prontos para consumo.
Dessa forma, você vai criar um sistema para totem de auto-atendimento
que deve atender aos seguintes requisitos:
1. A tela inicial deve ter um menu onde a pessoa deve selecionar se ela
   quer comprar:
1. Lanche
2. Bebida
2. Caso a pessoa tente escolher algum item fora das opções acima, o
   sistema deve mostrar a mensagem “Opção inválida, tente
   novamente” e mostrar novamente o menu inicial.
3. O sistema deve aceitar apenas o número da opção, ou seja, se a
   pessoa quiser um lanche ela deve inserir 1 e caso queira uma bebida
   ela deve digitar 2.
4. Caso a pessoa tente inserir alguma informação do tipo String o
   sistema deve retornar uma mensagem: “Formato inválido, para
   escolher o item, você deve informar o número dele”.
5. Quando digitar 1, ou seja, o item Lanche, deve aparecer as opções:
1. X-burger
2. X-salada

Desafio 03

a. Caso a pessoa tente escolher algum item fora das opções
acima, o sistema deve mostrar a mensagem “Opção inválida,
tente novamente” e mostrar novamente o menu inicial do
lanche.
b. Caso a pessoa tente inserir alguma informação do tipo String,
o sistema deve retornar uma mensagem: “Formato inválido,
para escolher o item, você deve informar o número dele”.
6. Quando a pessoa selecionar o lanche que quer comprar, o sistema
   deve perguntar a quantidade do lanche solicitado que a pessoa quer
   comprar, após o usuário selecionar o lanche e a quantidade, o
   carrinho de compra deve adicionar o código, quantidade, nome e
   valor do lanche e mostrar o valor total do pedido até aquele
   momento. Sendo que os valores dos lanches são:
   a. X-burger - R$ 10,00
   b. X-salada - R$ 12,00

7. Quando digitar 2, ou seja, o item Bebida, deve aparecer as opções:
1. Refrigerante
2. Suco
   a. Caso a pessoa tente escolher algum item fora das opções
   acima, o sistema deve mostrar a mensagem “Opção inválida,
   tente novamente” e mostrar novamente o menu inicial da
   bebida.
   b. Caso a pessoa tente inserir alguma informação do tipo String,
   o sistema deve retornar uma mensagem: “Formato inválido,
   para escolher o item, você deve informar o número dele”.
8. Quando a pessoa selecionar a bebida que quer comprar, o sistema
   deve perguntar a quantidade de bebida que a pessoa quer comprar,
   após o usuário selecionar a bebida e a quantidade, o carrinho de

Desafio 03

compra deve adicionar o código, a quantidade, nome e valor da
bebida e mostrar o valor total do pedido até aquele momento. Sendo
que os valores das bebidas são:
a. Refrigerantes - R$ 8,00
b. Sucos - R$ 6,00
9. Após a pessoa informar o lanche ou bebida que quer comprar e ver o
   valor total do pedido até aquele momento, o sistema deve perguntar
   se a pessoa deseja incluir mais itens, editar um item, remover item
   ou se deseja finalizar o pedido.
   a. Se ela desejar comprar mais itens, o sistema deve voltar para o
   menu inicial.
   b. Se ela desejar editar um item, o sistema deve solicitar o código
   do produto que deseja editar. Após receber um código válido e
   encontrar o produto, o sistema deverá perguntar qual a nova
   quantidade de itens que o usuário deseja adicionar, após o
   usuário atualizar o valor da quantidade, o sistema deve
   atualizar o valor total da compra e exibir novamente o carrinho
   atualizado.
   c. Se ela desejar remover itens, o sistema deve solicitar o código
   do produto válido que deseja remover (o código é um número
   que deverá ser adicionado ao produto automaticamente
   quando for adicionado ao carrinho), após ser feita a remoção
   do produto a partir do código, o sistema deve exibir o carrinho
   de compras atualizado.
   d. Se ela desejar finalizar o pedido, o sistema deve mostrar o valor
   total do pedido e quais os itens que ela selecionou e perguntar
   qual a forma de pagamento, sendo que o sistema deve aceitar
   cartão de crédito, cartão de débito, vale refeição e dinheiro.
   i. Após a pessoa selecionar uma das opções: cartão de
   crédito, cartão de débito ou vale refeição, o sistema
   mostra a seguinte mensagem: "Compra finalizada com
   sucesso! Boa refeição”.

Desafio 03

ii. Caso a pessoa selecione dinheiro, o sistema deve pedir
qual o valor em dinheiro que o usuário usará para pagar,
caso seja um valor mais alto que o valor total da compra,
o sistema deverá exibir o troco que o usuário deverá
receber.
iii. Caso a pessoa tente escolher alguma coisa fora das
opções acima, o sistema deve mostrar a mensagem
“Opção inválida, tente novamente” e mostrar novamente
as opções de cartão de crédito, cartão de débito, vale
refeição e dinheiro.

Entrega Mínima
- O sistema deve permitir que um produto seja adicionado ao
  carrinho.
- Sempre que um produto for adicionado ao carrinho, o valor do
  campo do código do produto deve ser adicionado automaticamente.
- O Sistema também deve permitir visualizar todos os produto
  adicionados na lista ao final da compra.
  Exemplo de saída:
  -------- SimCity FastFood ---------
  001 - 2 X-burger - R$ 20,00
  002 - 2 Sucos - R$ 12,00
  003 - 1 Refrigerante - R$ 8,00

- Essa lista deve conter apenas os campos: código, quantidade, nome
  do produto e valor. Por fim, o sistema deve permitir remover um
  produto do carrinho a partir do código, ao finalizar a remoção o
  sistema deve exibir a lista de produto do carrinho atualizada.

Desafio 03

Entrega média
O sistema deve conter interações com um menu dinâmico e a opção de
sair do sistema, além de todas as validações de campos obrigatórios para
escolher as opções do menu, sendo elas:
- Validação de opção na escolha do lanche
- Validação de opção na escolha da bebidas
- Validações na escolha das opções dos lanches e das bebidas
  oferecidas pelo sistema
- Validação na inserção(verificação de tipo de dado, lembrando que o
  código deverá ser um valor numérico, e tratamento para caso o item
  a ser removido ou editado não seja encontrado na lista, ou não
  exista) do código para remoção e atualização do produto no carrinho.
- validação quando a opção do pagamento for dinheiro (verificação de
  tipo de dado).
  IMPORTANTE: Entrega média válida APENAS se a mínima estiver
  desenvolvida e funcional.

Desafio 03

Entrega Máxima
O sistema deve permitir o usuário realizar as 4 operações básicas de um
sistema sendo:
- Inserção de produto no carrinho.
- Editar a quantidade de um item selecionado e atualizar o carrinho de
  compra.
- Remover um item a partir do código e atualizar a lista do carrinho de
  compra.
- Exibir todos os itens do carrinho.
  Além disso, o sistema deverá conter todas as validações e tratamentos
  necessários para entrada de dados incorretos, verificação de existência de
  itens no carrinho e campos nulos.
  O sistema também deverá conter a interação com menu dinâmico e opção
  de sair do sistema.
  IMPORTANTE: Entrega máxima válida APENAS se a média estiver
  desenvolvida e funcional.
