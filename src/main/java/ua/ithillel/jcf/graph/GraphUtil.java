package ua.ithillel.jcf.graph;

import java.util.*;

public class GraphUtil {
    public static <V> List<V> depthFirstTraverse(Map<V, List<V>> graph, V node) {
        List<V> values = new ArrayList<>();
        Stack<V> stack = new Stack<>();
        Set<V> visited = new HashSet<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            V top = stack.pop();

            if (visited.contains(top)) {
                continue;
            }

            values.add(top);

            List<V> neighbours = graph.get(top);
            for (V neighbour :
                    neighbours) {
                stack.push(neighbour);
            }

            visited.add(top);

        }

        return values;
    }

    public static <V> List<V> breadthFirstTraverse(Map<V, List<V>> graph, V node) {
        List<V> values = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            V top = queue.remove();

            if (visited.contains(top)) {
                continue;
            }

            values.add(top);

            List<V> neighbours = graph.get(top);
            for (V neighbour :
                    neighbours) {
                queue.add(neighbour);
            }

            visited.add(top);

        }

        return values;
    }

    public static <V> boolean hasPath(Map<V, List<V>> graph, V src, V dst) {
        Queue<V> queue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        queue.add(src);

        while (!queue.isEmpty()) {
            V top = queue.remove();

            if (top == dst || top.equals(dst)) {
                return true;
            }

            if (visited.contains(top)) {
                continue;
            }


            List<V> neighbours = graph.get(top);
            for (V neighbour :
                    neighbours) {
                queue.add(neighbour);
            }

            visited.add(top);

        }

        return false;
    }

    public static <V> Map<V, List<V>> edgeListToAdjacency(V[][] edgeList) {
        Map<V, List<V>> graph = new HashMap<>();

        for (V[] edge :
                edgeList) {
            V begin = edge[0];
            V end = edge[1];

            if (!graph.containsKey(begin)) {
                graph.put(begin, new ArrayList<>());
            }

            if (!graph.containsKey(end)) {
                graph.put(end, new ArrayList<>());
            }

            graph.get(begin).add(end);
            graph.get(end).add(begin);
        }

        return graph;
    }
}
