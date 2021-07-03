package main.java.Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer extends BaseClass implements IRetryAnalyzer {

    private int count = 0;
    private static int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult)  {
        while(count<maxTry){
            count++;
            return true;
        }
        return false;
    }

}