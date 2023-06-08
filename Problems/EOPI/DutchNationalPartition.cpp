#include <array>
#include <iostream>
int main()
{
    int arr[] = {6, 5, 1, 2, 3, 4};
    int pivot = arr[5];
    int length = sizeof(arr) / sizeof(arr[0]);
    int low = 0, equal = 0, high = length;
    /*
    Bottom: 0, low - 1
    Equal: low, equal - 1
    Unsorted: equal, high - 1
    High: high, length - 1
    */
    while (equal < high)
    {
        if (arr[equal] < pivot)
        {
            std::swap(arr[low++], arr[equal++]);
        }
        else if (arr[equal] == pivot)
        {
            ++equal;
        }
        else
        {
            std::swap(arr[--high], arr[equal]);
        }
    }
    for (int i = 0; i < length; i++)
    {
        std::cout << arr[i] << " ";
    }
}