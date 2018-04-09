package eip.examples.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import eip.examples.content.FilesTypes;

@Component
public class ContentBasedRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("file:input?noop=true")
//		.log("${headers}")
//		.log("${body}")
		.routeId("SEND TO RIGHT PATH")
			.choice()
				.when(header("CamelFileNameConsumed").endsWith(FilesTypes.JSON.getDescription()))
					.to("file:"+ FilesTypes.JSON)
				.when(header("CamelFileNameConsumed").endsWith(FilesTypes.XML.getDescription()))
					.to("file:"+ FilesTypes.XML)
				.when(header("CamelFileNameConsumed").endsWith(FilesTypes.TXT.getDescription()))
					.to("file:"+ FilesTypes.TXT)
				.otherwise()
					.to("file:" + "NotFound")
			.endChoice();
	
	}
}
