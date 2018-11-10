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
    static int x=14;
    static int y=14;
    static int dx=0;
    static int dy=1;
    static int score;
    public static void main(String[] args){
        input();
        init();
        solve();
        output();
    }
    public static void init(){
        score = simulate();
    }
    public static void solve(){
        for (int i=0;i<m-2;i++){
            for(int j=0;j<m-2;j++){
                bulk[i][j] = rnd.nextInt(6); //0-5 integer
            }
        }
        int newscore = simulate();
        if (newscore < score){
            bulk = new int[m-2][m-2];
        }
    }
    public static int simulate(){
        int[][] count = new int[m-2][m-2];
        for (int i=0;i<n;i++){
            x = 14;
            y = 14;
            dx = 0;
            dy = 1;
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
        return(score);
    }
    public static void instruction(char c){
        int r;
        switch (c) {
            case 'S':
                int nx = x+dx;
                int ny = y+dy;
                if(nx<0||nx>=m-2|ny<0|ny>=m-2){
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
}

