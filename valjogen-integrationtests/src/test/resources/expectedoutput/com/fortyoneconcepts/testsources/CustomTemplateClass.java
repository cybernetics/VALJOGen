package com.fortyoneconcepts.valjogen.testsources;

import java.util.Arrays;
import java.util.Objects;
import javax.annotation.Generated;

@Generated(value = "com.fortyoneconcepts.valjogen", date="2014-09-13T16:21Z", comments="Generated by ValjoGen code generator (ValjoGen.41concepts.com) from CustomTemplateInterface")
public final class CustomTemplateClass implements CustomTemplateInterface
{
  // Inserted magic code
  private final Object _object;

  public static CustomTemplateClass valueOf(final Object _object)
  {
    CustomTemplateClass _instance = new CustomTemplateClass(_object);
    return _instance;
  }

  private CustomTemplateClass(final Object _object)
  {
    this._object=Objects.requireNonNull(_object);
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public final Object getObject()
  {
   return _object;
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public int hashCode()
  {
    int _result = Objects.hash(_object);
    return _result;
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public boolean equals(final Object arg0)
  {
    if (this == arg0)
      return true;
    if (arg0 == null)
      return false;
    if (getClass() != arg0.getClass())
      return false;

    CustomTemplateClass _other = (CustomTemplateClass) arg0;

    return (Objects.equals(_object, _other._object));
  }

  /**
  * {@inheritDoc}
  */
  @Override
  public String toString()
  {
    final StringBuilder _sb = new StringBuilder();
      _sb.append("CustomTemplateClass [");
      _sb.append("_object=");
      _sb.append(_object); 
      _sb.append(']');
    return _sb.toString();
  }
}