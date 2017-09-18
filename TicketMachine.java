import java.util.Scanner;

public class TicketMachine
{
    //Price, antall soner, antall biletter
    int price, zones, tickets, totalPrice;
    
    //Adding new info by request
    int numberTickets, numberZones, addMoney, totalAdded;
    
    //To calculate the price
    int zonePrice, ticketPrice, toPay;
    
    //to input new values
    Scanner in = new Scanner(System.in);
    
    public TicketMachine(int setPrice)
    {
        price = setPrice;
        totalPrice = 0;
        zones = 0;
        tickets = 0;
    }
    
    public void buyTicket()
    {
        while (zones <= 0)
        {
            System.out.println("Each zone will add a 10 dollar price increase");
            System.out.println("Pick the number of zones you wish to travel");
        
            //Input for amount of zones
            numberZones = in.nextInt();
            
            if (numberZones <= 0)
            {
                System.out.println("That's in invalid number of zones");
                System.out.println("Pick the number of zones you wish to travel?");
                System.out.println();
            }
            
            zones = numberZones;
        }
        System.out.println("Number of zones to travel: " + zones);
        System.out.println();
        
        //calls the ticketAmount function/method
        ticketAmount();
    }
    
    private void ticketAmount()
    {
        while (tickets <= 0)
        {
            System.out.println("Pick the numer of tickets you wish to buy");
            System.out.println();
            
            //Input for number of tickets
            numberTickets = in.nextInt();
            
            if (numberTickets <= 0)
            {
                System.out.println("That's in invalid number of tickets");
                System.out.println("How many tickets would you like to purchase?");
                System.out.println();
            }
            
            tickets = numberTickets;
        }
        System.out.println("Number of tickets you wish to buy: " + tickets);
        System.out.println();
        
        //Calls the ticketPrice function/method
        ticketPrice();
    }
    
    private void ticketPrice()
    {
        zonePrice = zones * 10;
        ticketPrice = tickets * price;
        toPay = ticketPrice + zonePrice;
        //Totalprice used in displaying the total amount payed in the receipt
        totalPrice = toPay;
        
        System.out.println(zones + " zones with a total of " + tickets + " will result in the total price of: " + toPay);
        System.out.println();
        
        //Calls the addPayment function/method
        addPayment();
    }
    
    private void addPayment()
    {   
        System.out.println("Remaining amount to pay: " + toPay);
        while (toPay > 0)
        {
            addMoney = in.nextInt();
            if(addMoney > 0)
            {
                totalAdded += addMoney;
            }
            //Can't add negative money
            if(addMoney > 0)
            {
                if((totalAdded - toPay) > 0)
                {
                    System.out.println("You've added to much money: " + (totalAdded - toPay));
                    payBack();
                }
                else if((totalAdded - toPay) == 0)
                {
                    toPay = 0;
                }
                else
                {
                    System.out.println("You've not added enough money!");
                    System.out.println("You're missing: " + ((totalAdded - toPay) * -1) + " dollars to continue");
                }
            }
            else
            {
                 System.out.println("You can't add negative amounts of money...");
            }
        }
        //calls the tripMessage function/method
        tripMessage();
    }
    
    private void payBack()
    {
        int payBack = totalAdded - toPay;
        
        System.out.println();
        System.out.println(payBack + " have been returned to your account");
        System.out.println();
        
        toPay = 0;
    }
    
    private void tripMessage()
    {
        System.out.println();
        System.out.println("Thank you for choosing to travel with the Zachorian Alliance Train Executive Division");
        System.out.println("We in Z.A.T.E.D wish you a smooth and relaxing trip");
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println("Zones: " + zones + "     Tickets: " + tickets);
        System.out.println(" Trip total cost: " + totalPrice);
        System.out.println("----------------------------------------------------");
        System.out.println();
    }
}