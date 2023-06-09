package ua.ithillel.jcf;

import ua.ithillel.jcf.algo.ArithmeticUtils;
import ua.ithillel.jcf.algo.SearchUtils;
import ua.ithillel.jcf.algo.SortUtils;
import ua.ithillel.jcf.algo.StringCustomUtils;
import ua.ithillel.jcf.comparator.GpaComparator;
import ua.ithillel.jcf.function.ClickActionListener;
import ua.ithillel.jcf.function.MyFunctionImpl;
import ua.ithillel.jcf.function.MyInterface;
import ua.ithillel.jcf.generic.Container;
import ua.ithillel.jcf.generic.ContainerUtil;
import ua.ithillel.jcf.graph.GraphUtil;
import ua.ithillel.jcf.map.MyHashMap;
import ua.ithillel.jcf.map.MyMap;
import ua.ithillel.jcf.map.MyTreeMap;
import ua.ithillel.jcf.model.Employee;
import ua.ithillel.jcf.model.Human;
import ua.ithillel.jcf.model.Student;
import ua.ithillel.jcf.tree.BinarySearchTree;
import ua.ithillel.jcf.tree.SearchTree;
import ua.ithillel.jcf.tree.TreeNode;
import ua.ithillel.jcf.tree.TreeUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void processList(List<String> list) {
        for (String s :
                list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        // C# LINQ
        Stream<Integer> unendlessStream = Stream.generate(() -> (int) (Math.random() * 1000));

        List<Integer> collect = unendlessStream.limit(100)
                .filter(i -> i > 100)
                .collect(Collectors.toList());

        Stream<Integer> emptyStream = Stream.empty();

        Stream<Integer> concat = Stream.concat(emptyStream, unendlessStream);

        Stream<Integer> integerStream = Stream.of(1, 30, -3, -45, -35, 56, 0, 5);

        // int sum = 0;
        // sum += i;

        Optional<Integer> sumOptional = integerStream.filter(i -> i < 0)
                .map(i -> Math.abs(i))
                .reduce((i, acc) -> acc + i);

        if (sumOptional.isPresent()) {
            Integer sum = sumOptional.get();
            System.out.println("Sum of abs values of numbers < 0: " + sum);
        }

//        List<String> strings = integerStream.filter(i -> i > 0)
//                .peek(i -> System.out.println("Greater than 0: " + i))
//                .map(i -> i * 2)
//                .peek(i -> System.out.println("multiplied by 2 : " + i))
//                .filter(i -> i < 50)
//                .peek(i -> System.out.println("Less than 50: " + i))
//                .map(i -> "int: " + i)
//                .collect(Collectors.toList());


        Student vasyl = new Student("Vasyl", 21, 75);
        Student anna = new Student("Anna", 22, 89);
        Student petro = new Student("Petro", 35, 87);
        Student ivan = new Student("Ivan", 48, 72);
        Student olha = new Student("Olha", 31, 90);
        Student maxim = new Student("Maxim", 37, 91);

        List<Student> studentList = List.of(vasyl, anna, petro, ivan, olha, maxim);

        Stream<Student> studentStream = studentList.stream();
        List<String> students = studentStream.filter(student -> student.getAge() > 25)
                .filter(student -> student.getGpa() > 70)
                .filter(student -> student.getName().length() > 4)
                .map(student -> student.getName())
                .collect(Collectors.toList());

        Map<String, Integer> studentMap = studentList.stream()
                .filter(student -> student.getAge() > 25)
                .filter(student -> student.getGpa() > 70)
                .filter(student -> student.getName().length() > 4)
                .collect(Collectors.toMap(student -> student.getName(), student -> student.getGpa()));

        long count = studentList.stream()
                .filter(student -> student.getGpa() > 70)
                .count();

        Optional<Student> minOptional = studentList.stream()
                .filter(student -> student.getGpa() > 70)
                .min((s1, s2) -> s1.getAge() - s2.getAge());

        if (minOptional.isPresent()) {
            Student student = minOptional.get();
            System.out.println("Youngest student with GPA > 70:" + student);
        }

        System.out.println("Amount of stundets with GPA > 70: " + count);

        Optional<Student> minByAgeAlphabetic = studentList.stream()
                .filter(student -> student.getAge() > 60)
                .min((s1, s2) -> s1.getName().compareTo(s2.getName()));

//        if (minByAgeAlphabetic.isPresent()) {
//            Student student = minByAgeAlphabetic.get();
//            System.out.println("Older than 60 y.o. first by alphabet: " + student);
//        } else {
//            System.out.println(studentList.get(0));
//        }

        Student student2 = minByAgeAlphabetic.orElse(studentList.get(0));

        Student student3 = minByAgeAlphabetic.orElseGet(() -> new Student());

//        Student student4 = minByAgeAlphabetic.orElseThrow();

        Integer sumOfGpa = studentList.stream()
                .filter(student -> student.getGpa() > 75)
                .reduce(0, (acc, student)
                        -> acc + student.getGpa(), (acc, val) -> acc + val);

        System.out.println("Sim of GPA of students with GPA > 75: "+ sumOfGpa);


        try {
            Student student5 = minByAgeAlphabetic.orElseThrow(() -> new Exception());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        Supplier<Student> randomStudentGenerator = () -> {
            Random random = new Random();
            int i = random.nextInt();
            String name = "Student" + i;
            int age = Math.abs(i);
            return new Student(name, age);
        };

//        Supplier<Student> emptyStudentGenerator = () -> new Student();
        Supplier<Student> emptyStudentGenerator = Student::new;

        Student student1 = emptyStudentGenerator.get();

        System.out.println(randomStudentGenerator.get());
        System.out.println(randomStudentGenerator.get());
        System.out.println(randomStudentGenerator.get());
        System.out.println(randomStudentGenerator.get());

//        java.util.function.Consumer<Student> studentPrinter = s -> System.out.println(s);
        java.util.function.Consumer<Student> studentPrinter = System.out::println;

        studentPrinter.accept(vasyl);
        studentPrinter.accept(olha);
        studentPrinter.accept(maxim);

        Predicate<Student> agePredicate = student -> student.getAge() > 25;

        List<Student> olderThanTwentyFive =
                getMajorStudents(agePredicate,
                        vasyl, anna, petro, ivan, olha, maxim);

        System.out.println("Older than 25:" +  olderThanTwentyFive);

        System.out.println(getMajorStudents(student -> student.getAge() > 35,
                vasyl, anna, petro, ivan, olha, maxim));

        Function<Student, String> studentNameConverter = student -> {
            String name = student.getName();
            return name.toLowerCase();
        };

        System.out.println(studentNameConverter.apply(vasyl));
        System.out.println(studentNameConverter.apply(anna));


        Function<String, Integer> stringLengthFunc = s -> s.length(); // creaing

        System.out.println(stringLengthFunc.apply("Hello"));
        System.out.println(stringLengthFunc.apply("Hillel"));




        Comparator<Integer> integerComparator = (o1, o2) -> o1 - o2;



        JFrame jFrame = new JFrame();
        jFrame.setSize(100, 100);

        JPanel jPanel = new JPanel();
        JButton clickMe = new JButton("Click me");

//        ActionListener clickListener = e -> System.out.println("Lambda: button clicked");

        clickMe.addActionListener(System.out::println);

        jPanel.add(clickMe);
        jFrame.add(jPanel);

        jFrame.setVisible(true);




        MyInterface myInterface = new MyFunctionImpl();
        myInterface.doSomethingElse();

        MyInterface.printSomething();



        // FIXME: generics demo

//        Container<? super Integer> someNumContainer = new Container<>(10.3);
//        someNumContainer = new Container<>(1);
//        someNumContainer = new Container<>(new Object());
//
//        Object value1 = someNumContainer.getValue();
//        someNumContainer.setValue(1);
//
//
//        Container<String> hello = ContainerUtil.createContainer("Hello");
//
//        var emptyContainer = ContainerUtil.<Student>createEmptyContainer();
//
//
//        Container rawContainer = new Container(1);
//
//        Container<Object> objectContainer = new Container<>(new Object());
//        Container<Number> numberContainer = new Container<>(30);
//        Container<Integer> intContainer = new Container<>(23);
//
//
//        numberContainer.compare(intContainer);
//
//        rawContainer = intContainer;
//        rawContainer = objectContainer;
//
//
//        Container<String> stringContainer = new Container<>("Hello");
//        Container<Student> studentContainer = new Container<>(new Student("John", 35));
//        Container<Integer> integerContainer = new Container<>(34);
//
//        Container<int[]> container = new Container<>(new int[5]);
//
//        System.out.println(stringContainer instanceof Container);
//        System.out.println(studentContainer instanceof Container);
//        System.out.println(integerContainer instanceof Container);
//
//        // auto boxing
//        Integer objInt = 1; // Integer.valueOf(1);
//        Number aNumber = objInt;
//
//        // aith unboxing
//
//        int primitiveInt = objInt; // objInt.intValue();
//
//
//        // check underlying type
//        String value = stringContainer.getValue();
//
//        Student student = studentContainer.getValue();
//
//
//        List<String> list = new ArrayList<>(); //diamond syntax
//        list.add("Hello");
//        list.add("Hillel");
//        list.add("Java");
//
//
//        processList(list);


        // FIXME: undirected graph / edge list demo

//        Integer[][] edgeList = new Integer[][] {
//                {0, 1}, {1, 2}, {1, 4}, {2, 5}, {4, 5}, {4, 3}, {5, 8}, {5, 6}, {6, 7}
//        };
//
//
//        Map<Integer, List<Integer>> intGraph = GraphUtil.edgeListToAdjacency(edgeList);
//        System.out.println("From 0" + GraphUtil.depthFirstTraverse(intGraph, 0));
//        System.out.println("From 5" + GraphUtil.depthFirstTraverse(intGraph, 5));
//        System.out.println("From 3" + GraphUtil.depthFirstTraverse(intGraph, 3));
//
//        System.out.println("From 0" + GraphUtil.breadthFirstTraverse(intGraph, 0));
//        System.out.println("From 5" + GraphUtil.breadthFirstTraverse(intGraph, 5));
//        System.out.println("From 3" + GraphUtil.breadthFirstTraverse(intGraph, 3));

        // FIXME: directed graph / adjacency list demo
//        Map<String, List<String>> graph = new HashMap<>();
//        graph.put("A", List.of("B", "D", "E"));
//        graph.put("B", List.of("C", "D"));
//        graph.put("C", List.of());
//        graph.put("D", List.of("C", "E", "A"));
//        graph.put("E", List.of());
//
//        System.out.println("Start from A: " + GraphUtil.depthFirstTraverse(graph, "A"));
//        System.out.println("Start from B: " + GraphUtil.depthFirstTraverse(graph, "B"));
//        System.out.println("Start from C: " + GraphUtil.depthFirstTraverse(graph, "C"));
//        System.out.println("Start from D: " + GraphUtil.depthFirstTraverse(graph, "D"));
//
//        System.out.println("Start from A: " + GraphUtil.breadthFirstTraverse(graph, "A"));
//        System.out.println("Start from B: " + GraphUtil.breadthFirstTraverse(graph, "B"));
//        System.out.println("Start from C: " + GraphUtil.breadthFirstTraverse(graph, "C"));
//        System.out.println("Start from D: " + GraphUtil.breadthFirstTraverse(graph, "D"));
//
//        System.out.println("From A to C: " + GraphUtil.hasPath(graph, "A", "C"));
//        System.out.println("From A to D: " + GraphUtil.hasPath(graph, "A", "D"));
//        System.out.println("From C to A: " + GraphUtil.hasPath(graph, "C", "A"));

        // FIXME: binary search tree example
//        SearchTree<Integer> searchTree = new BinarySearchTree<>();
//
//        int[] ints = new int[] {1, 2, 4, 6, 8, 10, 23, 25, 28};
//        for (int in :
//                ints) {
//            searchTree.insert(in);
//        }


//        searchTree.insert(4);
//        searchTree.insert(2);
//        searchTree.insert(1);
//        searchTree.insert(6);
//        searchTree.insert(5);
//        searchTree.insert(3);
//        searchTree.insert(7);
//
//        System.out.println("4 exists: " + searchTree.search(4));
//        System.out.println("3 exists: " + searchTree.search(3));
//        System.out.println("10 exists: " + searchTree.search(10));
//
//        searchTree.delete(3);
//        searchTree.delete(4);
//
//        System.out.println("4 exists: " + searchTree.search(4));
//        System.out.println("3 exists: " + searchTree.search(3));
//        System.out.println("10 exists: " + searchTree.search(10));
//
//
//        for (Integer i :
//                searchTree) {
//            System.out.printf("%d ", i);
//        }
//
//        System.out.println();


        // FIXME: simple tree example
//        TreeNode<String> aRoot = new TreeNode<>("A");
//        TreeNode<String> b = new TreeNode<>("B");
//        TreeNode<String> c = new TreeNode<>("C");
//        TreeNode<String> d = new TreeNode<>("D");
//        TreeNode<String> e = new TreeNode<>("E");
//        TreeNode<String> f = new TreeNode<>("F");
//
//        aRoot.setLeft(b);
//        aRoot.setRight(c);
//
//        b.setLeft(d);
//
//        c.setLeft(e);
//        c.setRight(f);
//
//        List<String> depthFirst = TreeUtil.depthFirst(aRoot);
//        System.out.println("Tree Depth first: "+ depthFirst);
//        System.out.println("Tree Depth first recursive: "+ TreeUtil.depthFirstRecurse(aRoot));
//
//        List<String> breadthFirst = TreeUtil.breadthFirst(aRoot);
//
//        System.out.println("Breadth first tree: " + breadthFirst);
//
//        System.out.println("Using iterator");
//        for (String s: aRoot) {
//            System.out.printf("%s ", s);
//        }
//        System.out.println();
//
//        Iterator<String> iterator = aRoot.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            System.out.printf("%s ", next);
//        }
//
//        System.out.println("B exists" + TreeUtil.depthFirstSearch(aRoot, "B"));
//        System.out.println("X exists" + TreeUtil.depthFirstSearch(aRoot, "X"));
//        System.out.println("B exists" + TreeUtil.breadthFirstSearch(aRoot, "B"));
//        System.out.println("X exists" + TreeUtil.breadthFirstSearch(aRoot, "X"));
//
//        System.out.println("C Subtree: " + TreeUtil.breadthFirst(c));

//        System.out.printf("Person with name %s, age: %d, salary %f", "John", 35, 3500.00);


        System.out.println();


        // FIXME: merge sort example
//        Student vasyl = new Student("Vasyl", 21, 75);
//        Student anna = new Student("Anna", 22, 89);
//        Student petro = new Student("Petro", 35, 87);
//        Student ivan = new Student("Ivan", 48, 72);
//        Student olha = new Student("Olha", 31, 90);
//        Student maxim = new Student("Maxim", 37, 91);
//
//        Student[] students = new Student[] {
//                vasyl, anna, petro, ivan, olha, maxim
//        };
////        SortUtils.bubbleSort(students);
//        SortUtils.mergeSort(students, 0, students.length - 1);
//        System.out.println("Sorted students " + Arrays.toString(students));

//        int[] unsortedArr = new int[] {3, 45, 2, 6, 0, -2, 8, 13};
//        SortUtils.mergeSortInt(unsortedArr, 0, unsortedArr.length - 1);
//        System.out.println("Merge sort: " + Arrays.toString(unsortedArr));

        // FIXME: bubble sort example
//        SortUtils.bubbleSortInt(unsortedArr);
//        System.out.println(Arrays.toString(unsortedArr));


        // FIXME: binary search example

//        String[] strArr = new String[]{ "A", "B", "D", "M", "N", "P", "X"  };
//
//        System.out.println("Binary Search string: "
//                + SearchUtils.binarySearch(strArr, "D", 0, strArr.length));
//
//        int[] intArrSorted = new int[] {1, 4, 6, 9, 12, 34, 45, 47, 49};
//        System.out.println("Binary Search: " +
//                SearchUtils.binarySearchInt(intArrSorted, 34, 0, intArrSorted.length));

        // FIXME: linear search example

//        int[] intArr = {1, 4, 5, 6, 24, 9, -1};
//        Integer[] integers = {1, 4, 5, 6, 24, 9, -1};



//        System.out.println("Linear search:"
//                +  SearchUtils.linearSearchInt(intArr, 5));
//        System.out.println("Linear search:"
//                +  SearchUtils.linearSearch(integers, 5));
//
//        System.out.println("Students: " + Arrays.toString(students));
//        System.out.println("Students search: " + SearchUtils.linearSearch(students, petro));
//
//        System.out.println(StringCustomUtils.reverse("Hello!"));


        // FIXME: max and min generic recursive example

//        System.out.println("Max student: "
//                + ArithmeticUtils.max(vasyl, anna, petro, ivan, olha, maxim));
//        Comparator<Student> ageComparator = (s1, s2) -> s1.getAge() - s2.getAge();
//
//        System.out.println("Oldest student: "
//                + ArithmeticUtils.max(ageComparator, vasyl, anna, petro, ivan, olha, maxim));


        // FIXME: max and min recursive example

//        System.out.println("max " + ArithmeticUtils.maxInt(3, 1, 67, 48, 9, -1, -23));
//        System.out.println("min " + ArithmeticUtils.minInt(3, 1, 67, 48, 9, -1, -23));

        // FIXME: factorial recursive example

//        System.out.println("0! = " + ArithmeticUtils.factorial(0));
//        System.out.println("1! = " + ArithmeticUtils.factorial(1));
//        System.out.println("2! = " + ArithmeticUtils.factorial(2));
//        System.out.println("3! = " + ArithmeticUtils.factorial(3));
//        System.out.println("4! = " + ArithmeticUtils.factorial(4));

        // 0! = 1
        // 1! = 1 = 1 * 0!
        // 2! = 1 * 2 = 2 * 1!
        // 3! = 1 * 2 * 3 = 6 = 3 * 2!
        // 4! = 1 * 3 * 3 * 4 = 24 = 4 * 3!

        // n! = 1 * 2 * ... * n - 1 * n

        // FIXME: PriorityQueue Demo

//        Student vasyl = new Student("Vasyl", 21, 75);
//        Student anna = new Student("Anna", 22, 89);
//        Student petro = new Student("Petro", 35, 87);
//        Student ivan = new Student("Ivan", 48, 72);
//        Student olha = new Student("Olha", 31, 90);
//        Student maxim = new Student("Maxim", 37, 91);

        Comparator<Student> gpaComparator = (s1, s2) ->  s2.getGpa() - s1.getGpa();
//        Comparator<Student> gpaComparator = new GpaComparator();
//        Comparator<Student> gpaComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getGpa() - o1.getGpa();
//            }
//        };

//       PriorityQueue<Student> gradedStudents = new PriorityQueue<>(gpaComparator);
//
//
//
//        gradedStudents.add(vasyl);
//        gradedStudents.add(anna);
//        gradedStudents.add(petro);
//        gradedStudents.add(ivan);
//        gradedStudents.add(olha);
//        gradedStudents.add(maxim);
//
//        gradedStudents.removeIf(student -> student.getGpa() > 75);
//
//        System.out.println("Graded students: " + gradedStudents);


        // FIXME: Deque demo
        // deck - deque - double ended queue
//        Deque<Student> deque = new LinkedList<>();
//
//        deque.add(vasyl);
//        deque.add(anna);
//        deque.addLast(petro);
//        deque.add(olha);
//        deque.add(maxim);
//        deque.addFirst(ivan);
//
//        System.out.println("Deque: " +  deque);
//
        // FIXME: Queues demo
//
//        Queue<Student> cafeQueue = new LinkedList<>();
//
//        cafeQueue.add(vasyl);
//        cafeQueue.add(anna);
//        cafeQueue.add(petro);
//        cafeQueue.add(ivan);
//        cafeQueue.add(olha);
//        cafeQueue.add(maxim);
//
//        System.out.println("Queue: " + cafeQueue);
//        while (!cafeQueue.isEmpty()) {
//            Student peek = cafeQueue.peek(); // nullable
//            Student element = cafeQueue.element(); // throwable
//            Student first = cafeQueue.remove(); // throwable
//            System.out.printf("Student %s%n", first);
//        }
//
//        Student student = cafeQueue.poll(); // nullable


        // FIXME: Sets demo
//        Comparator<Student> ageComparator = (s1, s2) -> s1.getAge() - s2.getAge();
//        SortedSet<Student> students = new TreeSet<>(ageComparator);
//
//        Student vasyl = new Student("Vasyl", 21);
//        Student anna = new Student("Anna", 22);
//        Student petro = new Student("Petro", 35);
//        Student ivan = new Student("Ivan", 48);
//        Student olha = new Student("Olha", 31);
//        Student maxim = new Student("Maxim", 37);
//
//        students.add(vasyl);
//        students.add(anna);
//        students.add(petro);
//        students.add(ivan);
//        students.add(olha);
//        students.add(maxim);
//
//        System.out.println("Students: " + students);
//        System.out.println("Before Maxim: "+ students.headSet(maxim));
//        System.out.println("After Maxim: "+ students.tailSet(maxim));
//        System.out.println("Between Ivan and Petro: "+ students.subSet(petro, ivan));
//
//        Set<Student> javaStudents = new HashSet<>();
//        Set<Student> javaStudents = new LinkedHashSet<>();
//        Set<Student> frontendStudents = new HashSet<>();
//
//        Student vasyl = new Student("Vasyl", 21);
//        Student anna = new Student("Anna", 22);
//        Student petro = new Student("Petro", 35);
//        Student ivan = new Student("Ivan", 48);
//        Student olha = new Student("Olha", 31);
//        Student maxim = new Student("Maxim", 37);
//
//        javaStudents.add(vasyl);
//        javaStudents.add(anna);
//        javaStudents.add(petro);
//        javaStudents.add(ivan);
//        javaStudents.add(olha);
//
//        frontendStudents.add(anna);
//        frontendStudents.add(petro);
//        frontendStudents.add(maxim);
//
//        System.out.println("Java Students: " + javaStudents);
//        System.out.println("Frontend Students: " + frontendStudents);
//
//        Set<Student> allStudents = new HashSet<>();
//        allStudents.addAll(javaStudents);
//        allStudents.addAll(frontendStudents);
//
//        System.out.println("All students: " + allStudents);
//
//        Set<Student> javaAndFrontendStudent = new HashSet<>();
//        javaAndFrontendStudent.addAll(javaStudents);
//        javaAndFrontendStudent.retainAll(frontendStudents);
//
//        System.out.println("java&frontend students: " + javaAndFrontendStudent);
//
//        int size = javaStudents.size();
//        System.out.println("Does Vasyl study Java? " + javaStudents.contains(vasyl));

    // FIXME: maps' key set

//        Map<Integer, Integer> someMap = new HashMap<>();
//        someMap.put(1, 3);
//        someMap.put(4, 3);
//        someMap.put(7, 3);
//
//        for (Integer integer : someMap.keySet()) {
//            System.out.println(someMap.get(integer));
//        }
//
//        Collection<Integer> values = someMap.values();
//        Set<Integer> integers = someMap.keySet();

        System.out.println();


        // Optional
        // BigDecimal, BigInteger
        // double, float, int, long
        // RegEx

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
//        List<String> strList = new ArrayList<>();
//        List<String> strList1 = new LinkedList<>();
//
//        Queue<String> queue = new LinkedList<>();
//        Deque<String> deque = new LinkedList<>();



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

    public static List<Student> getMajorStudents(Predicate<Student> predicate, Student... students) {
        List<Student> majorStudents = new ArrayList<>();

        for (Student student :
                students) {
            if (predicate.test(student)) {
                majorStudents.add(student);
            }
        }

        return majorStudents;
    }
}
