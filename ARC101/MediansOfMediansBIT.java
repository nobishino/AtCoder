import java.util.*;

class Main {
    public static void main(String[] args) {
        solve();
    }
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int maxim = 1000000001;

        int ans = bSearch(0, maxim, a);
        
        System.out.println(ans);      
    }
    
    /*
    条件を満たすxの最大値をにぶたんで求める
    */
    public static int bSearch(int ok,int ng,int[] numbers){
        if(ng == ok + 1){
            return(ok);
        } else {
            int mid = (ok+ng)/2;
            if(judge(mid, numbers)) {
                return(bSearch(mid, ng, numbers));
            } else {
                return(bSearch(ok, mid, numbers));
            }
        }
    }

    public static boolean judge(int x, int[] numbers){
        /*
        int xが条件を満たすかどうか判定する
        条件：x以上のmedian yが半数以上存在する
        */
        int n = numbers.length;
        return(true);
    }
}
