package kreis.aula;


public class ArvoreC {
    private CharNode root;

    private class CharNode {
        char data;
        CharNode left;
        CharNode right;

        CharNode(char value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public void inserir(char value) {
        root = inserirNo(root, value);
    }

    private CharNode inserirNo(CharNode root, char value) {
        if (root == null) {
            return new CharNode(value);
        }

        if (value < root.data) {
            root.left = inserirNo(root.left, value);
        } else if (value > root.data) {
            root.right = inserirNo(root.right, value);
        }

        return root;
    }

    public void remover(char value) {
        root = removerNo(root, value);
    }

    private CharNode removerNo(CharNode root, char value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = removerNo(root.left, value);
        } else if (value > root.data) {
            root.right = removerNo(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = removerNo(root.right, root.data);
        }

        return root;
    }

    private char minValue(CharNode node) {
        char minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public void preOrdem() {
        preOrdemTraversal(root);
    }

    private void preOrdemTraversal(CharNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrdemTraversal(root.left);
            preOrdemTraversal(root.right);
        }
    }

    public void emOrdem() {
        emOrdemTraversal(root);
    }

    private void emOrdemTraversal(CharNode root) {
        if (root != null) {
            emOrdemTraversal(root.left);
            System.out.print(root.data + " ");
            emOrdemTraversal(root.right);
        }
    }

    public void posOrdem() {
        posOrdemTraversal(root);
    }

    private void posOrdemTraversal(CharNode root) {
        if (root != null) {
            posOrdemTraversal(root.left);
            posOrdemTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public int nivelNo(char value) throws Exception {
        return nivelNoRecursivo(root, value, 1);
    }

    private int nivelNoRecursivo(CharNode root, char value, int nivel) throws Exception {
        if (root == null) {
            throw new Exception("Nó não encontrado na árvore.");
        }

        if (value == root.data) {
            return nivel;
        } else if (value < root.data) {
            return nivelNoRecursivo(root.left, value, nivel + 1);
        } else {
            return nivelNoRecursivo(root.right, value, nivel + 1);
        }
    }
}