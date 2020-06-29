package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class ProductFactory {

    static Product newInstance(Item item) {
        Map<String, Product> products = setupProducts();
        Product product = products.get(item.name);
        if (product == null) {
            return new Foo();
        }

        return product;
    }

    static Map<String, Product> setupProducts() {
        Map<String, Product> products = new HashMap<String, Product>();
        products.put("Aged Brie", new AgedBrie());
        products.put("Backstage passes to a TAFKAL80ETC concert", new Backstage());
        products.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
        return products;
    }
}