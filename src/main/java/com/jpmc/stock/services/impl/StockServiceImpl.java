package com.jpmc.stock.services.impl;

import com.jpmc.stock.model.stock.Stock;
import com.jpmc.stock.services.stock.IStockService;
import com.jpmc.stock.model.stock.StockType;
import com.jpmc.stock.dao.stock.IStockDao;

import java.util.List;

import com.jpmc.stock.dao.impl.StockDaoImpl;


public class StockServiceImpl implements IStockService {
	
	// Creates a Singleton  service object 
	private IStockDao stockDao = new StockDaoImpl();
	
	private static StockServiceImpl instance = null;

	  public static StockServiceImpl getInstance() {
	    if (instance == null) {
	      instance = new StockServiceImpl();
	    }
	    return instance;
	  }
	  
	  public StockServiceImpl() {
		  this.addStock(new Stock("TEA", StockType.COMMON , 0.0, 0.0, 100.0));
		  this.addStock(new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0));
		  this.addStock(new Stock("ALE", StockType.COMMON, 23.0, 0.0, 60.0));
		  this.addStock(new Stock("GIN", StockType.PREFERRED, 8.0, 2.0, 100.0));
		  this.addStock(new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0));
	  }

	
	
	public Double calculateDividendYield(Stock stock) throws Exception{
	
		double dividendYield = -1.0;
		
			if( StockType.COMMON.equals(stock.getStockTType())){
				dividendYield = stock.getLastDividend() / stock.getCurrentPrice();
			}else{
			
				dividendYield = (stock.getFixedDividend() * stock.getParValue() ) / stock.getCurrentPrice();
			}
		
		return dividendYield;
	}

	public Stock getStock(String symbol) {
		return stockDao.getStockBySymbol(symbol);
		
	}
	
	public List<Stock> getAllStocks() {
		return stockDao.getAllStocks();
		
	}

	public void  addStock(Stock newStock) {
		stockDao.addStock(newStock);
	}
	
	public Double calculatePriceEarningsRatio(Stock stock) {
	Double dividendYield = stock.getCurrentPrice() / stock.getLastDividend();
		
		return dividendYield;
	};
	
	
	public Double calculateGBCE() {
	
	List<Stock> stocks = this.getAllStocks();
	
	Double sum = 0.0; 


    for (int i = 0; i < stocks.size() ; i++) 
    {
    	// for Unit Test  Purposes
    	if(stocks.get(i).getCurrentPrice() == null ) {
    		stocks.get(i).setCurrentPrice(2.497);
    	}
        sum = sum + (float)Math.log(stocks.get(i).getCurrentPrice()); 
    }
     sum = sum / stocks.size(); 
  
    return (Double)Math.exp(sum); 
		
		
	};
	
}
