(ns sicp-clj.newton)

(defn abs [x]
  (if (>= x 0) x (- x)))

(defn square [x]
  (* x x))

(defn cube [x]
  (* x x))

(defn average [x y]
  (/ (+ x y) 2))

(defn sqrt [x]
  (defn good-enough? [guess]
    (< (abs (- (square guess) x)) (/ 0.0001 x)))
  (defn improve [guess]
    (average guess (/ x guess)))
  (defn sqrt-iter [guess]
    (if (good-enough? guess)
        guess
        (sqrt-iter (improve guess))))
  (sqrt-iter 1.0))

(defn cube-root [x]
  (defn good-enough? [guess]
    (< (abs (- (cube guess) x)) 0.001))
  (defn improve [guess]
    (/ (+ (* 2 guess) (/ x (square guess))) 3.0))
  (defn cube-rt-iter [guess]
    (if (good-enough? guess)
        guess
        (cube-rt-iter (improve guess))))
  (cube-rt-iter 1.0))
