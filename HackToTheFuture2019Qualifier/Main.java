import java.util.*;

class Main{
    //variables
    static Scanner sc = new Scanner(System.in);
    static int n=500; //500 # of instruction series
    static int m=29; //29 board size
    static int l=300; //300 length of instruction serires
    static String[] inst = new String[n];
    static int[][] bulk = new int[m-2][m-2];
    static String[] dict = {".","D","T","L","R","#"};
    static Random rnd = new Random(20181110);
    static int x=13;
    static int y=13;
    static int score;
    static int[][] countTable = new int[m-2][m-2];
    static final long timeLimit = 2500;
    static long startTime;
    static long endTime;
    public static void main(String[] args){
        startTime = System.currentTimeMillis();
        endTime = startTime + timeLimit;
        input();
        init();
        solve();
        output();
        //printCount();
//        System.out.println(score);
    }
    public static void init(){
      //  Pair p = simulate();
        score = simulate();
     //   countTable = p.ctable;
    }
    public static void solve() {
        while(System.currentTimeMillis() < endTime){
            deviate();
        }
    }
    public static void deviate(){
        int i = rnd.nextInt(m-2);
        int j = rnd.nextInt(m-2);
        int currentBulk = bulk[i][j];
        int nextBulk = rnd.nextInt(6);
        while(nextBulk==currentBulk) nextBulk = rnd.nextInt(6);
        bulk[i][j] = nextBulk;
        //Pair newPair = simulate();
        //int newScore = newPair.score;
        int newScore = simulate();
        if (newScore > score){
            score = newScore;
            //countTable = newPair.ctable;
        } else {
            bulk[i][j] = currentBulk;
        }
    }
    //static String[] dict = {".","D","T","L","R","#"};
    public static int simulate(){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        int[][] count = new int[m-2][m-2];
        for (int i=0;i<n;i++){
            x = 13;
            y = 13;
            int dir = 2;
            for (int j=0;j<l;j++){
                char move = inst[i].charAt(j);
                if(move == 'S'){
                    int tmp=1;
                    if(bulk[x][y]==1) {
                        tmp=2;
                    } else if(bulk[x][y]==2){
                        tmp=3;
                    }
                    for(int k=0;k<tmp;k++){
//                        System.out.println(dir);
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if((nx<0|ny<0|nx>=m-2|ny>=m-2)){
                            break;
                        } else {
                            if(bulk[nx][ny]==5) {
                                break;
                            }
                        }
                        x = nx;
                        y = ny;
                    }
                } else if(move == 'L'){
                    int bn = bulk[x][y];
                    if(bn==1){
                        dir = rotation(dir,2);
                    } else if(bn==2){
                        dir = rotation(dir,3);
                    } else if(bn==4){
                        dir = rotation(dir,-1);
                    } else {
                        dir = rotation(dir,1);
                    }
                } else {
                    int bn = bulk[x][y];
                    if(bn==1){
                        dir = rotation(dir,-2);
                    } else if(bn==2){
                        dir = rotation(dir,-3);
                    } else if(bn==3){
                        dir = rotation(dir,1);
                    } else {
                        dir = rotation(dir,-1);
                    }
                }
            }
        count[x][y]++;
        }
        int score = evaluate(count);
        return(score);
        //return(new Pair(score,count));
    }
    public static int evaluate(int[][] c){
        int s = 0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<m-2;j++){
                int num = c[i][j];
                if(num==1){
                    s += 10;
                } else if(num==2){
                    s += 3;
                } else if(num==3){
                    s += 1;
                } else {
                    //
                }
            }
        }
        return(s);
    }
    public static int rotation(int v,int w){
        int ans = v+w;
        if (ans > 3){
            return(ans-4);
        } else if (ans < 0){
            return(ans+4);
        } else {
            return(ans);
        }
    }
    public static void input(){
        n = sc.nextInt();
        m = sc.nextInt();
        l = sc.nextInt();
        for(int i=0;i<n;i++){
            inst[i]=sc.next();
        }

    }
    public static void output(){
    //static String[] dict = {".","D","T","L","R","#"};
        for (int j=0;j<m;j++){
            System.out.print("#");
        }
        System.out.println();
        for (int i=0;i<m-2;i++){
            System.out.print("#");
            for (int j=0;j<m-2;j++){
                System.out.print(dict[bulk[i][j]]);
            }
            System.out.print("#");
            System.out.println();
        }
        for (int j=0;j<m;j++){
            System.out.print("#");
        }
        System.out.println();
    }
    public static void printCount(){
        int sum=0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<m-2;j++){
                System.out.print(countTable[i][j]);
                System.out.print(',');
                sum+=countTable[i][j];
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}

class Pair{
    public int score;
    public int[][] ctable;
    public Pair(int s, int[][] c){
        this.score=s;
        this.ctable = c;
    }
}