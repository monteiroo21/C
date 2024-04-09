grammar Hello ;

// symbol sintatic
main: stat* EOF;
stat: greetings | bye | hi;
greetings : 'hello' name;    // match keyword hello followed by an identifier
bye: 'bye' name;
hi: 'hi' name;
name: word+;
word : ID;

// symbol lexical
ID : [a-zA-Z]+ ;               // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ;   // skip spaces, tabs, newlines, \r (Windows)
