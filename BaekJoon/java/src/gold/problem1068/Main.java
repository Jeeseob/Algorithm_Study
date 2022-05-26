package gold.problem1068;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        if(N==1) {
            System.out.println(0);
            System.exit(0);
        }
        initTree(N);
        makeTree(br, N);

        int delete = getDelete(br);
        // delete 노드의 부모노드에서 delete 노드 제거
        checkDelete(N, delete);
        // delete 노드의 하위 노드에 leaf를 추가하여 leaf count에서 제거
        calcTree(delete);

        int answer = getAnswer(N);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void checkDelete(int N, int delete) {
        for (int i = 0; i < N; i++) {
            if(tree[i].contains(delete)) {
                tree[i].remove((Integer) delete);
                break;
            }
        }
    }

    private static int getDelete(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static void makeTree(BufferedReader br, int N) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int tempNode = Integer.parseInt(st.nextToken());
            if(tempNode == -1) continue;
            tree[tempNode].add(i);
        }
    }

    private static void calcTree(int delete) {
        for (int i = 0; i < tree[delete].size(); i++) {
            calcTree(tree[delete].get(i));
        }
        tree[delete].add(-1);
    }

    private static int getAnswer(int N) {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i].isEmpty()) {
                answer++;
            }
        }
        return answer;
    }

    private static void initTree(int N) {
        tree = new List[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
    }
}
