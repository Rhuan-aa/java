public class Produto {
    private String productName;
    private float productValue;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductValue() {
        return productValue;
    }

    public void setProductValue(float productValue) {
        this.productValue = productValue;
    }

    public void applyDiscount(float discount) {
        if (discount > 0 && discount < 100){
            this.productValue = this.productValue * (1 - (discount/100));
        } else {
            System.out.println("Desconto impossivel de ser aplicado");
        }
    }
}
