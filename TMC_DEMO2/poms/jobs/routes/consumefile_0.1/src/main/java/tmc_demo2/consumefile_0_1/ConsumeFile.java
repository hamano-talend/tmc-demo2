
package tmc_demo2.consumefile_0_1;

        import java.util.HashMap ;
        import java.util.Map ;
        import java.util.Properties ;
        import org.apache.camel.CamelContext ;
        import routines.* ;
        import routines.TalendString ;
        import routines.system.* ;
        import routines.system.api.TalendESBRoute ;

/**
 * Job: ConsumeFile Purpose: <br>
 * Description:  <br>
 * @author Hamano, Masaki
 * @version 8.0.1.20230913_0925-patch
 * @status 
 */





@org.springframework.boot.autoconfigure.SpringBootApplication
@org.springframework.boot.context.properties.EnableConfigurationProperties(ConsumeFile.ContextProperties.class)
@org.springframework.context.annotation.ImportResource("classpath:META-INF/spring/consumefile.xml")
public class ConsumeFile extends org.apache.camel.builder.RouteBuilder implements TalendESBRoute {

    @org.springframework.beans.factory.annotation.Autowired
    org.springframework.core.env.Environment env;



    private boolean inOSGi = routines.system.BundleUtils.inOSGi();

    private boolean inMS = true;

    private static Object arguments;


    public void setArguments(Object arguments) {
        this.inOSGi = true;
        ConsumeFile.arguments = arguments;
    }

