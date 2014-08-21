package com.fortyoneconcepts.valjogen.testsources;

import java.util.Arrays;
import java.util.Objects;


public final class ComplexClass implements ComplexInterfaceWithAllTypes
{
  private final ComplexInterfaceWithAllTypes other;
  private final Object _object;
  private final String _string;
  private final java.util.Date date;
  private final Object[] objectArray;
  private final Object[][] objectMultiArray;
  private final byte _byte;
  private final int _int;
  private final long _long;
  private final char _char;
  private final boolean _boolean;
  private final float _float;
  private final double _double;
  private final byte[] byteArray;
  private final int[] intArray;
  private final long[] longArray;
  private final char[] charArray;
  private final boolean[] booleanArray;
  private final float[] floatArray;
  private final double[] doubleArray;
  private final byte[][] byteMultiArray;
  private final int[][] intMultiArray;
  private final long[][] longMultiArray;
  private final char[][] charMultiArray;
  private final boolean[][] booleanMultiArray;
  private final float[][] floatMultiArray;
  private final double[][] doubleMultiArray;

  public static ComplexClass valueOf(final ComplexInterfaceWithAllTypes other, final Object _object, final String _string, final java.util.Date date, final Object[] objectArray, final Object[][] objectMultiArray, final byte _byte, final int _int, final long _long, final char _char, final boolean _boolean, final float _float, final double _double, final byte[] byteArray, final int[] intArray, final long[] longArray, final char[] charArray, final boolean[] booleanArray, final float[] floatArray, final double[] doubleArray, final byte[][] byteMultiArray, final int[][] intMultiArray, final long[][] longMultiArray, final char[][] charMultiArray, final boolean[][] booleanMultiArray, final float[][] floatMultiArray, final double[][] doubleMultiArray)
  {
    return new ComplexClass(other, _object, _string, date, objectArray, objectMultiArray, _byte, _int, _long, _char, _boolean, _float, _double, byteArray, intArray, longArray, charArray, booleanArray, floatArray, doubleArray, byteMultiArray, intMultiArray, longMultiArray, charMultiArray, booleanMultiArray, floatMultiArray, doubleMultiArray);
  }

  private ComplexClass(final ComplexInterfaceWithAllTypes other, final Object _object, final String _string, final java.util.Date date, final Object[] objectArray, final Object[][] objectMultiArray, final byte _byte, final int _int, final long _long, final char _char, final boolean _boolean, final float _float, final double _double, final byte[] byteArray, final int[] intArray, final long[] longArray, final char[] charArray, final boolean[] booleanArray, final float[] floatArray, final double[] doubleArray, final byte[][] byteMultiArray, final int[][] intMultiArray, final long[][] longMultiArray, final char[][] charMultiArray, final boolean[][] booleanMultiArray, final float[][] floatMultiArray, final double[][] doubleMultiArray)
  {
    this.other=Objects.requireNonNull(other);
    this._object=Objects.requireNonNull(_object);
    this._string=Objects.requireNonNull(_string);
    this.date=Objects.requireNonNull(date);
    this.objectArray=objectArray;
    this.objectMultiArray=objectMultiArray;
    this._byte=_byte;
    this._int=_int;
    this._long=_long;
    this._char=_char;
    this._boolean=_boolean;
    this._float=_float;
    this._double=_double;
    this.byteArray=byteArray;
    this.intArray=intArray;
    this.longArray=longArray;
    this.charArray=charArray;
    this.booleanArray=booleanArray;
    this.floatArray=floatArray;
    this.doubleArray=doubleArray;
    this.byteMultiArray=byteMultiArray;
    this.intMultiArray=intMultiArray;
    this.longMultiArray=longMultiArray;
    this.charMultiArray=charMultiArray;
    this.booleanMultiArray=booleanMultiArray;
    this.floatMultiArray=floatMultiArray;
    this.doubleMultiArray=doubleMultiArray;
  }

  @Override
  public final ComplexInterfaceWithAllTypes getOther()
  {
    return other;
  }

  @Override
  public final Object getObject()
  {
    return _object;
  }

  @Override
  public final String getString()
  {
    return _string;
  }

  @Override
  public final java.util.Date getDate()
  {
    return date;
  }

  @Override
  public final Object[] getObjectArray()
  {
    return objectArray;
  }

