public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(getMissingNo(new int[] {5, 3, 2, 1}, 4));
    }

    public static int getMissingNo(int[] input, int n) {
        int s = 0;
        for (int i = 2; i <= (n + 1); i++) {
            s += i;
            s -= input[i - 2];
        }

        return s;
    }
}
