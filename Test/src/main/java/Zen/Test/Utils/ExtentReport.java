package Zen.Test.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Date;

public class ExtentReport {
	
	static ExtentReports extent;
	
	public static ExtentReports ExtentreportGenerator() {
		Date d = new Date();
		String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		String Path=System.getProperty("user.dir")+"/Reports/"+fileName;
		ExtentSparkReporter reporter =new ExtentSparkReporter(Path);
		reporter.config().setDocumentTitle("TBG Automation Results");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		reporter.config().setReportName("Collaterate Automation Tests");
		reporter.config().setEncoding("utf-8");
		reporter.config().setCss("css-string");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", ReadYamlConfig.getbrowser().toUpperCase());
		extent.setSystemInfo("Organization", "The Bernard Group");
		extent.setSystemInfo("Tester", "VIJAYA");

		return extent;
	}
}
