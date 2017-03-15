package freedoms.androidframework.bean;

/**
 * Created by freedoms on 2017/3/13.
 */

public class UserBean{
    private String username;
    private String password;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
