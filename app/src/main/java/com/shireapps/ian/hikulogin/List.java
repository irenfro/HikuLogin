package com.shireapps.ian.hikulogin;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class List implements Parcelable{
	private String id;

    private int ean;

    private String[] retailers;

    private String aisle_id;

    private String product_id;

    private String dateLastModifyLong;

    private String status;

    private String flFavorite;

    private String name;

    private String quantity;

    private String dateCreate;

    private String aisleName;

    private String[] listTags;


    public List(Parcel in){
        String[] data= new String[13];

        in.readStringArray(data);
        this.id = data[0];
        try {
            this.ean = Integer.parseInt(data[1]);
        } catch (NumberFormatException e) {
        }
        this.retailers = data[2].substring(1, data[2].length() - 1).split(", ");
        this.aisle_id = data[3];
        this.product_id = data[4];
        this.dateLastModifyLong = data[5];
        this.status = data[6];
        this.flFavorite = data[7];
        this.name = data[8];
        this.quantity = data[9];
        this.dateCreate = data[10];
        this.aisleName = data[11];
        this.listTags = data[12].substring(1, data[12].length() - 1).split(", ");
    }

    @Override
    public int describeContents() {
// TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
// TODO Auto-generated method stub

        dest.writeStringArray(new String[]{this.id, String.valueOf(this.ean), Arrays.toString(this.retailers),
                this.aisle_id, this.product_id, this.dateLastModifyLong, this.status, this.flFavorite,
                this.name, this.quantity, this.dateCreate, this.aisleName, Arrays.toString(this.listTags)});
    }

    public static final Parcelable.Creator<List> CREATOR= new Parcelable.Creator<List>() {

        @Override
        public List createFromParcel(Parcel source) {
// TODO Auto-generated method stub
            return new List(source);  //using parcelable constructor
        }

        @Override
        public List[] newArray(int size) {
// TODO Auto-generated method stub
            return new List[size];
        }
    };

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public int getEan ()
    {
        return ean;
    }

    public void setEan (int ean)
    {
        this.ean = ean;
    }

    public String[] getRetailers ()
    {
        return retailers;
    }

    public void setRetailers (String[] retailers)
    {
        this.retailers = retailers;
    }

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

    public String getDateLastModifyLong ()
    {
        return dateLastModifyLong;
    }

    public void setDateLastModifyLong (String dateLastModifyLong)
    {
        this.dateLastModifyLong = dateLastModifyLong;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getFlFavorite ()
    {
        return flFavorite;
    }

    public void setFlFavorite (String flFavorite)
    {
        this.flFavorite = flFavorite;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getQuantity ()
    {
        return quantity;
    }

    public void setQuantity (String quantity)
    {
        this.quantity = quantity;
    }

    
    public String getDateCreate ()
    {
        return dateCreate;
    }

    public void setDateCreate (String dateCreate)
    {
        this.dateCreate = dateCreate;
    }

    public String getAisleName ()
    {
        return aisleName;
    }

    public void setAisleName (String aisleName)
    {
        this.aisleName = aisleName;
    }

    public String[] getListTags ()
    {
        return listTags;
    }

    public void setListTags (String[] listTags)
    {
        this.listTags = listTags;
    }

    public String toString() {
        return "name: " + name;
    }

    public List() {

    }
}
