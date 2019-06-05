package com.example.webdevs1serverjava.model;

public class Widget {
    private Long id;
    private String name;
    private Type type;
    private String text;
    private String srcUrl;
    private String cssClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Widget() {
    }

    /**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the srcUrl
	 */
	public String getSrcUrl() {
		return srcUrl;
	}

	/**
	 * @param srcUrl the srcUrl to set
	 */
	public void setSrcUrl(String srcUrl) {
		this.srcUrl = srcUrl;
	}

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Widget(Long id, String name, Type type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

	public Widget(Long id, String name, Type type, String text, String srcUrl, String cssClass) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.text = text;
		this.srcUrl = srcUrl;
		this.cssClass = cssClass;
	}
    
}