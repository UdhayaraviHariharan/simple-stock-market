package com.jpmc.stock.services.trade;

import java.util.List;

import com.jpmc.stock.model.trade.Trade;

public interface ITradeService {

	public void addTrade(Trade trade);
	
	public List<Trade> getAllTrades();
	
	public double calculateVolumeWeightedStockPrice() ;
}
