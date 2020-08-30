package net.zerobone.leftist;

public class Main {

    public static void main(String[] args) {

        Leftist<Integer> l = new Leftist<>();

        for (int i = 10; i <= 100; i++) {
            l.insert(i);
        }

        System.out.println(l.deleteMin());
        System.out.println(l.deleteMin());

    }

}