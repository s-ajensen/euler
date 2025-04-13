(ns euler.problems.problem010-spec
  (:require [euler.problems.problem010 :as sut]
            [speclj.core :refer :all]))

(describe "Problem 10"

  (it "prime?"
    (should (sut/prime? 2))
    (should (sut/prime? 3))
    (should-not (sut/prime? 4))
    (should (sut/prime? 5))
    (should-not (sut/prime? 6))
    (should (sut/prime? 7))
    (should-not (sut/prime? 8))
    (should-not (sut/prime? 9))
    (should (sut/prime? 87178291199)))

  (context "sums primes"

    (it "below 3"
      (should= 2 (sut/sum-primes-below 3)))

    (it "below 5"
      (should= 5 (sut/sum-primes-below 5)))

    (it "below 10"
      (should= 17 (sut/sum-primes-below 10)))

    #_(it "below 2000000"
      (should= 1 (sut/sum-primes-below 2000000))))
  )