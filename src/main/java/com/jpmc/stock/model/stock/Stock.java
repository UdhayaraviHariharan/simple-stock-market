package com.jpmc.stock.model.stock;

public class Stock {

	private String stockSymbol;
	
	private StockType stockTType;
	
	private Double lastDividend;
	
	private Double fixedDividend;
	
	private Double parValue;
	
	private Double currentPrice;
	
	private int numberOwnedCurrently ;


	public Stock(String stockSymbol, StockType stockTType, Double lastDividend, Double fixedDividend,
			Double parValue) {
		super();
		this.stockSymbol = stockSymbol;
		this.stockTType = stockTType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		
		
		this.currentPrice = lastDividend;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockType getStockTType() {
		return stockTType;
	}

	public void setStockTType(StockType stockTType) {
		this.stockTType = stockTType;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double finalDividend) {
		this.fixedDividend = finalDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}
	
	public Double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getNumberOwnedCurrently() {
		return numberOwnedCurrently;
	}

	public void setNumberOwnedCurrently(int numberOwnedCurrently) {
		this.numberOwnedCurrently = numberOwnedCurrently;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fixedDividend == null) ? 0 : fixedDividend.hashCode());
		result = prime * result + ((lastDividend == null) ? 0 : lastDividend.hashCode());
		result = prime * result + ((parValue == null) ? 0 : parValue.hashCode());
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result + ((stockTType == null) ? 0 : stockTType.hashCode());
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
		Stock other = (Stock) obj;
		if (fixedDividend == null) {
			if (other.fixedDividend != null)
				return false;
		} else if (!fixedDividend.equals(other.fixedDividend))
			return false;
		if (lastDividend == null) {
			if (other.lastDividend != null)
				return false;
		} else if (!lastDividend.equals(other.lastDividend))
			return false;
		if (parValue == null) {
			if (other.parValue != null)
				return false;
		} else if (!parValue.equals(other.parValue))
			return false;
		if (stockSymbol != other.stockSymbol)
			return false;
		if (stockTType != other.stockTType)
			return false;
		return true;
	}

	
}
