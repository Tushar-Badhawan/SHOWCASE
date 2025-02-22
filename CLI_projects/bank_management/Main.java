package CLI_projects.bank_management;

import java.io.*;
import java.util.ArrayList;

public class Main 
{
    void menu1() throws IOException,InterruptedException
    {
        Thread.sleep(2000);
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        System.out.println("enter the choice: ");
        System.out.println("1. to create account ");
        System.out.println("2. for transactions ");
        System.out.println("0. to exit");
    }
    void menu2() throws IOException,InterruptedException
    {
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        System.out.println("Please wait....");
        Thread.sleep(2000);
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        System.out.println("enter your choice");
        System.out.println("1. to deposit money");
        System.out.println("2. to withdraw money");
        System.out.println("3. to transfer money from one account to another");
        System.out.println("4. to check balance");
        System.out.println("0. to return back to main menu");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main op=new Main();
        String name;
        String address;
        int accno;
        int ac_Count = 1000;
        ArrayList<Bank> accounts = new ArrayList<>();
        ArrayList<Integer> accountNumbers = new ArrayList<>();
        int ch;
        int x = 0;
        do {
            op.menu1();
            ch = Integer.parseInt(br.readLine());
            if (ch == 1) {
                Bank ob = new Bank();
                System.out.println("enter your name");
                name = br.readLine();
                System.out.println("enter your address");
                address = br.readLine();
                ob.setName(name);
                ob.setAddress(address);
                accno = ac_Count + 1;
                ac_Count++;
                ob.setAccno(accno);
                accounts.add(x, ob);
                accountNumbers.add(x, accno);
                x++;
                accounts.get(x - 1).showDetails();
            }
            
            if (ch == 2) {
                System.out.println("please enter your account number");
                int current_accno = Integer.parseInt(br.readLine());
                Bank currentAccount = null;
                for (Bank acc : accounts) {
                    if (acc.accno == current_accno) {
                        currentAccount = acc;
                        break;
                    }
                }
                if (currentAccount == null) {
                    System.out.println("Account not found!");
                    continue;
                }
                
                
                op.menu2();
                int c = Integer.parseInt(br.readLine());
                Transactions trans = new Transactions();
                switch (c) {
                    case 1:
                        System.out.println("Enter amount to deposit: ");
                        double depAmount = Double.parseDouble(br.readLine());
                        trans.deposit(currentAccount, depAmount);
                        System.out.println("Deposit successful\nNew balance: " + currentAccount.getBalance());
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw: ");
                        double withAmount = Double.parseDouble(br.readLine());
                        trans.withdraw(currentAccount, withAmount);
                        System.out.println("Remaining balance: " + currentAccount.getBalance());
                        break;
                    case 3:
                        System.out.println("Enter recipient account number: ");
                        int target_accno = Integer.parseInt(br.readLine());
                        if (target_accno==current_accno) 
                        {
                            System.out.println("You entered your own Account number");
                            System.out.println("Taking you back to main menu");
                            break;    
                        }
                        Bank cur_accno = null;
                        for (Bank acc : accounts) {
                            if (acc.accno == target_accno) {
                                cur_accno = acc;
                                break;
                            }
                        }
                        if (cur_accno == null) {
                            System.out.println("Recipient account not found!");
                        } else {
                            System.out.println("Enter amount to transfer: ");
                            double transAmount = Double.parseDouble(br.readLine());
                            if (currentAccount.getBalance() >= transAmount) {
                                trans.withdraw(currentAccount, transAmount);
                                trans.deposit(cur_accno, transAmount);
                                System.out.println("Transfer successful\nNew balance: " + currentAccount.getBalance());
                            } else {
                                System.out.println("Insufficient balance!");
                            }
                        }
                        break;
                    case 4:
                        currentAccount.showBalance();
                        break;
                    case 0:
                        System.out.println("Taking you back to main menu.");
                        break;
                    default:
                        System.out.println("please enter from given options...\ntaking you to main menu");
                        break;
                }
            }
        } while (ch != 0);
        System.out.println("Thank you...");
    }
}