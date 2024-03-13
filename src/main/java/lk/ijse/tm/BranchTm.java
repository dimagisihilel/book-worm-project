package lk.ijse.tm;

public class BranchTm {
    private String branchName;
    private String branchAddress;
    private String branchContact;

    public BranchTm(String branchName, String branchAddress, String branchContact) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.branchContact = branchContact;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public String getBranchContact() {
        return branchContact;
    }
}
