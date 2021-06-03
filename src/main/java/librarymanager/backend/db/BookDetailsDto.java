package librarymanager.backend.db;

public class BookDetailsDto {

    String isbn;
    String name;
    String genre;
    double rating;
    boolean isAvailable;
    String author;
    String publisher;
    Integer quantity;
    String shelf;
    String location;

    public BookDetailsDto(String isbn, String name, String genre, double rating, boolean isAvailable,
                          String author, String publisher, Integer quantity, String shelf, String location) {
        this.isbn = isbn;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.isAvailable = isAvailable;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.shelf = shelf;
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getShelf() {
        return shelf;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "BookDetailsDto{" +
                "isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", isAvailable=" + isAvailable +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", quantity=" + quantity +
                ", shelf='" + shelf + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public static class BookDetailsDtoBuilder {

        String isbn;
        String name;
        String genre;
        double rating;
        boolean isAvailable;
        String author;
        String publisher;
        Integer quantity;
        String shelf;
        String location;


        public BookDetailsDtoBuilder(String isbn) {
            this.isbn = isbn;
        }


        public BookDetailsDtoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BookDetailsDtoBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public BookDetailsDtoBuilder setRating(double rating) {
            this.rating = rating;
            return this;
        }

        public BookDetailsDtoBuilder setAvailability(boolean available) {
            isAvailable = available;
            return this;
        }

        public BookDetailsDtoBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookDetailsDtoBuilder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookDetailsDtoBuilder setQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public BookDetailsDtoBuilder setShelf(String shelf) {
            this.shelf = shelf;
            return this;
        }

        public BookDetailsDtoBuilder setLocation(String location) {
            this.location = location;
            return this;
        }

        public BookDetailsDto build(){
            return new BookDetailsDto(this.isbn, this.name, this.genre, this.rating, this.isAvailable, this.author,
                    this.publisher, this.quantity, this.shelf, this.location);
        }
    }
}
