package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintManager
{
	public void print(Collection<Field> colsFields, short sSeparateLength, char cPatchChar)
	{
		String strContent;
		Map<Integer, String> mapLeftStrings = new HashMap<Integer, String>();

		Field[] fields = new Field[colsFields.size()];
		int nColIndex = 0;
		int nMaxFieldIndex = 0;
		int nMaxIndex = 0;
		for(Field field : colsFields)
		{
			strContent = field.getContent();
			nMaxFieldIndex = this.print(mapLeftStrings
									    , nColIndex
									    , colsFields.size()
									    , field.getContent()
										, field.getFieldLength()
										, sSeparateLength
										, cPatchChar);
			if (nMaxIndex < nMaxFieldIndex) nMaxIndex = nMaxFieldIndex; 
			
			fields[nColIndex] = field;
			nColIndex++;
		}
		
		String str;
		for(int i = 0; i < nMaxIndex; i++)
		{
			if ((str = mapLeftStrings.get(i)) == null)
			{
				System.out.print(this.getPatchedStr(""
						   							, fields[i % fields.length]
						   							  .getFieldLength()
													, sSeparateLength
													, cPatchChar));
				continue;
			}
			
			System.out.print(str);
			if (i % fields.length == fields.length - 1) System.out.println();
		}
		
		System.out.println();
	}
	
	private int print(Map<Integer, String> mapLeftStrings
					   	  , int nListIndex
					   	  , int nFieldsSize
					   	  , String strContent
					   	  , int nExpectedLength
					   	  , short sSeparateLength
					   	  , char cPatchChar)
	{
		if (strContent.length() > nExpectedLength)
		{
			mapLeftStrings.put(nListIndex, strContent.substring(0, nExpectedLength));
			return this.print(mapLeftStrings
					   , nListIndex + nFieldsSize
					   , nFieldsSize
					   , strContent.substring(nExpectedLength
										      , strContent.length())
					   , nExpectedLength
					   , sSeparateLength
					   , cPatchChar);
		}
		
		mapLeftStrings.put(nListIndex, strContent);
		return nListIndex;
	}
	
	public String getPatchedStr(String str, int nSize, int nSeparateSize, char cPatchChar)
	{
		return this.getPatchedStr(str, nSize + nSeparateSize, cPatchChar); 
	}
	
	public String getPatchedStr(String str, int nSize, char cPatchChar)
	{
		StringBuffer sb = new StringBuffer(str);
		
		int nLength = nSize - sb.length();
		if (nLength < 0) nLength = 0;
		
		sb.append(this.getFillCharArr(cPatchChar, nLength));
		
		return sb.toString();
	}
	
	private char[] getFillCharArr(char c, int nSize)
	{
		char[] cs = new char[nSize];
		Arrays.fill(cs, c);
		
		return cs;
	}
}
