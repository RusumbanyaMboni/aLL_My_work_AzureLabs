public class StaffHiring extends Staff {
    public StaffHiring(int staffNumber, String staffLocation) {
        super(staffNumber, staffLocation);
    }

    public String getStaffHiringProcess() {
        if (staffNumber < 20) {
            return "More staff needed.";
        } else {
            return "Staff level is sufficient.";
        }
    }
}
