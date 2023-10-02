package binarysearchtree;

public class BinarySearchTree<T> {

    private BSTNode<T> root;

    private static class BSTNode<T> {
        private T data;

        public BSTNode(T data) {
            this.data = data;
        }
    }

    public BinarySearchTree(T... elems) {
        for (T elem : elems) {
            
        }
    }
}
