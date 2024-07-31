(ns euler.problems.problem009)

(defn sqr [n]
  (* n n))

(defn ->triple [[m n]]
  [(- (sqr m) (sqr n))
   (* 2 m n)
   (+ (sqr m) (sqr n))])

(defn pythagorean-triples []
  (->> (for [m (iterate inc 2)
             n (range 1 m)]
         [m n])
       (map ->triple)))