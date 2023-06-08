package fr.epita.assistants.myebook;

public interface Paginated {
    void openToPage(int page);

    int getCurrentPage();

    int getPageCount();

}
