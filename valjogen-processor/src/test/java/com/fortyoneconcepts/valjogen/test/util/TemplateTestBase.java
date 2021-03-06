/*
* Copyright (C) 2014 41concepts Aps
*/
package com.fortyoneconcepts.valjogen.test.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.lang.model.SourceVersion;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic.Kind;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import com.fortyoneconcepts.valjogen.annotations.VALJOConfigure;
import com.fortyoneconcepts.valjogen.annotations.VALJOGenerate;
import com.fortyoneconcepts.valjogen.model.Clazz;
import com.fortyoneconcepts.valjogen.model.Configuration;
import com.fortyoneconcepts.valjogen.model.ConfigurationDefaults;
import com.fortyoneconcepts.valjogen.model.ConfigurationOptionKeys;
import com.fortyoneconcepts.valjogen.model.util.AnnotationProxyBuilder;
import com.fortyoneconcepts.valjogen.processor.KnownFileHandler;
import com.fortyoneconcepts.valjogen.processor.ResourceLoader;
import com.fortyoneconcepts.valjogen.processor.STCodeWriter;
import com.fortyoneconcepts.valjogen.processor.STTemplates;
import com.fortyoneconcepts.valjogen.processor.builders.ModelBuilder;
import com.google.testing.compile.CompilationRule;

/**
 * Common superclass for template-based tests.Derived tests are not supposed to check for compilation errors or that names are qualified correctly. This should be covered by the seperate tests that
 * checks if source will compile.
 *
 * As we use javax.lang.model which we do not normally have access to at runtime in Java 1.8 we use javax.lang.model magic proxies supplied by com.google.testing.compile library.
 *
 * Known problems:
 * No tests for javaDocs as reading javaDocs from source in tests not working due to limitation in google com.google.testing library v0.5.
 *
 * @author mmc
 */
public abstract class TemplateTestBase
{
	private final static Logger LOGGER = Logger.getLogger(TemplateTestBase.class.getName());

	@Rule
	public CompilationRule compilationRule = new CompilationRule();

	@Rule
	public TestName nameRule = new TestName();

	private Types types;
	private Elements elements;

	protected SourceVersion sourceVersion;

	protected AnnotationProxyBuilder<VALJOGenerate> generateAnnotationBuilder;
	protected AnnotationProxyBuilder<VALJOConfigure> configureAnnotationBuilder;
	protected Map<String,String> configurationOptions;
	protected static final String generatedPackageName = "testPackage";
	protected static final String generatedClassName = "TestImpl";

	private final Logger parentLogger;

	public TemplateTestBase() {
		super();
		parentLogger = Logger.getLogger(ConfigurationDefaults.TOP_PACKAGE_NAME);

		// Set a tempoary default log level until configuration has been read.
   	   parentLogger.setLevel(Level.INFO);
	}

	@Before
	public void init() throws URISyntaxException, IOException
	{
		sourceVersion=SourceVersion.RELEASE_7;

		types = Objects.requireNonNull(compilationRule.getTypes());
		elements = Objects.requireNonNull(compilationRule.getElements());

		generateAnnotationBuilder = new AnnotationProxyBuilder<VALJOGenerate>(VALJOGenerate.class);
		configureAnnotationBuilder = new AnnotationProxyBuilder<VALJOConfigure>(VALJOConfigure.class);

		configurationOptions = new HashMap<String,String>();
		configurationOptions.put(ConfigurationDefaults.OPTION_QUALIFIER+ConfigurationOptionKeys.warnAboutSynthesisedNames, "false");

		// Setup a default of a different log file for each test using this base class.
		String testName = this.getClass().getSimpleName()+"-"+nameRule.getMethodName();

		Path logDir = TestSupport.getTargetPath().resolve("logs");
		if (!Files.exists(logDir))
		  logDir=Files.createDirectory(logDir);

		String defaultLogFile = logDir.resolve("valjogen-"+testName+".log").toString();

		configurationOptions.put(ConfigurationDefaults.OPTION_QUALIFIER+ConfigurationOptionKeys.LOGFILE, defaultLogFile);
	}

	/**
	* Contains the produced result including generated code, intermediate model representation, warnings and errors.
	*
	* @author mmc
	*/
	public final class Output
	{
		public final String code;
		public final Clazz clazz;
		public final List<String> warnings;
		public final List<String> errors;

		public Output(String code, Clazz clazz, List<String> warnings, List<String> errors)
		{
			this.code=Objects.requireNonNull(code);
			this.clazz=Objects.requireNonNull(clazz);
			this.warnings=Objects.requireNonNull(warnings);
			this.errors=Objects.requireNonNull(errors);
		}
	}

