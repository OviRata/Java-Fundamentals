public class E {
    int id;
    String name;

    E(int id, String name){
        this.id=id;
        this.name=name;
    }

    public void newMethod(E obj){
        System.out.println(obj.id);
    }

    public void secondNewMethod(){
        newMethod(this);
        System.out.println("secondNewMethod called");
    }

}
