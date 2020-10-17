package Assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
         * Approach:
         * Create a Hashmap from the input matrix such that key of map stores a pair conating the indices of a block of matrix and 
         * the value of the Hashmap stores how many adjacents of this particular block are duplicates.
         * If matrix is 
         * a a
         * a b
         * Values would be
         * 2 1
         * 1 0
         * 
         * So now Traverse the map and remove all zero valued blocks
         * Then find the block which has the maximum value, (in case of multiple find first one) 
         * Replant that block with any crop that is different from crops in its adjacent blocks
         * Remove the particular block from the map
         * Update the values of adjacent blocks in the map.
         * If value is 0 remove form the map
         * While map has any block repeat the procedure. 
         * Keep Incremeting the replant value inside the while loop 
         * and output the answer
         */
public class Question4_1 {
    ArrayList<ArrayList<Integer>> crops;
    int n;
    HashMap<Pair<Integer, Integer>, Integer> map;

    // Functions to check if duplicates exist in adjacents
    int getCurr(int i, int j) {
        return crops.get(i).get(j);
    }

    int getUp(int i, int j) {
        if (i != 0 && i < n && j > -1 && j < n)
            return crops.get(i - 1).get(j);
        return -1;
    }

    int getDown(int i, int j) {
        if (i != n - 1 && i > -1 && j > -1 && j < n)
            return crops.get(i + 1).get(j);
        return -1;
    }

    int getLeft(int i, int j) {
        if (j != 0 && j < n && i > -1 && i < n)
            return crops.get(i).get(j - 1);
        return -1;
    }

    int getRight(int i, int j) {
        if (j != n - 1 && j < n && i > -1 && i < n)
            return crops.get(i).get(j + 1);
        return -1;
    }

    // A premade class that works similar to pair in cpp with reduced functionality
    public static class Pair<A, B> {
        private A first;
        private B second;

        public Pair(A first, B second) {
            super();
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            int hashFirst = first != null ? first.hashCode() : 0;
            int hashSecond = second != null ? second.hashCode() : 0;

            return (hashFirst + hashSecond) * hashSecond + hashFirst;
        }

        public boolean equals(Object other) {
            if (other instanceof Pair) {
                Pair otherPair = (Pair) other;
                return ((this.first == otherPair.first
                        || (this.first != null && otherPair.first != null && this.first.equals(otherPair.first)))
                        && (this.second == otherPair.second || (this.second != null && otherPair.second != null
                                && this.second.equals(otherPair.second))));
            }

            return false;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

    }

    public void showAll() {
        System.out.println("Crops Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(crops.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Value Matrix");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Pair<Integer, Integer> key = new Pair<Integer, Integer>(i, j);
                if (map.containsKey(key))
                    System.out.print(map.get(key));
                else
                    System.out.print(0);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public int getRandomCrop(ArrayList<Integer> excludeRows) {
        // Generates a random crop number from b/w 0 to 25 excluding some numbers
        Random rand = new Random();
        int range = 26;

        int random = rand.nextInt(range);

        while (excludeRows.contains(random)) {
            random = rand.nextInt(range);
        }

        return random;
    }

    public int calculateValue(int i, int j) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(getUp(i, j));
        arr.add(getDown(i, j));
        arr.add(getRight(i, j));
        arr.add(getLeft(i, j));
        return Collections.frequency(arr, getCurr(i, j));
    }

    void replant(ArrayList<ArrayList<Character>> crops) {

    }

    // This is the main function
    void planting() throws Exception {
        // Inputs taken
        System.out.print("Enter dimension of Matrix(n) : ");
        Scanner in = new Scanner(System.in);
        n = Integer.valueOf(in.nextLine());
        in.useDelimiter("\\s*");

        // crops is the input matrix where each input is converted to integer value b/w
        // 0 to 25
        crops = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter row " + (i + 1) + " : ");
            crops.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                char c = in.next().charAt(0);
                if (!Character.isLowerCase(c)) {
                    throw new Exception("Invalid Input");
                }
                crops.get(i).add(c - 'a');
            }
        }
        in.close();
        // This hashmap stores each index of matrix mapped with a value that stores the
        // number of duplicate adjacents of the index
        map = new HashMap<Pair<Integer, Integer>, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Pair<Integer, Integer> p = new Pair<Integer, Integer>(i, j);
                int num = calculateValue(i, j);

                if (num != 0)
                    map.put(p, num);
            }
        }
        // showAll();

        int count = 0;
        while (!map.isEmpty()) {
            HashMap.Entry<Pair<Integer, Integer>, Integer> maxEntry = null;

            for (HashMap.Entry<Pair<Integer, Integer>, Integer> entry : map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
            if (maxEntry == null) {
                continue;
            }
            int i = maxEntry.getKey().first;
            int j = maxEntry.getKey().second;
            ArrayList<Integer> arr = new ArrayList<Integer>();

            arr.add(getUp(i, j));
            arr.add(getDown(i, j));
            arr.add(getRight(i, j));
            arr.add(getLeft(i, j));
            int x = getRandomCrop(arr);
            crops.get(i).set(j, x);

            for (int p = i - 1; p <= i + 1; p++) {
                for (int q = j - 1; q <= j + 1; q++) {
                    if (p > -1 && p < n && q > -1 && q < n) {
                        int value = calculateValue(p, q);
                        Pair<Integer, Integer> key = new Pair<Integer, Integer>(p, q);
                        if (value < 1) {
                            map.remove(key);
                        } else {
                            map.put(key, value);
                        }
                    }
                }
            }
            count++;
            // showAll();
            System.out.println();
        }
        System.out.println("Replants required: " + count);

    }

    public static void main(String[] args) throws Exception {
        new Question4_1().planting();
    }

}
