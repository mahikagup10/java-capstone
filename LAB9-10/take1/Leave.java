package take1;
import java.util.*;


class Employee{
    //director
    //project manager
    //tech lead
    //employee

}

class LeaveRequest{
    //emp name
    //leave status - 'new' if created by client
    //approved by
    //request date
    //apprival date

    //on creation, sent to tech lead
    private String empName;
    private int leaveDays;
    private String leaveType;
    private String reason;
    private String requestDate;
    private String approvalDate;
    private String status;

    public LeaveRequest(String empName, int leaveDays, String leaveType, String reason, String requestDate) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.leaveType = leaveType;
        this.reason = reason;
        this.requestDate = requestDate;
        this.approvalDate = "";
        this.status = "New";
    }

    public String getEmpName() {
        return empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public String getReason() {
        return reason;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

class Leave{
    //casual leave -1 day, reason, processed by project manager
    //vacation leave, processed by director
    //sick leave -1 day, processed by tech lead
}