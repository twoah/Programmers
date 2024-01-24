import java.util.*;

public class P43162 {

    public static  int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited = new int[computers.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<computers.length;i++){
            if(visited[i] == 0){
                answer++;
                visited[i] = answer;
                q.offer(i);
            }
            while (!q.isEmpty()){
                int num = q.peek();
                for(int j=0;j<computers[num].length;j++){
                    if(computers[num][j] == 1 && visited[j] == 0){
                        q.offer(j);
                        visited[num] = answer;
                    }
                }
                q.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 1}};
        solution(3, computers);
    }
}
