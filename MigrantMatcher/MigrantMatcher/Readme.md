# Migrant Matcher

Autor: André Dias <br />
Número Aluno: 55314

Esta aplicação é uma implementação do projeto de Desenvolvimento Centrado em Objetos. 

Execução: <br />
Para executar esta aplicação é necessário executar o ficheiro MigrantMatcher.java e usar o ficheiro "configuration.properties". Este ficheiro define-se da maneira seguinte:<br /><br />
->metodoExecucao é como executar o ficheiro e toma 2 valores: <br />* terminal: para ser executado no termial
<br />* tests: é necessário executar os ficheiros JUnit de teste, no package tests <br /><br />
->ordemDatasAjudas é como ordenar as ajudas e toma 2 valores:
<br />* Ascendente
<br />* Descendente<br /><br />
O resto de campos são definidos para os testes.<br /><br />
Para o primeiro caso de uso, é preciso executar o ficheiro de testes "RegistarAjudaTests.java". Para este ficheiro as configurações são definidas da seguinte maneira:
Nos alojamentos e items há valores para o objeto esperado e para o objeto atual. Estes podem ser definidos livremente e terão impacto nos testes.<br /><br />
Para o segundo caso de uso, é preciso executar o ficheiro de testes "ProcurarAjudaTests.java". Para este ficheiro as configurações são definidas da seguinte maneira:
O NumeroFamiliares pode ter como valores 0, 1, 2 ou 3 e os outros campos do Migrante podem ser definidos livremente. O campo RegiaoAjuda terá de tomar um valor de uma região válida. As regiões válidas estão definidas pelo Enum "Regiao.java" no package dominio. <br /><br />
A forma ideal de visualizar o programa em ação e ecxplorar as funcionalidades é executar a partir do terminal, com a configuração de "terminal" para o campo "metodoExecucao". Assim, serão impressas instruções para usar o programa.
