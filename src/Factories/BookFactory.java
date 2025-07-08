package Factories;

import Models.Book;
import Models.EBook;
import Models.PaperBook;
import Models.ShowcaseBook;

public class BookFactory {
    public static Book createBook(String type, String isbn, String title, int year, float price, String author, int stockOr0, String fileTypeOrNull) {
        return switch (type.toLowerCase()) {
            case "paper" -> new PaperBook(isbn, title, year, price, author, stockOr0);
            case "ebook" -> new EBook(isbn, title, year, price, author, fileTypeOrNull);
            case "showcase" -> new ShowcaseBook(isbn, title, year, price, author);
            default -> throw new IllegalArgumentException("Unknown book type: " + type);
        };
    }
}
