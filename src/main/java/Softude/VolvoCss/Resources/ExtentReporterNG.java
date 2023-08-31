package Softude.VolvoCss.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getExtentReportObjct() {
		String path=System.getProperty("user.dir")+"//Reports//"+"index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Css Automation Report");
		reporter.config().setDocumentTitle("Css Report");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA","Pushpendra Singh");
		return extent;
		}
}
