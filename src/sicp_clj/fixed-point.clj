(ns sicp-clj.fixed-point)

(defn abs [a]
  (if (< a 0) (- a) a))

(defn average [a b]
  (/ (+ a b) 2))

(defn fixed-point [f start]
  (def tolerance 0.00001)
  (defn close-enough? [u v]
    (< (abs (- u v)) tolerance))
  (defn iter [old new]
    (if (close-enough? old new)
      new
      (iter new (f new))))
  (iter start (f start)))

(defn sqrt-fp [x]
  (fixed-point #(average (/ x %) %) 1.0))

; Uses def to lambda function as per Lecture 2A of MIT SICP lectures.
(def average-damp #(fn [x] (average (% x) x)))

(defn sqrt-fp-avgdamp [x]
  (fixed-point (average-damp #(/ x %)) 1))
