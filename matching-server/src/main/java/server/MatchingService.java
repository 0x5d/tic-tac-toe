package server;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MatchingService {
	
	public static Match wMatch = null; 
	
	@RequestMapping("/GameMatching")
    public Match gameMatch(@RequestParam(value="ip", required=true) String ip, @RequestParam(value="port", required = true) String port) {
		if(wMatch!=null){
			Match temp = new Match(wMatch.getIp(), wMatch.getPort());
			wMatch = null;
			return temp; 
		}else{
			wMatch = new Match(ip, port);
			return null;
		}
	}
	
}
