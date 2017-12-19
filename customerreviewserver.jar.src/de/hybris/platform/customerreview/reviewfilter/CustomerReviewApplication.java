package de.hybris.platform.customerreview.reviewfilter;

import java.util.List;

public class CustomerReviewApplication {

	public static void main(String[] args) {
		ProductReviewSamples ProductReviewSamples = new ProductReviewSamples();
		final double MIN_RATING = 6.0;
		final double MAX_RATING = 9.0;
		int sampleRecordsInRange = 20;
		int sampleRecordsWithError = 10;
		System.out.println("\nReview Rating is between " + MIN_RATING + " - " + MAX_RATING);
		System.out.println("\nReviews with positive rating");
		positiveTesting(ProductReviewSamples, MIN_RATING, MAX_RATING, sampleRecordsInRange);

		System.out.println("\nReviews with negaitve rating");
		negativeTesting(ProductReviewSamples, sampleRecordsWithError);

		System.out.println("\nWord Filter Testing");
		System.out.println("\nTest 1");
		testBadWords("bad Test");
		System.out.println("\nTest 2");
		testBadWords("poor Test");
		System.out.println("\nTest 3");
		testBadWords("worst Test");
	}

	public static void testBadWords(String reviewBody) {
		if (FilterHandler.foundBadWord(reviewBody, FilterHandler.loadData())) {
			try {
				System.out.println("Reivew Deneied");
				throw new Exception(
						"Review has Bad words");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Reivew Accepted");
		}

	}

	private static void negativeTesting(ProductReviewSamples ProductReviewSamples, int sampleSize) {
		final List<ProductDO> productReviewSamples = ProductReviewSamples.createProductSamples(sampleSize);
		System.out.println("\nNegative Review List:");
		System.out.println("\nProcessed List:");
		for (ProductDO productReviewSample : productReviewSamples) {
			if (productReviewSample.getRating() < 0) {
				try {
					System.out.println(productReviewSample.toString());
					throw new Exception(
							"Invalid Review\nRating Less Than 0\nRating=" + productReviewSample.getRating());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

	private static void positiveTesting(ProductReviewSamples ProductReviewSamples, double MIN_RATING, double MAX_RATING,
			int sampleSize) {
		List<ProductDO> productReviewSamples = ProductReviewSamples.createProductSamples(sampleSize);
		int count = 0;
		for (ProductDO productReviewSample : productReviewSamples) {
			if (productReviewSample.getRating() > MIN_RATING) {
				System.out.println(productReviewSample.toString());
				count++;
			}
		}
		if (count > 0) {
			System.out.println("Positive Review count" + count);
		} else {
			System.out.println("There are no positive reviews");
		}
	}
}
