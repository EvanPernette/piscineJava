package fr.epita.assistants;


import static org.junit.jupiter.api.Assertions.assertEquals;

import fr.epita.assistants.myebook.*;

public class Main {
    
    public static void main(String[] args) {
        //Test multiple versions of the same book   

        EBook eBook = new EBook("Harry Potter");

        eBook.writeCurrentPage("This story is about a young wizard..");

        Book printedBook = eBook.print();
        assertEquals("This story is about a young wizard..", printedBook.readCurrentPage());

        EBookReader eBookReader = new EBookReader();
        eBookReader.openEbook(printedBook.scan());
        assertEquals("This story is about a young wizard..", eBookReader.readCurrentPage());

        //Test multiple versions of the same book
        EBook eBook2 = new EBook("Harry Potter");
        eBook2.writeCurrentPage("This story is about a young wizard..");
        Book printedBook2 = eBook2.print();
        eBook.addPage();
        eBook.openToPage(1);
        eBook.writeCurrentPage("He is a student at Hogwarts..");
        eBook.addPage();
        eBook.openToPage(2);
        eBook.writeCurrentPage("He is a student at Hogwarts LEGACYEFEZFAFAZFAZFAZFAZFFAZF..");
        Book printedBook3 = eBook.print();
        eBook.addPage();
        eBook.openToPage(3);
        eBook.writeCurrentPage("He is a student at Hogwarts....................;..");
        Book printedBook4 = eBook.print();
        System.out.println("book3 :" + printedBook3.getPageCount());
        System.out.println("book4 :" + printedBook4.getPageCount());
        assertEquals("This story is about a young wizard..", printedBook2.readCurrentPage());
    }
}