	protected Output produceOutput(Class<?> sourceClass) throws Exception {
		return produceOutput(sourceClass, generateAnnotationBuilder.add(ConfigurationOptionKeys.name, generatedPackageName+"."+generatedClassName).build(), configureAnnotationBuilder.build(), false, false);
	}

	protected Output produceOutput(Class<?> sourceClass, VALJOConfigure configureAnnotation) throws Exception {
		return produceOutput(sourceClass, generateAnnotationBuilder.add(ConfigurationOptionKeys.name, generatedPackageName+"."+generatedClassName).build(), configureAnnotation, false, false);
	}

	protected Output produceOutput(Class<?> sourceClass, AnnotationProxyBuilder<VALJOGenerate> generateAnnotationBuilder, AnnotationProxyBuilder<VALJOConfigure> configureAnnotationBuilder) throws Exception
	{
		return produceOutput(sourceClass, generateAnnotationBuilder.add(ConfigurationOptionKeys.name, generatedPackageName+"."+generatedClassName).build(), configureAnnotationBuilder.build(), false, false);
	}

	protected Output produceOutput(Class<?> sourceClass, VALJOGenerate generateAnnotation, VALJOConfigure configureAnnotation) throws Exception
	{
		return produceOutput(sourceClass, generateAnnotation, configureAnnotation, false, false);
	}

	protected Output produceOutput(Class<?> sourceClass, VALJOGenerate generateAnnotation, VALJOConfigure configureAnnotation, boolean allowErrors, boolean suppressWarnings) throws Exception
	{
		Configuration configuration = new Configuration(sourceClass.getCanonicalName(), sourceVersion, generateAnnotation, configureAnnotation, Locale.ENGLISH, configurationOptions);

	    // Now that we know what to do with logging, do set it correctly.
        KnownFileHandler.setUpLogging(parentLogger, configuration);

	    // Make sure console logs what we ask for:
	    Logger rootLogger = Logger.getGlobal();
	    Handler[] handlers = rootLogger.getHandlers();
	    for (Handler handler : handlers)
		    if (handler instanceof ConsoleHandler) {
		      if (handler.getLevel().intValue()>configuration.getLogLevel().intValue())
		    	    handler.setLevel(configuration.getLogLevel());
	    }

		LOGGER.info(() -> "VALJOGen ANNOTATION PROCESSOR CONFIGURATION "+System.lineSeparator()+configuration);

		TypeElement interfaceElement = elements.getTypeElement(sourceClass.getCanonicalName());
		PackageElement packageElement = (PackageElement)(interfaceElement.getEnclosingElement());

		String sourcePackageElementPath = packageElement.toString().replace('.', '/');

		String srcPath = configuration.getSourcePath();
		ResourceLoader resourceLoader = new ResourceLoader(srcPath, sourcePackageElementPath);

		STTemplates templates = new STTemplates(resourceLoader, configuration);

		List<String> warnings = new ArrayList<String>();
		List<String> errors = new ArrayList<String>();

		ModelBuilder clazzFactory = new ModelBuilder(types, elements,  (megElement, kind, message) ->
		  {
			if (kind==Kind.ERROR) {
			  errors.add(message);
			  if (!allowErrors) {
	  			  LOGGER.severe(message);
				  Assert.fail(message);
			  }
			} else if (kind==Kind.WARNING || kind==Kind.MANDATORY_WARNING) {
			  warnings.add(message);

			  if (!suppressWarnings)
			    LOGGER.warning(message);
			} else LOGGER.info(message);
		  }, interfaceElement, configuration, resourceLoader, templates);

		Clazz clazz = clazzFactory.buildNewCLazz();

		LOGGER.info(() -> "VALJOGen ClazzFactory GENERATED CLAZZ MODEL INSTANCE: "+System.lineSeparator()+clazz.toString());

		STCodeWriter writer = new STCodeWriter(clazz, configuration, templates);

		String output = writer.outputClass();

		Assert.assertNotNull("template output should not be null", output);

		// Since we are generating output without the annotation processor, let's do our own debug output if enabled.
    	LOGGER.info("VALJOGen STCodeWriter GENERATED CONTENT: "+System.lineSeparator()+output);

	    output=output.replace('\r', ' ').replace('\n', ' ');
	    output=output.replaceAll("\\s+", " ");
	    output=output.trim();

		return new Output(output, clazz, warnings, errors);
	}
}