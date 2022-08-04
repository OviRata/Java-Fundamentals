public class D {
    int id;
    String name;

    D(int id){
        this.id=id;
        this.name="";
    }

    D(String name){
        this(5);
        this.name=name;
    }

    D(){
        this.name="A";
    }

    D(boolean b){
        this("D>C");
    }

}
