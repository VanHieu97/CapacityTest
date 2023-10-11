package controler;

import model.Product;

import java.util.ArrayList;

public interface IProduct<E> {
    ArrayList<E> getAllProduct();
    void addProduct(E e);
    void editProduct(String id, E e);
    void deleteProduct(String id);
    Product findProductByPriceMax();
    void sortByPriceUp();
}
