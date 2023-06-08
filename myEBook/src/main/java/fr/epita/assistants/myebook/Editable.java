package fr.epita.assistants.myebook;

public interface Editable {

    void writeCurrentPage(String PageText);
    void addPage();

    void deletePage();
}
