package BinarySearch;

import  java.util.*;
public class P43238 {

    public static long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = times[times.length-1] * n;
        long max = times[times.length-1] * n;
        long min = n;
        long mid = 0;
        while(min <= max){
            mid  = (min + max) / 2;
            long count = 0;

            for(int time : times)
                count += mid / time ;

            if(count >= n){
                answer = Math.min(mid, answer);
                max = mid - 1;
            }
            else
                min = mid + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));;
    }
}
