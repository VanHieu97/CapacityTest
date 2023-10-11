package model;

public class Product {
    private String id;
    private String nameProduct;
    private int price;
    private int quantity;
    private String describe;

    public Product(String id, String nameProduct, int price, int quantity, String describe) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product{" +
                "Mã Sản Phẩm='" + id + '\'' +
                ", Tên Sản Phẩm='" + nameProduct + '\'' +
                ", Giá=" + price +
                ", Số Lượng=" + quantity +
                ", Mô Tả='" + describe + '\'' +
                '}';
    }
}
