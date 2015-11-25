package com.shireapps.ian.hikulogin;


public class Data {
	private ProductOrder[] productOrder;

    private Regulars[] regulars;

    private String productCount;

    private List[] list;


    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProductOrder[] getProductOrder ()
    {
        return productOrder;
    }

    public void setProductOrder (ProductOrder[] productOrder)
    {
        this.productOrder = productOrder;
    }

    public Regulars[] getRegulars ()
    {
        return regulars;
    }

    public void setRegulars (Regulars[] regulars)
    {
        this.regulars = regulars;
    }

    public String getProductCount ()
    {
        return productCount;
    }

    public void setProductCount (String productCount)
    {
        this.productCount = productCount;
    }

    public List[] getList ()
    {
        return list;
    }

    public void setList (List[] list)
    {
        this.list = list;
    }
}
