import java.util.Scanner;

public class Bai11 {
    public static void nhapMang(int[] a, Scanner sc){
        for(int i = 0; i < a.length; i++){
            System.out.print("a[" + (i + 1) + "]: ");
            a[i] = sc.nextInt();
        }
        System.out.println();
    }

    public static void inMang(int[] a){
        for(int x : a){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int minMang(int[] a){
        int min = a[0];
        for(int x : a){
            if(x < min) min = x;
        }
        return min;
    }

    public static void kiemTraso(int[] a){
        int am = 0, duong = 0, khong = 0;
        for(int x : a){
            if(x < 0) am ++;
            else if(x > 0) duong ++;
            else khong ++;
        }
        System.out.println("Day co " + am + " so am");
        System.out.println("Day co " + duong + " so duong");
        System.out.println("Day co " + khong + " so 0");
    }

    public static float TBC(int[] a){
        int tong = 0;
        for(int x : a) tong += x;
        return (float) tong / a.length;
    }

    public static void soLonHonTBC(int[] a, float tbc){
        for(int x : a){
            if(x > tbc){
                System.out.print(x + " ");
            }
        }
        System.out.println();
    }

    public static void daoNguocMang(int[] a){
        for(int i = a.length - 1; i >= 0; i--){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void sapXepTang(int[] a){
        for(int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap gia tri cua mang: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        nhapMang(a, sc);

        System.out.println("Mang vua nhap la: ");
        inMang(a);

        int min = minMang(a);
        System.out.println("Min cua mang vua nhap la: " + min);

        kiemTraso(a);

        float tbc = TBC(a);
        System.out.println("Trung binh cong cua day la: " + tbc);

        System.out.println("Cac so lon hon TBC la: ");
        soLonHonTBC(a, tbc);

        System.out.println("Mang sau khi dao nguoc la: ");
        daoNguocMang(a);

        sapXepTang(a);
        System.out.println("Mang sau khi sap xep tang dan la: ");
        for(int x : a){
            System.out.print(x + " ");
        }

        sc.close();
    }
}
