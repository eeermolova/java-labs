import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Book {
    private String name;
    private String author;
    private int publishingYear;
    private String isbn;
    private String publisher;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Visitor {
    private String name;
    private String surname;
    private String phone;
    private List<Book> favoriteBooks;
    private boolean subscribed;
}
