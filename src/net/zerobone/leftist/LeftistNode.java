package net.zerobone.leftist;

public class LeftistNode<T extends Comparable<T>> {

    public T element;

    private int rank;

    public LeftistNode<T> left;

    public LeftistNode<T> right;

    public LeftistNode(T element) {
        this.element = element;
        rank = 1;
        this.left = null;
        this.right = null;
    }

    public LeftistNode(LeftistNode<T> left, T element, LeftistNode<T> right) {

        this.element = element;

        int leftRank = rankOf(left);
        int rightRank = rankOf(right);

        rank = 1 + Math.min(leftRank, rightRank);

        if (leftRank >= rightRank) {
            this.left = left;
            this.right = right;
        }
        else {
            this.left = right;
            this.right = left;
        }

    }

    public int rankOf(LeftistNode<T> node) {

        if (node == null) {
            return 0;
        }

        return node.getRank();

    }

    public int getRank() {
        return rank;
    }

}