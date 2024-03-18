grammar Calculator;

program : stat* EOF ; // Zero or more repetitions of stat
stat: expr? NEWLINE ; // Optative expr followed by an end-of-line

expr: 
    op=('+'|'-') expr                   #ExprUnary
  | expr op=('*'|'/'|'%') expr          #ExprMultDivMod
  | expr op=('+'|'-') expr              #ExprAddSub
  | Integer                             #ExprInteger
  | '(' expr ')'                        #ExprParent
  ;
  
Integer: [0-9]+; // implement with long integers
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;