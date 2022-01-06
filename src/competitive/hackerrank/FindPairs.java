package competitive.hackerrank;

import java.util.*;

public class FindPairs {
    public static void main(String[] args) {
        final int EXECUTION_TIMES = 100;
        List<Integer> numbers12 = List.of(1, 2);
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3);
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> nus = List.of(1, 2, 5, 6, 9, 10);

        long time = System.currentTimeMillis();
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            System.out.println(PairUtil.countPairs(numbers12, 1));
            System.out.println();

            System.out.println(PairUtil.countPairs(numbers, 1));
            System.out.println();

            System.out.println(PairUtil.countPairs(nums, 2));
            System.out.println();

            System.out.println(PairUtil.countPairs(nus, 2));
            System.out.println();
        }
        long firstTime = System.currentTimeMillis() - time;

        time = System.currentTimeMillis();
        for (int i = 0; i < EXECUTION_TIMES; i++) {
            System.out.println(PairUtil.countPairsBrutForce(numbers12, 1));
            System.out.println();

            System.out.println(PairUtil.countPairsBrutForce(numbers, 1));
            System.out.println();

            System.out.println(PairUtil.countPairsBrutForce(nums, 2));
            System.out.println();

            System.out.println(PairUtil.countPairsBrutForce(nus, 2));
            System.out.println();
        }
        System.out.println("execution of countPairs() took " + firstTime + "ms");
        System.out.println("execution of countPairsBrutForce() took " + (System.currentTimeMillis() - time) + "ms");
    }
}

class PairUtil {
    public static int countPairs(List<Integer> numbers, int k) {
        Set<Pair> pairs = new HashSet<>();
        int iterationCount = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = numbers.size() - 1; j >= i; j--) {
                iterationCount++;

                int a = numbers.get(i);
                int b = numbers.get(j);
                if (a + k == b) {
                    boolean added = pairs.add(new Pair(a, b));
                    if (added) System.out.println(a + ", " + b + " pair added");
                }
            }
        }

        System.out.println("countPairs() iteration count: " + iterationCount);
        return pairs.size();
    }

    public static int countPairsBrutForce(List<Integer> numbers, int k) {
        Set<Pair> pairs = new HashSet<>();
        int iterationCount = 0;
        for (int a : numbers) {
            for (int b : numbers) {
                iterationCount++;
                if (a + k == b) {
                    boolean added = pairs.add(new Pair(a, b));
                    if (added) System.out.println(a + ", " + b + " pair added");
                }
            }
        }

        System.out.println("countPairsBrutForce() iteration count: " + iterationCount);
        return pairs.size();
    }
}

record Pair(int p, int k) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (p != pair.p) return false;
        return k == pair.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p, k);
    }
}
