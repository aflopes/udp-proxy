package pt.enter.proxy.udpproxy.config;

import com.beust.jcommander.Parameter;

public class UdpProxyCmdLineConfig {
	
	@Parameter(names = {"--source-host", "-sh"}, description = "Source Host", required=true)
	private String sourceHost;
	
	@Parameter(names = {"--source-port", "-sp"}, description = "Source Port", required=true)
	private Integer sourcePort;
	
	@Parameter(names = {"--target-host", "-th"}, description = "Target Host", required=true)
	private String targetHost;
	
	@Parameter(names = {"--target-port", "-tp"}, description = "Target Port", required=true)
	private Integer targetPort;
	
	
	public String getSourceHost() {
		return sourceHost;
	}
	
	public Integer getSourcePort() {
		return sourcePort;
	}
	
	public String getTargetHost() {
		return targetHost;
	}

	public Integer getTargetPort() {
		return targetPort;
	}
}
