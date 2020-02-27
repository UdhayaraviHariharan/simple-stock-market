package com.jpmc.stock.services.stock;

import java.util.List;

import com.jpmc.stock.model.stock.Stock;


public interface IStockService {
	
	public void  addStock(Stock newStock);
	
	public Double calculateDividendYield(Stock stock) throws Exception;
	
	public Double calculatePriceEarningsRatio(Stock stock);
	
	public Double calculateGBCE();
	
	public Stock getStock(String symbol);
	
	public List<Stock> getAllStocks();
	

	  
	 
}
