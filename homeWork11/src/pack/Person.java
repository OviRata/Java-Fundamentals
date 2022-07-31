package pack;

public class Person {

    static int cr;
    int id;
    String firstName, lastName;

    public Person(String argFirst, String argLast){
        cr++;
        id=cr;
        firstName=argFirst;
        lastName=argLast;
    }

    public int getId(){
        return id;
    }

}
