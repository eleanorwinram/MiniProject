
/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account
{
    private int accountNo;
    private double balance;
    
    public Account( int accountNo, double balance)
    {
        accountNo = this.accountNo;
        balance =  this.balance;
    }
    
    public int getaccNo(){return accountNo;} 
    public double getbalance() {return balance;}
    public void setbalance(double b)
    {
        balance = balance + b;
        
    }
    
    public void boughtshares(double a)
    {
        balance = balance - a;
        return;
    }
    public void soldshares(double a)
    {
        balance = balance + a;
        return;
    }
}
