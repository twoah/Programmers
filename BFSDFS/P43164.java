import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P43164 {

    PriorityQueue<String> pq = new PriorityQueue<>();
    boolean[] visited ;

    public void dfs(String[][] tickets, String current, int cnt, String path){
        if(cnt == tickets.length){
            pq.add(path);
            return;
        }
        for(int i=0;i<tickets.length;i++){
            if(visited[i] == false && tickets[i][0].equals(current)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], cnt + 1, path + "," + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0, "ICN");
        answer = pq.peek().split(", ");
        return answer;
    }
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //solution(tickets);
    }
}


