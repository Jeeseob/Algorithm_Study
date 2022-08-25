package gold.problem1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/08/25
 * @Problem : https://www.acmicpc.net/problem/1922
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] group = new int[N];
        for (int i = 0; i < N; i++) {
            group[i] = i;
        }

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edges);

        int answer = 0;
        for (int i = 0; i < M; i++) {
            int com1 = edges[i].getCom1();
            int com2 = edges[i].getCom2();

            if (group[com1 - 1] != group[com2 - 1]) {
                answer += edges[i].getCost();
                int groupCode1 = group[com1 - 1];
                int groupCode2 = group[com2 - 1];
                for (int j = 0; j < N; j++) {
                    if(group[j] == groupCode2) {
                        group[j] = groupCode1;
                    }
                }

            }
        }
        System.out.println(answer);
    }
}

class Edge implements Comparable<Edge>{
    private int com1;
    private int com2;
    private int cost;

    public Edge(int com1, int com2, int cost) {
        this.com1 = com1;
        this.com2 = com2;
        this.cost = cost;
    }

    public int getCom1() {
        return com1;
    }

    public int getCom2() {
        return com2;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge computer) {
        return this.cost - computer.cost;
    }
}

