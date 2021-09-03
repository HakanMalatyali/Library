package Spring.bookStore.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name="book_name")
    private String bookName;

    @Column(name="author")
    private String author;

    @Column(name ="release_date")
    private String releaseDate;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

}
