(ns sicp-clj.fibonacci)

(defn fib-recur [n]
  (cond (zero? n) 0
        (= n 1) 1
        :else (+ (fib-recur (dec n))
                 (fib-recur (- n 2)))))

(defn fib [x]
  (defn fib-iter [a b n]
    (if (zero? n)
      b
      (fib-iter (+ a b) a (dec n))))
  (fib-iter 1 0 x))
