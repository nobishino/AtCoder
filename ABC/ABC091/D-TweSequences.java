import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        int c[] = new int[n];
        int d[] = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        for(int i=0;i<n;i++) b[i]=sc.nextInt();
        int maxdigit = 29;
        int answer = 0;
        for(int k=0;k<=maxdigit;k++){
            int number = 0;
            int mod = 1<<k+1;
            for(int i=0;i<n;i++) c[i]=a[i]%mod;
            for(int i=0;i<n;i++) d[i]=b[i]%mod;
            Arrays.sort(d);
            int t = 1<<k;
            //BinarySearch for every a[i]
            for(int i=0;i<n;i++){
                //BinarySearch and add to number;
                int t1 = bsearch(t-c[i], d, n);
                int t2 = bsearch(2*t-c[i], d, n);
                int t3 = bsearch(3*t-c[i], d, n);
                int t4 = bsearch(4*t-c[i], d, n);
                number += t1-t2+t3-t4;
            }
            if (number%2==1) answer += (1<<k);
        }
        System.out.println(answer);
    }
    public static int bsearch(int lbound,int[] array,int length){
        if(array[0]>=lbound) return(length);
        if(array[length-1]<lbound) return(0);
        int ok = length-1;
        int ng = 0;
        while(ok>ng+1){
            int mid = (ok+ng)/2;
            if(array[mid]>=lbound){
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return(length-ok);
    }
}