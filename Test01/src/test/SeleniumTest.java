package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 

//경매장 검색
public class SeleniumTest {
 
    public static void main(String[] args) {
        SeleniumTest selTest = new SeleniumTest();
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
    
    public SeleniumTest() {
        super();
 
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
                
        //Driver SetUp
         ChromeOptions options = new ChromeOptions();
         /*
          * 창 띄우지 않고 작업하기 
          */ 
         options.addArguments("headless");
         
         options.setCapability("ignoreProtectedModeSettings", true);
         driver = new ChromeDriver(options);
        
        //처음 url
        base_url = "https://archeage.xlgames.com/auctions";
        
    }
 
    public void crawl() {
 
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
 
            //검색할 이름
            String searchKey ="흑빛";
            webElement = driver.findElement(By.name("keywordStr"));
            webElement.sendKeys(searchKey);
 
            //버튼 클릭
            webElement = driver.findElement(By.xpath("//*[@id=\"btnSearch\"]"));
            webElement.click();
            Thread.sleep(3000); //3초 기다리기
            
            //그래프 버튼 클릭
            webElement = driver.findElement(By.className("record"));
            webElement.click();
            Thread.sleep(1000); //1초 기다리기
           
            //데이터 긁어오기
            char[] crawling_result;
            crawling_result=driver.findElement(By.className("average")).getText().toCharArray();
            System.out.println(searchKey+" 검색결과> "+crawling_result[7]+"골 "
            					+crawling_result[9]+crawling_result[10]+"실 "
            					+crawling_result[12]+crawling_result[13]+"동");
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            driver.close();
        }
 
    }
 
}