package com.jpmorgan.stock.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.jpmc.stock.dao.impl.StockDaoImpl;
import com.jpmc.stock.dao.impl.TradeDaoImpl;
import com.jpmc.stock.dao.stock.IStockDao;
import com.jpmc.stock.dao.trade.ITradeDao;
import com.jpmc.stock.model.stock.Stock;
import com.jpmc.stock.model.stock.StockType;
import com.jpmc.stock.model.trade.Trade;
import com.jpmc.stock.model.trade.TradeType;

public class TradeDaoTest {

	ITradeDao tradeDao = new TradeDaoImpl();
	 
	 private Trade trade1 ;
	 private Trade trade2 ;
	
	 @Before
	  public void setup() {
	    
		 
		 trade1 = new Trade(TradeType.BUY, new Date(), "22", "4", "TES");
		 trade2 = new Trade(TradeType.SELL, new Date(), "22", "4", "TES");
	 }
		
	
	@Test
	  public void testGetAllTrades() {
		
	    try {
	    	assertEquals(0 , tradeDao.getAllTrades().size(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }
	
	@Test
	  public void testAddTrade() {
		
		
		assertEquals(0 , tradeDao.getAllTrades().size(), 0);
		
	    try {
	    	tradeDao.addTrade(trade1);
	    	tradeDao.addTrade(trade2);
	    	assertEquals(2 , tradeDao.getAllTrades().size(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }
	
}
