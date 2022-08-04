public class C {
    int id;
    String name;

    C(int id){
        this.id=id;
        this.name="";
    }

    C(String name){
        this.name=name;
        this.id=0;
    }

    C(int id, String name){
        this.id=id;
        this.name=name;
    }

    C(){
        this.id=0;
        this.name="";
    }

}
