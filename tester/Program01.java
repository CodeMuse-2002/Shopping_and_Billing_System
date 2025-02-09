
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.CustomerDAO;
import dao.ProductDAO;
import entities.*;
import exceptions.ProductNotFoundException;
import utils.DbUtil;

class Contents {
	public static final int ADD = 1;
	public static final int UPDATE = 2;
	public static final int SORT = 3;
	public static final int SEARCH = 4;
	public static final int ADDP = 5;
}

public class Program01 {

	public static void addCustomer(Scanner sc) {
		System.out.println("Name: ");
		String name = sc.next();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Password: ");
		String password = sc.next();
		Customer_tb c = new Customer_tb(name, email, password);
		try (CustomerDAO customerDAO = new CustomerDAO()) {
			customerDAO.addCustomer(c);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateCustomerName(Scanner sc) {
		System.out.println("Customer Name: ");
		String name = sc.next();
		System.out.println("Customer Id: ");
		int id = sc.nextInt();
		try (CustomerDAO customerDAO = new CustomerDAO()) {
			customerDAO.updateCustomer(name, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sortProduct() {

		try (ProductDAO productDAO = new ProductDAO()) {
			List<Product_tb> p = productDAO.getProductSorted();
			for (Product_tb element : p) {
				System.out.println(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void addProduct(Scanner sc) {
		System.out.println("Product Name: ");
		String pname = sc.next();
		System.out.println("Price : ");
		double price = sc.nextDouble();
		System.out.println("User Id : ");
		int id = sc.nextInt();
		Product_tb p = new Product_tb(pname, price, id);
		try (ProductDAO productDAO = new ProductDAO()) {
			productDAO.addProduct(p);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getBill(Scanner sc) {
		System.out.print("Enter User id: ");
		int id = sc.nextInt();
		try (ProductDAO productDAO = new ProductDAO()) {
			productDAO.generateBill(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchProduct(Scanner sc) {
		System.out.println("Product Id : ");
		int id = sc.nextInt();
		Product_tb p = new Product_tb(id);
		try (ProductDAO productDAO = new ProductDAO()) {
			List<Product_tb> p1 = productDAO.searchProduct(id);
			if (p1.isEmpty()) {
				throw new ProductNotFoundException("Product not found");
			} else {
				for (Product_tb element : p1) {
					System.out.println(element);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int menu(Scanner sc) {
		System.out.println();
		System.out.println("0. EXIT");
		System.out.println("1. Add Customer");
		System.out.println("2. Update Customer Details");
		System.out.println("3. Sort Product by their Price and PurchaseDate");
		System.out.println("4. Search Product by Name");
		System.out.println("5. Add Products in a Cart and Generate Bill");
		System.out.print("ENTER YOUR CHOICE: ");
		return sc.nextInt();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		while ((choice = menu(sc)) != 0) {
			switch (choice) {
				case Contents.ADD: {
					addCustomer(sc);
					break;
				}

				case Contents.UPDATE: {
					updateCustomerName(sc);
					break;
				}

				case Contents.SORT: {
					sortProduct();
					break;
				}

				case Contents.SEARCH: {
					searchProduct(sc);
					break;
				}

				case Contents.ADDP: {
					addProduct(sc);
					getBill(sc);
					break;
				}
			}
		}
	}

}
