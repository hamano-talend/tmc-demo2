
package tmc_demo2.movie_rental_0_1;

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
 * Job: movie_rental Purpose: <br>
 * Description:  <br>
 * @author Hamano, Masaki
 * @version 8.0.1.20230913_0925-patch
 * @status 
 */
public class movie_rental implements TalendJob {
	static {System.setProperty("TalendJob.log", "movie_rental.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(movie_rental.class);
	

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
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
			
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "movie_rental";
	private final String projectName = "TMC_DEMO2";
	public Integer errorCode = null;
	private String currentComponent = "";
	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_9PYYwHikEeqZN5fwy26K9Q", "0.1");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
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
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
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
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				movie_rental.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(movie_rental.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
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

			public void tFlowToIterate_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTResponse_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTResponse_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTResponse_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTRequest_1_Loop_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tRESTRequest_1_In_error(exception, errorComponent, globalMap);
						
						}
					
			public void tRESTRequest_1_In_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tXMLMap_1_TXMLMAP_OUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tXMLMap_1_TXMLMAP_IN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tXMLMap_1_TXMLMAP_IN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTRequest_1_Loop_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}


	



private boolean runInTalendEsbRuntimeContainer = false;

public void setRunInTalendEsbRuntimeContainer(boolean flag) {
	runInTalendEsbRuntimeContainer = flag;
}

protected String restEndpoint;

public void setRestEndpoint(String restEndpoint){
	this.restEndpoint = restEndpoint;
}

public String getRestEndpoint() {
	return "";
}

private boolean runInDaemonMode = true;

public void setRunInDaemonMode(boolean flag) {
	runInDaemonMode = flag;
}

private boolean restTalendJobAlreadyStarted = false;

/**
 * REST provider implementation
 */
@javax.ws.rs.Path("/")

public static class RestServiceProviderImpl4TalendJob {

	@javax.ws.rs.core.Context
	private org.apache.cxf.jaxrs.ext.MessageContext messageContext;
	private final String setCookieHeader = "Set-Cookie";

	private final movie_rental job;

	public RestServiceProviderImpl4TalendJob(movie_rental job) {
		this.job = job;
	}

	private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap, movie_rental job) {
		// pass job DataSources
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources =
			(java.util.Map<String, routines.system.TalendDataSource>) job.globalMap.get(KEY_DB_DATASOURCES);
		if (null != talendDataSources) {
			java.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
			for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources.entrySet()) {
				restDataSources.put(talendDataSourceEntry.getKey(), new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));
			}
			requestGlobalMap.put(KEY_DB_DATASOURCES, restDataSources);
		}

		if (null != job.globalMap.get(KEY_DB_DATASOURCES_RAW)) {
			requestGlobalMap.put(KEY_DB_DATASOURCES_RAW, job.globalMap.get(KEY_DB_DATASOURCES_RAW));
		}

		// pass job shared connections
		requestGlobalMap.putAll(job.getSharedConnections4REST());

		// pass job concurrent map
		requestGlobalMap.put("concurrentHashMap", job.globalMap.get("concurrentHashMap"));

		requestGlobalMap.putAll(job.globalMap);
	}

	private void closePassedDataSourceConnections(java.util.Map<String, Object> requestGlobalMap) {
		// close connections in passed job DataSources
		try {
			java.util.Map<String, routines.system.TalendDataSource> restDataSources =
				(java.util.Map<String, routines.system.TalendDataSource>) requestGlobalMap.get(KEY_DB_DATASOURCES);
			if (null != restDataSources) {
				for (routines.system.TalendDataSource restDataSource : restDataSources.values()) {
					restDataSource.close();
				}
			}
		} catch (Throwable e) {
			e.printStackTrace(System.err);
		}
	}

	private javax.ws.rs.core.Response processRequest(java.util.Map<String, Object> request) {
		
		final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
		
		try {
			globalMap.put("restRequest", request);

			populateRequestWithJobContext(globalMap, job);

			job.tRESTRequest_1_LoopProcess(globalMap);

			java.util.Map<String, Object> response = (java.util.Map<String, Object>) globalMap.get("restResponse");

			Object responseBody = null;
			Integer status = null;
			java.util.Map<String, String> headers = null;
			if (null != response) {
				Object dropJsonRootProp = response.get("drop.json.root.element");
				Boolean dropJsonRoot = (null == dropJsonRootProp) ? false : (Boolean) dropJsonRootProp;
				messageContext.put("drop.json.root.element", dropJsonRoot.toString());

				responseBody = response.get("BODY");
				status = (Integer) response.get("STATUS");
				headers = (java.util.Map<String, String>) response.get("HEADERS");
			} else {
                            responseBody = request.get("ERROR");
                        }
            
			if (null == status) {
				status = (request.containsKey("STATUS")) ? (Integer) request.get("STATUS") : 404;
			}

			javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.status(status).entity(responseBody);
			if (headers != null) {
				for (java.util.Map.Entry<String, String> header : headers.entrySet()) {
					if (header.getKey().equalsIgnoreCase(setCookieHeader)) {
						String cookies = header.getValue().trim();
						String cookiesList[] = cookies.split(";");

						for (String cookie : cookiesList) {
							String cookieTokens[] = cookie.trim().split("=");

							if (cookieTokens.length == 2) {

								String cookieName = cookieTokens[0].trim();
								String cookieValue = cookieTokens[1].trim();

								if (cookieName.length() > 0 && cookieValue.length() > 0) {
									javax.ws.rs.core.NewCookie newCookie = new javax.ws.rs.core.NewCookie(cookieName, cookieValue);
									responseBuilder.cookie(newCookie);
								}
							}
						}
					} else {
						responseBuilder.header(header.getKey(), header.getValue());
					}
				}
			}

			return responseBuilder.build();

		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new javax.ws.rs.WebApplicationException(ex, 500);
		} finally {
			// close DB connections
			closePassedDataSourceConnections(globalMap);
		}
	}

	private javax.ws.rs.core.Response processStreamingResponseRequest(final java.util.Map<String, Object> request) {

		javax.ws.rs.core.StreamingOutput streamingOutput = new javax.ws.rs.core.StreamingOutput() {
			public void write(java.io.OutputStream output) {

				
				final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
				

				try {
					globalMap.put("restResponseStream", output);

					globalMap.put("restRequest", request);

					populateRequestWithJobContext(globalMap, job);

					job.tRESTRequest_1_LoopProcess(globalMap);

					if (globalMap.containsKey("restResponseWrappingClosure")) {
						output.write(((String) globalMap.get("restResponseWrappingClosure")).getBytes());
					}
				} catch (Throwable ex) {
					ex.printStackTrace();
					throw new javax.ws.rs.WebApplicationException(ex, 500);
				} finally {
					// close DB connections
					closePassedDataSourceConnections(globalMap);
				}
			}
		};

		return javax.ws.rs.core.Response.ok().entity(streamingOutput).build();
	}

	@javax.ws.rs.POST()

	@javax.ws.rs.Path("/movies")	@javax.ws.rs.Consumes({ "application/json" })
	@javax.ws.rs.Produces({ "application/json" })
	public javax.ws.rs.core.Response Add_movie(
		
				@javax.ws.rs.QueryParam("title") String title
		, 
				@javax.ws.rs.QueryParam("year") String year
		, 
				@javax.ws.rs.QueryParam("genre") String genre
		
		
			) {
                List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();  
                if(requiredParameterWithNullValueList.size() > 0){
                    return handleWrongRequest(messageContext, 400, "400 Bad Request \n" + requiredParameterWithNullValueList.toString() + " in tRESTRequest_1:Add_movie " + (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));         
                }
		java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		request_tRESTRequest_1.put("VERB", "POST");
		request_tRESTRequest_1.put("OPERATION", "Add_movie");
		request_tRESTRequest_1.put("PATTERN", "/movies");
	

		populateRequestInfo(request_tRESTRequest_1, messageContext);

		java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		
			parameters_tRESTRequest_1.put("QUERY:title:id_String", title);
		
			parameters_tRESTRequest_1.put("QUERY:year:id_String", year);
		
			parameters_tRESTRequest_1.put("QUERY:genre:id_String", genre);
		
		request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);


		return processRequest(request_tRESTRequest_1);
	}
	@javax.ws.rs.PUT()

	@javax.ws.rs.Path("/movies")	@javax.ws.rs.Consumes({ "application/json" })
	@javax.ws.rs.Produces({ "application/json" })
	public javax.ws.rs.core.Response rent_movie(
		
				@javax.ws.rs.QueryParam("rent") Boolean rent
		, 
				@javax.ws.rs.QueryParam("title") String title
		
		
			) {
                List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();  
                if(requiredParameterWithNullValueList.size() > 0){
                    return handleWrongRequest(messageContext, 400, "400 Bad Request \n" + requiredParameterWithNullValueList.toString() + " in tRESTRequest_1:rent_movie " + (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));         
                }
		java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		request_tRESTRequest_1.put("VERB", "PUT");
		request_tRESTRequest_1.put("OPERATION", "rent_movie");
		request_tRESTRequest_1.put("PATTERN", "/movies");
	

		populateRequestInfo(request_tRESTRequest_1, messageContext);

		java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		
			parameters_tRESTRequest_1.put("QUERY:rent:id_Boolean", rent);
		
			parameters_tRESTRequest_1.put("QUERY:title:id_String", title);
		
		request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);


		return processRequest(request_tRESTRequest_1);
	}
	@javax.ws.rs.GET()

	@javax.ws.rs.Path("/movies")
	@javax.ws.rs.Produces({ "application/json" })
	public javax.ws.rs.core.Response Available_movies(
		
		
			) {
                List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();  
                if(requiredParameterWithNullValueList.size() > 0){
                    return handleWrongRequest(messageContext, 400, "400 Bad Request \n" + requiredParameterWithNullValueList.toString() + " in tRESTRequest_1:Available_movies " + (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));         
                }
		java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		request_tRESTRequest_1.put("VERB", "GET");
		request_tRESTRequest_1.put("OPERATION", "Available_movies");
		request_tRESTRequest_1.put("PATTERN", "/movies");
	

		populateRequestInfo(request_tRESTRequest_1, messageContext);

		java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		
		request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);


		return processRequest(request_tRESTRequest_1);
	}
	public javax.ws.rs.core.Response handleWrongRequest(
			org.apache.cxf.jaxrs.ext.MessageContext context, int status, String error) {

		// System.out.println("wrong call [uri: " + context.getUriInfo().getPath() + " ; method: " + context.getRequest().getMethod() + " ; status: " + status + " ; error: " + error + "]");

		java.util.Map<String, Object> wrongRequest = new java.util.HashMap<String, Object>();

		wrongRequest.put("ERROR", error);
		wrongRequest.put("STATUS", status);
		wrongRequest.put("VERB", context.getRequest().getMethod());
		wrongRequest.put("URI", context.getUriInfo().getPath());
		wrongRequest.put("URI_BASE", context.getUriInfo().getBaseUri().toString());
		wrongRequest.put("URI_ABSOLUTE", context.getUriInfo().getAbsolutePath().toString());
		wrongRequest.put("URI_REQUEST", context.getUriInfo().getRequestUri().toString());

		return processRequest(wrongRequest);
	}

	private void populateRequestInfo(java.util.Map<String, Object> request, org.apache.cxf.jaxrs.ext.MessageContext context) {
		final javax.ws.rs.core.UriInfo ui = context.getUriInfo();

		request.put("URI", ui.getPath());
		request.put("URI_BASE", ui.getBaseUri().toString());
		request.put("URI_ABSOLUTE", ui.getAbsolutePath().toString());
		request.put("URI_REQUEST", ui.getRequestUri().toString());

		request.put("ALL_HEADER_PARAMS", context.getHttpHeaders().getRequestHeaders());
		request.put("ALL_QUERY_PARAMS", ui.getQueryParameters());

		javax.ws.rs.core.SecurityContext securityContext = context.getSecurityContext();
		if (null != securityContext && null != securityContext.getUserPrincipal()) {
			request.put("PRINCIPAL_NAME", securityContext.getUserPrincipal().getName());
		}

		request.put("CorrelationID", context.get("CorrelationID"));

		request.put("MESSAGE_CONTEXT", context);
	}

	private void populateMultipartRequestInfo(java.util.Map<String, Object> request, org.apache.cxf.jaxrs.ext.MessageContext context,
			java.util.Map<String, Boolean> partNames) {
		java.util.Map<String, String> attachmentFilenames = new java.util.HashMap<String, String>();

		java.util.Map<String, java.util.Map<String, java.util.List<String>>> attachmentHeaders =
			new java.util.HashMap<String, java.util.Map<String, java.util.List<String>>>();

		for (java.util.Map.Entry<String,Boolean> p : partNames.entrySet()) {
			String partName = p.getKey();
			Boolean optional = p.getValue();
			org.apache.cxf.jaxrs.ext.multipart.Attachment attachment = getFirstMatchingPart(context, partName, optional);
			if (null != attachment) {
				attachmentHeaders.put(partName, attachment.getHeaders());
				if (null != attachment.getContentDisposition()) {
					String filename = attachment.getContentDisposition().getParameter("filename");
					if (null != filename) {
						attachmentFilenames.put(partName, filename);
					}
				}
			}
		}

		request.put("ATTACHMENT_HEADERS", attachmentHeaders);
		request.put("ATTACHMENT_FILENAMES", attachmentFilenames);
	}

	private static org.apache.cxf.jaxrs.ext.multipart.Attachment getFirstMatchingPart(
			org.apache.cxf.jaxrs.ext.MessageContext context, String partName, Boolean optional) {
		List<org.apache.cxf.jaxrs.ext.multipart.Attachment> attachments =
			org.apache.cxf.jaxrs.utils.multipart.AttachmentUtils.getAttachments(context);
		for (org.apache.cxf.jaxrs.ext.multipart.Attachment attachment : attachments) {
			if (partName.equals(attachment.getContentId())) {
				return attachment;
			}
			org.apache.cxf.jaxrs.ext.multipart.ContentDisposition cd = attachment.getContentDisposition();
			if (null != cd && partName.equals(cd.getParameter("name"))) {
				return attachment;
			}
		}
		if (optional) { 
			return null;
		}
		// unexpected
		throw new javax.ws.rs.InternalServerErrorException();
	}
}

