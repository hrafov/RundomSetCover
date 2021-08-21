import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String... args) {
        // Creating a graph with 5 vertices - https://www.geeksforgeeks.org/graph-and-its-representations/
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        int minSetCover = Integer.MAX_VALUE;
        boolean[] randomBoolean = new boolean[v];
        Random random = new Random();

        int numberOfIterations = 50;
        for (int i = 0; i < numberOfIterations; i++) {
            System.out.println("\n\n --- Iteration number(i): " + i + "\n");

            // random boolean set 01100
            for (int j = 0; j < v; j++) {
                randomBoolean[j] = random.nextBoolean();
                System.out.print(" " + randomBoolean[j]);
            }
            System.out.println();

            // check for valid set cover
            if (!isValidSetCover(adj, randomBoolean)) continue;

            // if validSetCover < minSetCover
            // minSetCover = validSetCover;
            int cardinalityOfValidSetCover = 0;
            for (int l = 0; l < v; l++) {
                if (randomBoolean[l]) cardinalityOfValidSetCover++;
            }
            if (cardinalityOfValidSetCover < minSetCover) minSetCover = cardinalityOfValidSetCover;
            System.out.println("--- cardinalityOfValidSetCover = " + cardinalityOfValidSetCover + "\n");
        }
        System.out.println("\n minSetCover = " + minSetCover + " for " + numberOfIterations + " iterations");
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
        for (int k = 0; k < v; k++) {
            if (!test[k]) return false;
        }
        return true;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

}
