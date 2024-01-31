package Softeer.Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int weight;
    int price;
    Pair(int weight, int price){
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Pair o) {
        return this.price > o.price ? -1 : 1;
    }
}
public class P6288 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int N = scanner.nextInt();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            int weight = scanner.nextInt();
            int price = scanner.nextInt();
            pq.offer(new Pair(weight, price));
        }

        int answer = 0;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            System.out.println(total + " " + answer);
            if( total < top.weight){
                answer += total * top.price;
                break;
            }
            answer +=  top.weight * top.price;
            total -= top.weight;
        }
        System.out.println(answer + "");
    }
}
