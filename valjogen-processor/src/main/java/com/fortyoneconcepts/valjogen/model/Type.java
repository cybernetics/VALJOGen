/*
* Copyright (C) 2014 41concepts Aps
*/
package com.fortyoneconcepts.valjogen.model;

import java.util.*;
import static com.fortyoneconcepts.valjogen.model.util.NamesUtil.*;

/**
 * Information about a type that a model use or refer to. Actual types are divided into 3 concrete subclasses depending on the category
 * of the type. I.e. if the type is a primitive, an array or an object.
 *
 * @author mmc
 */
public abstract class Type extends ModelBase
{
	protected BasicClazz clazzUsingType; // May be set by subclass immediately after constructor but not changed afterwards.
	protected final String qualifiedProtoTypicalTypeName;

	protected Type(BasicClazz optClazzUsingType, String qualifiedProtoTypicalTypeName)
	{
		this.clazzUsingType = optClazzUsingType; // Must be set manually after constructor by subclass if null.
		this.qualifiedProtoTypicalTypeName =  Objects.requireNonNull(qualifiedProtoTypicalTypeName);
	}

	public abstract Type copy(BasicClazz optClazzUsingType);

	@Override
	public Configuration getConfiguration()
	{
		return clazzUsingType.getConfiguration();
	}

	@Override
	public HelperTypes getHelperTypes()
	{
		return clazzUsingType.getHelperTypes();
	}

	@Override
	public BasicClazz getClazz()
	{
		return clazzUsingType;
	}

	/**
	 * Returns type package name of the type.
	 *
	 * @return The package name of the type.
	 */
	@Override
	public String getPackageName()
	{
		return getPackageFromQualifiedName(qualifiedProtoTypicalTypeName);
	}

	/**
	 * Returns a type name with package but without any generic parts. I.e. no &lt;T&gt; suffix.
	 *
	 * @return The qualified type name
	 */
	public String getQualifiedName()
	{
		return stripGenericQualifier(qualifiedProtoTypicalTypeName);
	}

	/**
	 * Returns a full type name with package in front. For generic types this is prototypical. I.e. ClassName&lt;T&gt;
	 *
	 * @return The fully qualifid prototypical type name.
	 */
	public String getPrototypicalQualifiedName() {
		return qualifiedProtoTypicalTypeName;
	}

	/**
	 * Checks if the type is in scope of the class being generated taking imports and default packages etc. into account (so it can be used without qualification).
	 *
	 * @return True if type is in scope of the generated class and its imported classes/pacakges.
	 */
	public abstract boolean isInImportScope();

	/**
	 * Returns a simple type name without package unless nedded and without any generic parts. I.e. no &lt;T&gt; suffix.
	 *
	 * @return The simple type name
	 */
	public String getName()
	{
		if (isInImportScope())
			return getSimpleName();
		else return getQualifiedName();
	}

	/**
	 * Returns a simple type name without package and without any generic parts. I.e. no &lt;T&gt; suffix.
	 *
	 * @return The simple type name
	 */
	public String getSimpleName()
	{
		return getUnqualifiedName(getQualifiedName());
	}

	/**
	 * Returns a simple type name without package unless nedded. For generic types this is prototypical. I.e. ClassName&lt;T&gt;
	 *
	 * @return The prototypical type name without any package.
	 */
	public String getPrototypicalName()
	{
		// TODO: unqualify generic arguments also if these are in scope:

		if (isInImportScope())
			return getUnqualifiedName(getPrototypicalQualifiedName());
		else return getPrototypicalQualifiedName();
	}

	/**
	 * Return the name of the type when represented as an object. Only yields a different name for primitives.
	 *
	 * @return The wrapped type name or just type name if no wrapper exist.
	 */
	public String getWrapperName()
	{
	    if (isPrimitive())
	    	return getWrapperTypeName(getName());
	    else return getName();
	}

	/**
	 * Checks if the type is java.lang.Object
	 *
	 * @return True if the type represents java.lang.Object
	 */
	public boolean isRootObject()
	{
	    return false;
	}

    public boolean isPrimitive()
    {
    	return false;
    }

    public boolean isVoid()
    {
    	return false;
    }

    public boolean isPrimitiveFloat()
    {
    	return false;
    }

    public boolean isPrimitiveDouble()
    {
    	return false;
    }

	public boolean isArray()
	{
		return false;
	}

	public boolean isObject()
	{
		return false;
	}

	public boolean isMultiDimensionalArray()
	{
		return false;
	}

	public boolean isSerializable()
	{
		return false;
	}

	public boolean isComparable()
	{
		return false;
	}

	public DetailLevel getDetailLevel()
	{
		return DetailLevel.Low;
	}

	public boolean canBeMoreDetailed()
	{
		return false;
	}

	/**
	* Returns if the type is a generated type (Clazz)
	*
	* @return True if this type is the one being generated.
	*/
	public boolean isThisType()
	{
		return false;
	}

	/**
	* Returns if the type is the base class for the generated type (Clazz)
	*
	* @return True if this type is the base class for the class being generated.
	*/
	public boolean isThisSuperType()
	{
		return false;
	}

	/**
	* Returns this overall category (kind) of type this type is.
	*
	* @return The type category.
	*/
    public abstract TypeCategory getTypeCategory();

	@Override
	public int hashCode()
	{
		return qualifiedProtoTypicalTypeName.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Type other = (Type) obj;
		if (clazzUsingType != other.clazzUsingType)
			return false;
		if (qualifiedProtoTypicalTypeName == null) {
			if (other.qualifiedProtoTypicalTypeName != null)
				return false;
		} else if (!qualifiedProtoTypicalTypeName
				.equals(other.qualifiedProtoTypicalTypeName))
			return false;
		return true;
	}
}
