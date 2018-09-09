import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int ans;
        if(k%2==0) {
            ans = (k/2)*(k/2);
        } else {
            ans = (k/2)*(k/2 + 1);
        }
        System.out.println(ans);

        sc.close();
    }
}