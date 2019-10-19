import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] L;
    public static void main(String[] args) {
        N = sc.nextInt();
        L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
        }
        Arrays.sort(L);
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                answer += count(i,j);
            }
        }
        // answer /= 3;
        writer.println(answer);
        writer.flush();

    }
    static boolean within(int x, int left, int right) {
        return x >= left && right >= x;
    }

    static int count(int i, int j) {
        int a = L[i];
        int b = L[j];
        int R = less(a+b);
        int L = lessEq(Math.abs(a-b));
        int left = Math.max(L+1, j+1);
        int ans = Math.max(R-left+1,0);
        return Math.max(0,ans);
    }

    //maximum indice that L[i] <= upper
    //maximum indice that L[i] < upper
    static int less(int upper) {
        if (L[0] >= upper) return -1;
        if (L[N-1] < upper) return N-1;
        int ok = 0;
        int ng = N-1;
        while(Math.abs(ok-ng) > 1) {
            int mid = (ok+ng)/2;
            if (L[mid] < upper) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }
    static int lessEq(int upper) {
        if (L[0] > upper) return -1;
        if (L[N-1] <= upper) return N-1;
        int ok = 0;
        int ng = N-1;
        while(Math.abs(ok-ng) > 1) {
            int mid = (ok+ng)/2;
            if (L[mid] <= upper) {
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
