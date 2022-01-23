package sliver;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek1149 {

    static class House {
        int red;
        int green;
        int blue;
        String color;

        public void setColor(String[] colorPrice) {
            this.red = Integer.parseInt(colorPrice[0]);
            this.blue = Integer.parseInt(colorPrice[1]);
            this.green = Integer.parseInt(colorPrice[2]);
        }

        public int minColor(){
            int min = Integer.min(red, green);
            return min = Integer.min(min, blue);
        }
    }

    public static void main(String[] args){
        /*
        RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

        집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
        아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

        1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
        */

        Scanner scanner = new Scanner(System.in);
        ArrayList<House> houseArrayList = new ArrayList<House>();
        int result = 0;

        int numberOfHouse = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfHouse; i++) {
            houseArrayList.get(i).setColor(scanner.nextLine().split(" "));
        }

        System.out.println(result);
    }
}
