import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        sc.close();


        int ans = 1;
        
        System.out.println(ans);

        
    }
    
    /*
    条件を満たすxの最大値をにぶたんで求める
    */
    public static int bSearch(int ok,int ng,int[] numbers, int n){
        return 1;
    }

    public static boolean judge(int x, int[] numbers, int n){
        /*
        int xが条件を満たすかどうか判定する
        条件：x以上のmedian yが半数以上存在する
        */
        int[] cums = new int[n+1];
        cums[0] = 0;
        for(int i=0;i<n;i++){
            if(numbers[i] >= x) {
                cums[i+1] = cums[i] + 1;
            } else {
                cums[i+1] = cums[i] - 1;
            }
        }
        //転倒数が全区間数の半分以下
        int half = (n+1)*n/4;
        int invNumber = 0;
        //invNumber = invNum(cums);
        if(invNumber <= half) {
            return(true);
        } else {
            return(false);
        }
    }

 

    


    
}

class MyPair{
    public int value;
    public int[] list;
}