public static class ExceptionMapper4TalendJobRestService extends org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper {

	@javax.ws.rs.core.Context private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

	private RestServiceProviderImpl4TalendJob provider;

	public ExceptionMapper4TalendJobRestService(RestServiceProviderImpl4TalendJob provider) {
		this.provider = provider;
	}

	public javax.ws.rs.core.Response toResponse(javax.ws.rs.WebApplicationException ex) {
		String error = null;
		javax.ws.rs.core.Response response = ex.getResponse();
		if (null != response && null != response.getEntity()) {
			error = response.getEntity().toString();
		}
		response = super.toResponse(ex);
		if (null == error) {
			if (null != response && null != response.getEntity()) {
				error = response.getEntity().toString();
			} else {
				error = null == ex.getCause() ? ex.getMessage() : ex.getCause().getMessage();
			}
		}
		response = provider.handleWrongRequest(messageContext, response.getStatus(), error);

		java.util.List<javax.ws.rs.core.MediaType> accepts = messageContext.getHttpHeaders().getAcceptableMediaTypes();
		javax.ws.rs.core.MediaType responseType = accepts.isEmpty() ? null : accepts.get(0);

		if (responseType == null || !responseType.getSubtype().equals("xml") && !responseType.getSubtype().equals("json")) {
			responseType = javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
		}

		javax.ws.rs.core.Response r = javax.ws.rs.core.Response.status(response.getStatus()).entity(response.getEntity()).type(responseType).build();

		if(response.getHeaders()!=null){
			r.getHeaders().putAll(response.getHeaders());
		}

		return r;
	}
}

protected String checkEndpointUrl(String url) {
	final String defaultEndpointUrl = "http://127.0.0.1:8090/";

	String endpointUrl = url;
	if (null == endpointUrl || endpointUrl.trim().isEmpty()) {
		endpointUrl = defaultEndpointUrl;
	} else if (!endpointUrl.contains("://")) { // relative
		if (endpointUrl.startsWith("/")) {
			endpointUrl = endpointUrl.substring(1);
		}
		endpointUrl = defaultEndpointUrl + endpointUrl;
	}

	// test for busy
	java.net.URI endpointURI = java.net.URI.create(endpointUrl);
	String host = endpointURI.getHost();
	try {
		if (java.net.InetAddress.getByName(host).isLoopbackAddress()) {
			int port = endpointURI.getPort();
			java.net.ServerSocket ss = null;
			try {
				ss = new java.net.ServerSocket(port);
			} catch (IOException e) {
				// rethrow exception
				throw new IllegalArgumentException("Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
			} finally {
				if (ss != null) {
					try {
						ss.close();
					} catch (IOException e) {
						// ignore
					}
				}
			}
			try {
				// ok, let's doublecheck for silent listeners
				java.net.Socket cs = new java.net.Socket(host, port);
				// if succeed - somebody silently listening, fail!
				cs.close();
				// rethrow exception
				throw new IllegalArgumentException("Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
			} catch (IOException e) {
				// ok, nobody listens, proceed
			}
		}
	} catch (java.net.UnknownHostException e) {
		// ignore
	}

	return endpointUrl;
}


public static class StreamingDOM4JProvider extends org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider {

	public static final String SUPRESS_XML_DECLARATION = "supress.xml.declaration";

	private java.util.Map<String, Object> globalMap = null;

	public void setGlobalMap(java.util.Map<String, Object> globalMap) {
		this.globalMap = globalMap;
	}

	public void writeTo(org.dom4j.Document doc, Class<?> cls, java.lang.reflect.Type type,
			java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt,
			javax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)
					throws java.io.IOException, javax.ws.rs.WebApplicationException {
		if (mt.getSubtype().contains("xml")) {
			org.dom4j.io.XMLWriter writer;
			org.apache.cxf.message.Message currentMessage = null;
			if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
				currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
			} else {
				currentMessage = (org.apache.cxf.message.Message)((java.util.Map<String, Object>)globalMap.get("restRequest")).get("CURRENT_MESSAGE");
			}

			if (currentMessage != null && currentMessage.getExchange() != null && currentMessage.getExchange().containsKey(SUPRESS_XML_DECLARATION)) {
				org.dom4j.io.OutputFormat format = new org.dom4j.io.OutputFormat();
				format.setSuppressDeclaration(true);
				writer = new org.dom4j.io.XMLWriter(os, format);
			} else {
				writer = new org.dom4j.io.XMLWriter(os);
			}
			writer.write(doc);
			writer.flush();
		} else {
			super.writeTo(doc, cls, type, anns, mt, headers, os);
		}
	}
}

Thread4RestServiceProviderEndpoint thread4RestServiceProviderEndpoint = null;

class Thread4RestServiceProviderEndpoint extends Thread {

	private final String endpointUrl;

	private final movie_rental job;

	private org.apache.cxf.endpoint.Server server;

	private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

	public Thread4RestServiceProviderEndpoint(movie_rental job, String endpointUrl) {
		this.job = job;
		this.endpointUrl = endpointUrl;
		this.sf = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();
	}

	boolean inOSGi = routines.system.BundleUtils.inOSGi();

	public org.apache.cxf.endpoint.Server getServer(){
		return server;
	}

	public org.apache.cxf.jaxrs.JAXRSServerFactoryBean getJAXRSServerFactoryBean(){
		return sf;
	}

	public void run() {

		try {
			RestServiceProviderImpl4TalendJob provider = new RestServiceProviderImpl4TalendJob(job);

			if(sf.getProperties() == null){
				sf.setProperties(new java.util.HashMap<String, Object>());
			}

			java.util.List<Object> providers = (java.util.List<Object>)sf.getProviders();
			providers.add(new ExceptionMapper4TalendJobRestService(provider));
			providers.add(new StreamingDOM4JProvider());
			
			org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider =
					new org.apache.cxf.jaxrs.provider.json.JSONProvider();
			jsonProvider.setIgnoreNamespaces(true);
			
				jsonProvider.setAttributesToElements(true);
			
			

			
				jsonProvider.setConvertTypesToStrings(false);
			
			providers.add(jsonProvider);
			sf.setProviders(providers);
			sf.setTransportId("http://cxf.apache.org/transports/http");
			sf.setResourceClasses(RestServiceProviderImpl4TalendJob.class);
			sf.setResourceProvider(RestServiceProviderImpl4TalendJob.class,
					new org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider(provider));
			sf.setAddress(endpointUrl);

			final java.util.List<org.apache.cxf.feature.Feature> features = sf.getFeatures() == null?
					new java.util.ArrayList<org.apache.cxf.feature.Feature>() : sf.getFeatures();

			

			

			

			

			sf.setFeatures(features);

			server = sf.create();

			// System.out.println("REST service [endpoint: " + endpointUrl + "] published");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void stopEndpoint() {
		if (null != server) {
			server.stop();
			server.destroy();
			// System.out.println("REST service [endpoint: " + endpointUrl + "] unpublished");
		}
	}
}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression, String jobName)
				throws IOException, javax.script.ScriptException {
			String currentContext = context;
			String jobNameStripped = jobName.substring(jobName.lastIndexOf(".") + 1);

			boolean inOSGi = routines.system.BundleUtils.inOSGi();
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobNameStripped);

				if (jobProperties != null && null != jobProperties.get("context")) {
					currentContext = (String) jobProperties.get("context");
				}
			}
						
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = movie_rental.class.getClassLoader()
					.getResourceAsStream("tmc_demo2/movie_rental_0_1/contexts/" + currentContext  + ".properties");
			if (inContext == null) {
				inContext = movie_rental.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + currentContext  + ".properties");
			}
			try {
			    defaultProps.load(inContext);
				if(jobProperties != null){
					java.util.Enumeration<String> keys = jobProperties.keys();
					while (keys.hasMoreElements()) {
						String propKey = keys.nextElement();
						if (defaultProps.containsKey(propKey)) {
							defaultProps.put(propKey, (String) jobProperties.get(propKey));
						}
					}
				}
			} finally {
			    inContext.close();
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("context.([\\w]+)");
			java.util.regex.Matcher matcher = pattern.matcher(contextExpression);

			while (matcher.find()) {
				contextExpression = contextExpression.replaceAll(matcher.group(0),
						prefix + defaultProps.getProperty(matcher.group(1)) + prefix);
			}
			if (contextExpression.startsWith("/services")) {
				contextExpression = contextExpression.replaceFirst("/services","");
            }
			return isExpression ? evaluateContextExpression(contextExpression) : contextExpression;
		}

		public static String evaluateContextExpression(String expression) throws RuntimeException {
			delight.rhinosandox.RhinoSandbox sandbox = delight.rhinosandox.RhinoSandboxes.create();

			// Add some import for Java
			expression = expression.replaceAll("System.getProperty", "java.lang.System.getProperty");
			return sandbox.eval(null, expression).toString();
		}

        public static String getContext(String context, String contextName, String jobName) throws Exception {
			return contextName.contains("context.") ? evaluate(context, contextName, jobName) : contextName;
        }
    }







