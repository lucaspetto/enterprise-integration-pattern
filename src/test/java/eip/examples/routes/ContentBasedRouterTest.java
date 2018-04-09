package eip.examples.routes;

import java.io.File;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import eip.examples.content.FilesTypes;
import eip.examples.routes.ContentBasedRouter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentBasedRouterTest extends CamelTestSupport {

	@Override
	protected RoutesBuilder createRouteBuilder() throws Exception {

		return new ContentBasedRouter();
	}
	
	@Test
	public void contentBasedRouterTest() throws InterruptedException {
		
		Thread.sleep(5000);
		
		File file = new File(FilesTypes.JSON.name());
		
		assertTrue(file.isDirectory());
	}
}
