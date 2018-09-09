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
        MyPair msort = invNum(cums);
        invNumber = msort.value;
        if(invNumber <= half) {
            return(true);
        } else {
            return(false);
        }
    }

    //left, rightはそれぞれソート済み
    private static MyPair merge(int[] left, int[] right){
        int l = left.length;
        int r = right.length;
        int i = 0;
        int j = 0;
        int ansValue = 0;
        int[] ansList = new int[l+r];
        int index = 0;
        while(i < l && j < r){
            if(left[i] <= right[j]) {
                ansList[index] = left[i];
                i++;
            } else {
                ansList[index] = right[j];
                j++;
                ansValue += l-i;
            }
            index++;
        }
        while(i < l){
            ansList[index] = left[i];
            index++;
            i++;
        }
        while(j < r){
            ansList[index] = right[j];
            index++;
            j++;
        }
        MyPair ans = new MyPair();
        ans.list = ansList;
        ans.value = ansValue;
        return(ans);
    }

    private static MyPair invNum(int[] numbers) {
        int l = numbers.length;
        MyPair ans = new MyPair();
        
        //基底部
        if(l <= 1){
            ans.value = 0;
            ans.list = numbers;
            return(ans);
        }
        // l>=2の場合は分割統治
        int half = l/2;
        int[] left = new int[half];
        int[] right = new int[l-half];
        for(int i=0;i<l;i++) {
            if(i < half){
                left[i]=numbers[i];
            } else {
                right[i-half]=numbers[i];
            }
        }
        MyPair leftP = invNum(left);
        MyPair rightP = invNum(right);
        MyPair mergeP = merge(leftP.list,rightP.list);
        ans.list = mergeP.list;
        ans.value = leftP.value + rightP.value + mergeP.value;
        return(ans);
    }
  }

class MyPair{
    public int value;
    public int[] list;
}