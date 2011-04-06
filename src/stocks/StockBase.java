package stocks;


public abstract class StockBase {
	protected int marketValue[];
	protected String stockName;
	private final int NUM_POSSIBLE_MARKET_LOCATIONS = 50;
	
	public StockBase() {
		this.marketValue = new int[NUM_POSSIBLE_MARKET_LOCATIONS];
	}
	
	public int getCurMarketValue(int marketLocation) {
		return this.marketValue[marketLocation];
	}
	
	public String getStockName() {
		return this.stockName;
	}
	
//	protected abstract void initStockPrices(); 
}
