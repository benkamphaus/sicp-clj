(ns sicp-clj.keep)

; duplicates even? - but for illustration...
(defn is-even? [x]
  (zero? (rem x 2)))

(defn evens [nums]
  (cond (empty? nums) 
          '()
        (is-even? (first nums)) 
          (cons (first nums) (evens (rest nums)))
        :else (evens (rest nums))))

; Illustrates recursion and matches teaching example, but of course more
; idiomatically as:
(defn evens-filt [coll]
  (filter even? coll))
