package com.shireapps.ian.hikulogin;


public class Regulars {
	 private String aisle_id;

	    private String product_id;

	    private String aisle;

	    private String name;

	    private String[] listTags;

	    public String getAisle_id ()
	    {
	        return aisle_id;
	    }

	    public void setAisle_id (String aisle_id)
	    {
	        this.aisle_id = aisle_id;
	    }

	    public String getProduct_id ()
	    {
	        return product_id;
	    }

	    public void setProduct_id (String product_id)
	    {
	        this.product_id = product_id;
	    }

	    public String getAisle ()
	    {
	        return aisle;
	    }

	    public void setAisle (String aisle)
	    {
	        this.aisle = aisle;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String[] getListTags ()
	    {
	        return listTags;
	    }

	    public void setListTags (String[] listTags)
	    {
	        this.listTags = listTags;
	    }

	    @Override
	    public String toString()
	    {
	        return "[aisle_id = "+aisle_id+", product_id = "+product_id+", aisle = "+aisle+", name = "+name+", listTags = "+listTags+"]";
	    }
}
