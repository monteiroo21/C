2a)
antlr4-build
echo "2 3 +" | antlr4-test -gui

2b)
antlr4-clean
antlr4-visitor SuffixCalculator Execute Double (agora fazemos Double em vez de String porque são números)
antlr4-main SuffixCalculator program -v Execute
antlr4-build
cat exemplo_1.txt | antlr4-run

Nota: para funcionar corretamente é necessário "editar" "Execute.java"
Nota: na implementaçao com um visitor em ANTLR não é
necessario aplicar o algoritmo descrito no exercicio 1.03 (que recorre a um stack ). Ver "aula1_ex3_suffixCalculator_STACK.java"

Nota:
Não tem sido normal alterarmos o oficheiro ..Main.java.
Neste caso o Prof. adicionou linhas nesse ficheiro,
pois se o nosso ficheiro "exemplo_1.txt" tivesse linhas vazias
e fizessemos "cat exemplo_1.txt | antlr4-run" tinhamos uma exceção.

Outra alternativa é usando Iterator em Execute.java nos métodos Double visitProgram e Double visitStat()
como eu fiz.
