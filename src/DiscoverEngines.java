import java.util.List;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class DiscoverEngines {
	public static void main(String[] args) {

	    ScriptEngineManager mgr = new ScriptEngineManager();
	   
	    List<ScriptEngineFactory> factories = mgr.getEngineFactories();
	    
	    for (ScriptEngineFactory factory : factories) {
	    
	      System.out.println("ScriptEngineFactory Info");
	      
	      String engName = factory.getEngineName();
	      String engVersion = factory.getEngineVersion();
	      System.out.println("Script Engine: " + engName + " v. " + engVersion);

	      List<String> engNames = factory.getNames();
	      for(String name : engNames) System.out.println("Engine Alias: " + name);
	      
	      String langName = factory.getLanguageName();
	      String langVersion = factory.getLanguageVersion();
	      System.out.println("Language: " + langName + " v. " +  langVersion);
	      
	      List<String> exts = factory.getExtensions();
	      for(String ext : exts) System.out.println("Script file extension: " + ext);
	      
	      System.out.println("-------------------------------------------");
	    }    
	  }
}