public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "query";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public String genre;

				public String getGenre () {
					return this.genre;
				}

				public Boolean genreIsNullable(){
				    return true;
				}
				public Boolean genreIsKey(){
				    return false;
				}
				public Integer genreLength(){
				    return null;
				}
				public Integer genrePrecision(){
				    return null;
				}
				public String genreDefault(){
				
					return null;
				
				}
				public String genreComment(){
				
				    return "";
				
				}
				public String genrePattern(){
				
					return "";
				
				}
				public String genreOriginalDbColumnName(){
				
					return "genre";
				
				}

				
			    public String year;

				public String getYear () {
					return this.year;
				}

				public Boolean yearIsNullable(){
				    return true;
				}
				public Boolean yearIsKey(){
				    return false;
				}
				public Integer yearLength(){
				    return null;
				}
				public Integer yearPrecision(){
				    return null;
				}
				public String yearDefault(){
				
					return null;
				
				}
				public String yearComment(){
				
				    return "";
				
				}
				public String yearPattern(){
				
					return "";
				
				}
				public String yearOriginalDbColumnName(){
				
					return "year";
				
				}

				
			    public Boolean available;

				public Boolean getAvailable () {
					return this.available;
				}

				public Boolean availableIsNullable(){
				    return true;
				}
				public Boolean availableIsKey(){
				    return false;
				}
				public Integer availableLength(){
				    return null;
				}
				public Integer availablePrecision(){
				    return null;
				}
				public String availableDefault(){
				
					return null;
				
				}
				public String availableComment(){
				
				    return "";
				
				}
				public String availablePattern(){
				
					return "";
				
				}
				public String availableOriginalDbColumnName(){
				
					return "available";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",genre="+genre);
		sb.append(",year="+year);
		sb.append(",available="+String.valueOf(available));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(genre == null){
        					sb.append("<null>");
        				}else{
            				sb.append(genre);
            			}
            		
        			sb.append("|");
        		
        				if(year == null){
        					sb.append("<null>");
        				}else{
            				sb.append(year);
            			}
            		
        			sb.append("|");
        		
        				if(available == null){
        					sb.append("<null>");
        				}else{
            				sb.append(available);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

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

public static class addStruct implements routines.system.IPersistableRow<addStruct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "query";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public String genre;

				public String getGenre () {
					return this.genre;
				}

				public Boolean genreIsNullable(){
				    return true;
				}
				public Boolean genreIsKey(){
				    return false;
				}
				public Integer genreLength(){
				    return null;
				}
				public Integer genrePrecision(){
				    return null;
				}
				public String genreDefault(){
				
					return null;
				
				}
				public String genreComment(){
				
				    return "";
				
				}
				public String genrePattern(){
				
					return "";
				
				}
				public String genreOriginalDbColumnName(){
				
					return "genre";
				
				}

				
			    public String year;

				public String getYear () {
					return this.year;
				}

				public Boolean yearIsNullable(){
				    return true;
				}
				public Boolean yearIsKey(){
				    return false;
				}
				public Integer yearLength(){
				    return null;
				}
				public Integer yearPrecision(){
				    return null;
				}
				public String yearDefault(){
				
					return null;
				
				}
				public String yearComment(){
				
				    return "";
				
				}
				public String yearPattern(){
				
					return "";
				
				}
				public String yearOriginalDbColumnName(){
				
					return "year";
				
				}

				
			    public Boolean available;

				public Boolean getAvailable () {
					return this.available;
				}

				public Boolean availableIsNullable(){
				    return true;
				}
				public Boolean availableIsKey(){
				    return false;
				}
				public Integer availableLength(){
				    return null;
				}
				public Integer availablePrecision(){
				    return null;
				}
				public String availableDefault(){
				
					return null;
				
				}
				public String availableComment(){
				
				    return "";
				
				}
				public String availablePattern(){
				
					return "";
				
				}
				public String availableOriginalDbColumnName(){
				
					return "available";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",genre="+genre);
		sb.append(",year="+year);
		sb.append(",available="+String.valueOf(available));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(genre == null){
        					sb.append("<null>");
        				}else{
            				sb.append(genre);
            			}
            		
        			sb.append("|");
        		
        				if(year == null){
        					sb.append("<null>");
        				}else{
            				sb.append(year);
            			}
            		
        			sb.append("|");
        		
        				if(available == null){
        					sb.append("<null>");
        				}else{
            				sb.append(available);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(addStruct other) {

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

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return true;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "query";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public Boolean available;

				public Boolean getAvailable () {
					return this.available;
				}

				public Boolean availableIsNullable(){
				    return true;
				}
				public Boolean availableIsKey(){
				    return false;
				}
				public Integer availableLength(){
				    return null;
				}
				public Integer availablePrecision(){
				    return null;
				}
				public String availableDefault(){
				
					return null;
				
				}
				public String availableComment(){
				
				    return "";
				
				}
				public String availablePattern(){
				
					return "";
				
				}
				public String availableOriginalDbColumnName(){
				
					return "available";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.title == null) {
							if (other.title != null)
								return false;
						
						} else if (!this.title.equals(other.title))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.title = this.title;
	            other.available = this.available;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.title = this.title;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",available="+String.valueOf(available));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(available == null){
        					sb.append("<null>");
        				}else{
            				sb.append(available);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.title, other.title);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class rentStruct implements routines.system.IPersistableRow<rentStruct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return true;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "query";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public Boolean available;

				public Boolean getAvailable () {
					return this.available;
				}

				public Boolean availableIsNullable(){
				    return true;
				}
				public Boolean availableIsKey(){
				    return false;
				}
				public Integer availableLength(){
				    return null;
				}
				public Integer availablePrecision(){
				    return null;
				}
				public String availableDefault(){
				
					return null;
				
				}
				public String availableComment(){
				
				    return "";
				
				}
				public String availablePattern(){
				
					return "";
				
				}
				public String availableOriginalDbColumnName(){
				
					return "available";
				
				}

				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final rentStruct other = (rentStruct) obj;
		
						if (this.title == null) {
							if (other.title != null)
								return false;
						
						} else if (!this.title.equals(other.title))
						
							return false;
					

		return true;
    }

	public void copyDataTo(rentStruct other) {

		other.title = this.title;
	            other.available = this.available;
	            
	}

	public void copyKeysDataTo(rentStruct other) {

		other.title = this.title;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.available = null;
           				} else {
           			    	this.available = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// Boolean
				
						if(this.available == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.available);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",available="+String.valueOf(available));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(available == null){
        					sb.append("<null>");
        				}else{
            				sb.append(available);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(rentStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.title, other.title);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class outStruct implements routines.system.IPersistableRow<outStruct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	
			    public routines.system.Document body;

				public routines.system.Document getBody () {
					return this.body;
				}

				public Boolean bodyIsNullable(){
				    return true;
				}
				public Boolean bodyIsKey(){
				    return false;
				}
				public Integer bodyLength(){
				    return 0;
				}
				public Integer bodyPrecision(){
				    return 0;
				}
				public String bodyDefault(){
				
					return null;
				
				}
				public String bodyComment(){
				
				    return null;
				
				}
				public String bodyPattern(){
				
				    return null;
				
				}
				public String bodyOriginalDbColumnName(){
				
					return "body";
				
				}

				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Document
				
       			    	dos.writeObject(this.body);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Document
				
						dos.clearInstanceCache();
						dos.writeObject(this.body);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("body="+String.valueOf(body));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(body == null){
        					sb.append("<null>");
        				}else{
            				sb.append(body);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(outStruct other) {

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
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public String genre;

				public String getGenre () {
					return this.genre;
				}

				public Boolean genreIsNullable(){
				    return true;
				}
				public Boolean genreIsKey(){
				    return false;
				}
				public Integer genreLength(){
				    return null;
				}
				public Integer genrePrecision(){
				    return null;
				}
				public String genreDefault(){
				
					return null;
				
				}
				public String genreComment(){
				
				    return "";
				
				}
				public String genrePattern(){
				
					return "";
				
				}
				public String genreOriginalDbColumnName(){
				
					return "genre";
				
				}

				
			    public String year;

				public String getYear () {
					return this.year;
				}

				public Boolean yearIsNullable(){
				    return true;
				}
				public Boolean yearIsKey(){
				    return false;
				}
				public Integer yearLength(){
				    return null;
				}
				public Integer yearPrecision(){
				    return null;
				}
				public String yearDefault(){
				
					return null;
				
				}
				public String yearComment(){
				
				    return "";
				
				}
				public String yearPattern(){
				
					return "";
				
				}
				public String yearOriginalDbColumnName(){
				
					return "year";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",genre="+genre);
		sb.append(",year="+year);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(genre == null){
        					sb.append("<null>");
        				}else{
            				sb.append(genre);
            			}
            		
        			sb.append("|");
        		
        				if(year == null){
        					sb.append("<null>");
        				}else{
            				sb.append(year);
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

public static class Available_moviesStruct implements routines.system.IPersistableRow<Available_moviesStruct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
        }

			finally {}
		

    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
        }

			finally {}
		

    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(Available_moviesStruct other) {

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

public static class rent_movieStruct implements routines.system.IPersistableRow<rent_movieStruct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "query";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public Boolean rent;

				public Boolean getRent () {
					return this.rent;
				}

				public Boolean rentIsNullable(){
				    return true;
				}
				public Boolean rentIsKey(){
				    return false;
				}
				public Integer rentLength(){
				    return null;
				}
				public Integer rentPrecision(){
				    return null;
				}
				public String rentDefault(){
				
					return null;
				
				}
				public String rentComment(){
				
				    return "query";
				
				}
				public String rentPattern(){
				
					return "";
				
				}
				public String rentOriginalDbColumnName(){
				
					return "rent";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.rent = null;
           				} else {
           			    	this.rent = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.rent = null;
           				} else {
           			    	this.rent = dis.readBoolean();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// Boolean
				
						if(this.rent == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.rent);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// Boolean
				
						if(this.rent == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.rent);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",rent="+String.valueOf(rent));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(rent == null){
        					sb.append("<null>");
        				}else{
            				sb.append(rent);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(rent_movieStruct other) {

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

public static class Add_movieStruct implements routines.system.IPersistableRow<Add_movieStruct> {
    final static byte[] commonByteArrayLock_TMC_DEMO2_movie_rental = new byte[0];
    static byte[] commonByteArray_TMC_DEMO2_movie_rental = new byte[0];

	
			    public String title;

				public String getTitle () {
					return this.title;
				}

				public Boolean titleIsNullable(){
				    return true;
				}
				public Boolean titleIsKey(){
				    return false;
				}
				public Integer titleLength(){
				    return null;
				}
				public Integer titlePrecision(){
				    return null;
				}
				public String titleDefault(){
				
					return null;
				
				}
				public String titleComment(){
				
				    return "query";
				
				}
				public String titlePattern(){
				
					return "";
				
				}
				public String titleOriginalDbColumnName(){
				
					return "title";
				
				}

				
			    public String genre;

				public String getGenre () {
					return this.genre;
				}

				public Boolean genreIsNullable(){
				    return true;
				}
				public Boolean genreIsKey(){
				    return false;
				}
				public Integer genreLength(){
				    return null;
				}
				public Integer genrePrecision(){
				    return null;
				}
				public String genreDefault(){
				
					return null;
				
				}
				public String genreComment(){
				
				    return "query";
				
				}
				public String genrePattern(){
				
					return "";
				
				}
				public String genreOriginalDbColumnName(){
				
					return "genre";
				
				}

				
			    public String year;

				public String getYear () {
					return this.year;
				}

				public Boolean yearIsNullable(){
				    return true;
				}
				public Boolean yearIsKey(){
				    return false;
				}
				public Integer yearLength(){
				    return null;
				}
				public Integer yearPrecision(){
				    return null;
				}
				public String yearDefault(){
				
					return null;
				
				}
				public String yearComment(){
				
				    return "query";
				
				}
				public String yearPattern(){
				
					return "";
				
				}
				public String yearOriginalDbColumnName(){
				
					return "year";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_TMC_DEMO2_movie_rental.length) {
				if(length < 1024 && commonByteArray_TMC_DEMO2_movie_rental.length == 0) {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[1024];
				} else {
   					commonByteArray_TMC_DEMO2_movie_rental = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_TMC_DEMO2_movie_rental, 0, length);
			strReturn = new String(commonByteArray_TMC_DEMO2_movie_rental, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_TMC_DEMO2_movie_rental) {

        	try {

        		int length = 0;
		
					this.title = readString(dis);
					
					this.genre = readString(dis);
					
					this.year = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.title,dos);
					
					// String
				
						writeString(this.genre,dos);
					
					// String
				
						writeString(this.year,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("title="+title);
		sb.append(",genre="+genre);
		sb.append(",year="+year);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(title == null){
        					sb.append("<null>");
        				}else{
            				sb.append(title);
            			}
            		
        			sb.append("|");
        		
        				if(genre == null){
        					sb.append("<null>");
        				}else{
            				sb.append(genre);
            			}
            		
        			sb.append("|");
        		
        				if(year == null){
        					sb.append("<null>");
        				}else{
            				sb.append(year);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(Add_movieStruct other) {

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

public void tRESTRequest_1_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "tRESTRequest_1_Loop");
		org.slf4j.MDC.put("_subJobPid", "Gv4j3b_" + subJobPidCounter.getAndIncrement());
	

		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		Available_moviesStruct Available_movies = new Available_moviesStruct();
row1Struct row1 = new row1Struct();
outStruct out = new outStruct();
rent_movieStruct rent_movie = new rent_movieStruct();
rentStruct rent = new rentStruct();
row2Struct row2 = new row2Struct();
Add_movieStruct Add_movie = new Add_movieStruct();
addStruct add = new addStruct();
row3Struct row3 = new row3Struct();



	
	/**
	 * [tRESTRequest_1_Loop begin ] start
	 */

				
			int NB_ITERATE_tRESTRequest_1_In = 0; //for statistics
			

	
		
		ok_Hash.put("tRESTRequest_1_Loop", false);
		start_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_Loop";
	
	
		int tos_count_tRESTRequest_1_Loop = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTRequest_1_Loop", "Movies_Loop", "tRESTRequestLoop");
				talendJobLogProcess(globalMap);
			}
			
						
						
						if(enableLogStash){
							runStat.log(iterateId,0,0,"Available_movies","rent_movie","rent","row2","Add_movie","add","row3");
						}
						


					Add_movie = null;
			
					rent_movie = null;
			
					Available_movies = null;
			

	int nb_line_tRESTRequest_1 = 0;

	try {

		java.util.Map<String, Object> requestMessage_tRESTRequest_1 =
				(java.util.Map<String, Object>) globalMap.get("restRequest");

		restEndpoint = getRestEndpoint();

		if (null == requestMessage_tRESTRequest_1) {

			if (restTalendJobAlreadyStarted) {
				throw new RuntimeException("request is not provided");
			} else {
				if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
					String endpointUrl_tRESTRequest_1 = checkEndpointUrl(restEndpoint);
					// *** external thread for endpoint initialization
					thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this, endpointUrl_tRESTRequest_1);
					thread4RestServiceProviderEndpoint.start();
					// *** external thread for endpoint initialization
				}

				restTalendJobAlreadyStarted = true;

				if(runInDaemonMode){
					Thread.currentThread();
					try {
						while(true) {
							Thread.sleep(60000);
						}
					} catch (InterruptedException e_tRESTRequest_1) {
						// e_tRESTRequest_1.printStackTrace();
						// throw new TalendException(e_tRESTRequest_1, "wholeJob", globalMap);
					}
				}
			}
			return;
		}

        requestMessage_tRESTRequest_1.put("CURRENT_MESSAGE", org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

        Object ctx_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("MESSAGE_CONTEXT");
        if (ctx_tRESTRequest_1 != null && ctx_tRESTRequest_1 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
            requestMessage_tRESTRequest_1.put("MESSAGE_CONTEXT", ((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext)ctx_tRESTRequest_1).get());
        }

 



/**
 * [tRESTRequest_1_Loop begin ] stop
 */
	
	/**
	 * [tRESTRequest_1_Loop main ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_Loop";
	
	
				resourceMap.put("inIterateVComp", true);
			

 


	tos_count_tRESTRequest_1_Loop++;

/**
 * [tRESTRequest_1_Loop main ] stop
 */
	
	/**
	 * [tRESTRequest_1_Loop process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_Loop";
	
	

 



/**
 * [tRESTRequest_1_Loop process_data_begin ] stop
 */
	NB_ITERATE_tRESTRequest_1_In++;
	
	


	
	/**
	 * [tFlowToIterate_1 begin ] start
	 */

				
			int NB_ITERATE_tDBInput_1 = 0; //for statistics
			

	
		
		ok_Hash.put("tFlowToIterate_1", false);
		start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());
		
	
	currentComponent="tFlowToIterate_1";
	
	
			cLabel="iterate";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"Available_movies");
					}
				
		int tos_count_tFlowToIterate_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFlowToIterate_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
                    log4jParamters_tFlowToIterate_1.append("Parameters:");
                            log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "true");
                        log4jParamters_tFlowToIterate_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + (log4jParamters_tFlowToIterate_1) );
                    } 
                } 
            new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tFlowToIterate_1", "iterate", "tFlowToIterate");
				talendJobLogProcess(globalMap);
			}
			

int nb_line_tFlowToIterate_1 = 0;
int counter_tFlowToIterate_1 = 0;

 



/**
 * [tFlowToIterate_1 begin ] stop
 */






	
	/**
	 * [tRESTResponse_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRESTResponse_2", false);
		start_Hash.put("tRESTResponse_2", System.currentTimeMillis());
		
	
	currentComponent="tRESTResponse_2";
	
	
			cLabel="rent_or_giveback";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tRESTResponse_2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTResponse_2", "rent_or_giveback", "tRESTResponse");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tRESTResponse_2 begin ] stop
 */



	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="movielist";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"rent");
					}
				
		int tos_count_tDBOutput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
                    log4jParamters_tDBOutput_1.append("Parameters:");
                            log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "MYSQL_5");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("HOST" + " = " + "\"localhost\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PORT" + " = " + "\"3306\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "\"movies\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USER" + " = " + "\"root\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:dzGWSegEmy4BQS0BUmE6gSr1p1IXP4klDlOIjTpDIFs=").substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"movielist\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "NONE");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "UPDATE");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true\"");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
                        log4jParamters_tDBOutput_1.append(" | ");
                            log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tDBOutput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + (log4jParamters_tDBOutput_1) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_1", "movielist", "tMysqlOutput");
				talendJobLogProcess(globalMap);
			}
			






        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 2 && true) {        
                throw new RuntimeException("For update, every Schema column can not be a key");
        }

