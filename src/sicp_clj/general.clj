(ns sicp-clj.general)

(defn area [shape r]
  (* shape r r))

(def square 1)
(def circle Math/PI)
(def sphere (* 4 Math/PI))
(def hexagon (* (Math/sqrt 3) 1.5))
