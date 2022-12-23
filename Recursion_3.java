public class n5{
    public static double func (double a) {
        return Math.cos (Math.pow (a, 5)) + Math.pow (a, 4) - 345.3 * a - 23;
    }
    public static double Solve(double left, double right) {
        double m = (left + right) / 2;
        if (right - left < 0.001) {
            return m;
        }
        if (func(m) < 0) {
            return Solve(m, right);
        }
        return Solve(left, m);
    }

    public static void main(String []args){
        System.out.println(Solve(0, 10));
    }
}
