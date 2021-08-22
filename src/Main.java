import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String... args) {
        int numberOfVertices = 16;
        int numberOfIterations = 50000;
        ArrayList<ArrayList<Integer>> adj = directInputInit();
        int minSetCover = Integer.MAX_VALUE;
        boolean[] randomBoolean = new boolean[numberOfVertices];
        Random random = new Random();
        boolean[] randomBooleanResultWithMinSetCover = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfIterations; i++) {
            for (int j = 0; j < numberOfVertices; j++) { // random boolean set 01100
                randomBoolean[j] = random.nextBoolean();
            }
            if (!isValidSetCover(adj, randomBoolean)) continue;
            int cardinalityOfValidSetCover = 0;
            for (Boolean l : randomBoolean) {
                if (l) cardinalityOfValidSetCover++;
            }
            if (cardinalityOfValidSetCover < minSetCover) {
                minSetCover = cardinalityOfValidSetCover;
                System.arraycopy(randomBoolean, 0, randomBooleanResultWithMinSetCover, 0, numberOfVertices);
            }
        }
        System.out.println("\n minSetCover = " + minSetCover + " for " + numberOfIterations + " iterations");
        for (Boolean b : randomBooleanResultWithMinSetCover) System.out.print(" " + b);
    }

//    static ArrayList<ArrayList<Integer>> inputInit(int v) {
//        // Creating a graph with 5 vertices - https://www.geeksforgeeks.org/graph-and-its-representations/
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
//        for (int i = 0; i < v; i++)
//            adj.add(new ArrayList<>());
//        addEdge(adj, 0, 1);
//        addEdge(adj, 0, 4);
//        addEdge(adj, 1, 2);
//        addEdge(adj, 1, 3);
//        addEdge(adj, 1, 4);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 3, 4);
//        return adj;
//    }

    static ArrayList<ArrayList<Integer>> directInputInit() { // it is need to include all vertices around
        return new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 3, 4)),
                        new ArrayList<>(Arrays.asList(0, 2, 4, 5)),
                        new ArrayList<>(Arrays.asList(1, 5, 6)),
                        new ArrayList<>(Arrays.asList(0, 4, 7, 9, 10)),
                        new ArrayList<>(Arrays.asList(0, 1, 3, 5, 7)),
                        new ArrayList<>(Arrays.asList(1, 2, 4, 6, 7, 8)),
                        new ArrayList<>(Arrays.asList(2, 5, 8, 12)),
                        new ArrayList<>(Arrays.asList(3, 4, 5, 8, 10, 11)),
                        new ArrayList<>(Arrays.asList(5, 6, 7, 11, 12)),
                        new ArrayList<>(Arrays.asList(3, 10, 13)),
                        new ArrayList<>(Arrays.asList(3, 7, 9, 11, 13)),
                        new ArrayList<>(Arrays.asList(7, 8, 10, 12, 14)),
                        new ArrayList<>(Arrays.asList(6, 8, 11, 14, 15)),
                        new ArrayList<>(Arrays.asList(9, 10, 14)),
                        new ArrayList<>(Arrays.asList(11, 12, 13, 15)),
                        new ArrayList<>(Arrays.asList(12, 14))
                ));
    }


//    static ArrayList<ArrayList<Integer>> inputInit(int v) {
//        // Creating a graph with 16 vertices - https://www.youtube.com/watch?v=XmW3xR-0CSE
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
//        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());
//        addEdge(adj, 0, 1);
//        addEdge(adj, 0, 4);
//        addEdge(adj, 0, 3);
//
//        addEdge(adj, 1, 2);
//        addEdge(adj, 1, 5);
//        addEdge(adj, 1, 4);
//
//        addEdge(adj, 2, 6);
//        addEdge(adj, 2, 5);
//
//        addEdge(adj, 3, 4);
//        addEdge(adj, 3, 7);
//        addEdge(adj, 3, 10);
//        addEdge(adj, 3, 9);
//
//        addEdge(adj, 4, 5);
//        addEdge(adj, 4, 7);
//
//        addEdge(adj, 5, 6);
//        addEdge(adj, 5, 8);
//        addEdge(adj, 5, 7);
//
//        addEdge(adj, 6, 12);
//        addEdge(adj, 6, 8);
//
//        addEdge(adj, 7, 8);
//        addEdge(adj, 7, 11);
//        addEdge(adj, 7, 10);
//
//        addEdge(adj, 8, 12);
//        addEdge(adj, 8, 11);
//
//        addEdge(adj, 9, 10);
//        addEdge(adj, 9, 13);
//
//        addEdge(adj, 10, 11);
//        addEdge(adj, 10, 13);
//
//        addEdge(adj, 11, 12);
//        addEdge(adj, 11, 14);
//
//        addEdge(adj, 12, 15);
//        addEdge(adj, 12, 14);
//
//        addEdge(adj, 13, 14);
//
//        addEdge(adj, 14, 15);
//
//        return adj;
//    }

    static boolean isValidSetCover(ArrayList<ArrayList<Integer>> adj, boolean[] randomBoolean) {
        int v = randomBoolean.length;
        boolean[] test = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (randomBoolean[i]) {
                test[i] = true;
                for (int j = 0; j < adj.get(i).size(); j++) { // for all adjacent
                    test[adj.get(i).get(j)] = true;
                }
            }
        }
        for (Boolean b : test) {
            if (!b) return false;
        }
        return true;
    }

//    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
//        adj.get(u).add(v);
//        adj.get(v).add(u);
//    }

}
