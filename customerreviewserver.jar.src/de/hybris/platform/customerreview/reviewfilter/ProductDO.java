package de.hybris.platform.customerreview.reviewfilter;

final public class ProductDO {
    private double rating;
    private String customerName;
 
    public double getRating() {
        return rating;
    }
 
    public void setRating(double rating) {
        this.rating = rating;
    }
 
    public String getCustomerName() {
        return customerName;
    }
 
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
 
    public ProductDO (){}
 
    public ProductDO(double rating, String customerName) {
        this.rating = rating;
        this.customerName = customerName;
    }
 
    @Override
    public String toString() {
        return "ProductModel{" +
                "rating= " + rating +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
