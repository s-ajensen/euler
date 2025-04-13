(ns euler.problems.problem010)

(defn prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 7))
(def prime? (memoize prime?))

; ugly as hell and needs to be optimized
(defn sum-primes-below [n]
  (let [primes (loop [primes [] coll (iterate inc 2)]
                 (let [prime (first coll)]
                   (if (<= n prime)
                     primes
                     (let [primes (conj primes prime)]
                       (recur primes
                              (filter prime? (iterate inc (inc (last primes)))))))))]
    (reduce + primes)))