package com.jpmc.stock.model.trade;

import java.util.Date;


public class Trade implements Comparable<Trade>{
	private TradeType tradeType;
	
	private Date tradeTime;
	
	private String numberOfShares;
	
	private String tradePrice;
	
	private String stockSymbol;

	public int compareTo(Trade trade) {
	    return trade.getTradeTime().compareTo(this.tradeTime);
	  }

	
	public Trade(TradeType tradeType, Date tradeTime, String numberOfShares, String tradePrice, String stockSymbol) {
		super();
		this.tradeType = tradeType;
		this.tradeTime = tradeTime;
		this.numberOfShares = numberOfShares;
		this.tradePrice = tradePrice;
		this.stockSymbol = stockSymbol;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(String numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(String tradePrice) {
		this.tradePrice = tradePrice;
	}
	

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numberOfShares == null) ? 0 : numberOfShares.hashCode());
		result = prime * result + ((tradePrice == null) ? 0 : tradePrice.hashCode());
		result = prime * result + ((tradeTime == null) ? 0 : tradeTime.hashCode());
		result = prime * result + ((tradeType == null) ? 0 : tradeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (numberOfShares != other.numberOfShares)
			return false;
		if (tradePrice == null) {
			if (other.tradePrice != null)
				return false;
		} else if (!tradePrice.equals(other.tradePrice))
			return false;
		if (tradeTime == null) {
			if (other.tradeTime != null)
				return false;
		} else if (!tradeTime.equals(other.tradeTime))
			return false;
		if (tradeType != other.tradeType)
			return false;
		return true;
	}

	public Object stream() {
		// TODO Auto-generated method stub
		return null;
	}
}
