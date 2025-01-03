
package tmc_demo2.getenvironmentid_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: getEnvironmentID Purpose: <br>
 * Description: <br>
 * 
 * @author Hamano, Masaki
 * @version 8.0.1.20230913_0925-patch
 * @status
 */
public class getEnvironmentID implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "getEnvironmentID.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(getEnvironmentID.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "getEnvironmentID";
	private final String projectName = "TMC_DEMO2";
	public Integer errorCode = null;
	private String currentComponent = "";

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_1hXIQLCHEe-kcMyE6M_qOg", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					getEnvironmentID.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(getEnvironmentID.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tHTTPClient_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tHTTPClient_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tHTTPClient_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tHTTPClient_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tHTTPClient_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tHTTPClient_2");
		org.slf4j.MDC.put("_subJobPid", "wU8PBp_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tHTTPClient_2 begin ] start
				 */

				ok_Hash.put("tHTTPClient_2", false);
				start_Hash.put("tHTTPClient_2", System.currentTimeMillis());

				currentComponent = "tHTTPClient_2";

				cLabel = "getIDs";

				int tos_count_tHTTPClient_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tHTTPClient_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tHTTPClient_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tHTTPClient_2 = new StringBuilder();
							log4jParamters_tHTTPClient_2.append("Parameters:");
							log4jParamters_tHTTPClient_2.append("configuration.dataset.datastore.base" + " = "
									+ "https://api.ap.cloud.talend.com/tmc/v2.6");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.authentication.type" + " = " + "APIKey");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.authentication.apiKey.destination" + " = "
											+ "HEADERS");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.authentication.apiKey.headerName" + " = "
											+ "Authorization");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append(
									"configuration.dataset.datastore.authentication.apiKey.prefix" + " = " + "Bearer");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.authentication.apiKey.token" + " = "
											+ String.valueOf(
													"enc:routine.encryption.key.v1:wXTGyc581Tbl83VI3CTvaPuluH9t5hw0rMvrPj7Nwh5NqQB9OeLzc+28PRI643OHJns63fOViVaE33XMCCawPxDUfUjm0uVV2dG/6AqJnOff3+u0FINUxYJ8BP4=")
													.substring(0, 4)
											+ "...");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.dataset.methodType" + " = " + "GET");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.resource" + " = " + "/workspaces");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.hasPathParams" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.hasQueryParams" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.dataset.hasHeaders" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.dataset.hasBody" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.dataset.format" + " = " + "RAW_TEXT");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.returnedContent" + " = " + "STATUS_HEADERS_BODY");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.outputKeyValuePairs" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.downloadFile" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.connectionTimeout" + " = " + "30000");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.receiveTimeout" + " = " + "120000");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append(
									"configuration.dataset.datastore.bypassCertificateValidation" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.datastore.useProxy" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.acceptRedirections" + " = " + "true");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.maxRedirectOnSameURL" + " = " + "3");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.dataset.onlySameHost" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2
									.append("configuration.dataset.hasPagination" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.uploadFiles" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							log4jParamters_tHTTPClient_2.append("configuration.dieOnError" + " = " + "false");
							log4jParamters_tHTTPClient_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tHTTPClient_2 - " + (log4jParamters_tHTTPClient_2));
						}
					}
					new BytesLimit65535_tHTTPClient_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tHTTPClient_2", "getIDs", "HTTPClient");
					talendJobLogProcess(globalMap);
				}

				final org.talend.sdk.component.runtime.manager.ComponentManager mgr_tHTTPClient_2 = org.talend.sdk.component.runtime.manager.ComponentManager
						.instance();
				if (mgr_tHTTPClient_2.getContainer().findAll().isEmpty()) {
					mgr_tHTTPClient_2.autoDiscoverPlugins(false, true);
				}

				final java.util.Map<String, String> configuration_tHTTPClient_2 = new java.util.HashMap<>();
				final java.util.Map<String, String> registry_metadata_tHTTPClient_2 = new java.util.HashMap<>();
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.base",
						"https://api.ap.cloud.talend.com/tmc/v2.6");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.authentication.type", "APIKey");
				// configuration.dataset.datastore.authentication.basic.username is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.basic.password is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.ntlm.username is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.ntlm.password is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.bearerToken is hidden,
				// skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.authentication.apiKey.destination",
						"HEADERS");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.authentication.apiKey.headerName",
						"Authorization");
				// configuration.dataset.datastore.authentication.apiKey.queryName is hidden,
				// skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.authentication.apiKey.prefix",
						"Bearer");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.authentication.apiKey.token",
						routines.system.PasswordEncryptUtil.decryptPassword(
								"enc:routine.encryption.key.v1:vcb0U9uPEf5q0tf0Cg/r3rgCWw3fqnb7FGmvQfMZ7lsfRF5hAobW7DtPrhR9F5RjIwrAxl5LM7RFMs+1Av6dxMyr2lrmuxv0XSdpjbHoBV/nl/KXSnXNB3NFrr4="));
				// configuration.dataset.datastore.authentication.oauth20.flow is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.oauth20.authenticationType is
				// hidden, skipping.
				// configuration.dataset.datastore.authentication.oauth20.tokenEndpoint is
				// hidden, skipping.
				// configuration.dataset.datastore.authentication.oauth20.clientId is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.oauth20.clientSecret is
				// hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.methodType", "GET");
				configuration_tHTTPClient_2.put("configuration.dataset.resource", "/workspaces");
				configuration_tHTTPClient_2.put("configuration.dataset.hasPathParams", "false");
				configuration_tHTTPClient_2.put("configuration.dataset.hasQueryParams", "false");
				configuration_tHTTPClient_2.put("configuration.dataset.hasHeaders", "false");
				configuration_tHTTPClient_2.put("configuration.dataset.hasBody", "false");
				// configuration.dataset.body.type is hidden, skipping.
				// configuration.dataset.body.textValue is hidden, skipping.
				// configuration.dataset.body.jsonValue is hidden, skipping.
				// configuration.dataset.body.xmlValue is hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.format", "RAW_TEXT");
				// configuration.dataset.dssl is hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.returnedContent", "STATUS_HEADERS_BODY");
				configuration_tHTTPClient_2.put("configuration.dataset.outputKeyValuePairs", "false");
				// configuration.dataset.forwardInput is hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[0].key", "workspaceName");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[0].value", "{.response.name}");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[1].key", "workspaceID");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[1].value", "{.response.id}");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[2].key", "environmentName");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[2].value",
						"{.response.environment.name}");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[3].key", "environmentID");
				configuration_tHTTPClient_2.put("configuration.dataset.keyValuePairs[3].value",
						"{.response.environment.id}");
				configuration_tHTTPClient_2.put("configuration.downloadFile", "false");
				// configuration.directoryToSave is hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.connectionTimeout", "30000");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.receiveTimeout", "120000");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.bypassCertificateValidation", "false");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.useProxy", "false");
				// configuration.dataset.datastore.proxyType is hidden, skipping.
				// configuration.dataset.datastore.proxyHost is hidden, skipping.
				// configuration.dataset.datastore.proxyPort is hidden, skipping.
				// configuration.dataset.datastore.proxyLogin is hidden, skipping.
				// configuration.dataset.datastore.proxyPassword is hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.dataset.acceptRedirections", "true");
				configuration_tHTTPClient_2.put("configuration.dataset.maxRedirectOnSameURL", "3");
				configuration_tHTTPClient_2.put("configuration.dataset.onlySameHost", "false");
				configuration_tHTTPClient_2.put("configuration.dataset.hasPagination", "false");
				// configuration.dataset.pagination.preset is hidden, skipping.
				// configuration.dataset.pagination.strategy is hidden, skipping.
				// configuration.dataset.pagination.offsetLimitStrategyConfig.location is
				// hidden, skipping.
				// configuration.dataset.pagination.offsetLimitStrategyConfig.offsetParamName is
				// hidden, skipping.
				// configuration.dataset.pagination.offsetLimitStrategyConfig.offsetValue is
				// hidden, skipping.
				// configuration.dataset.pagination.offsetLimitStrategyConfig.limitParamName is
				// hidden, skipping.
				// configuration.dataset.pagination.offsetLimitStrategyConfig.limitValue is
				// hidden, skipping.
				// configuration.dataset.pagination.offsetLimitStrategyConfig.elementsPath is
				// hidden, skipping.
				// configuration.dataset.jsonForceDouble is hidden, skipping.
				// configuration.dataset.enforceNumberAsString is hidden, skipping.
				configuration_tHTTPClient_2.put("configuration.uploadFiles", "false");
				configuration_tHTTPClient_2.put("configuration.dieOnError", "false");
				configuration_tHTTPClient_2.put("configuration.dataset.__version", "1");
				configuration_tHTTPClient_2.put("configuration.dataset.datastore.__version", "1");

				final int chunkSize_tHTTPClient_2 = globalMap.containsKey("MAX_BATCH_SIZE_tHTTPClient_2")
						? (Integer) globalMap.get("MAX_BATCH_SIZE_tHTTPClient_2")
						: 100;

				final org.talend.sdk.component.runtime.output.Processor processorImpl_tHTTPClient_2 = mgr_tHTTPClient_2
						.findProcessor("HTTP", "Client", 1, configuration_tHTTPClient_2)
						.orElseThrow(() -> new IllegalArgumentException("Can't find HTTP#Client"));
				org.talend.sdk.component.runtime.di.studio.RuntimeContextInjector.injectLifecycle(
						processorImpl_tHTTPClient_2,
						new org.talend.sdk.component.api.context.RuntimeContextHolder("tHTTPClient_2", globalMap));

				final org.talend.sdk.component.runtime.di.studio.ParameterSetter changer_tHTTPClient_2 = new org.talend.sdk.component.runtime.di.studio.ParameterSetter(
						processorImpl_tHTTPClient_2);

				final javax.json.bind.Jsonb jsonb_tHTTPClient_2 = (javax.json.bind.Jsonb) mgr_tHTTPClient_2
						.findPlugin(processorImpl_tHTTPClient_2.plugin()).get()
						.get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class).getServices()
						.get(javax.json.bind.Jsonb.class);

				final java.util.Map<Class<?>, Object> servicesMapper_tHTTPClient_2 = mgr_tHTTPClient_2
						.findPlugin(processorImpl_tHTTPClient_2.plugin()).get()
						.get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class).getServices();

				final org.talend.sdk.component.runtime.di.AutoChunkProcessor processor_tHTTPClient_2 = new org.talend.sdk.component.runtime.di.AutoChunkProcessor(
						chunkSize_tHTTPClient_2, processorImpl_tHTTPClient_2);
				org.talend.sdk.component.runtime.di.JobStateAware.init(processorImpl_tHTTPClient_2, globalMap);
				processor_tHTTPClient_2.start();
				globalMap.put("processor_tHTTPClient_2", processor_tHTTPClient_2);

				int nbLineInput_tHTTPClient_2 = 0;
				globalMap.put("tHTTPClient_2_NB_LINE", nbLineInput_tHTTPClient_2);

				final org.talend.sdk.component.runtime.di.InputsHandler inputsHandler_tHTTPClient_2 = new org.talend.sdk.component.runtime.di.InputsHandler(
						jsonb_tHTTPClient_2, servicesMapper_tHTTPClient_2);
				final org.talend.sdk.component.runtime.output.InputFactory inputs_tHTTPClient_2 = inputsHandler_tHTTPClient_2
						.asInputFactory();

				final org.talend.sdk.component.runtime.di.OutputsHandler outputHandler_tHTTPClient_2 = new org.talend.sdk.component.runtime.di.OutputsHandler(
						jsonb_tHTTPClient_2, servicesMapper_tHTTPClient_2);
				final org.talend.sdk.component.runtime.output.OutputFactory outputs_tHTTPClient_2 = outputHandler_tHTTPClient_2
						.asOutputFactory();

				/**
				 * [tHTTPClient_2 begin ] stop
				 */

				/**
				 * [tHTTPClient_2 main ] start
				 */

				currentComponent = "tHTTPClient_2";

				cLabel = "getIDs";

				processor_tHTTPClient_2.onElement(inputs_tHTTPClient_2, outputs_tHTTPClient_2);
				nbLineInput_tHTTPClient_2++;
				globalMap.put("tHTTPClient_2_NB_LINE", nbLineInput_tHTTPClient_2);

				tos_count_tHTTPClient_2++;

				/**
				 * [tHTTPClient_2 main ] stop
				 */

				/**
				 * [tHTTPClient_2 process_data_begin ] start
				 */

				currentComponent = "tHTTPClient_2";

				cLabel = "getIDs";

				while (outputHandler_tHTTPClient_2.hasMoreData()) {

					/**
					 * [tHTTPClient_2 process_data_begin ] stop
					 */

					/**
					 * [tHTTPClient_2 process_data_end ] start
					 */

					currentComponent = "tHTTPClient_2";

					cLabel = "getIDs";

				} // End of data

				/**
				 * [tHTTPClient_2 process_data_end ] stop
				 */

				/**
				 * [tHTTPClient_2 end ] start
				 */

				currentComponent = "tHTTPClient_2";

				cLabel = "getIDs";

				globalMap.put("tHTTPClient_2_NB_LINE", nbLineInput_tHTTPClient_2);

				if (log.isDebugEnabled())
					log.debug("tHTTPClient_2 - " + ("Done."));

				ok_Hash.put("tHTTPClient_2", true);
				end_Hash.put("tHTTPClient_2", System.currentTimeMillis());

				/**
				 * [tHTTPClient_2 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tHTTPClient_2 finally ] start
				 */

				currentComponent = "tHTTPClient_2";

				cLabel = "getIDs";

				final org.talend.sdk.component.runtime.di.AutoChunkProcessor processor_tHTTPClient_2 = org.talend.sdk.component.runtime.di.AutoChunkProcessor.class
						.cast(globalMap.remove("processor_tHTTPClient_2"));
				try {
					if (processor_tHTTPClient_2 != null) {
						processor_tHTTPClient_2.stop();
					}
				} catch (final RuntimeException re) {
					throw new TalendException(re, currentComponent, cLabel, globalMap);
				}

				/**
				 * [tHTTPClient_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tHTTPClient_2_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "JDNE8d_" + subJobPidCounter.getAndIncrement());

		String iterateId = "";

		String currentComponent = "";
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				ok_Hash.put("talendJobLog", false);
				start_Hash.put("talendJobLog", System.currentTimeMillis());

				currentComponent = "talendJobLog";

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				currentComponent = "talendJobLog";

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				currentComponent = "talendJobLog";

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				currentComponent = "talendJobLog";

				/**
				 * [talendJobLog finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final getEnvironmentID getEnvironmentIDClass = new getEnvironmentID();

		int exitCode = getEnvironmentIDClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'getEnvironmentID' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20230913_0925-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'getEnvironmentID' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_1hXIQLCHEe-kcMyE6M_qOg");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2024-12-02T08:50:55.275012Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = getEnvironmentID.class.getClassLoader()
					.getResourceAsStream("tmc_demo2/getenvironmentid_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = getEnvironmentID.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'getEnvironmentID' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tHTTPClient_2Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tHTTPClient_2) {
			globalMap.put("tHTTPClient_2_SUBPROCESS_STATE", -1);

			e_tHTTPClient_2.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : getEnvironmentID");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'getEnvironmentID' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 60274 characters generated by Talend Cloud Data Fabric on the December 2,
 * 2024 at 8:50:55 AM GMT
 ************************************************************************************************/