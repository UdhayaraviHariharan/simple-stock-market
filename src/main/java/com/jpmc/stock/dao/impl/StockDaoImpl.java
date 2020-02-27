package com.jpmc.stock.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jpmc.stock.dao.stock.IStockDao;
import com.jpmc.stock.model.stock.Stock;


public class StockDaoImpl implements IStockDao{
	
	
	private List<Stock> currentHoldings = new ArrayList<Stock>();
	
	public StockDaoImpl() {
		
	}
	
	public List<Stock> getAllStocks(){
		return this.getCurrentHoldings();
	}
	
	  public void addStock(Stock stock) {
		  currentHoldings.add(stock);
	    
	  }

	 
	  public Stock getStockBySymbol(String symbol) {
		 for(Stock s : currentHoldings) {
			 if(s.getStockSymbol().equalsIgnoreCase(symbol)) {
				 return s;
			 }
		 }
		 
		 return null;
	   
	  }
	
	public List<Stock> getCurrentHoldings() {
		return currentHoldings;
	}

	public void setCurrentHoldings(List<Stock> currentHoldings) {
		this.currentHoldings = currentHoldings;
	}

}
