package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//네이버 검색 로그인
public class NaverTest {
 
    public static void main(String[] args) {
    	NaverTest selTest = new NaverTest();
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
    
    public NaverTest() {
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
        base_url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%95%84%ED%82%A4%EC%97%90%EC%9D%B4%EC%A7%80";
    }
 
    public void crawl() {
 
        try {
            //get page (= 브라우저에서 url을 주소창에 넣은 후 request 한 것과 같다)
            driver.get(base_url);
 
            /*
             * 
             */
            //공식 사이트 누르기
            webElement = driver.findElement(By.xpath("//*[@id=\"main_pack\"]/div[3]/div[2]/div[1]/div[2]/div[2]/dl[1]/dd[3]/a[1]"));
            webElement.click();
            Thread.sleep(10000); //1초 기다리기
            
            /*
            //로그인 버튼 클릭
             */
            webElement = driver.findElement(By.xpath("//*[@id=\"__4\"]/a"));
            webElement.click();
            Thread.sleep(1000); //1초 기다리기

            //아이디 입력
            String id="ces227@daum.net";
            webElement = driver.findElement(By.id("id_field"));
            webElement.sendKeys(id);
            Thread.sleep(1000); //1초 기다리기
            
            //비밀번호 입력
            String pw = "kalia!97";
            webElement = driver.findElement(By.id("pw_field"));
            webElement.sendKeys(pw);
            
            //로그인버튼 누르기
            webElement = driver.findElement(By.id("loginButton"));
            webElement.click();
            Thread.sleep(1000); //1초 기다리기
            
            //@@@여기서 오류
            //이벤트 로고 누르기
            webElement = driver.findElement(By.xpath("//*[@id=\"__4\"]/a"));
            webElement.click();
            Thread.sleep(1000); //1초 기다리기
            
            //ifram 으로 전환
            driver.switchTo().frame(driver.findElement(By.id("eventFrame")));
            
            //선물받기 클릭하기
            webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/a[3]"));
            webElement.click();
            
            //확인버튼 누르기
            webElement = driver.findElement(By.id("okBtn"));
            webElement.click();
            Thread.sleep(1000); //1초 기다리기
            
            
            //ifram 으로 전환
            driver.switchTo().frame(driver.findElement(By.id("eventFrame")));
            
            //선물받기 클릭하기
            webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/a[3]"));
            webElement.click();
            
            
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            //driver.close();
        }
 
    }
 
}