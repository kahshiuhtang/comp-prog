#include <iostream>
#include <string>
#include <limits>

// INCOMPLETE
int main()
{
    int n, p, cases = 1, min = INT_MAX;
    float comp = 0;
    char *name, *tempName;
    std::cin >> n >> p;
    for (int i = 0; i < n; i++)
    {
        std::cin >> tempName;
    }
    while (p--)
    {
        int price, comps;
        std::cin >> tempName >> price >> comps;
        if (comps / n > comp)
        {
            comp = comps / n;
            min = price;
            name = tempName;
        }
        else if (comps / n == comp && price < min)
        {
            min = price;
            name = tempName;
        }
        for (int i = 0; i < comps; i++)
        {
            std::cin >> tempName;
        }
    }
    std::cout << name;
}