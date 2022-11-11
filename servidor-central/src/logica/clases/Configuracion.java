package logica.clases;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuracion{
	private static Configuracion instancia = null;
	private String homeDir;
	private String publishURL;
	private String filePath;
	private Properties propiedades;
	
	private Configuracion() {
		homeDir = System.getProperty("user.home");
		
		// create and load default properties
		Properties defaultProps = new Properties();
		
		try {
		FileInputStream in = new FileInputStream(homeDir + "/.turismoUy/servidor_default.properties");
		defaultProps.load(in);
		in.close();

		// create application properties with default
		Properties applicationProps = new Properties(defaultProps);

		// now load properties 
		// from last invocation
		in = new FileInputStream(homeDir + "/.turismoUy/servidor.properties");
		applicationProps.load(in);
		in.close();
		
		String host = applicationProps.getProperty("host");
		String port = applicationProps.getProperty("port");
		String path = applicationProps.getProperty("path");
		publishURL = "http://" + host + ":" + port + path;
		
		filePath = homeDir + applicationProps.getProperty("file_path");
		
		propiedades = applicationProps;
		
		System.out.println(filePath);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			publishURL = "http://localhost:9128/webservices";
			filePath = "";
			propiedades = null;
		}
		
		
	}
	
	public static Configuracion getInstance() {
		if(instancia == null)
			instancia = new Configuracion();
		return instancia;
	}
	
	public String getHomeDir() {
		return homeDir;
	}
	
	public String getPublishURL() {
		return publishURL;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public Properties getPropiedades() {
		return propiedades;
	}
}