package mainPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunnerClass
{
	public static String[][] pendingLeases; 
    public static ChromeDriver driver;
    public static String downloadFilePath;
	public static Actions actions;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	
	public static String failedReason;
	
    public static String ID;
	public static String company;
	public static String leaseEntityID;
	public static String stateCode;
	public static String buildingName;
	public static String renterFirstName;
	public static String renterLastName;
	public static String policyNumberAggregated;
	public static String renterFullName;
	public static String policyStatus;
	public static String coverageAmount;
	public static String coverageEndDate;
	
	public static String claimSubmittedDate;
	public static String submittedAmount;
	public static String payOutAmount;
	public static String claimPaidAt;
	public static String claimDueDate;
	public static String claimNumberAggregated;
	public static String claimStatus;
	public static String datesplit;
	
	public static String[][] completedLeasesList;
	public static String[][] leaseEntityIDAndCompanyFromLeaseFact;
	public static boolean navigateToLeaseThroughLeaseEntityID = false;
	
	
	public static void main(String args[]) throws Exception
	{
		//Get Pending Leases
		DataBase.getLeasesList(AppConfig.pendingLeasesQuery);
		
		//Initial Browser
		PropertyWare.initiateBrowser();
				
		//Login to PW
		PropertyWare.signIn();
		
		for(int i=0;i<pendingLeases.length;i++)
		{
			ID = pendingLeases[i][0];
			company = "";
			leaseEntityID = "";
		stateCode= pendingLeases[i][1];
		buildingName = pendingLeases[i][2];
		renterFirstName =pendingLeases[i][3];
		renterLastName = pendingLeases[i][4];
		policyNumberAggregated=pendingLeases[i][5];
		renterFullName=pendingLeases[i][6];
		policyStatus=pendingLeases[i][7];
		coverageAmount=pendingLeases[i][8];
		coverageEndDate=pendingLeases[i][9];
		
		claimSubmittedDate=pendingLeases[i][10];
		submittedAmount=pendingLeases[i][11];
		payOutAmount=pendingLeases[i][12];
		claimPaidAt=pendingLeases[i][13];
		claimDueDate=pendingLeases[i][14];
		claimNumberAggregated=pendingLeases[i][15];
		claimStatus=pendingLeases[i][16];
		
		navigateToLeaseThroughLeaseEntityID = false;
		
		RunnerClass.failedReason="";
		//get Company from StateCode
		RunnerClass.company = AppConfig.getCompanyFromStateCode();
		RunnerClass.claimDueDate = dateFormatter();
		/*
		 * datesplit = claimDueDate.split(" ")[0];
		 * 
		 * System.out.println(datesplit);
		 */
		/*
		 * SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		 * SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy"); Date
		 * date = inputDate.parse(claimDueDate.trim());
		 * System.out.println(dateFormatter.format(date));
		 */
		
		System.out.println("Record  =  "  +i);
		System.out.println("Building  =  "+buildingName);
		System.out.println("Renter Last Name  =  "+renterLastName);
		
		try
		{
		if(PropertyWare.selectBuilding()==false)
		{
		String query = "Update Automation.SuretyBond Set Automation_Status ='Failed', Automation_Notes='"+failedReason+"' where ID = '"+ID+"'";
		DataBase.updateTable(query);
		continue;
		}
		if(navigateToLeaseThroughLeaseEntityID == false)
		{
		if(PropertyWare.selectLease()==false)
		{
			String query = "Update Automation.SuretyBond Set Automation_Status ='Failed', Automation_Notes='"+failedReason+"' where ID = '"+ID+"'";
			DataBase.updateTable(query);
			continue;
		}
		}
		if(UpdateSuretyBondDetails.updateDetails()==false)
		{
			String query = "Update Automation.SuretyBond Set Automation_Status ='Failed', Automation_Notes='"+failedReason+"' where ID = '"+ID+"'";
			DataBase.updateTable(query);
			continue;
		}
		String query = "Update Automation.SuretyBond Set Automation_Status ='Completed', Automation_Notes='"+failedReason+"' where ID = '"+ID+"'";
		DataBase.updateTable(query);
		
		}
		catch(Exception e)
		{
			continue;
		}
		}
	}
	
	public static String dateFormatter() {
		datesplit = claimDueDate.split(" ")[0];
		System.out.println(datesplit);
		SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat DateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
		Date date = null;
		try {
			date = inputDate.parse(claimDueDate.trim());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (DateFormat.format(date)).toString();
	}

}
