#include <array>
#include <iostream>

int main()
{
    int N;
    scanf("%d", &N);
    while (N--)
    {
        int num;
        std::cin >> num;
        if (num == 1 || num == 4 || num == 78)
        {
            std::cout << "+\n";
        }
        else if ((num - 35) % 100 == 0)
        {
            std::cout << "-\n";
        }
        else
        {
            int last = (num - 4) % 10;
            while (num > 10)
            {
                num /= 10;
            }
            if (num == 9 || last == 0)
            {
                std::cout << "*\n";
            }
            else
            {
                std::cout << "?\n";
            }
        }
    }
    return 0;
}