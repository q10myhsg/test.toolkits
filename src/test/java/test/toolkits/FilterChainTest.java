package test.toolkits;



import org.junit.Test;

import test.fc.filterchain.AfterAction;
import test.fc.filterchain.AfterAction2;
import test.fc.filterchain.Filter;
import test.fc.filterchain.FilterChain;

public class FilterChainTest {
	@Test
	public void testFilterChain() {
		FilterChain fc = new FilterChain();
		Filter f1 = new Filter();
		f1.appendAction(new AfterAction() );
		f1.setPriority(6);
		fc.addFilter(f1);
		Filter f2 = new Filter();
		f2.appendAction(new AfterAction2() );
		f2.setPriority(7);
		fc.addFilter(f2);		
		fc.doFilter();
				
	}
}
