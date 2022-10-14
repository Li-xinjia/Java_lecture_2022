public class Calc {
    public static void main(String[] args) {
        int list[] = { 10, 12, 8, 16, 20, 6, 24, 32 };

        int max = list[0];
        for (int i : list) {
            max = Math.max(max, i);
        }

        int min = list[0];
        for (int i : list) {
            min = Math.min(min, i);
        }

        int total = 0;
        int num = 0;
        int average = 0;
        for (int i : list) {
            total += i;
            num++;
        }
        average = total / num;

        System.out.println("Max: " + max + "\n");
        System.out.println("Min: " + min + "\n");
        System.out.println("Average: " + average + "\n");
    }
}
