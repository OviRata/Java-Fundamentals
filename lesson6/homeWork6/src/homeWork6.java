
import java.util.*;

public class homeWork6{
    public static void main( String[] arguments){
        int v;
        Scanner sc =  new Scanner(System.in);
        System.out.println("OK");
        v=sc.nextInt();


        if( (v%2)==0 && v > 10 ){
            System.out.println("Numarul este par.");
        }
        if( (v<15) && ( (v%2)==1) ){
            System.out.println("Numarul este impar.");
        }
    }
}
