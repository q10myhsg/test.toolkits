package test.fc.filterchain;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FilterChain  extends Filter{
	List<Filter> filters = new LinkedList<Filter>();
	int index = 0;
	
	public FilterChain addFilter(Filter f) {
		this.filters.add(f);
		Collections.sort(filters);
		return this;
	}
	
	@Override
	public boolean doFilter() {
		
		Iterator<Filter> it = filters.iterator();
		boolean flag=true;
		while(flag&&it.hasNext()){
			Filter f = it.next();
			flag = f.doAction();
		}
		return flag;
	}
}
