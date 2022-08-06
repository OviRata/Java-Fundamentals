import static arrayMethods.methods.*;


public class test {

    public static void main(String[] args){

        System.out.println(findNumber( new int[] {1, 2, 3, 4, 5 }, 4) );

        System.out.println(arraySum(  new int[] {1, 2, 3, 4, 5 }  ) );

        System.out.println( getEven( new int[] {1, 2, 3, 4, 5 } )[0] );

        int[] arr=getEven( new int[] {1, 2, 3, 4, 5 } );
        for(int i=0; i<=arr.length-1; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }

    }

}
