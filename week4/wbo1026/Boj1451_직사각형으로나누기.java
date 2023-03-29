package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1451{
    static int N, M;
    static long max;
    static int[][] rec;
    static long[][] sum;

    static void rec1() { // III 케이스
        for (int i = 1; i <= M - 2; i++) {
            for (int j = i + 1; j <= M - 1; j++) {
                long a = sum2(1, 1, N, i);
                long b = sum2(1, i + 1, N, j);
                long c = sum2(1, j + 1, N, M);
                max = Math.max(max, a * b * c);
            }
        }
    }

    static void rec2() { // 三 케이스
        for (int i = 1; i <= N - 2; i++) {
            for (int j = i + 1; j <= N - 1; j++) {
                long a = sum2(1, 1, i, M);
                long b = sum2(i + 1, 1, j, M);
                long c = sum2(j + 1, 1, N, M);
                max = Math.max(max, a * b * c);
            }
        }
    }

    static void rec3() { // ㅑ 케이스
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                long a = sum2(1, 1, N, j);
                long b = sum2(1, j + 1, i, M);
                long c = sum2(i + 1, j + 1, N, M);
                max = Math.max(max, a * b * c);
            }
        }
    }

    static void rec4() { // ㅕ 케이스
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                long a = sum2(1, 1, i, j);
                long b = sum2(i + 1, 1, N, j);
                long c = sum2(1, j + 1, N, M);
                max = Math.max(max, a * b * c);
            }
        }
    }

    static void rec5() { // ㅠ 케이스
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                long a = sum2(1, 1, i, M);
                long b = sum2(i + 1, 1, N, j);
                long c = sum2(i + 1, j + 1, N, M);
                max = Math.max(max, a * b * c);
            }
        }
    }

    static void rec6() { // ㅛ 케이스
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= M - 1; j++) {
                long a = sum2(1, 1, i, j);
                long b = sum2(1, j + 1, i, M);
                long c = sum2(i + 1, 1, N, M);
                max = Math.max(max, a * b * c);
            }
        }
    }

    // 1. for문으로 합 구하기
    static long sum(int startY, int startX, int endY, int endX) {
        long sum = 0;

        for (int i = startY; i <= endY; i++) {
            for (int j = startX; j <= endX; j++) {
                sum += rec[i][j];
            }
        }
        return sum;
    }

    // 2. 누적합을 이용해 구하기
    static long sum2(int startY, int startX, int endY, int endX) {

        return sum[endY][endX] - sum[endY][startX - 1] - sum[startY - 1][endX] + rec[startY - 1][startX - 1];

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        rec = new int[N + 1][M + 1];
        sum = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                rec[i][j] = (int) str.charAt(j - 1) - '0';
            }
        }

        for (int i = 1; i <= N; i++) { // 누적합 구하기
            for (int j = 1; j <= M; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + (long) rec[i][j] - sum[i - 1][j - 1];
            }
        }

        // end input

        rec1();
        rec2();
        rec3();
        rec4();
        rec5();
        rec6();
        System.out.println(max);

    }
}