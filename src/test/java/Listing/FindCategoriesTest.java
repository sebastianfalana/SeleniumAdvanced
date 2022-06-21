package Listing;

import base.TestBase;
import pages.commons.TopManuPage;

public class FindCategoriesTest extends TestBase {

    public void shouldFindCategories(){
        // 1 przeiteruj po wszystkich kategoriach
        new TopManuPage(driver).goToCategory("CLOTHES");

        // za kazdym razem sprawc czy:
        // --otowrzyla sie katogoria na ktora kliknąłeś
        // --ilość załadowanych produktów
        // --jest równa ilości podanych w tyule kategorii
        // *** dla chetnych: rowniez podkategorie
    }

}
