package day01;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    @Test
    void testNumberSequence(){
        int minParam=23;
        int maxParam=89;
        int pcs=10;

        NumberSequence numberSequence = new NumberSequence(pcs, minParam, maxParam);

        int min=-1;
        int max=-1;
        for(int number:numberSequence.getList()){
            if(min>number||min==-1){
                min=number;
            }
            if(max<number||max==-1){
                max=number;
            }
        }

        assertEquals(pcs,numberSequence.getList().size());
        assertTrue(min>minParam);
        assertTrue(max<maxParam);
    }

    @Test
    void testNumberSequenceII(){
        NumberSequence numberSequence = new NumberSequence(Arrays.asList(13,34,76,45,45,23));

        assertEquals(6,numberSequence.getList().size());

    }

}