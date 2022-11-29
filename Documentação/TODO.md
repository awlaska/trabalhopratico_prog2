Tema C – Gestão de um stand de automóveis

Descrição do Problema  
- Pretende-se elaborar um programa que permita fazer a gestão de veículos disponíveis,
  de vendas e de clientes de um stand de automóveis.

Funcionalidades a incluir
1. Deve ser possível a criação de novos clientes. Este registo deve ser feito pelo próprio cliente.  
   Assuma que todos os clientes são registados no programa, não sendo possível realizar vendas a um cliente não registado;
2. O cliente deve conseguir aceder ao seu perfil, onde pode ver a sua informação e onde a pode modificar;
3. O cliente deve conseguir aceder à listagem de veículos, e deve conseguir ver a informação de um dado veículo;
4. O cliente deve conseguir reservar um veículo para compra.  
   Na reserva, o cliente deve conseguir marcar uma data na qual se irá deslocar ao stand para efetuar a compra do veículo.  
   Esta reserva altera o estado do veículo para reservado.  
   Quando um veículo está neste estado, não deve ser possível outro cliente reservar o veículo;
5. O cliente deve conseguir aceder a um histórico de compras e reservas;
6. O dono do stand deve conseguir adicionar, modificar ou desativar veículos do stand.  
   Veículos desativados não aparecem na listagem de veículos disponíveis para compra,  
   mas continuam a aparecer no histórico de compras e reservas do cliente;
7. O dono do stand deve ter acesso a uma listagem onde consegue visualizar todos os veículos que estão registados no stand (incluindo desativados);
8. O dono do stand deve conseguir validar ou cancelar uma reserva.  
   Se a reserva for cancelada, o veículo passa a estar novamente disponível para ser reservado por um cliente;
9. O dono do stand deve conseguir registar uma venda de um veículo.  
   Quando o veículo é vendido, este passa a deixar de ser listado nos veículos disponíveis para compra.  
      a. Se a venda for de uma reserva criada por um cliente, essa reserva passa para um estado concluída;  
      b. Se a venda for de um veículo que não tenha sido reservado, o dono deve conseguir associar a venda ao cliente;
10. O dono do stand deve conseguir aceder a uma listagem onde verifica os próximos clientes que se irão deslocar ao stand  
    (isto é, uma lista ordenada pela data indicada na reserva de um veículo);
11. O dono do stand deve conseguir aceder à informação de um dado cliente.
12. Cada tipo de utilizador identificado apenas deve ter acesso às funcionalidades que lhe dizem respeito.

Requisitos Gerais  
1. Criar 3 níveis de autenticação no sistema: Utilizador (pode aceder aos seus registos ou a registos consigo partilhados);  
   UserManager (pode criar utilizadores, editar permissões na aplicação e visualizar todos os registos);  
   Admin (pode realizar qualquer ação no sistema; criar/editar utilizadores (de todos os tipos),  
   alterar permissões e visualizar todos os registos disponíveis no sistema).  
   Quando a aplicação inicia pela primeira vez (ainda sem utilizadores),  
   deverá automaticamente criar um único utilizador do tipo Admin com um nome de utilizador e password conhecidos.
2. Toda a gestão de entidades deve ser executada em coleções (List, Map, Set), em memória.  
   No início e no fim da execução, os dados da aplicação poderão ser persistidos em ficheiro(s).  
   Poderá utilizar ficheiros de texto (exemplo: formato CSV) ou em formato binário através da serialização de classes (ver interface Serializable).
3. A aplicação deverá ter uma interface (com menus) que funciona através da linha de comandos.  
   A aplicação deverá receber como argumento o(s) ficheiro(s) com os dados anteriormente gravados ou o nome de um novo ficheiro.
4. Os dados introduzidos na aplicação devem der validados.

Bónus:
1. Utilização de comentários no formato JavaDoc nos atributos e métodos das classes.
2. Criação de histórico de ações ou comandos realizados no sistema, indicando o nome da ação realizada,
   o utilizador que a realizou e data/hora.  
   Cada utilizador pode consultar o seu histórico, sendo que os Admins podem consultar todo o histórico de utilização da aplicação.
3. As passwords deverão ser encriptadas (exemplo: ver classes SecureRandom e MessageDigest)
4. Implementação de interface gráfica (substitui a implementação de uma interface baseada em consola).
5. Utilização de ferramentas de versionamento de código, como o GIT.