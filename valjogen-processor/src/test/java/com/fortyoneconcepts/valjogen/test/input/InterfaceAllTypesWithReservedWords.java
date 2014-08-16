package com.fortyoneconcepts.valjogen.test.input;

import com.fortyoneconcepts.valjogen.annotations.*;

@VALJOGenerate
public interface InterfaceAllTypesWithReservedWords extends BaseInterfaceWithoutAnnotation
{
	public InterfaceAllTypesWithReservedWords get1();

	public Object getObject();

	public String getString();

	public java.util.Date getDate();

	public String[] getStringAry();

	public String[][] getStringMultiAry();

	public byte getByte();

	public int getInt();

	public int[] getIntAry();

	public long getLong();

	public char getChar();

	public boolean isBoolean();

	public float getFloat();

	public double getDouble();

	public void setDouble(double d);
}

