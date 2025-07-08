package Models;

import Models.intefraces.Deliverable;
import Models.intefraces.Emailable;
import Models.intefraces.Purchasable;

public class EBook extends Book implements Purchasable, Emailable, Deliverable {
    private String fileType;
    public EBook(String isbn, String title, int year, float price, String author, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }
    @Override
    public boolean isPurchasable() {
        return true;
    }
    @Override
    public void sendEmailTo(String email) {
        System.out.println("Quantum book store: Sending ebook to " + email);
    }
    @Override
    public void deliver(String email, String address) {
        sendEmailTo(email);
    }

}
