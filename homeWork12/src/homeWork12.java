public class homeWork12 {

    public static String invert(String arg){
        String res="";
        for(int i=(arg.length())-1; i>=0; i--){
            res=res+arg.charAt(i);
        }
        return res;
    }



}
