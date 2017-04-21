package mvc;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class MvcMain {

    public static void main(String[] args) {
        User user = retriveStudentFromDatabase();
        UserView userView = new UserView();
        UserController userController = new UserController(user, userView);

        userController.updateView();
        userController.setUserName("jihun2");
        userController.updateView();
    }



    public static User retriveStudentFromDatabase() {
        return new User("jihunim", "1234", "jihun@jihun.com");
    }



}
