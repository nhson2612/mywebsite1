package model;

public class Product{
    private String productName;
    private String descrip;
    private String category;
    private int remainAmount;
    private int price;
    private int sellerId;
    private int buyerId;
    private int rate;

    public Product(String productName,String descrip,String category,int remainAmount,int sellerId,int buyerId,int rate){
        this.productName = productName;
        this.descrip = descrip;
        this.category = category;
        this.remainAmount = remainAmount;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.rate = rate;
    }

    public void setRate(int rate){
        this.rate = rate;
    }

    public void setBuyerId(int buyerId){
        this.buyerId = buyerId;
    }

    public void setSellerId(int sellerId){
        this.sellerId = sellerId;
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public void setDescrip(String descrip){
        this.descrip = descrip;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setRemainAmount(int remainAmount){
        this.remainAmount = remainAmount;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getRemainAmount(){
        return this.remainAmount;
    }

    public String getCategory(){
        return this.category;
    }
    public String getDescrip(){
        return this.descrip;
    }

    public String getProductName(){
        return this.productName;
    }

    public int getPrice(){
        return this.price;
    }

    public int getSellerId(){
        return this.sellerId;
    }

    public int getBuyerId(){
        return this.buyerId;
    }

    public int getRate(int rate){
        this.rate = rate;
        return rate;
    }
}
