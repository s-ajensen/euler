#include <catch2/catch_test_macros.hpp>

#include "problems/003.hpp"

#define ASSERT_PRIME(n) \
  SECTION(#n) { \
    factorization_t factors = factor(n); \
    REQUIRE(factors[n] == 1); \
    REQUIRE(factors.size() == 1); \
  }

TEST_CASE("Euler 3") {

  SECTION("calculates prime factors") {

    SECTION("simple primes") {
      ASSERT_PRIME(2);
      ASSERT_PRIME(3);
      ASSERT_PRIME(11);
      ASSERT_PRIME(4292967373);
    }

    SECTION("simple composites") {

      SECTION("4") {
        factorization_t factors = factor(4);
        REQUIRE(2 == factors[2]);
        REQUIRE(1 == factors.size());
      }

      SECTION("8") {
        factorization_t factors = factor(8);
        REQUIRE(3 == factors[2]);
        REQUIRE(1 == factors.size());
      }

      SECTION("6") {
        factorization_t factors = factor(6);
        REQUIRE(1 == factors[2]);
        REQUIRE(1 == factors[3]);
        REQUIRE(2 == factors.size());
      }

      SECTION("12") {
        factorization_t factors = factor(12);
        REQUIRE(2 == factors[2]);
        REQUIRE(1 == factors[3]);
        REQUIRE(2 == factors.size());
      }
    }

    SECTION("highly composite") {

      SECTION("2520") {
        factorization_t factors = factor(2520);
        REQUIRE(3 == factors[2]);
        REQUIRE(2 == factors[3]);
        REQUIRE(1 == factors[5]);
        REQUIRE(1 == factors[7]);
        REQUIRE(4 == factors.size());
      }

      SECTION("13195") {
        factorization_t factors = factor(13195);
        REQUIRE(1 == factors[5]);
        REQUIRE(1 == factors[7]);
        REQUIRE(1 == factors[13]);
        REQUIRE(1 == factors[29]);
        REQUIRE(4 == factors.size());
      }
    }
  }

  SECTION("Finds largest prime factor") {

    SECTION("13195") {
      REQUIRE(29 == euler_3(13195));
    }

    SECTION("13195") {
      REQUIRE(6857 == euler_3(600851475143));
    }
  }
}