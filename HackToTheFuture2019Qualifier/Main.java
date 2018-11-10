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
    static int dx=-1;
    static int dy=0;
    static int score;
    static int[][] countTable = new int[m-2][m-2];
    static final long timeLimit = 2500;
    static long startTime;
    static long endTime;
    static long repetition=1;
    public static void main(String[] args){
        startTime = System.currentTimeMillis();
        endTime = startTime + timeLimit;
        input();
        init();
        solve();
        //output();
        printCount();
        System.out.println(score);
    }
    public static void init(){
        score = simulate().score;
    }
    public static void solve() {
        while(System.currentTimeMillis() < endTime){
            deviate();
        }
    }
    public static void randomOrEmpty(){
        for (int i=0;i<m-2;i++){
            for(int j=0;j<m-2;j++){
                bulk[i][j] = rnd.nextInt(6); //0-5 integer
            }
        }
        int newscore = simulate().score;
        if (newscore < score){
            bulk = new int[m-2][m-2];
        }
    }
    public static void deviate(){
        repetition++;
        int i = rnd.nextInt(m-2);
        int j = rnd.nextInt(m-2);
        int currentBulk = bulk[i][j];
        int nextBulk = rnd.nextInt(6);
        while(nextBulk==currentBulk) nextBulk = rnd.nextInt(6);
        bulk[i][j] = nextBulk;
        Pair newPair = simulate();
        int newScore = newPair.score;
        int[][] ct = newPair.ctable;
        if (newScore > score){
            score = newScore;
            countTable = ct;
        } else {
            bulk[i][j] = currentBulk;
        }
    }
    public static Pair simulate(){
        int[][] count = new int[m-2][m-2];
        for (int i=0;i<n;i++){
            x = 13;
            y = 13;
            dx = -1;
            dy = 0;
            //static String[] dict = {".","D","T","L","R","#"};
            for(int j=0;j<l;j++){
                switch (bulk[x][y]) {
                    case 0:
                        instruction(inst[i].charAt(j));
                        break;
                    case 1:
                        instruction(inst[i].charAt(j));
                        instruction(inst[i].charAt(j));
                        break;
                    case 2:
                        instruction(inst[i].charAt(j));
                        instruction(inst[i].charAt(j));
                        instruction(inst[i].charAt(j));
                        break;
                    case 3:
                        if (inst[i].charAt(j)=='R') {
                            //System.out.println("R!");
                            instruction('L');
                        } else {
                            instruction(inst[i].charAt(j));
                        }
                        break;
                    case 4:
                        if (inst[i].charAt(j)=='L') {
                            instruction('R');
                        } else {
                            instruction(inst[i].charAt(j));
                        }
                        break;
                    default:
                        System.out.println("ERROR");
                        break;

                }
            }
            count[x][y]+=1;
        }
        int score=0;
        for(int i=0;i<m-2;i++){
            for(int j=0;j<m-2;j++){
                switch(count[i][j]){
                    case 1:
                        score += 10;
                        break;
                    case 2:
                        score += 3;
                        break;
                    case 3:
                        score += 1;
                        break;
                    default:
                        break;
                }
            }
        }
        return(new Pair(score,count));
    }
    public static void instruction(char c){
    //static String[] dict = {".","D","T","L","R","#"};
        int r;
        switch (c) {
            case 'S':
                int nx = x+dx;
                int ny = y+dy;
                if((nx<0)|(nx>=m-2)|(ny<0)|(ny>=m-2)){
                    break;
                } else {
                    if(bulk[nx][ny]==5) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    break;
                }
            case 'L':
                r = dy;
                dy = dx;
                dx = -r;
            case 'R':
                r = dy;
                dy = -dx;
                dx = r;
            default:
                break;
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