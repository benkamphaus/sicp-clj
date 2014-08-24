(ns sicp-clj.peano)

(defn plus-a [a b]
  (if (= a 0)
    b
    (inc (+ (dec a) b))))

(defn plus-b [a b]
  (if (= a 0)
    b
    (+ (dec a) (inc b))))
