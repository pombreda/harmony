package fr.labri.harmony.core;

import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;

import fr.labri.harmony.core.config.GlobalConfigReader;
import fr.labri.harmony.core.config.SourceConfigReader;
import fr.labri.harmony.core.execution.StudyScheduler;
import fr.labri.harmony.core.log.HarmonyLogger;

public class CoreCommand implements CommandProvider {

	public CoreCommand() {
	}

	public void _harmony(CommandInterpreter ci) {
			harmony(ci.nextArgument(), ci.nextArgument());
	}

	public void harmony(String globalConfigPath, String sourceConfigPath) {
		try {
			GlobalConfigReader global = new GlobalConfigReader(globalConfigPath);
			SourceConfigReader sources = new SourceConfigReader(sourceConfigPath, global);
			new StudyScheduler(global.getSchedulerConfiguration()).run(global, sources);

		} catch (Exception ex) {
			HarmonyLogger.error("Harmony was not able to parse your configuration files");
			ex.printStackTrace();
		}
	}

	@Override
	public String getHelp() {
		return null;
	}

}
