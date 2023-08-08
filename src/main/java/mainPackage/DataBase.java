package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase 
{
	public static boolean getLeasesList(String pendingLeasesQuery)
	{
		try
		{
		        Connection con = null;
		        Statement stmt = null;
		        ResultSet rs = null;
		            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            con = DriverManager.getConnection(AppConfig.connectionUrl);
		            String SQL = pendingLeasesQuery;
		            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		           // stmt = con.createStatement();
		            rs = stmt.executeQuery(SQL);
		            int rows =0;
		            if (rs.last()) 
		            {
		            	rows = rs.getRow();
		            	// Move to beginning
		            	rs.beforeFirst();
		            }
		            System.out.println("No of Rows = "+rows);
		            RunnerClass.pendingLeases = new String[rows][17];
		           int  i=0;
		            while(rs.next())
		            {
		            	String 	ID =  rs.getObject(1).toString();
		            	String 	stateCode =  (String) rs.getObject(2);
		                String  buildingAddress = rs.getObject(3).toString();
		                String RenterFirstName =  rs.getObject(4).toString();
		                String RenterLastName =  rs.getObject(5).toString();
		                String policyNumberAggregated =  rs.getObject(6).toString(); 
		                String RenterFullName =  rs.getObject(7).toString(); 
		                String PolicyStatus =  rs.getObject(8).toString(); 
		                String coverageAmount =  rs.getObject(9).toString(); 
		                String coverageEndDate =  rs.getObject(10).toString(); 
		                String claimSubmittedDate = (String) rs.getObject(11); 
		                String submittedAmount = String.valueOf(rs.getObject(12)); 
		                String payoutAmount = String.valueOf(rs.getObject(13)); 
		                String claimPaidAt = String.valueOf(rs.getObject(14)); 
		                String claimDueDate =  String.valueOf(rs.getObject(15)); 
		                String claimNumberAggregated = String.valueOf( rs.getObject(16)); 
		                String claimStatus = String.valueOf( rs.getObject(17)); 
		    			//ID
		                try 
		                {
		    				RunnerClass.pendingLeases[i][0] = ID;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][0] = "";
		                }
		              //stateCode
		                try 
		                {
		                	if(stateCode==null)
		                		RunnerClass.pendingLeases[i][1] = "";
		                	else
		    				RunnerClass.pendingLeases[i][1] = stateCode;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][1] = "";
		                }
		              //buildingAddress
		                try 
		                {
		                	if(buildingAddress==null)
		                		RunnerClass.pendingLeases[i][2] = "";
		                	else
		    				RunnerClass.pendingLeases[i][2] = buildingAddress;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][2] = "";
		                }
		              //Renter First Name
		                try 
		                {
		                	if(RenterFirstName==null)
		                		RunnerClass.pendingLeases[i][3] = "";
		                	else
		    				RunnerClass.pendingLeases[i][3] = RenterFirstName;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][3] = "";
		                }
		              //RenterLastName
		                try 
		                {
		                	if(RenterLastName==null)
		                		RunnerClass.pendingLeases[i][4] = "";
		                	else
		    				RunnerClass.pendingLeases[i][4] = RenterLastName;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][4] = "";
		                }
		              //policyNumberAggregated
		                try 
		                {
		                	if(policyNumberAggregated==null)
		                		RunnerClass.pendingLeases[i][5] = "";
		                	else
		    				RunnerClass.pendingLeases[i][5] = policyNumberAggregated;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][5] = "";
		                }
		              //RenterFullName
		                try 
		                {
		                	if(RenterFullName==null)
		                		RunnerClass.pendingLeases[i][6] = "";
		                	else
		    				RunnerClass.pendingLeases[i][6] = RenterFullName;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][6] = "";
		                }
		              //PolicyStatus
		                try 
		                {
		                	if(PolicyStatus==null)
		                		RunnerClass.pendingLeases[i][7] = "";
		                	else
		    				RunnerClass.pendingLeases[i][7] = PolicyStatus;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][7] = "";
		                }
		              //coverageAmount
		                try 
		                {
		                	if(coverageAmount==null)
		                		RunnerClass.pendingLeases[i][8] = "";
		                	else
		    				RunnerClass.pendingLeases[i][8] = coverageAmount;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][8] = "";
		                }
		              //coverageEndDate
		                try 
		                {
		                	if(coverageEndDate==null)
		                		RunnerClass.pendingLeases[i][9] = "";
		                	else
		    				RunnerClass.pendingLeases[i][9] = coverageEndDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][9] = "";
		                }
		              //claimSubmittedDate
		                try 
		                {
		                	if(claimSubmittedDate==null)
		                		RunnerClass.pendingLeases[i][10] = "";
		                	else
		    				RunnerClass.pendingLeases[i][10] = claimSubmittedDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][10] = "";
		                }
		              //submittedAmount
		                try 
		                {
		                	if(submittedAmount==null)
		                		RunnerClass.pendingLeases[i][11] = "";
		                	else
		    				RunnerClass.pendingLeases[i][11] = submittedAmount;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][11] = "";
		                }
		                //payoutAmount
		                try 
		                {
		                	if(payoutAmount==null)
		                		RunnerClass.pendingLeases[i][12] = "";
		                	else
		    				RunnerClass.pendingLeases[i][12] = payoutAmount;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][12] = "";
		                }
		              //claimPaidAt
		                try 
		                {
		                	if(claimPaidAt==null)
		                		RunnerClass.pendingLeases[i][13] = "";
		                	else
		    				RunnerClass.pendingLeases[i][13] = claimPaidAt;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][13] = "";
		                }
		              //claimDueDate
		                try 
		                {
		                	if(claimDueDate==null)
		                		RunnerClass.pendingLeases[i][14] = "";
		                	else
		    				RunnerClass.pendingLeases[i][14] = claimDueDate;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][14] = "";
		                }
		              //claimNumberAggregated
		                try 
		                {
		                	if(claimNumberAggregated==null)
		                		RunnerClass.pendingLeases[i][15] = "";
		                	else
		    				RunnerClass.pendingLeases[i][15] = claimNumberAggregated;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][15] = "";
		                }
		              //claimStatus
		                try 
		                {
		                	if(claimStatus==null)
		                		RunnerClass.pendingLeases[i][16] = "";
		                	else
		    				RunnerClass.pendingLeases[i][16] = claimStatus;
		                }
		                catch(Exception e)
		                {
		                	RunnerClass.pendingLeases[i][16] = "";
		                }
		    				i++;
		            }	
		            System.out.println("Total Pending Leases  = " +RunnerClass.pendingLeases.length);
		            rs.close();
		            stmt.close();
		            con.close();
		 return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		 return false;
		}
	}
	public static void updateTable(String query)
	 {
		    try (Connection conn = DriverManager.getConnection(AppConfig.connectionUrl);
		        Statement stmt = conn.createStatement();) 
		    {
		      stmt.executeUpdate(query);
		      System.out.println("Record Updated");
		      stmt.close();
	            conn.close();
		    } catch (SQLException e) 
		    {
		      e.printStackTrace();
		    }
	 }
	
	public static boolean getCompletedBuildingsList()
	{
		try
		{
		        Connection con = null;
		        Statement stmt = null;
		        ResultSet rs = null;
		            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            con = DriverManager.getConnection(AppConfig.connectionUrl);
		            String SQL = AppConfig.getLeasesWithStatusforCurrentDay;
		            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		           // stmt = con.createStatement();
		            rs = stmt.executeQuery(SQL);
		            int rows =0;
		            if (rs.last()) {
		            	rows = rs.getRow();
		            	// Move to beginning
		            	rs.beforeFirst();
		            }
		            System.out.println("No of buildings with status = "+rows);
		            RunnerClass.completedLeasesList = new String[rows][22];
		           int  i=0;
		            while(rs.next())
		            {
		            	
		            	String 	company =  (String) rs.getObject(1);
		                String  Unit_Entity_ID = (String) rs.getObject(2);
		                String  Address = (String) rs.getObject(3);
		                String  Current_Resident_FirstName = (String) rs.getObject(4);
		                String  Current_Resident_LastName = (String) rs.getObject(5);
		                String  Utility_ConnectionRequest = (String) rs.getObject(6);
		                String  SetConstruction_Codeto = (String) rs.getObject(7);
		                String  FilterSize = (String) rs.getObject(8);
		                String  PossesionConfirmedDate = (String) rs.getObject(9);
		                String  TurnOver_HandledBy = (String) rs.getObject(10);
		                String  TurnEstimate_SubmissionDate = (String) rs.getObject(11);
		                String  TurnEstimatedCost = (String) rs.getObject(12);
		                String  TurnApprovalDate = (String) rs.getObject(13);
		                String  TurnStateDate = (String) rs.getObject(14);
		                String  TurnEstimated_CompletionDate = (String) rs.getObject(15);
		                String  TurnActual_CompletionDate = (String) rs.getObject(16);
		                String  TurnActualCost = (String) rs.getObject(17);
		                String  Turn_QCCompletedDate = (String) rs.getObject(18);
		                String  LeasingLockbox_SerialNumber = (String) rs.getObject(19);
		                String  Last_vacantVisit = (String) rs.getObject(20);
		                String  Automation_Status = (String) rs.getObject(21);
		                String  Automation_Notes = (String) rs.getObject(22);
		                
		    				//Company
		    				RunnerClass.completedLeasesList[i][0] = company;
		    				//Port folio
		    				RunnerClass.completedLeasesList[i][1] = Unit_Entity_ID;
		    				//Third Party Unit ID
		    				RunnerClass.completedLeasesList[i][2] = Address;
		    				//Third Party Unit ID
		    				RunnerClass.completedLeasesList[i][3] = Current_Resident_FirstName;
		    				//Lease Name
		    				RunnerClass.completedLeasesList[i][4] = Current_Resident_LastName;
		    				//Lease Name
		    				RunnerClass.completedLeasesList[i][5] = Utility_ConnectionRequest;
		    				//Target Deposit
		    				RunnerClass.completedLeasesList[i][6] = SetConstruction_Codeto;
		    				//Listing Agent
		    				RunnerClass.completedLeasesList[i][7] = FilterSize;
		    				//Status
		    				RunnerClass.completedLeasesList[i][8] = PossesionConfirmedDate;
		    				//Notes
		    				RunnerClass.completedLeasesList[i][9] = TurnOver_HandledBy;
		    				//Notes
		    				RunnerClass.completedLeasesList[i][10] = TurnEstimate_SubmissionDate;
		    				//Notes
		    				RunnerClass.completedLeasesList[i][11] = TurnEstimatedCost;
		    				//Notes
		    				RunnerClass.completedLeasesList[i][12] = TurnApprovalDate;
		    				//Notes
		    				RunnerClass.completedLeasesList[i][13] = TurnStateDate;
		    				RunnerClass.completedLeasesList[i][14] = TurnEstimated_CompletionDate;
		    				RunnerClass.completedLeasesList[i][15] = TurnActual_CompletionDate;
		    				RunnerClass.completedLeasesList[i][16] = TurnActualCost;
		    				RunnerClass.completedLeasesList[i][17] = Turn_QCCompletedDate;
		    				RunnerClass.completedLeasesList[i][18] = LeasingLockbox_SerialNumber;
		    				RunnerClass.completedLeasesList[i][19] = Last_vacantVisit;
		    				RunnerClass.completedLeasesList[i][20] = Automation_Status;
		    				RunnerClass.completedLeasesList[i][21] = Automation_Notes;
		    				i++;
		            }	
		            rs.close();
		            stmt.close();
		            con.close();
		 return true;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		 return false;
		}
	}



}
