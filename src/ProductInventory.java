public class ProductInventory {
    ProductNode inventoryHead = new ProductNode();
    public void showInventory()
    {
        if(inventoryHead==null) {
            System.out.println("Iventory is empty, add iteams to inventory");
        }
        ProductNode tmp = inventoryHead.next;
        while (tmp != null) {
            System.out.println(tmp.toString());
            tmp = tmp.next;
        }
    }
    public int getTotalQuantity()
    {
        int Quantity=0;
        ProductNode tmp = inventoryHead;
        if(tmp==null) {
            return 0;
        }
        while(tmp!=null) {
            Quantity += tmp.productQuantity;
            tmp=tmp.next;
        }

        return Quantity;
    }
    public ProductNode removeMaximum()
    {
        ProductNode Node = null;
        ProductNode MaxNode = null;
        if(inventoryHead.next != null) {
            ProductNode cur = inventoryHead.next;
            ProductNode per = inventoryHead;
            MaxNode = per;
            Node = cur;
            while(cur != null) {
                if(cur.productQuantity > Node.productQuantity) {
                    Node = cur;
                    MaxNode = per;
                }
                per = cur;
                cur = cur.next;
            }
            MaxNode.next = Node.next;
        }
        return Node;
    }
    public void sortInventory()
    {
        if(inventoryHead.next != null) {
            ProductInventory ivnSort = new ProductInventory();
            while(inventoryHead.next != null) {
                ProductNode Node = removeMaximum();
                ivnSort.addProduct(Node.productName,Node.productLocator,Node.productQuantity,Node.productPrice);
            }
            inventoryHead.next = ivnSort.inventoryHead.next;
        }
    }
    public void addProduct(String productName, String locator, int quantity, double price)
    {
        ProductNode Node = new ProductNode(productName, locator, quantity, price);
        if (inventoryHead == null) {
            inventoryHead = Node;
        }
        else {
            ProductNode nodeLast = inventoryHead;
            while (nodeLast.next != null) {
                nodeLast = nodeLast.next;
            }
            nodeLast.next = Node;
        }
    }
    public void removeProduct(String productName, String locator)
    {
        if(inventoryHead.next != null) {
            ProductNode cur = inventoryHead.next;
            ProductNode per = inventoryHead;
            while(cur != null) {
                if(cur.productLocator.equalsIgnoreCase(locator) && cur.productName.equalsIgnoreCase(productName)) {
                    if(per == inventoryHead) {
                        inventoryHead.next = cur.next;
                    }
                    else{
                        per.next = cur.next;
                    }
                    break;
                }
                per = cur;
                cur = cur.next;
            }
        }
    }
    public int countProduct(String productName)
    {
        int countProduct = 0;
        ProductNode node = inventoryHead;
        while (node != null) {
            if (productName.equalsIgnoreCase(node.productName)) {
                countProduct += node.productQuantity;
            }
            node = node.next;
        }
        return countProduct;
    }
    public int countNeededQuantity(String productName, int neededQuantity)
    {
        int Quantity = countProduct(productName);
        return neededQuantity-Quantity;
    }
    class ProductException extends RuntimeException {
        public ProductException(String s) {
            super(s);
        }
    }
}
