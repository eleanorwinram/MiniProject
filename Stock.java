
/**
 * Write a description of class Stock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stock
{
    private  double cost;
    private  double fluctuation;
    private String name;
    
    //properties that all stocks have
    
    public Stock(double cost, String name, double f)
    {
        this.cost = cost;
        this.name= name;
        this.fluctuation = f; 
    }
    // constructor for the stock class
    public String getname()
        {return name;}
    public double getcost()
    {
        return cost;
    }
    // getters so that these private vars can be accessed in 
    public double getf()
    {return fluctuation;}
   
    public String printinfo()
    {
        return ("Stock name: "+ this.getname() + "\n The price is currently "+ this.getcost()+ " but this regularly change at the rate " + getf() + "%");
    }
}
