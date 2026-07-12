class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0) return m * n;

        int[] intersection = ops[0];

        for (int[] op: ops) {
            if (intersection == op) continue;

            intersection = findIntersection(op, intersection);
        }

        return countElements(intersection);
    }

    private int[] findIntersection(int[] op, int[] intersection) {
        return new int[]{
            Math.min(intersection[0], op[0]),
            Math.min(intersection[1], op[1])
        };
    }

    private int countElements(int[] intersection) {
        return intersection[0] * intersection[1];
    }
}