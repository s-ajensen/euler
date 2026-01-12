#pragma once

#include <span>
#include <algorithm>

inline int sum_multiples_below(int n, const std::span<const int> divisors) {
  int sum{0};
  for (int i = 1; i < n; i++) {
    if (std::ranges::any_of(divisors, [i](int d){ return i % d == 0; })) {
      sum += i;
    }
  }
  return sum;
}
