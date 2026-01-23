import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++){
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        System.out.println("Day vua nhap la: ");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        int dem = 0;
        for(int x : a){
            if(x % 2 == 0){
                dem++;
            }
        }
        System.out.println("\nMang co: " + dem + " so chan");

        int tong = 0;
        for(int x : a){
            tong += x;
        }
        System.out.println("Mang co tong la: "+ tong);

        int max = a[0];
        for(int x : a){
            if(x > max){
                max = x;
            }
        }
        System.out.println("Max cua mang vua nhap la: " + max);

        sc.close();
    }
}
