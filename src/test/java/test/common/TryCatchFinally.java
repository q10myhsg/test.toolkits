package test.common;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryCatchFinally {
	private static final Logger logger = LoggerFactory.getLogger(TryCatchFinally.class);

	private int getData() {

		int ret = 0;
		String text = "1";
		try {
			ret = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			ret = 1;
			logger.debug("catching-------------------");
		} finally {
			ret = 2;
			logger.debug("finally----------------------");
		}
	    logger.debug("getData-------------------------");
		return ret;
	}

	@Test
	public void testTryCatch() {
		TryCatchFinally tcf = new TryCatchFinally();
		logger.debug(tcf.getData() + "");
	}
}
