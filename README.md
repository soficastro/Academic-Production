# Academic-Production

PROJETO AINDA NÃO REFATORADO

Conta de Administrador:
email: divers
senha: 234

FUNCIONALIDADES

-> Alocação de alunos de gradução, alunos de pós graduação, alunos de mestrado, professores e pesquisadores;
-> Alocação e edição de produções acadêmicas: pesquisas e publicações;
-> Orientação entre professores e alunos;
-> Consulta de acervo de produções acadêmicas e colaboradores.

CLASSES

  - Main
Classe prinpical onde boa parte dos processos acontecem.

  - Admin
Certas funcionalidades do Sistema só podem ser acessadas pelo administrador do Sistema. Essas funcionalidades são adicionar e 
editar projeto, adicionar publicação, adicionar um orientando a um professor. Essa classe, então, guarda as informações de login
do administrador e é usada para checar se o usuário é de fato aquele. A desvantagem é que o administrador já é predefinido de
antemão, não é possível editar email ou senha ou criar outro.

  - Professor
Classe para o tipo de colaborador Professor. Tem as informações de nome, email, projetos, publicações e orientandos. Possui um
método "display" que exibe todas as informações de um professor. A desvantagem é que essa classe possui muitas semelhanças com outras
classes que poderiam estar numa superclasse Person.

  - Project
Classe para a produção acadêmica Projeto. Possui os métodos "start" - que inicializa um projeto, caso você escolha adicionar
todas as informações deste e também, através de um loop, adiciona seus participantes, e "edit" que permite a edição dessas
mesmas informações. O método de exibir todas as informações de um projeto ainda não foi implementada.

  - Publication
Classe para a produção acadêmica Publicação. Para adicionar informações a uma publicação, foram usados vários métodos diferentes
que ainda não foram totalmente implementados. Outra desvantagem é que poderia estar numa superclasse Production com informações
em comum com a classe Project.

  - Researcher
Classe para o tipo de colaborador Pesquisador. Tem as informações de nome, email, projetos e publicações. Possui um método 
"display" que exibe todas as informações de um pesquisador. Essa função ainda não está totalmente implementada. A desvantagem
é que essa classe possui muitas semelhanças com outras classes que poderiam estar numa superclasse Person.

  - Student
Classe para o tipo de colaborador Aluno. Tem as informações de nome, email, projetos, publicações e tipo de alunos. Possui
um método "display" que exibe todas as informações de um alunosa função ainda não está totalmente implementada. A desvantagem
é que essa classe possui muitas semelhanças com outras classes que poderiam estar numa superclasse Person.

DISTRIBUIÇÃO DOS MÉTODOS
Boa parte dos métodos estão na classe Main entre eles "consult" que permite uma consulta sobre um colaborador ou um projeto; o método 
"login" que é chamado depois que o administrador pede acesso ao Sistema e onde acontecem todas as modificações de informações ou onde
se chama métodos para tal; e o método "report" que dá um relatório do desempenho do Laboratório.


