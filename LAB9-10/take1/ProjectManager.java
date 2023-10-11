package take1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectManager extends LeaveApprover {
    @Override
    public void processLeaveRequest(LeaveRequest leaveRequest) {
        if (leaveRequest.getLeaveType().equals("CL")) {
            // Approve the leave request
            leaveRequest.setApprovalDate(getCurrentDate());
            leaveRequest.setStatus("Approved");
            System.out.println("Leave request approved by Project Manager");
            System.out.println("Request details: " + leaveRequest.toString());
        } else {
            // Pass the request to the next approver
            successor.processLeaveRequest(leaveRequest);
        }
    }

    private String getCurrentDate() {
        // Get current date
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
