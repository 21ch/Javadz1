public class n3{
    public static void recurs (int n){
        if (n == 1) {
            System.out.print("1 ");
        }
        else{
            recurs(n - 1);
        }
        System.out.print(n + " ");

    }
    public static void main(String []args){
        recurs(10);
    }
}
