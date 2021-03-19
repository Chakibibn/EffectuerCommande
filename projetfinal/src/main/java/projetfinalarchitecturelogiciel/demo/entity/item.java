package projetfinalarchitecturelogiciel.demo.entity;

public class item {
    private product product;
    private int quantity;

    public item(projetfinalarchitecturelogiciel.demo.entity.product product, int i) {
        this.product=product;
        this.quantity=i;
    }
    public item(){}

    public projetfinalarchitecturelogiciel.demo.entity.product getProduct() {
        return product;
    }

    public void setProduct(projetfinalarchitecturelogiciel.demo.entity.product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
