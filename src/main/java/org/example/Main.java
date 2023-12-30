package org.example;


//Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования
//Задание: "Библиотечная Система"
//Цель:
//Создать простую систему для управления книгами в библиотеке. Система должна позволять хранить книги, сортировать их по разным критериям, а также предоставлять функционал для перебора книг.
//
//Шаги:
//Класс Book:
//
//Создайте класс Book с полями: title (название), author (автор) и publishedYear (год издания).
//Реализуйте конструктор, геттеры для каждого поля и метод toString().
//Реализуйте интерфейс Comparable<Book> для сравнения книг по названию.
//Компараторы:
//
//Создайте два компаратора для класса Book: один для сортировки по автору, другой - по году издания.
//Класс Library:
//
//Создайте класс Library, который реализует Iterable<Book>.
//В классе Library должен быть список books, в котором хранятся объекты Book.
//Реализуйте методы для добавления книг (addBook), получения списка всех книг (getBooks) и сортировки книг по разным критериям.
//Реализуйте метод iterator() для обхода всех книг в библиотеке.
//Тестирование функционала:
//
//В методе main создайте экземпляр класса Library и добавьте в него несколько книг.
//Продемонстрируйте сортировку книг по названию, автору и году издания.
//Используйте цикл for-each для перебора и вывода всех книг из Library.
//Дополнительные задачи (по желанию):
//Добавьте функционал для удаления книг из библиотеки.
//Реализуйте возможность фильтрации книг по определенным критериям (например, по автору или году издания).
//Создайте пользовательский интерфейс (консольный или графический), чтобы упростить взаимодействие с вашей библиотечной системой.
//Это задание поможет вам закрепить знания о создании и использовании классов, интерфейсов, компараторов и итераторов в Java, а также даст понимание, как эти элементы могут работать вместе в реальном приложении.

public class Main {
    public static void main(String[] args) {
        doWork();
    }

    static void doWork() {
        Reader pers = new Reader("Иван");
        Book book1 = new Book("Война и мир", "Толстой Л.Н.", "2001");
        Book book2 = new Book("Преступление и наказание", "Достоевский Ф.М.", "2020");
        Library catalog = new Library();
        catalog.addBook(book1);
        catalog.addBook(book2);
        int what;

        System.out.println("Сейчас в каталоге книг - " + catalog.getCountBook());
        for (int i = 0; i < 10; i++) {
            System.out.println("Что будем делать: 0-Добавить книгу; 1-Найти книгу; 2-Удалить книгу");
            what = whatDo(pers);
            if (what == 1) {
                iterator(pers, catalog);
            }
            if (what == 0) {
                addCatalogBook(pers, catalog);
                System.out.println("В каталоге книг - " + catalog.getCountBook());
            }
            if (what == 2) {
                if (catalog.getCountBook() > 0 ) {
                    removeCatalogBook(pers, catalog);
                    System.out.println("В каталоге осталось книг - " + catalog.getCountBook());
                } else {
                    System.out.println("В каталоге пусто. Нет книг для удаления");
                }
            }
        }
    }

    static int whatDo(Reader pers) {
        int d;
        do {
            d = pers.getAnswer();
            if (d != 0 & d != 1 & d != 2) {
                System.out.println("Укажите что нужно сделать: 0-Добавить книгу; 1-Найти книгу; 2-Удалить книгу");
            }
        } while(d != 0 & d != 1 & d != 2);
        return d;
    }

    static void iterator(Reader pers, Library catalog) {
        System.out.println("Что ищем?");
        String str = pers.getString();
        int rez = catalog.searchBookByName(str);
        if (rez == 0) {
            System.out.println("Книга \"" + str + "\" не найдена");
        }
    }

    static void addCatalogBook(Reader pers, Library catalog) {
        String getTitle = null;
        String getAuthor = null;
        String getPublishedYear = null;
        System.out.println("Укажите название книги");
        getTitle = pers.getString();
        System.out.println("Укажите автора книги");
        getAuthor = pers.getString();
        System.out.println("Укажите год издания книги");
        getPublishedYear = pers.getString();
        catalog.addBook(new Book(getTitle, getAuthor, getPublishedYear));
        System.out.println("Книга добавлена в каталог");
    }

    static void removeCatalogBook(Reader pers, Library catalog) {
        int numBook;
        System.out.println("В каталоге книг - " + catalog.getCountBook());
        System.out.println("Укажите номер удаляемой книги");
        do {
            numBook = pers.getAnswer();
        } while(numBook < 1 || numBook > catalog.getCountBook());
        --numBook;
        System.out.println("Вы уверены что хотите удалить книну: " + catalog.getBookInfoById(numBook) + "?");
        System.out.println("0-нет; 1-да");
        int ans;
        do {
            ans = pers.getAnswer();
        } while (ans != 0 & ans != 1);
        if (ans == 1) {
            catalog.removeBook(numBook);
        }
    }
}