package eu.trentorise.smartcampus.services.ordinanzerovereto.impl;

import it.sayservice.platform.core.bus.service.compiler.InvokeConnector;
import it.sayservice.platform.core.bus.service.compiler.InvokeDataFlowScriptNode;
import it.sayservice.platform.core.bus.service.dataflow.ServiceDataFlow;
import java.util.ArrayList;
import java.io.Reader;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.w3c.dom.Document;
import bsh.Interpreter;
import bsh.EvalError;
import bsh.ParseException;
import bsh.TargetError;
import com.google.protobuf.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import it.sayservice.platform.core.bus.common.exception.*;
import javax.script.ScriptException;
import it.sayservice.platform.core.bus.service.ServiceMethod;
import it.sayservice.platform.core.i18n.ExceptionMessage;
import it.sayservice.platform.core.bus.service.compiler.InvokeGeolocalize;
import it.sayservice.platform.core.bus.service.compiler.InvokeScript;
import it.sayservice.platform.core.bus.service.compiler.InvokeMerge;
import it.sayservice.platform.core.bus.service.compiler.InvokeConstructor;
import it.sayservice.platform.core.bus.service.compiler.InvokeFilter;
import it.sayservice.platform.core.bus.service.compiler.InvokeTransformer;
import it.sayservice.platform.core.bus.service.compiler.InvokeVariableValidation;
import it.sayservice.platform.core.message.ProtoBean;


/**
*
* Generated DataFlow class: DO NOT EDIT!
*
*/
public class GetOrdinanzeDataFlow implements ServiceDataFlow {

	private final transient Log log = LogFactory.getLog(this.getClass());


	private String data;

	private ServiceMethod serviceMethod;

	public GetOrdinanzeDataFlow () {
		super();
	}

	public void setServiceMethod(ServiceMethod serviceMethod) {
		this.serviceMethod = serviceMethod;	
	}

	public List<Message> invoke(String serviceExecutionId, Map<String, Object> parameters) throws DataFlowException {
		Map<String, Object> contextVariables = new java.util.HashMap<String,Object>();
	contextVariables.put("data", data);


		List<Message> output = new java.util.ArrayList<Message>();
		try {

		
		//Connector (HTTP)
		it.sayservice.platform.core.bus.service.connector.HTTPConnector connector = new it.sayservice.platform.core.bus.service.connector.HTTPConnector();
		connector.setSessionSupport("REQUIRED", null);
		connector.setPost(false);
		connector.setEncoding("ISO-8859-1");

		//Connect
		connector.setUrl((String)InvokeScript.invoke("\"http://www2.comune.rovereto.tn.it/iride/extra/ordinanze_gps/json/\"", contextVariables));
		try {
			InvokeConnector<java.io.Reader> connectorInvoker = new InvokeConnector<java.io.Reader>();
			java.io.Reader connectResult1 = connectorInvoker.invoke(connector, "connector", "data", serviceExecutionId, serviceMethod);
			it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer connectTransformer1 = new it.sayservice.platform.core.bus.service.transformer.ReaderToStringTransformer();
			data = (String)connectTransformer1.transform(connectResult1);
			contextVariables.put("data", data);
			InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "data", data);
			} catch (ConnectorException e0) {
				log.error("DataFlow Error: " + e0.getClass().getName());
				throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e0);
			} catch (TransformerException e1) {
				log.error("DataFlow Error: " + e1.getClass().getName());
				throw new DataFlowException(ExceptionMessage.CONNECTION_ERROR, e1);
			}

		//Script
		{
		try {
			java.util.List<?> scriptResult1 = (java.util.List<?>)InvokeDataFlowScriptNode.invoke(eu.trentorise.smartcampus.services.ordinanzerovereto.impl.Script.class, "createOrdinanze", "data", contextVariables, serviceExecutionId, serviceMethod);
			output = (List<Message>)scriptResult1;
			contextVariables.put("output", output);
			InvokeVariableValidation.validate(serviceMethod, serviceExecutionId, "output", output);
			} catch (Exception e0) {
				log.error("DataFlow Error: " + e0.getClass().getName());
				throw new DataFlowException(ExceptionMessage.TRANSFORMER_ERROR, e0);
			}
		}

	return output;
	} catch (ParseException pe) {
		log.error("Script Error: Parse Exception.", pe);
		throw new DataFlowException(pe.getMessage(), pe);
	} catch (EvalError ee) {
		log.error("Script Error: Eval Error.", ee);
		throw new DataFlowException(ee.getMessage(), ee);
	} catch (Exception e) {
		if (e instanceof DataFlowException) {
			throw (DataFlowException)e;
		} else {
			log.error("Unexpected Error", e);
			throw new DataFlowException(e.getMessage(), e);
		}
	}
	}

	public Message.Builder getOutputBuilder() {
		return eu.trentorise.smartcampus.services.ordinanzerovereto.data.message.Ordinanzerovereto.Ordinanza.newBuilder();
	}

	public void resetXSS() {
	}

}
