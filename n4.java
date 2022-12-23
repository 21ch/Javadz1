import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
public class n4{
    public static void search1 (int[] A, int x){
        boolean res = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == x) {
                System.out.println(i + " " + A[i]);
                res = false;
            }
        }
        if (res)
            System.out.println("Элемент не найден");
    }

    public static void binsearch (int[] A, int x){
        int left = 0;
        int right = A.length;
        while (left + 1 < right){
            int m = (left + right) / 2;
            if (A[m] > x){
                right = m;
            }
            else {
                left = m;
            }
        }
        if (A[left] == x){
            System.out.println(left + " " + A[left]);
        }
        else {
            System.out.println("Элемент не найден");
        }
    }

    public static int[] Massive_creator (int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(-100, 100);
        }
        return arr;
    }
    public static void main(String []args){
        int[] a = new int[100];
        a = Massive_creator(100);
        search1(a, 0);
        System.out.println("Бинпоиск:");
        Arrays.sort(a);
        binsearch(a, 32);
    }
}