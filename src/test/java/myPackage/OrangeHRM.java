package myPackage;

import org.testng.annotations.*;

public class OrangeHRM extends ReusableKeywords {

	@Test
	public void launch() throws Exception {
		String value=excelRead("Sheet1", 0, 0);
		System.out.println(value);
		
		excelWrite("Sheet2", 0, 0, "Anandamayee");
		
	}
	
	
//	@BeforeTest
//	public void launchApp() throws Exception {
//		openBrowser();
//		
//	}
//	
//	@Test(priority=1)
//	public void login() throws Exception{
//		inputText(username, user);
//		inputText(password, userPass);
//		captureSS("loginSS.png");
////		rightClick(loginButton);
//		click(loginButton);
//		visibleOfElement(profileDD, shortDelay);
//		boolean status= elementPresent(profileDD);
//		if(status) {
//			System.out.println("Logged in successfully");
//		}
//		else {
//			System.out.println("Log in failed");
//		}
//	}
//	@Test(priority=2)
//	public void performanceTabFunc() throws Exception{
//		System.out.println("Hi");
//		visibleOfElement(performanceTab,10);
////		System.out.println("Hi");
//		click(performanceTab);
//		inputText(performanceEmployeeName, "Andy");
//		Thread.sleep(2000);
//		keyPress(performanceEmployeeName,"a");
//		Thread.sleep(5000);
//		keyPress(performanceEmployeeName,"x");
//		
//		Thread.sleep(5000);
//		System.out.println("Performance tab func passed");
//		
//	}
//	
//	@Test(priority=3)
//	public void reviewTabFunc()throws Exception{
//		visibleOfElement(reviewStatusDD, 10);
//		click(reviewStatusDD);
//		Thread.sleep(2000);
//		doubleClick(reviewStatusDD);
//		Thread.sleep(10000);
//		mouseHover(performanceTab);
//		Thread.sleep(10000);
//	}
////	
////	@Test
////	public void dropdown() throws Exception {  // diff website
////		selectByValue(booksSortBy, "https://demowebshop.tricentis.com/books?orderby=5");
////		selectByIndex(booksView, 1);
////		selectByText(booksDisplay, "12");
////		Thread.sleep(5000);
////	}
////	
//	@Test (priority=4)
//	public void getText() throws Exception {  // unable to change the tab
//		click(DashboardBtn);
//		String value=getText(dashboard);
//		System.out.println(value);
//	}
////	
//	@Test (priority=5)
//	public void scrollElement() {            
//		scrollToElement(0,250);
//	}
//	
//	@Test (priority=6)
//	public void logout() throws Exception {  // instantly getting logged out
//		logout(logoutButton);
//		Thread.sleep(3000);
//	}
//
//	@AfterTest
//	public void closeApp() throws Exception{
////		logout(logoutButton);
//		closeBrowser();
//	}
	
	
}


