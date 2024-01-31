package Softeer.DP;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** 소프티어 징검다리 문제**/
public class P6293 {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int answer = 0;
        int[] rocks = IntStream.range(0, N).map( i -> scanner.nextInt()).toArray();
        int[] dp = IntStream.range(0, N).map(i -> 1).toArray();

        for(int i=0;i<N;i++){
            for(int j=0;j<=i;j++){
                if(rocks[i] > rocks[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
        }

        for(int i=0;i<N;i++){
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
