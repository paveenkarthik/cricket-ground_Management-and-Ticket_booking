
import Model.getDBConnection;
import views.User1;

public class App {
    public static void main(String args[]) throws Exception{
        try{
            getDBConnection.getConnection();
        //   System.out.println("Connected");
        }
        catch(Exception e){

            System.out.println("NOT CONNNECTED");
            System.out.println(e);
        }
       User1 H=new User1();
       H.toSignUpLogin();
        
    }
}
