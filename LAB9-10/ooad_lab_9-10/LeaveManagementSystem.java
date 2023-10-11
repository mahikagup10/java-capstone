import java.time.LocalDate;
import java.util.Scanner;
import java.util.Date;

interface LeaveHandler {
 void setNextHandler(LeaveHandler nextHandler);
 void processLeave(LeaveRequest leaveRequest);
}

class LeaveRequest {
 String empName;
 String leaveType;
 String leaveStatus;
 String approvedBy;
 LocalDate requestDate;
 LocalDate approvalDate;
 String reason;
 LocalDate startDate;
 LocalDate endDate;
 public LeaveRequest(String empName, String leaveType, LocalDate requestDate, String reason, LocalDate startDate, LocalDate endDate) {
 this.empName = empName;
 this.leaveType = leaveType;
 this.requestDate = requestDate;
 this.reason = reason;
 this.startDate = startDate;
 this.endDate = endDate;
 this.leaveStatus = "New";
 }
}

class TechLead implements LeaveHandler {

 LeaveHandler nextHandler;
 public void setNextHandler(LeaveHandler nextHandler) {
 this.nextHandler = nextHandler;
 }

 public void processLeave(LeaveRequest leaveRequest) {
 if (leaveRequest.leaveType.equalsIgnoreCase("SL")) {
 leaveRequest.leaveStatus = "Approved";
 leaveRequest.approvedBy = "Tech Lead";
 leaveRequest.approvalDate = LocalDate.now();
 System.out.println("Sick Leave approved for " + leaveRequest.empName+" by TechLead.");
 } 
 else {
 if (nextHandler != null) {
 nextHandler.processLeave(leaveRequest);
 }
 }
 }
}

class ProjectManager implements LeaveHandler {
 LeaveHandler nextHandler;
 public void setNextHandler(LeaveHandler nextHandler) {
 this.nextHandler = nextHandler;
 }

 public void processLeave(LeaveRequest leaveRequest) {
 if (leaveRequest.leaveType.equalsIgnoreCase("CL")) {
 leaveRequest.leaveStatus = "Approved";
 leaveRequest.approvedBy = "Project Manager";
 leaveRequest.approvalDate = LocalDate.now();
 System.out.println("Casual Leave approved for "+leaveRequest.empName+" by Project Manager.");
 } 
 else {
 if (nextHandler != null) {
 nextHandler.processLeave(leaveRequest);
 }
 }
 }
}

class Director implements LeaveHandler {
 LeaveHandler nextHandler;
 public void setNextHandler(LeaveHandler nextHandler) {
 this.nextHandler = nextHandler;
 }

 public void processLeave(LeaveRequest leaveRequest) {
 if (leaveRequest.leaveType.equalsIgnoreCase("VL")) {
 leaveRequest.leaveStatus = "Approved";
 leaveRequest.approvedBy = "Director";
 leaveRequest.approvalDate = LocalDate.now();
 System.out.println("Vacation Leave approved for "+leaveRequest.empName+" by Director.");
 } 
 else {
 if (nextHandler != null) {
 nextHandler.processLeave(leaveRequest);
 }
 }
 }
}

public class LeaveManagementSystem {

 public static void main(String[] args) {
 TechLead techLead = new TechLead();
 ProjectManager projectManager = new ProjectManager();
 Director director = new Director();
 techLead.setNextHandler(projectManager);
 projectManager.setNextHandler(director);
 boolean flag=true;
 while(flag)
 {
 Scanner myObj = new Scanner(System.in); // Create a Scanner object
 System.out.println("Enter username");
 String empName = myObj.nextLine(); // Read user input
 System.out.println("EmpName is: " + empName);
 System.out.println("Enter leave Type (SL,CL,VL)");
 String leaveType = myObj.nextLine();
 System.out.println("LeaveType is: " + leaveType);
 if(leaveType.equals("SL")||leaveType.equals("CL")||leaveType.equals("VL")){
 switch(leaveType){
 case "SL":{
 LeaveRequest sickLeave = new LeaveRequest(empName,leaveType,LocalDate.now(), null, null, null);
 techLead.processLeave(sickLeave);
 flag= false;
 break;
 }
 case "CL":{
 System.out.println("Enter reason");
 String reason = myObj.nextLine();

 LeaveRequest casualLeave = new LeaveRequest(empName, leaveType,
LocalDate.now(), reason ,null, null);
 techLead.processLeave(casualLeave);
 flag= false;
 break;
 }
 case "VL":{

 try{
 System.out.println("Enter start date for leave in yyyy-mm-dd format");
 String startDate = myObj.nextLine();
 LocalDate StartDate = LocalDate.parse(startDate);
 if(StartDate.compareTo(LocalDate.now()) < 0) {
 System.out.println("Invalid start date");
 break;
 }
 System.out.println("Enter end date for leave in yyyy-mm-dd format");
 String endDate = myObj.nextLine();
 LocalDate EndDate = LocalDate.parse(endDate);

 if(EndDate.compareTo(StartDate) < 0 || EndDate.compareTo(LocalDate.now())< 0 ){
 System.out.println("Invalid end date");
 break;
 }
 LeaveRequest vacationLeave = new LeaveRequest(empName, leaveType,LocalDate.now(), null, StartDate, EndDate);
 techLead.processLeave(vacationLeave);
 flag= false;
 break;
 }
 catch(Exception DateTimeException){
 System.out.println("Wrong date format, please enter again");
 break;
 }
 }
 }
 }
 else{
 System.out.println("Wrong type of leave");
 }
 }
}
}
