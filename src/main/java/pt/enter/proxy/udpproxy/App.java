package pt.enter.proxy.udpproxy;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beust.jcommander.JCommander;

import pt.enter.proxy.udpproxy.config.UdpProxyCmdLineConfig;
import pt.enter.proxy.udpproxy.config.UdpProxySpringConfiguration;

public class App {
	
	public static final String UDP_PROXY_CONFIG = "udp-proxy-config";

	private static Logger LOGGER = LoggerFactory.getLogger(App.class);
	
	private CamelContext camelContext;
	private ApplicationContext applicationContext;

	
	public static void main(String[] args) throws Exception {
		new App().start(args);
	}


	private void start(String[] args) throws Exception{
		
		UdpProxyCmdLineConfig config = new UdpProxyCmdLineConfig();
		JCommander jcommander = new JCommander(config);
		try{
			jcommander.parse(args);
		}catch(Exception e){
			LOGGER.error("Unexpected args received or args are missing");
			jcommander.usage();
			System.exit(1);
		}
		System.getProperties().put(UDP_PROXY_CONFIG, config);

		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					stop();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}));
		applicationContext = new AnnotationConfigApplicationContext(UdpProxySpringConfiguration.class);
		camelContext = SpringCamelContext.springCamelContext(applicationContext,false);
		LOGGER.info("Starting udp-proxy");
		camelContext.start();
	}

	private void stop() throws Exception{
		LOGGER.info("Stoping udp-proxy");
		camelContext.stop();
	}
}
