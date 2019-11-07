import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] a;
    static List<List<Integer>> edges;
    static Queue<Integer> topQ;
    static int[] dp;
    static int[] inDegree;

    public static void main(String[] args) {
        N = sc.nextInt();
        a = new int[N][N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                a[i][j] = sc.nextInt() - 1;
            }
        }
        int M = N * (N - 1) / 2;
        inDegree = new int[M];
        edges = new ArrayList<List<Integer>>(M);
        topQ = new LinkedList<Integer>();
        dp = new int[M];
        for (int i = 0; i < M; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                int x = a[i][j];
                int y = a[i][j + 1];
                int v = f(i, x);
                int w = f(i, y);
                edges.get(v).add(w);
                inDegree[w]++;
            }
        }
        for (int i = 0; i < M; i++) {
            if (inDegree[i] == 0)
                topQ.offer(i);
        }
        // Topological sort
        int[] tSort = new int[M];
        boolean loop = false;
        for (int i = 0; i < M; i++) {
            if (topQ.size() > 0) {
                int v = topQ.poll();
                tSort[i] = v;
                for (int w : edges.get(v)) {
                    inDegree[w]--;
                    if (inDegree[w] == 0)
                        topQ.offer(w);
                }
            } else {
                loop = true;
                break;
            }
        }
        if (loop) {
            writer.println(-1);
            writer.flush();
        } else {
            for (int v : tSort) {
                for (int w : edges.get(v)) {
                    dp[w] = Math.max(dp[w], dp[v] + 1);
                }
            }
            int answer = 0;
            for (int distance : dp) {
                // writer.println(distance);
                answer = Math.max(distance, answer);
            }
            writer.println(answer + 1);
            writer.flush();

        }
    }

    static int f(int i, int j) {
        // writer.println("---");
        // writer.println(i);
        // writer.println(j);
        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        int answer = (N - 1) * i - ((i - 1) * i) / 2 + j - i - 1;
        // writer.println(answer);
        // writer.flush();
        return answer;
    }

    static final FastScanner sc = new FastScanner(System.in);
    static PrintWriter writer = new PrintWriter(System.out);

    static class FastScanner {
        Reader input;

        FastScanner() {
            this(System.in);
        }

        FastScanner(InputStream stream) {
            this.input = new BufferedReader(new InputStreamReader(stream));
        }

        int nextInt() {
            return (int) nextLong();
        }

        long nextLong() {
            try {
                int sign = 1;
                int b = input.read();
                while ((b < '0' || '9' < b) && b != '-' && b != '+') {
                    b = input.read();
                }
                if (b == '-') {
                    sign = -1;
                    b = input.read();
                } else if (b == '+') {
                    b = input.read();
                }
                long ret = b - '0';
                while (true) {
                    b = input.read();
                    if (b < '0' || '9' < b)
                        return ret * sign;
                    ret *= 10;
                    ret += b - '0';
                }
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        }

        double nextDouble() {
            try {
                double sign = 1;
                int b = input.read();
                while ((b < '0' || '9' < b) && b != '-' && b != '+') {
                    b = input.read();
                }
                if (b == '-') {
                    sign = -1;
                    b = input.read();
                } else if (b == '+') {
                    b = input.read();
                }
                double ret = b - '0';
                while (true) {
                    b = input.read();
                    if (b < '0' || '9' < b)
                        break;
                    ret *= 10;
                    ret += b - '0';
                }
                if (b != '.')
                    return sign * ret;
                double div = 1;
                b = input.read();
                while ('0' <= b && b <= '9') {
                    ret *= 10;
                    ret += b - '0';
                    div *= 10;
                    b = input.read();
                }
                return sign * ret / div;
            } catch (IOException e) {
                e.printStackTrace();
                return Double.NaN;
            }
        }

        char nextChar() {
            try {
                int b = input.read();
                while (Character.isWhitespace(b)) {
                    b = input.read();
                }
                return (char) b;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }

        String nextStr() {
            try {
                StringBuilder sb = new StringBuilder();
                int b = input.read();
                while (Character.isWhitespace(b)) {
                    b = input.read();
                }
                while (b != -1 && !Character.isWhitespace(b)) {
                    sb.append((char) b);
                    b = input.read();
                }
                return sb.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }
    // FAST SCANNER END HERE
}
