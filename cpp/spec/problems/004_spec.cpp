#include <catch2/catch_test_macros.hpp>

#include "problems/004.hpp"

TEST_CASE("Euler 4") {

  SECTION("detects palindrome") {
    REQUIRE(is_palindrome(101));
    REQUIRE_FALSE(is_palindrome(102));
    REQUIRE(is_palindrome(1234554321));
    REQUIRE(is_palindrome(123454321));
  }

  SECTION("finds largest palindrome product") {
    REQUIRE(9009 == euler_4(2));
    REQUIRE(906609 == euler_4(3));
  }
}