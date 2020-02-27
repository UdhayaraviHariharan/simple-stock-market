package com.jpmc.stock;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.jpmc.stock.dao.impl.StockDaoImpl;
import com.jpmc.stock.model.stock.Stock;
import com.jpmc.stock.model.stock.StockType;
import com.jpmc.stock.model.trade.Trade;
import com.jpmc.stock.model.trade.TradeType;
import com.jpmc.stock.services.stock.IStockService;
import com.jpmc.stock.services.trade.ITradeService;

import jdk.internal.jline.internal.Log;

import com.jpmc.stock.services.impl.TradeServiceImpl;
import com.jpmc.stock.services.impl.StockServiceImpl;

public class SimpleStockMarket {

	static Logger logger = Logger.getLogger(SimpleStockMarket.class.getName());
	private static Scanner scanner;
	 private static IStockService stockService = StockServiceImpl.getInstance();
	 private static ITradeService tradeService = TradeServiceImpl.getInstance();
	 
	 
	 
	SimpleStockMarket(){
		SimpleStockMarketRun();
	}

	
	public static void SimpleStockMarketRun() {
		
		
		displayUserOptions();
    	
        scanner = new Scanner(System.in);
        String userInput= null;
        boolean exitNow = false;
        
        while (true) {
        	userInput = scanner.nextLine();
        	
          if (exitNow) {
            scanner.close();
            System.exit(0);
          } 
          
          else {
            try {
              int option = Integer.parseInt(userInput);
          
              switch (option) {
                case 1:
                	calculateDividendYield();
                	break;
                case 2:
                  calculatePERatio();
                  break;
                case 3:
                	addTrade();
                   break;
                case 4:
                calculateVolumeWeightedStockPrice();
                  break;
                case 5:
                  calculateGBCE();
                  break;
                default:
                  break;
              }
            } catch (Exception e) {
            	logger.info("Invalid Input");
             
            } 
           
            
            System.out.println("\n\n Do You Want to Continue ? ");
            System.out.println("Enter N to Exit ; Any other key to Continue");
            
            userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("N")) {
            	exitNow  = true;
            	
            	 System.out.println("\n\n Thank you for using Simple Stock Market");
            }
            else {
            	displayUserOptions();
            }
        
          }
        }
        }

    private static void displayUserOptions() {
        
        System.out.println("1 -  Calculate dividend yield for stock");
        System.out.println("2 -  Calculate P/E ratio for stock");
        System.out.println("3 -  Record a trade for stock");
        System.out.println("4 -  Calculate Volume Weighted Stock Price for stock");
        System.out.println("5 -  Calculate GBCE All Share Index");
        
        System.out.print(" \n\n Enter a Value between 1 and 5 :   ");
        
      }
 
    
    /**
     * This is a common Method to get User input
     * @return Stock
     */
    public static Stock getUserInput() {
 	   System.out.print("Enter Stock : ");
 	   String stockEntered = scanner.nextLine();
 	   
 	   System.out.print("Enter Stock Price : ");
 	   String stockPrice = scanner.nextLine();
 	   
 	   
 	   
		/*
		 * if(Integer.parseInt(stockPrice) <10001 ) {
		 * System.out.println(Integer.parseInt(stockPrice)); }
		 */
 	   
 	   Stock stock = stockService.getStock(stockEntered.toUpperCase());
 	   if(stock==null) {
 		   logger.info("You do not own the stock : " + stockEntered);
 	   }
 	   else {
 		   stock.setCurrentPrice(Double.parseDouble(stockPrice));
 	   }
  	   return stock;
 	   
    }
    /**
     * This is a common Method to get User input For trade
     * @return Stock
     */
    public static Stock getUserTradeInput() {
  	 
  	   System.out.print("Enter 'B' for Buy or 'S' for Sell : ");
  	   String buySellInd = scanner.next();
  	   
  	   if (buySellInd.equalsIgnoreCase("B")) {
  		 System.out.println("Enter Stock to Buy : ");
  		String stockEntered = scanner.nextLine();
		   	
		    System.out.println("Enter Number of Stocks to Buy : ");
		   	String numberToBuy = scanner.nextLine();
		   	
		    System.out.println("Enter Stock Price : ");
		    String stockPrice = scanner.nextLine();
		    
		    Stock stock = stockService.getStock(stockEntered.toUpperCase());
		   	if(stock!=null)
		   	{
		   		stock.setNumberOwnedCurrently(stock.getNumberOwnedCurrently() + Integer.parseInt(numberToBuy));
		   	}
		   	else
		   	{
		   		System.out.println("Adding New Stock to your portfolio");
		   		stockService.addStock(new Stock(stockEntered, StockType.COMMON , Double.parseDouble(stockPrice), 0.0, 46.0));
		   	}
  		   
  	   }
  	   else if (buySellInd.equalsIgnoreCase("S")) {
  		   System.out.println("Your Current Holdings");
  		   List<Stock> currentHoldings = stockService.getAllStocks();
  		   
  		   for(Stock s : currentHoldings) {
  			   System.out.println(s.getStockSymbol());
  		   }
  		   System.out.println("Enter Stock to Sell : ");
  		   	String stockEntered = scanner.nextLine();
  		   	Stock stock = stockService.getStock(stockEntered.toUpperCase());
  		   	
  		   	if(stock!=null) {
  		   	 System.out.println("You have " + stock.getNumberOwnedCurrently() + " Number of "+ stock.getStockSymbol()+ " stocks");
  		   System.out.println("How many shares do you want to sell? " );
  		   int sell = scanner.nextInt();
  		   
  		   while(sell > stock.getNumberOwnedCurrently()) {
  			   System.out.println("Cannot Sell : You Own " + stock.getNumberOwnedCurrently()+ " Number of Shares");
  			 System.out.println("Enter number of Shares to Sell again : ");
  			 sell = scanner.nextInt();
  		   }
  		   
  		   	}

  		   
  	   }
  	   else {
  		   System.out.println("Invalid Input");
  	   }
  	   
  	  Stock stock = stockService.getStock("");
  	   
  	  
  	   
  	   return stock;
  	   
     }
    
  /**
   * This method is used to calculate the Dividend Yield for the current stock input.
   * It calls the getUserInput() to get user inputs and calls the calculateDividendYield from the Stock 
   */
   private static void calculateDividendYield() {
	    
	  Stock stock =  getUserInput();
	  if(stock!=null) {
	  Double dividendYield = Double.MIN_VALUE;
	   
	    try {
	    	dividendYield= stockService.calculateDividendYield(stock);
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	    System.out.println("Dividend Yield : " + dividendYield);
	  }
   }
   
   /**
    * This method is used to calculate the PE Ratio for the current stock input.
    * It calls the getUserInput() to get user inputs and calls the calculateDividendYield from the Stock 
    */
   public static void calculatePERatio() {
	   
	   Stock stock = getUserInput();
	   
	   if(stock!=null) {
	   Double peRatio = Double.MIN_VALUE;
	   
	   if(stock.getLastDividend() == 0) {
		   System.out.println("Dividend of " + stock.getStockSymbol() + " = 0 : P/E Ratio Inapplicable");
		  
	   }
	   else {
	   	   try {
		   peRatio= stockService.calculatePriceEarningsRatio(stock);
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   System.out.println("P/E Ratio:  " + peRatio);
	   }
	   }
   }
   
   public static void addTrade() {
	   
	   //getUserTradeInput();
	   System.out.print("Enter Stock to Trade ");
  	   String stockSymbol = scanner.next();
	   
  	   boolean correctInput = false;
  	   
  	   System.out.print("Enter 'B' for Buy or 'S' for Sell : ");
	   String buySellInd = scanner.next();
	   
	   TradeType tradeType= TradeType.BUY;
	   while (!correctInput) {
	   
	   if(buySellInd!=null && !buySellInd.isEmpty() )
	   {
		   if(buySellInd.length() != 1) {
			   correctInput = false;
		   }
		   
		   else {
			   if(buySellInd.equalsIgnoreCase("s") ) {
				   tradeType = TradeType.SELL;
			   }
			   
			   if(buySellInd.equalsIgnoreCase("s") || buySellInd.equalsIgnoreCase("b")) {
				   correctInput = true;
			   }
		   }
	   }
	   if(!correctInput) {
		   System.out.print("Invalid Input : Please Try Again  ");
	   System.out.print("Enter 'B' for Buy or 'S' for Sell : ");
	   buySellInd = scanner.next();
	   }
	   }

  	   
  	   
  	  System.out.print("Enter number of Shares : ");
 	   String numberOfShares = scanner.next();
 	   
 	   
   	  System.out.print("Enter Trade Price : ");
  	   String tradePrice = scanner.next();
  	   
  	   
 	   Trade trade = new Trade(tradeType , new Date(), numberOfShares,tradePrice, stockSymbol);
 	  tradeService.addTrade(trade);
 	  logger.info("Trade Executed Successfully");
 	   
 	  
 	  
 	  List<Trade> trades = tradeService.getAllTrades();
 	  if(trades!=null) {
 	  System.out.println("Number of Trades Done So Far : " + trades.size());
 	  System.out.println("Stocks Traded : ");
 	  for(Trade t : trades) {
 		  System.out.print(" " +t.getStockSymbol());
 	  }
 	  }
 	  
   }
   
   /**
    * This method is used to calculate the GBCE for the current stocks .
    */
  public static void calculateGBCE() {
	   
	   Double gbce = stockService.calculateGBCE();
	   System.out.println("GBCE : " + gbce);
	   
   } 
  /**
   * This method is used to calculate the Volume Weighted Stock Price.
   */
  public static void calculateVolumeWeightedStockPrice() {
	   
	   Double vwsp = tradeService.calculateVolumeWeightedStockPrice();
	   System.out.println("Volume Weighted Stock Price : " + vwsp);
	   
   }
   
   

}
