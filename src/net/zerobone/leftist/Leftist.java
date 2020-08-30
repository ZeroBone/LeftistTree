package net.zerobone.leftist;

public class Leftist<T extends Comparable<T>> {

    private LeftistNode<T> root;

    public Leftist() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T element) {

        LeftistNode<T> node = new LeftistNode<T>(element);

        root = mergeWith(root, node);

    }

    public void merge(Leftist<T> q) {

        root = mergeWith(root, q.root);

    }

    public T getMin() {

        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return root.element;

    }

    public T deleteMin() {

        if (isEmpty()) {
            throw new IllegalStateException();
        }

        T min = root.element;

        root = mergeWith(root.left, root.right);

        return min;

    }

    private LeftistNode<T> mergeWith(LeftistNode<T> h, LeftistNode<T> k) {

        if (h == null) {
            return k;
        }

        if (k == null) {
            return h;
        }

        LeftistNode<T> t = h.left;
        T a = h.element;
        LeftistNode<T> u = h.right;

        LeftistNode<T> v = k.left;
        T b = k.element;
        LeftistNode<T> w = k.right;

        if (a.compareTo(b) <= 0) {
            return new LeftistNode<T>(t, a, mergeWith(u, k));
        }
        else {
            return new LeftistNode<T>(v, b, mergeWith(h, w));
        }

    }

}