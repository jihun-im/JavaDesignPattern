package mvc;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class UserView {
    public void printUserDetails(String name, String email) {
        System.out.println("----------------------");
        System.out.println("additional information");
        System.out.println("Student name : " + name + ", email : " + email);
        System.out.println("----------------------");
    }
}
