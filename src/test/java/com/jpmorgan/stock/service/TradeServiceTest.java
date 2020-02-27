package com.jpmorgan.stock.service;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jpmc.stock.model.stock.Stock;
import com.jpmc.stock.model.stock.StockType;
import com.jpmc.stock.model.trade.Trade;
import com.jpmc.stock.model.trade.TradeType;
import com.jpmc.stock.services.impl.TradeServiceImpl;
import com.jpmc.stock.services.trade.ITradeService;

public class TradeServiceTest {
	private static ITradeService tradeService = TradeServiceImpl.getInstance();
	
	
	@Before
	  public void setup() {

		  
	  }
	
	@Test
	public void tradeServiceInitializationTest(){


		ITradeService factoryInstanceA = TradeServiceImpl.getInstance();
		ITradeService factoryInstanceB = TradeServiceImpl.getInstance();

		Assert.assertNotNull(factoryInstanceA);
		Assert.assertNotNull(factoryInstanceB);

		Assert.assertTrue(factoryInstanceA.equals(factoryInstanceB));

	}
	
	@Test
	  public void testAddATrade() {
		Trade trade = new Trade(TradeType.BUY, new Date() ,"22" , "31", "ALE" );
		
		assertEquals(0 , tradeService.getAllTrades().size(), 0);
		
	    try {
	    	tradeService.addTrade(trade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    assertEquals(1 , tradeService.getAllTrades().size(), 0);
	  }
	
	
	@Test
	  public void testcalculateVolumeWeightedStockPrice() {
	    try {
	    		    	
			assertEquals(31.0 , tradeService.calculateVolumeWeightedStockPrice(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

	  
}
