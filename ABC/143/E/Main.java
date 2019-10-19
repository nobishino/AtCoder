import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int L;
    static int Q;
    static long[][] wf;
    static long[][] ans;
    static Queue<Pair> fixed = new LinkedList<Pair>();
    static List<List<Integer>> zero;
    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        wf = new long[N][N];
        ans = new long[N][N];
        zero = new ArrayList<List<Integer>>(N);
        for (int i = 0; i < N; i++) {
            zero.add(new ArrayList<Integer>());
        }
        //inf initialize
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                wf[i][j] = Integer.MAX_VALUE;
                ans[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            wf[a][b] = wf[b][a] = c;
        }
        //wf
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    wf[i][j] = Math.min(wf[i][j], wf[i][k] + wf[k][j]);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (wf[i][j] <= L) {
                    ans[i][j] = 0;
                    ans[j][i] = 0;
                    fixed.offer(new Pair(i,j));
                    fixed.offer(new Pair(j,i));
                    zero.get(i).add(j);
                    zero.get(j).add(i);
                }
            }
        }
        while (fixed.size() > 0) {
            Pair p = fixed.poll();
            for (int k : zero.get(p.j)) {
                long newValue = ans[p.i][p.j] + 1;
                if (ans[p.i][k] > newValue) {
                    ans[p.i][k] = Math.min(ans[p.i][k], ans[p.i][p.j] + 1);
                    fixed.offer(new Pair(p.i, k));
                }
            }
        }
        Q = sc.nextInt();
        // writer.println(Q);
        //Query
        for (int i = 0; i < Q; i++) {
            int s = sc.nextInt() - 1;
            int t = sc.nextInt() - 1;
            long answer = (ans[s][t] == Integer.MAX_VALUE) ? -1 : ans[s][t];
            writer.println(answer); 
        }
        writer.flush();
        
        
    }
    static class Pair {
        public int i;
        public int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
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
