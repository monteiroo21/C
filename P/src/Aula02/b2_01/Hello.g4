grammar Hello;
main : (greetings | bye)*;
greetings : 'hello' name ;
bye : 'bye' name ;
name : word+;
words : ID;
ID : [a-zA-Z]+ ;
WS : [ \t\r\n]+ -> skip ;