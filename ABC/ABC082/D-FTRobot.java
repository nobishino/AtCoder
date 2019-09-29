import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int x = sc.nextInt();
        int y = sc.nextInt();
        boolean dirx = true;
        int[] a = new int[8000];
        int[] b = new int[8000];
        int aindex=0;
        int bindex=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='F') {
                sum++;
            } else {
                if(dirx) {
                    a[aindex] = 2*sum;
                    aindex++;
                    x+=sum;
                    sum=0;
                    dirx = false;
                } else {
                    b[bindex] = 2*sum;
                    bindex++;
                    y+=sum;
                    sum=0;
                    dirx = true;
                }
                sum = 0;
            }
        }
        //last remainder
        if(sum>0){
            if(dirx){
                a[aindex] = 2*sum;
                aindex++;
                x+=sum;
            } else {
                b[bindex] = 2*sum;
                bindex++;
                y+=sum;
            }
        }
        boolean xans;
        boolean yans;
        x -= a[0];
        if (aindex==1){
            xans = x==0;
        } else {
            if(x<0){
                xans = false;
            } else {
                boolean[][] xdp = partialSumDP(a, aindex, x,1);
                xans = xdp[aindex-1][x];
            }
        }
        if(y<0){
            yans = false;
        } else {
            boolean[][] ydp = partialSumDP(b, bindex, y,0);
            yans = ydp[bindex][y];
        }

        if(xans & yans) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static boolean[][] partialSumDP(int[] series,int length, int maxsum, int startindex){
        boolean dp[][] = new boolean[length+1-startindex][maxsum+1];
        dp[0][0] = true;
        for(int i=1;i<length+1-startindex;i++){
            for(int s=0;s<maxsum+1;s++){
                if(s-series[i-1+startindex]>=0) {
                    dp[i][s] = dp[i-1][s] | dp[i-1][s-series[i-1+startindex]];
                } else {
                    dp[i][s] = dp[i-1][s];
                }
            }
        }
        return(dp);
    }
}