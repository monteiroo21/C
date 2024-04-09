grammar StoreNumbers;

program: 
        stat* EOF
    ;

stat:   
        line NEWLINE
    ;

line:
        Number '-' Name
    ;

Name: [a-zA-Z]+;
Number: [0-9]+;

NEWLINE: '\r'? '\n';    
WS: [ \t]+ -> skip;