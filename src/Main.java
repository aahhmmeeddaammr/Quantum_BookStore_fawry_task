import Factories.BookFactory;
import Models.Book;
import Services.InventoryService;

public class Main {
    public static void main(String[] args) {
        Book p1 = BookFactory.createBook("paper", "PB001", "Clean Code", 2010, 45.0f, "Robert C. Martin", 10, null);
        Book p2 = BookFactory.createBook("ebook", "EB001", "You Don’t Know JS", 2019, 25.0f, "Kyle Simpson", 0, "PDF");
        Book p3 = BookFactory.createBook("showcase", "SB001", "Quantum Architecture", 2000, 0.0f, "Ahmed Amr", 0, null);

        InventoryService.addBook(p1);
        InventoryService.addBook(p2);
        InventoryService.addBook(p3);

        InventoryService.buyBook("PB001", 2, "aamr24987@gmail.com", "Elzyton, Cairo");
        InventoryService.buyBook("EB001", 1, "aamr24987@gmail.com", "Dokki, Giza");
        InventoryService.removeOutdatedBooks(20);
    }
}