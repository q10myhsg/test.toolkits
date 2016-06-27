package test.jedis.set;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanResult;

public class JedisSetTest {
	private static final Logger logger = LoggerFactory.getLogger(JedisSetTest.class);
	@Test
	public void testJedisSet() {
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("123.57.11.88");
		jedis.auth("fangcheng");
//		Jedis jedis = new Jedis("192.168.1.4");
		File f = new File("category3.txt");

		boolean flag = true;
		String cur = "0";
		ScanResult<String> sr;
		while(flag){
			sr = jedis.sscan("category3", cur);
			List<String> l =  sr.getResult();
			Iterator<String> it = l.iterator();
			while(it.hasNext()){
				try {
					String str = it.next();
					FileUtils.writeStringToFile(f, str+"\r\n", true);
					logger.info(str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			cur =  sr.getStringCursor();
			if(Integer.parseInt(cur)<1){
				flag=false;
			}
		}
	}
	
	
}
