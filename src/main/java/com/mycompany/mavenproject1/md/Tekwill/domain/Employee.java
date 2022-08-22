package md.Tekwill.domain;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private Department department;
    private static int idGenerator;

    public Employee(){
       this.generateId();
    }

    public Employee(String name, String lastName){
        this();
        this.name=name;
        this.lastName=lastName;
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    private void generateId(){
        idGenerator++;
        id=idGenerator;
    }

    public void setDepartment(Department dep){
        this.department=dep;
    }
    
    public Department getDepartment(){
        return department;
    }
}
