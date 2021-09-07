package framework.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private Properties environmentparameters;
    private static String propertiesfilepath = System.getProperty("user.dir")+"\\src\\main\\resources\\config";


    /**
     * Read values from properties file (EnvironmentParameters.properties)
     *
     * @param key
     * @return String
     * @throws IOException
     */

    public PropertiesReader() {

        environmentparameters = new Properties();
        try
        {
            FileInputStream filepath = new FileInputStream
                    (new File(propertiesfilepath+"\\EnvironmentParameters.properties"));
            environmentparameters.load(filepath);
            filepath.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getApplicationURL() {

        String applicationURL = environmentparameters.getProperty("ApplicationURL");
        return applicationURL;
    }

    public long getExplicitlyWait() {

        String explicitlyWait = environmentparameters.getProperty("ExplicitlyWait");
        return Long.parseLong(explicitlyWait);
    }

    public String getBrowserType() {

        String browserType = environmentparameters.getProperty("BrowserType");
        return browserType;
    }

    public String getPassword() {

        String password = environmentparameters.getProperty("Password");
        return password;
    }

}
