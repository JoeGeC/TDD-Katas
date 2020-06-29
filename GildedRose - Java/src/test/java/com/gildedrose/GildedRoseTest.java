package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GildedRoseTest {

    @ParameterizedTest
    @CsvSource(value = {
            "foo: 0: 0: 'foo, -1, 0'",
            "foo: 6: 10: 'foo, 5, 9'",
            "foo: -1: 10: 'foo, -2, 8'",
            "foo: 5: 1: 'foo, 4, 0'",
            "foo: 5: -1: 'foo, 4, -1'",

            "Aged Brie: 11: 50: 'Aged Brie, 10, 50'",
            "Aged Brie: 11: 0: 'Aged Brie, 10, 1'",

            "Aged Brie: -1: 10: 'Aged Brie, -2, 12'",


            "Aged Brie: -1: 50: 'Aged Brie, -2, 50'",
            "Aged Brie: -1: 49: 'Aged Brie, -2, 50'",

            "Backstage passes to a TAFKAL80ETC concert: 0: 0: 'Backstage passes to a TAFKAL80ETC concert, -1, 0'",
            "Backstage passes to a TAFKAL80ETC concert: 10: 10: 'Backstage passes to a TAFKAL80ETC concert, 9, 12'",
            "Backstage passes to a TAFKAL80ETC concert: 5: 10: 'Backstage passes to a TAFKAL80ETC concert, 4, 13'",
            "Backstage passes to a TAFKAL80ETC concert: -1: 10: 'Backstage passes to a TAFKAL80ETC concert, -2, 0'",
            "Backstage passes to a TAFKAL80ETC concert: 11: 10: 'Backstage passes to a TAFKAL80ETC concert, 10, 11'",
            "Backstage passes to a TAFKAL80ETC concert: 10: 50: 'Backstage passes to a TAFKAL80ETC concert, 9, 50'",
            "Backstage passes to a TAFKAL80ETC concert: 11: 50: 'Backstage passes to a TAFKAL80ETC concert, 10, 50'",
            "Backstage passes to a TAFKAL80ETC concert: 5: 50: 'Backstage passes to a TAFKAL80ETC concert, 4, 50'",
            "Backstage passes to a TAFKAL80ETC concert: 6: 50: 'Backstage passes to a TAFKAL80ETC concert, 5, 50'",
            "Backstage passes to a TAFKAL80ETC concert: 6: 4: 'Backstage passes to a TAFKAL80ETC concert, 5, 6'",
            "Backstage passes to a TAFKAL80ETC concert: -1: 50: 'Backstage passes to a TAFKAL80ETC concert, -2, 0'",
            "Backstage passes to a TAFKAL80ETC concert: 1: 48: 'Backstage passes to a TAFKAL80ETC concert, 0, 50'",
            "Backstage passes to a TAFKAL80ETC concert: 1: 49: 'Backstage passes to a TAFKAL80ETC concert, 0, 50'",

            "Sulfuras, Hand of Ragnaros: 0: 0: 'Sulfuras, Hand of Ragnaros, 0, 0'",
            "Sulfuras, Hand of Ragnaros: 5: 1: 'Sulfuras, Hand of Ragnaros, 5, 1'",
            "Sulfuras, Hand of Ragnaros: 7: 1: 'Sulfuras, Hand of Ragnaros, 7, 1'",
            "Sulfuras, Hand of Ragnaros: -1: 5: 'Sulfuras, Hand of Ragnaros, -1, 5'",
            "Sulfuras, Hand of Ragnaros: -1: 50: 'Sulfuras, Hand of Ragnaros, -1, 50'",
    }, delimiter = ':')
    public void foo(String item, int sellIn, int quality, String expected) {
        Item[] items = new Item[]{new Item(item, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(expected, app.items[0].toString());
    }

}
