package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
//캐릭+서버로 검색
public class SearchTest {
 
    public static void main(String[] args) {
    	SearchTest selTest = new SearchTest();
        selTest.crawl();
        
    }
 
    
    //WebDriver
    private WebDriver driver;
    
    private WebElement webElement;
    
    //Properties
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    //웹 드라이버 깔려있는 주소
    public static final String WEB_DRIVER_PATH = "D:/CES/selenium/chromedriver.exe";
    
    //크롤링 할 URL
    private String base_url;
    
    public SearchTest() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
                
        //Driver SetUp
         ChromeOptions options = new ChromeOptions();
         /*
          * 창 띄우지 않고 작업하기 
         options.addArguments("headless");
          */ 
         
         options.setCapability("ignoreProtectedModeSettings", true);
         driver = new ChromeDriver(options);
        
        //처음 url
        String searchKey="포하";
        String server = "NUI";
        base_url = "https://archeage.xlgames.com/search?dt=characters&keyword="+searchKey+"&subDt=&server="+server;
    }
 
    public void crawl() {
 
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
 
            //첫번째로 찾은 캐릭터 누르기
            webElement = driver.findElement(By.className("lst"));
            webElement.findElement(By.tagName("a"));
            
       
            
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            //driver.close();
        }
 
    }
 
}