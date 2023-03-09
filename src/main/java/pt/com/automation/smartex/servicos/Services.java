package pt.com.automation.smartex.servicos;

public interface Services {
	
	Responsee getEndpoint(String endPoint);
	Responsee postEndpoint(String endPoint,Object message);
	Responsee putEndPoint(String endPoint,Object message);
	Responsee deleteEndpoint(String endPoint);

}
