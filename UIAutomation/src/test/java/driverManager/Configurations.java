package driverManager;

import java.io.FileInputStream;
import java.util.Properties;

import static constants.ResourcesConstants.*;

public class Configurations {
    private static Properties configProp;

    public void onPrepare() {
        configProp=configProp==null?new Properties():configProp;

        try {
            FileInputStream fileInputStream = new FileInputStream(PROPERTIESFILE);
            configProp.load(fileInputStream);
        }
        catch (Exception e){
            throw new RuntimeException("Unable to read the config properties file " + PROPERTIESFILE);
        }
    }

    public static Properties getConfigProp() {
        return configProp;
    }

    public static void setConfigProp(Properties configProp) {
        Configurations.configProp = configProp;
    }
}
