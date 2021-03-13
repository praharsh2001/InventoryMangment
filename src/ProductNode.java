public class ProductNode {
    String productName;
    String productLocator;
    int productQuantity;
    double productPrice;

    ProductNode next;
    ProductNode()
    {
        next= null;
        productName="";
        productLocator="";
        productQuantity=0;
        productPrice=0.0;
    }
    ProductNode(String productName, String productLocator, int productQuantity, double productPrice)
    {
        this.productName=productName;
        this.productLocator=productLocator;
        this.productQuantity=productQuantity;
        this.productPrice=productPrice;
    }
    public String toString() {
        return productName+"   "+productLocator+"  "+productQuantity+"   "+productPrice;
    }
}
