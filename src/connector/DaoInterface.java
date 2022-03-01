package connector;

import javax.servlet.http.HttpServletRequest;

public interface DaoInterface {
	
	public boolean add(HttpServletRequest request);
	
	public boolean choose(HttpServletRequest request);

}
