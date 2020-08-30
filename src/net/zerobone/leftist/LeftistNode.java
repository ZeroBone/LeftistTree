package net.zerobone.leftist;

public class LeftistNode<T extends Comparable<T>> {

    public T element;

    public LeftistNode<T> left;

    public LeftistNode<T> right;

    public LeftistNode(T element) {
        this.element = element;
    }

    public LeftistNode(LeftistNode<T> left, T element, LeftistNode<T> right) {

        this.element = element;

        if (rankOf(left) >= rankOf(right)) {
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

        return node.rank();

    }

    public int rank() {

        int leftRank = left == null ? 0 : left.rank();

        int rightRank = right == null ? 0 : right.rank();

        assert leftRank >= rightRank;

        return Math.min(leftRank, rightRank) + 1;

    }

}