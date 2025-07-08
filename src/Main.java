import Models.Book;
import Models.EBook;
import Models.PaperBook;
import Models.ShowcaseBook;
import Services.InventoryService;

public class Main {
    public static void main(String[] args) {
        Book p1 = new PaperBook("PB001", "Clean Code", 2010, 45.0f, "Robert C. Martin", 10);
        Book p2 = new EBook("EB001", "You Don’t Know JS", 2019, 25.0f, "Kyle Simpson", "PDF");
        Book p3 = new ShowcaseBook("SB001", "Quantum Architecture", 2000, 0.0f, "Ahmed Amr");

        InventoryService.addBook(p1);
        InventoryService.addBook(p2);
        InventoryService.addBook(p3);

        InventoryService.buyBook("PB001", 2, "aamr24987@gmail.com", "Elzyton, Cairo");
        InventoryService.buyBook("EB001", 1, "aamr24987@gmail.com", "Dokki, Giza");
        InventoryService.removeOutdatedBooks(20);
    }
}