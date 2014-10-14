package com.fortyoneconcepts.valjogen.model;

import java.util.Objects;

/**
 * Specifies a non-exisisting type. Type of nothing.
 *
 * @author mmc
 *
 */
public class NoType extends Type
{
	public NoType()
	{
		super(null, "NONE");
	}

	/**
     * Nb. Post-constructor for this type. This method must be called for the type to be fully initialized.
     *
	 * @param clazzUsingType The class using this type.
     */
	public void init(BasicClazz clazzUsingType)
	{
		this.clazzUsingType=Objects.requireNonNull(clazzUsingType);
	}

	@Override
	public TypeCategory getTypeCategory()
	{
		return TypeCategory.NONE;
	}

	@Override
	public String toString(int level)
	{
		return "<NONE>";
	}

	@Override
	public boolean isInImportScope()
	{
		return true;
	}
}
