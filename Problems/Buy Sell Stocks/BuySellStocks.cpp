#include <vector>
#include <iostream>
#include <limits>

int main()
{
    std::vector<double> prices{12, 11, 13, 9, 12, 8, 14, 13, 15};

    double max_profit = 0;
    double min_price = std::numeric_limits<double>::max();
    std::vector<double> profits(size(prices), 0);

    for (int i = 0; i < size(prices); i++)
    {
        min_price = std::min(prices[i], min_price);
        max_profit = std::max(prices[i] - min_price, max_profit);
        profits[i] = max_profit;
    }
    double max_price = std::numeric_limits<double>::min();
    for (int i = size(prices) - 1; i > 0; i--)
    {
        max_price = std::max(prices[i], max_price);
        max_profit = std::max(max_price - prices[i] + profits[i - 1], max_profit);
    }
}