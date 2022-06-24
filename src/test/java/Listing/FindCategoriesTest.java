package Listing;

import base.TestBase;
import org.assertj.core.api.Assertions;
import pages.commons.Breadcrumbs;
import pages.commons.TopManuPage;

public class FindCategoriesTest extends TestBase {

    public void shouldFindCategories(){
        // 1 przeiteruj po wszystkich kategoriach
        new TopManuPage(driver).goToCategory("CLOTHES");
        Assertions.assertThat(new Breadcrumbs(driver).getBreadcrumbs(1)).isEqualTo("Clothes");

        // za kazdym razem sprawc czy:
        // --otowrzyla sie katogoria na ktora kliknąłeś
        // --ilość załadowanych produktów
        // --jest równa ilości podanych w tyule kategorii
        // *** dla chetnych: rowniez podkategorie
    }

}
