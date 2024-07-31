(ns euler.problems.problem009-spec
  (:require [c3kit.apron.corec :as ccc]
            [euler.problems.problem009 :as sut]
            [speclj.core :refer :all]))

(describe "Problem 9"

  (context "enumerates pythagorean triples"

    (it "1"
      (should= [3 4 5]
               (first (sut/pythagorean-triples))))

    (it "2"
      (should= [8 6 10]
               (second (sut/pythagorean-triples))))

    (it "3"
      (should= [5 12 13]
               (nth (sut/pythagorean-triples) 2)))

    (it "4"
      (should= [15 8 17]
               (nth (sut/pythagorean-triples) 3)))

    (it "5"
      (should= [12 16 20]
               (nth (sut/pythagorean-triples) 4)))

    (it "6"
      (should= [7 24 25]
               (nth (sut/pythagorean-triples) 5)))

    (it "solves"
      (should= [375 200 425] (ccc/ffilter #(= 1000 (apply + %))
                   (sut/pythagorean-triples))))))