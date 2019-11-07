import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] a;
    
    public static void main(String[] args) {
        N = sc.nextInt();
        a = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            a[i] = sc.nextInt();
        }
        List<List<Integer>> divider = new ArrayList<List<Integer>>(N+1);
        for (int i = 0 ; i < N+1; i++) divider.add(new ArrayList<Integer>());
        for (int i = 1; i <= N; i++) {
            int multiple = i * 2;
            while(multiple <= N) {
                divider.get(multiple).add(i);
                multiple += i;
            }
        }
        writer.println(divider.toString());
        int[] values = new int[N+1];
        List<Integer> answer = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            int parity = 0;
            for (int v : divider.get(i)) {
                parity += values[v];
            }
            parity += a[i];
            parity %= 2;
            values[i] = parity;
            if (parity == 1) answer.add(i);
        }
        int M = answer.size();
        writer.println(Arrays.toString(values));
        writer.println(M);

        for (int ans : answer) {
            writer.print(ans);
            writer.print(" ");
        }
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
