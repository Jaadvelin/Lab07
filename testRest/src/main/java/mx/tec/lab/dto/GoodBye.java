
package mx.tec.lab.dto;

public class GoodBye {
	private final long id;
	private final String content;
	
	public GoodBye(long id, String content)
	{
		this.id = id;
		this.content = content;
	}
	
	public long getId()
	{
		return id;
	}
	
	public String getContent()
	{
		return content;
	}
}
