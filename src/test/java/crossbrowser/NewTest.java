package crossbrowser;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class NewTest {
	WebDriver driver;
  
	@Test(enabled=false)
  public void testcheckbox() {
	  driver.get("https://www.leafground.com/dashboard.xhtml");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	  driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"menuform:m_checkbox\"]")).click();
	  driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt89\"]/div[2]")).click();//
	  driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt91\"]/div[2]")).click();
	  driver.findElement(By.xpath("//*[@id=\"j_idt87:basic\"]/tbody/tr/td[1]/div/div[2]")).click();
	  for(int i=0;i<=3;i++) {
		  driver.findElement(By.xpath("//*[@id=\"j_idt87:ajaxTriState\"]/div[2]")).click();
	  }		  
	  driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt100\"]/div[2]")).click();
	boolean value=  driver.findElement(By.xpath("//*[@id=\"j_idt87:j_idt102\"]/div[2]")).isEnabled();
if(value==true)
{System.out.println("ceckbox is enabled");}
else{System.out.println("ceckbox is disabled");}
 driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple\"]/ul")).click();
 driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li[1]/div/div[2]")).click();
 driver.findElement(By.xpath("//*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li[2]/div/div[2]")).click();

  }
	
	@Test(priority=0)
	public void radiButton()
	{	  driver.get("https://www.leafground.com/dashboard.xhtml");
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		  driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]")).click();
		  driver.findElement(By.xpath("//*[@id=\"menuform:m_radio\"]")).click();
		   driver.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[1]/div/div[2]")).click();
		   Actions action=new Actions(driver);
		  WebElement radiobutton= driver.findElement(By.xpath("//*[@id=\"j_idt87:city2\"]/div/div[1]/div/div[2]"));
          action.doubleClick(radiobutton);
         List<WebElement> radiobuttons =driver.findElements(By.xpath("//*[@id=\"j_idt87:console2\"]//input"));
        if(radiobuttons.get(0).isSelected()) {
        	System.out.println("radio button 1 is selected by default");
        }else if(radiobuttons.get(1).isSelected())
        {        	System.out.println("radio button 2 is selected by default");
}		  else if(radiobuttons.get(2).isSelected()) {
	System.out.println("radio button 3 is selected by default");
}else {
	System.out.println("radio button 4 is selected by default");

}
        List<WebElement> radiobuttons2 =driver.findElements(By.xpath("//*[@id=\"j_idt87:age\"]//input"));
        if(radiobuttons2.get(0).isSelected()||radiobuttons2.get(1).isSelected()||radiobuttons2.get(2).isSelected()) {
        	System.out.println("Age is already selected no need to select");
        }else {		  
        	driver.findElement(By.xpath("//*[@id=\"j_idt87:age\"]/div/div[1]/div/div[2]")).click();
}
}
	
	@Test(priority=1)
	public void hyperlinkTest() throws IOException{
		driver.get("https://www.leafground.com/dashboard.xhtml");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menuform:m_link\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[1]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"menuform:j_idt40\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menuform:m_link\"]")).click();
		String URL=driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[2]/div/div/a")).getAttribute("href");
        System.out.println("url destination......  https://www.leafground.com"+URL);
        String URL2=driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[1]/div[3]/div/div/a")).getAttribute("href");
        URL url = new URL(URL2);

        HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
        httpURLConnect.setConnectTimeout(5000);
        httpURLConnect.connect();
        if(httpURLConnect.getResponseCode()>=400)
        {
        	System.out.println(URL2+" is a "+httpURLConnect.getResponseMessage()+" is a broken link");
        }    
   
        else{
            System.out.println(URL2+" is a "+httpURLConnect.getResponseMessage() +" valid link");
        }
       List<WebElement> Listofurls= driver.findElements(By.xpath("/html/body/div[1]/div[5]/div[2]//a"));
       String urltomatch= driver.findElement(By.xpath("//*[@id=\"j_idt87\"]/div/div[2]/div[1]/div/div/a")).getAttribute("href");
       int noofurls=Listofurls.size();
       int count = 0;
       for(int i=0;i<noofurls;i++) {
    	  if(urltomatch.equalsIgnoreCase(Listofurls.get(i).getAttribute("href"))) {
    		  count=count+1;
    	  }else {System.out.println("  ");}
    	  }
    	  if(count>1) {
    		  System.out.println("this is dublicate url");
    	  }else {
    		  System.out.println("this is not dublicate url");

    	  }
    	  List<WebElement>  allurlsonwebpage=driver.findElements(By.xpath("/html/body/div[1]/div[5]/div[2]//a[@href]"));
    	  int countoflinks=allurlsonwebpage.size();
    	  System.out.println("count of links are  "+countoflinks);    	  
	}  
	
	
  @Parameters("browsername")
  @BeforeTest
  public void beforeTest(String browsername) {
	  if(browsername.equalsIgnoreCase("chrome"))
	  {WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  }else if(browsername.equalsIgnoreCase("firefox"))
	  {WebDriverManager.firefoxdriver().setup();
	  driver=new FirefoxDriver();
	  }else if(browsername.equalsIgnoreCase("Edge"))
	  {WebDriverManager.edgedriver().setup();
	  driver=new EdgeDriver();
	  }
	  
  }

}
