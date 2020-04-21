package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName ReadProperties
 * @Description TODO
 * @Author zhongyang.he
 * @Date 2020/4/21 23:14
 **/
public class ReadProperties {


    public static String getprop(String filename, String folder,String propname) throws FileNotFoundException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("./test-classes/properties/"+folder+"/"+filename+".properties"));
        String str = props.getProperty(propname);
        return str;

    }




}
