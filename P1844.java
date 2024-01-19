import java.util.*;
public class P1844 {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int[][] visited;
    boolean isSuccess = false;
    int answer = 0;

    public int solution(int[][] maps) {
        visited = new int[maps.length][maps[0].length];

        bfs(maps);
        answer = visited[maps.length-1][maps[0].length-1];
        if(!isSuccess) answer = -1;

        return answer;
    }

    public void bfs(int[][] maps){

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0,0));
        visited[0][0] = 1;

        while(!q.isEmpty()){

            int cx = q.peek().x;
            int cy = q.peek().y;
            answer++;

            if(cx == maps.length -1 && cy == maps[0].length -1){
                isSuccess = true;
                break;
            }

            for(int i=0;i<4;i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length){
                    if(visited[nx][ny] == 0 && maps[nx][ny] == 1)
                        q.offer(new Pair(nx, ny));
                    visited[nx][ny] = visited[cx][cy] + 1;
                }

            }
            q.poll();
        }

    }
}