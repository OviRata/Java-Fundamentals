class new_class{
    int n;
    char c;
    float f;
    boolean b;

    public int mod3(int n){
        return n%3;
    }

    public void happy_strings(String s1, String s2){
        String s3=s1+s2;
        return;
    }

    public String wow_string(){
        String res="";
        for(int i=0; i<100; i++){
            res+="WOW!\n";
        }
        return res;
    }

    public int char_to_int(char c){
        int n=c;
        return n;
    }

    public new_class(int n, char c, float f, boolean b){
        this.n=n;
        this.c=c;
        this.f=f;
        this.b=b;
    }


    public int sum_n(int n){
        int sum=0;
        for(int i=1; i<=n; i++){
            sum+=i;
        }
        return sum;
    }

    public void even_till_n(int n){
        for(int i=0; i<n; i++){
            if( (i%2)==0){
                System.out.println(i);
            }
        }
    }


    public void hello10(){
        for(int i=1; i<=10; i++){
            System.out.println("Hello!");
        }
    }


    public void odd_till_n(int n){
        for(int i=1; i<n; i++){
            if( (i%2)==1 ){
                System.out.println(i);
            }
        }
    }

}

public class homeWork9 {
    public static void main(String args[]){

        //Exercise 1

        new_class new_obj= new new_class(100, 'a', 4.5f, true);
        System.out.println(new_obj.mod3( new_obj.n ) );
        new_obj.happy_strings("abra", "-cadabra");
        System.out.print(new_obj.wow_string());
        System.out.println(new_obj.char_to_int(new_obj.c) );

        //Exercise 2-5
        System.out.println( new_obj.sum_n(100) );
        new_obj.even_till_n(99);
        new_obj.hello10();
        new_obj.odd_till_n(100);


        return;
    }
}