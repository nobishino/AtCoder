import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int P;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges[i] = new Edge(a - 1, b - 1, - c + P);
        }
        int ans;
        int[] distance = new int[N];
        int INF = Integer.MAX_VALUE/2;
        for (int i = 1; i < N; i++)  distance[i] = INF;
        for (int i = 0 ; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge e = edges[j];
                distance[e.end] = Math.min(distance[e.end], distance[e.start] + e.cost);
            }
            // writer.println(Arrays.toString(distance));
        }
        ans = distance[N-1];
        for (int j = 0; j < M; j++) {
            Edge e = edges[j];
            distance[e.end] = Math.min(distance[e.end], distance[e.start] + e.cost);
        }
        // writer.println(Arrays.toString(distance));
        ans = ans == distance[N-1] ? Math.max(0,-ans) : -1;
        writer.println(ans);
        writer.flush();
    }

    static class Edge {
        public int start;
        public int end;
        public int cost;
        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
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
                    if (b < '0' || '9' < b) return ret * sign;
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
                    if (b < '0' || '9' < b) break;
                    ret *= 10;
                    ret += b - '0';
                }
                if (b != '.') return sign * ret;
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
    //FAST SCANNER END HERE
}
