grammar Hello;

main: (greetings | bye)*; // permitir a repetição até ao fim do ficheiro das regras de qualquer uma das regras atrás descritas

greetings : 'hello' name;
bye: 'bye' name;
name : word+; // permitir nomes com mais do que um identificador.
word: ID;

ID : [a-zA-Z]+; // incluir letras maiúsculas
WS: [ \t\r\n]+ -> skip;

