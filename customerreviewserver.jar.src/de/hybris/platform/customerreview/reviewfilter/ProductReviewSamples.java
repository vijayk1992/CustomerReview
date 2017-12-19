package de.hybris.platform.customerreview.reviewfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
//create fake reviews for testing purpose
public class ProductReviewSamples { 
    List<ProductDO> createProductSamples(int numberOfProducts) {
        List<ProductDO> productList = new ArrayList<>();
        Random randomNumbers = new Random();
        int minimumRange = -10;
        int maximumRange = 10;
        for (int i = 0; i < numberOfProducts; i++) {
            int maxLength = randomNumbers.nextInt(maximumRange) + 5;
            StringBuilder randomName = new StringBuilder(maxLength);
            for (int j = 0; j < maxLength; j++) {
                char nextChar = (char) (randomNumbers.nextInt(26) + 65);
                randomName.append(nextChar);
            }
            productList.add(new ProductDO(minimumRange + (maximumRange - minimumRange) * randomNumbers.nextDouble(), randomName.toString()));
        }
        return productList;
    }
}