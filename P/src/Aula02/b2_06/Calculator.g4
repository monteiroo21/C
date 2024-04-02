grammar Calculator;

program : (stat | assignment)* EOF ; // Zero or more repetitions of stat
stat: expr? NEWLINE ; // Optative expr followed by an end-of-line
assignment: ID '=' expr NEWLINE;

expr: 
    op=('+'|'-') expr                   #ExprUnary
  | expr op=('*'|'/'|'%') expr          #ExprMultDivMod
  | expr op=('+'|'-') expr              #ExprAddSub
  | Integer                             #ExprInteger
  | '(' expr ')'                        #ExprParent
  | ID                                  #ExprID
  ;
  
ID : [A-Za-z_]+;
Integer: [0-9]+; // implement with long integers
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;