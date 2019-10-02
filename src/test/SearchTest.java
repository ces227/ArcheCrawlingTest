package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
//캐릭+서버로 검색
public class SearchTest {
 
    public static void main(String[] args) {
    	SearchTest selTest = new SearchTest("포하","NUI");
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
    
    public SearchTest() { }
    
    public SearchTest(String nickname,String server) {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
                
        //Driver SetUp
         ChromeOptions options = new ChromeOptions();
         
         //창 띄우지 않고 작업하기
         options.addArguments("headless");
         
         //왜인지 모르겠지만 사이즈를 지정해줘야 headless로 했을때 오류가 안뜸..
         options.addArguments("window-size=1920x1080");
         
         //뭔지모름
         options.setCapability("ignoreProtectedModeSettings", true);
         
         
         driver = new ChromeDriver(options);
        
        //처음 url
        base_url = "https://archeage.xlgames.com/search?dt=characters&keyword="+nickname+"&subDt=&server="+server;
    }
 
    public void crawl() {
 
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
 
            //첫번째로 찾은 캐릭터 누르기
            webElement = driver.findElement(By.className("lst"));
            webElement=webElement.findElement(By.tagName("a"));
            System.out.println(webElement.getText());
            webElement.click();
            webElement=driver.findElement(By.className("score"));
            System.out.println(webElement.getText());
       
            
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            //driver.close();
        }
 
    }
 
}