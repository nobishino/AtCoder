import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int wmax = sc.nextInt();
        int w[] = new int[n];
        int v[] = new int[n];
        for (int i=0;i<n;i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        if (w[0]<=300) {
            int dp[][] = new int[n+1][303*n+1];
            for (int i=1;i<=n;i++){
                for (int weight=0;weight<=303*n;weight++){
                    int diffw = weight - w[i-1];
                    if (diffw>=0){
                        dp[i][weight] = Math.max(dp[i-1][weight],dp[i-1][diffw] + v[i-1]);
                    } else {
                        dp[i][weight] = dp[i-1][weight];
                    }
                }
            }
            System.out.println(dp[n][Math.min(wmax,303*n)]);

        } else {
            int maxn = wmax/w[0];
//            System.out.println(maxn);
            int maxr = wmax - maxn*w[0];
//            System.out.println(maxr);
            maxn = Math.min(maxn,n);
            maxr = Math.min(maxr,3*n);
            int dp[][][] = new int[n+1][n+1][3*n+1];
            //maybe initialized to 0?
            for (int i=1; i<=n; i++) {
                int diff = w[i-1]-w[0];
                for (int m=0; m<=n; m++) {
                    for (int r=0; r<=3*n; r++){
                        if (m>0 && r-diff>=0){
                            dp[i][m][r] = Math.max(dp[i-1][m][r],dp[i-1][m-1][r-diff]+v[i-1]);
                        } else {
                            dp[i][m][r] = dp[i-1][m][r];
                        }
                    }
                }
            }
            /*
            for (int i=0;i<=n;i++){
                
                System.out.println("-----");
                System.out.println(i);
                System.out.println("-----");
                for(int m=0;m<=n;m++){
                    for(int r=0;r<=3*n;r++){
                        System.out.print(dp[i][m][r]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }
            */
            System.out.println(dp[n][maxn][maxr]);
        }

    }
}