
package kreis.aula;

import kreis.aula.*;

public class Main {
    public static void main(String[] args) {

        ArvoreC arvore = new ArvoreC();

        arvore.inserir('k');
        arvore.inserir('d');
        arvore.inserir('m');
        arvore.inserir('b');
        arvore.inserir('f');
        arvore.inserir('i');
        arvore.inserir('t');
        arvore.inserir('c');
        arvore.inserir('p');
        arvore.inserir('z');
        arvore.inserir('r');

        System.out.println("Atravessamento em pré-ordem:");
        arvore.preOrdem();

     
        System.out.println("Atravessamento em ordem:");
        arvore.emOrdem();
        
        System.out.println("Atravessamento em pós-ordem:");
        arvore.posOrdem();
        arvore.remover('m');

        try {
            int nivel = arvore.nivelNo('r');
            System.out.println("Nível do nó 'r' após a remoção: " + nivel);
        } catch (Exception e) {
            System.out.println("Nó 'r' não encontrado na árvore.");
        }
    }
}