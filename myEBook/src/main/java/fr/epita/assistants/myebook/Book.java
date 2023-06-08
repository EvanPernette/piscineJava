package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public class Book implements Paginated, Readable {

    private String name;
    private List<String> pages;
    private int currentPage;

    Book(String name, List<String> pages) {
        this.name = name;
        this.pages = new ArrayList<String>(pages);
        this.currentPage = 0;
    }


    public String getName() {
        return name;
    }

    public EBook scan() {
        EBook ebook = new EBook(name);
        ebook.pages = pages;
        return ebook;
    }

    @Override
    public void openToPage(int page) {
        if (page >= 0 && page < pages.size()) {
            this.currentPage = page;
        }
    }

    @Override
    public int getCurrentPage() {
        return this.currentPage;
    }


    @Override
    public int getPageCount() {
        return this.pages.size();
    }

    @Override
    public String readCurrentPage() {
        if (pages == null)
        {
            return null;
        }
        return this.pages.get(currentPage);
    }
}