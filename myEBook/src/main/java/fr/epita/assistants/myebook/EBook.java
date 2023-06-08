package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class EBook implements Paginated, Editable {

    private String name;
    List<String> pages;
    private int currentPage;

    public EBook(String name) {
        this.name = name;
        this.pages = new ArrayList<>();
        this.currentPage = 0;
        this.pages.add("");
    }

    public String getName() {
        return name;
    }

    public Book print() {
        Book book = new Book(this.name, this.pages);
        return book;
    }


    @Override
    public void openToPage(int page) {
        if (page >= 0 && page < pages.size()) {
            this.currentPage = page;
        }
    }


    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public int getPageCount() {
        return pages.size();
    }

    @Override
    public void writeCurrentPage(String pageText) {
        pages.set(currentPage, pageText);
    }

    @Override
    public void addPage() {
        pages.add(currentPage + 1, "");
    }
    @Override
    public void deletePage() {
        if (pages.size() > 0) {
            pages.remove(currentPage);
            if (pages.size() == 0) {
                pages.add("");
            }
        }
    }
}