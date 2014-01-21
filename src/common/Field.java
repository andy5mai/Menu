package common;

public class Field
{
	private Field fieldTitle;
	private String strContent;
	private int nFieldLength;
	
	private Field(String strContent, int nFieldLength)
	{
		this.fieldTitle = null;
		this.strContent = strContent;
		this.nFieldLength = nFieldLength;
	}
	
	private Field(Field fieldTitle, String strContent)
	{
		this.fieldTitle = fieldTitle;
		this.strContent = strContent;
	}
	
	public static Field getNewTitle(String strContent, int nFieldLength)
	{
		return new Field(strContent, nFieldLength);
	}
	
	public static Field getNew(Field fieldTitle, String strContent)
	{
		return new Field(fieldTitle, strContent);
	}
	
	public Field getTitleField()
	{
		return this.fieldTitle;
	}
	
	public String getContent()
	{
		return this.strContent;
	}
	
	public int getFieldLength()
	{
		if (this.fieldTitle != null) return this.fieldTitle.getFieldLength();
		
		return this.nFieldLength;
	}
}
