package Zen.Test.Utils;
import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.Assert;
import org.testng.Reporter;

public class Log {
    private static Logger log;

    public static void initLogCfg() {
        String rootPath = System.getProperty("user.dir");
        PropertyConfigurator.configure(rootPath + File.separator +
            "src/main/java/Zen/Test/Utils/log4j.properties");
        log = Logger.getLogger("TraceLog");
    }

    public static void debug(String msg) {
        Log.initLogCfg();
        log.info(msg);
        Reporter.log(msg + "<br/>");
    }

    public static void pass(String msg) {
        Log.initLogCfg();
        log.info(msg);
        Reporter.log("<font color='green' >" + msg + "</font><br/>");
    }

    public static void info(String msg) {
        Log.initLogCfg();
        log.info(msg);
        Reporter.log(msg + "<br/>");
    }

    public static void warn(String msg) {
        Log.initLogCfg();
        log.warn(msg);
        Reporter.log("<font color='orange'>" + msg + "</font><br/>");
    }

    public static void fail(String msg) {
        Log.initLogCfg();
        log.error(msg);
        Reporter.log("<font color='red'>" + msg + "</font><br/>");
        Assert.assertFalse(true, "The Test case is failed");
    }
}
