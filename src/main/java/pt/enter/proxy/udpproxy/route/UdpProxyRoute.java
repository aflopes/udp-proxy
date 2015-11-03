package pt.enter.proxy.udpproxy.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pt.enter.proxy.udpproxy.config.UdpProxyCmdLineConfig;

@Component
public class UdpProxyRoute extends RouteBuilder {

	@Autowired
	UdpProxyCmdLineConfig config;
	
	@Override
	public void configure() throws Exception {
		from("netty:udp://"+ config.getSourceHost() + ":" + config.getSourcePort() + "?allowDefaultCodec=false&decoder=#stringDecoder")
		.log(LoggingLevel.INFO, "Message Received")
		.to("netty:udp://"+ config.getTargetHost() + ":" + config.getTargetPort());
	}
}
