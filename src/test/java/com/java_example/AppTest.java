package com.java_example;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void bookClassReturnConstuctorData()
    {
        Book bookData = new Book("Title", "Author", "ISBN");

        assertTrue( bookData.getTitle().equals("Title") );
        assertTrue( bookData.getAuthor().equals("Author") );
        assertTrue( bookData.getIsbn().equals("ISBN") );
        assertTrue( bookData.getTypeOfLiterature().equals("Book") );
    }

    @Test
    public void magazineClassReturnConstuctorData()
    {
        Magazine magazineData = new Magazine("Title", "Author", "ISBN");

        assertTrue( magazineData.getTitle().equals("Title") );
        assertTrue( magazineData.getAuthor().equals("Author") );
        assertTrue( magazineData.getIsbn().equals("ISBN") );
        assertTrue( magazineData.getTypeOfLiterature().equals("Magazine") );
    }

    @Test
    public void bookClassReturnSettedData()
    {
        Book bookData = new Book("Title", "Author", "ISBN");

        bookData.setTitle("Second Title");
        bookData.setAuthor("Second Author");
        bookData.setIsbn("Second ISBN");

        assertTrue( bookData.getTitle().equals("Second Title") );
        assertTrue( bookData.getAuthor().equals("Second Author") );
        assertTrue( bookData.getIsbn().equals("Second ISBN") );
        assertTrue( bookData.getTypeOfLiterature().equals("Book") );
    }

    @Test
    public void magazineClassReturnSettedData()
    {
        Magazine magazineData = new Magazine("Title", "Author", "ISBN");

        magazineData.setTitle("Second Title");
        magazineData.setAuthor("Second Author");
        magazineData.setIsbn("Second ISBN");

        assertTrue( magazineData.getTitle().equals("Second Title") );
        assertTrue( magazineData.getAuthor().equals("Second Author") );
        assertTrue( magazineData.getIsbn().equals("Second ISBN") );
        assertTrue( magazineData.getTypeOfLiterature().equals("Magazine") );
    }
}
