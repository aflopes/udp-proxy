package pt.enter.proxy.udpproxy.config;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import pt.enter.proxy.udpproxy.App;

@Configuration
@ComponentScan({
	"pt.enter.proxy.udpproxy.route",
	"pt.enter.proxy.udpproxy.service",
	})
public class UdpProxySpringConfiguration extends CamelConfiguration {

	@Bean(name="stringDecoder")
	public StringDecoder getStringDecoder(){
		return new StringDecoder();
	}
	
	@Bean(name="stringEncoder")
	public StringEncoder getStringEncoder(){
		return new StringEncoder();
	}
	
	@Bean
	@Scope("singleton")
	public UdpProxyCmdLineConfig getConfig(){
		return (UdpProxyCmdLineConfig) System.getProperties().get(App.UDP_PROXY_CONFIG);
	}
}
