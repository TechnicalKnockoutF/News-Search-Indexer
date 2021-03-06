package edu.buffalo.cse.irf14.analysis;

public class Category implements Analyzer {

	TokenStream ts = null;

	Token tok = null;

	Boolean tokenFiltering = false;

	TokenFilterFactory factory = TokenFilterFactory.getInstance();
	TokenFilter filter = null;

	Analyzer an = null;

	public Category(TokenFilter filter) {
		super();
		this.filter = filter;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean increment() throws TokenizerException {
		// TODO Auto-generated method stub
		return tokenFiltering;
	}

	@Override
	public TokenStream getStream() {
		// TODO Auto-generated method stub
		ts = filter.getStream();
		return ts;
	}
	
	public Analyzer categoryTokenFilter(TokenStream stream)
	{
		filter = factory.getFilterByType(TokenFilterType.SYMBOL, stream);
		filter = factory.getFilterByType(TokenFilterType.ACCENT, filter.getStream());
		filter = factory.getFilterByType(TokenFilterType.NUMERIC, filter.getStream());
		filter = factory.getFilterByType(TokenFilterType.SPECIALCHARS, filter.getStream());
		filter = factory.getFilterByType(TokenFilterType.CAPITALIZATION, filter.getStream());
		
		an = new Category(filter);
		
		return an;
	}
}
