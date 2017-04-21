package mvc;

/**
 * Created by jihun.im on 2017-04-21.
 */
public class UserController {
    User user;
    UserView userView;

    public UserController(User user, UserView userView) {
        this.user = user;
        this.userView = userView;
    }

    public void setUserName(String name) {
        user.setName(name);
    }

    public String getUserName() {
        return user.getName();
    }

    public void setUserEmail(String email) {
        user.setEmail(email);
    }

    public String getUserEmail() {
        return user.getEmail();
    }

    public void setUserPassword(String password) {
        user.setName(password);
    }

    public void updateView() {
        userView.printUserDetails(user.getName(), user.getEmail());
    }

}
