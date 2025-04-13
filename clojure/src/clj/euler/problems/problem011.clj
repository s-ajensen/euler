(ns euler.problems.problem011
  (:require [c3kit.apron.corec :as ccc]
            [c3kit.apron.schema :as schema]
            [clojure.string :as str]))

(defn- parse-line [line]
  (->> (str/split line #" ")
       (mapv schema/->int)))
(defn parse-grid [grid]
  (mapv parse-line (str/split grid #"\n")))

(defn ->product [coll]
  (if (empty? coll)
    [0 []]
    [(apply * coll) coll]))

(defn <-row [cells x y d]
  (let [row (nth cells y)]
    (take d (drop x row))))

(defn <-col [cells x y d]
  (let [col (->> (map #(get % x nil) cells) (filter some?))]
    (take d (drop y col))))

(defn <-diag
  ([direction cells x y d]
   (->> (for [n (range d)]
          (get (get cells (+ y (* direction n)) nil) (+ x n) nil))
        (filter some?)))
  ([cells x y d]
   (<-diag 1 cells x y d)))

(defn <-lines [cells x y d]
  (let [fns [<-row <-col <-diag (partial <-diag -1)]]
    (reduce (fn [lines f] (conj lines (f cells x y d))) [] fns)))

(defn- maybe-not-grid! [grid]
  (when-not (every? #(= (count (first grid)) %) (map count grid))
    (throw (ex-info "'grid' is not a grid" {:grid grid}))))

(defn max-product [grid]
  (maybe-not-grid! grid)
  (->> (for [y (range (count grid))
             x (range (count (first grid)))]
         (map ->product (<-lines grid x y 4)))
       (apply concat)
       (sort-by first >)
       first))