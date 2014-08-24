(ns sicp-clj.factorial)

(defn factorial-recurse [x]
  (if (= x 1) 
    1
    (* x (factorial-recurse (- x 1)))))

(defn factorial-iter [x]
  (defn fact-iter [product counter max-count]
    (if (> counter max-count)
      product
      (fact-iter (* counter product)
                 (+ counter 1)
                 max-count)))
  (fact-iter 1 1 x))

(defn factorial-iter-clj [x]
  (loop [n x f 1]
    (if (= n 1)
      f
      (recur (dec n) (* f n)))))

(defn factorial-reduce [x]
  (let [natnum (iterate inc 1)]
    (reduce * (take x natnum))))