  @Override
  public final Object[][] getObjectMultiArray()
  {
    return objectMultiArray;
  }

  @Override
  public final byte getByte()
  {
    return _byte;
  }

  @Override
  public final int getInt()
  {
    return _int;
  }

  @Override
  public final long getLong()
  {
    return _long;
  }

  @Override
  public final char getChar()
  {
    return _char;
  }

  @Override
  public final boolean isBoolean()
  {
    return _boolean;
  }

  @Override
  public final float getFloat()
  {
    return _float;
  }

  @Override
  public final double getDouble()
  {
    return _double;
  }

  @Override
  public final byte[] getByteArray()
  {
    return byteArray;
  }

  @Override
  public final int[] getIntArray()
  {
    return intArray;
  }

  @Override
  public final long[] getLongArray()
  {
    return longArray;
  }

  @Override
  public final char[] getCharArray()
  {
    return charArray;
  }

  @Override
  public final boolean[] getBooleanArray()
  {
    return booleanArray;
  }

  @Override
  public final float[] getFloatArray()
  {
    return floatArray;
  }

  @Override
  public final double[] getDoubleArray()
  {
    return doubleArray;
  }

  @Override
  public final byte[][] getByteMultiArray()
  {
    return byteMultiArray;
  }

  @Override
  public final int[][] getIntMultiArray()
  {
    return intMultiArray;
  }

  @Override
  public final long[][] getLongMultiArray()
  {
    return longMultiArray;
  }

  @Override
  public final char[][] getCharMultiArray()
  {
    return charMultiArray;
  }

  @Override
  public final boolean[][] getBooleanMultiArray()
  {
    return booleanMultiArray;
  }

  @Override
  public final float[][] getFloatMultiArray()
  {
    return floatMultiArray;
  }

  @Override
  public final double[][] getDoubleMultiArray()
  {
    return doubleMultiArray;
  }

  @Override
  public int hashCode()
  {
    final int _prime = 31;
    int _result = 1;
    _result = _prime * _result + Objects.hashCode(other); 
    _result = _prime * _result + Objects.hashCode(_object); 
    _result = _prime * _result + Objects.hashCode(_string); 
    _result = _prime * _result + Objects.hashCode(date); 
    _result = _prime * _result + Arrays.hashCode(objectArray); 
    _result = _prime * _result + Arrays.deepHashCode(objectMultiArray); 
    _result = _prime * _result + Byte.hashCode(_byte); 
    _result = _prime * _result + Integer.hashCode(_int); 
    _result = _prime * _result + Long.hashCode(_long); 
    _result = _prime * _result + Character.hashCode(_char); 
    _result = _prime * _result + Boolean.hashCode(_boolean); 
    _result = _prime * _result + Float.hashCode(_float); 
    _result = _prime * _result + Double.hashCode(_double); 
    _result = _prime * _result + Arrays.hashCode(byteArray); 
    _result = _prime * _result + Arrays.hashCode(intArray); 
    _result = _prime * _result + Arrays.hashCode(longArray); 
    _result = _prime * _result + Arrays.hashCode(charArray); 
    _result = _prime * _result + Arrays.hashCode(booleanArray); 
    _result = _prime * _result + Arrays.hashCode(floatArray); 
    _result = _prime * _result + Arrays.hashCode(doubleArray); 
    _result = _prime * _result + Arrays.deepHashCode(byteMultiArray); 
    _result = _prime * _result + Arrays.deepHashCode(intMultiArray); 
    _result = _prime * _result + Arrays.deepHashCode(longMultiArray); 
    _result = _prime * _result + Arrays.deepHashCode(charMultiArray); 
    _result = _prime * _result + Arrays.deepHashCode(booleanMultiArray); 
    _result = _prime * _result + Arrays.deepHashCode(floatMultiArray); 
    _result = _prime * _result + Arrays.deepHashCode(doubleMultiArray); 
    return _result;
  }

