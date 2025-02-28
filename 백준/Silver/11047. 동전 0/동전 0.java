import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        int sum = 0, count = 0, idx = n-1;
        while(sum != k) {
            if(sum + coin[idx] > k){
                idx--;
                continue;
            } else {
                sum += coin[idx];
                count++;
            }

            if(sum == k)
                break;
        }
        System.out.print(count);
    }
}
