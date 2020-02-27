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
import com.jpmc.stock.services.impl.StockServiceImpl;
import com.jpmc.stock.services.impl.TradeServiceImpl;
import com.jpmc.stock.services.stock.IStockService;
import com.jpmc.stock.services.trade.ITradeService;


public class StockServiceTest {

	 private static IStockService stockService = StockServiceImpl.getInstance();
	 
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
	public void stockServiceInitializationTest(){


		IStockService factoryInstanceA = StockServiceImpl.getInstance();
		IStockService factoryInstanceB = StockServiceImpl.getInstance();

		Assert.assertNotNull(factoryInstanceA);
		Assert.assertNotNull(factoryInstanceB);

		Assert.assertTrue(factoryInstanceA.equals(factoryInstanceB));
	}
	

	
	@Test
	  public void testCalculateDividendYield() {
	    try {
	    	
			assertEquals(1.0767790262172285 , stockService.calculateDividendYield(stock1), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	@Test
	  public void testCalculatePriceEarningsRatio() {
	    try {
	    	
			assertEquals(4.732 , stockService.calculatePriceEarningsRatio(stock2), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }


	
	@Test
	  public void testcalculateGBCE() {
	    try {
	    		    	
			assertEquals(2.4970000328945963 , stockService.calculateGBCE(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
