#Migrant Matcher

Autor: Andr� Dias <br />
N�mero Aluno: 55314

Esta aplica��o � uma implementa��o do projeto de Desenvolvimento Centrado em Objetos. 

Execu��o: <br />
Para executar esta aplica��o � necess�rio executar o ficheiro MigrantMatcher.java e usar o ficheiro "configuration.properties". Este ficheiro define-se da maneira seguinte:<br /><br />
->metodoExecucao � como executar o ficheiro e toma 2 valores: <br />* terminal: para ser executado no termial
<br />* tests: � necess�rio executar os ficheiros JUnit de teste, no package tests <br /><br />
->ordemDatasAjudas � como ordenar as ajudas e toma 2 valores:
<br />* Ascendente
<br />* Descendente<br /><br />
O resto de campos s�o definidos para os testes.<br /><br />
Para o primeiro caso de uso, � preciso executar o ficheiro de testes "RegistarAjudaTests.java". Para este ficheiro as configura��es s�o definidas da seguinte maneira:
Nos alojamentos e items h� valores para o objeto esperado e para o objeto atual. Estes podem ser definidos livremente e ter�o impacto nos testes.<br /><br />
Para o segundo caso de uso, � preciso executar o ficheiro de testes "ProcurarAjudaTests.java". Para este ficheiro as configura��es s�o definidas da seguinte maneira:
O NumeroFamiliares pode ter como valores 0, 1, 2 ou 3 e os outros campos do Migrante podem ser definidos livremente. O campo RegiaoAjuda ter� de tomar um valor de uma regi�o v�lida. As regi�es v�lidas est�o definidas pelo Enum "Regiao.java" no package dominio. <br /><br />
A forma ideal de visualizar o programa em a��o e ecxplorar as funcionalidades � executar a partir do terminal, com a configura��o de "terminal" para o campo "metodoExecucao". Assim, ser�o impressas instru��es para usar o programa.