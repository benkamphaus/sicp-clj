(ns sicp-clj.set)

; Initial simple case (a set is a vector here rather than car/cdr list)

(defn element-of-set? 
  [x a-set]
  (cond (empty? a-set) false
        (= x (first a-set)) true
        :else (element-of-set? x (rest a-set))))

; demo
(element-of-set? 1 [1 2 3]) ;true
(element-of-set? 4 [1 2 3]) ;false
