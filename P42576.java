import java.util.HashMap;

public class P42576 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String p : participant){
            hashMap.put(p,hashMap.getOrDefault(p,0) + 1);
        }

        for(String complete : completion){
            hashMap.put(complete, hashMap.get(complete) - 1);
        }

        for(String key : hashMap.keySet()){
            if(hashMap.get(key) != 0)
                answer = key;
        }
        return answer;
    }
}
