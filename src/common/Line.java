package common;

import java.util.LinkedHashMap;
import java.util.Map;

public class Line
{
	private LinkedHashMap<Object, Field> mapFields;
	private int nTotalLength = 0;
	private short sSeparateLength = 2;
	
	private Line()
	{
		this.mapFields = new LinkedHashMap<Object, Field>();
	}
	
	private Line(short sSeparateLength)
	{
		this();
		this.sSeparateLength = sSeparateLength;
	}
	
	public static Line getNewTitleLine(short sSeparateLength)
	{
		return new Line(sSeparateLength);
	}
	
	public static Line getNew()
	{
		return new Line();
	}
	
	public void addTitle(Field fieldTitle)
	{
		this.mapFields.put(fieldTitle.getContent(), fieldTitle);
		this.nTotalLength = this.nTotalLength + fieldTitle.getFieldLength() + this.sSeparateLength;
	}
	
	public Field getTitle(String strTitle)
	{
		return this.mapFields.get(strTitle);
	}
	
	public short getSeparateLength()
	{
		return this.sSeparateLength;
	}
	
	public void addField(Field fieldTitle, Field field)
	{
		this.mapFields.put(fieldTitle, field);
		
	}
	
	public Field getField(Field fieldTitle)
	{
		return this.mapFields.get(fieldTitle);
	}
	
	public Map<Object, Field> getFields()
	{
		return this.mapFields;
	}
}
