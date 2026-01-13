#pragma once

#include <string>
#include <math.h>
#include <ranges>

inline bool is_palindrome(int n) {
  const std::string s = std::to_string(n);

  for (int i = 0; i <= std::ceil(s.size()) / 2; i++) {
    if (s[i] != s[s.size() - 1 - i]) {
      return false;
    }
  }
  return true;
}

inline int euler_4(int n) {
  const int lo = pow(10, n - 1);
  const int hi = pow(10, n);

  int result = -1;
  for (int i = hi; i > lo; i--) {
    for (int j = hi; j > lo; j--) {
      const int product = i * j;
      if (is_palindrome(product) && product > result) {
        result = product;
      }
    }
  }
  return result;
}