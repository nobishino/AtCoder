import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] s = new long[n+1];
        for(int i=1;i<n+1;i++){
            s[i] = s[i-1] + sc.nextInt();
        }
        long answer = 100000000;
        answer *= answer;
        for(int m=2;m<n-1;m++){
            long[] x = binarySearch(1, m, s);
            long[] y = binarySearch(m+1, n, s);
            long a = x[0];
            long b = x[1];
            long c = y[0];
            long d = y[1];
            long candidate = Math.max(b,d)-Math.min(a,c);
            answer = Math.min(candidate,answer);
        }
        System.out.println(answer);
    }
    public static long[] binarySearch(int left, int right, long[] array){
        double s = (double) (array[right]-array[left-1]);
        double half = s/2;
        int ok = right;
        int ng = left - 1 ;
        while(ok>ng+1){
            int mid = (ok+ng)/2;
            if (array[mid]-array[left-1] >= half) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        double dOk = Math.abs((double) (array[ok]-array[left-1]) -half);
        double dNg = Math.abs((double) (array[ng]-array[left-1]) -half);
        long x;
        long y;
        if (dOk < dNg) {
            x = array[ok]-array[left-1];
            y = array[right]-array[ok];
        } else {
            x = array[ng]-array[left-1];
            y = array[right]-array[ng];
        }
        long [] answer = new long[2];
        answer[0] = Math.min(x,y);
        answer[1] = Math.max(x,y);
        return(answer);
    }
}