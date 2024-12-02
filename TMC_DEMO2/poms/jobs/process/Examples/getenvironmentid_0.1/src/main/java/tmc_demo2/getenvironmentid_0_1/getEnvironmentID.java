
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

	public void tHTTPClient_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tHTTPClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFilterRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tHTTPClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tHTTPClient_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tHTTPClient_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_TMC_DEMO2_getEnvironmentID = new byte[0];
		static byte[] commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[0];

		public String workspaceName;

		public String getWorkspaceName() {
			return this.workspaceName;
		}

		public Boolean workspaceNameIsNullable() {
			return true;
		}

		public Boolean workspaceNameIsKey() {
			return false;
		}

		public Integer workspaceNameLength() {
			return null;
		}

		public Integer workspaceNamePrecision() {
			return null;
		}

		public String workspaceNameDefault() {

			return null;

		}

		public String workspaceNameComment() {

			return "";

		}

		public String workspaceNamePattern() {

			return "";

		}

		public String workspaceNameOriginalDbColumnName() {

			return "workspaceName";

		}

		public String workspaceID;

		public String getWorkspaceID() {
			return this.workspaceID;
		}

		public Boolean workspaceIDIsNullable() {
			return true;
		}

		public Boolean workspaceIDIsKey() {
			return false;
		}

		public Integer workspaceIDLength() {
			return null;
		}

		public Integer workspaceIDPrecision() {
			return null;
		}

		public String workspaceIDDefault() {

			return null;

		}

		public String workspaceIDComment() {

			return "";

		}

		public String workspaceIDPattern() {

			return "";

		}

		public String workspaceIDOriginalDbColumnName() {

			return "workspaceID";

		}

		public String environmentName;

		public String getEnvironmentName() {
			return this.environmentName;
		}

		public Boolean environmentNameIsNullable() {
			return true;
		}

		public Boolean environmentNameIsKey() {
			return false;
		}

		public Integer environmentNameLength() {
			return null;
		}

		public Integer environmentNamePrecision() {
			return null;
		}

		public String environmentNameDefault() {

			return null;

		}

		public String environmentNameComment() {

			return "";

		}

		public String environmentNamePattern() {

			return "";

		}

		public String environmentNameOriginalDbColumnName() {

			return "environmentName";

		}

		public String environmentID;

		public String getEnvironmentID() {
			return this.environmentID;
		}

		public Boolean environmentIDIsNullable() {
			return true;
		}

		public Boolean environmentIDIsKey() {
			return false;
		}

		public Integer environmentIDLength() {
			return null;
		}

		public Integer environmentIDPrecision() {
			return null;
		}

		public String environmentIDDefault() {

			return null;

		}

		public String environmentIDComment() {

			return "";

		}

		public String environmentIDPattern() {

			return "";

		}

		public String environmentIDOriginalDbColumnName() {

			return "environmentID";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TMC_DEMO2_getEnvironmentID.length) {
					if (length < 1024 && commonByteArray_TMC_DEMO2_getEnvironmentID.length == 0) {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[1024];
					} else {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length);
				strReturn = new String(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TMC_DEMO2_getEnvironmentID.length) {
					if (length < 1024 && commonByteArray_TMC_DEMO2_getEnvironmentID.length == 0) {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[1024];
					} else {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length);
				strReturn = new String(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TMC_DEMO2_getEnvironmentID) {

				try {

					int length = 0;

					this.workspaceName = readString(dis);

					this.workspaceID = readString(dis);

					this.environmentName = readString(dis);

					this.environmentID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TMC_DEMO2_getEnvironmentID) {

				try {

					int length = 0;

					this.workspaceName = readString(dis);

					this.workspaceID = readString(dis);

					this.environmentName = readString(dis);

					this.environmentID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.workspaceName, dos);

				// String

				writeString(this.workspaceID, dos);

				// String

				writeString(this.environmentName, dos);

				// String

				writeString(this.environmentID, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.workspaceName, dos);

				// String

				writeString(this.workspaceID, dos);

				// String

				writeString(this.environmentName, dos);

				// String

				writeString(this.environmentID, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("workspaceName=" + workspaceName);
			sb.append(",workspaceID=" + workspaceID);
			sb.append(",environmentName=" + environmentName);
			sb.append(",environmentID=" + environmentID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (workspaceName == null) {
				sb.append("<null>");
			} else {
				sb.append(workspaceName);
			}

			sb.append("|");

			if (workspaceID == null) {
				sb.append("<null>");
			} else {
				sb.append(workspaceID);
			}

			sb.append("|");

			if (environmentName == null) {
				sb.append("<null>");
			} else {
				sb.append(environmentName);
			}

			sb.append("|");

			if (environmentID == null) {
				sb.append("<null>");
			} else {
				sb.append(environmentID);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_TMC_DEMO2_getEnvironmentID = new byte[0];
		static byte[] commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[0];

		public String workspaceName;

		public String getWorkspaceName() {
			return this.workspaceName;
		}

		public Boolean workspaceNameIsNullable() {
			return true;
		}

		public Boolean workspaceNameIsKey() {
			return false;
		}

		public Integer workspaceNameLength() {
			return null;
		}

		public Integer workspaceNamePrecision() {
			return null;
		}

		public String workspaceNameDefault() {

			return null;

		}

		public String workspaceNameComment() {

			return "";

		}

		public String workspaceNamePattern() {

			return "";

		}

		public String workspaceNameOriginalDbColumnName() {

			return "workspaceName";

		}

		public String workspaceID;

		public String getWorkspaceID() {
			return this.workspaceID;
		}

		public Boolean workspaceIDIsNullable() {
			return true;
		}

		public Boolean workspaceIDIsKey() {
			return false;
		}

		public Integer workspaceIDLength() {
			return null;
		}

		public Integer workspaceIDPrecision() {
			return null;
		}

		public String workspaceIDDefault() {

			return null;

		}

		public String workspaceIDComment() {

			return "";

		}

		public String workspaceIDPattern() {

			return "";

		}

		public String workspaceIDOriginalDbColumnName() {

			return "workspaceID";

		}

		public String environmentName;

		public String getEnvironmentName() {
			return this.environmentName;
		}

		public Boolean environmentNameIsNullable() {
			return true;
		}

		public Boolean environmentNameIsKey() {
			return false;
		}

		public Integer environmentNameLength() {
			return null;
		}

		public Integer environmentNamePrecision() {
			return null;
		}

		public String environmentNameDefault() {

			return null;

		}

		public String environmentNameComment() {

			return "";

		}

		public String environmentNamePattern() {

			return "";

		}

		public String environmentNameOriginalDbColumnName() {

			return "environmentName";

		}

		public String environmentID;

		public String getEnvironmentID() {
			return this.environmentID;
		}

		public Boolean environmentIDIsNullable() {
			return true;
		}

		public Boolean environmentIDIsKey() {
			return false;
		}

		public Integer environmentIDLength() {
			return null;
		}

		public Integer environmentIDPrecision() {
			return null;
		}

		public String environmentIDDefault() {

			return null;

		}

		public String environmentIDComment() {

			return "";

		}

		public String environmentIDPattern() {

			return "";

		}

		public String environmentIDOriginalDbColumnName() {

			return "environmentID";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TMC_DEMO2_getEnvironmentID.length) {
					if (length < 1024 && commonByteArray_TMC_DEMO2_getEnvironmentID.length == 0) {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[1024];
					} else {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length);
				strReturn = new String(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_TMC_DEMO2_getEnvironmentID.length) {
					if (length < 1024 && commonByteArray_TMC_DEMO2_getEnvironmentID.length == 0) {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[1024];
					} else {
						commonByteArray_TMC_DEMO2_getEnvironmentID = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length);
				strReturn = new String(commonByteArray_TMC_DEMO2_getEnvironmentID, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_TMC_DEMO2_getEnvironmentID) {

				try {

					int length = 0;

					this.workspaceName = readString(dis);

					this.workspaceID = readString(dis);

					this.environmentName = readString(dis);

					this.environmentID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_TMC_DEMO2_getEnvironmentID) {

				try {

					int length = 0;

					this.workspaceName = readString(dis);

					this.workspaceID = readString(dis);

					this.environmentName = readString(dis);

					this.environmentID = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.workspaceName, dos);

				// String

				writeString(this.workspaceID, dos);

				// String

				writeString(this.environmentName, dos);

				// String

				writeString(this.environmentID, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.workspaceName, dos);

				// String

				writeString(this.workspaceID, dos);

				// String

				writeString(this.environmentName, dos);

				// String

				writeString(this.environmentID, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("workspaceName=" + workspaceName);
			sb.append(",workspaceID=" + workspaceID);
			sb.append(",environmentName=" + environmentName);
			sb.append(",environmentID=" + environmentID);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (workspaceName == null) {
				sb.append("<null>");
			} else {
				sb.append(workspaceName);
			}

			sb.append("|");

			if (workspaceID == null) {
				sb.append("<null>");
			} else {
				sb.append(workspaceID);
			}

			sb.append("|");

			if (environmentName == null) {
				sb.append("<null>");
			} else {
				sb.append(environmentName);
			}

			sb.append("|");

			if (environmentID == null) {
				sb.append("<null>");
			} else {
				sb.append(environmentID);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tHTTPClient_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tHTTPClient_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tHTTPClient_1");
		org.slf4j.MDC.put("_subJobPid", "QrFmSi_" + subJobPidCounter.getAndIncrement());

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

				row1Struct row1 = new row1Struct();
				row2Struct row2 = new row2Struct();

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - " + (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
					talendJobLogProcess(globalMap);
				}

				///////////////////////

				class Util_tLogRow_1 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[4];

					public void addRow(String[] row) {

						for (int i = 0; i < 4; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 3 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 3 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|%3$-");
							sbformat.append(colLengths[2]);
							sbformat.append("s");

							sbformat.append("|%4$-");
							sbformat.append(colLengths[3]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);
						for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						for (int i = 0; i < colLengths[1] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);
						for (int i = 0; i < colLengths[2] - fillChars[3].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[3] - fillChars[1].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("tLogRow_1");
				util_tLogRow_1
						.addRow(new String[] { "workspaceName", "workspaceID", "environmentName", "environmentID", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tFilterRow_1 begin ] start
				 */

				ok_Hash.put("tFilterRow_1", false);
				start_Hash.put("tFilterRow_1", System.currentTimeMillis());

				currentComponent = "tFilterRow_1";

				cLabel = "filterWorkspace";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tFilterRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFilterRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFilterRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFilterRow_1 = new StringBuilder();
							log4jParamters_tFilterRow_1.append("Parameters:");
							log4jParamters_tFilterRow_1.append("LOGICAL_OP" + " = " + "&&");
							log4jParamters_tFilterRow_1.append(" | ");
							log4jParamters_tFilterRow_1.append("CONDITIONS" + " = " + "[{OPERATOR=" + ("==")
									+ ", RVALUE=" + ("\"DEV\"") + ", INPUT_COLUMN=" + ("environmentName")
									+ ", FUNCTION="
									+ ("$source == null? false : $source.toUpperCase().compareTo($target) $operator 0")
									+ "}, {OPERATOR=" + ("==") + ", RVALUE=" + ("\"CLOUD_RUN\"") + ", INPUT_COLUMN="
									+ ("workspaceName") + ", FUNCTION="
									+ ("$source == null? false : $source.toUpperCase().compareTo($target) $operator 0")
									+ "}]");
							log4jParamters_tFilterRow_1.append(" | ");
							log4jParamters_tFilterRow_1.append("USE_ADVANCED" + " = " + "false");
							log4jParamters_tFilterRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFilterRow_1 - " + (log4jParamters_tFilterRow_1));
						}
					}
					new BytesLimit65535_tFilterRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tFilterRow_1", "filterWorkspace", "tFilterRow");
					talendJobLogProcess(globalMap);
				}

				int nb_line_tFilterRow_1 = 0;
				int nb_line_ok_tFilterRow_1 = 0;
				int nb_line_reject_tFilterRow_1 = 0;

				class Operator_tFilterRow_1 {
					private String sErrorMsg = "";
					private boolean bMatchFlag = true;
					private String sUnionFlag = "&&";

					public Operator_tFilterRow_1(String unionFlag) {
						sUnionFlag = unionFlag;
						bMatchFlag = "||".equals(unionFlag) ? false : true;
					}

					public String getErrorMsg() {
						if (sErrorMsg != null && sErrorMsg.length() > 1)
							return sErrorMsg.substring(1);
						else
							return null;
					}

					public boolean getMatchFlag() {
						return bMatchFlag;
					}

					public void matches(boolean partMatched, String reason) {
						// no need to care about the next judgement
						if ("||".equals(sUnionFlag) && bMatchFlag) {
							return;
						}

						if (!partMatched) {
							sErrorMsg += "|" + reason;
						}

						if ("||".equals(sUnionFlag))
							bMatchFlag = bMatchFlag || partMatched;
						else
							bMatchFlag = bMatchFlag && partMatched;
					}
				}

				/**
				 * [tFilterRow_1 begin ] stop
				 */

				/**
				 * [tHTTPClient_1 begin ] start
				 */

				ok_Hash.put("tHTTPClient_1", false);
				start_Hash.put("tHTTPClient_1", System.currentTimeMillis());

				currentComponent = "tHTTPClient_1";

				cLabel = "getIDs";

				int tos_count_tHTTPClient_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tHTTPClient_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tHTTPClient_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tHTTPClient_1 = new StringBuilder();
							log4jParamters_tHTTPClient_1.append("Parameters:");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.datastore.base" + " = "
									+ "https://api.a.cloud.talend.com/tmc/v2.6");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.authentication.type" + " = " + "OAuth20");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.authentication.oauth20.flow" + " = "
											+ "CLIENT_CREDENTIAL");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.authentication.oauth20.authenticationType"
											+ " = " + "FORM");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.authentication.oauth20.tokenEndpoint"
											+ " = " + "");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append(
									"configuration.dataset.datastore.authentication.oauth20.clientId" + " = " + "");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append(
									"configuration.dataset.datastore.authentication.oauth20.clientSecret" + " = "
											+ String.valueOf(routines.system.PasswordEncryptUtil.encryptPassword(""))
													.substring(0, 4)
											+ "...");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append(
									"configuration.dataset.datastore.authentication.oauth20.scopes" + " = " + "[]");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.methodType" + " = " + "GET");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.resource" + " = " + "/workspaces");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.hasPathParams" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.hasQueryParams" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.hasHeaders" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.hasBody" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.format" + " = " + "JSON");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.dssl" + " = " + ".root");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.returnedContent" + " = " + "BODY_ONLY");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.outputKeyValuePairs" + " = " + "true");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.forwardInput" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.keyValuePairs" + " = "
									+ "[{configuration.dataset.keyValuePairs[].key=" + ("\"workspaceName\"")
									+ ", configuration.dataset.keyValuePairs[].value=" + ("\"{.response.name}\"")
									+ "}, {configuration.dataset.keyValuePairs[].key=" + ("\"workspaceID\"")
									+ ", configuration.dataset.keyValuePairs[].value=" + ("\"{.response.id}\"")
									+ "}, {configuration.dataset.keyValuePairs[].key=" + ("\"environmentName\"")
									+ ", configuration.dataset.keyValuePairs[].value="
									+ ("\"{.response.environment.name}\"")
									+ "}, {configuration.dataset.keyValuePairs[].key=" + ("\"environmentID\"")
									+ ", configuration.dataset.keyValuePairs[].value="
									+ ("\"{.response.environment.id}\"") + "}]");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.downloadFile" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.connectionTimeout" + " = " + "30000");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.receiveTimeout" + " = " + "120000");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append(
									"configuration.dataset.datastore.bypassCertificateValidation" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.datastore.useProxy" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.acceptRedirections" + " = " + "true");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.maxRedirectOnSameURL" + " = " + "3");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dataset.onlySameHost" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.hasPagination" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1
									.append("configuration.dataset.jsonForceDouble" + " = " + "true");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.uploadFiles" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							log4jParamters_tHTTPClient_1.append("configuration.dieOnError" + " = " + "false");
							log4jParamters_tHTTPClient_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tHTTPClient_1 - " + (log4jParamters_tHTTPClient_1));
						}
					}
					new BytesLimit65535_tHTTPClient_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tHTTPClient_1", "getIDs", "HTTPClient");
					talendJobLogProcess(globalMap);
				}

				final org.talend.sdk.component.runtime.manager.ComponentManager mgr_tHTTPClient_1 = org.talend.sdk.component.runtime.manager.ComponentManager
						.instance();
				if (mgr_tHTTPClient_1.getContainer().findAll().isEmpty()) {
					mgr_tHTTPClient_1.autoDiscoverPlugins(false, true);
				}

				final java.util.Map<String, String> configuration_tHTTPClient_1 = new java.util.HashMap<>();
				final java.util.Map<String, String> registry_metadata_tHTTPClient_1 = new java.util.HashMap<>();
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.base",
						"https://api.a.cloud.talend.com/tmc/v2.6");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.authentication.type", "OAuth20");
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
				// configuration.dataset.datastore.authentication.apiKey.destination is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.apiKey.headerName is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.apiKey.queryName is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.apiKey.prefix is hidden,
				// skipping.
				// configuration.dataset.datastore.authentication.apiKey.token is hidden,
				// skipping.
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.authentication.oauth20.flow",
						"CLIENT_CREDENTIAL");
				configuration_tHTTPClient_1
						.put("configuration.dataset.datastore.authentication.oauth20.authenticationType", "FORM");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.authentication.oauth20.tokenEndpoint",
						"");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.authentication.oauth20.clientId", "");
				configuration_tHTTPClient_1.put("configuration.dataset.methodType", "GET");
				configuration_tHTTPClient_1.put("configuration.dataset.resource", "/workspaces");
				configuration_tHTTPClient_1.put("configuration.dataset.hasPathParams", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.hasQueryParams", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.hasHeaders", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.hasBody", "false");
				// configuration.dataset.body.type is hidden, skipping.
				// configuration.dataset.body.textValue is hidden, skipping.
				// configuration.dataset.body.jsonValue is hidden, skipping.
				// configuration.dataset.body.xmlValue is hidden, skipping.
				configuration_tHTTPClient_1.put("configuration.dataset.format", "JSON");
				configuration_tHTTPClient_1.put("configuration.dataset.dssl", ".root");
				configuration_tHTTPClient_1.put("configuration.dataset.returnedContent", "BODY_ONLY");
				configuration_tHTTPClient_1.put("configuration.dataset.outputKeyValuePairs", "true");
				configuration_tHTTPClient_1.put("configuration.dataset.forwardInput", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[0].key", "workspaceName");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[0].value", "{.response.name}");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[1].key", "workspaceID");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[1].value", "{.response.id}");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[2].key", "environmentName");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[2].value",
						"{.response.environment.name}");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[3].key", "environmentID");
				configuration_tHTTPClient_1.put("configuration.dataset.keyValuePairs[3].value",
						"{.response.environment.id}");
				configuration_tHTTPClient_1.put("configuration.downloadFile", "false");
				// configuration.directoryToSave is hidden, skipping.
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.connectionTimeout", "30000");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.receiveTimeout", "120000");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.bypassCertificateValidation", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.useProxy", "false");
				// configuration.dataset.datastore.proxyType is hidden, skipping.
				// configuration.dataset.datastore.proxyHost is hidden, skipping.
				// configuration.dataset.datastore.proxyPort is hidden, skipping.
				// configuration.dataset.datastore.proxyLogin is hidden, skipping.
				// configuration.dataset.datastore.proxyPassword is hidden, skipping.
				configuration_tHTTPClient_1.put("configuration.dataset.acceptRedirections", "true");
				configuration_tHTTPClient_1.put("configuration.dataset.maxRedirectOnSameURL", "3");
				configuration_tHTTPClient_1.put("configuration.dataset.onlySameHost", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.hasPagination", "false");
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
				configuration_tHTTPClient_1.put("configuration.dataset.jsonForceDouble", "true");
				// configuration.dataset.enforceNumberAsString is hidden, skipping.
				configuration_tHTTPClient_1.put("configuration.uploadFiles", "false");
				configuration_tHTTPClient_1.put("configuration.dieOnError", "false");
				configuration_tHTTPClient_1.put("configuration.dataset.__version", "1");
				configuration_tHTTPClient_1.put("configuration.dataset.datastore.__version", "1");
				configuration_tHTTPClient_1.put("SCHEMA_FLOW[0]", "workspaceName");
				configuration_tHTTPClient_1.put("SCHEMA_FLOW[1]", "workspaceID");
				configuration_tHTTPClient_1.put("SCHEMA_FLOW[2]", "environmentName");
				configuration_tHTTPClient_1.put("SCHEMA_FLOW[3]", "environmentID");

				final int chunkSize_tHTTPClient_1 = globalMap.containsKey("MAX_BATCH_SIZE_tHTTPClient_1")
						? (Integer) globalMap.get("MAX_BATCH_SIZE_tHTTPClient_1")
						: 100;

				final org.talend.sdk.component.runtime.output.Processor processorImpl_tHTTPClient_1 = mgr_tHTTPClient_1
						.findProcessor("HTTP", "Client", 1, configuration_tHTTPClient_1)
						.orElseThrow(() -> new IllegalArgumentException("Can't find HTTP#Client"));
				org.talend.sdk.component.runtime.di.studio.RuntimeContextInjector.injectLifecycle(
						processorImpl_tHTTPClient_1,
						new org.talend.sdk.component.api.context.RuntimeContextHolder("tHTTPClient_1", globalMap));

				final org.talend.sdk.component.runtime.di.studio.ParameterSetter changer_tHTTPClient_1 = new org.talend.sdk.component.runtime.di.studio.ParameterSetter(
						processorImpl_tHTTPClient_1);

				final javax.json.bind.Jsonb jsonb_tHTTPClient_1 = (javax.json.bind.Jsonb) mgr_tHTTPClient_1
						.findPlugin(processorImpl_tHTTPClient_1.plugin()).get()
						.get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class).getServices()
						.get(javax.json.bind.Jsonb.class);

				final java.util.Map<Class<?>, Object> servicesMapper_tHTTPClient_1 = mgr_tHTTPClient_1
						.findPlugin(processorImpl_tHTTPClient_1.plugin()).get()
						.get(org.talend.sdk.component.runtime.manager.ComponentManager.AllServices.class).getServices();

				final org.talend.sdk.component.runtime.di.AutoChunkProcessor processor_tHTTPClient_1 = new org.talend.sdk.component.runtime.di.AutoChunkProcessor(
						chunkSize_tHTTPClient_1, processorImpl_tHTTPClient_1);
				org.talend.sdk.component.runtime.di.JobStateAware.init(processorImpl_tHTTPClient_1, globalMap);
				processor_tHTTPClient_1.start();
				globalMap.put("processor_tHTTPClient_1", processor_tHTTPClient_1);

				int nbLineInput_tHTTPClient_1 = 0;
				globalMap.put("tHTTPClient_1_NB_LINE", nbLineInput_tHTTPClient_1);

				final org.talend.sdk.component.runtime.di.InputsHandler inputsHandler_tHTTPClient_1 = new org.talend.sdk.component.runtime.di.InputsHandler(
						jsonb_tHTTPClient_1, servicesMapper_tHTTPClient_1);
				final org.talend.sdk.component.runtime.output.InputFactory inputs_tHTTPClient_1 = inputsHandler_tHTTPClient_1
						.asInputFactory();

				final org.talend.sdk.component.runtime.di.OutputsHandler outputHandler_tHTTPClient_1 = new org.talend.sdk.component.runtime.di.OutputsHandler(
						jsonb_tHTTPClient_1, servicesMapper_tHTTPClient_1);
				outputHandler_tHTTPClient_1.addConnection("FLOW", row1.getClass());
				final org.talend.sdk.component.runtime.output.OutputFactory outputs_tHTTPClient_1 = outputHandler_tHTTPClient_1
						.asOutputFactory();

				/**
				 * [tHTTPClient_1 begin ] stop
				 */

				/**
				 * [tHTTPClient_1 main ] start
				 */

				currentComponent = "tHTTPClient_1";

				cLabel = "getIDs";

				processor_tHTTPClient_1.onElement(inputs_tHTTPClient_1, outputs_tHTTPClient_1);
				nbLineInput_tHTTPClient_1++;
				globalMap.put("tHTTPClient_1_NB_LINE", nbLineInput_tHTTPClient_1);

				tos_count_tHTTPClient_1++;

				/**
				 * [tHTTPClient_1 main ] stop
				 */

				/**
				 * [tHTTPClient_1 process_data_begin ] start
				 */

				currentComponent = "tHTTPClient_1";

				cLabel = "getIDs";

				while (outputHandler_tHTTPClient_1.hasMoreData()) {
					row1 = outputHandler_tHTTPClient_1.getValue("FLOW");

					/**
					 * [tHTTPClient_1 process_data_begin ] stop
					 */

					/**
					 * [tFilterRow_1 main ] start
					 */

					currentComponent = "tFilterRow_1";

					cLabel = "filterWorkspace";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row1", "tHTTPClient_1", "getIDs", "HTTPClient", "tFilterRow_1", "filterWorkspace",
							"tFilterRow"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
					}

					row2 = null;
					Operator_tFilterRow_1 ope_tFilterRow_1 = new Operator_tFilterRow_1("&&");
					ope_tFilterRow_1.matches(
							(row1.environmentName == null ? false
									: row1.environmentName.toUpperCase().compareTo("DEV") == 0),
							" environmentName.toUpperCase().compareTo(\"DEV\") == 0 failed");
					ope_tFilterRow_1.matches(
							(row1.workspaceName == null ? false
									: row1.workspaceName.toUpperCase().compareTo("CLOUD_RUN") == 0),
							" workspaceName.toUpperCase().compareTo(\"CLOUD_RUN\") == 0 failed");

					if (ope_tFilterRow_1.getMatchFlag()) {
						if (row2 == null) {
							row2 = new row2Struct();
						}
						row2.workspaceName = row1.workspaceName;
						row2.workspaceID = row1.workspaceID;
						row2.environmentName = row1.environmentName;
						row2.environmentID = row1.environmentID;
						log.debug("tFilterRow_1 - Process the record " + (nb_line_tFilterRow_1 + 1) + ".");

						nb_line_ok_tFilterRow_1++;
					} else {
						nb_line_reject_tFilterRow_1++;
					}

					nb_line_tFilterRow_1++;

					tos_count_tFilterRow_1++;

					/**
					 * [tFilterRow_1 main ] stop
					 */

					/**
					 * [tFilterRow_1 process_data_begin ] start
					 */

					currentComponent = "tFilterRow_1";

					cLabel = "filterWorkspace";

					/**
					 * [tFilterRow_1 process_data_begin ] stop
					 */
