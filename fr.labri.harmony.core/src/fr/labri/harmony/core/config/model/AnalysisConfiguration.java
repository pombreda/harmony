package fr.labri.harmony.core.config.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnalysisConfiguration {
	private String analysisName;
	private String persistenceUnit;

	private HashMap<String, Object> options;

	// List of analyses required by this analysis and thus they need to be performed before it
	private Collection<String> dependencies;

	private FoldersConfiguration foldersConfiguration;

	/*
	 * Whether the analysis requires the source to extract actions or not. True by default
	 */
	private boolean requireActions = true;

	private boolean requireHarmonyModel = true;
	
	public AnalysisConfiguration() {
		dependencies = Collections.emptyList();
	};

	public AnalysisConfiguration(String analysisName) {
		this();
		this.analysisName = analysisName;
	}

	public AnalysisConfiguration(String analysisName, HashMap<String, Object> options) {
		this(analysisName);
		this.options = options;
	}

	public String getAnalysisName() {
		return analysisName;
	}

	@JsonProperty("class")
	public void setAnalysisName(String analysisName) {
		this.analysisName = analysisName;
	}

	@JsonProperty("options")
	public HashMap<String, Object> getOptions() {
		return options;
	}

	public void setOptions(HashMap<String, Object> options) {
		this.options = options;
	}

	public Collection<String> getDependencies() {
		return dependencies;
	}

	@JsonIgnore
	public void setDependencies(Collection<String> dependencies) {
		this.dependencies = dependencies;
	}

	public FoldersConfiguration getFoldersConfiguration() {
		return foldersConfiguration;
	}

	@JsonIgnore
	public void setFoldersConfiguration(FoldersConfiguration foldersConfiguration) {
		this.foldersConfiguration = foldersConfiguration;
	}

	@JsonIgnore
	public String getPersistenceUnit() {
		return persistenceUnit;
	}

	public void setPersistenceUnit(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}

	/**
	 * @return Whether the analysis requires the source to extract actions or not.
	 */
	public boolean requireActions() {
		return requireActions;
	}

	@JsonProperty("require-actions")
	public void setRequireActions(boolean requireActions) {
		this.requireActions = requireActions;
	}
	
	public boolean requireHarmonyModel() {
		return requireHarmonyModel;
	}

	@JsonProperty("require-harmony-model")
	public void setRequireHarmonyModel(boolean requireHarmonyModel) {
		this.requireHarmonyModel = requireHarmonyModel;
	}

}
