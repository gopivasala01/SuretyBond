package mainPackage;

import org.openqa.selenium.By;

public class Locators 
{
	public static By userName = By.id("loginEmail");
	public static By password = By.name("password");
	public static By signMeIn = By.xpath("//*[@value='Sign Me In']");
	public static By loginError = By.xpath("//*[@class='toast toast-error']");
	
	public static By searchbox = By.name("eqsSearchText");
	public static By dashboardsTab = By.linkText("Dashboards");
	public static By searchingLoader = By.xpath("//*[@id='eqsResult']/h1");
	public static By noItemsFoundMessagewhenLeaseNotFound = By.xpath("//*[text()='No Items Found']");
	public static By selectSearchedLease = By.xpath("//*[@class='results']/descendant::li/a");
	public static By getLeaseCDEType = By.xpath("//*[@id='summary']/table[1]/tbody/tr[3]/td");
	 public static By searchedLeaseCompanyHeadings = By.xpath("//*[@id='eqsResult']/div/div/h1");
	
	public static By marketDropdown = By.id("switchAccountSelect");
	public static By buildingTitle = By.id("summaryTitleBuilding");
	public static By buildingDeactivatedMessage = By.xpath("//*[text()='This Building has been deactivated']");
	public static By leasesTab = By.xpath("//*[@class='tabbedSection']/a[4]");	
    public static By leasesTab2 = By.xpath("(//a[text()='Leases'])[2]");
    public static By tenantContact = By.xpath("//*[@id='buildingLeaseList']/tbody/tr/td[2]/a");
    public static By leaseList = By.xpath("//*[@id='buildingLeaseList']/tbody/tr/td[1]/a");
    public static By popUpAfterClickingLeaseName = By.xpath("//*[@id='viewStickyNoteForm']");
    public static By scheduledMaintanancePopUp = By.xpath("//*[text()='Scheduled Maintenance Notification']");
    public static By scheduledMaintanancePopUpOkButton = By.id("alertDoNotShow");
    public static By popupClose = By.xpath("//*[@id='editStickyBtnDiv']/input[2]");
    public static By permissionDenied = By.xpath("//*[contains(text(),'Permission Denied')]");
    public static By leaseOwnersList = By.xpath("//*[@id='buildingLeaseList']/tbody/tr/td[2]/a");
    
    public static By summaryEditButton = By.xpath("//*[@value='Edit']");
    public static By utilityConnectionRequest = By.xpath("//*[text()='Utility Connection Request']/following::Select[1]");
    
    public static By saveLease = By.xpath("(//*[@class='primaryButtons'])[2]/input[1]");
    public static By cancelLease = By.xpath("(//*[@class='primaryButtons'])[2]/input[2]");
    
    public static By saveBuilding = By.xpath("(//*[@class='primaryButtons'])[2]/input[1]");
    public static By cancelBuilding = By.xpath("(//*[@class='primaryButtons'])[2]/input[4]");
    
    public static By newAutoCharge = By.xpath("//*[@value='New Auto Charge']");
    public static By rcField = By.xpath("//*[text()='RC']/following::input[1]");
    
    public static By SuretyBondPolicyNumber = By.xpath("//*[text()='Surety Bond Policy Number']/following::input[1]");
    public static By suretyBondPurchaser = By.xpath("//*[text()='Surety Bond Purchaser']/following::input[1]");
    public static By suretyBondStatus = By.xpath("//*[text()='Surety Bond Status']//following::Select[1]");
    public static By suretyBondAmount = By.xpath("//*[text()='Surety Bond Amount']//following::input[1]");
    public static By suretyBondExpirationDate = By.xpath("//*[text()='Surety Bond Expiration Date']//following::input[1]");
    public static By suretyBondClaimFiledDate = By.xpath("//*[text()='Surety Bond Claim Filed Date']//following::input[1]");
    public static By suretyBondAmountClaimed = By.xpath("//*[text()='Surety Bond Amount Claimed']//following::input[1]");
    public static By suretyBondSettlementAmount = By.xpath("//*[text()='Surety Bond Settlement Amount']//following::input[1]");
    public static By suretyBondDateSettlementReceived = By.xpath("//*[text()='Surety Bond Date Settlement Received']/following::input[1]");
    public static By suretyBondClaimDueDate = By.xpath("//*[text()='Surety Bond Claim Due Date']/following::input[1]");
    public static By suretyBondClaimNumber = By.xpath("//*[text()='Surety Bond Claim Number']/following::input[1]");
    public static By suretyBondClaimStatus = By.xpath("//*[text()='Surety Bond Claim Status']/following::Select[1]");

}
