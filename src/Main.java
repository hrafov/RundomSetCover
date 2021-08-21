import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String...args) {
        int numberOfVertices = 16;
        int numberOfIterations = 50000;
        ArrayList<ArrayList<Integer>> adj = inputInit(numberOfVertices);
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

    static ArrayList<ArrayList<Integer>> inputInit(int v) {
        // Creating a graph with 16 vertices - https://www.youtube.com/watch?v=XmW3xR-0CSE
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 0, 3);

        addEdge(adj, 1, 0);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 5);
        addEdge(adj, 1, 4);

        addEdge(adj, 2, 1);
        addEdge(adj, 2, 6);
        addEdge(adj, 2, 5);

        addEdge(adj, 3, 0);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 3, 10);
        addEdge(adj, 3, 9);

        addEdge(adj, 4, 0);
        addEdge(adj, 4, 1);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 7);
        addEdge(adj, 4, 3);

        addEdge(adj, 5, 1);
        addEdge(adj, 5, 2);
        addEdge(adj, 5, 6);
        addEdge(adj, 5, 8);
        addEdge(adj, 5, 7);
        addEdge(adj, 5, 4);

        addEdge(adj, 6, 2);
        addEdge(adj, 6, 12);
        addEdge(adj, 6, 8);
        addEdge(adj, 6, 5);

        addEdge(adj, 7, 3);
        addEdge(adj, 7, 4);
        addEdge(adj, 7, 5);
        addEdge(adj, 7, 8);
        addEdge(adj, 7, 11);
        addEdge(adj, 7, 10);

        addEdge(adj, 8, 5);
        addEdge(adj, 8, 6);
        addEdge(adj, 8, 12);
        addEdge(adj, 8, 11);
        addEdge(adj, 8, 7);

        addEdge(adj, 9, 3);
        addEdge(adj, 9, 10);
        addEdge(adj, 9, 13);

        addEdge(adj, 10, 3);
        addEdge(adj, 10, 7);
        addEdge(adj, 10, 11);
        addEdge(adj, 10, 13);
        addEdge(adj, 10, 9);

        addEdge(adj, 11, 7);
        addEdge(adj, 11, 8);
        addEdge(adj, 11, 12);
        addEdge(adj, 11, 14);
        addEdge(adj, 11, 10);

        addEdge(adj, 12, 8);
        addEdge(adj, 12, 6);
        addEdge(adj, 12, 15);
        addEdge(adj, 12, 14);
        addEdge(adj, 12, 11);

        addEdge(adj, 13, 9);
        addEdge(adj, 13, 10);
        addEdge(adj, 13, 14);

        addEdge(adj, 14, 11);
        addEdge(adj, 14, 12);
        addEdge(adj, 14, 15);
        addEdge(adj, 14, 13);

        addEdge(adj, 15, 12);
        addEdge(adj, 15, 14);

        return adj;
    }

    static  boolean isValidSetCover(ArrayList<ArrayList<Integer>> adj, boolean[] randomBoolean) {
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

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
