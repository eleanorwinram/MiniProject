
/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends Stock
{
    private boolean perishable;
    
    public Food (String name, double cost, double fluctuation, boolean perishable)
    {   
        super(cost, name, fluctuation);
        this.perishable = perishable;
        
    
    }
    
    public boolean getp()
    {return perishable;}
    
    public String printinfo()
    {
       
        String m= "";
        if(perishable == true)
        {
            m =( "\n"+getname() + " provides mostly perishable foods");
        }
        else {
            m = ("\n"+ getname() + " provides mostly non-perishable foods");
        }
        
        return ("Stock name: "+ this.getname() + "\n The price is currently "+ this.getcost()+ " but this regularly change at the rate " + getf() + "%" + m);
    }
    
    public void printnews()
    {
        System.out.println("BREAKING NEWS \n*** " + getname() + " has been taken over by the company Kraft foods. Share values have increased by 2%");
    }
}
