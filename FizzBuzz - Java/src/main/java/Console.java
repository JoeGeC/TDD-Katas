public class Console implements Outputter {

    @Override
    public void output(String value) {
        System.out.println(value);
    }
}
