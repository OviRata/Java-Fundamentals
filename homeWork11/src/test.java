import pack.Person;

public class test {


    public static void main(String args[]){
        Person myObj1=new Person("Ovidiu", "Rata");
        Person myObj2=new Person("Alexandru", "Jizdan");
        System.out.println(myObj1.getId()+"\n"+myObj2.getId());
        //All good
    }

}
