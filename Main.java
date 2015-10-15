package com.netger;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;


public class Main {

    public static void main(String[] args) {
        // write your code here

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.0");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("deviceName", "iPhone 6 Plus");
        //capabilities.setCapability("app", "/Users/artemtsai/Development/ios_examples/iOS-Samples-master/InternationalMountains/build/Debug-iphonesimulator/InternationalMountains.app");

        capabilities.setCapability("app", "/Users/artemtsai/Development/hms_iOS.app");



        RemoteWebDriver wd;

        try {
            wd = new RemoteWebDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);


            int depth = 3;
            int j = 1;
            int i = 4;

            boolean dir = false;

            while (true)
            {
                ++i;
                int z = i % depth;

                if (z == 0) {

                    if (true == dir)
                    {
                        if (10 == depth) depth = 2;

                        ++depth;

                        --i;
                    }

                    dir = !dir;
                    ++i;
                    continue;

                }


                if (dir == true) j = depth - z;
                else j = z;

                String path = String.format("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[%d]/UIAStaticText[1]", j);


                wd.findElement(By.xpath(path)).click();

                HashMap<String, Double> script = new HashMap<String, Double>();
                script.put("tapCount", 1.0);
                script.put("touchCount", 1.0);
                script.put("duration", 0.5);
                script.put("x", 66.0);
                script.put("y", 87.0);

                wd.executeScript("mobile: tap", script);
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
