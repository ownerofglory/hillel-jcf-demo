package ua.ithillel.jcf;

import ua.ithillel.jcf.map.MyHashMap;
import ua.ithillel.jcf.map.MyMap;
import ua.ithillel.jcf.map.MyTreeMap;
import ua.ithillel.jcf.model.Employee;
import ua.ithillel.jcf.model.Human;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // FIXME: using comparator example
//        Map<Person, Integer> map = new TreeMap<>((o1, o2)
//                -> o1.getName().compareTo(o2.getName()));
//        map.put(new Person(), 15);

//        Comparator<Human> humanAgeComparator = (o1, o2) -> {
//            return o2.getAge() - o1.getAge();
//        };


        // FIXME: own tree map implementation
//        MyMap<Integer, String> myMap = new MyTreeMap<>();
//        myMap.put(13, "Hello");
//        myMap.put(8, "World");
//        myMap.put(17, "Hillel");
//        myMap.put(11, "Hi");
//
//        String s1 = myMap.get(8);
//        String s2 = myMap.get(11);
//        String s3 = myMap.get(17);
//
//        myMap.remove(13);
//
//        System.out.println();

        // FIXME: own hash map implementation
//        MyMap<String, Integer> cityPopulation = new MyHashMap<>();
//
//        //
//        cityPopulation.put("New York", 18_937_000);
//        cityPopulation.put("Miami", 6_265_000);
//        cityPopulation.put("Kyiv", 3_000_000);
//        cityPopulation.put("Atlanta", 6_000_000);
//        cityPopulation.put("Philadelphia", 5_800_000);
//        cityPopulation.put("Mumbai", 21_000_000);
//        cityPopulation.put("Lagos", 16_000_000);
//
//        cityPopulation.put("Tianjin", 14_000_000);
//        cityPopulation.put("San Antonio", 2_000_000);
//        cityPopulation.put("Baltimore", 2_000_000);
//        cityPopulation.put("Austin", 2_000_000);
//
//        cityPopulation.put(null, 34545);
//        Integer integer = cityPopulation.get(null);
//
//        Integer kyiv = cityPopulation.get("Kyiv");
//        Integer mumbai = cityPopulation.get("Mumbai");
//
//        System.out.println(cityPopulation);

        // FIXME: Maps demo
//        Map<String, Integer> cityPopulation = new HashMap<>();
//
//        cityPopulation.put("New York", 18_937_000);
//        cityPopulation.put("Miami", 6_265_000);
//        cityPopulation.put("Kyiv", 3_000_000);
//
//        Integer kyivPopulation = cityPopulation.get("Kyiv");
//
//        System.out.println(cityPopulation);
//        System.out.println("Kyiv:" + kyivPopulation);
//
//        cityPopulation.remove("Miami");
//
//        System.out.println(cityPopulation);
//
//        cityPopulation.put("Kyiv", 3_100_000);
//
//        System.out.println(cityPopulation);


        // FIXME: method equals example
        // maps in the  app
        // mobile apps

        // reflective

        // transitive
        // x.equals(y) y.equals(z) => x.equals(z)

        //symmetry

//        Human ivan = new Employee("Ivan", 28, "Developer");
//        Human ivan1 = new Human("Ivan", 28);
//
//        boolean equals = ivan1.equals(ivan);
//        boolean equals1 = ivan.equals(ivan1);
//
//
//        List<Human> people = new ArrayList<>();
//        Human john = new Human("John", 34);
//        Human jane = new Human("Jane", 34);
//
//        john.equals(john);
//
//
//        people.add(john);
//        people.add(jane);
//        people.add(new Human("Alice", 28));
//        people.add(new Human("Bob", 50));
//
//        System.out.println(people);
//
//        boolean johnExists = people.contains(new Human("John", 34));
//        System.out.println("John exists: " + johnExists);

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
