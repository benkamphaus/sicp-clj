(ns sicp-clj.cons-car-cdr
  (:refer-clojure :exclude [cons]))

(defn cons [a b]
  #(cond (= % 1) a (= % 2) b))

(defn car [x] (x 1))

(defn cdr [x] (x 2))
