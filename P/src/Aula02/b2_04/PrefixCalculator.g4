grammar PrefixCalculator;
program:
    stat* EOF       // zero or more repetitions of stat
  ;
stat:
    expr? NEWLINE   // optative expr followed by an end-of-line
  ;
expr:
    op=('*'|'/'|'+'|'-') expr expr  #ExprPrefix
  | Number                          #ExprNumber
  ;
Number: [0-9]+('.'[0-9]+)?; // fixed point real Number
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;