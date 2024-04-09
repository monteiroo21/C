grammar Calculator;

program:
    stat* EOF
  ;
stat:
    (expr | assignment)? NEWLINE
  ;
assignment: ID '=' expr;  
expr:
    expr op=('*'|'/'|'%') expr      #ExprAddSubMultDivMod
  | expr op=('+'|'-') expr          #ExprAddSubMultDivMod
  | signal=('+'|'-')? ID            #ExprID
  | signal=('+'|'-')? Integer       #ExprInteger
  | signal=('+'|'-')? '(' expr ')'  #ExprParent
  ;

ID: [a-zA-Z_]+;
Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
