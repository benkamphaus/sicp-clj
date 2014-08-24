(ns sicp-clj.argue)
(require '[clojure.string :refer [split]])

(defn opposite [w]
  (cond (= w 'like) 'hate
        (= w 'hate) 'like
        (= w 'wonderful) 'terrible
        (= w 'terrible) 'wonderful
        (= w 'great) 'awful
        (= w 'awful) 'great
        (= w 'terrific) 'yucky
        (= w 'yucky) 'terrific
        :else w))

(defn argue [s]
  (if (empty? s)
    '()
    (cons (opposite (first s))
          (argue (rest s)))))

(defn argue-string [s]
  (->> (split s #"\s") (into '()) reverse (map symbol) argue))
