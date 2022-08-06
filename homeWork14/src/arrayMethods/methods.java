package arrayMethods;

//Greseala: numele clasei publice si a fisierului incep cu majuscula


public class methods {


    public static int findNumber(int[] a, int x){
        int n=a.length;
        for(int i=0; i<=n-1; i++){
            if(a[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static int arraySum(int[] a){
        int sum=0, n=a.length;
        for(int i=0; i<=n-1; i++){
            sum+=a[i];
        }
        return sum;
    }

    public static int[] getEven(int[] a){
        int n=a.length;
        int countEven=0;

        for(int i=0; i<=n-1; i++){
            if( (a[i]%2)==0 ){
                countEven++;
            }
        }

        int[] res=new int[countEven];

        int j=0; //index for res

        for(int i=0; i<=n-1; i++){
            if( (a[i]%2)==0 ){
                res[j]=a[i];
                j++;
            }
        }

        return res;
    }


}
