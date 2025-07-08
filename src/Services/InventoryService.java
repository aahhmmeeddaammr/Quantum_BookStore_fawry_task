package Services;

import Models.Book;
import Models.PaperBook;
import Models.intefraces.Deliverable;
import Models.intefraces.Purchasable;

import java.util.*;

public class InventoryService {
    private static Map<String, Book> inventory = new HashMap<>();

    public static void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Book added -> " + book.getTitle());
    }
    public static List<Book> removeOutdatedBooks(int maxYearsOld) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();

        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            if (currentYear - entry.getValue().getPublishedYear() > maxYearsOld) {
                removed.add(entry.getValue());
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book -> " + entry.getValue().getTitle());
            }
        }
        return removed;
    }

    public static double buyBook(String isbn, int qty, String email, String address) {
        Book book = inventory.get(isbn);
        if (book == null) throw new RuntimeException("Quantum book store: Book not found.");
        if (book instanceof Purchasable && !((Purchasable) book).isPurchasable()) throw new RuntimeException("Quantum book store: Book not for sale.");

        double amount = book.getPrice() * qty;

        if (book instanceof PaperBook) {
            ((PaperBook) book).setQuantityInStock(qty);
        }

        if(book instanceof Deliverable){
            ((Deliverable) book).deliver(email , address);
        }

        System.out.println("Quantum book store: Purchase complete. Paid amount = $" + amount);
        return amount;
    }

}
