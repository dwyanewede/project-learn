package sun.net.www.protocol.classpath;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @ClassName: Handler
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2018/12/11 17:58
 * @Version: 1.0
 */
public class Handler extends URLStreamHandler {

    private final String URL_PREFIX = "classpath:/";

    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        String str = url.toString();
        String urlStr = str.substring(URL_PREFIX.length());
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(urlStr);
        return resource.openConnection();
    }
}
