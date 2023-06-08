#include <iostream>
#include <array>
#include <limits.h>

int main()
{
    int N, B, H, W;
    int per, rooms, min = INT_MAX;
    std::cin >> N >> B >> H >> W;
    for (int i = 0; i < H; i++)
    {
        std::cin >> per;
        for (int j = 0; j < W; j++)
        {
            std::cin >> rooms;
            if (rooms >= N && per * N < B && per * N < min)
            {
                min = per * N;
            }
        }
    }
    if (min == INT_MAX)
    {
        std::cout << "stay home";
        return 0;
    }
    std::cout << min;
}