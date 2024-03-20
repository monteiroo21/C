grammar Numbers;
file: line* EOF; // o ficheiro tem 0 ou mais linhas
line:
	NUM '-' WORD NL; // cada linha tem a forma NUM - WORD e termina com uma mudança de linha
NUM: [0-9]+;
WORD: [A-Za-z]+;
NL: '\r'? '\n';
WS: [ \t]+ -> skip;