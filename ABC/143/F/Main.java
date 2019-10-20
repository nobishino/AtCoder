import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] a;
    static int[] C;
    static int[] D;
    static int[] E;
    static int[] G;
    static int[] f;
    
    public static void main(String[] args) {
        N = sc.nextInt();
        a = new int[N];
        C = new int[N+1];
        D = new int[N+1];
        E = new int[N+1];
        f = new int[N+2];
        G = new int[N+1];
        //Preparation for C: O(N)
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            C[a[i]]++;
        }
        //Preparation for D: O(N)
        for (int i = 0; i < N+1; i++) {
            D[C[i]]++;
        }
        //Prearation for E: O(N)
        for (int k = 1; k < N+1; k++) {
            E[k] = E[k-1] + k * D[k];
            G[k] = G[k-1] + D[k];
        }
        for (int x = 1; x < N+1; x++) {
            f[x] = G[N] - G[x] + E[x]/x;
        }
        f[0] = Integer.MAX_VALUE;
        f[N+1] = -1;
        //Binary search
        for (int t = 1; t <= N; t++) {
            int answer = binSearch(t);
            writer.println(answer);
        }
        writer.flush();
    }
    //return max x s.t f[x] >= k
    //k <- [1,N]
    static int binSearch(int k) {
        int ok = 0; //f[0] = inf
        int ng = N+1; //f[1] = -1
        while (Math.abs(ok-ng) > 1) {
            int mid = (ok + ng) / 2;
            if (f[mid] >= k) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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
