import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String S;
    
    public static void main(String[] args) {
        S = sc.nextStr();
        N = S.length() + 1;
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<Integer>());
        }
        int[] inDegree = new int[N];
        for (int i = 0; i < N - 1; i++) {
            char c = S.charAt(i);
            if (c == '<') {
                edges.get(i).add(i+1);
                inDegree[i+1]++;
            } else {
                edges.get(i+1).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        long[] dp = new long[N];
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (queue.size() > 0) {
            int v = queue.poll();
            for (int w : edges.get(v)) {
                dp[w] = Math.max(dp[v] + 1, dp[w]);
                if (--inDegree[w] == 0) queue.offer(w);
            }
        }
        long answer = Arrays.stream(dp).sum();
        writer.println(answer);
        writer.flush();
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
