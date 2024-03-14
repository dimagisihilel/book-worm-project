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

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public void setBranchContact(String branchContact) {
        this.branchContact = branchContact;
    }
}
