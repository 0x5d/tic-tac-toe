package server;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {
	
	private final String ip;
	private final String port;
	
	
	public Match(String ip, String port){
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
	}
	
	
}
