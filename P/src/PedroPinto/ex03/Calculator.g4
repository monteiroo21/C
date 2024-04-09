grammar Calculator;

program:
    stat* EOF
  ;
stat:
    expr? NEWLINE
  ;
expr:
    expr op=('*'|'/'|'%') expr      #ExprAddSubMultDivMod
  | expr op=('+'|'-') expr          #ExprAddSubMultDivMod
  | signal=('+'|'-')? Integer       #ExprInteger
  | signal=('+'|'-')? '(' expr ')'  #ExprParent
  ;

Integer: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ \t]+ -> skip;
COMMENT: '#' .*? '\n' -> skip;
