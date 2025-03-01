import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[1100001];
        for(int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }

        for(int i = 2; i < Math.sqrt(arr.length); i++) {
            if(arr[i] == 0)
                continue;
            for(int j = i + i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }

        for(int i = n; i <= 1100000; i++) {
            if(arr[i] != 0) {
                if (isPalindrome(i)) {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
    static boolean isPalindrome(int n) {
        char[] num = String.valueOf(n).toCharArray();

        int s = 0;
        int e = num.length - 1;
        while(s < e) {
            if(num[s] != num[e])
                return false;
            s++;
            e--;
        }
        return true;
    }
}
