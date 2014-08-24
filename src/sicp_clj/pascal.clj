(ns sicp-clj.pascal)

(defn pascal-elem [x y]
  (cond (zero? x) 1
        (= x y) 1
        :else (+ (pascal-elem (dec x) (dec y))
                 (pascal-elem x (dec y)))))
