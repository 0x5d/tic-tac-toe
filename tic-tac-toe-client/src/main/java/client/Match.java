package client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Match {
	
	private String ip;
	private String port;
	
	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
	}
	
	
}

