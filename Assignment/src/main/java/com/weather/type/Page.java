package com.weather.type;

public enum Page {
	
	INDEX("index"), HOME("home");

	private final String page;

	private Page(final String page) {
		this.page = page;
	}

	Page() {
		page = null;
	}

	/**
	 * toString method.
	 * 
	 * @return Value of this Enum as String.
	 */
	@Override
	public String toString() {
		return page;
	}
}
