package take1;
public abstract class LeaveApprover {
    protected LeaveApprover successor;

    public void setSuccessor(LeaveApprover successor) {
        this.successor = successor;
    }

    public abstract void processLeaveRequest(LeaveRequest leaveRequest);
}