package test.toolkits;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonIOTest {
	private static final Logger logger = LoggerFactory.getLogger(CommonIOTest.class);

	@Test
	public void testCommonIoFile() {
		logger.debug(FileUtils.getUserDirectory().getAbsolutePath());
		File f = new File("123.txt");
		try {
			FileUtils.write(f, "1\r\n", true);
			FileUtils.write(f, "2\r\n", true);
			FileUtils.write(f, "3", true);
			LineIterator l = FileUtils.lineIterator(f);
			while (l.hasNext()) {
				String str = l.nextLine();
				logger.info(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testStringBuffer(){
		
	}
}
