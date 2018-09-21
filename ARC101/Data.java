import java.util.*;

class Main{
    public static void main(String[] args){
        Random rdm = new Random();
        int n = 100000;
        int maxim = 1000000000;
        System.out.println(n);
        for(int i=0;i<n;i++){
            System.out.print(rdm.nextInt(maxim-1)+1);
            System.out.print(" ");
        }
    }
  }

