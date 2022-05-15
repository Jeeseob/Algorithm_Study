package gold.problem9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] link;
    private static int count;
    private static Boolean[] visited;
    private static Boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int numberOfPeople = Integer.parseInt(br.readLine()) + 1;
            makeLink(br, numberOfPeople);

            initBooleanArray(numberOfPeople);
            count = 0;

            for (int j = 1; j < numberOfPeople; j++) {
                if (finished[j]) continue;
                dfs(j);
            }
            print(numberOfPeople);
        }
    }

    private static void initBooleanArray(int numberOfPeople) {
        finished = new Boolean[numberOfPeople];
        Arrays.fill(finished, false);
        visited = new Boolean[numberOfPeople];
        Arrays.fill(visited, false);
    }

    static void dfs(int temp) {
        visited[temp] = true;
        int next = link[temp];

        if(!visited[next]) {
            dfs(next);
        }

        else {
            // cycle에 속한 사람수를 count
            if(!finished[next]) {
                count++;
                while(next != temp) {
                    count++;
                    next = link[next];
                }
            }
        }
        finished[temp] = true;
    }

    private static void makeLink(BufferedReader br, int numberOfPeople) throws IOException {
        link = new int[numberOfPeople];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int j = 1; j < numberOfPeople; j++) {
            link[j] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print(int numberOfPeople) {
        System.out.println(numberOfPeople - count - 1);
    }
}
