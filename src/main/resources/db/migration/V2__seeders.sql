INSERT INTO student (id, code, name)  VALUES (nextval('student_seq'), '1A', 'JOAO');
INSERT INTO student (id, code, name)  VALUES (nextval('student_seq'), '2A', 'MARIA');
INSERT INTO student (id, code, name)  VALUES (nextval('student_seq'), '3A', 'DOUGLAS');

INSERT INTO simulated (id, code, created_at) VALUES (nextval('simulated_seq'), '1S', now());

INSERT INTO proof (id, code, simulated_id) VALUES (nextval('proof_seq'), '1P', 1);

INSERT INTO feedback (id, code, proof_id) VALUES (nextval('feedback_seq'), '1F', 1);

INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '1Q', 
'Vamos prender o Saci? Sua missão nesse jogo é prender o Saci, um diabinho de uma perna só que adora fazer bagunça. Ele está sempre com um cachimbo aceso na boca e uma carapuça vermelha na cabeça, que é o que lhe dá força. Quem conseguir pegar a carapuça do Saci transforma o diabinho em seu ajudante. Quando ele vira um rodemoinho, a única maneira de segurá-lo é jogando uma peneira de cruzeta em cima dele. Depois, para aprisioná-lo, é preciso jogar uma garrafa em cima da peneira, e arrolhar bem forte. O Saci também tem medo de água: ele nunca cruza um riacho. Se
colocarem ele numa ilha, pode ficar preso lá o resto da vida. Neste texto, encontram-se instruções sobre como',
null, 'EASY'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 1, 'A', 'armar uma arapuca.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 1, 'B', 'roubar uma carapuça.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 1, 'C', 'prender o Saci.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 1, 'D', 'tornar-se ajudante do Saci.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 1, 'E', 'jogar uma peneira na garrafa');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 1);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 1, 3);


INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '2Q', 
'Este folheto faz parte de uma campanha institucional que tem por finalidade',
'http://portaldoprofessor.mec.gov.br/storage/discovirtual/galerias/imagem/0000000093/md.0000021396.jpg', 'EASY'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 2, 'A', 'informar sobre a qualidade da água.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 2, 'B', 'estimular o consumo de água.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 2, 'C', 'reduzir o consumo de copos descartáveis..');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 2, 'D', 'alertar para a qualidade do ar.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 2, 'E', 'conciliar as pessoas no ambiente de trabalho.');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 2);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 2, 8);


INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '3Q', 
'Para se aproximar do público-alvo, esta campanha utiliza a linguagem oral, que pode
ser identificada em',
'http://portaldoprofessor.mec.gov.br/storage/discovirtual/galerias/imagem/0000000093/md.0000021396.jpg', 'EASY'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 3, 'A', 'adote um copo.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 3, 'B', 'como podemos ajudar?');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 3, 'C', 'use uma caneca própria.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 3, 'D', 'olá, galera.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 3, 'E', 'traga uma garrafinha de água.');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 3);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 3, 14);

INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '4Q', 
'Todos comeram a mesma fração das duas porções de batatas fritas pedidas, mas um
deles, vegetariano, não consumiu nenhuma parte da picanha grelhada, que foi
dividida igualmente entre os outros três. João, que não é vegetariano, consumiu, além
das batatas fritas e da picanha, 1 refrigerante e 1 suco de laranja e, de sobremesa,
pediu um sorvete. Teve de pagar, portanto,',
null, 'MEDIUM'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 4, 'A', 'R$ 43,50.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 4, 'B', 'R$ 41,50.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 4, 'C', 'R$ 39,00.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 4, 'D', 'R$ 37,00.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 4, 'E', ' R$ 18,50.');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 4);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 4, 17);

INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '5Q', 
'Como dizia
aquele bem-te-vi que ficou míope:
“bem te via... bem te via..." O poeta construiu o humor nos versos acima por meio',
null, 'MEDIUM'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 5, 'A', ' da exploração do verbo contido no nome da ave.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 5, 'B', ' da atribuição da fala a um pássaro.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 5, 'C', 'do uso de reticências no último verso.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 5, 'D', 'de uma rima inesperada (dizia com via.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 5, 'E', ' da repetição da palavra “bem-te-vi.');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 5);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 5, 21);


INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '6Q', 
'Para fazer a festa junina da escola, os alunos do Ensino Fundamental foram divididos
em grandes grupos. Cada grupo tinha a missão de arrecadar dinheiro a partir de
doações para comprar o maior número possível de prendas de um determinado tipo
(bolas de plástico, canetas etc.). Um dos grupos conseguiu juntar R$ 211,75 e vai
gastar todo o dinheiro comprando bolas de plástico, cada uma no valor de 27
centavos. Conseguirão comprar, portanto, no máximo,',
null, 'MEDIUM'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 6, 'A', ' 786 bolas.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 6, 'B', ' 785 bolas.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 6, 'C', ' 784 bolas.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 6, 'D',  '783 bolas.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 6, 'E',  '782 bolas.');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 6);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 6, 28);


INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '7Q', 
'No tratamento de piscinas, um dos produtos utilizados é o algicida, cuja função é
eliminar as algas da água. Costuma vir em embalagens de 1 L, 2 L ou 5 L, e deve ser
utilizado na razão de 7 mL do produto para cada metro cúbico de água na piscina. No texto, foram destacadas 3 unidades de medida, sendo',
null, 'MEDIUM'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 7, 'A', ' 1 delas referente a capacidade, 1 referente a massa e 1 referente a comprimento.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 7, 'B', ' 1 delas referente a capacidade e 2 delas referentes a massa.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 7, 'C', ' 2 delas referentes a capacidade e 1 delas referente a massa.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 7, 'D',  'as 3 referentes a capacidade.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 7, 'E',  'as 3 referentes a massa..');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 7);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 7, 33);

INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '8Q', 
'Se duas pequenas esferas de metal idênticas forem carregadas eletricamente, encostadas e depois separadas, as cargas finais de cada uma serão iguais à metade da
soma algébrica das cargas iniciais. Considere as configurações a seguir, em que uc significa unidade de carga.
I. Cargas iniciais de +3 uc e −3 uc.
II. Cargas inicias de +5 uc e −1 uc.
III. Cargas iniciais de −5 uc e +1 uc.
Se realizarmos o experimento descrito com cada uma das configurações, as cargas
finais de cada esfera serão de',
null, 'HARD'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 8, 'A', ' 0 uc em I, +2 uc em II e −2 uc em III.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 8, 'B', ' 0 uc em I, −2 uc em II e +2 uc em III.');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 8, 'C', ' +3 uc em I, +3 uc em II e −3 uc em III');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 8, 'D',  '−3 uc em I, −2 uc em II e −2 uc em III');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 8, 'E',  '−3 uc em I, +2 uc em II e −2 uc em III.');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 8);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 8, 36);


INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '9Q', 
'Na prova de Matemática de uma sala do Ensino Fundamental, pedia-se o valor da
seguinte expressão:
(13 + 7×3) ÷ 2.
Carlos se distraiu na hora da resolução e, apesar de ter acertado a regra dos
parênteses, trocou a ordem das operações indicadas dentro deles. A diferença entre o
valor obtido por ele e o valor correto, nessa ordem, é',
null, 'HARD'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 9, 'A', '  30');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 9, 'B', ' 17');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 9, 'C', '13');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 9, 'D',  '10');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 9, 'E',  '7');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 9);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 9, 43);

INSERT INTO question (id, code, description, image_url, level) VALUES (nextval('question_seq'), '10Q', 
'O humor da tira ocorre porque',
'http://www.monica.com.br/comics/tirinhas/tira21.htm', 'HARD'
);


INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 10, 'A', '  é incomum o Cebolinha pedir ajuda ao Cascão');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 10, 'B', ' Cascão nega, disfarçadamente, ajuda ao Cebolinha');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 10, 'C', 'Cascão oferece uma ajuda diferente da esperada pelo Cebolinha');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 10, 'D',  'ninguém pode vencer a Mônica, nem mesmo o Cascão');
INSERT INTO question_item (id, question_id, option, description) VALUES (nextval('question_item_seq'), 10, 'E',  'Cascão não sabe como poderia ajudar o Cebolinha, então apenas mostra sua
solidariedade');

INSERT INTO proof_question (id, proof_id, question_id) VALUES (nextval('proof_question_seq'), 1, 10);

INSERT INTO feedback_question (id, feedback_id, question_id, correct_question_item_id) VALUES (nextval('feedback_question_seq'), 1, 10, 48);


INSERT INTO student_simulated (id, simulated_id, student_id) VALUES (nextval('student_simulated_seq'), 1, 1);

INSERT INTO student_simulated (id, simulated_id, student_id) VALUES (nextval('student_simulated_seq'), 1, 2);

INSERT INTO student_simulated (id, simulated_id, student_id) VALUES (nextval('student_simulated_seq'), 1, 3);

INSERT INTO student_proof (id, student_id, proof_id) VALUES (nextval('student_proof_seq'), 1, 1);

INSERT INTO student_proof (id, student_id, proof_id) VALUES (nextval('student_proof_seq'), 2, 1);

INSERT INTO student_proof (id, student_id, proof_id) VALUES (nextval('student_proof_seq'), 3, 1);


INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 3, 1, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 8, 2, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 14, 3, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 17, 4, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 21, 5, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 28, 6, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 33, 7, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 36, 8, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 43, 9, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 1, 48, 10, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 3, 1, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 9, 2, false);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 13, 3, false);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 17, 4, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 21, 5, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 28, 6, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 33, 7, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 36, 8, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 42, 9, false);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 2, 48, 10, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 3, 1, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 9, 2, false);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 13, 3, false);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 17, 4, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 21, 5, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 28, 6, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 33, 7, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 36, 8, true);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 42, 9, false);

INSERT INTO proof_answer (id, student_proof_id, question_item_id, question_id, correct) VALUES (nextval('proof_answer_seq'), 3, 48, 10, true);

