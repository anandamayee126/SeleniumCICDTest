package myPackage;

import java.io.File;
//import utils.ExcelUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.v138.filesystem.model.File;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableKeywords extends Locators
{

	public static WebDriver driver;
	WebDriverWait wait;
	WebElement element;
	JavascriptExecutor js;
	Actions action;
	public static Workbook workbook;
	public static Sheet sheet;
	
	//method name= openBrowser
   //parameter or argument= null
	//return= WebDriver
	public static WebDriver openBrowser() throws Exception {
		if(browser=="chrome") {
			System.setProperty("WebDriver.chrome.driver",chromeDriverPath);
			driver= new ChromeDriver();
		}
		driver.get(url);
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ultraShortDelay));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	//method name= click
	//parameter or argument= String(xpath/locator)
	//return= null or void
	public void click(String locator) throws Exception{
		driver.findElement(By.xpath(locator)).click();
	
	}
	
	//method name= inputText
	//parameter or argument= String(xpath/locator) and String(Text)
	//return= null or void	
	public void inputText(String locator, String text) throws Exception{
		click(locator);
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(text);
		
	}
	
	//method name= closeBrowser
	//parameter or argument= null
	//return= null or void		
	public void closeBrowser() throws Exception{
		driver.quit();
//		driver.close();
	}
	
	//method name= visibleOfElement
	//parameter or argument= String locator and int time
	//return= null or void	
	public void visibleOfElement(String locator, int time) throws Exception{
		wait= new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		
		
	}
	
	//method name= invisibleOfElement
	//parameter or argument= String locator and int time
	//return= null or void	
	public void invisibleOfElement(String locator, int time) throws Exception{
		wait= new WebDriverWait(driver,Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}
	
	//method name= elementPresent
	//parameter or argument= String locator
	//return= boolean
	public boolean elementPresent(String locator) {
		try {
			driver.findElement(By.xpath(locator));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	//method name= selectByText
	//parameter or argument= String locator and String text
	//return= void
	public void selectByText(String locator, String text) throws Exception{      // https://demowebshop.tricentis.com/books?orderby=6
		Select dropdown = new Select(driver.findElement(By.cssSelector(locator)));
		dropdown.selectByVisibleText(text);
	}
	
	//method name= selectByIndex
	//parameter or argument= String locator and int index
	//return= void
	public void selectByIndex(String locator, int index) throws Exception{      // https://demowebshop.tricentis.com/books?orderby=6
		Select dropdown = new Select(driver.findElement(By.xpath(locator)));
		dropdown.selectByIndex(index);
	}
	
	//method name= selectByValue
	//parameter or argument= String locator and String value
	//return= void
	public void selectByValue(String locator, String value) throws Exception{      // https://demowebshop.tricentis.com/books?orderby=6
		Select dropdown = new Select(driver.findElement(By.xpath(locator)));
		
		dropdown.selectByValue(value);
//		dropdown.deselectByValue(value);
	}
	
	//method name= navigateToURL
	//parameter or argument= String tempURL
	//return= void
	public void navigateToURL(String tempURL) throws Exception{
//		System.out.println("Hello");
		driver.navigate().to(tempURL);
	
	}
	
	//method name= getText
	//parameter or argument= String locator
	//return= String
	public String getText(String locator) throws Exception{
		String tempText= driver.findElement(By.xpath(locator)).getText();
		return tempText;
	}
	
	//method name= scrollToElement
	//parameter or argument= int x, int y
	//return= void
	public void scrollToElement(int x, int y) {
		js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")","");
	}
	
	//method name= switchToFrame
	//parameter or argument= String locator
	//return= void
	public void switchToFrame(String locator) throws Exception{
		element = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(element);
		//driver.switchTo().frame(0);
	}
	
	//method name= javaScriptClick
	//parameter or argument= String locator
	//return= void
	public void javaScriptClick(String locator) throws Exception {
		element = driver.findElement(By.xpath(locator));
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		
	}
	
	//method name= rightClick
	//parameter or argument= String locator
	//return= void
	public void rightClick(String locator)throws Exception {
		element= driver.findElement(By.xpath(locator));
		 action= new Actions(driver);
		 action.contextClick(element).perform();
	} 
	
	//method name= doubleClick
	//parameter or argument= String locator
	//return= void	
	public void doubleClick(String locator)throws Exception {
		element= driver.findElement(By.xpath(locator));
		 action= new Actions(driver);
		 action.doubleClick(element).perform();
	} 

	//method name= mouseHover
	//parameter or argument= String locator
	//return= void	
	public void mouseHover(String locator) throws Exception{
		element= driver.findElement(By.xpath(locator));
		action= new Actions(driver);
		action.moveToElement(element).perform();
	}

	//method name= keyPress
	//parameter or argument= String locator, String Text
	//return= void	
	public void keyPress( String locator, String text) throws Exception{
		
		driver.findElement(By.xpath(locator)).sendKeys(Keys.chord(Keys.CONTROL, text));
	}
	
	
	public void captureSS(String filename) throws IOException{
	   LocalDateTime now = LocalDateTime.now();
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
	   String currentDateTime= now.format(dtf);
	   
	   TakesScreenshot ts= (TakesScreenshot) driver;
	   File sourceFile= ts.getScreenshotAs(OutputType.FILE);
	   File destinationFile= new File(ssPath+currentDateTime+filename);
	   FileUtils.copyFile(sourceFile,destinationFile);
	   
	}
	
	public String excelRead(String sheetName, int rowNum, int colNum) throws Exception{
//		ExcelUtils.setExcelFile();
		FileInputStream fis= new FileInputStream(new File(excelPath));
		workbook= new XSSFWorkbook(fis);  // for opening excel
		
		sheet= workbook.getSheet(sheetName); // choosing the sheet 
		
		Cell c= sheet.getRow(rowNum).getCell(colNum); // to get the cell value
		DataFormatter format = new DataFormatter(); // to make the cell value readable
		fis.close();
		return format.formatCellValue(c);
		
		
	}
	public void excelWrite(String sheetName, int rowNum, int colNum, String text) throws Exception{
		FileInputStream fis= new FileInputStream(new File(excelPath));
		workbook= new XSSFWorkbook(fis); 
		sheet= workbook.getSheet(sheetName);
		fis.close();
		Row row= sheet.getRow(rowNum);
		if(row==null) {
			row=sheet.createRow(rowNum);
			
		}
		Cell cell=row.getCell(colNum);
		if(cell==null) {
			cell=row.createCell(colNum);
		}
		cell.setCellValue(text);
		FileOutputStream fos= new FileOutputStream(new File(excelPath));
		workbook.write(fos);
		fos.close();
	}
	//method name= logout
	//parameter or argument= String locator
	//return= void	
	public void logout(String locator) throws Exception {
		click(profileDD);
		click(locator);
	}
}
