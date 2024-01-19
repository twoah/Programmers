import java.util.*;

public class P87694 {

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        int answer = 0;
        int[][] check = new int[101][101];

        for(int[] rec : rectangle){
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int ex = rec[2] * 2;
            int ey = rec[3] * 2;
            for(int i = sx; i <= ex;i++){
                for(int j=sy; j <=ey;j++){
                    check[i][j] = 1;
                }
            }
        }


        for(int[] rec : rectangle){
            int sx = rec[0] * 2;
            int sy = rec[1] * 2;
            int ex = rec[2] * 2;
            int ey = rec[3] * 2;
            for(int i=sx+1;i<ex;i++){
                for(int j=sy+1;j<ey;j++){
                    check[i][j] = 0;
                }
            }
        }

        int cx = characterX * 2;
        int cy = characterY * 2;
        int ix = itemX * 2;
        int iy = itemY * 2;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int visited[][] = new int[101][101];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(cx, cy));
        visited[cx][cy] = 0;

        while(!queue.isEmpty()){
            cx = queue.peek().x;
            cy = queue.peek().y;
            if(cx == ix && cy == iy)
                break;
            for(int i =0;i<4;i++){
                int nx = queue.peek().x + dx[i];
                int ny = queue.peek().y + dy[i];

                if(nx >= 0 && nx < 101 && ny >= 0 && ny < 101 && check[nx][ny] == 1 && visited[nx][ny] == 0){
                    queue.offer(new Pair(nx,ny));
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
            queue.poll();
        }
        answer = visited[ix][iy];
        return answer / 2;
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        System.out.println(solution(rectangle, 9, 7, 6, 1));
    }
}