  @Override
  public boolean equals(final Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    ComplexClass _other = (ComplexClass) obj;

    return (Objects.equals(other, _other.other) && Objects.equals(_object, _other._object) && Objects.equals(_string, _other._string) && Objects.equals(date, _other.date) && Arrays.equals(objectArray, _other.objectArray) && Arrays.deepEquals(objectMultiArray, _other.objectMultiArray) && (_byte == _other._byte) && (_int == _other._int) && (_long == _other._long) && (_char == _other._char) && (_boolean == _other._boolean) && (Float.floatToIntBits(_float) == Float.floatToIntBits(_other._float)) && (Double.doubleToLongBits(_double) == Double.doubleToLongBits(_other._double)) && Arrays.equals(byteArray, _other.byteArray) && Arrays.equals(intArray, _other.intArray) && Arrays.equals(longArray, _other.longArray) && Arrays.equals(charArray, _other.charArray) && Arrays.equals(booleanArray, _other.booleanArray) && Arrays.equals(floatArray, _other.floatArray) && Arrays.equals(doubleArray, _other.doubleArray) && Arrays.deepEquals(byteMultiArray, _other.byteMultiArray) && Arrays.deepEquals(intMultiArray, _other.intMultiArray) && Arrays.deepEquals(longMultiArray, _other.longMultiArray) && Arrays.deepEquals(charMultiArray, _other.charMultiArray) && Arrays.deepEquals(booleanMultiArray, _other.booleanMultiArray) && Arrays.deepEquals(floatMultiArray, _other.floatMultiArray) && Arrays.deepEquals(doubleMultiArray, _other.doubleMultiArray));
  }

  @Override
  public String toString()
  {
      final StringBuilder _sb = new StringBuilder();
      _sb.append("ComplexClass [");
      _sb.append("other=");
      _sb.append(other); 
      _sb.append(", ");
      _sb.append("_object=");
      _sb.append(_object); 
      _sb.append(", ");
      _sb.append("_string=");
      _sb.append(_string); 
      _sb.append(", ");
      _sb.append("date=");
      _sb.append(date); 
      _sb.append(", ");
      _sb.append("objectArray=");
      _sb.append(Arrays.toString(objectArray)); 
      _sb.append(", ");
      _sb.append("objectMultiArray=");
      _sb.append(Arrays.toString(objectMultiArray)); 
      _sb.append(", ");
      _sb.append("_byte=");
      _sb.append(_byte); 
      _sb.append(", ");
      _sb.append("_int=");
      _sb.append(_int); 
      _sb.append(", ");
      _sb.append("_long=");
      _sb.append(_long); 
      _sb.append(", ");
      _sb.append("_char=");
      _sb.append(_char); 
      _sb.append(", ");
      _sb.append("_boolean=");
      _sb.append(_boolean); 
      _sb.append(", ");
      _sb.append("_float=");
      _sb.append(_float); 
      _sb.append(", ");
      _sb.append("_double=");
      _sb.append(_double); 
      _sb.append(", ");
      _sb.append("byteArray=");
      _sb.append(Arrays.toString(byteArray)); 
      _sb.append(", ");
      _sb.append("intArray=");
      _sb.append(Arrays.toString(intArray)); 
      _sb.append(", ");
      _sb.append("longArray=");
      _sb.append(Arrays.toString(longArray)); 
      _sb.append(", ");
      _sb.append("charArray=");
      _sb.append(Arrays.toString(charArray)); 
      _sb.append(", ");
      _sb.append("booleanArray=");
      _sb.append(Arrays.toString(booleanArray)); 
      _sb.append(", ");
      _sb.append("floatArray=");
      _sb.append(Arrays.toString(floatArray)); 
      _sb.append(", ");
      _sb.append("doubleArray=");
      _sb.append(Arrays.toString(doubleArray)); 
      _sb.append(", ");
      _sb.append("byteMultiArray=");
      _sb.append(Arrays.toString(byteMultiArray)); 
      _sb.append(", ");
      _sb.append("intMultiArray=");
      _sb.append(Arrays.toString(intMultiArray)); 
      _sb.append(", ");
      _sb.append("longMultiArray=");
      _sb.append(Arrays.toString(longMultiArray)); 
      _sb.append(", ");
      _sb.append("charMultiArray=");
      _sb.append(Arrays.toString(charMultiArray)); 
      _sb.append(", ");
      _sb.append("booleanMultiArray=");
      _sb.append(Arrays.toString(booleanMultiArray)); 
      _sb.append(", ");
      _sb.append("floatMultiArray=");
      _sb.append(Arrays.toString(floatMultiArray)); 
      _sb.append(", ");
      _sb.append("doubleMultiArray=");
      _sb.append(Arrays.toString(doubleMultiArray)); 
      _sb.append(']');
      return _sb.toString();
  }
}