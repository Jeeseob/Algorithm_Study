package sliver.problem1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        ArrayList<String> noData = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String data = br.readLine();
            if(hashSet.contains(data)) {
                noData.add(data);
            }
        }

        System.out.println(noData.size());
        Collections.sort(noData);
        for (String name : noData) {
            System.out.println(name);
        }
    }
}
