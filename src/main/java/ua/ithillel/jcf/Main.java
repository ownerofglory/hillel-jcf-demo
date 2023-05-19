package ua.ithillel.jcf;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // FIXME: empty list
        // head -> NULL
        // FIXME: add 20 to begin
        // head -> (20) -> NULL
        // FIXME: add 13 to begin
        // (13) -> (20) -> NULL
        //        /
        //    head
        // FIXME: fix head to reference newly added element
        // head -> (13) -> (20) -> NULL

        // FIXME: add 5 to begin
        // (5) -> (13) -> (20) -> NULL
        //   head /

        // FIXME: fix head to reference newly added element
        // (5) -> (13) -> (20) -> NULL
        //  |
        //   head


        // FIXME: existing list
        // head -> 3 -> 5 -> 8 -> 1 -> NULL
        // FIXME: add 34 to the end
        // head -> 3 -> 5 -> 8 -> 1 -> 34 -> NULL

        // FIXME: difference between abstract data structure and implementation
        List<String> strList = new ArrayList<>();
        List<String> strList1 = new LinkedList<>();

        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();



        // FIXME: custom demo implementation of Sigly Linked List
//        MySinglyLinkedList<Integer> myLinkedIntList = new MySinglyLinkedList<>();
//        myLinkedIntList.add(455);
//        myLinkedIntList.add(2);
//        myLinkedIntList.add(8);
//        myLinkedIntList.add(34);
//        myLinkedIntList.add(42);
//        myLinkedIntList.add(21);
//        myLinkedIntList.add(5);
//        myLinkedIntList.addToEnd(4);
//
//        for (Integer i :
//                myLinkedIntList) {
//            System.out.printf("%d ", i);
//        }




        // FIXME: LinkedList demo
//        List<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1); // (1)-> * NULL
//        linkedList.add(3); // (1)-> (3) -> * NULL
//        linkedList.add(30); // (1)-> (3) -> (30) -> * NULL
//        linkedList.add(2); // (1)-> (3) -> (30) -> (2) -> * NULL
//
//        linkedList.set(2, 18);


        // NODE

        // FIXME: custom demo implementation of an Array List
//        MyList<Integer> intList = new MyArrayList<>();
//
//        intList.add(3);
//        intList.add(4);
//        intList.add(1);
//        intList.add(1);
//        intList.add(7);
//        intList.add(9);
//
//        intList.add(3);
//        intList.add(4);
//        intList.add(1);
//        intList.add(1);
//        intList.add(7);
//        intList.add(9);
//        intList.add(3);
//        intList.add(4);
//        intList.add(1);
//        intList.add(1);
//        intList.add(7);
//        intList.add(9);
//
//        for (Integer i: intList) {
//            System.out.printf("%d ", i);
//        }
//
//        System.out.println(intList);

        // FIXME: ArrayList Demo
//        List<String> list = new ArrayList<>(); //diamond
//        list.add("Hello");
//        list.add("Hillel");
//        list.add("World");
//
//        list.addAll(List.of("1", "2"));
//
//        ArrayList<String> objects = new ArrayList<>();
//        objects.addAll(list);
//
//
//        String o = list.get(0);
//        String s = list.get(2);
//
//        list.size();
//
//        list.remove("Hello");
//        list.remove(1);
//        System.out.println(o);

        // FIXME: arrays of arrays a.k.a. multi-dimensional arrays

//        int[][] intEmptyMatrix = {};
//        int[][] intMatrix = new int[10][10];
//
//        int[][] twoDimensionalArray = new int[5][];
//        twoDimensionalArray[0] = new int[] {1, 2, 3};
//        twoDimensionalArray[3] = new int[8];
//        twoDimensionalArray[4] = new int[]{};
//
//        String[][][] threeDimensmatrix = {};


        // FIXME: arrays demo
//        int[] intEmptyArray = {};
//        int[] intArray = new int[] {3, 45, 78, 9, 34};
//
//        System.out.println(intArray[3]);
//        int length = intArray.length;
//        int idx = 0;
//
//        if (idx < intArray.length) {
//            int i = intArray[idx];
//        }
//
//        int[] intArrayDefaultValue = new int[12];
    }
}
