package gold.problem1043;

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

        ArrayList<Integer> knowReals = new ArrayList<Integer>();
        for(String str : strings) {
            knowReals.add(Integer.parseInt(str));
        }
        knowReals.remove(0); // 처음 값은 총 인원이기 때문에 제외

        ArrayList<ArrayList<Integer>> peopleInParty = new ArrayList<ArrayList<Integer>>();

        //파티와 각 파티에 참석하는 사람을 저장한다.
        for(int i = 0; i<numberOfParty; i++) {
            peopleInParty.add(new ArrayList<Integer>());
            strings = scanner.nextLine().split(" ");
            for(String str : strings) {
                peopleInParty.get(i).add(Integer.parseInt(str));
            }
            peopleInParty.get(i).remove(0);
        }

        // 광기의 knownReals.. 찾기

        // 모든 파티를 체크하는데, 시간상관없이 체크해야하기 때문엔 이중 for문을 돈다.
        for(int j = 0; j<numberOfParty; j++) {
            for (int i = 0; i < numberOfParty; i++) {
                // knowReals에 속하는 사람이 해당 파티에 존재하는 경우,
                for (int knowReal : knowReals) {
                    // 해당 파티에 참석한 모든 사람을 knowReals에 추가한다.
                    if (peopleInParty.get(i).contains(knowReal)) {
                        for (int personInParty : peopleInParty.get(i)) {
                            knowReals.add(personInParty);
                        }
                        break;
                    }
                }
            }
        }

        // 진실을 아는 사람이 아무도 없는 경우, 해당 파티에서는 거짓말을 해도 된다.
        for(int i = 0; i<numberOfParty; i++) {
            for(int person : knowReals) {
                if (peopleInParty.get(i).contains(person)) {
                    addPoint = 0;
                    break;
                }
                addPoint = 1;
            }
            result += addPoint;
        }
        System.out.println(result);
    }
}
