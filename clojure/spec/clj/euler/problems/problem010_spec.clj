(ns euler.problems.problem010-spec
  (:require [euler.problems.problem010 :as sut]
            [speclj.core :refer :all]))

(describe "Problem 10"

  #_(context "produces primes"

    ;(tags :slow)

    (it "1"
      (should= [2] (take 1 sut/primes)))

    (it "2"
      (should= [2 3] (take 2 sut/primes)))

    (it "3"
      (should= [2 3 5] (take 3 sut/primes)))

    (it "4"
      (should= [2 3 5 7] (take 4 sut/primes)))

    (it "5"
      (should= [2 3 5 7 11] (take 5 sut/primes)))

    ; slow
    #_(it "big"
      (should (doall (take 10000 sut/primes)))))

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