int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

String tableName_tDBOutput_1 = "movielist";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
		
			
        String properties_tDBOutput_1 = "noDatetimeStringSync=true";
        if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
            properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "movies" + "?" + properties_tDBOutput_1;

			String driverClass_tDBOutput_1 = "com.mysql.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Driver ClassName: ")  + (driverClass_tDBOutput_1)  + (".") );
			String dbUser_tDBOutput_1 = "root";
			

			 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:hPoMmDjQIhHD8NOcMflNmbnQrjfE67yPIpvPnPhEXn0=");

			String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
			java.lang.Class.forName(driverClass_tDBOutput_1);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection attempts to '")  + (url_tDBOutput_1)  + ("' with the username '")  + (dbUser_tDBOutput_1)  + ("'.") );
			conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to '")  + (url_tDBOutput_1)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
			conn_tDBOutput_1.setAutoCommit(false);
			int commitEvery_tDBOutput_1 = 10000;
			int commitCounter_tDBOutput_1 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_1.getAutoCommit())  + ("'.") );
		int batchSize_tDBOutput_1 = 10000;
		int batchSizeCounter_tDBOutput_1=0;
	

		int count_tDBOutput_1=0;
		
				
			
				String update_tDBOutput_1 = "UPDATE `" + "movielist" + "` SET `available` = ? WHERE `title` = ?";
				
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
				


 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";
	
	
			cLabel="select_movie";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"rent_movie");
					}
				
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_1 = new StringBuilder();
                    log4jParamters_tMap_1.append("Parameters:");
                            log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_1.append(" | ");
                            log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "select_movie", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_rent_movie_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_rent_tMap_1 = 0;
				
rentStruct rent_tmp = new rentStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */






	
	/**
	 * [tRESTResponse_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRESTResponse_3", false);
		start_Hash.put("tRESTResponse_3", System.currentTimeMillis());
		
	
	currentComponent="tRESTResponse_3";
	
	
			cLabel="movie_added";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tRESTResponse_3 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTResponse_3", "movie_added", "tRESTResponse");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tRESTResponse_3 begin ] stop
 */



	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="movielist";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"add");
					}
				
		int tos_count_tDBOutput_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBOutput_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBOutput_2 = new StringBuilder();
                    log4jParamters_tDBOutput_2.append("Parameters:");
                            log4jParamters_tDBOutput_2.append("DB_VERSION" + " = " + "MYSQL_5");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("HOST" + " = " + "\"localhost\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("PORT" + " = " + "\"3306\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DBNAME" + " = " + "\"movies\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USER" + " = " + "\"root\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:02wLcDSTR/ihGaMnUbXVmnBwkvA+xlzueyhIhFjKSXs=").substring(0, 4) + "...");     
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("TABLE" + " = " + "\"movielist\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("TABLE_ACTION" + " = " + "NONE");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DATA_ACTION" + " = " + "INSERT");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("DIE_ON_ERROR" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true\"");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("EXTENDINSERT" + " = " + "true");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("NB_ROWS_PER_INSERT" + " = " + "100");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("COMMIT_EVERY" + " = " + "10000");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ADD_COLS" + " = " + "[]");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_FIELD_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("USE_HINT_OPTIONS" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ENABLE_DEBUG_MODE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("ON_DUPLICATE_KEY_UPDATE" + " = " + "false");
                        log4jParamters_tDBOutput_2.append(" | ");
                            log4jParamters_tDBOutput_2.append("UNIFIED_COMPONENTS" + " = " + "tMysqlOutput");
                        log4jParamters_tDBOutput_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + (log4jParamters_tDBOutput_2) );
                    } 
                } 
            new BytesLimit65535_tDBOutput_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBOutput_2", "movielist", "tMysqlOutput");
				talendJobLogProcess(globalMap);
			}
			







int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

String tableName_tDBOutput_2 = "movielist";
boolean whetherReject_tDBOutput_2 = false;

java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
long date_tDBOutput_2;

java.sql.Connection conn_tDBOutput_2 = null;
		
			
        String properties_tDBOutput_2 = "noDatetimeStringSync=true";
        if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
            properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_2 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "movies" + "?" + properties_tDBOutput_2;

			String driverClass_tDBOutput_2 = "com.mysql.jdbc.Driver";
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Driver ClassName: ")  + (driverClass_tDBOutput_2)  + (".") );
			String dbUser_tDBOutput_2 = "root";
			

			 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:/zFmztc/abVuc2sBvTaXNOylyZMGVY80TvNKvqzlYZw=");

			String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
			java.lang.Class.forName(driverClass_tDBOutput_2);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection attempts to '")  + (url_tDBOutput_2)  + ("' with the username '")  + (dbUser_tDBOutput_2)  + ("'.") );
			conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2, dbPwd_tDBOutput_2);
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection to '")  + (url_tDBOutput_2)  + ("' has succeeded.") );
			
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
	
			conn_tDBOutput_2.setAutoCommit(false);
			int commitEvery_tDBOutput_2 = 10000;
			int commitCounter_tDBOutput_2 = 0;
			
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection is set auto commit to '")  + (conn_tDBOutput_2.getAutoCommit())  + ("'.") );

		int count_tDBOutput_2=0;
		
				
			

		
						String insert_tDBOutput_2 = "INSERT INTO `" + "movielist" + "` (`title`,`genre`,`year`,`available`) VALUES (?,?,?,?)";
		
						int batchSize_tDBOutput_2 = 100;
						int batchSizeCounter_tDBOutput_2=0;
						    
						java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(insert_tDBOutput_2);
						resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

		


 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";
	
	
			cLabel="movie_details";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"Add_movie");
					}
				
		int tos_count_tMap_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tMap_2 = new StringBuilder();
                    log4jParamters_tMap_2.append("Parameters:");
                            log4jParamters_tMap_2.append("LINK_STYLE" + " = " + "AUTO");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
                        log4jParamters_tMap_2.append(" | ");
                            log4jParamters_tMap_2.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
                        log4jParamters_tMap_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + (log4jParamters_tMap_2) );
                    } 
                } 
            new BytesLimit65535_tMap_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_2", "movie_details", "tMap");
				talendJobLogProcess(globalMap);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_Add_movie_tMap_2 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_add_tMap_2 = 0;
				
addStruct add_tmp = new addStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tRESTRequest_1_In begin ] start
	 */

	

	
		
		ok_Hash.put("tRESTRequest_1_In", false);
		start_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_In";
	
	
		int tos_count_tRESTRequest_1_In = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTRequest_1_In", "Movies_In", "tRESTRequestIn");
				talendJobLogProcess(globalMap);
			}
			
						resourceMap.remove("inIterateVComp");
					

 



/**
 * [tRESTRequest_1_In begin ] stop
 */
	
	/**
	 * [tRESTRequest_1_In main ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_In";
	
	

		if (requestMessage_tRESTRequest_1.containsKey("ERROR")) { // wrong request received
						Add_movie = null;
						rent_movie = null;
						Available_movies = null;
		} else { // non-error (not wrong request)

			String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
			String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

			java.util.Map<String, Object> params_tRESTRequest_1 =
				(java.util.Map<String, Object>) requestMessage_tRESTRequest_1.get("PARAMS");
					if (matchedFlow_tRESTRequest_1.equals("Add_movie")) {
						Add_movie = new Add_movieStruct();
								if (params_tRESTRequest_1.containsKey("QUERY:title:id_String")) {
									
										
										Add_movie.title = (String) params_tRESTRequest_1.get("QUERY:title:id_String");
									
								}
								if (params_tRESTRequest_1.containsKey("QUERY:genre:id_String")) {
									
										
										Add_movie.genre = (String) params_tRESTRequest_1.get("QUERY:genre:id_String");
									
								}
								if (params_tRESTRequest_1.containsKey("QUERY:year:id_String")) {
									
										
										Add_movie.year = (String) params_tRESTRequest_1.get("QUERY:year:id_String");
									
								}
					} else { // non matched flow
						Add_movie = null;
					}
				
					if (matchedFlow_tRESTRequest_1.equals("rent_movie")) {
						rent_movie = new rent_movieStruct();
								if (params_tRESTRequest_1.containsKey("QUERY:title:id_String")) {
									
										
										rent_movie.title = (String) params_tRESTRequest_1.get("QUERY:title:id_String");
									
								}
								if (params_tRESTRequest_1.containsKey("QUERY:rent:id_Boolean")) {
									
										
										rent_movie.rent = (Boolean) params_tRESTRequest_1.get("QUERY:rent:id_Boolean");
									
								}
					} else { // non matched flow
						rent_movie = null;
					}
				
					if (matchedFlow_tRESTRequest_1.equals("Available_movies")) {
						Available_movies = new Available_moviesStruct();
					} else { // non matched flow
						Available_movies = null;
					}
				
		}

		globalMap.put("tRESTRequest_1_URI", (String) requestMessage_tRESTRequest_1.get("URI"));
		globalMap.put("tRESTRequest_1_URI_BASE", (String) requestMessage_tRESTRequest_1.get("URI_BASE"));
		globalMap.put("tRESTRequest_1_URI_ABSOLUTE", (String) requestMessage_tRESTRequest_1.get("URI_ABSOLUTE"));
		globalMap.put("tRESTRequest_1_URI_REQUEST", (String) requestMessage_tRESTRequest_1.get("URI_REQUEST"));
		globalMap.put("tRESTRequest_1_HTTP_METHOD", (String) requestMessage_tRESTRequest_1.get("VERB"));

		globalMap.put("tRESTRequest_1_ATTACHMENT_HEADERS", requestMessage_tRESTRequest_1.get("ATTACHMENT_HEADERS"));
		globalMap.put("tRESTRequest_1_ATTACHMENT_FILENAMES", requestMessage_tRESTRequest_1.get("ATTACHMENT_FILENAMES"));

		globalMap.put("tRESTRequest_1_PRINCIPAL_NAME", (String) requestMessage_tRESTRequest_1.get("PRINCIPAL_NAME"));
		globalMap.put("tRESTRequest_1_CORRELATION_ID", (String) requestMessage_tRESTRequest_1.get("CorrelationID"));

 


	tos_count_tRESTRequest_1_In++;

/**
 * [tRESTRequest_1_In main ] stop
 */
	
	/**
	 * [tRESTRequest_1_In process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_In";
	
	

 



/**
 * [tRESTRequest_1_In process_data_begin ] stop
 */
// Start of branch "Available_movies"
if(Available_movies != null) { 



	
	/**
	 * [tFlowToIterate_1 main ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";
	
	
			cLabel="iterate";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"Available_movies","tRESTRequest_1_In","Movies_In","tRESTRequestIn","tFlowToIterate_1","iterate","tFlowToIterate"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("Available_movies - " + (Available_movies==null? "": Available_movies.toLogString()));
    			}
    		


    	
 
	   nb_line_tFlowToIterate_1++;  
       counter_tFlowToIterate_1++;
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Current iteration is: ")  + (counter_tFlowToIterate_1)  + (".") );
       globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);
 


	tos_count_tFlowToIterate_1++;

/**
 * [tFlowToIterate_1 main ] stop
 */
	
	/**
	 * [tFlowToIterate_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";
	
	
			cLabel="iterate";
		

 



/**
 * [tFlowToIterate_1 process_data_begin ] stop
 */
	NB_ITERATE_tDBInput_1++;
	
	


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT begin ] start
	 */

	

	
		
		ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", false);
		start_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_OUT";
	
	
			cLabel="map_movie_list_TXMLMAP_OUT";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tXMLMap_1_TXMLMAP_OUT = 0;
		
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_OUT - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tXMLMap_1_TXMLMAP_OUT{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_OUT = new StringBuilder();
                    log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("Parameters:");
                            log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
                        log4jParamters_tXMLMap_1_TXMLMAP_OUT.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_OUT - "  + (log4jParamters_tXMLMap_1_TXMLMAP_OUT) );
                    } 
                } 
            new BytesLimit65535_tXMLMap_1_TXMLMAP_OUT().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tXMLMap_1_TXMLMAP_OUT", "map_movie_list_TXMLMAP_OUT", "tXMLMapOut");
				talendJobLogProcess(globalMap);
			}
			

	
	
