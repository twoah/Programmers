package StackAndQueue;

import java.util.ArrayList;

public class P12906 {

    public static int[] solution(int []arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int cur = -1;
        for(int i=0;i<arr.length;i++){
            if(cur!=arr[i]){
                arrayList.add(arr[i]);
                cur = arr[i];
            }

        }
        return arrayList.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {

    }
}
