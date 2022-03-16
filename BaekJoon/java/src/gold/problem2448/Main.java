package gold.problem2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static Boolean[][] tree;
    private static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        // 입력
        height = Integer.parseInt(st.nextToken());

        // 초기화
        tree = new Boolean[height][height * 2 - 1];
        for(int i = 0; i < height; i++) {
            Arrays.fill(tree[i], false);
        }

        // 알고리즘 동작
        drawTree(0, height-1, height);

        // 출력
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < height*2 -1; j++) {
                if(tree[i][j]) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static void drawTree(int row, int start,int tempHeight) {
        if(row+2 >= height) {
            return;
        }
        if(tempHeight == 3) {

            tree[row][start] = true;
            tree[row + 1][start - 1] = true;
            tree[row + 1][start + 1] = true;
            for (int i = start - 2; i <= start + 2; i++) {
                tree[row + 2][i] = true;
            }
        }
        else {
            int nextHeight = tempHeight/2;
            // 현재 노드는 그려야 하기 때문에, 단순히 tempHeight를 3으로 만들기 위한 재귀
            drawTree(row, start, nextHeight);

            // 규칙성을 찾아서 모두 그려줌.
            drawTree(row + nextHeight, start - nextHeight, nextHeight);
            drawTree(row + nextHeight, start + nextHeight, nextHeight);
        }
    }
}
