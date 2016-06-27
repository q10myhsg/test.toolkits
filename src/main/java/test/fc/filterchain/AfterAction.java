package test.fc.filterchain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AfterAction implements Action {
	private static final Logger logger = LoggerFactory.getLogger(AfterAction.class);

	@Override
	public void doAction() {
		logger.debug("=======AfterAction=========");
	}
}
