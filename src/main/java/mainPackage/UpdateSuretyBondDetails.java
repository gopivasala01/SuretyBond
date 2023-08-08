package mainPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateSuretyBondDetails 
{
	public static boolean updateDetails() throws Exception
	{
		try
		{
		RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
        RunnerClass.driver.findElement(Locators.summaryEditButton).click();
        
        Thread.sleep(2000);
		RunnerClass.js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//Surety Bond Policy Number
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.SuretyBondPolicyNumber)).build().perform();
		RunnerClass.driver.findElement(Locators.SuretyBondPolicyNumber).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.SuretyBondPolicyNumber).sendKeys(RunnerClass.policyNumberAggregated);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Policy Number";
		}
		
		//Surety Bond Policy Number
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondPurchaser)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondPurchaser).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondPurchaser).sendKeys(RunnerClass.renterFullName);
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Purchaser";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondStatus)).build().perform();
		Select status = new Select(RunnerClass.driver.findElement(Locators.suretyBondStatus));
		status.selectByVisibleText(RunnerClass.policyStatus);
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Status";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondAmount)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondAmount).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondAmount).sendKeys(RunnerClass.coverageAmount);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Amount";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondExpirationDate)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondExpirationDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondExpirationDate).sendKeys(RunnerClass.coverageEndDate);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Expiration Date";
		}
		
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondClaimFiledDate)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondClaimFiledDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondClaimFiledDate).sendKeys(RunnerClass.claimSubmittedDate);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Amount Claimed";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondAmountClaimed)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondAmountClaimed).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondAmountClaimed).sendKeys(RunnerClass.submittedAmount);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Amount Claimed";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondSettlementAmount)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondSettlementAmount).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondSettlementAmount).sendKeys(RunnerClass.payOutAmount);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Settlement Amount";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondDateSettlementReceived)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondDateSettlementReceived).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondDateSettlementReceived).sendKeys(RunnerClass.claimPaidAt);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Date Settlement Received";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondClaimDueDate)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondClaimDueDate).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondClaimDueDate).sendKeys(RunnerClass.claimDueDate);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Claim Due Date";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondClaimNumber)).build().perform();
		RunnerClass.driver.findElement(Locators.suretyBondClaimNumber).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		RunnerClass.driver.findElement(Locators.suretyBondClaimNumber).sendKeys(RunnerClass.claimNumberAggregated);						
		}
		catch(Exception e)
		{
			e.printStackTrace();
			RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Claim Number";
		}
		
		//Surety Bond Status
		try
		{
		RunnerClass.actions.moveToElement(RunnerClass.driver.findElement(Locators.suretyBondClaimStatus)).build().perform();
		Select status = new Select(RunnerClass.driver.findElement(Locators.suretyBondClaimStatus));
		status.selectByVisibleText(AppConfig.getClaimStatus(RunnerClass.claimStatus));
								
		}
		catch(Exception e)
		{
			e.printStackTrace();
		    RunnerClass.failedReason = RunnerClass.failedReason+", Surety Bond Claim Status";
		}
		return true;
		}
		catch(Exception e)
		{
			RunnerClass.failedReason = "Issue in updating fields";
			return false;
		}
		
	}

}
