package mail;

/**
 * @ClassName MyAuthenticator
 * @Description 认证
 * @Author zhongyang.he
 * @Date 2020/4/18 22:19
 **/
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {
    private String username = null;
    private String password = null;

    public MyAuthenticator() {
    };

    public MyAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

}
