
/**
 * Write a description of class Fashion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fashion extends Stock
{
    private String brandType;
    //eg if its luxuary or high street.
    
    public Fashion (String name, double cost, double fluctuation, String brandType)
    {   
        super(cost, name, fluctuation);
        this.brandType = brandType;
        
    
    }
    
    public String getbrand()
    {return brandType;}
    
    public String printinfo()
    {
        return ("Stock name: "+ this.getname() + "\n The price is currently "+ this.getcost()+ " but this regularly change at the rate " + getf() + " % A characteristic of this stock is that its brand type is " + brandType);
    }
    public void printnews()
    {
        System.out.println("BREAKING NEWS \n *** The stock for company PLT has just fallen by 4% we would reccomend that you buy ***");
    }
}
