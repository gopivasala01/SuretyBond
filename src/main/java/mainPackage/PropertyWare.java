package mainPackage;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyWare 
{
	public static boolean initiateBrowser()
	{
		try
		{
		RunnerClass.downloadFilePath = AppConfig.downloadFilePath;
		Map<String, Object> prefs = new HashMap<String, Object>();
	    // Use File.separator as it will work on any OS
	    prefs.put("download.default_directory",
	    		RunnerClass.downloadFilePath);
        // Adding cpabilities to ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
        RunnerClass.driver= new ChromeDriver(options);
        RunnerClass.driver.manage().window().maximize();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean signIn()
	{
		try
		{
		RunnerClass.driver.get(AppConfig.URL);
        RunnerClass.driver.findElement(Locators.userName).sendKeys(AppConfig.username); 
        RunnerClass.driver.findElement(Locators.password).sendKeys(AppConfig.password);
        Thread.sleep(2000);
        RunnerClass.driver.findElement(Locators.signMeIn).click();
        Thread.sleep(3000);
        RunnerClass.actions = new Actions(RunnerClass.driver);
        RunnerClass.js = (JavascriptExecutor)RunnerClass.driver;
        RunnerClass.driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(2));
        try
        {
        if(RunnerClass.driver.findElement(Locators.loginError).isDisplayed())
        {
        	System.out.println("Login failed");
			return false;
        }
        }
        catch(Exception e) {}
        RunnerClass.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(100));
        return true;
		}
		catch(Exception e)
		{
			System.out.println("Login failed");
			return false;
		}
	}
	/*
	public static boolean selectLease()
	{
	
		
		try
		{
			RunnerClass.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(100));
	        RunnerClass.driver.navigate().refresh();
	        PropertyWare.intermittentPopUp();
	        //if(PropertyWare.checkIfBuildingIsDeactivated()==true)
	        	//return false;
	        RunnerClass.driver.findElement(Locators.marketDropdown).click();
	        String marketName = "HomeRiver Group - "+RunnerClass.company;
	        Select marketDropdownList = new Select(RunnerClass.driver.findElement(Locators.marketDropdown));
	        marketDropdownList.selectByVisibleText(marketName);
	        Thread.sleep(3000);
	        String buildingPageURL = AppConfig.buildingPageURL+RunnerClass.leaseEntityID;
	        RunnerClass.driver.navigate().to(buildingPageURL);
	        if(PropertyWare.permissionDeniedPage()==true)
	        {
	        	System.out.println("Wrong Lease Entity ID");
	        	RunnerClass.failedReason = "Wrong Lease Entity ID";
	        	return false;
	        }
	        PropertyWare.intermittentPopUp();
	        if(PropertyWare.checkIfBuildingIsDeactivated()==true)
	        	return false;
	        
	        return true;
	        /*
	        String buildingAddress = RunnerClass.driver.findElement(Locators.buildingTitle).getText();
	        if(buildingAddress.toLowerCase().contains(RunnerClass.address.substring(0,RunnerClass.address.lastIndexOf(" ")).toLowerCase()))
	        return true;
	        else
	        {
	        	System.out.println("Address it not matched");
	        	RunnerClass.failedReason = "Address is not matched";
	        	return false;
	        }
		}
		catch(Exception e)
		{
			RunnerClass.failedReason= "Lease not found";
			return false;
		}
	}
	*/
	
	public static boolean selectBuilding()
	{
		//Modify Building Name
		try
		{
			String lastWordFromBuildingName = RunnerClass.buildingName.split(" ")[RunnerClass.buildingName.split(" ").length-1];
			for(int i=0;i<AppConfig.buildingNameLastWords.length;i++)
			{
				if(AppConfig.buildingNameLastWords[i].equalsIgnoreCase(lastWordFromBuildingName.trim()))
				{
					RunnerClass.buildingName = RunnerClass.buildingName.replace(lastWordFromBuildingName, "").trim();
					break;
				}
			}
		}
		catch(Exception e)
		{}
		String firstWordFromBuildingName = "";
		try
		{
			firstWordFromBuildingName = RunnerClass.buildingName.split(" ")[0];
		}
		catch(Exception e)
		{}
		
		//Get LeaseEntityID and Company from LeaseFact_Dashboard using partial buildingname and Renter Last Name
		DataBase.getLeaseEntityIDAndCompany(firstWordFromBuildingName);
		if(RunnerClass.company==null||RunnerClass.company==""||RunnerClass.leaseEntityID==null||RunnerClass.leaseEntityID=="")
		{
		RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(10));
		RunnerClass.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//Thread.sleep(3000);
		PropertyWare.intermittentPopUp();
		RunnerClass.js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		RunnerClass.driver.navigate().refresh();
		try
		{
	    //RunnerClass.driver.findElement(Locators.dashboardsTab).click();
		RunnerClass.driver.findElement(Locators.searchbox).clear();
		RunnerClass.driver.findElement(Locators.searchbox).sendKeys(RunnerClass.buildingName);
		RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(300));
		Thread.sleep(3000);
		try
		{
			RunnerClass.wait.until((ExpectedConditions.invisibilityOf(RunnerClass.driver.findElement(Locators.searchingLoader))));
		}
		catch(Exception e)
		{
			
		}
		// Select Lease from multiple leases
		List<WebElement> displayedCompanies =null;
					try
					{
						displayedCompanies = RunnerClass.driver.findElements(Locators.searchedLeaseCompanyHeadings);
					}
					catch(Exception e)
					{
						
					}
						boolean leaseSelected = false;
						for(int i =0;i<displayedCompanies.size();i++)
						{
							String companyName = displayedCompanies.get(i).getText();
							if(RunnerClass.company.contains(","))
							{
								if(RunnerClass.company.toLowerCase().contains(companyName.split("-")[1].trim().toLowerCase())&&!companyName.contains("Legacy"))
								{
									
									List<WebElement> leaseList = RunnerClass.driver.findElements(By.xpath("(//*[@class='section'])["+(i+1)+"]/ul/li/a"));
									//System.out.println(leaseList.size());
									for(int j=0;j<leaseList.size();j++)
									{
										String lease = leaseList.get(j).getText();
										if(lease.toLowerCase().contains(RunnerClass.buildingName.toLowerCase())&&lease.contains(":"))
										{
											RunnerClass.driver.findElement(By.xpath("(//*[@class='section'])["+(i+1)+"]/ul/li["+(j+1)+"]/a")).click();
											leaseSelected = true;
											break;
										}
									}
								}
							}
							else
							{
							if(companyName.toLowerCase().contains(RunnerClass.company.toLowerCase())&&!companyName.contains("Legacy"))
							{
								
								List<WebElement> leaseList = RunnerClass.driver.findElements(By.xpath("(//*[@class='section'])["+(i+1)+"]/ul/li/a"));
								//System.out.println(leaseList.size());
								for(int j=0;j<leaseList.size();j++)
								{
									String lease = leaseList.get(j).getText();
									if(lease.toLowerCase().contains(RunnerClass.buildingName.toLowerCase())&&lease.contains(":"))
									{
										RunnerClass.driver.findElement(By.xpath("(//*[@class='section'])["+(i+1)+"]/ul/li["+(j+1)+"]/a")).click();
										leaseSelected = true;
										break;
									}
								}
							}
							}
							if(leaseSelected==true)
							{
								break;
							}
						}
						if(leaseSelected==false)
						{
						    RunnerClass.failedReason =  RunnerClass.failedReason+","+ "Building Not Found";
							return false;
						}
			         } 
		    catch(Exception e) 
				     {
			         RunnerClass.failedReason = RunnerClass.failedReason+","+  "Issue in selecting Building";
				     return false;
				     }
		}
		else
		{
			if(PropertyWare.getToLeasePageWithLeaseEntityID()==false)
				return false;
			else return true;
		}
		return true;
	}
	public static boolean selectLease() 
	{
		try
		{
			RunnerClass.js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			RunnerClass.driver.findElement(Locators.leasesTab).click();
			RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
	        
	        try
	        {
	        	List<WebElement> leaseNameList = RunnerClass.driver.findElements(Locators.leaseList);
	        	boolean renterAvailability = false;
	        	for(int i=0;i<leaseNameList.size();i++)
				{
					String renterName = leaseNameList.get(i).getText();
					if(renterName.toLowerCase().contains(RunnerClass.renterLastName.trim().toLowerCase()))
					{
						leaseNameList.get(i).click();
						renterAvailability =true;
						break;
					}
				}
	        	if(renterAvailability==false)
	        	{
	        		System.out.println( "Lease Not Available");
				    RunnerClass.failedReason =  RunnerClass.failedReason+","+   "Lease Not Available";
					return false;
	        	}
	        }
	        catch(Exception e)
	        {
	        	System.out.println("Unable to Click Lease Owner Name");
			    RunnerClass.failedReason =  RunnerClass.failedReason+","+  "Unable to Click Lease Onwer Name";
				return false;
	        }
	        /*
			try
			{
				String[] renterFullNameArray = {};
				List<WebElement> ownerNames = RunnerClass.driver.findElements(Locators.leaseOwnersList);
				List<WebElement> leaseNameList = RunnerClass.driver.findElements(Locators.leaseList);
				try
				{
				renterFullNameArray = RunnerClass.renterFullName.split(" ");
				}
				catch(Exception e)
				{
					renterFullNameArray[0] = RunnerClass.renterFullName;
				}
				boolean renterAvailability = false;
				for(int i=0;i<leaseNameList.size();i++)
				{
					String renterName = leaseNameList.get(i).getText();
					for(int j=0;j<renterFullNameArray.length;j++)
					{
						//String renterPartialName = renterFullNameArray[j];
						if(renterName.toLowerCase().contains(RunnerClass.renterLastName.toLowerCase()))
						{
							renterAvailability = true;
							leaseNameList.get(i).click();
							break;
						}
					}
					if(renterAvailability==true)
						break;
				}
				if(renterAvailability==false)
				{
					System.out.println("Lease Not Available");
				    RunnerClass.failedReason =  RunnerClass.failedReason+","+  "Lease Not Available";
					return false;
				}
			}
			catch(Exception e)
			{
				
				System.out.println("Unable to Click Lease Owner Name");
			    RunnerClass.failedReason =  RunnerClass.failedReason+","+  "Unable to Click Lease Onwer Name";
				return false;
			}
			*/
			PropertyWare.intermittentPopUp();
			return true;
		}
			//pop up
		catch(Exception e)
		{
			RunnerClass.failedReason="Lease Not Found";
			return false;
		}
	}
	
	public static void intermittentPopUp()
	{
		//Pop up after clicking lease name
				try
				{
					RunnerClass.driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(1));
			        try
			        {
					if(RunnerClass.driver.findElement(Locators.popUpAfterClickingLeaseName).isDisplayed())
					{
						RunnerClass.driver.findElement(Locators.popupClose).click();
					}
			        }
			        catch(Exception e) {}
			        try
			        {
					if(RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUp).isDisplayed())
					{
						RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUpOkButton).click();
					}
			        }
			        catch(Exception e) {}
			        try
			        {
			        if(RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUpOkButton).isDisplayed())
			        	RunnerClass.driver.findElement(Locators.scheduledMaintanancePopUpOkButton).click();
			        }
			        catch(Exception e) {}
					RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
				}
				catch(Exception e) {}
			
	}
	
	public static boolean checkIfBuildingIsDeactivated()
	{
		//Pop up after clicking lease name
				try
				{
					RunnerClass.driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(1));
			        try
			        {
					if(RunnerClass.driver.findElement(Locators.buildingDeactivatedMessage).isDisplayed())
					{
						System.out.println("Building is Deactivated");
						RunnerClass.failedReason = "Building is Deactivated";
						RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
			        	return true;
					}
			        }
			        catch(Exception e) {}
			        
					RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
			        return false;
				}
				catch(Exception e) {}
				return false;
				
	}
	public static boolean permissionDeniedPage()
	{
		try
		{
		RunnerClass.driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(1));
        if(RunnerClass.driver.findElement(Locators.permissionDenied).isDisplayed())
        {
        	RunnerClass.driver.navigate().back();
        	return true;
        }
        RunnerClass.driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(5));
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}

	public static boolean getToLeasePageWithLeaseEntityID()
	{
		
		try
		{
			RunnerClass.navigateToLeaseThroughLeaseEntityID = true;
			RunnerClass.driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	        RunnerClass.wait = new WebDriverWait(RunnerClass.driver, Duration.ofSeconds(100));
	        RunnerClass.driver.navigate().refresh();
	        PropertyWare.intermittentPopUp();
	        //if(PropertyWare.checkIfBuildingIsDeactivated()==true)
	        	//return false;
	        //if(RunnerClass.previousRecordCompany==null||!RunnerClass.previousRecordCompany.equals(RunnerClass.company)||RunnerClass.previousRecordCompany.equals(""))
	       //{
	        RunnerClass.driver.findElement(Locators.marketDropdown).click();
	        String marketName = "HomeRiver Group - "+RunnerClass.company.trim();
	        Select marketDropdownList = new Select(RunnerClass.driver.findElement(Locators.marketDropdown));
	        marketDropdownList.selectByVisibleText(marketName);
	        Thread.sleep(3000);
	        //}
	        String buildingPageURL = AppConfig.buildingPageURL+RunnerClass.leaseEntityID;
	        RunnerClass.driver.navigate().to(buildingPageURL);
	        if(PropertyWare.permissionDeniedPage()==true)
	        {
	        	System.out.println("Wrong Lease Entity ID");
	        	RunnerClass.failedReason = "Wrong Lease Entity ID";
	        	return false;
	        }
	        PropertyWare.intermittentPopUp();
	        if(PropertyWare.checkIfBuildingIsDeactivated()==true)
	        	return false;
	        boolean portfolioCheck = false;
	        
	        return true;
		}
		catch(Exception e)
		{
			RunnerClass.failedReason= "Lease not found";
			return false;
		}
	}

}
