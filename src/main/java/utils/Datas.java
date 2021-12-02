package utils;

import com.google.common.io.Resources;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Datas {

    public static List<String> fromResourceAsList(String resourceName) {
        try {
            URL url = Resources.getResource(resourceName);
            return Resources.readLines(url, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
