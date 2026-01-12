#pragma once

inline int64_t sum_even_fibs_to(int64_t n) {
  int64_t sum{0};

  int64_t fib0{1};
  int64_t fib1{2};
  while (fib1 <= n) {
    if (fib1 % 2 == 0) {
      sum += fib1;
    }

    const int64_t next = fib0 + fib1;
    fib0 = fib1;
    fib1 = next;
  }

  return sum;
}