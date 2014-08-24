(ns sicp-clj.newton)

(defn square [x]
  (* x x))

(defn abs [a]
  (if (< a 0) (- a) a))

(defn fixed-point [f start]
  (def tolerance 0.00001)
  (defn close-enough? [u v]
    (< (abs (- u v)) tolerance))
  (defn iter [old new]
    (if (close-enough? old new)
      new
      (iter new (f new))))
  (iter start (f start)))

(defn deriv [f]
  (let [dx 0.00001]
    (fn [x]
      (/ (- (f (+ x dx))
            (f x))
         dx))))

(defn newton [f guess]
  (let [df (deriv f)]
    (fixed-point
      #(- % (/ (f %) (df %)))
      guess)))

(defn sqrt [x]
  (newton #( - x (square %))
          1.0))

(defn cube [x]
  (* x x x))

(defn cube-root [x]
  (newton #(- x (cube %))
          1.0))
