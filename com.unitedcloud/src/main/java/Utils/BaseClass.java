package main.java.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.base.CaseFormat;
import main.java.Pages.Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseClass implements  Waiter{

    public static WebDriver driver;
    public static ThreadLocal<String>testPlatform = new ThreadLocal<>();
    private final String fs = File.separator;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;

    /**
     * Getter Method for the Platform that is set using setPlaform()method
     * @return
     */
    public static Platform getPlatform(){
        try{
            return Platform.valueOf(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, testPlatform.get()));
        }catch (NullPointerException e){
            return null;
        }
    }

    /**
     * Setter Method for the Platform the Test is intended to run on
     * In "setup()" Method, set the platform based on the Groups present on the Test
     */
    protected void setPlatform(ITestResult iTestResult) {
        String[] testGroups = iTestResult.getMethod().getGroups();
        String platform = Platform.WEB_DESKTOP.toString();
        testPlatform.set(platform);
    }

    /**
     * Setter Method for the Driver
     * By default, Chrome WebDriver will be used
     */
    public void setDriver(String browserName){

            if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + fs + "drivers" + fs + "chromedriver.exe");
            driver = new ChromeDriver();
        }else {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + fs + "drivers" + fs + "chromedriver.exe");
                driver = new ChromeDriver();
            }
    }

    @BeforeTest
    public void beforeTest(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + fs + "reports" + fs + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Test Done By", "Marko Zdravkovic");

    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(@Optional("Chrome") String browserName, Method testMethod, ITestResult iTestResult){
        LoginPage loginPage = new LoginPage();
        logger = extent.createTest(testMethod.getName());
        setPlatform(iTestResult);
        setDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.Login_Page);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.loginUser(Constants.Username, Constants.Password);
        waitImplicit(5000);
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, m);
        }else if(result.getStatus()==ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test case: " + methodName + " failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest(){
        extent.flush();
    }
}
