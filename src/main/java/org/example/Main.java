package org.example;


//���� 3. ��������� ����������� ���������� Java � ������� �� �������������
//�������: "������������ �������"
//����:
//������� ������� ������� ��� ���������� ������� � ����������. ������� ������ ��������� ������� �����, ����������� �� �� ������ ���������, � ����� ������������� ���������� ��� �������� ����.
//
//����:
//����� Book:
//
//�������� ����� Book � ������: title (��������), author (�����) � publishedYear (��� �������).
//���������� �����������, ������� ��� ������� ���� � ����� toString().
//���������� ��������� Comparable<Book> ��� ��������� ���� �� ��������.
//�����������:
//
//�������� ��� ����������� ��� ������ Book: ���� ��� ���������� �� ������, ������ - �� ���� �������.
//����� Library:
//
//�������� ����� Library, ������� ��������� Iterable<Book>.
//� ������ Library ������ ���� ������ books, � ������� �������� ������� Book.
//���������� ������ ��� ���������� ���� (addBook), ��������� ������ ���� ���� (getBooks) � ���������� ���� �� ������ ���������.
//���������� ����� iterator() ��� ������ ���� ���� � ����������.
//������������ �����������:
//
//� ������ main �������� ��������� ������ Library � �������� � ���� ��������� ����.
//����������������� ���������� ���� �� ��������, ������ � ���� �������.
//����������� ���� for-each ��� �������� � ������ ���� ���� �� Library.
//�������������� ������ (�� �������):
//�������� ���������� ��� �������� ���� �� ����������.
//���������� ����������� ���������� ���� �� ������������ ��������� (��������, �� ������ ��� ���� �������).
//�������� ���������������� ��������� (���������� ��� �����������), ����� ��������� �������������� � ����� ������������ ��������.
//��� ������� ������� ��� ��������� ������ � �������� � ������������� �������, �����������, ������������ � ���������� � Java, � ����� ���� ���������, ��� ��� �������� ����� �������� ������ � �������� ����������.

public class Main {
    public static void main(String[] args) {
        doWork();
    }

    static void doWork() {
        Reader pers = new Reader("����");
        Book book1 = new Book("����� � ���", "������� �.�.", "2001");
        Book book2 = new Book("������������ � ���������", "����������� �.�.", "2020");
        Library catalog = new Library();
        catalog.addBook(book1);
        catalog.addBook(book2);
        int what;

        System.out.println("������ � �������� ���� - " + catalog.getCountBook());
        for (int i = 0; i < 10; i++) {
            System.out.println("��� ����� ������: 0-�������� �����; 1-����� �����; 2-������� �����");
            what = whatDo(pers);
            if (what == 1) {
                iterator(pers, catalog);
            }
            if (what == 0) {
                addCatalogBook(pers, catalog);
                System.out.println("� �������� ���� - " + catalog.getCountBook());
            }
            if (what == 2) {
                if (catalog.getCountBook() > 0 ) {
                    removeCatalogBook(pers, catalog);
                    System.out.println("� �������� �������� ���� - " + catalog.getCountBook());
                } else {
                    System.out.println("� �������� �����. ��� ���� ��� ��������");
                }
            }
        }
    }

    static int whatDo(Reader pers) {
        int d;
        do {
            d = pers.getAnswer();
            if (d != 0 & d != 1 & d != 2) {
                System.out.println("������� ��� ����� �������: 0-�������� �����; 1-����� �����; 2-������� �����");
            }
        } while(d != 0 & d != 1 & d != 2);
        return d;
    }

    static void iterator(Reader pers, Library catalog) {
        System.out.println("��� ����?");
        String str = pers.getString();
        int rez = catalog.searchBookByName(str);
        if (rez == 0) {
            System.out.println("����� \"" + str + "\" �� �������");
        }
    }

    static void addCatalogBook(Reader pers, Library catalog) {
        String getTitle = null;
        String getAuthor = null;
        String getPublishedYear = null;
        System.out.println("������� �������� �����");
        getTitle = pers.getString();
        System.out.println("������� ������ �����");
        getAuthor = pers.getString();
        System.out.println("������� ��� ������� �����");
        getPublishedYear = pers.getString();
        catalog.addBook(new Book(getTitle, getAuthor, getPublishedYear));
        System.out.println("����� ��������� � �������");
    }

    static void removeCatalogBook(Reader pers, Library catalog) {
        int numBook;
        System.out.println("� �������� ���� - " + catalog.getCountBook());
        System.out.println("������� ����� ��������� �����");
        do {
            numBook = pers.getAnswer();
        } while(numBook < 1 || numBook > catalog.getCountBook());
        --numBook;
        System.out.println("�� ������� ��� ������ ������� �����: " + catalog.getBookInfoById(numBook) + "?");
        System.out.println("0-���; 1-��");
        int ans;
        do {
            ans = pers.getAnswer();
        } while (ans != 0 & ans != 1);
        if (ans == 1) {
            catalog.removeBook(numBook);
        }
    }
}