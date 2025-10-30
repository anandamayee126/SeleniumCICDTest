package myPackage;

public class Locators extends UserData{

	String loginButton="//button[contains(@class,\"orangehrm-login-button\")]";
	
	String username="//input[@name=\"username\"]";
    String password="//input[@name=\"password\"]";
    String profileDD="//li[@class=\"oxd-userdropdown\"]";
    String logoutButton="//a[@class=\"oxd-userdropdown-link\" and text()=\"Logout\"]";
    
    String booksSortBy= "//select[@name=\"products-orderby\"]"; //https://demowebshop.tricentis.com/books?orderby=6
    String booksDisplay="select[id=\"products-pagesize\"]"; //https://demowebshop.tricentis.com/books?orderby=6
    String booksView="//select[@name=\"products-viewmode\"]"; //https://demowebshop.tricentis.com/books?orderby=6
    String dashboard="//h6[text()=\"Dashboard\"]";
    String DashboardBtn="//span[text()='Dashboard']";
    String performanceTab="//a[@href=\"/web/index.php/performance/viewPerformanceModule\"]";
    String reviewStatusDD="//label[text()=\"Review Status\"]/../..//i";
    String performanceEmployeeName= "//input[@placeholder=\"Type for hints...\"]";
}
