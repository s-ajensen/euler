#include <catch2/catch_test_macros.hpp>
#include "problems/002.hpp"

TEST_CASE("Euler 2") {

  SECTION("sums even fibs") {
    REQUIRE(2 == sum_even_fibs_to(2));
    REQUIRE(10 == sum_even_fibs_to(8));
    REQUIRE(44 == sum_even_fibs_to(34));
    REQUIRE(4613732 == sum_even_fibs_to(4000000));
  }
}