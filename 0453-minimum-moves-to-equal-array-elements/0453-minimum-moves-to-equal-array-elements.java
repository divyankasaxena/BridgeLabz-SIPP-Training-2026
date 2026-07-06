class Solution {
    public int minMoves(int[] A) {
        return (int)(Arrays.stream(A).asLongStream().sum() - 1L * Arrays.stream(A).min().getAsInt() * A.length);
    }
}