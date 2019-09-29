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
        int cumsum = 0;
        long m = n;
        long intervals = m*(m+1)/2;
        long half = intervals/2;
        long y = 0;
        BIT bit = new BIT(2*n+1);
        bit.add(n+1,1);
        for(int i = 0; i<n; i++){
            if(numbers[i]>=x){
                cumsum++;
            } else {
                cumsum--;
            }
            y += bit.sum(cumsum+n+1);
            bit.add(cumsum+n+1,1);
        }
        return(y >= intervals - half);
    }
}

class BIT {
    private int[] values;
    private int length;

    public BIT(int length) {
        this.length = length;
        values = new int[length+1];
    }

    public void add(int location, int value){
        for(int x = location; x <= this.length; x += x & -x){
            values[x] += value;
        }
    }

    public int sum(int right){
        int ans = 0;
        for(int x = right; x > 0; x -= x & -x){
            ans += values[x];
        }
        return ans;
    }

    public int sum(int left, int right){
        if(left > 1)
            return(sum(right)-sum(left-1));
        else
            return(sum(right));
    }
}