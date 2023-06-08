package fr.epita.assistants.myebook;


public class EBookReader implements Paginated, Readable, Updatable {

    private EBook ebook;
    private int currentPage;
    private double version;

    public EBookReader() {
        this.version = 1.0;
    }


    public void openEbook(EBook ebook) {
        this.ebook = ebook;
        this.currentPage = ebook.getCurrentPage();
    }


    @Override
    public void openToPage(int page) {
        ebook.openToPage(page);
        this.currentPage = page;
    }

    @Override
    public int getCurrentPage() {
        if (ebook == null)
        {
            return -1;
        }
        return currentPage;
    }


    @Override
    public int getPageCount() {
        if (ebook == null)
        {
            return -1;
        }
        return ebook.getPageCount();
    }


    @Override
    public String readCurrentPage() {
        if (ebook == null)
        {
            return null;
        }
        return ebook.pages.get(currentPage);
    }


    @Override
    public double getVersion() {
        return version;
    }

    @Override
    public void update(double version) {
        if (version > this.version) {
            this.version = version;
        }
    }
}
