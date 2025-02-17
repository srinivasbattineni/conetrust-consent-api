package com.java.springboot.consentApi.dto;

import java.util.List;

public class ConsentRequest {
	private String identifier;
	private String requestInformation;
	private String identifierType;
	private List<Purpose> purposes;

	// Getters and Setters
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getRequestInformation() {
		return requestInformation;
	}

	public void setRequestInformation(String requestInformation) {
		this.requestInformation = requestInformation;
	}

	public String getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}

	public List<Purpose> getPurposes() {
		return purposes;
	}

	public void setPurposes(List<Purpose> purposes) {
		this.purposes = purposes;
	}

	// Inner class for Purposes
	public static class Purpose {
		private String id;
		private String transactionType;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getTransactionType() {
			return transactionType;
		}

		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
	}
}
