import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static String S;
    
    public static void main(String[] args) {
        S = sc.nextStr();
        int N = S.length();
        k = sc.nextInt();
        int splitIndex = split(S);
        long answer = 0;
        if (splitIndex == -1) {
            answer = (N/2) * k;
        } else {
            String head = S.substring(0, splitIndex);
            String tail = S.substring(splitIndex);
            String tailHead = tail + head;
            long headCnt = calc(head);
            long tailCnt = calc(tail);
            long tailHeadCnt = calc(tailHead);
            answer = headCnt + tailCnt + (k - 1) * tailHeadCnt;
        }
        writer.println(answer);
        writer.flush();
    }

    //s should not be ""
    static int split(String s) {
        char head = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != head) return i;
        }
        return -1;
    }

    static long calc(String s) {
        char prev = '?';
        long count = 1;
        long answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prev) {
                count++;
            } else {
                answer += count/2;
                count = 1;
                prev = c;
            }
        }
        answer += count/2;
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
