package mail;

/**
 * @ClassName AutoMail
 * @Description 发送邮件入口
 * @Author zhongyang.he
 * @Date 2020/4/18 22:18
 **/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import base.ReadProperties;

public class AutoMail {
    public static void main(String[] args) throws  IOException {
        MailInfo mailInfo = new MailInfo();
        String sendTo[] = readMail("sendto");
        String cclist[] = readMail("cc");

        mailInfo.setMailServerHost(ReadProperties.getprop("mail", "MailServerHost"));
        mailInfo.setMailServerPort(ReadProperties.getprop("mail", "MailServerPort"));
        mailInfo.setValidate(true);
        mailInfo.setUsername(ReadProperties.getprop("mail", "Username"));
        mailInfo.setPassword(ReadProperties.getprop("mail", "Password"));// 您的邮箱密码
        mailInfo.setFromAddress(ReadProperties.getprop("mail", "FromAddress"));
        mailInfo.setToAddress(sendTo);
        mailInfo.setSubject(ReadProperties.getprop("mail", "Subject"));
        mailInfo.setCcAddress(cclist);

//        读取overview.html内容
        String mailcontent = ReadHtml.readString("./target/surefire-reports/html/overview.html");
//        读取reportng.css内容
        String cssvalue=ReadHtml.readString("./target/surefire-reports/html/reportng.css");
//        把读取的内容拼接成一个css样式头
        String changestr="<style type=\"text/css\">h1 {display : inline}"+cssvalue+"</style>";
//        替换填充overview.html中的样式
        mailcontent=mailcontent.replace("<link href=\"reportng.css\" rel=\"stylesheet\" type=\"text/css\" />", changestr);
//        定义overview.html中标题样式
        String logostr="<h1 style=\"color:red ; font-size:50px;font-family: '楷体','楷体_GB2312';\">MAVEN_DEMO</h1><h1>自动化测试报告</h1>";
//        替换overview.html中标题样式
        mailcontent=mailcontent.replace("<h1>Test Results Report</h1>", logostr);
//        把邮件正文放到mailInfo里
        mailInfo.setContent(mailcontent);
        SendMail.sendHtmlMail(mailInfo);// 发送html格式邮件

    }
    public static String[] readMail(String mailtype) throws IOException {

        int i=0;
        Properties props = new Properties();
        props.load(new FileInputStream("./target/test-classes/properties/"+mailtype+".properties"));
        String[] mailto = new String[props.size()];

        for(Enumeration enu=props.elements();enu.hasMoreElements();)
        {
            String key = (String)enu.nextElement();

            mailto[i]=key;
            i++;
        }
        return mailto;
    }

}
