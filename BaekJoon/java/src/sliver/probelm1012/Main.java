package sliver.probelm1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static Point[] Points;
    private static int board[][];
    private static int rowBoard;
    private static int columnBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int numberOfTestCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < numberOfTestCase; i++) {
            readConsole(br);
            int tempAnswer = calc();
            stringBuilder.append(tempAnswer + "\n");
        }

        System.out.println(stringBuilder);
    }

    private static int calc() {
        int answer = 0;

        Boolean[][] visited = new Boolean[columnBoard][rowBoard];
        initVisted(visited);

        Queue<Point> pointQueue = new LinkedList<>();

        for (int i = 0; i < Points.length; i++) {
            if (!visited[Points[i].getColumn()][Points[i].getRow()]) {
                answer++;
                pointQueue.add(Points[i]);

                while (!pointQueue.isEmpty()) {
                    Point tempPoint = pointQueue.poll();
                    int tempColumn = tempPoint.getColumn();
                    int tempRow = tempPoint.getRow();

                    if (board[tempColumn][tempRow] == 1) {
                        if (visited[tempColumn][tempRow]) continue;
                        visited[tempColumn][tempRow] = true;

                        if (tempColumn > 0) {
                            pointQueue.add(new Point(tempColumn - 1, tempRow));
                        }
                        if (tempColumn < columnBoard - 1) {
                            pointQueue.add(new Point(tempColumn + 1, tempRow));
                        }

                        if (tempRow > 0) {
                            pointQueue.add(new Point(tempColumn, tempRow - 1));
                        }
                        if (tempRow < rowBoard - 1) {
                            pointQueue.add(new Point(tempColumn, tempRow + 1));
                        }
                    }
                }
            }
        }

        return answer;
    }

    private static void initVisted(Boolean[][] visited) {
        for(Boolean[] visitedRow : visited) {
            Arrays.fill(visitedRow, false);
        }
    }

    private static void readConsole(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        rowBoard = Integer.parseInt(st.nextToken());
        columnBoard = Integer.parseInt(st.nextToken());
        board = new int[columnBoard][rowBoard];

        int numberOfCabbage = Integer.parseInt(st.nextToken());
        Points = new Point[numberOfCabbage];
        readWorm(br, numberOfCabbage);
    }

    private static void readWorm(BufferedReader br, int numberOfCabbage) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < numberOfCabbage; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int row = Integer.parseInt(st.nextToken());
            int column = Integer.parseInt(st.nextToken());

            board[column][row] = 1;
            Points[i] = new Point(column, row);
        }
    }

    private static class Point {
        private int column;
        private int row;

        public int getColumn() {
            return column;
        }

        public int getRow() {
            return row;
        }

        public Point(int column, int row) {
            this.column = column;
            this.row = row;
        }
    }
}
