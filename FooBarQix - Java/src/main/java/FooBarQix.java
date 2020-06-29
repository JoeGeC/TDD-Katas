public class FooBarQix {
    public String printMany(int amount) {
        return null;
    }

    public String print(int value) {
        if(value == 0) return "";
        String result = "";
        if (value == 3) result += appendContainWord("Foo");
        if(value % 3 == 0) result += "Foo";
        if (value == 5) result += appendContainWord("Bar");
        if(value % 5 == 0) result += "Bar";
        if (value == 7) result += appendContainWord("Qix");
        if(value % 7 == 0) result += "Qix";
        if(result.isEmpty()) return Integer.toString(value);
        return result;
    }

    private String appendContainWord(String word) {
        return word;
    }
}
