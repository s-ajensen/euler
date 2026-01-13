#pragma once
#include <map>

using factorization_t = std::map<uint64_t, uint8_t>;

inline factorization_t factor(uint64_t n) {
  factorization_t factors;

  for (uint32_t m = 2; m <= sqrt(n); ) {
    if (n % m == 0) {
      factors[m]++;
      n /= m;
    } else {
      m++;
    }
  }
  factors[n]++;

  return factors;
}

inline uint64_t euler_3(uint64_t n) {
  return factor(n).rbegin()->first;
}