    public <T> Map<String, T> getArguments(Object props,Class c){
        if (props != null) {
            try {
                java.lang.reflect.Field propertiesField = props.getClass().getDeclaredField("properties");
                propertiesField.setAccessible(true);
                java.util.Dictionary p = (java.util.Dictionary) propertiesField.get(props);
                java.util.Map<String,T> result = new java.util.HashMap<>();

                if(p !=null ){
                    for (java.util.Enumeration<String> keys = p.keys(); keys.hasMoreElements();) {
                        String key = keys.nextElement();
                        if(c.equals(String.class)){
                            result.put(key, (T) String.valueOf(p.get(key)));
                        }else{
                            result.put(key, (T) p.get(key));
                        }

                    }
                }

                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String propertyToString(Object obj){
        if(obj!=null && obj instanceof java.util.Date){
            return String.format("yyyy-MM-dd HH:mm:ss;%tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj);
        }else{
            return String.valueOf(obj);
        }
    }


            @Override
            public void configure() throws java.lang.Exception {
                doConfig();
            }

            class DefaultRegistry extends org.apache.camel.support.DefaultRegistry{
            
                private org.apache.camel.spi.Registry registry = null;
                
                public DefaultRegistry(org.apache.camel.spi.Registry registry){
                    this.registry = registry;
                }
        
                public void put(String k, Object v) {
                    registry.bind(k, (v == null) ? Object.class: v.getClass(), v);
                }
                
                public Object get(String k) {
                    return registry.lookupByName(k);
                }
        
            }

            public void destroy() {

            }

            public void doConfig() throws java.lang.Exception {
                final /*org.apache.camel.model.Model*/CamelContext camelContext = getContext();
                
                camelContext.setDebugging(true);
                camelContext.setStreamCaching(false);
                org.apache.camel.spi.Registry realRegistry = camelContext.getRegistry();
                
                if (realRegistry == null) {
                    realRegistry = new org.apache.camel.support.DefaultRegistry();
                }
                
                DefaultRegistry registry = new DefaultRegistry(realRegistry);
                
                ((org.apache.camel.impl.DefaultCamelContext) camelContext).setRegistry(realRegistry);
                
                // add notifier
                java.util.Collection<org.apache.camel.management.JmxNotificationEventNotifier> jmxEventNotifiers = camelContext
                    .getRegistry().findByType(
                        org.apache.camel.management.JmxNotificationEventNotifier.class);
                if (jmxEventNotifiers != null && !jmxEventNotifiers.isEmpty()) {
                    camelContext.getManagementStrategy().addEventNotifier(
                        jmxEventNotifiers.iterator().next());
                }
                



                        
                    //read context values
                    readContextValues(contextStr);



		from("file://C:/StudentFiles/Route/input"+"?noop=true"+"&autoCreate=true"+"&flatten=false"+"&bufferSize=128")
.routeId("ConsumeFile_cFile_1_take_file")			.to("file://C:/StudentFiles/Route/output"+"?noop=true"+"&autoCreate=true"+"&flatten=false"+"&bufferSize=128")
.id("ConsumeFile_cFile_2_put_file");	}
	private org.apache.camel.main.Main main;

    private void run() throws java.lang.Exception {
        main = new org.apache.camel.main.Main() {

            protected CamelContext createCamelContext() {
                final org.apache.camel.impl.DefaultCamelContext camelContext =
                    new org.apache.camel.spring.SpringCamelContext(
                        new org.springframework.context.support.ClassPathXmlApplicationContext("META-INF/spring/consumefile.xml"));
                        camelContext.setName("ConsumeFile");
                        camelContext.getRegistry().bind("ConsumeFile", registry.lookupByName("ConsumeFile"));

						
                return camelContext;
            }
        };

        //add route
        
		main.bind("ConsumeFile", this);
		
        main.run();
    }

	public void stop() throws java.lang.Exception {
		if(main != null) {
			main.stop();
		}
	}

	public void shutdown() throws java.lang.Exception {
		if(main != null) {
			main.shutdown();
		}
	}

	

    
        private java.util.Dictionary<String, String> loadHttpConduitProperties(String configName) {
            Properties properties = new Properties();
            try (java.io.InputStream is = getConfigLocation(configName)) {
                properties.load(is);
            } catch (Exception e) {
                throw new RuntimeException("Cannot load the properties", e);
            }
            java.util.Dictionary<String, String> dic = new java.util.Hashtable<String, String>();
            for (Object key : properties.keySet()) {
                dic.put((String) key, properties.getProperty((String) key));
            }
            return dic;
        }
        
        public java.io.InputStream getConfigLocation(String fileName){
        
            java.io.InputStream stream = null;
            
            String configFile = "config/" + fileName;
            
            String configPath = env.getProperty("spring.config.additional-location");
            
            String file = "";
            if (configPath != null) {
                // get spring.config.additional-location from env
                file = configPath +java.io.File.separator+ fileName;
            } else {
                // by default from current "config" directory
                file = System.getProperty("user.dir") + java.io.File.separator + configFile;
            }

            java.io.File usersfile = new java.io.File(file);
            
            if (usersfile.exists()) {
                try{
                    stream = new java.io.FileInputStream(file);
                }catch(Exception e){
                    stream = this.getClass().getClassLoader().getResourceAsStream(configFile);
                }
            } else {
                stream = this.getClass().getClassLoader().getResourceAsStream(configFile);
            }
            
            return stream;
        }

        private static void loadConfig(Map<String,String> argsMap,String configName,String configValue){
            String configFileValue = "classpath:config/" + configValue;

            if (argsMap.get(configName) == null) {
                if (argsMap.get("--spring.config.additional-location") == null) {
                    argsMap.put(configName, configFileValue);
                } else {
                    String value = argsMap.get("--spring.config.additional-location") + java.io.File.separator + configValue;
    
                    if(new java.io.File(value).exists()){
                        argsMap.put(configName, "file:" + value);
                    }else{
                        if (argsMap.get("--spring.config.additional-location").contains(":")) {
                            try {
                                if (new java.io.File(new java.net.URI(value)).exists()) {
                                    argsMap.put(configName, value);
                                } else {
                                    argsMap.put(configName, configFileValue);
                                }
                            } catch (Exception e) {
                                argsMap.put(configName, configFileValue);
                            }
                        } else {
                            argsMap.put(configName, configFileValue);
                        }
                    }
                }
            }
        }

        private static String[] resetArgs(String... args){
            Map<String,String> argsMap = new HashMap<String,String>();

            for(int i=0;i<args.length;i++){
                String[] kv = args[i].split("=");
                if(kv.length > 1) {
                	argsMap.put(kv[0], kv[1]);
                }
            }

            if (argsMap.get("--spring.config.additional-location") != null) {
                System.setProperty("spring.config.additional-location",argsMap.get("--spring.config.additional-location"));
            }            
            loadConfig(argsMap,"--spring.banner.location","banner.txt");
            
            if (argsMap.get("--camel.springboot.typeConversion") == null) {
                argsMap.put("--camel.springboot.typeConversion", "false");
            }

            String[] resetArgs = new String[argsMap.size()];
            
            java.util.Set<String> keySet = argsMap.keySet();

            int idx = 0;
            
            for(String key:keySet){
                resetArgs[idx] =  key+"="+argsMap.get(key);
                idx++;
            }

            return resetArgs;
        }


        @org.springframework.beans.factory.annotation.Autowired
        private ContextProperties context;

        @org.springframework.boot.context.properties.ConfigurationProperties
        public static class ContextProperties {


                public String getProperty(String key) {
                    return getProperty(key, null);
                }
		
                public String getProperty(String key, String defaultValue) {
                    if (key != null && !key.isEmpty()) {
                        try {
                            java.lang.reflect.Method m = this.getClass()
                                .getDeclaredMethod("get" + Character.toUpperCase(key.charAt(0)) + key.substring(1));
                            Object o = m.invoke(this);
                            if(o != null){
                                return String.valueOf(o);
                            }else {
                                return defaultValue;
                            }
                        } catch (Exception e) {
                            return defaultValue;
                        }
                    }
                    return null;
                }
	}

	private static String contextStr = "Default";

	
	public void setContextName(String contextName){
		contextStr = contextName;
	}


	private final Properties context_param = new Properties();

    
        public static void main(String... args){
            String[] resetArgs = resetArgs(args);
            org.springframework.context.ApplicationContext applicationContext = new org.springframework.boot.SpringApplication(ConsumeFile.class).run(resetArgs);
            org.apache.camel.spring.boot.CamelSpringBootApplicationController applicationController = applicationContext.getBean(org.apache.camel.spring.boot.CamelSpringBootApplicationController.class);
            applicationController.blockMainThread();
        }
    

    @Override
    public String[][] runJob(String[] args) {
		int exitCode = runJobInTOS(args);
		return new String[][] { { Integer.toString(exitCode) } };
    }

    @Override
    public int runJobInTOS(String[] args) {
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

		try {
			run();
		} catch (java.lang.Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 0;
	}

    	//for the issue APPINT-34429
		/**
		 * read context values from specified context
		 * @parameter contextName : the name of context while will be used
		 */
		private void readContextValues(String contextName){
			
		}
    

	private void evalParam(String arg) {
        if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
        }else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
            }
        }
	}
}

