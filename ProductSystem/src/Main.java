import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = getProducts();

        Map<String, List<Product>> productsBySector =
                productList.stream().collect(Collectors.groupingBy(Product::getSector));
        
        for (String sector : new TreeSet<>(productsBySector.keySet())){
            System.out.println("Sector: " + sector);
            List<Product> list = productsBySector.get(sector);
            
            list.sort(Comparator.comparingDouble(Product::getPrice));
            
            for (Product product : list) {
                System.out.println(" - " + product);
            }
        }
    }

    private static List<Product> getProducts() {
        Product cleanCode = new Product("Clean Code", "livro", 80.00
                , 4);
        Product cleanArchitecture = new Product("Clean Architecture", "livro", 142.00
                , 12);
        Product devilMayCry = new Product("Devil May Cry Remaster", "jogo", 125.00
                , 7);
        Product ninjaGaiden = new Product("Ninja Gaiden 2 Black Remaster", "jogo", 250.00
                , 1);

        List<Product> productList = new ArrayList<Product>();
        productList.add(cleanCode);
        productList.add(cleanArchitecture);
        productList.add(devilMayCry);
        productList.add(ninjaGaiden);
        return productList;
    }
}