package org.example;
import java.util.ArrayList;
public class Library {
        ArrayList<Book> catalog = new ArrayList<Book>();

        public void addBook(Book book) {
            catalog.add(book);
        }

        public void removeBook(int id) {
            catalog.remove(id);
        }

        public int getCountBook() {
            return catalog.size();
        }

        public String getBookInfoById(int id) {
            Book book = catalog.get(id);
            return book.toString();
        }


        public int searchBookByName(String text) {
            int rez = 0;
            String nameBook;
            for (int i = 0; i < getCountBook(); i++) {
                Book book = catalog.get(i);
                nameBook = book.getTitle().toLowerCase();
                if (nameBook.contains(text.toLowerCase())) {
                    System.out.println(book.toString());
                    rez++;
                }
            }
            if (rez == 0) {
                rez = searchBookByWriter(text);
            }
            return rez;
        }

        public int searchBookByWriter(String text) {
            int rez = 0;
            String nameWriter;
            for (int i = 0; i < getCountBook(); i++) {
                Book book = catalog.get(i);
                nameWriter = book.getAuthor().toLowerCase();
                if (nameWriter.contains(text.toLowerCase())) {
                    System.out.println(book.toString());
                    rez++;
                }
            }
            return rez;
        }

    }
