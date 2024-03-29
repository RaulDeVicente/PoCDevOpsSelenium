package junit;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

public class CalculadoraTest {
	private WebDriver driver;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		// Cargar el webdriver definido como parametro de entrada en la ejecucion
		try {
			if (System.getProperty("webdriver.edge.driver") != null && System.getProperty("webdriver.edge.driver").length()>0) {
				
				File tempFile = new File(System.getProperty("webdriver.edge.driver"));
				if(tempFile.exists()) {			
					driver = new EdgeDriver();
				}else {
					System.out.println();
					System.out.println("ERROR: El driver indicado no existe (" + System.getProperty("webdriver.edge.driver") + ")");
				}
			}else if (System.getProperty("webdriver.chrome.driver") != null && System.getProperty("webdriver.chrome.driver").length()>0) {
				
				File tempFile = new File(System.getProperty("webdriver.chrome.driver"));
				if(tempFile.exists()) {			
					driver = new ChromeDriver();
				}else {
					System.out.println();
					System.out.println("ERROR: El driver indicado no existe (" + System.getProperty("webdriver.chrome.driver") + ")");
				}
			} else {
				System.out.println("ERROR: No se ha definido un webdriver");
			}
			js = (JavascriptExecutor) driver;
		}catch (Exception e) {
			System.out.println("Error configurando el webdriver: " + e.getMessage());
		}
	}

	@After
	public void tearDown() {
		try {
			driver.quit();
		}catch (Exception e) {
			System.out.println("Error al cerrar el webdriver " + e.getMessage());
		}
		
	}

	@Test
	public void Suma1y2multi3() {
		// driver.get("http://10.99.104.217:9081/ProsaPortal7/index.jsp");
		try {
			driver.get(
					"http://" + System.getProperty("host") + ":" + System.getProperty("port") + "/ProsaPortal7/index.jsp");
			driver.manage().window().setSize(new Dimension(1038, 684));
	
			driver.findElement(By.id("ui-accordion-accordion-header-1")).click();
			Duration duration = Duration.ofSeconds(10);
			WebDriverWait wait = new WebDriverWait(driver, duration);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("configuracionIntranetDSServicio")));
			driver.findElement(By.id("configuracionIntranetDSServicio")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("codSilcon")));
			driver.findElement(By.id("codSilcon")).sendKeys("IDUS7143");
			driver.findElement(By.id("codSilcon")).sendKeys(Keys.ENTER);
	
			try {
				driver.findElement(By.id("INTRANETDS_SERVICIO")).click();
	
			} catch (Exception e) {
				driver.findElement(By.id("ui-accordion-accordion-header-1")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("INTRANETDS_SERVICIO")));
				driver.findElement(By.id("INTRANETDS_SERVICIO")).click();
			}
	
			driver.findElement(By.id("INTRANETDS_SERVICIO")).sendKeys("XV23VC01");
			driver.findElement(By.id("submitIntranetDSServicio")).click();
			driver.findElement(By.id("sum1")).sendKeys("1");
			driver.findElement(By.id("sum2")).click();
			driver.findElement(By.id("sum2")).sendKeys("2");
			driver.findElement(By.id("multi")).click();
			driver.findElement(By.id("multi")).sendKeys("3");
			driver.findElement(By.id("SPM.ACC.CALCULAR1")).click();
			driver.findElement(By.id("res1")).click();
			{
				String value = driver.findElement(By.id("res1")).getAttribute("value");
				assertEquals(value, "10");
			}
		}catch (Exception e) {
			System.out.println("Error al generar el test " + e.getMessage());
			assertTrue("Test marcado como fail debido a una excepci�n durante la ejecuci�n", false);
		}
	}

	@Test
	public void Suma1y2multi4() {
		// driver.get("http://10.99.104.217:9081/ProsaPortal7/index.jsp");
		try{
			driver.get(
					"http://" + System.getProperty("host") + ":" + System.getProperty("port") + "/ProsaPortal7/index.jsp");
			driver.manage().window().setSize(new Dimension(1038, 684));
	
			driver.findElement(By.id("ui-accordion-accordion-header-1")).click();
			Duration duration = Duration.ofSeconds(10);
			WebDriverWait wait = new WebDriverWait(driver, duration);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("configuracionIntranetDSServicio")));
			driver.findElement(By.id("configuracionIntranetDSServicio")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("codSilcon")));
			driver.findElement(By.id("codSilcon")).sendKeys("IDUS7143");
			driver.findElement(By.id("codSilcon")).sendKeys(Keys.ENTER);
	
			try {
				driver.findElement(By.id("INTRANETDS_SERVICIO")).click();
	
			} catch (Exception e) {
				driver.findElement(By.id("ui-accordion-accordion-header-1")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("INTRANETDS_SERVICIO")));
				driver.findElement(By.id("INTRANETDS_SERVICIO")).click();
			}
	
			driver.findElement(By.id("INTRANETDS_SERVICIO")).sendKeys("XV23VC01");
			driver.findElement(By.id("submitIntranetDSServicio")).click();
			driver.findElement(By.id("sum1")).sendKeys("1");
			driver.findElement(By.id("sum2")).click();
			driver.findElement(By.id("sum2")).sendKeys("2");
			driver.findElement(By.id("multi")).click();
			driver.findElement(By.id("multi")).sendKeys("4");
			driver.findElement(By.id("SPM.ACC.CALCULAR1")).click();
			driver.findElement(By.id("res1")).click();
			{
				String value = driver.findElement(By.id("res1")).getAttribute("value");
				assertEquals(value, "13");
			}
		}catch (Exception e) {
			System.out.println("Error al generar el test " + e.getMessage());
			assertTrue("Test marcado como fail debido a una excepci�n durante la ejecuci�n", false);
		}
	}
}
