# Programa Para Empréstimos de Ferramentas.

## 😶‍🌫️ Introdução.
O presente trabalho tem como intuito propor a análise e modelagem de um sistema de software destinado ao gerenciamento de empréstimos de ferramentas, 
visando atender de forma eficaz às demandas específicas do cliente e de seus potenciais usuários. O objetivo principal é o desenvolvimento de um software que não apenas otimize o
cadastro de ferramentas e amigos, mas também monitore de maneira eficiente o processo de empréstimo desses itens, fornecendo relatórios sobre despesas, empréstimos ativos e um histórico completo de transações.

## 🧠 Integrantes do Grupo:

➡️ Ana Carolina Vieira Marcondes Bories - RA:1072416427 - Conta GitHub - [anacvieiracc](https://github.com/anacvieiracc)

➡️ Davi Dias Perius, 10724114628, Unisul ADM  - RA:10724114628 - Conta GitHub - [Periusdv](https://github.com/Periusdv) 

➡️ Guilherme Mitsuo Honda - RA:1072416697 - Conta GitHub - [lmitsuol](https://github.com/lmitsuol)

➡️ Lorenzo Eid Colaferro - RA:1072419633 - Conta GitHub - [lorenzoeid](https://github.com/lorenzoeid)

➡️ Mateus Aloisio Marcelino - RA:1072321293 - Conta GitHub - [MateusAMarcelino](https://github.com/MateusAMarcelino)


## 🛠️ Linguagens e Tecnologias Utilizadas:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/javafx-%23FF0000.svg?style=for-the-badge&logo=javafx&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![NetBeans IDE](https://img.shields.io/badge/NetBeansIDE-1B6AC6.svg?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

## 😎 Contextualização:

Para melhor compreensão de nosso trabalho, apresentamos a seguir o problema a ser abordado e solucionado através do desenvolvimento do software:

	“No churrasco de família, seu tio-avô lhe pediu um software para gerenciar o empréstimo de ferramentas. Ele quer que o software rode localmente no computador dele.
    A ideia é ter um cadastro de ferramentas (nome, marca, custo de aquisição) e o de amigos (nome, telefone).
	Ele gostaria de registrar os empréstimos de uma ou mais ferramentas a um determinado amigo, marcando a data que ocorreu e também a data de devolução.
	Ele pediu que o software tivesse um relatório de ferramentas e o quanto ele gastou. Também vai querer outro relatório dos empréstimos ativos e de todos os empréstimos realizados. 
    Por algum motivo, ele gostaria de saber quem é que fez mais empréstimos e se tem alguém que nunca devolveu algum item. Inclusive, a cada novo empréstimo, ele gostaria que o sistema diga se o amigo ainda tem algo que não devolveu.
	Dias mais tarde, ele pediu para aproveitar o cadastro de amigos e criar uma agenda integrada com o Google para registrar o convite dos amigos a algum evento, a integração tem como princípio 
    compartilhar o lembrete do evento de forma a ele receber um e-mail.”

    
### Requisitos Funcionais e não funcionais ⬇️
```bash
REQUISITOS FUNCIONAIS:
. RF001 -> Cadastrar as ferramentas com nome, marca e custo.
. RF002 -> Cadastrar os amigo com nome, telefone e e-mail.
. RF003 -> Registrar o empréstimo das ferramentas ao amigo, incluindo a data 
de empréstimo e devolução.
. RF004 -> O software precisa ter uma lista de todas as ferramentas e o valor gasto 
nelas.
. RF005 -> Mostrar o relatório de todos os empréstimos ativos.
. RF006 -> Mostrar o relatório de todos os empréstimos realizados.
. RF007 -> Mostrar qual amigo fez mais empréstimos.
. RF008 -> Mostrar se algum amigo nunca devolveu uma ferramenta.
. RF009 -> Ao fazer um novo empréstimo, mostrar se o amigo tem alguma
ferramenta não devolvida.

REQUISITOS NÃO FUNCIONAIS:
. RNF001 -> O sistema deve ser utilizado no Windows 10.
. RNF002 -> O programa deve rodar localmente em um computador pessoal.
. RNF003 -> O programa deve ser desenvolvido em Java, Na versão 8.
. RNF004 -> O programa deve ser conectado a uma base de dados usando mySQL, Na versão 8.3.0
```

## Configurando o Banco de Dados:
```bash
 Usuário ; root
 Senha ; root

 Os scripts que terão de ser utilizados para criar o Banco de Dados, estão no arquivo [ banco.sql ]




