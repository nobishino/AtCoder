import java.util.*;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int maxA = 100000;
        int count[] = new int[maxA];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            count[a[i]]++;
        }
        int kind = 0;
        int even = 0;
        for(int i=1;i<maxA;i++) {
            int c = count[i];
            if (c > 0) {
                kind++;
                if (c%2==0){
                    even++;
                }
            }
        }
        int answer;
        if (even%2==0){
            answer = kind;
        } else {
            answer = kind-1;
        }
        System.out.println(answer);
    }
}