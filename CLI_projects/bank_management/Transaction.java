package CLI_projects.bank_management;

class Transactions {
    public void deposit(Bank ac, double ammount) {
        double bal = ac.getBalance();
        bal = bal + ammount;
        ac.setBalance(bal);
    }

    public void withdraw(Bank ac, double ammount) {
        if (ac.getBalance() >= ammount) {
            ac.setBalance(ac.getBalance() - ammount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Error: Withdrawal amount exceeds balance");
        }
    }
}