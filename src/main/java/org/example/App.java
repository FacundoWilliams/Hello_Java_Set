package org.example;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Hello Java Set!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        CategoriesMenu categoriesMenu;
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        categoriesMenu =
        mapper.readValue((new FileInputStream(new File
                (System.getProperty("user.dir") + "/json" + "/" + "CategoriesMenu" + ".json"))), CategoriesMenu.class);
        //Getting the state object
        System.out.println("This is a State object"+ categoriesMenu.getState());
        //Getting a root category
        Iterator<rootCategories> categoryIterator = categoriesMenu.getState().getRootCategories().iterator();
        rootCategories rootCategory = categoryIterator.next();
        System.out.println("This is a root category= "+ rootCategory );
        //Getting a subCategory
        Iterator<subCategories> subCategoryIterator = rootCategory.getSubCategories().iterator();
        subCategories subCategory = subCategoryIterator.next();
        System.out.println("This is a sub category= "+ subCategory );
        //Getting a leafCategory
        Iterator<leafCategories> leafCategoryIterator = subCategory.getLeafCategories().iterator();
        leafCategories leafcategory = leafCategoryIterator.next();
        System.out.println("This is a leaf category= "+ leafcategory );



    }
}
