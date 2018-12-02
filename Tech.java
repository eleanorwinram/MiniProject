
/**
 * Write a description of class Tech here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tech extends Stock
{
    private boolean hardware;
    
    public Tech(String name, double cost, double fluctuation, boolean hardware)
    {   
        super(cost, name, fluctuation);
        this.hardware = hardware; 
        
    
    }
    
    public boolean geth()
    {return hardware;}
    
    public String printinfo()
    {
    
        String m="";
        if(hardware == true)
        {
        m= ("\n" +"This company provides hardware products");
    }
    
    else {
        m = ("\n" +"This company provides software products");
    }
    
    return("Stock name: "+ this.getname() + "\n The price is currently "+ this.getcost()+ " but this regularly change at the rate " + getf() + "%" + m);
    }
    public void printnews()
    {
        
        System.out.println("BREAKING NEWS \n*** Hewlett Packard have released new products and the value of shares has gone up! ***"); 
    }
}
