public class B {

    public static String multiply(String S, int n){
        String res="";
        for(int i=1; i<=n; i++){
            res=res+S;
        }
        return res;
    }

    public static int multiply(int a, int b){
        return a*b;
    }

    public static String add(String A, String B){
        return A+B;
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static String modulo(String A, int m){
        int n=A.length();
        String res="";
        for(int i=n-1-(n%m)+1; i<n; i++ ){
            res+=A.charAt(i);
        }
        return res;
    }

    public static int modulo(int a, int m){
        return a%m;
    }

}