//===============================input xml init part===============================
class XML_API_tXMLMap_1_TXMLMAP_OUT{
	public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        if (node != null && node instanceof org.dom4j.Element) {
        	org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute("nil");
        	if(attri != null && ("true").equals(attri.getText())){
            	return true;
            }
        }
        return false;
    }

    public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        return node == null ? true : false;
    }

    public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        if (node != null) {
            return node.getText().length() == 0;
        }
        return false;
    }
}
	class Var__tXMLMap_1_TXMLMAP_OUT__Struct {
	}
	Var__tXMLMap_1_TXMLMAP_OUT__Struct Var__tXMLMap_1_TXMLMAP_OUT = new Var__tXMLMap_1_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
outStruct out_tmp = new outStruct();
outStruct out_save = null;
//the aggregate variable
outStruct out_aggregate = null;
int count_out_tXMLMap_1_TXMLMAP_OUT = 0;
//init the resultset for aggregate
java.util.List<Object> allOutsForAggregate_tXMLMap_1 = new java.util.ArrayList<Object>();
globalMap.put("allOutsForAggregate_tXMLMap_1",allOutsForAggregate_tXMLMap_1);
// ###############################
		int nb_line_tXMLMap_1_TXMLMAP_OUT = 0; 
	
    XML_API_tXMLMap_1_TXMLMAP_OUT xml_api_tXMLMap_1_TXMLMAP_OUT = new XML_API_tXMLMap_1_TXMLMAP_OUT();

	//the map store the previous value of aggregate columns
	java.util.Map<String,Object> aggregateCacheMap_tXMLMap_1_TXMLMAP_OUT = new java.util.HashMap<String,Object>();

class GenerateDocument_out {

	java.util.Map<String,Object> valueMap = null;
	
	routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(1);
	
	org.dom4j.Document doc = null;
	
	org.dom4j.Element root4Group = null;
	
	org.dom4j.io.OutputFormat format = null;
	
	java.util.List<java.util.List<String>> groupbyList = null;
	java.util.List<org.dom4j.Element> groupElementList = null;
	int order = 0;
	
	boolean isFirst = true;
	
	boolean	needRoot = true;
	
	String currentValue = null;

		org.dom4j.Element subTreeLoopParent0 = null;
		public boolean  subTreeLoop0 = false;
	
    public GenerateDocument_out() {
//    	this.treeNodeAPI = treeNodeAPI;
    	
    	valueMap = new java.util.HashMap<String,Object>();
    	
    	groupbyList =  new java.util.ArrayList<java.util.List<String>>();
		groupElementList = new java.util.ArrayList<org.dom4j.Element>();
    	
    	doc = org.dom4j.DocumentHelper.createDocument();
    	format = org.dom4j.io.OutputFormat.createPrettyPrint();
    	format.setTrimText(false);
    }
    
    public org.dom4j.Document getDocument(){
    	return this.doc;
    }
    
	//We generate the TreeNode_API object only if there is a document in the main input table.
    void generateElements(boolean isInnerJoin, row1Struct row1, Var__tXMLMap_1_TXMLMAP_OUT__Struct Var
	) {
	
	
	/*if(this.treeNodeAPI==null) {
		this.treeNodeAPI = treeNodeAPI;
	}*/
	
	org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
if (needRoot) {
	needRoot=false;
		org.dom4j.Element root = null;
				root = doc.addElement("root");
		subTreeRootParent = root;
					subTreeLoopParent0 = root;
		root4Group = subTreeRootParent;
	}else{
		subTreeRootParent=root4Group;
	}
	/* build group xml tree */
	boolean isNewElement = false;
		isNewElement = false;
		org.dom4j.Element loop = null;
				loop = org.dom4j.DocumentHelper.createElement("movie");
				subTreeRootParent.elements().add(orderHelper.getInsertLocation(0,0),loop);
		subTreeRootParent = loop;
		org.dom4j.Element loop_0 = null;
				loop_0 = loop.addElement("title");
		valueMap.put("loop_0",row1.title);
		if(valueMap.get("loop_0")!=null) {
			routines.system.NestXMLTool.setText(loop_0, FormatterUtils.fm(valueMap.get("loop_0"),null));
		}
		org.dom4j.Element loop_1 = null;
				loop_1 = loop.addElement("genre");
		valueMap.put("loop_1",row1.genre);
		if(valueMap.get("loop_1")!=null) {
			routines.system.NestXMLTool.setText(loop_1, FormatterUtils.fm(valueMap.get("loop_1"),null));
		}
		org.dom4j.Element loop_2 = null;
				loop_2 = loop.addElement("year");
		valueMap.put("loop_2",row1.year);
		if(valueMap.get("loop_2")!=null) {
			routines.system.NestXMLTool.setText(loop_2, FormatterUtils.fm(valueMap.get("loop_2"),null));
		}
		}
    }

	GenerateDocument_out gen_Doc_out_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_out();
	boolean docAlreadyInstanciate_out = false;

class GenerateDocument_tXMLMap_1_TXMLMAP_OUT {

	java.util.Map<String,Object> valueMap = null;
	
	routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(1);
	
	org.dom4j.Document doc = null;
	
	org.dom4j.Element root4Group = null;
	
	org.dom4j.io.OutputFormat format = null;
	
	java.util.List<java.util.List<String>> groupbyList = null;
	java.util.List<org.dom4j.Element> groupElementList = null;
	int order = 0;
	
	boolean isFirst = true;
	
	boolean	needRoot = true;
	
	String currentValue = null;

		org.dom4j.Element subTreeLoopParent0 = null;
		public boolean  subTreeLoop0 = false;
	
    public GenerateDocument_tXMLMap_1_TXMLMAP_OUT() {
//    	this.treeNodeAPI = treeNodeAPI;
    	
    	valueMap = new java.util.HashMap<String,Object>();
    	
    	groupbyList =  new java.util.ArrayList<java.util.List<String>>();
		groupElementList = new java.util.ArrayList<org.dom4j.Element>();
    	
    	doc = org.dom4j.DocumentHelper.createDocument();
    	format = org.dom4j.io.OutputFormat.createPrettyPrint();
    	format.setTrimText(false);
    }
    
    public org.dom4j.Document getDocument(){
    	return this.doc;
    }
    
	//We generate the TreeNode_API object only if there is a document in the main input table.
    void generateElements(boolean isInnerJoin, row1Struct row1, Var__tXMLMap_1_TXMLMAP_OUT__Struct Var
	) {
	
	
	/*if(this.treeNodeAPI==null) {
		this.treeNodeAPI = treeNodeAPI;
	}*/
	
	org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
if (needRoot) {
	needRoot=false;
		org.dom4j.Element root = null;
				root = org.dom4j.DocumentHelper.createElement("root");
				doc.add(root);
		subTreeRootParent = root;
		root4Group = subTreeRootParent;
	}else{
		subTreeRootParent=root4Group;
	}
	/* build group xml tree */
	boolean isNewElement = false;
		isNewElement = false;
		}
    }

	GenerateDocument_tXMLMap_1_TXMLMAP_OUT gen_Doc_tXMLMap_1_TXMLMAP_OUT_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_tXMLMap_1_TXMLMAP_OUT();
	boolean docAlreadyInstanciate_tXMLMap_1_TXMLMAP_OUT = false;

	            

 



/**
 * [tXMLMap_1_TXMLMAP_OUT begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";
	
	
			cLabel="movielist";
		
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_5");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("HOST" + " = " + "\"localhost\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PORT" + " = " + "\"3306\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"movies\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USER" + " = " + "\"root\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:Nm9ucHXFPMwCtDBX/1us7gSB9wgk5MzGmKKlO063/Ds=").substring(0, 4) + "...");     
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"movielist\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT    `movielist`.`title`,    `movielist`.`genre`,    `movielist`.`year`  FROM `movielist` where  `movielist`.`available` = '1'\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("title")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("genre")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("year")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "movielist", "tMysqlInput");
				talendJobLogProcess(globalMap);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "root";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:yPDcA5KTxBfgMxyDD/FnI4+Nn63c5B52hPMYypc8bzA=");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = "noDatetimeStringSync=true";
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "movies" + "?" + properties_tDBInput_1;
				
	    		log.debug("tDBInput_1 - Driver ClassName: "+driverClass_tDBInput_1+".");
			
	    		log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1 + "' with the username '" + dbUser_tDBInput_1 + "'.");
			
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
	    		log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1 + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  `movielist`.`title`, \n  `movielist`.`genre`, \n  `movielist`.`year`\n\nFROM `movielist` where  `movielist`.`avai"
+"lable` = '1'";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

		    globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);

		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.title = null;
							} else {
	                         		
        	row1.title = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.genre = null;
							} else {
	                         		
        	row1.genre = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.year = null;
							} else {
	                         		
        	row1.year = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					

 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="movielist";
		

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_OUT";
	
	
			cLabel="map_movie_list_TXMLMAP_OUT";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"row1","tDBInput_1","movielist","tMysqlInput","tXMLMap_1_TXMLMAP_OUT","map_movie_list_TXMLMAP_OUT","tXMLMapOut"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

	boolean rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
	boolean rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
	boolean mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
	boolean isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;
	  
	
			
   
					out_tmp.body = null;
					
		
		


			
{ // start of Var scope

	// ###############################
	// # Vars tables

Var__tXMLMap_1_TXMLMAP_OUT__Struct Var = Var__tXMLMap_1_TXMLMAP_OUT;
		// ###############################
		// # Output tables

out = null;


// # Output table : 'out'
count_out_tXMLMap_1_TXMLMAP_OUT++;


if(!docAlreadyInstanciate_out) {
docAlreadyInstanciate_out = true;gen_Doc_out_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_out();
//init one new out struct for cache the result.
out_aggregate = new outStruct();
out_aggregate.body = new routines.system.Document();
out_aggregate.body.setDocument(gen_Doc_out_tXMLMap_1_TXMLMAP_OUT.getDocument());

//construct the resultset
allOutsForAggregate_tXMLMap_1.add(out_aggregate);
}


gen_Doc_out_tXMLMap_1_TXMLMAP_OUT.generateElements(rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT,row1,Var);


log.debug("tXMLMap_1 - Outputting the record " + count_out_tXMLMap_1_TXMLMAP_OUT + " of the output table 'out'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;



 


	tos_count_tXMLMap_1_TXMLMAP_OUT++;

/**
 * [tXMLMap_1_TXMLMAP_OUT main ] stop
 */
	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_OUT";
	
	
			cLabel="map_movie_list_TXMLMAP_OUT";
		

 



/**
 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] stop
 */
	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_OUT";
	
	
			cLabel="map_movie_list_TXMLMAP_OUT";
		

 



/**
 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="movielist";
		

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
	    		log.debug("tDBInput_1 - Closing the connection to the database.");
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_1 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_OUT";
	
	
			cLabel="map_movie_list_TXMLMAP_OUT";
		
		log.debug("tXMLMap_1 - Written records count in the table 'out': " + count_out_tXMLMap_1_TXMLMAP_OUT + ".");



				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row1",2,0,
				 			"tDBInput_1","movielist","tMysqlInput","tXMLMap_1_TXMLMAP_OUT","map_movie_list_TXMLMAP_OUT","tXMLMapOut","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_OUT - "  + ("Done.") );

ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", true);
end_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());




/**
 * [tXMLMap_1_TXMLMAP_OUT end ] stop
 */


	
	/**
	 * [tRESTResponse_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRESTResponse_1", false);
		start_Hash.put("tRESTResponse_1", System.currentTimeMillis());
		
	
	currentComponent="tRESTResponse_1";
	
	
			cLabel="get";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"out");
					}
				
		int tos_count_tRESTResponse_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTResponse_1", "get", "tRESTResponse");
				talendJobLogProcess(globalMap);
			}
			

 



/**
 * [tRESTResponse_1 begin ] stop
 */



	
	/**
	 * [tXMLMap_1_TXMLMAP_IN begin ] start
	 */

	

	
		
		ok_Hash.put("tXMLMap_1_TXMLMAP_IN", false);
		start_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_IN";
	
	
			cLabel="map_movie_list_TXMLMAP_IN";
		
		int tos_count_tXMLMap_1_TXMLMAP_IN = 0;
		
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tXMLMap_1_TXMLMAP_IN{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_IN = new StringBuilder();
                    log4jParamters_tXMLMap_1_TXMLMAP_IN.append("Parameters:");
                            log4jParamters_tXMLMap_1_TXMLMAP_IN.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
                        log4jParamters_tXMLMap_1_TXMLMAP_IN.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + (log4jParamters_tXMLMap_1_TXMLMAP_IN) );
                    } 
                } 
            new BytesLimit65535_tXMLMap_1_TXMLMAP_IN().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tXMLMap_1_TXMLMAP_IN", "map_movie_list_TXMLMAP_IN", "tXMLMapIn");
				talendJobLogProcess(globalMap);
			}
			
