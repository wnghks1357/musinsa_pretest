package musinsa.test.codi.util;
import musinsa.test.codi.customer.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BrandUtil {

    // 브랜드별 총 가격 계산
    public static Map<String, Integer> calculateBrandTotalPrices(List<Product> products) {
        Map<String, List<Integer>> brandPriceMap = products.stream()
                .collect(Collectors.groupingBy(
                        product -> product.getBrand().getBrandName(),
                        Collectors.mapping(Product::getPrice, Collectors.toList())
                ));

        return brandPriceMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> PriceUtil.calculateTotalPrice(entry.getValue())
                ));
    }

    // 최저 가격 브랜드 선택
    public static String findMinPriceBrand(Map<String, Integer> brandTotalPrices) {
        return brandTotalPrices.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}