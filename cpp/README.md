# Project Euler (C++)

## Build

```bash
# Configure (run once, or after CMakeLists.txt changes)
cmake -B build

# Build all
cmake --build build

# Build specific target
cmake --build build --target 001
```

## Run

```bash
# Run a problem
./build/001

# Run tests
./build/tests
```

# Catch2 Primer:
```c++
#include <catch2/catch_test_macros.hpp>
#include <vector>
#include <string>

// Basic test case
TEST_CASE("Basic assertions") {
    REQUIRE(1 + 1 == 2);        // Fatal - stops on failure
    CHECK(2 * 2 == 4);          // Non-fatal - continues on failure
}

// Sections let you share setup code
TEST_CASE("Using sections") {
    std::vector<int> v{1, 2, 3};  // Runs before each SECTION

    SECTION("can add elements") {
        v.push_back(4);
        REQUIRE(v.size() == 4);
    }

    SECTION("can remove elements") {
        v.pop_back();
        REQUIRE(v.size() == 2);
    }
}

// Tags for filtering: ./tests [math] or ./tests [slow]
TEST_CASE("Tagged test", "[math][example]") {
    REQUIRE(10 / 2 == 5);
}

// Common matchers
TEST_CASE("Comparison assertions") {
    REQUIRE(5 > 3);
    REQUIRE(3 < 5);
    REQUIRE(5 >= 5);
    REQUIRE(5 <= 5);
    REQUIRE(5 != 3);
}

// Floating point comparison
TEST_CASE("Floating point") {
    double result = 0.1 + 0.2;
    REQUIRE(result == Catch::Approx(0.3));
    REQUIRE(result == Catch::Approx(0.3).epsilon(0.01));  // Custom tolerance
}

// Exception testing
TEST_CASE("Exceptions") {
    REQUIRE_THROWS(throw std::runtime_error("oops"));
    REQUIRE_THROWS_AS(throw std::runtime_error("oops"), std::runtime_error);
    REQUIRE_NOTHROW(1 + 1);
}

// Boolean checks
TEST_CASE("Boolean assertions") {
    REQUIRE_FALSE(1 == 2);
}
```