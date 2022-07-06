package Listing;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.Breadcrumbs;
import pages.commons.ProductsListingPage;
import pages.commons.TopManuPage;

public class FindCategoriesTest extends TestBase {

    @Test
    public void shouldFindCategories(){
        // 1 przeiteruj po wszystkich kategoriach
        // za kazdym razem sprawc czy:
        // --otowrzyla sie katogoria na ktora kliknąłeś

        new TopManuPage(driver).goToCategory("ACCESSORIES");
        Assertions.assertThat(new Breadcrumbs(driver).getBreadcrumbs(1)).isEqualTo("Clothes");
        System.out.println("Breadcrumbs: "+new Breadcrumbs(driver).getBreadcrumbs(1));

        // --ilość załadowanych produktów
        // --jest równa ilości podanych w tyule kategorii

        Assertions.assertThat(new ProductsListingPage(driver).getNumberOfProductsOnListing())
                .isEqualTo(new ProductsListingPage(driver).getQuantityOfProductsFromCategoryHeader());
        System.out.println("Product quantity: "+new ProductsListingPage(driver).getQuantityOfProductsFromCategoryHeader());

        // *** dla chetnych: rowniez podkategorie
    }
    @Test
    public void shouldFindCategory2(){
//        goToCategory("CLOTHES");
//        goToCategory("ACCESSORIES");
//        goToCategory("ART");

        goToSubCategory("CLOTHES","MEN");
    }

    public void goToCategory(String categoryName){
        new TopManuPage(driver).goToCategory(categoryName);
        Assertions.assertThat(new Breadcrumbs(driver).getBreadcrumbs(1).toUpperCase())
                .isEqualTo(new ProductsListingPage(driver).getCategoryName().toUpperCase());
        System.out.println("Breadcrumbs: "+new Breadcrumbs(driver).getBreadcrumbs(1));

        Assertions.assertThat(new ProductsListingPage(driver).getNumberOfProductsOnListing())
                .isEqualTo(new ProductsListingPage(driver).getQuantityOfProductsFromCategoryHeader());
        System.out.println("Product quantity: "+new ProductsListingPage(driver).getQuantityOfProductsFromCategoryHeader());

    }
    public void goToSubCategory(String categoryName, String subCategoryName){
        new TopManuPage(driver).hoverCategory(categoryName);
        new TopManuPage(driver).goToSubCategory(subCategoryName);
        Assertions.assertThat(new ProductsListingPage(driver).getCategoryName().toUpperCase())
                .isEqualTo(subCategoryName);
        System.out.println("Sub-Category name: "+new ProductsListingPage(driver).getCategoryName());
        Assertions.assertThat(new ProductsListingPage(driver).getNumberOfProductsOnListing())
                .isEqualTo(new ProductsListingPage(driver).getQuantityOfProductsFromCategoryHeader());
        System.out.println("Number of products in sub_category "+subCategoryName+" is - "+
                new ProductsListingPage(driver).getNumberOfProductsOnListing());

    }

}
