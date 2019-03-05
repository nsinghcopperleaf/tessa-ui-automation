package com.tessa.story;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import com.tessa.steps.*;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.Embeddable;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.parsers.RegexStoryParser;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.ParameterConverters.DateConverter;
import org.jbehave.core.steps.ParameterConverters.ExamplesTableConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.jbehave.core.steps.CandidateSteps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.*;


/**
 * <p>
 * {@link Embeddable} class to run multiple textual stories via JUnit.
 * </p>
 * <p>
 * Stories are specified in classpath and correspondingly the {@link LoadFromClasspath} story loader is configured.
 * </p>
 */

@RunWith(JUnitReportingRunner.class)

//@RunWith(SerenityRunner.class)
public class Config extends JUnitStories {
//public class ScopeSheetStory {

    public Config() {
    	
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
               .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(10000);
		List<String> metaFilters = new ArrayList<String>();
		metaFilters.add(System.getProperty("metaFilters", "-skip"));
		configuredEmbedder().useMetaFilters(metaFilters);

		//super();
		//this.configuredEmbedder().candidateSteps().add(new ScopeSheetSteps());
    	
    }
   
@Override
@Test
public void run() throws Throwable {
    super.run();
}

	

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new ScopeSheetSteps());
    }

 
    @Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
		// where to find the stories
				.useStoryLoader(new LoadFromClasspath(this.getClass()))
				// CONSOLE and TXT reporting
				.useStoryReporterBuilder(
						new StoryReporterBuilder().withDefaultFormats()
								.withFormats(Format.CONSOLE, Format.HTML_TEMPLATE));
	}

	// Here we specify the steps classes
	@Override
	public List<CandidateSteps> candidateSteps() {
		// varargs, can have more that one steps classes
		return new InstanceStepsFactory(configuration(), new ScopeSheetSteps())
				.createCandidateSteps();
	}


	@Override
	protected List<String> storyPaths() {
		// TODO Auto-generated method stub
		//return Arrays.asList("com/tessa/stories/ScopeSheet.story");
		//return Arrays.asList("com/tessa/stories/ScopeSheet.story");
		 //String placetosearch = System.getProperty("user.dir") + "\\src\\main\\resources\\com\\tessa\\stories\\";
	     StoryFinder finder = new StoryFinder();
	     //List<String> pathsFound = storyFinder.findPaths(placetosearch, Arrays.asList("**/*"), Arrays.asList(""));
	     //for (String found : pathsFound) {
	     //       System.out.println("Found: " + found);
	     //} 
	    return Arrays.asList("com/tessa/stories/ScopeSheet.story");
        //return finder.findPaths(codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/*.story"), Arrays.asList(""));
	    //return pathsFound;
		
	}
        
}

