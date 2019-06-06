package com.example.webdevs1serverjava.model;

public class Widget {
    private long id;
    private String name;
    private Type type;
    private int order;
    private String text;
    private String srcUrl;
    private String cssClass;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Widget(Long id, String name, Type type,int order, String text, String srcUrl) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.text = text;
		this.order =order;
		this.srcUrl = srcUrl;
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
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public Widget(Long id, String name, Type type,int order) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.order =order;
    }

	public Widget(Long id, String name, Type type, int order,String text, String srcUrl, String cssClass) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.order =order;
		this.text = text;
		this.srcUrl = srcUrl;
		this.cssClass = cssClass;
	}

	public Widget(long id, String name, Type type, int order, String text, String cssClass) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.order =order;
		this.text = text;
		this.cssClass=cssClass;
	}
	public Widget(long id, String name, Type type, int order, String text) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.order =order;
		this.text = text;
	}
    
}