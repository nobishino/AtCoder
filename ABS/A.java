import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int ans = 0;
        int r = k/2;
        int q = k%2;
        if (q==0) 
            ans = r * r;
        else
            ans = (r+1) * r;
        System.out.println(ans);

        sc.close();
    }
}
