package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTest {

    @Test
    void testRecipe1(){
        Recipe recipe=new Recipe("Sajtos Csirke");
        assertEquals("Sajtos Csirke",recipe.getName());
        assertEquals(0,recipe.getIngredients().size());
    }

    @Test
    void testRecipe2(){
        Recipe recipe=new Recipe("Sajtos Csirke","Megsajtozzuk és kisütjük");

        assertEquals("Sajtos Csirke",recipe.getName());
        assertEquals("Megsajtozzuk és kisütjük",recipe.getDescription());
        assertEquals(0,recipe.getIngredients().size());
    }
    @Test
    void testAddIngredient(){
        Recipe recipe=new Recipe("Sajtos Csirke","Megsajtozzuk és kisütjük");
        recipe.addIngredient("sajt","csirke","só");

        assertEquals("Sajtos Csirke",recipe.getName());
        assertEquals("Megsajtozzuk és kisütjük",recipe.getDescription());
        assertEquals(3,recipe.getIngredients().size());
        assertEquals("só",recipe.getIngredients().get(2));
    }
}