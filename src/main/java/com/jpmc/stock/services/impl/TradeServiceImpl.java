package com.jpmc.stock.services.impl;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.jpmc.stock.dao.impl.TradeDaoImpl;
import com.jpmc.stock.dao.trade.ITradeDao;
import com.jpmc.stock.model.stock.Stock;
import com.jpmc.stock.model.trade.Trade;
import com.jpmc.stock.services.trade.ITradeService;


public class TradeServiceImpl implements ITradeService{
	private ITradeDao tradeDao = new TradeDaoImpl();
	private static TradeServiceImpl instance = null;

	  public static TradeServiceImpl getInstance() {
	    if (instance == null) {
	      instance = new TradeServiceImpl();
	    }
	    return instance;
	  }

	  
	public void addTrade(Trade trade) {
		tradeDao.addTrade(trade);
		
	}
	
	public List<Trade> getAllTrades(){
		return tradeDao.getAllTrades();
	}
	
	

	private static Date getTimeAheadByMins15(){
	    Calendar calendar = Calendar.getInstance();
	    calendar.add(Calendar.MINUTE, - 15);
	    return calendar.getTime();
	}
	  
	public List<Trade> getTradesMinusMins15()
	{
	    List<Trade> result = new ArrayList<Trade>();
	    Date logicDate = getTimeAheadByMins15();
	   
	    List<Trade> trades = this.getAllTrades();
	    Collections.sort(trades);
	  
	    Iterator<Trade> it = trades.iterator();
	    while (it.hasNext()) {
	      Trade t = it.next();
	      if (t.getTradeTime().before(logicDate)) {
	        break;
	      }
	      result.add(t);
	    }
	    return result;
	}
	
	public double calculateVolumeWeightedStockPrice() {
		
		
		List<Trade> trades = this.getTradesMinusMins15();
		
	    double sumOfPriceQuantity = 0;
	    int sumOfQuantity = 0;

	    if(trades==null || trades.size() ==0) {
	    	System.out.println(" There is no Trades done in your Account - Cannot calculate Volume Weighted Stock Price");
	    	return 0.0	 ;
	    }
	    else {
	    	
	   
	    for (Trade trade : trades) {
	      sumOfPriceQuantity = sumOfPriceQuantity + (Double.parseDouble(trade.getTradePrice()) * Double.parseDouble(trade.getNumberOfShares()));
	      sumOfQuantity = (int) (sumOfQuantity + Double.parseDouble(trade.getNumberOfShares()));
	    }
	    double result = sumOfPriceQuantity / sumOfQuantity;
	    return result;
	    }
	  }
	  
}
