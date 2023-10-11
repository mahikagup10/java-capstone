import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Create the employees
        Employee techLead = new TechLead("John Doe");
        Employee projectManager = new ProjectManager("Jane Doe");
        Employee director = new Director("Bob Smith");

        // Create the chain of responsibility
        LeaveApproverChain chain = new LeaveApproverChain();
        chain.addApprover(techLead);
        chain.addApprover(projectManager);
        chain.addApprover(director);

        // Create some leave requests
        Date startDate1 = sdf.parse("01/06/2023");
        Date endDate1 = sdf.parse("01/06/2023");
        LeaveRequest request1 = new LeaveRequest("Alice", LeaveType.CASUAL, startDate1, endDate1, "Not feeling well");

        Date startDate2 = sdf.parse("02/06/2023");
        Date endDate2 = sdf.parse("03/06/2023");
        LeaveRequest request2 = new LeaveRequest("Bob", LeaveType.VACATION, startDate2, endDate2);

        Date startDate3 = sdf.parse("04/06/2023");
        Date endDate3 = sdf.parse("04/06/2023");
        LeaveRequest request3 = new LeaveRequest("Charlie", LeaveType.SICK, startDate3, endDate3);

        // Process the leave requests
        chain.processRequest(request1);
        chain.processRequest(request2);
        chain.processRequest(request3);
    }
}

public class LeaveApproverChain {

    private Approver chain;

    public LeaveApproverChain() {
        buildChain();
    }

    public void addApprover(Employee projectManager) {
        
    }

    private void buildChain() {
        this.chain = new Director(new ProjectManager(new TechLead(null)));
    }

    public void processRequest(LeaveRequest request) {
        chain.processRequest(request);
    }
}

public interface Approver {
    void approveLeave(LeaveRequest request);
}

public class TechLead extends Employee implements Approver {
    
    private Approver successor;

    public TechLead(String name) {
        super(name, Role.TECH_LEAD);
    }

    @Override
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    @Override
    public void processLeaveRequest(LeaveRequest request) {
        if (request.getType() == LeaveType.SICK_LEAVE) {
            System.out.println(getRole() + " approved the " + request.getType() + " for " + request.getEmployee() + " on " + request.getRequestDate());
            request.approve(getRole(), new Date());
        } else {
            System.out.println(getRole() + " cannot approve the " + request.getType() + " and forwarding to " + successor.getRole());
            successor.processLeaveRequest(request);
        }
    }
}

public class ProjectManager extends Employee implements Approver {

    private Approver successor;

    public ProjectManager(String name) {
        super(name, Role.PROJECT_MANAGER);
    }

    @Override
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    @Override
    public void processLeaveRequest(LeaveRequest request) {
        if (request.getType() == LeaveType.CL) {
            approveLeave(request);
        } else {
            successor.processLeaveRequest(request);
        }
    }

    private void approveLeave(LeaveRequest request) {
        request.approve(getName());
        System.out.println("Leave request approved by Project Manager " + getName());
        System.out.println(request.toString());
    }
}


public class Director extends Employee implements Approver {
    private final String role = "Director";

    public Director(String name) {
        super(name);
    }

    @Override
    public void processLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getType() == LeaveType.VACATION) {
            approveLeaveRequest(leaveRequest);
        } else {
            System.out.println("Leave request not approved by " + role + " for " + leaveRequest.getEmployee().getName());
            if (getNextApprover() != null) {
                getNextApprover().processLeaveRequest(leaveRequest);
            }
        }
    }

    @Override
    public String getRole() {
        return role;
    }
}


public abstract class Employee {
    protected String name;
    protected Approver approver;
 
    public Employee(String name) {
        this.name = name;
    }
 
    public void setApprover(Approver approver) {
        this.approver = approver;
    }
 
    public void processLeaveRequest(LeaveRequest leaveRequest) {
        approver.processLeaveRequest(leaveRequest);
    }
 
    public abstract String getRole();
 
    @Override
    public String toString() {
        return "Employee [name=" + name + "]";
    }
}


public class LeaveRequest {
    private String empName;
    private LeaveType leaveType;
    private Date startDate;
    private Date endDate;
    private String reason;
    private LeaveStatus leaveStatus;
    private Employee approvedBy;
    private Date requestDate;
    private Date approvalDate;

    public LeaveRequest(String empName, LeaveType leaveType, Date startDate, Date endDate, String reason) {
        this.empName = empName;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.leaveStatus = LeaveStatus.NEW;
        this.requestDate = new Date();
    }

    public String getEmpName() {
        return empName;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public LeaveStatus getLeaveStatus() {
        return leaveStatus;
    }

    public Employee getApprovedBy() {
        return approvedBy;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setLeaveStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
}
