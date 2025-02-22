package CLI_projects.bank_management;

class Bank {
    String name = "";
    String address = "";
    int accno = 0;
    Double ammount = 0.0d;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public void setBalance(double ammount) {
        this.ammount = ammount;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public double getBalance() {
        return this.ammount;
    }

    public void showDetails() {
        System.out.println("**************************");
        System.out.println("Name           : " + name);
        System.out.println("Account Number : " + accno);
        System.out.println("Address        : " + address);
        System.out.println("Balance        : " + ammount);
        System.out.println("**************************");
    }

    public void showBalance() {
        System.out.println(" __________________________________");
        System.out.printf("| %-15s : %-10s |\n", "Name", name);
        System.out.printf("| %-15s : %-10d |\n", "Account No", accno);
        System.out.printf("| %-15s : %-10.2f |\n", "Balance", ammount);
        System.out.println(" __________________________________");
    }
}
