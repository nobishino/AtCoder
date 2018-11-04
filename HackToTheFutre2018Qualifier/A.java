import java.util.*;

class Main {
    Random rdm = new Random(12739124);
    int[][] ans = new int[1000][3];
    Scanner sc = new Scanner(System.in);
    final static int N=100, row=100, col=100, anum=1000;
    int[][] map = new int[row][col];

    void input() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[j][i] = sc.nextInt();
            }
        }
    }
    void output() {
        System.out.println(ans.length);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i][0] + " " + ans[i][1] + " " + ans[i][2]);
        }
    }
    void init(){
        for(int i=0;i<anum;i++){
            ans[i][0]=rdm.nextInt(100);
            ans[i][1]=rdm.nextInt(100);
            ans[i][2]=rdm.nextInt(100)+1;
        }
    }
    void solve() {
        input();
        init(); 
        output();
    }
    public static void main(String[] args){
        new Main().solve();
    }

}