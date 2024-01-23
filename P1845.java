import java.util.*;
public class P1845 {

    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }

        Iterator iterator = hashSet.iterator();
        while(!iterator.hasNext()){
            System.out.println(iterator.next());
        }

        if(nums.length / 2  < hashSet.size())
            answer = nums.length / 2;
        else answer = hashSet.size();
        return answer;
    }
}
