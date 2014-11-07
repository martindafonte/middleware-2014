package fing.midd;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService(targetNamespace="prueba2", portName="Sender", serviceName="BancoSender", endpointInterface="fing.midd.IService")
@Addressing
public interface IService {
	@WebMethod
	public abstract void receive(long id, fing.midd.Transaction[] transaction)
			throws java.rmi.RemoteException;

}