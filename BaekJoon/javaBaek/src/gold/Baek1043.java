package gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek1043 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");
        int numberOfParty = Integer.parseInt(strings[1]);

        int addPoint = 1;
        int result = 0;

        strings = scanner.nextLine().split(" ");

        ArrayList<Integer> knownRealPeople = new ArrayList<Integer>();
        for(String str : strings) {
            knownRealPeople.add(Integer.parseInt(str));
        }
        knownRealPeople.remove(0); // 처음 값은 총 인원이기 때문에 제외

        ArrayList<ArrayList<Integer>> peopleInParty = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i<numberOfParty; i++) {
            peopleInParty.add(new ArrayList<Integer>());
            strings = scanner.nextLine().split(" ");
            for(String str : strings) {
                peopleInParty.get(i).add(Integer.parseInt(str));
            }
            peopleInParty.get(i).remove(0);
        }
        for(int j = 0; j<numberOfParty; j++) {
            for (int i = 0; i < numberOfParty; i++) {
                for (int person : knownRealPeople) {
                    if (peopleInParty.get(i).contains(person)) {
                        for (int personInParty : peopleInParty.get(i)) {
                            knownRealPeople.add(personInParty);
                        }
                        break;
                    }
                }
            }
        }

        for(int i = 0; i<numberOfParty; i++) {
            for(int person : knownRealPeople) {
                if (peopleInParty.get(i).contains(person)) {
                    addPoint = 0;
                    break;
                }
                else {
                    addPoint = 1;
                }
            }
            result += addPoint;
        }

        for(int person : knownRealPeople) {
            System.out.println(person);
        }
        System.out.println();
        System.out.println(result);




        // 1 진실을 아는 사람이 오면 더하지 않는다.
        // 2 진실을 아는 사람과 함께 온 사람이 있으면 더하지 않는다.

        // 3 순서대로하는 것이 아니라 한번에 처리해야 한다.

        // 4 일단 진실을 아는 사람과 같이온 사람부터 처리한 후, 그 사람과 같이 온 사람을 진실을 아는 사람에 넣는다.




    }
}
