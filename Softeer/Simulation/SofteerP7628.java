package Softeer.Simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 연탄의 크기
 * https://softeer.ai/practice/7628
 * **/
public class SofteerP6253 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        int[] num = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = scanner.nextInt();
        }
        num = IntStream.range(0, N).map(i->arr[i]).sorted().toArray();
        int answer = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=2;i<=200;i++){
            int count = 0;
            for(int j=0;j<N;j++){
                if(num[j] % i == 0){
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);

    }
}
