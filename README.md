# schedulingFinancialTransfers
Agendamento de Transferencia Financeira

# Patterns utilizado no projeto.

   -Abstract Factory:
    Utilizado para reaproveitamento da regra de negocio, futuramente podemos ter novas camadas que  vai ser necessário reutilizar os mesmos cálculos (regras de juros), poderia também ter usado o conceito de interface, então teríamos um cenário de polimorfismo, onde cada classe implementaria sua regra de negocio, pensei de uma forma diferente visando que a descrição do negocio não afirmou que poderia ser de tal maneira. 



# Justifique frameworks.

    -Juni - Criação dos testes unitarios (validação apenas das regras de negocio), nao havia nessecidade de criar os testes integrados, porque nao é acessado nenhum banco de dados ou camada externa.

    -Maven - Utilizado para gestão de dependencia e principalmente para build do projeto, atravez do comando (mvn) linha de comando e possivel executar o projeto de fomra simples e organizada. 

    -MapStruct - Utilizado para fazer o "DE PARA", e deixar de forma limpa, dinamica e organizada o codigo, nao precisando utilizar os metodos SET do java, mapeamentos feitos na interface.



# Códigos complexos podem ter um comentário descrevendo a solução.

   -Em todos os metodos complexos, foi feito um comentario na classe e se necessario dentro do metodos nas validações.

   

Usado arquitetura MVC para desacoplamento do codigo e manter legibilidade para facil entendimento em possiveis manutenções, dessa forma podemos reutilizar os metodos de forma clara e seguindo um dos conceitos de orientação a objeto.



# -Camadas:

    -API -Responsavel por receber os parametros de entrada, não existe interface grafica execução do projeto via linha de comando, passando os parametros necessarios.

    -Controller - Responsavel por controlar toda o fluxo de negocio.

    -DAO - Responsavel por executar as regras de negocio.

    -Utils - Responsavel por ser o apoio das regras (Deve ser reutilizado em varios pontos do projeto).

    -Entity - Responsavel por ser o objeto principal de manipulaçao do negocio.

    -Unums -Responsavel por manter organizada as mensagens e codigos do projeto.

    

# Versões Utilizas: 

    -Java 1.8

    -Maven 3.9

    -Junit 4.0

    -MapStruct 2.0

# Execução:  
   -Executar via maven, (ferramenta de BUILD)
      --Comando deve ser realizado via linha de comando na pasta onde contempla o .pom: mvn clean install para gerar o .jar
     
     --Em seguida executar o comando "java -jar finacialSchenduling-0.0.1-SNAPSHOT.jar 15/09/2017 5000 XXXXXX ADD" sem as ""
     
     --1º parâmetro data do agendamento "15/09/2017"
     --2º parâmetro valor da transferências "5000"
     --3º paramentro conta de destino "XXXXXX"
     --4º operação "ADD" adicionar o agendamento ou pode ser FIND buscar a operação cadastrada
