package com.jpmc.stock.dao.stock;

import java.util.List;

import com.jpmc.stock.model.stock.Stock;

public interface IStockDao {
	 public void addStock(Stock stock) ;
 
	 public Stock getStockBySymbol(String symbol);
	 
	 public List<Stock> getAllStocks();
}
