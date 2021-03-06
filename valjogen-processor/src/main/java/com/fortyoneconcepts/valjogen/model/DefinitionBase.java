/*
* Copyright (C) 2014 41concepts Aps
*/
package com.fortyoneconcepts.valjogen.model;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

/**
 * Common base class for definition model
 *
 * @author mmc
 */
abstract class DefinitionBase extends ModelBase implements Definition
{
	protected final BasicClazz clazz;
	protected final String name;
	protected final EnumSet<Modifier> declaredModifiers;
	protected final List<Annotation> annotations;

	protected DefinitionBase(final BasicClazz clazz, final String name, final EnumSet<Modifier> declaredModifiers, List<Annotation> annotations)
	{
		this.clazz=Objects.requireNonNull(clazz);
		this.name=Objects.requireNonNull(name);
		this.declaredModifiers=Objects.requireNonNull(declaredModifiers);
		this.annotations=Objects.requireNonNull(annotations);
	}

	@Override
	public Configuration getConfiguration()
	{
		return clazz.getConfiguration();
	}

	@Override
	public BasicClazz getClazz()
	{
		return clazz;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public EnumSet<Modifier> getDeclaredModifiers()
	{
		return declaredModifiers;
	}

	@Override
	public List<Annotation> getAnnotations()
	{
		return annotations;
	}
}