java.util.List<Object> outs_tXMLMap_1 = (java.util.List<Object>)globalMap.get("allOutsForAggregate_tXMLMap_1");
for(Object  row_out_tXMLMap_1_TXMLMAP_IN : outs_tXMLMap_1) {//TD512
 



/**
 * [tXMLMap_1_TXMLMAP_IN begin ] stop
 */
	
	/**
	 * [tXMLMap_1_TXMLMAP_IN main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_IN";
	
	
			cLabel="map_movie_list_TXMLMAP_IN";
		

	out = null;
	if(row_out_tXMLMap_1_TXMLMAP_IN!=null && row_out_tXMLMap_1_TXMLMAP_IN instanceof outStruct) {
		out = (outStruct)row_out_tXMLMap_1_TXMLMAP_IN;
			routines.system.NestXMLTool.generateOk(out.body, false);		
	}
 


	tos_count_tXMLMap_1_TXMLMAP_IN++;

/**
 * [tXMLMap_1_TXMLMAP_IN main ] stop
 */
	
	/**
	 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_IN";
	
	
			cLabel="map_movie_list_TXMLMAP_IN";
		

 



/**
 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] stop
 */
// Start of branch "out"
if(out != null) { 



	
	/**
	 * [tRESTResponse_1 main ] start
	 */

	

	
	
	currentComponent="tRESTResponse_1";
	
	
			cLabel="get";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"out","tXMLMap_1_TXMLMAP_IN","map_movie_list_TXMLMAP_IN","tXMLMapIn","tRESTResponse_1","get","tRESTResponse"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("out - " + (out==null? "": out.toLogString()));
    			}
    		

	java.io.OutputStream outputStream_tRESTResponse_1 = (java.io.OutputStream) globalMap.get("restResponseStream");
	boolean responseAlreadySent_tRESTResponse_1 = globalMap.containsKey("restResponse");

	if (null == outputStream_tRESTResponse_1 && responseAlreadySent_tRESTResponse_1) {
		throw new RuntimeException("Rest response already sent.");
	} else if (!globalMap.containsKey("restRequest")) {
		throw new RuntimeException("Not received rest request yet.");
	} else {
		Integer restProviderStatusCode_tRESTResponse_1 = 200;

		Object restProviderResponse_tRESTResponse_1 = null;
		if (null != out.body) {
			restProviderResponse_tRESTResponse_1 = out.body.getDocument();
		}

		java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_1 = new java.util.TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_1 = new java.lang.StringBuilder();
		final String setCookieHeader = "Set-Cookie";

        if (restProviderResponseHeader_cookies_tRESTResponse_1.length() > 0) {
		    restProviderResponseHeaders_tRESTResponse_1.put(setCookieHeader, restProviderResponseHeader_cookies_tRESTResponse_1.toString());
		}

        java.util.Map<String, Object> restRequest_tRESTResponse_1 = (java.util.Map<String, Object>) globalMap.get("restRequest");
        org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_1 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_1.get("MESSAGE_CONTEXT");
        

		if (null == outputStream_tRESTResponse_1) {
			java.util.Map<String, Object> restResponse_tRESTResponse_1 = new java.util.HashMap<String, Object>();
			restResponse_tRESTResponse_1.put("BODY", restProviderResponse_tRESTResponse_1);
			restResponse_tRESTResponse_1.put("STATUS", restProviderStatusCode_tRESTResponse_1);
			restResponse_tRESTResponse_1.put("HEADERS", restProviderResponseHeaders_tRESTResponse_1);
			restResponse_tRESTResponse_1.put("drop.json.root.element", Boolean.valueOf(false));
			globalMap.put("restResponse", restResponse_tRESTResponse_1);
			
		} else {

			javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_1 = null;
			if (!responseAlreadySent_tRESTResponse_1) {
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = ((org.apache.cxf.message.Message)restRequest_tRESTResponse_1.get("CURRENT_MESSAGE"));
				}

				if (currentMessage != null && currentMessage.getExchange() != null) {
					currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
				}

				messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.RESPONSE_CODE, restProviderStatusCode_tRESTResponse_1);
				javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_1 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
				for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_1.entrySet()) {
					headersMultivaluedMap_tRESTResponse_1.putSingle(multivaluedHeader.getKey(), multivaluedHeader.getValue());
				}
				messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, headersMultivaluedMap_tRESTResponse_1);

				String responseContentType_tRESTResponse_1 = null;
				
				if (currentMessage != null && currentMessage.getExchange() != null) {
					responseContentType_tRESTResponse_1 = (String) currentMessage.getExchange().get(org.apache.cxf.message.Message.CONTENT_TYPE);
				}
					
				if (null == responseContentType_tRESTResponse_1) {
					// this should not be needed, just in case. set it to the first value in the sorted list returned from HttpHeaders
					responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1.getHttpHeaders().getAcceptableMediaTypes().get(0);
				} else {
					responseMediaType_tRESTResponse_1 = org.apache.cxf.jaxrs.utils.JAXRSUtils.toMediaType(responseContentType_tRESTResponse_1);
				}
				globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_1);

				String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1.getSubtype();
				if (responseMediaSubType_tRESTResponse_1.equals("xml") || responseMediaSubType_tRESTResponse_1.endsWith("+xml")) {
					outputStream_tRESTResponse_1.write("<wrapper>".getBytes());
					globalMap.put("restResponseWrappingClosure", "</wrapper>");
				}
				if (responseMediaSubType_tRESTResponse_1.equals("json") || responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
					outputStream_tRESTResponse_1.write("[".getBytes());
					globalMap.put("restResponseWrappingClosure", "]");
				}

				globalMap.put("restResponse", true);
			} else {
				responseMediaType_tRESTResponse_1 = (javax.ws.rs.core.MediaType) globalMap.get("restResponseMediaType");
			}

			if (null != restProviderResponse_tRESTResponse_1) {
				String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1.getSubtype();
				if (responseMediaSubType_tRESTResponse_1.equals("json") || responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
					if (globalMap.containsKey("restResponseJsonStarted")) {
						outputStream_tRESTResponse_1.write(",".getBytes());
					} else {
						globalMap.put("restResponseJsonStarted", true);
					}
				}

				Class<? extends Object> responseBodyClass_tRESTResponse_1 = restProviderResponse_tRESTResponse_1.getClass();
				javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_1 = messageContext_tRESTResponse_1.getProviders();
				javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_1 = messageBodyProviders_tRESTResponse_1.getMessageBodyWriter(
						responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1, null, responseMediaType_tRESTResponse_1);

                if (messageBodyWriter_tRESTResponse_1 instanceof StreamingDOM4JProvider) {
                    ((StreamingDOM4JProvider)messageBodyWriter_tRESTResponse_1).setGlobalMap(globalMap);
                }

				messageBodyWriter_tRESTResponse_1.writeTo(restProviderResponse_tRESTResponse_1, responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1,
						new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_1, null, outputStream_tRESTResponse_1);
			}
			// initial variant
			//outputStream_tRESTResponse_1.write(String.valueOf(restProviderResponse_tRESTResponse_1).getBytes());
			outputStream_tRESTResponse_1.flush();
		}
	}

 


	tos_count_tRESTResponse_1++;

/**
 * [tRESTResponse_1 main ] stop
 */
	
	/**
	 * [tRESTResponse_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRESTResponse_1";
	
	
			cLabel="get";
		

 



/**
 * [tRESTResponse_1 process_data_begin ] stop
 */
	
	/**
	 * [tRESTResponse_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRESTResponse_1";
	
	
			cLabel="get";
		

 



/**
 * [tRESTResponse_1 process_data_end ] stop
 */

} // End of branch "out"




	
	/**
	 * [tXMLMap_1_TXMLMAP_IN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_IN";
	
	
			cLabel="map_movie_list_TXMLMAP_IN";
		

 



/**
 * [tXMLMap_1_TXMLMAP_IN process_data_end ] stop
 */
	
	/**
	 * [tXMLMap_1_TXMLMAP_IN end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_IN";
	
	
			cLabel="map_movie_list_TXMLMAP_IN";
		

}//TD512
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + ("Done.") );

ok_Hash.put("tXMLMap_1_TXMLMAP_IN", true);
end_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());




/**
 * [tXMLMap_1_TXMLMAP_IN end ] stop
 */

	
	/**
	 * [tRESTResponse_1 end ] start
	 */

	

	
	
	currentComponent="tRESTResponse_1";
	
	
			cLabel="get";
		

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"out",2,0,
				 			"tXMLMap_1_TXMLMAP_IN","map_movie_list_TXMLMAP_IN","tXMLMapIn","tRESTResponse_1","get","tRESTResponse","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tRESTResponse_1", true);
end_Hash.put("tRESTResponse_1", System.currentTimeMillis());




/**
 * [tRESTResponse_1 end ] stop
 */













	
	/**
	 * [tFlowToIterate_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";
	
	
			cLabel="iterate";
		

 



/**
 * [tFlowToIterate_1 process_data_end ] stop
 */

} // End of branch "Available_movies"




