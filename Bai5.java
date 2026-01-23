import java.util.Scanner;

public class Bai5 {
    /*public static void main(String[] args) {
        for(int i = 1; i < 10; i++) {
            System.out.println(i);
        }
    }
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap vao 1 so nguyen: ");
        int n = sc.nextInt();

        for(int i = 1; i <= 10; i++){
            System.out.println(n + "*" + i + " = " + (n * i));
        }

        sc.close();
    }
}
