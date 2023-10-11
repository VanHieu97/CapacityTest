package model;

import controler.IProduct;
import readAndWrite.ReadAndWriteFIle;

import java.util.ArrayList;

public class ManagerProduct implements IProduct<Product> {
    ReadAndWriteFIle readAndWriteFIle;
    ArrayList<Product> listProduct;

    public ManagerProduct() {
        readAndWriteFIle = new ReadAndWriteFIle();
        this.listProduct = readAndWriteFIle.ReadFile();

    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return listProduct;

    }

    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
        readAndWriteFIle.WriteFile(listProduct);
    }

    @Override
    public void editProduct(String id, Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId().equals(id)) {
                listProduct.set(i, product);
            }
        }
        readAndWriteFIle.WriteFile(listProduct);
    }

    @Override
    public void deleteProduct(String id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId().equals(id)) {
                listProduct.remove(i);
            }
        }
        readAndWriteFIle.WriteFile(listProduct);
    }

    @Override
    public Product findProductByPriceMax() {
        Product ProductMax = listProduct.get(0);
        for (Product product : listProduct) {
            if (product.getPrice() > ProductMax.getPrice()) {
                ProductMax = product;
            }
        }
        return ProductMax;
    }

    public int findIndex(String id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public void sortByPriceUp() {
        listProduct.sort((o1, o2) -> o1.getPrice() - o2.getPrice());
    }
}
