#include <vector>

std::vector<int> applyPermutation(std::vector<int> perm, std::vector<int> *A_ptr);
int main()
{
    std::vector<int> A_ptr = {1, 2, 3, 4, 5, 6};
    std::vector<int> perm = {1, 3, 5, 0, 2, 4};
    std::vector<int> ans = applyPermutation(perm, &A_ptr);
}

std::vector<int> applyPermutation(std::vector<int> perm, std::vector<int> *A_ptr)
{
    std::vector<int> &A = *A_ptr;
    for (int i = 0; i < size(A); i++)
    {
        while (perm[i] != i)
        {
            std::swap(A[perm[i]], A[i]);
            std::swap(perm[i], perm[perm[i]]);
        }
    }
}