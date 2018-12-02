
/**
 * Write a description of class MyGui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.UIManager;
import java.util.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.net.URL;
import javax.sound.sampled.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MyGui extends Frame implements ActionListener, WindowListener
{
    private TextField deposit;
    private TextField quantity;
    private TextArea messages;
    private TextField info;
    private TextField stocktype;

    private Label ldeposit;
    private Label lquantity;

    private Label linfo;
    private Label lstocktype;

    private Label lstocktypeout;
    private Button addbuy;
    private Button addsell;
    private Button addinfo;
    private Button adddeposit;
    private Button addoldactions;
    private Button addfile;
    private JButton addbexit;

    private final int WIDTH = 600;
    private final int HEIGHT = 660;

    public MyGui()
    {

        setLayout (new BoxLayout (this, BoxLayout.Y_AXIS));  
        setSize(400,400);  
        setVisible(true);
        setTitle("STOCK SIMULATOR");
        setSize(WIDTH, HEIGHT);
        setview();

        addbuy = new Button("Buy Stock");
        addsell = new Button("Sell Stock");
        addinfo = new Button("Get information");
        adddeposit = new Button("Desposit Funds");
        addoldactions = new Button("View Todays Actions");
        addfile = new Button("Save to file");
        addbexit = new JButton("EXIT");
        deposit =new TextField("",20);
        stocktype =new TextField("",20);
        quantity =new TextField("",20);
        info =new TextField("",20);

        ldeposit = new Label("deposit: ");
        lstocktype = new Label("1)PLT \n2)HP \n3)Cadbury: ");
        lquantity = new Label("quantity: ");
        linfo = new Label("information: ");
        messages = new TextArea("");
        messages.setEditable(false);

        lstocktypeout = new Label("");

        add(ldeposit); add(deposit);
        add(lquantity); add(quantity);
        add(lstocktype); add(stocktype);        
        add(messages);
        add(addbuy);
        add(addsell);
        add(addinfo);
        add(adddeposit);
        add(addoldactions);
        add(addfile);
        add(addbexit);
        addWindowListener(this);
        adddeposit.addActionListener(new adddeposit());
        addbuy.addActionListener(new addbuy());
        addsell.addActionListener(new addsell());
        addinfo.addActionListener(new addinfo());
        addoldactions.addActionListener(new addoldactions());
        addfile.addActionListener(new addfile());
        addbexit.addActionListener(new addbexit());
        setVisible(true);
    }

    Stock fash1 = new Fashion("PLT", 245.00, 0.56, "High Street Fashion");
    Stock t1 = new Tech("HP", 345.00, 0.23, true);
    Stock f3 = new Food("cadbury", 256, 0.45, true);
    Account acc1 = new Account(12345, 210000000.98);
    ArrayList<String> ownedshares = new ArrayList<String>();

    private void setview() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            // ignore error 
        }
    }

    public void randomnews()
    {
        Random r = new Random();
        int n = r.nextInt(3);

        String [] news = new String [3];
        news[0] = "BREAKING NEWS \n *** The stock for company PLT has just fallen by 4% we would reccomend that you buy ***";
        news[1] ="BREAKING NEWS \n*** Hewlett Packard have released new products and the value of shares has gone up! ***";
        news[2] = "BREAKING NEWS \n*** Cadbury has been taken over by the company Kraft foods. Share values have increased by 2%";

        String var1 = news[n];
        messages.setText(messages.getText() + "\n"+ var1);
    }
    private class addbuy implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            String m = stocktype.getText();
            int number =Integer.parseInt(quantity.getText());
            if(m.equals("1"))
            {
                double c = fash1.getcost();
                c = c*number;
                acc1.boughtshares(c);
                messages.setText(messages.getText() + "\nyour new balance is " + acc1.getbalance());
                ownedshares.add("You bought " + number + " shares in PLT");
            }
            else if(m.equals("2"))
            {
                double c = t1.getcost();

                c = c*number;
                acc1.boughtshares(c);
                messages.setText(messages.getText() + "\nyour new balance is " + acc1.getbalance());
                ownedshares.add("You bought " + number + " shares in HP");
            }
            else if(m.equals("3"))
            {
                double c = f3.getcost();
                c = c*number;
                acc1.boughtshares(c);
                messages.setText(messages.getText() + "\nyour new balance is " + acc1.getbalance());
                ownedshares.add("You bought " + number + " shares in Cadbury");
            }
            randomnews();

        }
    }
    private class addsell implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            String m = stocktype.getText();
            int number =Integer.parseInt(quantity.getText());
            if(m.equals("1"))
            {
                double c = fash1.getcost();
                c = c*number;
                acc1.soldshares(c);
                messages.setText("your new balance is " + acc1.getbalance());
                ownedshares.add("You sold " + number + " shares in PLT");
            }
            else if(m.equals("2"))
            {
                double c = t1.getcost();

                c = c*number;
                acc1.soldshares(c);
                messages.setText("your new balance is " + acc1.getbalance());
                ownedshares.add("You sold " + number + " shares in HP");
            }
            else if(m.equals("3"))
            {
                double c = f3.getcost();
                c = c*number;
                acc1.soldshares(c);
                messages.setText("your new balance is " + acc1.getbalance());
                ownedshares.add("You sold " + number + " shares in Cadbury");
            }
            randomnews();

        }

    }
    private class addinfo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {

            messages.setText(messages.getText() + "\n"+ fash1.printinfo() + "\n" + t1.printinfo() + "\n"+ f3.printinfo()); 

        }
    }
    private class adddeposit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {

            acc1.setbalance(Double.parseDouble(deposit.getText()));

            messages.setText(messages.getText() + "\n" +"Funds added"); 
            //System.out.println("Deposited");
        }
    }
    private class addoldactions implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            System.out.println("PREVIOUS TRADING ACTIONS DOCUMENTED");
            System.out.println("***********************************");
            for(int i=0; i<ownedshares.size(); i++)
            {
                System.out.println(ownedshares.get(i));
            }
            System.out.println("Your balance is now : £" + acc1.getbalance());
            System.out.println("***********************************");
            System.out.println("*********** END DOCUMENT **********");
        }
    }

    private class addfile implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            try{
                PrintWriter outputStream = new PrintWriter(new FileWriter("stocklist.txt"));

                for(int i=0; i<ownedshares.size(); i++)
                {
                    outputStream.println(ownedshares.get(i));
                }

                outputStream.close();
            }
            catch(IOException e)
            {

                messages.setText(messages.getText() +"file was unable to save at this time");
            }
        }
    }
    private class addbexit implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt)
        {
            try 
            {
                URL files = this.getClass().getClassLoader().getResource("sound.wav");
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(files);
                Clip clip = AudioSystem.getClip( );
                clip.open(audioInputStream);
                clip.start( );

            }
            catch(Exception e)
            {
                System.out.println("Error with playing sound.");

            }
            new java.util.Timer().schedule( 
                new java.util.TimerTask() 
                {
                    @Override
                    public void run() 
                    {
                        System.exit(0);
                    }
                }, 

                6000 
            );

        }
    }
    @Override
    public void windowClosing(WindowEvent event) {

        System.exit(0);

    }

    public static void main(String [] args)
    {
        try{ 

            MyGui g = new MyGui();

        }
        catch(Exception e){
            System.out.println("Please use terminal not GUI. \nGUI currently out of order.");
        }
    }

    @Override public void actionPerformed(ActionEvent event) { }

    @Override public void windowOpened(WindowEvent event) { }

    @Override public void windowClosed(WindowEvent event) { }

    @Override public void windowIconified(WindowEvent event) { }

    @Override public void windowDeiconified(WindowEvent event) { }

    @Override public void windowActivated(WindowEvent event) { }

    @Override public void windowDeactivated(WindowEvent event) { }
}