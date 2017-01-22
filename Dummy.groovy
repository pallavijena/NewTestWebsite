package PageObjects

import Setup.DriverCreation
import Setup.IEventListener
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.events.EventFiringWebDriver

import java.util.concurrent.TimeUnit

/**
 * Created by Pallavi on 11/14/2016.
 */
class Dummy {
    public static void main(String[] args)
    {
        WebDriver drive;
        drive = DriverCreation.getChromeDriver()
        EventFiringWebDriver driver = new EventFiringWebDriver(drive)
        IEventListener listen = new IEventListener()
//        IAbstractWDEvent ab = new IAbstractWDEvent()
        driver.register(listen)

//        driver.register(ab)
        driver.get("https://www.gmail.com/")
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES)//PAGE
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) // Element
        driver.manage().window().maximize()
//        driver.findElement(By.partialLinkText("Gmail")).click();
        WebElement e=driver.findElement(By.name("q"));
        e.sendKeys("Minnesota")
        e.submit()

        Thread.sleep(3000)
        driver.unregister(listen)
//        driver.unregister(ab)
        driver.close()
    }
}
