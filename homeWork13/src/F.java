public class F {

    int id;
    String name;

    public F newMethod(){
        return new F();
    }

    public F secondNewMethod(){
        return this;
    }

}
