public class FactorialAssert{

    public static int fac(int n){
        assert n <= 16 : "Lo sentimos, numero muy grande";
        if(n==0)
            return 1;
        return n * fac(n-1);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println("Fac(" + n + "): " + fac(n));    
    }
}