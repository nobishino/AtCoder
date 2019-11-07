import java.util.*;
import java.io.*;
public class Main{
    static Scanner sc = new Scanner(System.in);
    static int A;
    static int B;
    static int C;
    static int K;
    static int S;
    static int T;
    public static void main(String[] args) {
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        S = sc.nextInt();
        T = sc.nextInt();
        int answer = S * A + T * B;
        if (S + T >= K) answer -= (S + T) * C;
        System.out.println(answer);
    }
}