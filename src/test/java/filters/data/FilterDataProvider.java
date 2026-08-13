package filters.data;

import org.testng.annotations.DataProvider;

public class FilterDataProvider {

    @DataProvider(name = "sortOptions")
    public Object[][] sortOptions()
    {

        return new Object[][]
                {
                {"Recommended"},
                {"Best Selling"},
                {"Newest"},
                {"Price: Low to High"},
                {"Price: High to Low"}
        };
    }
}