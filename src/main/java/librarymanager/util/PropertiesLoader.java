package librarymanager.util;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class PropertiesLoader {

    public static Properties loadProperties() throws IOException {

        Properties properties = new Properties();
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream("application.properties");
        properties.load(inputStream);
        inputStream.close();
        return properties;
    }
}
