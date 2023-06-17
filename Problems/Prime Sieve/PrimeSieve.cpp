#include <vector>
#include <deque>
#include <iostream>

std::vector<int> generatePrimes(int n);
int main()
{
    std::vector<int> ans = generatePrimes(12000);
    for (int i = 0; i < ans.size(); i++)
    {
        std::cout << ans[i] << " ";
    }
}

std::vector<int> generatePrimes(int n)
{
    std::vector<int> primes;
    std::deque<bool> is_prime(n + 1, true);
    is_prime[0] = is_prime[1] = false;
    for (int p = 2; p <= n; p++)
    {
        if (is_prime[p])
        {
            primes.push_back(p);
            for (int i = p * 2; i <= n; i += p)
            {
                is_prime[i] = false;
            }
        }
    }
    return primes;
}