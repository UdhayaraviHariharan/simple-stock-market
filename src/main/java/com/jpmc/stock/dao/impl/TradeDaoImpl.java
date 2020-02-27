package com.jpmc.stock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.jpmc.stock.dao.trade.ITradeDao;
import com.jpmc.stock.model.trade.Trade;

public class TradeDaoImpl implements ITradeDao {

	
	private ArrayList<Trade> trades = new ArrayList<Trade>();

	public ArrayList<Trade> getTrades() {
		return trades;
	}

	public void setTrades(ArrayList<Trade> trades) {
		this.trades = trades;
	}
	
	public void addTrade(Trade trade) {
		this.trades.add(trade);
	}
	
	public List<Trade> getAllTrades(){
		return this.trades;
	}
}
