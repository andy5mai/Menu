package common;

import java.util.ArrayList;
import java.util.List;

public class Line
{
	private List<Field> listFields;
	public Line()
	{
		this.listFields = new ArrayList<Field>();
	}
	public void addField(Field field)
	{
		this.listFields.add(field);
	}
	
	public List<Field> getFields()
	{
		return this.listFields;
	}
}
