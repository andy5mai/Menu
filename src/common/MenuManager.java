package common;

import java.util.ArrayList;
import java.util.List;

public class MenuManager
{
	private PrintManager printManager;
	private Line lineTitle;
	private List<Line> listLines;
	private char cPatchChar;
	
	public MenuManager(short sSeparateLength, char cPatchChar)
	{
		this.cPatchChar = cPatchChar;
		this.printManager = new PrintManager();
		this.lineTitle = Line.getNewTitleLine(sSeparateLength);
		this.listLines = new ArrayList<Line>();
	}
	
	public void addTitle(String strTitle, int nFieldSize)
	{
		this.lineTitle.addTitle(Field.getNewTitle(strTitle, nFieldSize));
	}
	
	public Field getTitle(String strTitle)
	{
		return this.lineTitle.getTitle(strTitle);
	}
	
	public void addField(Field fieldTitle, String strContent)
	{
		this.listLines.add(Line.getNew());
		this.setField(this.listLines.size() - 1, fieldTitle, strContent);
	}
	
	public void setField(int nLineIndex, Field fieldTitle, String strContent)
	{
		Line line = this.listLines.get(nLineIndex);
		if (line == null) line = Line.getNew();
		line.addField(fieldTitle, Field.getNew(fieldTitle, strContent));
		
		this.listLines.set(nLineIndex, line);
	}
	
	public void print()
	{
		this.printManager.print(this.lineTitle.getFields().values()
								, this.lineTitle.getSeparateLength()
								, this.cPatchChar);
		
		for(Line line : this.listLines)
		{
			this.printManager.print(line.getFields().values()
									, this.lineTitle.getSeparateLength()
									, cPatchChar);
		}
	}
}
