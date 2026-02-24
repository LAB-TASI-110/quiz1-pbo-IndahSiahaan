import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();
        int[] nilai = new int[N];

        for (int i = 0; i < N; i++) {
            nilai[i] = input.nextInt();
        }

        int total = 0;

        // Jumlahkan semua nilai
        for (int i = 0; i < N; i++) {
            total += nilai[i];
        }

        System.out.println(total);

        input.close();
    }
}
