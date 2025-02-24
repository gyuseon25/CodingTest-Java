import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] arr, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        tmp = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(1, n);
        for(int i = 1; i <= n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void mergeSort(int s, int e) {
        if(e - s < 1) return;
        int m = s + (e - s) / 2;
        mergeSort(s, m);
        mergeSort(m+1, e);
        for(int i = s; i <= e; i++){
            tmp[i] = arr[i];
        }

        int k = s;
        int idx1 = s;
        int idx2 = m+1;
        //두 그룹을 병합하는 로직, 양쪽 인덱스가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 index값을 오른쪽으로 한 칸 이동 시키기
        while(idx1 <= m && idx2 <= e) {
            if(tmp[idx1] > tmp[idx2]) {
                arr[k] = tmp[idx2];
                k++;
                idx2++;
            } else {
                arr[k] = tmp[idx1];
                k++;
                idx1++;
            }
        }
        //한쪽 그룹이 모두 선택된 후 남아 있는 값 정리
        while (idx1 <= m) {
            arr[k] = tmp[idx1];
            k++;
            idx1++;
        }
        while (idx2 <= m) {
            arr[k] = tmp[idx2];
            k++;
            idx2++;
        }
    }
}
