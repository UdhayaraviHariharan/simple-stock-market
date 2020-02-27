package com.jpmorgan.stock.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.stock.dao.impl.StockDaoImpl;
import com.jpmc.stock.dao.stock.IStockDao;
import com.jpmc.stock.model.stock.Stock;
import com.jpmc.stock.model.stock.StockType;
import com.jpmc.stock.model.trade.Trade;
import com.jpmc.stock.model.trade.TradeType;

public class StockDaoTest {
	IStockDao stockDao = new StockDaoImpl();
	
	 
	 private Stock stock1 ;
	 private Stock stock2 ;
	 private Stock stock3 ;
	 
	 @Before
	  public void setup() {
	    
		 
	    stock1 = new Stock("TEST", StockType.COMMON, 23.0, 0.0, 16.0);
	    stock2 = new Stock("TEST2", StockType.COMMON, 5.0, 3.0, 2.0);
	    stock3 = new Stock("TEST3", StockType.PREFERRED, 5.0, 0.0, 1.0);
		  stock1.setCurrentPrice(21.36);
		  stock2.setCurrentPrice(23.66);
		  stock3.setCurrentPrice(3.3);
		  
	  }
	  
	 
	@Test
	  public void testGetAllStocks() {
		
	    try {
	    	assertEquals(0 , stockDao.getAllStocks().size(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }
	
	@Test
	  public void testAddStocks() {
		assertEquals(0 , stockDao.getAllStocks().size(), 0);
		
	    try {
	    	stockDao.addStock(stock1);
	    	stockDao.addStock(stock2);
	    	assertEquals(2 , stockDao.getAllStocks().size(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }
	
	@Test
	  public void testGetAllStocksAfterAdd() {
	assertEquals(0 , stockDao.getAllStocks().size(), 0);
		
	    try {
	    	stockDao.addStock(stock1);
	    	stockDao.addStock(stock2);
	    	assertEquals(2 , stockDao.getAllStocks().size(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }
}
