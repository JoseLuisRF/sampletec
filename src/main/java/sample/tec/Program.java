package sample.tec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import sample.tec.util.Utility;


public class Program {
    public static void main(String[] args) {
        Utility utility = new Utility();
        
        String s = "I am using      HackerRank to improve      programming";
        String t = "am      HackerRank to improve";
        String[] result = utility.missingWords(s, t);

        Arrays.stream(result).forEach(System.out::println);

        Integer[] arr = utility.customSort(new Integer[]{3, 1, 2, 2, 4});

        System.out.println("customSort");
        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("personalizeCoupon");

        List<Map> topTen = personalizeCoupon(createCouponList(), getCategories());
        topTen.stream().forEach(System.out::println);

    }


    private static List<Map> personalizeCoupon(List<Map> coupons, List<String> preferredCategories) {
        return coupons.stream()
                .filter(coupon -> preferredCategories.contains(coupon.get("category")))
                .map(map -> {
                            map.put("discount", (float) map.get("couponAmount") / ((float) map.get("itemPrice")));
                            return map;
                        }
                ).sorted((o1, o2) -> ((Float) o1.get("discount")).compareTo((Float) o2.get("discount")))
                .limit(10)
                .map(dictionary -> {
                    Map<String, Object> resMap = new Hashtable();

                    resMap.put("upc", dictionary.get("upc"));
                    resMap.put("category", dictionary.get("category"));
                    resMap.put("itemPrice", dictionary.get("itemPrice"));
                    resMap.put("couponAmount", dictionary.get("couponAmount"));
                    return resMap;
                })
                .collect(Collectors.toList());
    }

    private static final String UPC_KEY = "upc";
    private static final String CODE_KEY = "code";
    private static final String CATEGORY_KEY = "category";
    private static final String ITEM_PRICE_KEY = "itemPrice";
    private static final String COUPON_AMOUNT_KEY = "couponAmount";

    private static List<Map> createCouponList() {
        Random random = new Random();
        List<Map> coupons = new ArrayList<>();
        List<String> categories = getCategories();

        for (int i = 0; i < 100; i++) {
            Map c1 = new Hashtable();
            c1.put(UPC_KEY, UPC_KEY + "_" + i);
            c1.put(CODE_KEY, CODE_KEY + "_" + i);

            String category = getCategories().get(random.nextInt(categories.size()));
            c1.put(CATEGORY_KEY, category);

            float priceKey = random.nextInt(10000);

            c1.put(ITEM_PRICE_KEY, priceKey);

            float couponAmount = priceKey * ((random.nextInt(100) / 100f));
            c1.put(COUPON_AMOUNT_KEY, couponAmount);
            coupons.add(c1);
        }

        return coupons;
    }

    private static List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            categories.add(CATEGORY_KEY + i);
        }
        return categories;
    }

}
