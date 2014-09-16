(ns sicp-clj.deriv-rules)

(defn atom? [x]
  (= 1 (count x)))

(defn constant? [exp var]
  (and (atom? exp)
       (not (= exp var))))

(defn same-var? [exp var]
  (and (atom? exp)
       (= exp var)))

(defn sum? [exp]
  (and (not (atom? exp))
       (= (first exp) (quote +))))

(defn product? [exp]
  (and (not (atom? exp))
       (= (first exp) (quote *))))

(defn make-sum [a1 a2]
  (list (quote +) a1 a2))

(defn make-product [m1 m2]
  (list (quote *) m1 m2))

(defn deriv [exp var]
  (cond (constant? exp var) 0
        (same-var? exp var) 1
        (sum? exp)
          (let [a1 (first (rest exp))
                a2 (first (rest (rest exp)))]
            (make-sum (deriv (a1 exp) var)
                               (deriv (a2 exp) var)))
        (product? exp)
          (let [m1 (first (rest exp))
                m2 (first (rest (rest exp)))]
            (make-sum
              (make-product (m1 exp)
                            (deriv (m2 exp) var))
              (make-product (m2 exp)
                            (deriv (m1 exp) var))))))
