package mvc.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank(message = "This field must be entered")
    @Column(name = "author")
    private String author;
    @NotBlank(message = "This field must be entered")
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "categoryID")
    @Valid
    private CategoryEntity category;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private BookDetailsEntity bookDetails;

    public BookEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public BookDetailsEntity getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetailsEntity bookDetails) {
        this.bookDetails = bookDetails;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category.toString() +
                ", bookDetails=" + bookDetails.toString() +
                '}';
    }
}