// Start of branch "rent_movie"
if(rent_movie != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			cLabel="select_movie";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"rent_movie","tRESTRequest_1_In","Movies_In","tRESTRequestIn","tMap_1","select_movie","tMap"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("rent_movie - " + (rent_movie==null? "": rent_movie.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_1 = false;
		boolean mainRowRejected_tMap_1 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

rent = null;


// # Output table : 'rent'
count_rent_tMap_1++;

rent_tmp.title = rent_movie.title ;
rent_tmp.available = rent_movie.rent == true? false:true;
rent = rent_tmp;
log.debug("tMap_1 - Outputting the record " + count_rent_tMap_1 + " of the output table 'rent'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			cLabel="select_movie";
		

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "rent"
if(rent != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="movielist";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"rent","tMap_1","select_movie","tMap","tDBOutput_1","movielist","tMysqlOutput"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("rent - " + (rent==null? "": rent.toLogString()));
    			}
    		



            row2 = null;
        whetherReject_tDBOutput_1 = false;
                    if(rent.available == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.BOOLEAN);
} else {pstmt_tDBOutput_1.setBoolean(1, rent.available);
}


                    if(rent.title == null) {
pstmt_tDBOutput_1.setNull(2 + count_tDBOutput_1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(2 + count_tDBOutput_1, rent.title);
}


            pstmt_tDBOutput_1.addBatch();
            nb_line_tDBOutput_1++;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Adding the record ")  + (nb_line_tDBOutput_1)  + (" to the ")  + ("UPDATE")  + (" batch.") );
                  batchSizeCounter_tDBOutput_1++;
            if(!whetherReject_tDBOutput_1) {
                            row2 = new row2Struct();
                                row2.title = rent.title;
                                row2.available = rent.available;
            }
                if ( batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
                        try {
                                int countSum_tDBOutput_1 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("UPDATE")  + (" batch.") );
                                for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                                    countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                                }
                                rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("UPDATE")  + (" batch execution has succeeded.") );
                                updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
                                batchSizeCounter_tDBOutput_1 = 0;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_1 = 0;
                            for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                                countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                            }
                            rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                            updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_1 - "  + (e.getMessage()) );
                        }
                }
                commitCounter_tDBOutput_1++;

                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

                        try {
                                int countSum_tDBOutput_1 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("UPDATE")  + (" batch.") );
                                for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                                    countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                                }
                                rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("UPDATE")  + (" batch execution has succeeded.") );
                                updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_1 = 0;
                            for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                                countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                            }
                            rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                            updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_1 - "  + (e.getMessage()) );

                        }
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_1)  + (" record(s).") );
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tRESTResponse_2 main ] start
	 */

	

	
	
	currentComponent="tRESTResponse_2";
	
	
			cLabel="rent_or_giveback";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"row2","tDBOutput_1","movielist","tMysqlOutput","tRESTResponse_2","rent_or_giveback","tRESTResponse"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		

	java.io.OutputStream outputStream_tRESTResponse_2 = (java.io.OutputStream) globalMap.get("restResponseStream");
	boolean responseAlreadySent_tRESTResponse_2 = globalMap.containsKey("restResponse");

	if (null == outputStream_tRESTResponse_2 && responseAlreadySent_tRESTResponse_2) {
		throw new RuntimeException("Rest response already sent.");
	} else if (!globalMap.containsKey("restRequest")) {
		throw new RuntimeException("Not received rest request yet.");
	} else {
		Integer restProviderStatusCode_tRESTResponse_2 = 200;

		Object restProviderResponse_tRESTResponse_2 = null;

		java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_2 = new java.util.TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_2 = new java.lang.StringBuilder();
		final String setCookieHeader = "Set-Cookie";

        if (restProviderResponseHeader_cookies_tRESTResponse_2.length() > 0) {
		    restProviderResponseHeaders_tRESTResponse_2.put(setCookieHeader, restProviderResponseHeader_cookies_tRESTResponse_2.toString());
		}

        java.util.Map<String, Object> restRequest_tRESTResponse_2 = (java.util.Map<String, Object>) globalMap.get("restRequest");
        org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_2 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_2.get("MESSAGE_CONTEXT");
        

		if (null == outputStream_tRESTResponse_2) {
			java.util.Map<String, Object> restResponse_tRESTResponse_2 = new java.util.HashMap<String, Object>();
			restResponse_tRESTResponse_2.put("BODY", restProviderResponse_tRESTResponse_2);
			restResponse_tRESTResponse_2.put("STATUS", restProviderStatusCode_tRESTResponse_2);
			restResponse_tRESTResponse_2.put("HEADERS", restProviderResponseHeaders_tRESTResponse_2);
			restResponse_tRESTResponse_2.put("drop.json.root.element", Boolean.valueOf(false));
			globalMap.put("restResponse", restResponse_tRESTResponse_2);
			
		} else {

			javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_2 = null;
			if (!responseAlreadySent_tRESTResponse_2) {
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = ((org.apache.cxf.message.Message)restRequest_tRESTResponse_2.get("CURRENT_MESSAGE"));
				}

				if (currentMessage != null && currentMessage.getExchange() != null) {
					currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
				}

				messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.RESPONSE_CODE, restProviderStatusCode_tRESTResponse_2);
				javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_2 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
				for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_2.entrySet()) {
					headersMultivaluedMap_tRESTResponse_2.putSingle(multivaluedHeader.getKey(), multivaluedHeader.getValue());
				}
				messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, headersMultivaluedMap_tRESTResponse_2);

				String responseContentType_tRESTResponse_2 = null;
				
				if (currentMessage != null && currentMessage.getExchange() != null) {
					responseContentType_tRESTResponse_2 = (String) currentMessage.getExchange().get(org.apache.cxf.message.Message.CONTENT_TYPE);
				}
					
				if (null == responseContentType_tRESTResponse_2) {
					// this should not be needed, just in case. set it to the first value in the sorted list returned from HttpHeaders
					responseMediaType_tRESTResponse_2 = messageContext_tRESTResponse_2.getHttpHeaders().getAcceptableMediaTypes().get(0);
				} else {
					responseMediaType_tRESTResponse_2 = org.apache.cxf.jaxrs.utils.JAXRSUtils.toMediaType(responseContentType_tRESTResponse_2);
				}
				globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_2);

				String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2.getSubtype();
				if (responseMediaSubType_tRESTResponse_2.equals("xml") || responseMediaSubType_tRESTResponse_2.endsWith("+xml")) {
					outputStream_tRESTResponse_2.write("<wrapper>".getBytes());
					globalMap.put("restResponseWrappingClosure", "</wrapper>");
				}
				if (responseMediaSubType_tRESTResponse_2.equals("json") || responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
					outputStream_tRESTResponse_2.write("[".getBytes());
					globalMap.put("restResponseWrappingClosure", "]");
				}

				globalMap.put("restResponse", true);
			} else {
				responseMediaType_tRESTResponse_2 = (javax.ws.rs.core.MediaType) globalMap.get("restResponseMediaType");
			}

			if (null != restProviderResponse_tRESTResponse_2) {
				String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2.getSubtype();
				if (responseMediaSubType_tRESTResponse_2.equals("json") || responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
					if (globalMap.containsKey("restResponseJsonStarted")) {
						outputStream_tRESTResponse_2.write(",".getBytes());
					} else {
						globalMap.put("restResponseJsonStarted", true);
					}
				}

				Class<? extends Object> responseBodyClass_tRESTResponse_2 = restProviderResponse_tRESTResponse_2.getClass();
				javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_2 = messageContext_tRESTResponse_2.getProviders();
				javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_2 = messageBodyProviders_tRESTResponse_2.getMessageBodyWriter(
						responseBodyClass_tRESTResponse_2, responseBodyClass_tRESTResponse_2, null, responseMediaType_tRESTResponse_2);

                if (messageBodyWriter_tRESTResponse_2 instanceof StreamingDOM4JProvider) {
                    ((StreamingDOM4JProvider)messageBodyWriter_tRESTResponse_2).setGlobalMap(globalMap);
                }

				messageBodyWriter_tRESTResponse_2.writeTo(restProviderResponse_tRESTResponse_2, responseBodyClass_tRESTResponse_2, responseBodyClass_tRESTResponse_2,
						new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_2, null, outputStream_tRESTResponse_2);
			}
			// initial variant
			//outputStream_tRESTResponse_2.write(String.valueOf(restProviderResponse_tRESTResponse_2).getBytes());
			outputStream_tRESTResponse_2.flush();
		}
	}

 


	tos_count_tRESTResponse_2++;

/**
 * [tRESTResponse_2 main ] stop
 */
	
	/**
	 * [tRESTResponse_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRESTResponse_2";
	
	
			cLabel="rent_or_giveback";
		

 



/**
 * [tRESTResponse_2 process_data_begin ] stop
 */
	
	/**
	 * [tRESTResponse_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRESTResponse_2";
	
	
			cLabel="rent_or_giveback";
		

 



/**
 * [tRESTResponse_2 process_data_end ] stop
 */

} // End of branch "row2"




	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "rent"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			cLabel="select_movie";
		

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "rent_movie"




// Start of branch "Add_movie"
if(Add_movie != null) { 



	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			cLabel="movie_details";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"Add_movie","tRESTRequest_1_In","Movies_In","tRESTRequestIn","tMap_2","movie_details","tMap"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("Add_movie - " + (Add_movie==null? "": Add_movie.toLogString()));
    			}
    		

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		
		// ###############################
		// # Input tables (lookups)
		
		boolean rejectedInnerJoin_tMap_2 = false;
		boolean mainRowRejected_tMap_2 = false;
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

add = null;


// # Output table : 'add'
count_add_tMap_2++;

add_tmp.title = Add_movie.title ;
add_tmp.genre = Add_movie.genre ;
add_tmp.year = Add_movie.year ;
add_tmp.available = true;
add = add_tmp;
log.debug("tMap_2 - Outputting the record " + count_add_tMap_2 + " of the output table 'add'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			cLabel="movie_details";
		

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "add"
if(add != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="movielist";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"add","tMap_2","movie_details","tMap","tDBOutput_2","movielist","tMysqlOutput"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("add - " + (add==null? "": add.toLogString()));
    			}
    		



            row3 = null;
        whetherReject_tDBOutput_2 = false;
                            if(add.title == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(1, add.title);
}

                            if(add.genre == null) {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(2, add.genre);
}

                            if(add.year == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, add.year);
}

                            if(add.available == null) {
pstmt_tDBOutput_2.setNull(4, java.sql.Types.BOOLEAN);
} else {pstmt_tDBOutput_2.setBoolean(4, add.available);
}

                    pstmt_tDBOutput_2.addBatch();
                    nb_line_tDBOutput_2++;

                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Adding the record ")  + (nb_line_tDBOutput_2)  + (" to the ")  + ("INSERT")  + (" batch.") );
                      batchSizeCounter_tDBOutput_2++;
            if(!whetherReject_tDBOutput_2) {
                            row3 = new row3Struct();
                                row3.title = add.title;
                                row3.genre = add.genre;
                                row3.year = add.year;
                                row3.available = add.available;
            }
                if ( batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2) {
                try {
                        int countSum_tDBOutput_2 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                        for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
                            countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                        insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                }catch (java.sql.BatchUpdateException e){
                    globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_2 = 0;
                    for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
                        countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
                    }
                    rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                    insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                    System.err.println(e.getMessage());
            log.error("tDBOutput_2 - "  + (e.getMessage()) );
                }

                batchSizeCounter_tDBOutput_2 = 0;
            }
                commitCounter_tDBOutput_2++;

                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

                        try {
                                int countSum_tDBOutput_2 = 0;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
                                for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
                                    countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : 1);
                                }
                                rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
                                insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                        }catch (java.sql.BatchUpdateException e){
                            globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                            int countSum_tDBOutput_2 = 0;
                            for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
                                countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
                            }
                            rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
                            insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
                            System.err.println(e.getMessage());
            log.error("tDBOutput_2 - "  + (e.getMessage()) );

                        }
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_2)  + (" record(s).") );
                    }
                    conn_tDBOutput_2.commit();
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection commit has succeeded.") );
                        rowsToCommitCount_tDBOutput_2 = 0;
                    }
                    commitCounter_tDBOutput_2=0;
                }

 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
// Start of branch "row3"
if(row3 != null) { 



	
	/**
	 * [tRESTResponse_3 main ] start
	 */

	

	
	
	currentComponent="tRESTResponse_3";
	
	
			cLabel="movie_added";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"row3","tDBOutput_2","movielist","tMysqlOutput","tRESTResponse_3","movie_added","tRESTResponse"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row3 - " + (row3==null? "": row3.toLogString()));
    			}
    		

	java.io.OutputStream outputStream_tRESTResponse_3 = (java.io.OutputStream) globalMap.get("restResponseStream");
	boolean responseAlreadySent_tRESTResponse_3 = globalMap.containsKey("restResponse");

	if (null == outputStream_tRESTResponse_3 && responseAlreadySent_tRESTResponse_3) {
		throw new RuntimeException("Rest response already sent.");
	} else if (!globalMap.containsKey("restRequest")) {
		throw new RuntimeException("Not received rest request yet.");
	} else {
		Integer restProviderStatusCode_tRESTResponse_3 = 200;

		Object restProviderResponse_tRESTResponse_3 = null;

		java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_3 = new java.util.TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_3 = new java.lang.StringBuilder();
		final String setCookieHeader = "Set-Cookie";

        if (restProviderResponseHeader_cookies_tRESTResponse_3.length() > 0) {
		    restProviderResponseHeaders_tRESTResponse_3.put(setCookieHeader, restProviderResponseHeader_cookies_tRESTResponse_3.toString());
		}

        java.util.Map<String, Object> restRequest_tRESTResponse_3 = (java.util.Map<String, Object>) globalMap.get("restRequest");
        org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_3 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_3.get("MESSAGE_CONTEXT");
        

		if (null == outputStream_tRESTResponse_3) {
			java.util.Map<String, Object> restResponse_tRESTResponse_3 = new java.util.HashMap<String, Object>();
			restResponse_tRESTResponse_3.put("BODY", restProviderResponse_tRESTResponse_3);
			restResponse_tRESTResponse_3.put("STATUS", restProviderStatusCode_tRESTResponse_3);
			restResponse_tRESTResponse_3.put("HEADERS", restProviderResponseHeaders_tRESTResponse_3);
			restResponse_tRESTResponse_3.put("drop.json.root.element", Boolean.valueOf(false));
			globalMap.put("restResponse", restResponse_tRESTResponse_3);
			
		} else {

			javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_3 = null;
			if (!responseAlreadySent_tRESTResponse_3) {
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = ((org.apache.cxf.message.Message)restRequest_tRESTResponse_3.get("CURRENT_MESSAGE"));
				}

				if (currentMessage != null && currentMessage.getExchange() != null) {
					currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
				}

				messageContext_tRESTResponse_3.put(org.apache.cxf.message.Message.RESPONSE_CODE, restProviderStatusCode_tRESTResponse_3);
				javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_3 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
				for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_3.entrySet()) {
					headersMultivaluedMap_tRESTResponse_3.putSingle(multivaluedHeader.getKey(), multivaluedHeader.getValue());
				}
				messageContext_tRESTResponse_3.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, headersMultivaluedMap_tRESTResponse_3);

				String responseContentType_tRESTResponse_3 = null;
				
				if (currentMessage != null && currentMessage.getExchange() != null) {
					responseContentType_tRESTResponse_3 = (String) currentMessage.getExchange().get(org.apache.cxf.message.Message.CONTENT_TYPE);
				}
					
				if (null == responseContentType_tRESTResponse_3) {
					// this should not be needed, just in case. set it to the first value in the sorted list returned from HttpHeaders
					responseMediaType_tRESTResponse_3 = messageContext_tRESTResponse_3.getHttpHeaders().getAcceptableMediaTypes().get(0);
				} else {
					responseMediaType_tRESTResponse_3 = org.apache.cxf.jaxrs.utils.JAXRSUtils.toMediaType(responseContentType_tRESTResponse_3);
				}
				globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_3);

				String responseMediaSubType_tRESTResponse_3 = responseMediaType_tRESTResponse_3.getSubtype();
				if (responseMediaSubType_tRESTResponse_3.equals("xml") || responseMediaSubType_tRESTResponse_3.endsWith("+xml")) {
					outputStream_tRESTResponse_3.write("<wrapper>".getBytes());
					globalMap.put("restResponseWrappingClosure", "</wrapper>");
				}
				if (responseMediaSubType_tRESTResponse_3.equals("json") || responseMediaSubType_tRESTResponse_3.endsWith("+json")) {
					outputStream_tRESTResponse_3.write("[".getBytes());
					globalMap.put("restResponseWrappingClosure", "]");
				}

				globalMap.put("restResponse", true);
			} else {
				responseMediaType_tRESTResponse_3 = (javax.ws.rs.core.MediaType) globalMap.get("restResponseMediaType");
			}

			if (null != restProviderResponse_tRESTResponse_3) {
				String responseMediaSubType_tRESTResponse_3 = responseMediaType_tRESTResponse_3.getSubtype();
				if (responseMediaSubType_tRESTResponse_3.equals("json") || responseMediaSubType_tRESTResponse_3.endsWith("+json")) {
					if (globalMap.containsKey("restResponseJsonStarted")) {
						outputStream_tRESTResponse_3.write(",".getBytes());
					} else {
						globalMap.put("restResponseJsonStarted", true);
					}
				}

				Class<? extends Object> responseBodyClass_tRESTResponse_3 = restProviderResponse_tRESTResponse_3.getClass();
				javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_3 = messageContext_tRESTResponse_3.getProviders();
				javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_3 = messageBodyProviders_tRESTResponse_3.getMessageBodyWriter(
						responseBodyClass_tRESTResponse_3, responseBodyClass_tRESTResponse_3, null, responseMediaType_tRESTResponse_3);

                if (messageBodyWriter_tRESTResponse_3 instanceof StreamingDOM4JProvider) {
                    ((StreamingDOM4JProvider)messageBodyWriter_tRESTResponse_3).setGlobalMap(globalMap);
                }

				messageBodyWriter_tRESTResponse_3.writeTo(restProviderResponse_tRESTResponse_3, responseBodyClass_tRESTResponse_3, responseBodyClass_tRESTResponse_3,
						new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_3, null, outputStream_tRESTResponse_3);
			}
			// initial variant
			//outputStream_tRESTResponse_3.write(String.valueOf(restProviderResponse_tRESTResponse_3).getBytes());
			outputStream_tRESTResponse_3.flush();
		}
	}

 


	tos_count_tRESTResponse_3++;

