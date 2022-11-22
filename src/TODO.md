Tema C – Gestão de um stand de automóveis

Descrição do Problema  
- Este projeto consiste no desenvolvimento de um sistema de rastreio de tarefas para os freelancers poderem anotar o trabalho realizado diariamente, de forma a ajudar na cobrança do valor adequado pelos serviços.

Funcionalidades a incluir
1. Um utilizador pode criar uma conta. Para aceder ao sistema, o utilizador deverá efetuar login.
2. O utilizador pode editar os dados da sua conta, nomeadamente o seu nome, dados de autenticação e número habitual de horas de trabalho diário.
3. O utilizador poderá criar um projeto para agrupar tarefas. Um projeto tem um nome, nome do cliente e preço por hora. As informações sobre o projeto poderão ser alteradas. Os projetos podem ser removidos, tendo o utilizador a opção de apagar todas as tarefas associadas ou simplesmente desassociar as tarefas.
4. Um utilizador pode iniciar uma tarefa indicando uma curta descrição e data/hora de início. Alternativamente, se não for indicada data e hora, considera-se que a tarefa inicia no momento atual. As tarefas podem ter um projeto associado e um preço hora (por defeito, o preço hora desse projeto).
5. Um utilizador pode terminar uma tarefa em determinada data e hora. Se não for indicada uma data e hora, considera-se o momento atual.
6. Um utilizador pode remover tarefas em curso ou finalizadas.
7. O utilizador pode listar todas as tarefas em curso, obtendo informação do tempo total despendido até ao momento.
8. O utilizador pode listar todas as tarefas finalizadas entre duas datas.
9. Um utilizador pode convidar outro utilizador para participar num projeto. O utilizador que é convidado para um projeto deverá aceitar o convite para poder introduzir tarefas nesse projeto.
10. O utilizador criador do projeto pode remover utilizadores convidados dos seus projetos.
11. Deverá ser possível visualizar (imprimir) um relatório pessoal para determinado mês, que deverá incluir lista de tarefas realizadas em cada dia (com indicação do projeto), número de horas total em cada dia e número de horas totais no mês. Caso alguma das tarefas tenha um preço hora associado, deverá ser indicado o preço total por dia e preço total do mês. As tarefas em curso não deverão ser incluídas no relatório. Os dias em que o utilizador excedeu o número habitual de horas diárias devem ser sinalizados no relatório.
12. Deverá ser possível imprimir um relatório mensal semelhante ao descrito na linha acima, mas ao nível do projeto e ao nível do cliente, indicando adicionalmente todos os utilizadores que executaram as tarefas a cada dia.

Requisitos Gerais  
1. Criar 3 níveis de autenticação no sistema: User (pode aceder aos seus registos ou a registos consigo partilhados); UserManager (pode criar utilizadores, editar permissões na aplicação e visualizar todos os registos); Admin (pode realizar qualquer ação no sistema; criar/editar utilizadores (de todos os tipos), alterar permissões e visualizar todos os registos disponíveis no sistema). Quando a aplicação inicia pela primeira vez (ainda sem utilizadores), deverá automaticamente criar um único utilizador do tipo Admin com um nome de utilizador e password conhecidos.
2. Toda a gestão de entidades deve ser executada em coleções (List, Map, Set), em memória. No início e no fim da execução, os dados da aplicação poderão ser persistidos em ficheiro(s). Poderá utilizar ficheiros de texto (exemplo: formato CSV) ou em formato binário através da serialização de classes (ver interface Serializable).
3. A aplicação deverá ter uma interface (com menus) que funciona através da linha de comandos. A aplicação deverá receber como argumento o(s) ficheiro(s) com os dados anteriormente gravados ou o nome de um novo ficheiro.
4. Os dados introduzidos na aplicação devem der validados.

Bónus:
1. Utilização de comentários no formato JavaDoc nos atributos e métodos das classes.
2. Criação de histórico de ações ou comandos realizados no sistema, indicando o nome da ação realizada, o utilizador que a realizou e data/hora. Cada utilizador pode consultar o seu histórico, sendo que os Admins podem consultar todo o histórico de utilização da aplicação.
3. As passwords deverão ser encriptadas (exemplo: ver classes SecureRandom e
   MessageDigest)
4. Implementação de interface gráfica (substitui a implementação de uma interface baseada em consola).
5. Utilização de ferramentas de versionamento de código, como o GIT.