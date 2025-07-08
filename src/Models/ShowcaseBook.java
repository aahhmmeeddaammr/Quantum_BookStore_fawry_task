package Models;

import Models.intefraces.Purchasable;

public class ShowcaseBook extends Book implements Purchasable {
    public ShowcaseBook(String isbn, String title, int year, float price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public boolean isPurchasable() {
        return false;
    }
}
