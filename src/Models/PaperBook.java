package Models;

import Models.intefraces.Purchasable;
import Models.intefraces.Shippable;
import Models.intefraces.Deliverable;

public class PaperBook extends  Book implements Shippable , Purchasable, Deliverable {
    private int quantityInStock;
    public PaperBook(String isbn, String title, int publishedYear, float price, String author , int quantityInStock) {
        super(isbn, title, publishedYear, price, author);
        this.quantityInStock = quantityInStock;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        if (this.quantityInStock < quantityInStock) throw new RuntimeException("Quantum book store: Not enough in the stock.");
        this.quantityInStock -= quantityInStock;
    }
    @Override
    public boolean isPurchasable() {
        return quantityInStock > 0;
    }
    @Override
    public void ship(String address) {
        System.out.println("Quantum book store: Shipping to " + address);
    }
    @Override
    public void deliver(String email, String address) {
        ship(address);
    }
}
