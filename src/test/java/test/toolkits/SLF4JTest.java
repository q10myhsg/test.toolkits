package test.toolkits;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JTest {
	 private static final Logger logger = LoggerFactory.getLogger(SLF4JTest.class);
	 @Test
	 public void testLogger(){
		 logger.debug("1");
	 }
}
