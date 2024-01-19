import java.util.*;

public class P43163 {

    static boolean[] visited;
    static int answer;
    public static void dfs(String begin, String target, String[] words, int count){

        if(begin.equals(target)){
            answer = count;
            return;
        }

        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;
            int diff = 0;
            for(int j=0;j<words[i].length();j++){
                if(begin.charAt(j) != words[i].charAt(j))
                    diff++;
            }

            if(diff == 1){
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        }

    }
    public static int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));


    }
}
