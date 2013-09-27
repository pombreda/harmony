package fr.labri.harmony.core.config.model;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.labri.harmony.core.source.SourceExtractor;

public class SourceConfiguration {
	private String repositoryURL;
	private String sourceExtractorName;
	private String username;
	private String password;
	private String pathOnServer;
	private FoldersConfiguration foldersConfiguration;
	private String configurationFileName;

	private HashMap<String, Object> options;

	
	public SourceConfiguration() {
		options = new HashMap<>();
	}

	public SourceConfiguration(String repositoryURL, SourceExtractor<?> srcConnector) {
		this();
		this.repositoryURL = repositoryURL;
	}

	public String getRepositoryURL() {
		return repositoryURL;
	}

	@JsonProperty("url")
	public void setRepositoryURL(String repositoryURL) {
		this.repositoryURL = repositoryURL;
	}

	@JsonProperty("class")
	public String getSourceExtractorName() {
		return sourceExtractorName;
	}
	
	public void setSourceExtractorName(String sourceExtractorName) {
		this.sourceExtractorName = sourceExtractorName;
	}

	@JsonIgnore
	public void setFoldersConfiguration(FoldersConfiguration foldersConfiguration) {
		this.foldersConfiguration = foldersConfiguration;
	}
	
	public FoldersConfiguration getFoldersConfiguration() {
		return foldersConfiguration;
	}

	@JsonProperty("options")
	public HashMap<String, Object> getOptions() {
		return options;
	}

	public void setOptions(HashMap<String, Object> options) {
		this.options = options;
	}

	@JsonProperty("user")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JsonIgnore
	public String getConfigurationFileName() {
		return configurationFileName;
	}

	public void setConfigurationFileName(String configurationFileName) {
		this.configurationFileName = configurationFileName;
	}

	@JsonProperty("path")
	public String getPathOnServer() {
		return pathOnServer;
	}

	public void setPathOnServer(String pathOnServer) {
		this.pathOnServer = pathOnServer;
	}
	
	
	
	

}