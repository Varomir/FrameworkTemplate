package core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    protected static final Logger LOG = LoggerFactory.getLogger(Config.class);
    private static Properties properties;
    private static String resourceFile = "/project.properties";

    private static void loadProperties() {
        properties = new Properties();
        InputStream in = Config.class.getResourceAsStream(resourceFile);

        try {
            properties.load(in);
            in.close();
        } catch (Exception e) {
            LOG.error("Unable to read resource file", e.getMessage());
        }
    }

    public static String getProperty(String propertyName) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(propertyName);
    }

    public static String getBaseURL(){
        return getProperty("test.baseURL");
    }
}
