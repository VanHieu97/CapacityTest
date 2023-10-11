package view;

import model.ManagerProduct;
import model.Product;
import validate.Validate;

import java.util.Scanner;

public class Menu {
    ManagerProduct managerProduct = new ManagerProduct();
    Scanner inputStr = new Scanner(System.in);
    Scanner inputNumber = new Scanner(System.in);

    public void MenuProduct() {
        boolean run = true;
        while (run) {
            System.out.println("===== Cửa Hàng Tạp Hóa PEW PEW ====");
            System.out.println("1: Xem Tất Cả Sản Phẩm");
            System.out.println("2: Thêm Sản Phẩm");
            System.out.println("3: Sửa Sản Phẩm");
            System.out.println("4: Xóa Sản Phẩm");
            System.out.println("5: Sắp Xếp Sản Phẩm Theo Giá Tăng Dần");
            System.out.println("6: Sản Phẩm Giá Cao Nhất Trong Tiệm");
            System.out.println("0: Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Validate.checkChoice();
            switch (choice) {
                case 1:
                    getAllProduct();
                    MenuShowInfo();
                    break;
                case 2:
                    formAddProduct();
                    break;
                case 3:
                    Edit();
                    break;
                case 4:
                    formDelete();
                    break;
                case 5:sortByPriceUp();
                    break;
                case 6:getProductMaxPrice();
                    break;
                default:
                    run = false;
            }
        }
    }

    public void MenuShowInfo() {
        boolean run = true;
        while (run) {
            System.out.println("===== Cửa Hàng Tạp Hóa PEW PEW ====");
            System.out.println("2: Thêm Sản Phẩm");
            System.out.println("3: Sửa Sản Phẩm");
            System.out.println("4: Xóa Sản Phẩm");
            System.out.println("0: Thoát");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = Validate.checkChoice();
            switch (choice) {
                case 2:
                    formAddProduct();
                    break;
                case 3:
                    Edit();
                    break;
                case 4:
                    formDelete();
                    break;
                default:
                    run = false;
            }
        }
    }

    public void getAllProduct() {
        int count = 0;
        System.out.println("<==== Danh Sách Sản Phẩm Trong Tiệm ====>");
        for (Product product : managerProduct.getAllProduct()) {
            System.out.println(product);
            count++;
            if (count == 5) {
                System.out.println("Nhấn Enter để tiếp tục xem");
                count = 0;
                inputStr.nextLine();
            }
        }
    }

    public void formAddProduct() {
        System.out.println("==== Thêm Sản Phẩm Mới ====");
        System.out.println("Nhập vào Mã Sản Phẩm - Ví Du: HD1");
        String ID = Validate.checkID();
        System.out.println("Nhập vào Tên Sản Phẩm -  Ví Dụ: Hàu Sữa");
        String name = Validate.checkName();
        System.out.println("Nhập vào Giá Sản Phẩm - Ví Dụ: 300");
        int price = Validate.Price();
        System.out.println("Nhập vào Số Lượng Sản Phẩm - Ví Dụ: 10");
        int quantity = Validate.checkSoL();
        System.out.println("Mô Tả Sản Phẩm - Ví Dụ: Thực Phẩm Chức Năng");
        String type = inputStr.nextLine();
        Product product = new Product(ID, name, price, quantity, type);
        managerProduct.addProduct(product);
        System.out.println("Thêm Thành Công!");
    }

    public void Edit() {
        System.out.println("=== Sửa Sản Phẩm ===");
        System.out.println("Nhập vào Mã Sản Phẩm Muốn Sửa - Ví Dụ: HD1");
        String ID = Validate.checkID();
        if (managerProduct.findIndex(ID) != -1) {
            System.out.println("Nhập vào Mã Sản Phẩm - Ví Du: HD1");
            String id = Validate.checkID();
            System.out.println("Nhập vào Tên Sản Phẩm -  Ví Dụ: Hàu Sữa");
            String name = Validate.checkName();
            System.out.println("Nhập vào Giá Sản Phẩm - Ví Dụ: 300");
            int price = Validate.Price();
            System.out.println("Nhập vào Số Lượng Sản Phẩm - Ví Dụ: 10");
            int quantity = Validate.checkSoL();
            System.out.println("Mô Tả Sản Phẩm - Ví Dụ: Thực Phẩm Chức Năng");
            String type = inputStr.nextLine();
            Product product = new Product(id, name, price, quantity, type);
            managerProduct.editProduct(ID, product);
            System.out.println("Sửa Thành Công");
        } else {
            System.out.println("Không Tìm Thấy Mã Sản Phẩm Muốn Sửa!");
        }
    }

    public void formDelete() {
        System.out.println("===Xóa Sản Phẩm===");
        System.out.println("Nhập vào Mã Sản Phẩm Muốn Xóa - Ví Dụ: HD1");
        String id = inputStr.nextLine();
        System.out.println("Bạn Có Muốn Xóa Không? <Yes Or No>");
        String Y = inputStr.nextLine();
        String Y1 = "Yes";
        String N1 = "No";
        if (Y1.equals(Y)) {
            if (managerProduct.findIndex(id) != -1) {
                managerProduct.deleteProduct(id);
                System.out.println("Xóa Thành Công!");
            } else {
                System.out.println("Không Tìm Thấy Mã Phòng Muốn Xóa!");
            }
        } else {
            return;
        }
    }

    public void getProductMaxPrice() {
        System.out.println("<=== Sản Phẩm Có Giá Cao Nhất ===>");
        System.out.println(managerProduct.findProductByPriceMax());
        System.out.println("===================");
    }

    public void sortByPriceUp() {
        System.out.println("<=== Danh Sách Sản Phẩm Theo Giá Tăng Dần ===>");
        managerProduct.sortByPriceUp();
        for (Product product : managerProduct.getAllProduct()) {
            System.out.println(product);
        }
    }
}

