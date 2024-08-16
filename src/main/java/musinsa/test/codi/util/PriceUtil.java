package musinsa.test.codi.util;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PriceUtil {

    // 총 가격 계산
    public static int calculateTotalPrice(List<Integer> prices) {
        return prices.stream().mapToInt(Integer::intValue).sum();
    }

    // 가격을 3자리마다 콤마가 포함된 형식으로 변환
    public static String formatPrice(int price) {
        NumberFormat formatter = NumberFormat.getInstance(Locale.getDefault());
        return formatter.format(price);
    }
}