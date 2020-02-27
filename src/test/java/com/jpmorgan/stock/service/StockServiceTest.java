package com.jpmorgan.stock.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jpmc.stock.services.impl.StockServiceImpl;
import com.jpmc.stock.services.impl.TradeServiceImpl;
import com.jpmc.stock.services.stock.IStockService;
import com.jpmc.stock.services.trade.ITradeService;


public class StockServiceTest {

	 private static IStockService stockService = StockServiceImpl.getInstance();
	 private static ITradeService tradeService = TradeServiceImpl.getInstance();
	 
	 

    @Before
    public void setup() {
        
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
	public void tradeServiceInitializationTest(){


		ITradeService factoryInstanceA = TradeServiceImpl.getInstance();
		ITradeService factoryInstanceB = TradeServiceImpl.getInstance();

		Assert.assertNotNull(factoryInstanceA);
		Assert.assertNotNull(factoryInstanceB);

		Assert.assertTrue(factoryInstanceA.equals(factoryInstanceB));

	}
}
