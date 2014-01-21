package Test;

import common.MenuManager;

public class Exec
{
	private enum Title
	{
		test1(3)
		, test2(4)
		, test3(2);
		
		private int nFieldSize;
		private Title(int nFieldSize)
		{
			this.nFieldSize = nFieldSize;
		}
		
		public void setFieldSize(int nFieldSize)
		{
			this.nFieldSize = nFieldSize;
		}
		
		public int getFieldSize()
		{
			return this.nFieldSize;
		}
	}
	
	
	public static void main(String[] args)
	{
		MenuManager menuManager = new MenuManager((short)2, ' ');
		
		for(Title title : Title.values())
		{
			menuManager.addTitle(title.name(), title.getFieldSize());
		}
		
		for(int i = 0; i < 2; i++)
		{
			for(Title title : Title.values())
			{
				menuManager.addField(menuManager.getTitle(title.name()), "111222" + i);
			}
		}
		
		menuManager.print();
	}

}