/**
 * [tRESTResponse_3 main ] stop
 */
	
	/**
	 * [tRESTResponse_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRESTResponse_3";
	
	
			cLabel="movie_added";
		

 



/**
 * [tRESTResponse_3 process_data_begin ] stop
 */
	
	/**
	 * [tRESTResponse_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tRESTResponse_3";
	
	
			cLabel="movie_added";
		

 



/**
 * [tRESTResponse_3 process_data_end ] stop
 */

} // End of branch "row3"




	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "add"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			cLabel="movie_details";
		

 



/**
 * [tMap_2 process_data_end ] stop
 */

} // End of branch "Add_movie"




	
	/**
	 * [tRESTRequest_1_In process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_In";
	
	

 



/**
 * [tRESTRequest_1_In process_data_end ] stop
 */
	
	/**
	 * [tRESTRequest_1_In end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_In";
	
	
						resourceMap.put("inIterateVComp", true);
					

 

ok_Hash.put("tRESTRequest_1_In", true);
end_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());




/**
 * [tRESTRequest_1_In end ] stop
 */

	
	/**
	 * [tFlowToIterate_1 end ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";
	
	
			cLabel="iterate";
		

globalMap.put("tFlowToIterate_1_NB_LINE",nb_line_tFlowToIterate_1);
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"Available_movies",2,0,
				 			"tRESTRequest_1_In","Movies_In","tRESTRequestIn","tFlowToIterate_1","iterate","tFlowToIterate","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_1", true);
end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());




/**
 * [tFlowToIterate_1 end ] stop
 */




	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			cLabel="select_movie";
		


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'rent': " + count_rent_tMap_1 + ".");





				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"rent_movie",2,0,
				 			"tRESTRequest_1_In","Movies_In","tRESTRequestIn","tMap_1","select_movie","tMap","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="movielist";
		



		
			try {
				if(pstmt_tDBOutput_1 != null){
					int countSum_tDBOutput_1 = 0;
					
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Executing the ")  + ("UPDATE")  + (" batch.") );
					for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("The ")  + ("UPDATE")  + (" batch execution has succeeded.") );
					
						updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
					
				}
			}catch (java.sql.BatchUpdateException e){
				globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
				
					int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
						updatedCount_tDBOutput_1 += countSum_tDBOutput_1;
						
            log.error("tDBOutput_1 - "  + (e.getMessage()) );
					System.err.println(e.getMessage());
					
			}
			

		if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
		}
		
	resourceMap.put("statementClosed_tDBOutput_1", true);
	
			if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_1)  + (" record(s).") );
			}
			conn_tDBOutput_1.commit();
			if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tDBOutput_1 = 0;
			}
			commitCounter_tDBOutput_1 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Closing the connection to the database.") );
		conn_tDBOutput_1 .close();
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tDBOutput_1", true);
	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Has ")  + ("updated")  + (" ")  + (nb_line_update_tDBOutput_1)  + (" record(s).") );

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"rent",2,0,
				 			"tMap_1","select_movie","tMap","tDBOutput_1","movielist","tMysqlOutput","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Done.") );

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */

	
	/**
	 * [tRESTResponse_2 end ] start
	 */

	

	
	
	currentComponent="tRESTResponse_2";
	
	
			cLabel="rent_or_giveback";
		

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row2",2,0,
				 			"tDBOutput_1","movielist","tMysqlOutput","tRESTResponse_2","rent_or_giveback","tRESTResponse","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tRESTResponse_2", true);
end_Hash.put("tRESTResponse_2", System.currentTimeMillis());




/**
 * [tRESTResponse_2 end ] stop
 */










	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			cLabel="movie_details";
		


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'add': " + count_add_tMap_2 + ".");





				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"Add_movie",2,0,
				 			"tRESTRequest_1_In","Movies_In","tRESTRequestIn","tMap_2","movie_details","tMap","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tMap_2 - "  + ("Done.") );

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="movielist";
		



				
					try {
						if (batchSizeCounter_tDBOutput_2 != 0) {
							int countSum_tDBOutput_2 = 0;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Executing the ")  + ("INSERT")  + (" batch.") );
							for(int countEach_tDBOutput_2: pstmt_tDBOutput_2.executeBatch()) {
								countSum_tDBOutput_2 += (countEach_tDBOutput_2 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
							
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("The ")  + ("INSERT")  + (" batch execution has succeeded.") );
							
								insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
							
						}
					}catch (java.sql.BatchUpdateException e){
						globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
						
							int countSum_tDBOutput_2 = 0;
							for(int countEach_tDBOutput_2: e.getUpdateCounts()) {
								countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
							}
							rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;
							
								insertedCount_tDBOutput_2 += countSum_tDBOutput_2;
								
            log.error("tDBOutput_2 - "  + (e.getMessage()) );
							System.err.println(e.getMessage());
							
					}
					batchSizeCounter_tDBOutput_2 = 0;
					
			
		

		if(pstmt_tDBOutput_2 != null) {
			
				pstmt_tDBOutput_2.close();
				resourceMap.remove("pstmt_tDBOutput_2");
			
		}
		
	resourceMap.put("statementClosed_tDBOutput_2", true);
	
			if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection starting to commit ")  + (rowsToCommitCount_tDBOutput_2)  + (" record(s).") );
			}
			conn_tDBOutput_2.commit();
			if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
				
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection commit has succeeded.") );
				rowsToCommitCount_tDBOutput_2 = 0;
			}
			commitCounter_tDBOutput_2 = 0;
			
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Closing the connection to the database.") );
		conn_tDBOutput_2 .close();
		
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection to the database has closed.") );
		resourceMap.put("finish_tDBOutput_2", true);
	

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Has ")  + ("inserted")  + (" ")  + (nb_line_inserted_tDBOutput_2)  + (" record(s).") );

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"add",2,0,
				 			"tMap_2","movie_details","tMap","tDBOutput_2","movielist","tMysqlOutput","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Done.") );

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */

	
	/**
	 * [tRESTResponse_3 end ] start
	 */

	

	
	
	currentComponent="tRESTResponse_3";
	
	
			cLabel="movie_added";
		

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row3",2,0,
				 			"tDBOutput_2","movielist","tMysqlOutput","tRESTResponse_3","movie_added","tRESTResponse","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tRESTResponse_3", true);
end_Hash.put("tRESTResponse_3", System.currentTimeMillis());




/**
 * [tRESTResponse_3 end ] stop
 */













	
	/**
	 * [tRESTRequest_1_Loop process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_Loop";
	
	

 



/**
 * [tRESTRequest_1_Loop process_data_end ] stop
 */
	
	/**
	 * [tRESTRequest_1_Loop end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_Loop";
	
	
				resourceMap.remove("inIterateVComp");
			
	} catch (Throwable e_tRESTRequest_1) {
        if (e_tRESTRequest_1 instanceof Exception) {
			new TalendException((Exception) e_tRESTRequest_1, currentComponent, globalMap).printStackTrace();
        } else {
			new TalendException(new RuntimeException (e_tRESTRequest_1), currentComponent, globalMap).printStackTrace();
       	}
		if(!globalMap.containsKey("restResponse")){
			java.util.Map<String, Object> restFault_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			restFault_tRESTRequest_1.put("STATUS", 500);
			restFault_tRESTRequest_1.put("BODY", e_tRESTRequest_1.getMessage());
			globalMap.put("restResponse", restFault_tRESTRequest_1);
		}
		return;
	}
	nb_line_tRESTRequest_1++;
	globalMap.put("tRESTRequest_1_NB_LINE", nb_line_tRESTRequest_1);

				
				
				if(enableLogStash){
					runStat.log(iterateId,2,0,"Available_movies","rent_movie","rent","row2","Add_movie","add","row3");
				}
				
 

ok_Hash.put("tRESTRequest_1_Loop", true);
end_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());




/**
 * [tRESTRequest_1_Loop end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRESTRequest_1_Loop finally ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_Loop";
	
	

 



/**
 * [tRESTRequest_1_Loop finally ] stop
 */

	
	/**
	 * [tRESTRequest_1_In finally ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	currentComponent="tRESTRequest_1_In";
	
	

 



/**
 * [tRESTRequest_1_In finally ] stop
 */

	
	/**
	 * [tFlowToIterate_1 finally ] start
	 */

	

	
	
	currentComponent="tFlowToIterate_1";
	
	
			cLabel="iterate";
		

 



/**
 * [tFlowToIterate_1 finally ] stop
 */

	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";
	
	
			cLabel="movielist";
		

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_OUT";
	
	
			cLabel="map_movie_list_TXMLMAP_OUT";
		

 



/**
 * [tXMLMap_1_TXMLMAP_OUT finally ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_IN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	currentComponent="tXMLMap_1_TXMLMAP_IN";
	
	
			cLabel="map_movie_list_TXMLMAP_IN";
		

 



/**
 * [tXMLMap_1_TXMLMAP_IN finally ] stop
 */

	
	/**
	 * [tRESTResponse_1 finally ] start
	 */

	

	
	
	currentComponent="tRESTResponse_1";
	
	
			cLabel="get";
		

 



/**
 * [tRESTResponse_1 finally ] stop
 */
















	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";
	
	
			cLabel="select_movie";
		

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";
	
	
			cLabel="movielist";
		



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_1.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_1 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
            log.error("tDBOutput_1 - "  + (errorMessage_tDBOutput_1) );
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */

	
	/**
	 * [tRESTResponse_2 finally ] start
	 */

	

	
	
	currentComponent="tRESTResponse_2";
	
	
			cLabel="rent_or_giveback";
		

 



/**
 * [tRESTResponse_2 finally ] stop
 */










	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";
	
	
			cLabel="movie_details";
		

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";
	
	
			cLabel="movielist";
		



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Closing the connection to the database.") );
                    ctn_tDBOutput_2.close();
                if(log.isDebugEnabled())
            log.debug("tDBOutput_2 - "  + ("Connection to the database has closed.") );
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
            log.error("tDBOutput_2 - "  + (errorMessage_tDBOutput_2) );
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */

	
	/**
	 * [tRESTResponse_3 finally ] start
	 */

	

	
	
	currentComponent="tRESTResponse_3";
	
	
			cLabel="movie_added";
		

 



/**
 * [tRESTResponse_3 finally ] stop
 */












				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 1);
	}
	


public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", "talendJobLog");
		org.slf4j.MDC.put("_subJobPid", "KZfDb4_" + subJobPidCounter.getAndIncrement());
	

	
		String iterateId = "";
	
	
	String currentComponent = "";
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		ok_Hash.put("talendJobLog", false);
		start_Hash.put("talendJobLog", System.currentTimeMillis());
		
	
	currentComponent="talendJobLog";
	
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



/**
 * [talendJobLog begin ] stop
 */
	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 


	tos_count_talendJobLog++;

/**
 * [talendJobLog main ] stop
 */
	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_begin ] stop
 */
	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog process_data_end ] stop
 */
	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




/**
 * [talendJobLog end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	currentComponent="talendJobLog";
	
	

 



/**
 * [talendJobLog finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
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
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final movie_rental movie_rentalClass = new movie_rental();

        int exitCode = movie_rentalClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'movie_rental' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20230913_0925-patch"));
		
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

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'movie_rental' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_9PYYwHikEeqZN5fwy26K9Q");
                org.slf4j.MDC.put("_compiledAtTimestamp","2024-11-29T09:35:26.405674100Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
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

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);

        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = movie_rental.class.getClassLoader().getResourceAsStream("tmc_demo2/movie_rental_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = movie_rental.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
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
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
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
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'movie_rental' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);




	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tRESTRequest_1_LoopProcess(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRESTRequest_1_Loop) {
globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", -1);

e_tRESTRequest_1_Loop.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : movie_rental");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'movie_rental' - Finished - status: " + status + " returnCode: " + returnCode );

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
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
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
 *     254822 characters generated by Talend Cloud Data Fabric 
 *     on the November 29, 2024 at 9:35:26 AM GMT
 ************************************************************************************************/