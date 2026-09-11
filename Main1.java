import java.util.Scanner;

public class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the number of rows: ");
        n = sc.nextInt();
        int a[][] = new int[n][];
        int m;
        for(int i=0;i<n;i++){
            System.out.print("Enter the number of columns for row "+i+": ");
            m = sc.nextInt();
            a[i] = new int[m];
            for(int j=0;j<m;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            System.out.print("a : "+i+"\t");
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();

        }
    }
}
