
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
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

        System.out.println(result);

    }
}