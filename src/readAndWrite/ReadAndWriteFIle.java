package readAndWrite;

import model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteFIle {
    File file = new File("data/product.csv");

    public void WriteFile(ArrayList<Product> listProduct) {
        try {
            FileWriter fileWriter = new FileWriter("data/product.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product : listProduct) {
                line += product.getId() + "," + product.getNameProduct() + "," + product.getQuantity() + "," + product.getPrice() + "," + product.getDescribe() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Product> ReadFile() {
        ArrayList<Product> listProductNew = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Product product = new Product(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), data[4]);
                listProductNew.add(product);
            }
            bufferedReader.close();
        } catch (IOException | RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return listProductNew;
    }
}
