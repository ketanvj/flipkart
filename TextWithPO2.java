package scripts.orangePOAlternate1;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TextWithPO2 {
	
	OrangeHRM orangeHRM;
	 @Test
	  public void OrangeHRM() throws InterruptedException {
		
		  //Call the method.
		  orangeHRM.login("Admin","admin123");
		  String expectedTitle = "OrangeHRM";
		  String actualTitle = orangeHRM.getTitleAfterLogin();
		  assertEquals(actualTitle,expectedTitle);
	  }
	  
		@BeforeClass	
		public void beforeClass() {
			
			//Create an object of class(stcTourismHomePage.
			orangeHRM = new OrangeHRM();	
	  }

	  
	  @AfterClass
	  public void afterClass() {
		  orangeHRM.closebrowser();
	  }  

}
