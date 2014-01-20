package common;

import java.util.ArrayList;
import java.util.List;

public class MainManager
{
	private Line lineTitle;
	private List<Line> listLines;
	
	public MainManager()
	{
		this.listLines = new ArrayList<Line>();
	}
	
	public void addTitle(String strTitle, int nFieldSize)
	{
		this.lineTitle.addField(new Field(null, strTitle, nFieldSize));
	}
	
	
}
