package mainPackage;

public class AppConfig 
{
	 public static boolean saveButtonOnAndOff= false;
		
	   public static String URL ="https://app.propertyware.com/pw/login.jsp";
	   public static String username ="mds0418@gmail.com";
	   public static String password ="KRm#V39fecMDGg#";
	   
	   public static String excelFileLocation = "E:\\Automation\\Base Rent Update";
	   public static String downloadFilePath = "C:\\SantoshMurthyP\\Initial Rents Update - Branches\\Tennessee";
	   
	   public static String buildingPageURL = "https://app.propertyware.com/pw/leases/lease_detail.do?entityID=";
	   //Mail credentials
	   public static String fromEmail = "bireports@beetlerim.com";
	   public static String fromEmailPassword = "Welcome@123";
	   
	   public static String toEmail = "gopi.v@beetlerim.com";
	   public static String CCEmail = "gopi.v@beetlerim.com";
	   
	   public static String mailSubject = "Surety Bond Report on  ";
	   
	   public static String[] LeaseAgreementFileNames = {"REVISED_Lease_","Lease_","Leases_"};
	   
	   public static String connectionUrl = "jdbc:sqlserver://azrsrv001.database.windows.net;databaseName=HomeRiverDB;user=service_sql02;password=xzqcoK7T;encrypt=true;trustServerCertificate=true;";
	   
	  // public static String leaseFetchQuery  = "Select Company, Building,leaseName from Automation.InitialRentsUpdate where Status ='Pending' and Company ='Georgia'";
	   
	   public static String pendingLeasesQuery = "Select ID, AddressState,BuildingName,RenterFirstName,RenterLastName,PolicyNumberAggregated\r\n"
	   		+ ",RenterFullName = (RenterFirstName +' '+ RenterLastName),PolicyStatus,CoverageAmount,CoverageEndDate\r\n"
	   		+ ",SubmittedTimeStamp,TotalSubmittedAmount,TotalPayoutAmount,ClaimPaidAt='',ClaimDueDate,ClaimNumberAggregated,ClaimStatus\r\n"
	   		+ "from Automation.SuretyBond where Automation_Status ='Failed' ";
	   
	   public static String failedLeasesQuery = "Select Company, LeaseEntityID,DateDiff(Day,MoveInDate,Getdate()) as datedifference from Automation.BaseRentUpdate where  Company='Alabama' and Status ='Failed'";
	   
	   public static String getLeasesWithStatusforCurrentDay = "Select Company, Building,ThirdPartyUnitID, Leaseidnumber, LeaseName,LeaseStatus,leaseExecutionDate, StartDate, EndDate, MonthlyRent, MonthlyRentFromPW, PetRent, PetRentFromPW,Status, Notes from Automation.InitialRentsUpdate and company in ('Tennessee') ";//where Format(convert(datetime, CompletedDate, 101),'dd MM yyyy') = format(getdate(),'dd MM yyyy') ";//and company in ('Florida','North Carolina')";
	   
	   public static String[] buildingNameLastWords = {"Court","Lane","Road","Drive","Avenue","Terrace","Northwest"};
	   
	   public static String getClaimStatus(String status)
	   {
		   switch(status)
		   {
		   case "Accepted":
			   return "Claim Approved";
		   case "Closed Without Payment":
			   return "Claim Approved";
		   case "Denied":
			   return "Claim Denied";
		   case "New":
			   return "Claim Pending";
		   case "Paid":
			   return "Claim Approved";
		   case "Payment Plan":
			   return "Claim Approved";
		   case "Payment Plan In Progress":
			   return "Claim Approved";
		   case "Processing":
			   return "Claim Pending";
		   case "Subrogation":
			   return "Claim Approved";
		   case "Subrogation Pain In Full":
			   return "Claim Approved";
		   case "Withdrawn":
			   return "Claim Withdrawn";
		   }
		   return "Please Choose*";
	   }
	   
	   public static String getCompanyFromStateCode()
	   {
		   switch(RunnerClass.stateCode)
		   {
		   case "AL":
			   return "Alabama";
		   case "AK":
			   return "Alaska";
		   case "AZ":
		       return "Arizona";
		   case "AR":
			   return "Arkansas";
		   case "CA":
		       return "California";
		   case "CO":
			   return "Colorado";
		   case "CT":
			   return "Connecticut";
		   case "DE":
			   return "Delaware";
		   case "DC":
			   return "DC Metro";
		   case "FL":
			   return "Florida";
		   case "GA":
			   return "Georgia";
		   case "HI":
			   return "Hawaii";
		   case "ID":
			   return "Idaho Falls";
		   case "IL":
			   return "Illinois";
		   case "IN":
			   return "Indiana";
		   case "IA":
			   return "Iowa";
		   case "KS":
			   return "Kansas City";
		   case "KY":
			   return "Kentucky";
		   case "LA":
			   return "Louisiana";
		   case "ME":
			   return "Maine";
		   case "MD":
			   return "Maryland";
		   case "MA":
			   return "Massachusetts";
		   case "MI":
			   return "Michigan";
		   case "MN":
			   return "Minnesota";
		   case "MS":
			   return "Mississippi";
		   case "MO":
			   return "Missouri";
		   case "MT":
			   return "Montana";
		   case "NE":
			   return "Nebraska";
		   case "NV":
			   return "Nevada";
		   case "NH":
			   return "New Hampshire";
		   case "NJ":
			   return "New Jersey";
		   case "NM":
			   return "New Mexico";
		   case "NY":
			   return "New York";
		   case "NC":
			   return "North Carolina";
		   case "ND":
			   return "North Dakota";
		   case "OH":
			   return "Ohio";
		   case "OK":
			   return "Oklahoma";
		   case "OR":
			   return "Oregon";
		   case "PA":
			   return "Pennsylvania";
		   case "PR":
			   return "Puerto Rico";
		   case "RI":
			   return "Rhode Island";
		   case "SC":
			   return "South Carolina";
		   case "SD":
			   return "South Dakota";
		   case "TN":
			   return "Tennessee";
		   case "TX":
			   return "San Antonio";
		   case "UT":
			   return "Utah";
		   case "VT":
			   return "Vermont";
		   case "VA":
			   return "Virginia";
		   case "VI":
			   return "Virgin Islands";
		   case "WA":
			   return "Washington";
		   case "WV":
			   return "West Virginia";
		   case "WI":
			   return "Wisconsin";
		   case "WY":
			   return "Wyoming";
			   
		   
		   }
		   return "";
	   }
	   

}