// Start of branch "row2"
					if (row2 != null) {

						/**
						 * [tLogRow_1 main ] start
						 */

						currentComponent = "tLogRow_1";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row2", "tFilterRow_1", "filterWorkspace", "tFilterRow", "tLogRow_1", "tLogRow_1",
								"tLogRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
						}

///////////////////////		

						String[] row_tLogRow_1 = new String[4];

						if (row2.workspaceName != null) { //
							row_tLogRow_1[0] = String.valueOf(row2.workspaceName);

						} //

						if (row2.workspaceID != null) { //
							row_tLogRow_1[1] = String.valueOf(row2.workspaceID);

						} //

						if (row2.environmentName != null) { //
							row_tLogRow_1[2] = String.valueOf(row2.environmentName);

						} //

						if (row2.environmentID != null) { //
							row_tLogRow_1[3] = String.valueOf(row2.environmentID);

						} //

						util_tLogRow_1.addRow(row_tLogRow_1);
						nb_line_tLogRow_1++;
						log.info("tLogRow_1 - Content of row " + nb_line_tLogRow_1 + ": "
								+ TalendString.unionString("|", row_tLogRow_1));
//////

//////                    

///////////////////////    			

						tos_count_tLogRow_1++;

						/**
						 * [tLogRow_1 main ] stop
						 */

						/**
						 * [tLogRow_1 process_data_begin ] start
						 */

						currentComponent = "tLogRow_1";

						/**
						 * [tLogRow_1 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_1 process_data_end ] start
						 */

						currentComponent = "tLogRow_1";

						/**
						 * [tLogRow_1 process_data_end ] stop
						 */

					} // End of branch "row2"

					/**
					 * [tFilterRow_1 process_data_end ] start
					 */

					currentComponent = "tFilterRow_1";

					cLabel = "filterWorkspace";

					/**
					 * [tFilterRow_1 process_data_end ] stop
					 */

					/**
					 * [tHTTPClient_1 process_data_end ] start
					 */

					currentComponent = "tHTTPClient_1";

					cLabel = "getIDs";

				} // End of data

				/**
				 * [tHTTPClient_1 process_data_end ] stop
				 */

				/**
				 * [tHTTPClient_1 end ] start
				 */

				currentComponent = "tHTTPClient_1";

				cLabel = "getIDs";

				globalMap.put("tHTTPClient_1_NB_LINE", nbLineInput_tHTTPClient_1);

				if (log.isDebugEnabled())
					log.debug("tHTTPClient_1 - " + ("Done."));

				ok_Hash.put("tHTTPClient_1", true);
				end_Hash.put("tHTTPClient_1", System.currentTimeMillis());

				/**
				 * [tHTTPClient_1 end ] stop
				 */

				/**
				 * [tFilterRow_1 end ] start
				 */

				currentComponent = "tFilterRow_1";

				cLabel = "filterWorkspace";

				globalMap.put("tFilterRow_1_NB_LINE", nb_line_tFilterRow_1);
				globalMap.put("tFilterRow_1_NB_LINE_OK", nb_line_ok_tFilterRow_1);
				globalMap.put("tFilterRow_1_NB_LINE_REJECT", nb_line_reject_tFilterRow_1);

				log.info("tFilterRow_1 - Processed records count:" + nb_line_tFilterRow_1 + ". Matched records count:"
						+ nb_line_ok_tFilterRow_1 + ". Rejected records count:" + nb_line_reject_tFilterRow_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tHTTPClient_1", "getIDs", "HTTPClient", "tFilterRow_1", "filterWorkspace", "tFilterRow",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tFilterRow_1 - " + ("Done."));

				ok_Hash.put("tFilterRow_1", true);
				end_Hash.put("tFilterRow_1", System.currentTimeMillis());

				/**
				 * [tFilterRow_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ") + (nb_line_tLogRow_1) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tFilterRow_1", "filterWorkspace", "tFilterRow", "tLogRow_1", "tLogRow_1", "tLogRow",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
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
				 * [tHTTPClient_1 finally ] start
				 */

				currentComponent = "tHTTPClient_1";

				cLabel = "getIDs";

				final org.talend.sdk.component.runtime.di.AutoChunkProcessor processor_tHTTPClient_1 = org.talend.sdk.component.runtime.di.AutoChunkProcessor.class
						.cast(globalMap.remove("processor_tHTTPClient_1"));
				try {
					if (processor_tHTTPClient_1 != null) {
						processor_tHTTPClient_1.stop();
					}
				} catch (final RuntimeException re) {
					throw new TalendException(re, currentComponent, cLabel, globalMap);
				}

				/**
				 * [tHTTPClient_1 finally ] stop
				 */

				/**
				 * [tFilterRow_1 finally ] start
				 */

				currentComponent = "tFilterRow_1";

				cLabel = "filterWorkspace";

				/**
				 * [tFilterRow_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tHTTPClient_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "Vx2iYn_" + subJobPidCounter.getAndIncrement());

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
		org.slf4j.MDC.put("_compiledAtTimestamp", "2024-12-02T08:38:49.714667600Z");

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
			tHTTPClient_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tHTTPClient_1) {
			globalMap.put("tHTTPClient_1_SUBPROCESS_STATE", -1);

			e_tHTTPClient_1.printStackTrace();

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
 * 100056 characters generated by Talend Cloud Data Fabric on the December 2,
 * 2024 at 8:38:49 AM GMT
 ************************************************************************************************/