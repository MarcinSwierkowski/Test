package pl.sda.Serializacja;

import java.io.Serializable;

    public class Book implements Serializable {

        private int id;
        private String title;
        private String author;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }

}
