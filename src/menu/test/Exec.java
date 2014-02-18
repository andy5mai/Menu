package menu.test;

import common.MenuManager;

public class Exec
{
	private enum Title
	{
		test1(5)
		, test2(10)
		, test3(6);
		
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
//		
//		for(int i = 0; i < 2; i++)
//		{
//			for(Title title : Title.values())
//			{
//				menuManager.addField(menuManager.getTitle(title.name()), "11122233" + i);
//			}
//		}
		
		menuManager.print();		
	}

}
