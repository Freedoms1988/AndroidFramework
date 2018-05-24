package freedoms.androidframework.bean;

/**
 * @Class UserBean
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/

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
