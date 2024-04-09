grammar FractionsCalculator;

program: stat* EOF;    

stat: (print | assignment | expr) ';';

print: 'print' expr;

assignment: expr '->' ID;

expr:
    expr op=('*'|':') expr          #ExprAddSubMultDivMod
  | expr op=('+'|'-') expr          #ExprAddSubMultDivMod
  | signal=('+'|'-')? '(' expr ')'  #ExprParent
  | '(' expr ')' '^' num            #ExprExp
  | num '/' Integer                 #ExprDiv
  | num                             #ExprInteger
  | signal=('+'|'-')? ID            #ExprID
  | 'read' Sentence                 #ExprRead 
  | 'reduce' expr                   #ExprReduce     
  ;

num: signal=('+'|'-')? Integer;  

Sentence: '"' (ESC | .)*? '"';
fragment ESC: '\\"' | '\\\\';

ID: LETTER (LETTER | DIGIT)*;
fragment LETTER: [a-zA-Z_];
fragment DIGIT: [0-9];

Integer: DIGIT+;

WS: [ \t\n\r]+ -> skip;
LINE_COMMENT: '//' .*? '\n' -> skip;
COMMENT: '/*' .*? '*/' -> skip;