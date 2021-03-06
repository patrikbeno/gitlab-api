package com.messners.gitlab.api;

import java.net.URL;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.representation.Form;

/**
 * This class is the base class for all the sub API classes.  It provides implementations of 
 * delete(), get(), post() and put() that are re-used by all the sub-classes. 
 * 
 * @author Greg Messner <greg@messners.com>
 *
 */
public abstract class AbstractApi {

	private GitLabApi gitLabApi;
	
	public AbstractApi (GitLabApi gitLabApi) {
		this.gitLabApi = gitLabApi;
	}

	protected GitLabApiClient getApiClient () {
		return (gitLabApi.getApiClient());
	}	
	
	
	/**
	 * Perform an HTTP GET call with the specified query parameters and path objects, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 * 
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param queryParams
	 * @param pathArgs
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected  ClientResponse get (ClientResponse.Status expectedStatus, MultivaluedMap<String, String> queryParams, Object ... pathArgs) 
			throws GitLabApiException {	
		
		ClientResponse response = null;
		try {			
			response = getApiClient().get(queryParams, pathArgs);			
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}	
	
	
	/**
	 * Perform an HTTP GET call with the specified query parameters and URL, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 * 
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param queryParams
	 * @param url
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected ClientResponse get (ClientResponse.Status expectedStatus, MultivaluedMap<String, String> queryParams, URL url) 
			throws GitLabApiException {		
		
		ClientResponse response = null;
		try {			
			response = getApiClient().get(queryParams, url);			
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}	
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}		
	
	
	/**
	 * Perform an HTTP POST call with the specified form data and path objects, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 * 
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param formData
	 * @param pathArgs
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected ClientResponse post (ClientResponse.Status expectedStatus, Form formData, Object ... pathArgs) throws GitLabApiException {
		
		ClientResponse response = null;
		try {			
			response = getApiClient().post(formData, pathArgs);			
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}	
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}
	
	
	/**
	 * Perform an HTTP POST call with the specified form data and URL, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 * 
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param formData
	 * @param url
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected ClientResponse post (ClientResponse.Status expectedStatus, Form formData, URL url) throws GitLabApiException {
		
		ClientResponse response = null;
		try {			
			response = getApiClient().post(formData, url);
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}
	

	/**
	 * Perform an HTTP PUT call with the specified form data and path objects, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 * 
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param queryParams
	 * @param pathArgs
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected  ClientResponse put (ClientResponse.Status expectedStatus, MultivaluedMap<String, String> queryParams, Object ... pathArgs) throws GitLabApiException {
		
		ClientResponse response = null;
		try {			
			response = getApiClient().put(queryParams, pathArgs);				
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}	
	
	
	/**
	 * Perform an HTTP PUT call with the specified form data and URL, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 *  
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param queryParams
	 * @param url
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected ClientResponse put (ClientResponse.Status expectedStatus, MultivaluedMap<String, String> queryParams, URL url) throws GitLabApiException {	
		
		ClientResponse response = null;
		try {			
			response = getApiClient().put(queryParams, url);			
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}	
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}	
	
	
	/**
	 * Perform an HTTP DELETE call with the specified form data and path objects, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 *
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param queryParams
	 * @param pathArgs
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected  ClientResponse delete (ClientResponse.Status expectedStatus, MultivaluedMap<String, String> queryParams, Object ... pathArgs)
			throws GitLabApiException {
		
		ClientResponse response = null;
		try {			
			response = getApiClient().delete(queryParams, pathArgs);			
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}	
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}	
	
	
	/**
	 * Perform an HTTP DELETE call with the specified form data and URL, returning 
	 * a ClientResponse instance with the data returned from the endpoint.
	 *  
	 * @param expectedStatus the HTTP status that should be returned from the server
	 * @param queryParams
	 * @param url
	 * @return a ClientResponse instance with the data returned from the endpoint
	 * @throws GitLabApiException
	 */
	protected ClientResponse delete (ClientResponse.Status expectedStatus, MultivaluedMap<String, String> queryParams, URL url) throws GitLabApiException {
		
		ClientResponse response = null;
		try {			
			response = getApiClient().delete(queryParams, url);	
		} catch (Exception e) {
			throw (new GitLabApiException(e));
		}
		
		if (response.getStatus() != expectedStatus.getStatusCode()) {
			throw (new GitLabApiException(response));			
		}
		
		return (response);
	}

	
	/**
	 * Convenience method for adding query and form parameters to a get() or post() call.
	 * 
	 * @param formData
	 * @param name
	 * @param value
	 */
	protected void addFormParam(Form formData, String name, Object value) throws IllegalArgumentException {
		addFormParam(formData, name, value, false);
	}


	/**
	 * Convenience method for adding query and form parameters to a get() or post() call.  
	 * If required is true and value is null, will throw an IllegalArgumentException.
	 * 
	 * @param formData
	 * @param name
	 * @param value
	 * @param required
	 * @throws IllegalArgumentException if a required parameter is null or empty
	 */
	protected void addFormParam(Form formData, String name, Object value, boolean required) throws IllegalArgumentException {
		
			if (value == null) {
				
				if (required) {
					throw new IllegalArgumentException(name + " cannot be empty or null");
				}
				
				return;
			}
			
			String stringValue = value.toString().trim();
			if (required && stringValue.length() == 0) {
				throw new IllegalArgumentException(name + " cannot be empty or null");
			}
			
			formData.add(name, stringValue);		
	}
}
