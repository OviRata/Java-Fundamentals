package A;


public class A {
    private int sz;
    private String password;

     int get_sz(){
        return this.sz;
    }

    public void set_sz(int sz){
        this.sz=sz;
    }

    public void create_pass(){
        this.password="";
         char c='a';
        int pl=0;
        for(int i=1; i<=sz; i++){
            pl+=10; pl%=26;
            c=(char)('a'+pl);
            this.password=this.password+c;
        }
    }

    private String get_password() {
        return this.password;
    }

}
