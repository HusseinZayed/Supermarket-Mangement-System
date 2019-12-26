

package superMarket.model;

/**
 *
 * @author hussein
 */
public class ProductModel {
    
    private int id;
    private int number;
    private int discount;
    private Double price;
    private String type;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductModel{" + "id=" + id + ", number=" + number + ", discount=" + discount + ", price=" + price + ", type=" + type + ", name=" + name + '}';
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
