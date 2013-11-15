package fr.labri.harmony.analysis.xtic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import fr.labri.harmony.analysis.xtic.aptitude.Aptitude;
import fr.labri.harmony.analysis.xtic.aptitude.PatternAptitude;
import fr.labri.harmony.analysis.xtic.report.GenerateReport;
import fr.labri.harmony.core.analysis.AbstractPostProcessingAnalysis;
import fr.labri.harmony.core.config.model.AnalysisConfiguration;
import fr.labri.harmony.core.dao.Dao;
import fr.labri.harmony.core.model.Source;
import fr.labri.harmony.core.output.OutputUtils;

public  class XticPostAnalysis extends AbstractPostProcessingAnalysis{

	public XticPostAnalysis() {
		super();
	}

	public XticPostAnalysis(AnalysisConfiguration config, Dao dao,
			Properties properties) {
		super(config, dao, properties);
	}

	@Override
	public void runOn(Collection<Source> sources) {
		for(Source src : sources) {
			List<Developer> devs = dao.getData("xtic", Developer.class, src);
			List<Aptitude> apts = new ArrayList<Aptitude>();
			for(Developer dev : devs) {
				for(PatternAptitude ap : dev.getScore().keySet()) {
					if(!apts.contains(ap.getAptitude()))
						apts.add(ap.getAptitude());
				}
			}		
			File directory;
			try {
				directory = OutputUtils.buildOutputPath(src, this, "report").toFile();
				FileUtils.deleteDirectory(directory);
				directory.mkdir();
				GenerateReport.createReport(directory, src, apts, devs, dao);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	

}