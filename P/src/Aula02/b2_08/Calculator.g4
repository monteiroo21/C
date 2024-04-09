grammar Calculator;

program : stat* EOF ; // Zero or more repetitions of stat
stat: NEWLINE               #StatEmpty
    | expr NEWLINE          #StatExpr
    | assignment NEWLINE    #StatAssignment
    ;

assignment: ID '=' expr;

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