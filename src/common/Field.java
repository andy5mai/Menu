package common;

public class Field
{
	private Field fieldTitle;
	private String strContent;
	private int nFieldSize;
	
	public Field(Field fieldTitle, String strContent, int nFieldSize)
	{
		this.fieldTitle = fieldTitle;
		this.strContent = strContent;
		this.nFieldSize = nFieldSize;
	}
	
	public Field getTitleField()
	{
		return this.fieldTitle;
	}
	
	public String getContent()
	{
		return this.strContent;
	}
	
	public int getFieldSize()
	{
		return this.nFieldSize;
	}
}
