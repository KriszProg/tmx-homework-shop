package hu.tmx.model.abstraction;

public abstract class Product implements Sellable {
    protected final String name;

    protected Product(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }
}
