package Softeer;

import java.util.Scanner;
import java.util.stream.Stream;

public class P6254 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] times = new String[5][2];

        Stream.iterate(0, i->i+1).limit(5)
                .forEach(i -> {
                    times[i][0] = scanner.next();
                    times[i][1] = scanner.next();

                });

        int sum = 0;
        for(int i=0;i<5;i++){
            int startHour = Integer.parseInt(times[i][0].split(":")[0]);
            int startMinute = Integer.parseInt(times[i][0].split(":")[1]);
            int endHour = Integer.parseInt(times[i][1].split(":")[0]);
            int endMinute = Integer.parseInt(times[i][1].split(":")[1]);
            System.out.println(sum);
            sum += (endHour* 60 + endMinute) - (startHour * 60 + startMinute);
        }
        System.out.println(sum);
    }
}
