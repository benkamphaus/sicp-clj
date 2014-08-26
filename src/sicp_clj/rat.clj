(ns sicp-clj.rat)

;; Data structures are very different in Clojure from earlier Lisps/Scheme.
;; The CONS and CAR/CDR primitives and the CONS pair from SICP Lecture 2B
;; are a first clearly divergent point from Clojure.

(defn gcd [a b]
  (if (zero? b) 
      a
      (gcd b (mod a b))))

(defn make-rat [n d]
  (let [g (gcd n d)]
    (vector (/ n g) (/ d g))))

; similar to car
(defn numer [rat]
  (first rat))

; more idiomatic and performant
(defn denom [rat]
  (second rat))

; more like cadr
(defn denom-cadr [rat]
  (first (rest rat)))

(defn +rat [x y]
  (make-rat
    (+ (* (numer x) (denom y))
       (* (numer y) (denom x)))
    (* (denom x) (denom y))))

(defn *rat [x y]
  (make-rat
    (* (numer x) (numer y))
    (* (denom x) (denom y)))) 
