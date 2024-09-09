package com.ixo.movieinfo.exception;


public class ResourceNotFoundException extends RuntimeException{
	private String resourceType;
	private String resourceName;
	private Integer resourceValue;
	
	public ResourceNotFoundException(String resourceType, String resourceName, Integer resourceValue) {
		super(String.format("%s not found with %s : %s ", resourceType, resourceName, resourceValue));
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.resourceValue = resourceValue;
	}
}
