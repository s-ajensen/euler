#include <catch2/catch_test_macros.hpp>
#include "problems/001.hpp"

TEST_CASE("Euler 1") {

  SECTION("sums multiples") {
    std::array divisors {3, 5};

    REQUIRE(0 == sum_multiples_below(3, divisors));
    REQUIRE(3 == sum_multiples_below(5, divisors));
    REQUIRE(8 == sum_multiples_below(6, divisors));
    REQUIRE(23 == sum_multiples_below(10, divisors));
    REQUIRE(233168 == sum_multiples_below(1000, divisors));
  }
}